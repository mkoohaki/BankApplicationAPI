package bank.application.dao;

import bank.application.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeClientDao")
public class ClientFakeDataAccessService implements ClientDao {

    private static List<Client> DBC = new ArrayList<>();

    @Override
    public int insertClient(UUID id, Client client) {

        DBC.add(new Client(id, client.getFirstName(), client.getLastName(), client.getAddress(),
                client.getPhoneNumber(), client.getEmailAddress(), client.getAccountNumbers()));
        return 1;
    }

    @Override
    public List<Client> selectAllClients() {
        return DBC;
    }

    @Override
    public Optional<Client> selectClientById(UUID id) {

        return DBC.stream().filter(client -> client.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteClientById(UUID id) {

        Optional<Client> clientMaybe = selectClientById(id);
        if(clientMaybe.isEmpty())
            return 0;
        DBC.remove(clientMaybe.get());
        return 1;
    }

    @Override
    public int updateClientById(UUID id, Client update) {
        return selectClientById(id).map(client -> {
            int indexOfClientToUpdate = DBC.indexOf(client);
            if(indexOfClientToUpdate >= 0){
                DBC.set(indexOfClientToUpdate, new Client(id, update.getFirstName(), update.getLastName(), update.getAddress(),
                        update.getPhoneNumber(), update.getEmailAddress(), update.getAccountNumbers()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
