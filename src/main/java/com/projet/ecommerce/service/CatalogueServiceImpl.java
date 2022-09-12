package com.projet.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ecommerce.entites.Article;
import com.projet.ecommerce.entites.Catalogue;
import com.projet.ecommerce.repository.CatalogueRepository;
import com.projet.ecommerce.repository.CategorieRepository;

@Service
public class CatalogueServiceImpl implements CatalogueService {

	
	@Autowired
	CatalogueRepository catalogueRepository;
	
	@Override
	public List<Catalogue> getAllCatalogue() {
		// TODO Auto-generated method stub
		return catalogueRepository.findAll();
	}

	@Override
	public Catalogue addCatalogue(Catalogue c) {
		// TODO Auto-generated method stub
		return catalogueRepository.save(c);
	}

	@Override
	public void deleteCatalogue(Long id) {
		// TODO Auto-generated method stub
		catalogueRepository.deleteById(id);
	}

	@Override
	public List<Catalogue> findCatalogueById(Long id) {
		// TODO Auto-generated method stub
		return catalogueRepository.findCatalogueById(id);
	}

	@Override
	public List<Catalogue> findCatalogueByNom(String nom) {
		// TODO Auto-generated method stub
		return catalogueRepository.findByNomContains(nom);
	}

}
