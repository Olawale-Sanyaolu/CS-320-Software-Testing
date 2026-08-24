package contact;

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName,
                   String phone, String address) {
        // Validate all fields upon creation
        validateContactId(contactId);
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // --- Getters ---
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // --- Setters (with validation) ---
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    // --- Validation Helper Methods ---
    private void validateContactId(String contactId) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException(
                    "Invalid contactId: Must not be null and cannot exceed 10 characters.");
        }
    }

    private void validateFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException(
                    "Invalid firstName: Must not be null and cannot exceed 10 characters.");
        }
    }

    private void validateLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException(
                    "Invalid lastName: Must not be null and cannot exceed 10 characters.");
        }
    }

    private void validatePhone(String phone) {
        // Checks for null, exact length of 10, and ensures all characters are digits
        if (phone == null || phone.length() != 10
                || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                    "Invalid phone: Must not be null and must be exactly 10 digits.");
        }
    }

    private void validateAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException(
                    "Invalid address: Must not be null and cannot exceed 30 characters.");
        }
    }
}