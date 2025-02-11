package gov.inl.igcapt.gdtaf.data;

import gov.inl.igcapt.gdtaf.model.OperationalAttributeType;
import gov.inl.igcapt.gdtaf.model.OperationalObjective;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * OperationalObjectivRepoMgr is a manager/accessor class for GTDAF
 * Operational Objective Repository data.  Data is stored in a map keyed
 * on uuid.  The OperationalObjectivRepoMgr class must be initialized
 * once the GDTAF Scenario has been loaded into memory
 */

public class OperationalObjectiveRepoMgr {

    private Map<String, OperationalObjective> m_opobj_map = new HashMap<String, OperationalObjective>();
    private static final OperationalObjectiveRepoMgr instance = new OperationalObjectiveRepoMgr();
    private OperationalObjectiveRepoMgr(){

    }

    /**
     * hook to the Singleton class
     * @return OperationalObjectiveRepoMgr
     */
    public static OperationalObjectiveRepoMgr getInstance(){
        return instance;
    }

    /**
     * initializes the class with  data from the GDTAF scenario
     * Must be called before use.
     * @param gdtaf
     */
    public void initRepo(gov.inl.igcapt.gdtaf.model.GDTAF gdtaf){
        resetRepo();
        var ooList = gdtaf.getOperationalObjectiveRepo().getOperationalObjective();
        for(var oo : ooList){
            m_opobj_map.put(oo.getUUID(), oo);
        }
    }

    private void resetRepo(){
        m_opobj_map.clear();
    }

    /**
     * getter for an OperationalObjective object
     * @param uuid
     * @return OperationalObjective
     */
    public OperationalObjective getOperationalObjective(String uuid){
        return m_opobj_map.get(uuid);
    }


    /**
     * getter for Latency in Seconds.  GDTAF provides a json string as the
     * application_latency value... this method takes that string and parses
     * into a JSONObject and returns the value converted to seconds if the units
     * are not seconds
     * @param ooUuid
     * @return
     */
    public int getOpObjLatencySec(String ooUuid){
        var oo = m_opobj_map.get(ooUuid);
        for(var attr:oo.getAttributes()){
            if(attr.getType()== OperationalAttributeType.APPLICATION_LATENCY){
                String jsonstring = attr.getValue();
                String escaped =  escapeHTML(jsonstring);
                JSONArray jsonArray = new JSONArray(jsonstring);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject arrayObj = jsonArray.getJSONObject(i);
                    int value = arrayObj.getInt("value");
                    String units = arrayObj.getString("units");
                    switch (units){
                        case "second":
                            return value;
                        case "hour":
                            return value * 3600;
                        case "minute":
                            return value *  60;
                        default:
                            return value;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * number of Operational Objectives stored
     * @return int
     */
    public int count(){return m_opobj_map.size();}

    public static String escapeHTML(String str) {
        return str.codePoints().mapToObj(c -> c > 127 || "\"'<>&".indexOf(c) != -1 ?
                        "&#" + c + ";" : new String(Character.toChars(c)))
                .collect(Collectors.joining());
    }

}
