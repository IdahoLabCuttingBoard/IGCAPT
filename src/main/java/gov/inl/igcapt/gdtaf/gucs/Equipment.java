//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.30 at 02:05:01 PM MST 
//


package gov.inl.igcapt.gdtaf.gucs;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Equipment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Equipment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://pnnl.gov/gdtaf-core}BaseBlock"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ConstrainingAttribute" type="{http://pnnl.gov/gdtaf-core}ConstrainingAttribute" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="PossibleRole" type="{http://pnnl.gov/gdtaf-core}EquipmentRole" maxOccurs="unbounded"/&gt;
 *         &lt;element name="PossibleZone" type="{http://pnnl.gov/gdtaf-core}CommunicationZone" maxOccurs="unbounded"/&gt;
 *         &lt;element name="Icon" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="possible_children" type="{http://pnnl.gov/gdtaf-core}guid" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="possible_parents" type="{http://pnnl.gov/gdtaf-core}guid" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="possible_peers" type="{http://pnnl.gov/gdtaf-core}guid" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="derived_from" type="{http://pnnl.gov/gdtaf-core}guid" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="available_data" type="{http://pnnl.gov/gdtaf-core}guid" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Description" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Type" use="required" type="{http://pnnl.gov/gdtaf-core}EquipmentType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Equipment", namespace = "http://pnnl.gov/gdtaf-core", propOrder = {
    "constrainingAttribute",
    "possibleRole",
    "possibleZone",
    "icon",
    "possibleChildren",
    "possibleParents",
    "possiblePeers",
    "derivedFrom",
    "availableData"
})
public class Equipment
    extends BaseBlock
{

    @XmlElement(name = "ConstrainingAttribute")
    protected List<ConstrainingAttribute> constrainingAttribute;
    @XmlElement(name = "PossibleRole", required = true)
    @XmlSchemaType(name = "string")
    protected List<EquipmentRole> possibleRole;
    @XmlElement(name = "PossibleZone", required = true)
    @XmlSchemaType(name = "string")
    protected List<CommunicationZone> possibleZone;
    @XmlElement(name = "Icon")
    protected byte[] icon;
    @XmlElement(name = "possible_children")
    protected List<String> possibleChildren;
    @XmlElement(name = "possible_parents")
    protected List<String> possibleParents;
    @XmlElement(name = "possible_peers")
    protected List<String> possiblePeers;
    @XmlElement(name = "derived_from")
    protected List<String> derivedFrom;
    @XmlElement(name = "available_data")
    protected List<String> availableData;
    @XmlAttribute(name = "Description", required = true)
    protected String description;
    @XmlAttribute(name = "Type", required = true)
    protected EquipmentType type;

    /**
     * Gets the value of the constrainingAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the constrainingAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConstrainingAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConstrainingAttribute }
     * 
     * 
     */
    public List<ConstrainingAttribute> getConstrainingAttribute() {
        if (constrainingAttribute == null) {
            constrainingAttribute = new ArrayList<ConstrainingAttribute>();
        }
        return this.constrainingAttribute;
    }

    /**
     * Gets the value of the possibleRole property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the possibleRole property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPossibleRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EquipmentRole }
     * 
     * 
     */
    public List<EquipmentRole> getPossibleRole() {
        if (possibleRole == null) {
            possibleRole = new ArrayList<EquipmentRole>();
        }
        return this.possibleRole;
    }

    /**
     * Gets the value of the possibleZone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the possibleZone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPossibleZone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommunicationZone }
     * 
     * 
     */
    public List<CommunicationZone> getPossibleZone() {
        if (possibleZone == null) {
            possibleZone = new ArrayList<CommunicationZone>();
        }
        return this.possibleZone;
    }

    /**
     * Gets the value of the icon property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getIcon() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setIcon(byte[] value) {
        this.icon = value;
    }

    /**
     * Gets the value of the possibleChildren property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the possibleChildren property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPossibleChildren().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPossibleChildren() {
        if (possibleChildren == null) {
            possibleChildren = new ArrayList<String>();
        }
        return this.possibleChildren;
    }

    /**
     * Gets the value of the possibleParents property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the possibleParents property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPossibleParents().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPossibleParents() {
        if (possibleParents == null) {
            possibleParents = new ArrayList<String>();
        }
        return this.possibleParents;
    }

    /**
     * Gets the value of the possiblePeers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the possiblePeers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPossiblePeers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPossiblePeers() {
        if (possiblePeers == null) {
            possiblePeers = new ArrayList<String>();
        }
        return this.possiblePeers;
    }

    /**
     * Gets the value of the derivedFrom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the derivedFrom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDerivedFrom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDerivedFrom() {
        if (derivedFrom == null) {
            derivedFrom = new ArrayList<String>();
        }
        return this.derivedFrom;
    }

    /**
     * Gets the value of the availableData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the availableData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailableData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAvailableData() {
        if (availableData == null) {
            availableData = new ArrayList<String>();
        }
        return this.availableData;
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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link EquipmentType }
     *     
     */
    public EquipmentType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link EquipmentType }
     *     
     */
    public void setType(EquipmentType value) {
        this.type = value;
    }

}
