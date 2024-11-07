package com.develhope.bookstore.controllers;

import com.develhope.bookstore.entities.Client;
import com.develhope.bookstore.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("client")
public class ClientController {
    // parameters
    @Autowired
    private ClientService clientService;

    /**
     * POST mapping
     */
    @PostMapping("/new-client")
    public ResponseEntity<Client> create(@RequestBody Client client){
        return ResponseEntity.ok(clientService.create(client));
    }

    /**
     * GET mapping by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Client> getByActiveId(@PathVariable Long id){
        Optional<Client> clientOptional = clientService.readById(id);
        return clientOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
     }

    /**
     * GET mapping
     */
    @GetMapping("/client-catalog")
   public ResponseEntity<List<Client>> getAll() {
        return ResponseEntity.ok(clientService.readAll());
    }
    /**
     * PUT mapping
     */
    @PutMapping("/{id}")
   public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client){
        Optional<Client> clientOptional = clientService.update(id,client);
        return clientOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    /**
     * DELETE mapping
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok(clientService.eliminationLogic(id));
    }



}
