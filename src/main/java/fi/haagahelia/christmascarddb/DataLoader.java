package fi.haagahelia.christmascarddb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fi.haagahelia.christmascarddb.domain.Contact;
import fi.haagahelia.christmascarddb.repository.ContactRepository;

/**
 * Loads sample contacts into the database when the application starts.
 */
@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(ContactRepository contactRepository) {
        return args -> {
            contactRepository.save(new Contact("Anna", "Korhonen", "Helsinki", true));
            contactRepository.save(new Contact("Matti", "Virtanen", "Espoo", false));
            contactRepository.save(new Contact("Laura", "Laine", "Vantaa", true));
        };
    }
}