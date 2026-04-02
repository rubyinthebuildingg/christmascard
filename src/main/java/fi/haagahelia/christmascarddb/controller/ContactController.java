package fi.haagahelia.christmascarddb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fi.haagahelia.christmascarddb.domain.Contact;
import fi.haagahelia.christmascarddb.repository.ContactRepository;

/**
 * Controller for handling contact-related web requests.
 */
@Controller
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    /**
     * Shows the main page with all contacts.
     */
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        return "contactlist";
    }

    /**
     * Opens the form for adding a new contact.
     */
    @GetMapping("/add")
    public String addContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "addcontact";
    }

    /**
     * Saves a new contact to the database.
     */
    @PostMapping("/save")
    public String saveContact(Contact contact) {
        contactRepository.save(contact);
        return "redirect:/";
    }

    /**
     * Deletes a contact by id.
     */
    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id") Long id) {
        contactRepository.deleteById(id);
        return "redirect:/";
    }

    /**
     * Opens the edit form for a selected contact.
     */
    @GetMapping("/edit/{id}")
    public String editContact(@PathVariable("id") Long id, Model model) {
        model.addAttribute("contact", contactRepository.findById(id).orElseThrow());
        return "editcontact";
    }

    /**
     * Updates an existing contact.
     */
    @PostMapping("/update")
    public String updateContact(Contact contact) {
        contactRepository.save(contact);
        return "redirect:/";
    }

    /**
     * Searches contacts by last name.
     */
    @GetMapping("/search")
    public String searchContacts(@RequestParam("keyword") String keyword, Model model) {
        if (keyword == null || keyword.trim().isEmpty()) {
            model.addAttribute("contacts", contactRepository.findAll());
        } else {
            model.addAttribute("contacts", contactRepository.findByLastNameContainingIgnoreCase(keyword));
        }
        return "contactlist";
    }
}