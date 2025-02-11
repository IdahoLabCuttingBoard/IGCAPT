package gov.inl.igcapt.gdtaf.data;

import gov.inl.igcapt.gdtaf.model.GDTAF;
import gov.inl.igcapt.gdtaf.model.Equipment;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

/**
 * EquipmentRepoMgr is a manager/accessor class for GTDAF
 * Equipment Repository data.  Data is stored in a map keyed
 * on equipment uuid.  The EquipmentRepoMgr class must be initialized
 * once the GDTAF Scenario has been loaded into memory
 */
public class EquipmentRepoMgr {

    private static final EquipmentRepoMgr instance = new EquipmentRepoMgr();
    private Map<String, Equipment> m_equipMap = new HashMap<String, Equipment>();

    private EquipmentRepoMgr() {

    }

    /**
     * EquipmentRepoMgr singleton accessor method
     *
     * @return EquipmentRepoMgr
     */
    public static EquipmentRepoMgr getInstance() {
        return instance;
    }

    /**
     * intitialize the class with data from the GDTAF Scenario
     * must be called before use
     *
     * @param gdtaf
     */
    public void initRepo(gov.inl.igcapt.gdtaf.model.GDTAF gdtaf) {
        resetRepo();
        var equipList = gdtaf.getEquipmentRepo().getEquipment();
        for (var equip : equipList) {
            m_equipMap.put(equip.getUUID(), equip);
        }
    }

    private void resetRepo() {
        m_equipMap.clear();
    }

    /**
     * getter to return equipment object from the map
     *
     * @param uuid
     * @return Equipment
     */
    public Equipment getEquip(String uuid) {
        return m_equipMap.get(uuid);
    }

    public Collection<Equipment> getAllEquip() {
        return m_equipMap.values();
    }

    /**
     * Number of elements in the Repo
     *
     * @return int
     */
    public int count() {
        return m_equipMap.size();
    }

    /**
     * this is a utility to get a list of equipment derived from a particular UUID
     * This is handy when trying to associate a Operational Objective Source/Dest ID
     * to a SolutionAsset.  The Source/Dest will be the parameter uuid and the return list
     * of uuids will be things to search for as AssetSolution->Eqiupment
     *
     * @param uuid
     * @return
     */
    public List<String> getEquipmentDerivedFrom(String uuid) {
        List<String> derivedFromList = new ArrayList<String>();
        for (var equip : m_equipMap.values()) {
            for (var der : equip.getDerivedFrom()) {
                if (der.equals(uuid)) {
                    derivedFromList.add(equip.getUUID());
                }
            }
        }
        return derivedFromList;
    }

    /**
     * helper function to associate the GDTAF Equipment Name to
     * a IGCAPT Component UUID
     *
     * @param uuid
     * @return
     */
    public String getICAPTComponentUUID(String uuid) {
        /// TODO It would be better to generate a sqlite call to find the UUID and return that.

        switch (getEquip(uuid).getName()) {
            case "Capacitor Bank":
                return "3822d4ce-a0e0-4900-a2e1-1692cb942b32";
            case "Recloser":
                return "abea3785-fb38-497e-863d-1858dd269633";
            case "Field Sensor":
                return "40062231-7e2a-4423-87ea-0e212a83a1a2";
            case "Regulator":
                return "5738def5-f279-44a6-a3c7-b04325b6ff9e";
            case "Switch":
                return "71e87e52-b32f-4ca4-9db3-6dd071204154";
            case "EnergyConsumerPhase":
                return "3f40e7be-d5ac-4b8e-845f-bc38f7bd5938";
            case "EnergyConsumer":
                return "eefab4fc-a62b-4b97-8142-f8d3d089c370";
            case "DMS":
                return "49b20f30-cde6-4850-bf26-cb36e5d3ffa3";
            case "Y-Corp Cellular Gateway":
            case "X-Corp Cellular Gateway":
                return "6d03b93f-a693-44ad-a023-c3076029bf24";
            case "X-Corp Mesh Range Extender":
            case "Y-Corp Mesh Range Extender":
                return "16634386-e364-41cf-a3dc-e6641e25b3e8";
            case "X-Corp Mesh Node":
            case "Y-Corp Mesh Node":
                return "be8672a3-fb13-4144-970a-fc717ab2c07a";
            case "Y-Corp Cellular Node":
            case "X-Corp Cellular Node":
                return "9d07a4b1-816c-4177-8a3e-4be275a4d631";
            case "X-Corp Mesh Router":
            case "Y-Corp Mesh Router":
                return "894f4ea9-cfaa-4d9a-8b98-e048ca53ecb5";
            case "X-Corp NMS":
            case "Y-Corp NMS":
                return "caf557d2-1cab-48f0-8f2f-89edacb97138";
            case "Distribution Automation Feeder Device":
                return "eeaa2f6a-3cb4-4f01-807e-f9848ef108f9";
            case "TransformerTank":
                return "6e265d80-6854-47e6-ae0d-9b41b9872876";
            case "LoadBreakSwitch":
                return "3ab66c08-4a6c-4a66-b342-f8c673a9be19";
            case "ACLineSegment":
                return "326e8150-9ac7-465b-a0dd-a6c09b79041d";
            case "TapChangerControl":
                return "40b0623a-b4eb-499a-8f6d-c9d73d4353d1";
            case "RatioTapChanger":
                return "29daa518-07bf-4ba9-9cb9-eb0ceedb04c5";
            case "PowerTransformer":
                return "838f5ed5-b09f-4b8d-8cd9-b2e35b1f39c3";
            case "LinearShuntCompensator":
                return "3fb6c6a1-4b6e-43ad-8d0e-9ec9f7ceacd3";
            case "LinearShuntCompensatorPhase":
                return "1e05de30-ec16-4f46-bd4a-66fdf8cda18b";
            case "SwitchPhase":
                return "7e12dc56-2879-4867-91f9-a4fdc70225b0";
            case "EnergySource":
                return "cdd8b540-fc53-4295-b6be-97f125d4879a";
            case "Feeder":
                return "acb86d4f-1c02-4434-92e0-368e41879a18";
            case "Distribution":
                return "29ece96d-8641-446e-aee2-d983580dac43";
            case "PowerElectronicsConnection":
                return "9a8b0787-21f5-440c-af94-bfca70b0cd80";
            case "PowerElectronicsConnectionPhase":
                return "35f65649-2578-4a15-a2b4-5c1fad61f848";
            case "Breaker":
                return "2f96c46c-10ff-4914-8a20-beec51511e74";
            case "Public Carrier eNodeB":
                return "06905227-2b74-497b-806a-9413c661ef0a";
            case "PhotovoltaicUnit":
                return "f93458a7-5fbd-4647-9952-5639c7d17644";
            case "Fuse":
                return "d66fe77e-99f0-4270-ae35-139037fa382a";
            case "BatteryUnit":
                return "3988b3c7-cff5-4eda-b8e1-267c664c09a6";
            case "Substation":
                return "fd37c5da-5f16-46c3-8998-6980d3473a4d";
            default:
                // UUID for Unknown
                System.out.println("Unknown Asset Mapping: " + getEquip(uuid).getName());
                return "4cf6265d-b575-4de7-a2e1-2b794809fbbd";
        }
    }

    public int getProjectedCapex(String equipUUID) {
        var equipment = getEquip(equipUUID);
        var attrList = equipment.getConstrainingAttribute();
        for (var attr : attrList) {
            if (attr.getType().name().equals("COST_FACTORS")) {
                var jsonString = attr.getValue();
                JSONArray jsonArray = new JSONArray(jsonString);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    if(obj.getString("stage").equals("projected")) {
                        var capexObj = (JSONObject) obj.get("capex");
                        var fixedObj = (JSONObject) capexObj.get("fixed");
                        var valueObj = fixedObj.getInt("value");
                        return valueObj;
                    }
                }
            }
        }
        return -1;
    }

    public int getActualCapex(String equipUUID){
        var equipment = getEquip(equipUUID);
        var attrList = equipment.getConstrainingAttribute();
        for (var attr : attrList) {
            if (attr.getType().name().equals("COST_FACTORS")) {
                var jsonString = attr.getValue();
                JSONArray jsonArray = new JSONArray(jsonString);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    if(obj.getString("stage").equals("actual")) {
                        var capexObj = (JSONObject) obj.get("capex");
                        var fixedObj = (JSONObject) capexObj.get("fixed");
                        var valueObj = fixedObj.getInt("value");
                        return valueObj;
                    }
                }
            }
        }
        return -1;
    }

    public int getProjectedOpexPerYear(String equipUUID){
        int opexValue = -1;
        int everyValue = 1;
        int conversion = 1;
        String everyUnits = "year";

        var equipment = getEquip(equipUUID);
        var attrList = equipment.getConstrainingAttribute();
        for (var attr : attrList) {
            if (attr.getType().name().equals("COST_FACTORS")) {
                var jsonString = attr.getValue();
                JSONArray jsonArray = new JSONArray(jsonString);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    if(obj.getString("stage").equals("projected")) {
                        var opexArray = (JSONArray) obj.get("opex");
                        for(int j = 0; j < opexArray.length(); j++){
                            JSONObject opexObj = opexArray.getJSONObject(j);
                            if(opexObj.getString("type").equals("maintenance")){
                                JSONObject fixedObj = opexObj.getJSONObject("fixed");
                                JSONObject everyObj = opexObj.getJSONObject("every");
                                opexValue = fixedObj.getInt("value");
                                everyValue = everyObj.getInt("value");
                                everyUnits = everyObj.getString("units");
                            }
                        }
                    }
                }
            }
        }
        switch(everyUnits){
            case "year":
                conversion = 1;
                break;
            case "month":
                conversion  = 12;
                break;
            case "day":
                conversion = 365;
                break;
            case "hour":
                conversion = 365*24;
                break;
            default:
                conversion = 1;
                break;
        }

        return (opexValue * conversion) / everyValue;
    }

    public int getActualOpexPerYear(String equipUUID){
        int opexValue = -1;
        int everyValue = 1;
        int conversion = 1;
        String everyUnits = "year";

        var equipment = getEquip(equipUUID);
        var attrList = equipment.getConstrainingAttribute();
        for (var attr : attrList) {
            if (attr.getType().name().equals("COST_FACTORS")) {
                var jsonString = attr.getValue();
                JSONArray jsonArray = new JSONArray(jsonString);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    if(obj.getString("stage").equals("actual")) {
                        var opexArray = (JSONArray) obj.get("opex");
                        for(int j = 0; j < opexArray.length(); j++){
                            JSONObject opexObj = opexArray.getJSONObject(j);
                            if(opexObj.getString("type").equals("maintenance")){
                                JSONObject fixedObj = opexObj.getJSONObject("fixed");
                                JSONObject everyObj = opexObj.getJSONObject("every");
                                opexValue = fixedObj.getInt("value");
                                everyValue = everyObj.getInt("value");
                                everyUnits = everyObj.getString("units");
                            }
                        }
                    }
                }
            }
        }
        switch(everyUnits){
            case "year":
                conversion = 1;
                break;
            case "month":
                conversion  = 12;
                break;
            case "day":
                conversion = 365;
                break;
            case "hour":
                conversion = 365*24;
                break;
            default:
                conversion = 1;
                break;
        }

        return (opexValue * conversion) / everyValue;
    }
}