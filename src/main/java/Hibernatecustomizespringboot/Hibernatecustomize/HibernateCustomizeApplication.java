package Hibernatecustomizespringboot.Hibernatecustomize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class HibernateCustomizeApplication extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCustomizeApplication.class, args);
	}

}
