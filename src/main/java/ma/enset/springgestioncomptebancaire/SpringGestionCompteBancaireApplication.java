package ma.enset.springgestioncomptebancaire;

import ma.enset.springgestioncomptebancaire.entity.Compte;
import ma.enset.springgestioncomptebancaire.entity.enumes.TypeCompte;
import ma.enset.springgestioncomptebancaire.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class SpringGestionCompteBancaireApplication implements CommandLineRunner {
	@Autowired
	CompteRepository compteRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringGestionCompteBancaireApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//====================================================
		for(int i=0;i<10;i++){
			String randomAcountNumber =   UUID.randomUUID().toString().substring(0, 20);
			compteRepository.save(new Compte((long) i, (long) i,
					TypeCompte.values()[new Random().nextInt(TypeCompte.values().length)],
					new Date((long) (Math.random() * System.currentTimeMillis())),
					new Date((long) (Math.random() * System.currentTimeMillis())),
					new Date((long) (Math.random() * System.currentTimeMillis())),
					new Random().nextBoolean(),randomAcountNumber,new Random().nextDouble(Math.pow(10,10))
			));
		}
		//=====================================================
		List<Compte> comptesList = compteRepository.findAll();
		comptesList.forEach(c->{
			System.out.println(c.toString());
		});
		//===================================================
		Compte compte = compteRepository.findById(3L).get();
		System.out.println(compte.toString());
		//=================================================
		Compte compteByUserId = compteRepository.findCompteByUserId(7L);
		System.out.println(compteByUserId.toString());
		//================================================
		System.out.println("Les  Comptes Active  : ");
		List<Compte> activeComptes = compteRepository.searchCompteByStatus(true);
		activeComptes.forEach(c->{
			System.out.println(c.toString());
		});
		//===============================================
		System.out.println("Les  Comptes Non Active  : ");
		List<Compte> nonActiveComptes = compteRepository.searchCompteByStatus(false);
		activeComptes.forEach(c->{
			System.out.println(c.toString());
		});
		//===========================================================
		Compte updatedCompte = compteRepository.findById(2L).get();
		updatedCompte.setIsActive(!updatedCompte.getIsActive());
		compteRepository.save(updatedCompte);
		//===========================================================
		compteRepository.deleteById(6L);
	}
}