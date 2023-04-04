package ma.enset.springgestioncomptebancaire.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.springgestioncomptebancaire.entity.enumes.TypeCompte;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompteRequestDTO {
    private TypeCompte typeCompte;
    private Double balance;
    private String currency;
}