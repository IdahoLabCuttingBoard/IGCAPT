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
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GridCommunicationPath complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GridCommunicationPath"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://pnnl.gov/gdtaf-core}BaseBlock"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="equip_node" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="req" type="{http://pnnl.gov/gdtaf-core}guid" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="equip" type="{http://pnnl.gov/gdtaf-core}guid"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Description" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GridCommunicationPath", propOrder = {
    "equipNode"
})
public class GridCommunicationPath
    extends BaseBlock
{

    @XmlElement(name = "equip_node", required = true)
    protected List<GridCommunicationPath.EquipNode> equipNode;
    @XmlAttribute(name = "Description")
    protected String description;

    /**
     * Gets the value of the equipNode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the equipNode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEquipNode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GridCommunicationPath.EquipNode }
     * 
     * 
     */
    public List<GridCommunicationPath.EquipNode> getEquipNode() {
        if (equipNode == null) {
            equipNode = new ArrayList<GridCommunicationPath.EquipNode>();
        }
        return this.equipNode;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="req" type="{http://pnnl.gov/gdtaf-core}guid" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="equip" type="{http://pnnl.gov/gdtaf-core}guid"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "req",
        "equip"
    })
    public static class EquipNode {

        protected List<String> req;
        @XmlElement(required = true)
        protected String equip;

        /**
         * Gets the value of the req property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the req property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReq().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getReq() {
            if (req == null) {
                req = new ArrayList<String>();
            }
            return this.req;
        }

        /**
         * Gets the value of the equip property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEquip() {
            return equip;
        }

        /**
         * Sets the value of the equip property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEquip(String value) {
            this.equip = value;
        }

    }

}
