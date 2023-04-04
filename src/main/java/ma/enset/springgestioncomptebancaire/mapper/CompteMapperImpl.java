package ma.enset.springgestioncomptebancaire.mapper;
import ma.enset.springgestioncomptebancaire.dto.CompteResponseDTO;
import ma.enset.springgestioncomptebancaire.entity.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapperImpl implements CompteMapper {
    @Override
    public CompteResponseDTO fromBanqueCompte(Compte compte) {
        CompteResponseDTO compteResponseDTO = CompteResponseDTO.builder().build();
        BeanUtils.copyProperties(compte,compteResponseDTO);
        return compteResponseDTO;
    }
}