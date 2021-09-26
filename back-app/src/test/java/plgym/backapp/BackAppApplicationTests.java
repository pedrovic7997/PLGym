package plgym.backapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import plgym.BackAppController;


@SpringBootTest
class BackAppApplicationTests {

	BackAppController backAppController = new BackAppController();

	@Test
	void contextLoads() {
		Assertions.assertNotEquals(backAppController.printAll(), "");
	}

}
