package CourseworkWorkAutoParts.controller;


import CourseworkWorkAutoParts.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/clients")
public interface ClientController {

    @GetMapping
    ResponseEntity<List<Client>> getAllClients();

    @GetMapping("/{id}")
    ResponseEntity<Client> getClientById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<Client> createClient(@RequestBody Client client);

    @PutMapping("/{id}")
    ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteClient(@PathVariable Long id);

   @GetMapping("/ClientByCriteria")
    ResponseEntity<List<Client>> getClientByCriteria() {
    List<Client> client = clientService.getClientByCriteria (1, 3);
    client.addAll(ClientInRange);
    return ResponseEntity.ok(client);
}

    
}
