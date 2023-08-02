package alex.goapiconnector.apiconnector;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import alex.goapiconnector.logic.GameRunner;

@SpringBootApplication
public class GoApiConnectorApplication {

	public static void main(String[] args) {
		// SpringApplication.run(GoApiConnectorApplication.class, args);
		GameRunner gameRunner = new GameRunner(19);
		gameRunner.start();

	}

}
