//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.30 at 02:04:59 PM MST 
//


package gov.inl.igcapt.gdtaf.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PayloadAttributeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="PayloadAttributeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CIA_RISK_VALUE"/&gt;
 *     &lt;enumeration value="INTEGRITY"/&gt;
 *     &lt;enumeration value="NISTIR_7628_LOGICAL_INTERFACE_CATEGORIES"/&gt;
 *     &lt;enumeration value="AVAILABIITY"/&gt;
 *     &lt;enumeration value="CONFIDENTIALITY"/&gt;
 *     &lt;enumeration value="TYPE"/&gt;
 *     &lt;enumeration value="STATIC_PAYLOAD_SIZE"/&gt;
 *     &lt;enumeration value="DESCRIPTION"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PayloadAttributeType")
@XmlEnum
public enum PayloadAttributeType {

    CIA_RISK_VALUE,
    INTEGRITY,
    NISTIR_7628_LOGICAL_INTERFACE_CATEGORIES,
    AVAILABIITY,
    CONFIDENTIALITY,
    TYPE,
    STATIC_PAYLOAD_SIZE,
    DESCRIPTION;

    public String value() {
        return name();
    }

    public static PayloadAttributeType fromValue(String v) {
        return valueOf(v);
    }

}
