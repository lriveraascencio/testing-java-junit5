package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexControllerTest {
	
	IndexController controller;

	@BeforeEach
	void setUp() throws Exception {
		controller = new IndexController();
	}

	@DisplayName("Test Proper view name is returned for index page")
	@Test
	void testIndex() {
		assertEquals("index", controller.index());
		assertEquals("index", controller.index(), "Wrong View Returned");
		assertEquals("index", controller.index(), "Another expensive Message" + "Make me only if you have to");
	}

	@Test
	@DisplayName("Test Exception")
	void testOupsHandler() {
		assertThrows(ValueNotFoundException.class, () -> {
			controller.oupsHandler();
		});
		//assertTrue("notimplemented".equals(controller.oupsHandler()),"this is some expensive " + "Message to build" + "for my test");
	}
	
	@Disabled
	@Test
	void testTimeOut() {
		assertTimeout(Duration.ofMillis(100), () -> {
			Thread.sleep(5000);
			System.out.println("I got here");
		});
	}
	
	@Disabled
	@Test
	void testTimeOutPrempt() {
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
			Thread.sleep(5000);
			System.out.println("I got acahere");
		});
	}
	
	@Test
	void testAssumptionTrue() {
		assumeTrue("GURU".equalsIgnoreCase("GURU_RUNTIME"));
	}
	
	@Test
	void testAssumptionTrueAssumptionIsTrue() {
		assumeTrue("GURU".equalsIgnoreCase("GURU"));
	}
	
	

}
