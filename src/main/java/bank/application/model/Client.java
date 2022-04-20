package bank.application.model;

import java.util.UUID;

public class Client {

    private final int PHONE_NUMBER_SIZE = 10;

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    private final String emailAddress;
    private final String accountNumbers;

    public Client(UUID id, String firstName, String lastName, String address, String phoneNumber, String emailAddress, String accountNumbers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        if(phoneNumber.length() == PHONE_NUMBER_SIZE)
            this.phoneNumber = phoneNumber;
        else
            this.phoneNumber = null;        this.emailAddress = emailAddress;
        this.accountNumbers = accountNumbers;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAccountNumbers() {
        return accountNumbers;
    }
}
