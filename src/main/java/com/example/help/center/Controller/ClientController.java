package com.example.help.center.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.help.center.Service.ClientService;
import com.example.help.center.entity.Client;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(@PathVariable Long companyId) {
        return ResponseEntity.ok(clientService.getAllClientsByCompany(companyId));
    }

    @PostMapping
    public ResponseEntity<String> createClient(@RequestBody Client client) {
        clientService.addClient(client);
        return ResponseEntity.ok("Client created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@PathVariable Long id, @RequestBody Client client) {
        client.setId(id);
        clientService.updateClient(client);
        return ResponseEntity.ok("Client updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok("Client deleted successfully");
    }
}
