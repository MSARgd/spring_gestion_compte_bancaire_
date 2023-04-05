package ma.enset.springgestioncomptebancaire.mapper;
import ma.enset.springgestioncomptebancaire.dto.CompteRequestDTO;
import ma.enset.springgestioncomptebancaire.dto.CompteResponseDTO;
import ma.enset.springgestioncomptebancaire.entity.Compte;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapperImpl implements CompteMapper {
    private ModelMapper modelMapper=new ModelMapper();
    @Override
    public CompteResponseDTO fromBanqueCompte(Compte compte) {
        CompteResponseDTO compteResponseDTO = CompteResponseDTO.builder().build();
        BeanUtils.copyProperties(compte,compteResponseDTO);
        return compteResponseDTO;
    }

    @Override
    public Compte fromCompteDTO(CompteRequestDTO compteRequestDTO) {
        Compte compte = Compte.builder().build();
        BeanUtils.copyProperties(compteRequestDTO,compte);
        return  compte;
    }
}