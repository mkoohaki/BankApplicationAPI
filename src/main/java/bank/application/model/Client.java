package bank.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Client {

    private final int PHONE_NUMBER_SIZE = 10;

    private final UUID id;
    @NotBlank
    private final String firstName;
    @NotBlank
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    @NotBlank
    private final String emailAddress;
    @NotBlank
    private final String accountNumbers;

    public Client(@JsonProperty("id") UUID id,
                  @JsonProperty("firstName") String firstName,
                  @JsonProperty("lastName") String lastName,
                  @JsonProperty("address") String address,
                  @JsonProperty("phoneNumber") String phoneNumber,
                  @JsonProperty("emailAddress") String emailAddress,
                  @JsonProperty("accountNumbers") String accountNumbers) {
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
