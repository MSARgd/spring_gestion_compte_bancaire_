package ma.enset.springgestioncomptebancaire.service;

import ma.enset.springgestioncomptebancaire.dto.CompteRequestDTO;
import ma.enset.springgestioncomptebancaire.dto.CompteResponseDTO;
import ma.enset.springgestioncomptebancaire.entity.Compte;
import ma.enset.springgestioncomptebancaire.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.UUID;

@Service
@Transactional
public class CompteServiceImpl implements CompteService  {
    @Autowired
    private CompteRepository compteRepository;
    @Override
    public CompteResponseDTO addCompte(CompteRequestDTO compteRequestDTO) {
        Compte compte = Compte.builder()
                .id(new Random().nextLong())
                .typeCompte(compteRequestDTO.getTypeCompte())
                .balance(compteRequestDTO.getBalance())
                .currency(compteRequestDTO.getCurrency())
                .build();
        Compte savedCompte = compteRepository.save(compte);

        CompteResponseDTO compteResponseDTO = CompteResponseDTO.builder()
                .userId(savedCompte.getUserId())
                .currency(savedCompte.getCurrency())
                .accountNumber(savedCompte.getAccountNumber())
                .solde(savedCompte.getSolde())
                .build();
        return compteResponseDTO;
    }
}
