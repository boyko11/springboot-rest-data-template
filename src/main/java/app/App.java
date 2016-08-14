package app;

import app.model.Donkey;
import app.repositories.DonkeyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Bean
    public CommandLineRunner demo(DonkeyRepository donkeyRepository) {

        return (args) -> {

            // save a bunch of Donkeys
            donkeyRepository.save(new Donkey("Sera", 1, "SuperCool"));
            donkeyRepository.save(new Donkey("Jack", 1, "Angry"));
            donkeyRepository.save(new Donkey("Josh", 2, "SuperAngry"));
            donkeyRepository.save(new Donkey("Abby", 3, "Mellow"));
            donkeyRepository.save(new Donkey("Jason", 2, "SuperMellow"));
            donkeyRepository.save(new Donkey("Amber", 7, "TooMellow"));
            donkeyRepository.save(new Donkey("Jack", 3, "Cool"));

            donkeyRepository.save(new Donkey("Jack", 1, "Angry"));
            donkeyRepository.save(new Donkey("Jack", 1, "Angry"));
            donkeyRepository.save(new Donkey("Jack", 1, "Angry"));

            log.info("Saved a bunch of donkeys");

        };
    }

}