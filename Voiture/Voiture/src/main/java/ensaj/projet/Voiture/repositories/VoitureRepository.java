package ensaj.projet.Voiture.repositories;

import ensaj.projet.Voiture.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture,Long> {
}
