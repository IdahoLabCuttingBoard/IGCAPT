//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.30 at 02:04:59 PM MST 
//


package gov.inl.igcapt.gdtaf.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataElement"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://pnnl.gov/gdtaf-core}BaseBlock"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SourceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Time" type="{http://pnnl.gov/gdtaf-core}TimeContractType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Description" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Group" use="required" type="{http://pnnl.gov/gdtaf-core}DataGroup" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataElement", namespace = "http://pnnl.gov/gdtaf-core", propOrder = {
    "sourceID",
    "time"
})
public class DataElement
    extends BaseBlock
{

    @XmlElement(name = "SourceID", namespace = "http://pnnl.gov/gdtaf-core")
    protected String sourceID;
    @XmlElement(name = "Time", namespace = "http://pnnl.gov/gdtaf-core")
    protected TimeContractType time;
    @XmlAttribute(name = "Description", required = true)
    protected String description;
    @XmlAttribute(name = "Group", required = true)
    protected DataGroup group;

    /**
     * Gets the value of the sourceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceID() {
        return sourceID;
    }

    /**
     * Sets the value of the sourceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceID(String value) {
        this.sourceID = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link TimeContractType }
     *     
     */
    public TimeContractType getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeContractType }
     *     
     */
    public void setTime(TimeContractType value) {
        this.time = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link DataGroup }
     *     
     */
    public DataGroup getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataGroup }
     *     
     */
    public void setGroup(DataGroup value) {
        this.group = value;
    }

}
