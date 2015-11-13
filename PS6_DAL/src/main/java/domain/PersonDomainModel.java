package domain;

import java.util.Date;
import java.util.UUID;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import util.LocalDateAdapter;

public class PersonDomainModel {

	private String firstName;
	private String lastName;
	private String street;
	private Integer postalCode;
	private String city;
	private Date birthday;
	private UUID PersonID;

	/**
	 * Default constructor.
	 */
	
	  public PersonDomainModel()
	    {
	    	this.PersonID = UUID.randomUUID();
	    	this.postalCode = 0;
	    }

	public PersonDomainModel(String FirstName, String LastName, String Street,
			Integer PostalCode, String City, Date Birthday) {
		super();
		firstName = FirstName;
		lastName = LastName;
		street = Street;
		postalCode = PostalCode;
		city = City;
		birthday = Birthday;
		
		
	}  
    public void setPersonID(UUID personID) {
		PersonID = personID;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public UUID getPersonID()
    {
    	return this.PersonID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName =firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street=street;
    }



    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode=postalCode;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city=city;
    }



    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday=birthday;
    }


}