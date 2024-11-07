package com.develhope.bookstore.services;

import com.develhope.bookstore.entities.Client;
import com.develhope.bookstore.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    // parameters
    @Autowired
    private ClientRepository clientRepository;

    //CRUD methods

    /**
     * create
     */
    public Client create(Client newClient){
        return clientRepository.save(newClient);
    }

    /**
     * read by active id
     */
    public Optional<Client> readById(Long id){
        return clientRepository.findByActiveId(id);
    }

    /**
     * read all
     */
    public List<Client> readAll(){
        return clientRepository.findAllActiveIds();
    }

    /**
     * update by active id
     */
    public Optional<Client> update(Long id, Client client){
        Optional<Client> clientOptional = clientRepository.findByActiveId(id);
        if (clientOptional.isPresent()){
            Client updateClient = clientOptional.get();
            updateClient.setName(client.getName());
            updateClient.setAge(client.getAge());
            updateClient.setAddress(client.getAddress());
            updateClient.setReview(client.getReview());
            updateClient.setActive(client.isActive());
            updateClient.setEmail(client.getEmail());
            updateClient.setPassword(client.getPassword());
            return Optional.of(clientRepository.save(updateClient));
        } else {
            return Optional.empty();
        }

    }

    /**
     * elimination logic
     */
    public String eliminationLogic(Long id){
        Optional<Client> clientOptional = clientRepository.findByActiveId(id);
        if (clientOptional.isPresent()){
            clientRepository.eliminationLogic(id);
            return "the Account was successfully eliminated";
        } else {
            return "There was an error";
        }
    }
}
