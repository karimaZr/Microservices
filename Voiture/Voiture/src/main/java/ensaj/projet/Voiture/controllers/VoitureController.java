package ensaj.projet.Voiture.controllers;

import ensaj.projet.Voiture.ClientService;
import ensaj.projet.Voiture.entities.Client;
import ensaj.projet.Voiture.entities.Voiture;
import ensaj.projet.Voiture.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoitureController {

    @Autowired
 VoitureRepository voitureRepository;


        @Autowired
        ClientService clientService ;
    @GetMapping(value = "/voitures", produces = {"application/json"})
public ResponseEntity<Object> findAll() {
         try {
            List<Voiture> voitures = voitureRepository.findAll();
             return ResponseEntity.ok(voitures);
             } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
             .body("Error fetching voitures: " + e.getMessage());
             }
         }

         @GetMapping("/voitures/{Id}")
 public ResponseEntity<Object> findById(@PathVariable Long Id) {
         try {
             Voiture voiture = voitureRepository.findById(Id)
             .orElseThrow(() -> new Exception("Voiture Introuvable"));

             // Fetch the client details using the clientService
             voiture.setClient(clientService.clientById(voiture.getId_client()));

             return ResponseEntity.ok(voiture);
             } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
             .body("Voiture not found with ID: " + Id);
             }
         }




         @PutMapping("/voitures/{Id}")
 public ResponseEntity<Object> update(@PathVariable Long Id, @RequestBody
    Voiture updatedVoiture) {
        try {
             Voiture existingVoiture = voitureRepository.findById(Id)
             .orElseThrow(() -> new Exception("Voiture not found with ID: "
                    + Id));

             // Update only the non-null fields from the request body
             if (updatedVoiture.getMatricule() != null &&
                    !updatedVoiture.getMatricule().isEmpty()) {
                 existingVoiture.setMatricule(updatedVoiture.getMatricule());
                 }

             if (updatedVoiture.getMarque() != null &&
                    !updatedVoiture.getMarque().isEmpty()) {
                 existingVoiture.setMarque(updatedVoiture.getMarque());
                 }

             if (updatedVoiture.getModel() != null &&
                    !updatedVoiture.getModel().isEmpty()) {
                 existingVoiture.setModel(updatedVoiture.getModel());
                 }


             // Save the updated Voiture
             Voiture savedVoiture = voitureRepository.save(existingVoiture);

             return ResponseEntity.ok(savedVoiture);

             } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
             .body("Error updating voiture: " + e.getMessage());
             }
        }

        }