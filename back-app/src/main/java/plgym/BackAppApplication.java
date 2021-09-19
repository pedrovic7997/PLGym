package plgym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class BackAppApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(BackAppApplication.class, args);
	}
}
