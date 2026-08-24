package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // In-memory data structure to store contacts
    private Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException(
                    "Contact object cannot be null.");
        }

        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException(
                    "A contact with this ID already exists.");
        }

        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                    "Invalid contactId or contact does not exist.");
        }

        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        getContactOrThrow(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        getContactOrThrow(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        getContactOrThrow(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        getContactOrThrow(contactId).setAddress(address);
    }

    // Helper method to retrieve a contact or throw an exception if not found
    private Contact getContactOrThrow(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                    "Invalid contactId or contact does not exist.");
        }

        return contacts.get(contactId);
    }

    // Helper method to retrieve a contact (useful for verifying tests)
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}