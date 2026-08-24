package contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        // Initialize a fresh service instance before each test
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact(
                "1",
                "John",
                "Doe",
                "1234567890",
                "123 Main St"
        );

        contactService.addContact(contact);

        assertEquals(contact, contactService.getContact("1"));
    }

    @Test
    public void testAddDuplicateContact() {
        Contact contact1 = new Contact(
                "1",
                "John",
                "Doe",
                "1234567890",
                "123 Main St"
        );

        Contact contact2 = new Contact(
                "1",
                "Jane",
                "Smith",
                "0987654321",
                "456 Elm St"
        );

        contactService.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () ->
                contactService.addContact(contact2)
        );
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact(
                "1",
                "John",
                "Doe",
                "1234567890",
                "123 Main St"
        );

        contactService.addContact(contact);
        contactService.deleteContact("1");

        assertNull(contactService.getContact("1"));
    }

    @Test
    public void testDeleteInvalidContact() {
        assertThrows(IllegalArgumentException.class, () ->
                contactService.deleteContact("999")
        );
    }

    @Test
    public void testUpdateFields() {
        Contact contact = new Contact(
                "1",
                "John",
                "Doe",
                "1234567890",
                "123 Main St"
        );

        contactService.addContact(contact);

        contactService.updateFirstName("1", "Jane");
        assertEquals(
                "Jane",
                contactService.getContact("1").getFirstName()
        );

        contactService.updateLastName("1", "Smith");
        assertEquals(
                "Smith",
                contactService.getContact("1").getLastName()
        );

        contactService.updatePhone("1", "0987654321");
        assertEquals(
                "0987654321",
                contactService.getContact("1").getPhone()
        );

        contactService.updateAddress("1", "456 Elm St");
        assertEquals(
                "456 Elm St",
                contactService.getContact("1").getAddress()
        );
    }

    @Test
    public void testUpdateInvalidContact() {
        assertThrows(IllegalArgumentException.class, () ->
                contactService.updateFirstName("999", "Jane")
        );
    }
}