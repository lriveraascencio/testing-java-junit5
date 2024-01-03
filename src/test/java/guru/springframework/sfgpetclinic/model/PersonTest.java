package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void groupedAssertions() {
		//given
		Person person = new Person(1l,"Joe", "Buck");
		
		//then
		assertAll("Test Props Set", 
				() -> assertEquals(person.getFirstName(), "Joe"),
				() -> assertEquals(person.getLastName(), "Buck"));
	}
	
	@Test
	void groupedAssertionMsgs() {
		//given
		Person person = new Person(1l,"Joe", "Buck");
		
		//then
		assertAll("Test Props Set", 
				() -> assertEquals(person.getFirstName(), "Jowe", "First name failed"),
				() -> assertEquals(person.getLastName(), "Buck", "last name failed"));
	}

}
