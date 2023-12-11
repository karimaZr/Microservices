package ensaj.projet.Client.controllers;

import ensaj.projet.Client.entities.Client;
import ensaj.projet.Client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientControllers {
    @Autowired
    private ClientRepository clientRepository;
    @GetMapping("/clients")
    public List<Client> finAll(){
        return clientRepository.findAll();
    }
    @GetMapping("/client/{id}")
    public  Client findById(@PathVariable Long id) throws Exception{
        return this.clientRepository.findById(id).orElseThrow(()->new
                Exception("Client inexistant"));
    }

}
