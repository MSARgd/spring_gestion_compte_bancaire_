package ma.enset.springgestioncomptebancaire.repository;

import ma.enset.springgestioncomptebancaire.entity.Compte;
import ma.enset.springgestioncomptebancaire.entity.enumes.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CompteRepository1 extends JpaRepository<Compte,Long> {
        @RestResource(path = "byType")
        public List<Compte>  findCompteByTypeCompte(@Param("type") TypeCompte typeCompte);

}
