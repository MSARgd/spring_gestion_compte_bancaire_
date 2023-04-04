package ma.enset.springgestioncomptebancaire.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompteResponseDTO {
    private Long userId;
    private String accountNumber;
    private Double solde;
    private String currency;
}

