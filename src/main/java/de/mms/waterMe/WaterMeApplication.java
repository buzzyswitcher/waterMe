package de.mms.waterMe;

import de.mms.waterMe.database.repository.IrrigationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import de.mms.waterMe.services.Plants.PlantService;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableJpaRepositories("de.mms.waterMe")
public class WaterMeApplication {
	public static void main(String... args) {
		SpringApplication.run(WaterMeApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
