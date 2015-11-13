package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class Person_Test {
//add test, update test, delete test
private static PersonDomainModel Julia;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		Date dDate = null;
		try {
			dDate = new SimpleDateFormat("yyyy-MM-dd").parse("1960-12-01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Julia = new PersonDomainModel();
		Julia.setFirstName("Julia");
		Julia.setLastName("George");
		Julia.setBirthday(dDate);
		Julia.setCity("Jackson");
		Julia.setPostalCode(19010);
		Julia.setStreet("14 Seahorse Street");
	}



	@After
	public void tearDown() throws Exception {
		PersonDomainModel per;	
		PersonDAL.deletePerson(Julia.getPersonID());
		per = PersonDAL.getPerson(Julia.getPersonID());
		assertNull("This person does not belong in the database",per);		
	}
	
	
	
	@Test
	public void UpdatePersonTest()
	{		
		PersonDomainModel per;
		final String C_LASTNAME = "Jules";
		
		per = PersonDAL.getPerson(Julia.getPersonID());		
		assertNull("This person does not belong in the database",per);		
		PersonDAL.addPerson(Julia);	
		
		Julia.setLastName(C_LASTNAME);
		PersonDAL.updatePerson(Julia);
		
		per = PersonDAL.getPerson(Julia.getPersonID());

		assertTrue("Name Didn't Change",Julia.getLastName() == C_LASTNAME);
	}

	@Test
	public void DeletePersonTest()
	{		
		PersonDomainModel per;		
		per = PersonDAL.getPerson(Julia.getPersonID());		
		assertNull("This person does not belong in the database",per);	
		
		PersonDAL.addPerson(Julia);			
		per = PersonDAL.getPerson(Julia.getPersonID());
		System.out.println(Julia.getPersonID() + " found");
		assertNotNull("This person does not belong in the database",per);
		
		PersonDAL.deletePerson(Julia.getPersonID());
		per = PersonDAL.getPerson(Julia.getPersonID());		
		assertNull("This person does not belong in the database",per);	
		
	}
	
	@Test
	public void AddPersonTest()
	{		
		PersonDomainModel per;		
		per = PersonDAL.getPerson(Julia.getPersonID());		
		assertNull("This person does not belong in the database",per);		
		PersonDAL.addPerson(Julia);	
		
		per = PersonDAL.getPerson(Julia.getPersonID());
		System.out.println(Julia.getPersonID() + " found");
		assertNotNull("This person should be in the database",per);
	}
	

}
