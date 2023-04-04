package ma.enset.springgestioncomptebancaire.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.springgestioncomptebancaire.entity.enumes.TypeCompte;

import java.util.Date;
@Entity
@Data @NoArgsConstructor  @AllArgsConstructor @Builder
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @Enumerated(EnumType.STRING)
    private TypeCompte typeCompte;
    private Date createdAt;
    private Date updatedAt;
    private Date endValidity;
    private Boolean isActive;
    private String accountNumber;
    private Double solde;
}