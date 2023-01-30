//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.30 at 02:04:58 PM MST 
//


package gov.inl.igcapt.gdtaf.core;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EquipmentRole.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="EquipmentRole"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ROLE_UNKNOWN"/&gt;
 *     &lt;enumeration value="ROLE_ENDPOINT"/&gt;
 *     &lt;enumeration value="ROLE_REPEATER"/&gt;
 *     &lt;enumeration value="ROLE_TAKEOUT"/&gt;
 *     &lt;enumeration value="ROLE_HEADEND"/&gt;
 *     &lt;enumeration value="ROLE_STORE_AND_FORWARD"/&gt;
 *     &lt;enumeration value="ROLE_ROUTER"/&gt;
 *     &lt;enumeration value="ROLE_SWITCH"/&gt;
 *     &lt;enumeration value="ROLE_FIREWALL"/&gt;
 *     &lt;enumeration value="ROLE_BATTERY_BACKUP"/&gt;
 *     &lt;enumeration value="ROLE_COMMS_LINK"/&gt;
 *     &lt;enumeration value="ROLE_TOWER"/&gt;
 *     &lt;enumeration value="ROLE_SUBSTATION"/&gt;
 *     &lt;enumeration value="ROLE_CONTAINER"/&gt;
 *     &lt;enumeration value="ROLE_CONDUCTOR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EquipmentRole")
@XmlEnum
public enum EquipmentRole {

    ROLE_UNKNOWN,
    ROLE_ENDPOINT,
    ROLE_REPEATER,
    ROLE_TAKEOUT,
    ROLE_HEADEND,
    ROLE_STORE_AND_FORWARD,
    ROLE_ROUTER,
    ROLE_SWITCH,
    ROLE_FIREWALL,
    ROLE_BATTERY_BACKUP,
    ROLE_COMMS_LINK,
    ROLE_TOWER,
    ROLE_SUBSTATION,
    ROLE_CONTAINER,
    ROLE_CONDUCTOR;

    public String value() {
        return name();
    }

    public static EquipmentRole fromValue(String v) {
        return valueOf(v);
    }

}
