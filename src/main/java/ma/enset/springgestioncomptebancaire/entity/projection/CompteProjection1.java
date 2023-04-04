package ma.enset.springgestioncomptebancaire.entity.projection;

import ma.enset.springgestioncomptebancaire.entity.Compte;
import ma.enset.springgestioncomptebancaire.entity.enumes.TypeCompte;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "projection1",types = Compte.class)
public interface CompteProjection1 {
   public Long getId();
   public TypeCompte getTypeCompte();

}