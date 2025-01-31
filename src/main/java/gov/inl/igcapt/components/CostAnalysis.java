/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gov.inl.igcapt.components;

import edu.uci.ics.jung.graph.Graph;
import gov.inl.igcapt.components.DataModels.SgComponentData;
import gov.inl.igcapt.gdtaf.data.GDTAFScenarioMgr;
import gov.inl.igcapt.graph.GraphManager;
import gov.inl.igcapt.graph.SgEdge;
import gov.inl.igcapt.graph.SgNode;
import gov.inl.igcapt.graph.SgNodeInterface;
import gov.inl.igcapt.view.IGCAPTgui;

import java.util.*;

/**
 *
 * @author fewda
 */
    public class CostAnalysis {

    private Graph<SgNodeInterface, SgEdge> _graph;
    private StringBuilder timestampStr;

    public CostAnalysis(Graph<SgNodeInterface, SgEdge> graph) {
        _graph = graph;
    }

    private ArrayList<SgNodeInterface> sgNodeList = null;

    public void analyze() {

        Date startDate = new Date();
        sgNodeList = new ArrayList<>(_graph.getVertices());
        Map<String, CostAnalysisEntry> m_costReportData = new HashMap<>();
        for (SgNodeInterface sgAbstractNode : sgNodeList) {

            if (sgAbstractNode instanceof SgNode sgNode) {
                SgComponentData componentData = sgNode.getAssociatedComponent();
                if (m_costReportData.containsKey(componentData.getName()) == false) {
                    m_costReportData.put(componentData.getName(), new CostAnalysisEntry(componentData.getName()));
                }
                var entry = m_costReportData.get(componentData.getName());
                entry.addEntry();
                for (var attr : componentData.getAttributes()) {
                    switch (attr.getName()) {
                        case "CAPEX_PROJECTED" -> entry.setCapexProjected(attr.getValue());
                        case "CAPEX_ACTUAL" -> entry.setCapexActual(attr.getValue());
                        case "OPEX_PROJECTED" -> entry.setOpexProjected(attr.getValue());
                        case "OPEX_ACTUAL" -> entry.setOpexActual(attr.getValue());
                        default -> {
                        }
                    }
                }
            }

        }
        
        ArrayList<CostAnalysisEntry> reportData = new ArrayList<>();
        for (var entry: m_costReportData.entrySet()){
            if( entry.getValue().getCapexActualTotal() >= 0 ||
                entry.getValue().getCapexProjectedTotal() >= 0 ||
                entry.getValue().getOpexPerYearActualTotal() >= 0 ||
                entry.getValue().getOpexPerYearProjectedTotal() >= 0){

                reportData.add(entry.getValue());
            }
        }

        Date endDate = new Date();
        timestampStr = new StringBuilder();
        timestampStr.append("Scenario: ");
        timestampStr.append(GDTAFScenarioMgr.getInstance().getActiveScenario().getName());
        timestampStr.append("\nSolution: ");
        timestampStr.append(GDTAFScenarioMgr.getInstance().getActiveSolution().getName());
        timestampStr.append("\nSolution Option: ");
        timestampStr.append(GDTAFScenarioMgr.getInstance().getActiveSolutionOption().getName());
        timestampStr.append("\nAnalysis start time: ");
        timestampStr.append(startDate);
        timestampStr.append("\nAnalysis end time: ");
        timestampStr.append(endDate);
        
        var costAnalysisResults = new CostResultsDialog(IGCAPTgui.getInstance(), false);
        costAnalysisResults.UpdateResults(timestampStr.toString(), reportData);
        costAnalysisResults.setVisible(true);

        GraphManager.getInstance().setAnalysisDirty(false);
        IGCAPTgui.getInstance().refresh();
    }
}
