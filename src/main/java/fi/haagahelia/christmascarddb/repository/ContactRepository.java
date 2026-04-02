package fi.haagahelia.christmascarddb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.christmascarddb.domain.Contact;

/**
 * Repository for Contact database operations.
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findByLastNameContainingIgnoreCase(String lastName);
}