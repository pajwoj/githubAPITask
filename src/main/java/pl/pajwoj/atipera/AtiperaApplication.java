package pl.pajwoj.atipera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AtiperaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AtiperaApplication.class, args);
		while(true) {}
	}
}
