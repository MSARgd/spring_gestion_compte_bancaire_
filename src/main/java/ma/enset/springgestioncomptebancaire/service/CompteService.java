package ma.enset.springgestioncomptebancaire.service;

import ma.enset.springgestioncomptebancaire.dto.CompteRequestDTO;
import ma.enset.springgestioncomptebancaire.dto.CompteResponseDTO;

public interface CompteService {
    public CompteResponseDTO addCompte( CompteRequestDTO compteRequestDTO);

}
