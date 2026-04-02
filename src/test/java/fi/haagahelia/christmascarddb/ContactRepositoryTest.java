package fi.haagahelia.christmascarddb;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fi.haagahelia.christmascarddb.domain.Contact;
import fi.haagahelia.christmascarddb.repository.ContactRepository;

@DataJpaTest
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    void shouldFindByLastName() {
        contactRepository.save(new Contact("Test", "Smith", "Helsinki", false));

        List<Contact> contacts = contactRepository.findByLastNameContainingIgnoreCase("Smith");

        assertThat(contacts).hasSize(1);
        assertThat(contacts.get(0).getFirstName()).isEqualTo("Test");
    }

    @Test
    void shouldSaveContact() {
        Contact contact = new Contact("Anna", "Brown", "Espoo", true);
        contactRepository.save(contact);

        assertThat(contact.getId()).isNotNull();
    }
}