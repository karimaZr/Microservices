package ensaj.projet.Voiture;

import ensaj.projet.Voiture.entities.Client;
import ensaj.projet.Voiture.entities.Voiture;
import ensaj.projet.Voiture.repositories.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseInitializer {

    @Bean
    public CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository,ClientService clientService) {
        return args -> {
            Client c1 = clientService.clientById(Long.parseLong("2"));
             Client c2 = clientService.clientById(Long.parseLong("1"));
             System.out.println("**************************");
             System.out.println("Id est :" + c2.getId());
             System.out.println("Nom est :" + c2.getNom());
             System.out.println("**************************");
             System.out.println("**************************");
             System.out.println("Id est :" + c1.getId());
             System.out.println("Nom est :" + c1.getNom());
             System.out.println("Age est :" + c1.getAge());
             System.out.println("**************************");
             voitureRepository.save(new Voiture(Long.parseLong("1"), "Toyota", "A25 333", "Corolla", Long.parseLong("2"), c2));
            voitureRepository.save(new Voiture(Long.parseLong("2"), "Renault",
                    "B 6 3456", "Megane", Long.parseLong("1"), c2));
            voitureRepository.save(new Voiture(Long.parseLong("3"), "Peugeot",
                    "A 55 4444", "301", Long.parseLong("2"), c1));
             };
         }

}
