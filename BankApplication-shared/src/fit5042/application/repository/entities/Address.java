package fit5042.application.repository.entities;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Address class to keep record of address details
 * @author yashkhandha
 */

//Adding annotations for Composition mapping
@Embeddable
@Access(AccessType.PROPERTY)
public class Address implements Serializable {
    
    //for storing street number
    @Column(name = "street_number")
    private String streetNumber;
    //for storing street address
    @Column(name = "street_name")
    private String streetName;
    //for storing suburb
    @Column(name="suburb")
    private String suburb;
    //for storing postcode
    @Column(name = "postcode")
    private String postcode;
    //for storing state
    @Column(name="state")
    private String state;

    //default constructor
    public Address() {
    }

    //parametrized constructor
    public Address(String streetNumber, String streetAddress, String suburb, String postcode, String state) {
        this.streetNumber = streetNumber;
        this.streetName = streetAddress;
        this.suburb = suburb;
        this.postcode = postcode;
        this.state = state;
    }

    //accessors and mutators for accessing attributes
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //to string method to display attributes
    @Override
    public String toString() {
        return streetNumber + " " + streetName + ", " + suburb + ", " + state + " " + postcode;
    }
    
}
