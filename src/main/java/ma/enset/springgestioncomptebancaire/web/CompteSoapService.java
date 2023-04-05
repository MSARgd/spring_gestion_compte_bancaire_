package ma.enset.springgestioncomptebancaire.web;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import ma.enset.springgestioncomptebancaire.entity.Compte;
import ma.enset.springgestioncomptebancaire.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
@WebService(name = "/banque")
public class CompteSoapService {
    @Autowired
    CompteRepository compteRepository;
    @WebMethod
    public List<Compte> getAllComptes(){
        return compteRepository.findAll();
    }
    @WebMethod
    public Compte getCompte(@Param("id")Long id){
        return compteRepository.findById(id).get();
    }
    @WebMethod
    public Compte getCompteByUserId(@Param("idClient")Long id){
        return compteRepository.findCompteByUserId(id);
    }
}