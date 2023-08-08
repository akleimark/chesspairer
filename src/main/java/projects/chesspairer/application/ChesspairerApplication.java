package projects.chesspairer.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "projects.chesspairer")
@EnableJpaRepositories("projects.chesspairer")
@EntityScan("projects.chesspairer")

/**
 * It is through this class, the spring boot application will run.
 */
public class ChesspairerApplication
{	
	/**
	 * 
	 * This is the main function, the heart of the spring boot application.
	 */
	public static void main(String[] args)
	{
		SpringApplication.run(ChesspairerApplication.class, args);
	}	
}
