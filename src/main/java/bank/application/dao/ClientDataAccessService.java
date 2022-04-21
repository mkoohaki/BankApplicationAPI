package bank.application.dao;

import bank.application.model.Client;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class ClientDataAccessService implements ClientDao {

    private final JdbcTemplate jdbcTemplate;

    public ClientDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertClient(UUID id, Client client) {
        return 0;
    }

    @Override
    public List<Client> selectAllClients() {
        final String sql = "SELECT * FROM client";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String address = resultSet.getString("address");
            String phoneNumber = resultSet.getString("phoneNumber");
            String emailAddress = resultSet.getString("emailAddress");
            String accountNumbers = resultSet.getString("accountNumbers");
            return new Client( id,firstName, lastName, address, phoneNumber, emailAddress, accountNumbers);
        });
    }

    @Override
    public Optional<Client> selectClientById(UUID id) {
        final String sql = "SELECT * FROM client WHERE id = ?";

        Client client = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            UUID clientId = UUID.fromString(resultSet.getString("id"));
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String address = resultSet.getString("address");
            String phoneNumber = resultSet.getString("phoneNumber");
            String emailAddress = resultSet.getString("emailAddress");
            String accountNumbers = resultSet.getString("accountNumbers");
//            ArrayList<String> accountNumbers = new ArrayList<>();
//            accountNumbers.add(resultSet.getString("accountNumbers"));
            return new Client( clientId,firstName, lastName, address, phoneNumber, emailAddress, accountNumbers);
        });
        return Optional.ofNullable(client);
    }

    @RequestMapping("/delete")
    @Override
    public int deleteClientById(UUID id) {
        final String sql = "DELETE FROM client WHERE id = ?";

        Optional<Client> clientMaybe = selectClientById(id);
        if(clientMaybe.isEmpty())
            return 0;
        int rowAffected = jdbcTemplate.update(sql, id);
        return rowAffected;
    }

    @Override
    public int updateClientById(UUID id, Client client) {
        final String sql = "UPDATE client set firstName = ?, lastName = ?, address = ?, phoneNumber = ?, " +
                " emailAddress = ?, accountNumbers = ? WHERE id = ?";
        Optional<Client> clientMaybe = selectClientById(id);
        if(clientMaybe.isEmpty())
            return 0;
        int rowAffected = jdbcTemplate.update(sql, client.getFirstName(), client.getLastName(), client.getAddress(),
                client.getPhoneNumber(), client.getEmailAddress(), client.getAccountNumbers(), id);
        return rowAffected;
    }
}
