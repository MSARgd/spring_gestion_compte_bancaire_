package ma.enset.springgestioncomptebancaire.repository;

import ma.enset.springgestioncomptebancaire.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte,Long> {

}
