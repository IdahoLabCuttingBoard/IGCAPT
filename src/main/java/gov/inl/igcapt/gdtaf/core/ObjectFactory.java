//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.30 at 02:04:58 PM MST 
//


package gov.inl.igcapt.gdtaf.core;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.inl.igcapt.gdtaf.core package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.inl.igcapt.gdtaf.core
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BaseBlock }
     * 
     */
    public BaseBlock createBaseBlock() {
        return new BaseBlock();
    }

    /**
     * Create an instance of {@link Equipment }
     * 
     */
    public Equipment createEquipment() {
        return new Equipment();
    }

    /**
     * Create an instance of {@link ConstrainingAttribute }
     * 
     */
    public ConstrainingAttribute createConstrainingAttribute() {
        return new ConstrainingAttribute();
    }

    /**
     * Create an instance of {@link GeoLocation }
     * 
     */
    public GeoLocation createGeoLocation() {
        return new GeoLocation();
    }

    /**
     * Create an instance of {@link DataElement }
     * 
     */
    public DataElement createDataElement() {
        return new DataElement();
    }

    /**
     * Create an instance of {@link TimeContractType }
     * 
     */
    public TimeContractType createTimeContractType() {
        return new TimeContractType();
    }

}
