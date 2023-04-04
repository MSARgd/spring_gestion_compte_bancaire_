package ma.enset.springgestioncomptebancaire.repository;

import ma.enset.springgestioncomptebancaire.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
public interface CompteRepository extends JpaRepository<Compte,Long> {
    Compte findCompteByUserId(Long id);
    @Query("select c from Compte c where c.isActive= :x")
    List<Compte> searchCompteByStatus(@Param("x") Boolean b);

}
