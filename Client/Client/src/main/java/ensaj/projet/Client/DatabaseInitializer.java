package ensaj.projet.Client;

import ensaj.projet.Client.entities.Client;
import ensaj.projet.Client.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseInitializer {

    @Bean
    public CommandLineRunner initialiserBaseH2(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new Client(Long.parseLong("1"), " SELIMANI","Rabab", Float.parseFloat("23")));
            clientRepository.save(new Client(Long.parseLong("2"), "Amal"," RAMI",Float.parseFloat("22")));
            clientRepository.save(new Client(Long.parseLong("3"), " SAFI","Samir", Float.parseFloat("22")));
            clientRepository.save(new Client(Long.parseLong("4"), " Zrayouil","Karima", Float.parseFloat("20")));
        };
    }
}
