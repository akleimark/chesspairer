package projects.chesspairer.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "projects.chesspairer")
@EnableJpaRepositories("projects.chesspairer")
@EntityScan("projects.chesspairer")

public class ChesspairerApplication
{	
	public static void main(String[] args)
	{
		SpringApplication.run(ChesspairerApplication.class, args);
	}	
}
