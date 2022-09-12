package com.projet.ecommerce.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ecommerce.entites.Categorie;
import com.projet.ecommerce.repository.CategorieRepository;

@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	CategorieRepository categorieRepository;
	
	@Override
	public List<Categorie> getAllCategorie() {
		return categorieRepository.findAll();
		
	}

	@Override
	public Categorie addCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return categorieRepository.save(c);
	}

	@Override
	public void deleteCategorie(Long id) {
		// TODO Auto-generated method stub
		categorieRepository.deleteById(id);
	}

	@Override
	public Categorie findCategorieById(Long id) {
		// TODO Auto-generated method stub
		return categorieRepository.getById(id);
		
	}

	@Override
	public Object findCategorieByNom(String nom) {
		// TODO Auto-generated method stub
		return categorieRepository.findByNomContains(nom);
	}

	
	

	
}
