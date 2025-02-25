package guru.springframework.sfgpetclinic.model;



import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OwnerTest {

	@Test
	void dependentAssertions() {
		Owner owner = new Owner(1l, "Joe", "Buck");
		owner.setCity("Key West");
		owner.setTelephone("1231231234");
		
		assertAll("Properties Test",
				() -> assertAll("Person Properties",
						() -> assertEquals("Joe", owner.getFirstName(), "First Name did not Match"),
						() -> assertEquals("Buck", owner.getLastName())),
				() -> assertAll("Owner Properties",
						() -> assertEquals("Key West", owner.getCity(), "City Did not Match"),
						() -> assertEquals("1231231234", owner.getTelephone())
				));
		
		//assertThat(owner.getCity(), is("Key West"));
		
	}
	

}
