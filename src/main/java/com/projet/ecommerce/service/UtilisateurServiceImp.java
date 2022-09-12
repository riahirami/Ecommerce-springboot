package com.projet.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ecommerce.entites.Utilisateur;
import com.projet.ecommerce.repository.UtilisateurRepository;

@Service

public class UtilisateurServiceImp implements UtilisateurService {

	
	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	public Utilisateur Inscription(Utilisateur u) {
		// TODO Auto-generated method stub
		return utilisateurRepository.save(u);
	}
	
	
}
