package bank.application.api;

import bank.application.model.Client;
import bank.application.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/client")
@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public void addClient( @NonNull @RequestBody Client client){ clientService.addClient(client); }

    @GetMapping
    public List<Client> getAllClients() { return clientService.getAllClients(); }

    @GetMapping(path = "{id}")
    public Client getClientById(@PathVariable("id") UUID id) {
        return clientService.getClientById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteClientById(@PathVariable("id") UUID id) {
        clientService.deleteClient(id);
    }

    @PutMapping(path = "{id}")
    public void updateClient(@PathVariable("id") UUID id, @RequestBody Client clientToUpdate) {
        clientService.updateClient(id, clientToUpdate);
    }
}
