package alex.goapiconnector.apiconnector;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import alex.goapiconnector.logic.GameController;
import alex.goapiconnector.ui.TextInterface;

@SpringBootApplication
public class GoApiConnectorApplication {

	public static void main(String[] args) {
		// SpringApplication.run(GoApiConnectorApplication.class, args);
		TextInterface ui = new TextInterface(new GameController(19));
		while (true) {
			ui.requestMove();
		}

	}

}
