package ma.enset.springgestioncomptebancaire.web;

import ma.enset.springgestioncomptebancaire.entity.Compte;
import ma.enset.springgestioncomptebancaire.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/banque")
public class CompteRestControllerApi {
    @Autowired
    CompteRepository compteRepository;
    public CompteRestControllerApi(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }
   /* @GetMapping("/comptes/{id}")
    public Compte getCompte(@PathVariable Long id) {
        return compteRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Acount %s not found",id)));
    } */
    @GetMapping( "/comptes/{id}")
    private Compte getCompte(@PathVariable Long id){
        return compteRepository.findCompteByUserId(id);
    }
    @GetMapping("/comptes")
    public List<Compte> getAllComptes(){
        return compteRepository.findAll();
    }
    @PostMapping("/comptes/{compte}")
    public Compte saveCompte(@RequestBody Compte compte){
        return compteRepository.save(compte);
    }
    @PutMapping("/comptes/{id}")
    public  Compte updateCompte(@RequestBody Compte compte,@PathVariable Long id){
        Compte updatedCompte =  compteRepository.findById(id).get();
        if(compte.getUserId() != null) updatedCompte.setUserId(compte.getUserId());
        if(compte.getTypeCompte()!=null) updatedCompte.setTypeCompte(compte.getTypeCompte());
        if(compte.getCreatedAt()!=null) updatedCompte.setUpdatedAt(compte.getUpdatedAt());
        if(compte.getUpdatedAt()!=null) updatedCompte.setUpdatedAt(new Date());
        if(compte.getEndValidity()!=null) updatedCompte.setEndValidity(compte.getEndValidity());
        if(compte.getAccountNumber()!=null) updatedCompte.setAccountNumber(compte.getAccountNumber());
        if(compte.getSolde()!=null) updatedCompte.setSolde(compte.getSolde());
        return compteRepository.save(updatedCompte);
    }
    @DeleteMapping("/comptes/{id}")
    public void deleteCompte(@PathVariable Long id){
        compteRepository.deleteById(id);
    }
//    @GetMapping("/comptes/{isActive}")
//    public List<Compte> getComptesByStatus(@PathVariable Boolean isActive){
//        return compteRepository.searchCompteByStatus(isActive);
//    }
}