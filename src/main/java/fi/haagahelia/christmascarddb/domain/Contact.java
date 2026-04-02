package fi.haagahelia.christmascarddb.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class for storing Christmas card contact information.
 */
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String city;
    private boolean cardSent;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String city, boolean cardSent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.cardSent = cardSent;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isCardSent() {
        return cardSent;
    }

    public void setCardSent(boolean cardSent) {
        this.cardSent = cardSent;
    }
}