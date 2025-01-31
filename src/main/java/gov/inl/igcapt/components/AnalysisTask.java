/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gov.inl.igcapt.components;

import edu.uci.ics.jung.algorithms.shortestpath.ShortestPathUtils;
import edu.uci.ics.jung.algorithms.shortestpath.UnweightedShortestPath;
import edu.uci.ics.jung.graph.Graph;
import gov.inl.igcapt.gdtaf.data.GDTAFScenarioMgr;
import gov.inl.igcapt.graph.GraphManager;
import gov.inl.igcapt.graph.SgEdge;
import gov.inl.igcapt.graph.SgNode;
import gov.inl.igcapt.graph.SgNodeInterface;
import gov.inl.igcapt.properties.IGCAPTproperties;
import gov.inl.igcapt.properties.IGCAPTproperties.IgcaptProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.SwingWorker;
import gov.inl.igcapt.view.IGCAPTgui;
import java.util.stream.Collectors;

/**
 *
 * @author FRAZJD
 */
    public class AnalysisTask extends SwingWorker<String, Integer> {

        private Graph<SgNodeInterface, SgEdge> _graph;
        private static volatile boolean _running = true;

        public AnalysisTask(Graph<SgNodeInterface, SgEdge> graph) {
            _graph = graph;
        }

        public void terminate() {
            _running = false;
        }

        @Override
        protected String doInBackground() {
            return analyze(_graph);
        }

        private ArrayList<SgNodeInterface> sgNodeList = null;
        private ArrayList<SgEdge> sgEdgeList = null;

        String analyze(Graph graph) {

            String returnval = null;
            
            List<gov.inl.igcapt.components.Pair<SgNode, SgNode>> analyzeList = new ArrayList<>();

            Date startDate = new Date();

            // reset utilization
            IGCAPTgui.getInstance().clearEdgeUtilization();
            
            // Clear list of data flows to be analyzed
            analyzeList.clear();

            // start and end points
            List<List<Integer>> paths;
            StringBuilder analysisResults = new StringBuilder();

            // Build list of data flows to be analyzed
            sgNodeList = new ArrayList<>(graph.getVertices());
            sgEdgeList = new ArrayList<>(graph.getEdges());
            
            List<SgNodeInterface> result = sgNodeList.stream()
                    .filter(item -> item.getName().contains("Wide"))
                    .collect(Collectors.toList());
            
            int i = 0;

            firePropertyChange("status", "old", "Compiling endpoint pair list.");
            for (SgNodeInterface sgAbstractNode : sgNodeList) {

                if (!_running) {
                    return null;
                }

                // Only take 50% of our progress in this phase.  Take the rest below.
                setProgress(50 * i++ / sgNodeList.size());

                // If there is data to send and sending is enabled, generate the list
                // of start/end nodes for which the paths will be generated.
                if (sgAbstractNode instanceof SgNode sgNode) {
                    if (sgNode.getDataToSend() > 0 && sgNode.getEnableDataSending()) {
                        for (int endPointId : sgNode.getEndPointList()) {
                            SgNodeInterface endPointNode = GraphManager.getInstance().getNode(sgNodeList, endPointId);

                            if (endPointNode != null && endPointId != sgNode.getId()) {
                                if (sgNode.getDataToSend() > 0.0) {
                                    gov.inl.igcapt.components.Pair<SgNode, SgNode> innerList = new gov.inl.igcapt.components.Pair<>(sgNode, (SgNode)endPointNode);
                                    analyzeList.add(innerList);
                                }
                            }
                        }
                    }
                }
            }

            if (_running) {
                i = 0;
                firePropertyChange("status", "old", "Determing paths for each endpoint pair.");
                for (gov.inl.igcapt.components.Pair<SgNode, SgNode> pair : analyzeList) {

                    if (!_running) {
                        return null;
                    }
                    setProgress(50 + 50 * i++ / analyzeList.size());

                    paths = getNewNodePaths(graph, pair.first, pair.second, true);

                    double ackPayload = Double.parseDouble(IGCAPTproperties.getInstance().getPropertyKeyValue(IgcaptProperty.ACK_SIZE));
                    
                    var graphManager = GraphManager.getInstance();

                    for (List<Integer> sublist : paths) {
                        for (Integer value : sublist) {
                            
                            if (!_running) {
                                return null;
                            }
                            
                            SgEdge sgEdge = graphManager.getEdge(sgEdgeList, value);
                            
                            SgNodeInterface sgAbstractNode = pair.first;

                            if (sgAbstractNode instanceof SgNode sgNode) {
                                
                                int protocolOverhead = sgEdge.getFixedOverhead() + (int)(sgNode.getDataToSend()*sgEdge.getMultiplierOverhead());
                                double protocolOverheadRate = sgNode.computeRate(sgNode.getMaxLatency(), protocolOverhead);
                                
                                sgEdge.setCalcTransRate(sgEdge.getCalcTransRate() + sgNode.getComputedRate() + protocolOverheadRate);
                            }
                        }

                        if (_running) {
                            // Reverse communication flow for ACK
                            for (int j = sublist.size() - 1; j >= 0; j--) {
                                
                                if (!_running) {
                                    return null;
                                }
                                
                                SgEdge sgEdge = GraphManager.getInstance().getEdge(sgEdgeList, sublist.get(j));
                                SgNode sgSrcNode = pair.first;

                                // This is an ACK coming back from the destination.  Use the timing from the
                                // source and a fixed ACK payload as specified in the properties file.
                                double ackUtilization = ackPayload * 8.0 / sgSrcNode.getMaxLatency() / 1000;
                                sgEdge.setCalcTransRate(sgEdge.getCalcTransRate() + ackUtilization);
                            }
                        }
                    }
                }
            }

            if (_running) {
                Date endDate = new Date();

                analysisResults.append("Scenario: ");
                analysisResults.append(GDTAFScenarioMgr.getInstance().getActiveScenario().getName());
                analysisResults.append("\nSolution: ");
                analysisResults.append(GDTAFScenarioMgr.getInstance().getActiveSolution().getName());
                analysisResults.append("\nSolution Option: ");
                analysisResults.append(GDTAFScenarioMgr.getInstance().getActiveSolutionOption().getName());
                analysisResults.append("\nAnalysis start time: ");
                analysisResults.append(startDate.toString());
                analysisResults.append("\nAnalysis end time: ");
                analysisResults.append(endDate.toString());

                returnval = analysisResults.toString();
                GraphManager.getInstance().setAnalysisDirty(false);
           
                IGCAPTgui.getInstance().refresh();
            }

             return returnval;
        }
        
        public static List<List<Integer>> getNewNodePaths(Graph graph, SgNode fromNode, SgNode toNode, boolean isSender) {
           
            List<List<Integer>> returnval = new ArrayList<>();
            
            UnweightedShortestPath uwsp = new UnweightedShortestPath(GraphManager.getInstance().getOriginalGraph());
            //var result = uwsp.getDistance(fromNode, toNode);
            
            var spl = ShortestPathUtils.getPath(GraphManager.getInstance().getOriginalGraph(), uwsp, fromNode, toNode);
 
            List<Integer> edgeList = new ArrayList<>();

            for (var element : spl) {
                edgeList.add(((SgEdge)element).getId());
            }
            
            returnval.add(edgeList);
            
            return returnval;
        }

        public static List<List<Integer>> getNodePaths(Graph graph, SgNode fromNode, SgNode toNode, boolean isSender) {
            List<List<Integer>> returnval = new ArrayList<>();
            
            //System.out.println("From: " + fromNode.getName() + " To: " + toNode.getName());
            SgNode currentNode;
            
            if (!_running) {
                return null;
            }

            SgNodeInterface fromSgAbstractNode = fromNode;
            SgNodeInterface toSgAbstractNode = toNode;

            if (fromSgAbstractNode instanceof SgNode && toSgAbstractNode instanceof SgNode) {

                SgNode fromSgNode = (SgNode) fromSgAbstractNode;
                SgNode toSgNode = (SgNode) toSgAbstractNode;

                currentNode = fromSgNode;
                currentNode.setUsed(true);         // Prevent a node from being looped back on

                // Can only terminate at the destination, regardless of whether there is an intermediate node
                // that is not transmitting. We only want complete paths that start at the from node and end at the to node.
                if (fromNode == toNode) {
                    ArrayList<Integer> x = new ArrayList<>();
                    returnval.add(x);
                } else {// if (isSender) {
                    // Cycle through all connected components

                    // Get list of connected edges.
                    List<SgEdge> sgEdges = new ArrayList<>(graph.getIncidentEdges(fromSgNode));

                    for (SgEdge sgEdge : sgEdges) {
                        
                        if (!_running) {
                            return null;
                        }
                        
                        if (sgEdge.isEnabled()) {
                            SgNode nextComponent = null;

                            edu.uci.ics.jung.graph.util.Pair<SgNodeInterface> endpoints = graph.getEndpoints(sgEdge);

                            if (endpoints.getFirst() instanceof SgNode endPt1 && endpoints.getSecond() instanceof SgNode endPt2) {

                                if (endPt1 != null && endPt2 != null) {
                                    if (!endPt1.getUsed()) {
                                        nextComponent = endPt1;
                                    } else if (!endPt2.getUsed()) {
                                        nextComponent = endPt2;
                                    }
                                }
                            }   

                            if (nextComponent != null) {
                                List<List<Integer>> returnPaths = getNodePaths(graph, nextComponent, toSgNode, false);

                                // We received a path, add our current edge to the head of each list and return it.
                                if (returnPaths != null && !returnPaths.isEmpty()) {
                                    for (List<Integer> path : returnPaths) {
                                        path.add(0, sgEdge.getId());
                                    }
                                    returnval.addAll(0, returnPaths);
                                    break; // Stop after first path found.
                                }
                            }
                        }
                    }
                }
                currentNode.setUsed(false); // Return it to the pool, just need to make sure it does not loop back downstream
            }
            return returnval;
        }
    }