package bank.application.dao;

import bank.application.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeClientDao")
public class ClientFakeDataAccessService implements  ClientDao {

    private static List<Client> DBC = new ArrayList<>();

    @Override
    public int insertClient(UUID id, Client client) {

        DBC.add(new Client(id, client.getFirstName(), client.getLastName(), client.getAddress(),
                client.getPhoneNumber(), client.getEmailAddress(), client.getAccountNumbers()));
        return 1;
    }
}
