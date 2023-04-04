package ma.enset.springgestioncomptebancaire.web;

import ma.enset.springgestioncomptebancaire.entity.Compte;
import ma.enset.springgestioncomptebancaire.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banque")
public class CompteRestControllerApi {
    @Autowired
    CompteRepository compteRepository;
    @GetMapping(path = "/comptes/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    private Compte getCompte(@PathVariable("id") Long id){
        return compteRepository.findCompteByUserId(id);
    }
    @GetMapping(path="/comptes",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    private List<Compte> getAllComptes(){
        return compteRepository.findAll();
    }
    @PostMapping("/comptes/{compte}")
    private Compte save(@RequestBody Compte compte){
        return compteRepository.save(compte);
    }
    @PutMapping("/comptes/{id}")
    private Compte update(@RequestBody Compte compte,@PathVariable("id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }
    @DeleteMapping("/comptes/{id}")
    private void delete(@PathVariable Long id){
        compteRepository.deleteById(id);
    }
    @GetMapping("/comptes/{isActive}")
    private List<Compte> getComptesByStatus(@PathVariable Boolean isActive){
        return compteRepository.searchCompteByStatus(isActive);
    }

}
