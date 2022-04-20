package bank.application.dao;

import bank.application.model.Client;

import java.util.UUID;

public interface ClientDao {

    int insertClient(UUID id, Client client);


    default int insertClient(Client client) {
        UUID id = UUID.randomUUID();

        return insertClient(id, client);
    }
}
