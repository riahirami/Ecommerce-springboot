package com.projet.ecommerce.service;

import java.util.List;

import com.projet.ecommerce.entites.Article;
import com.projet.ecommerce.entites.Catalogue;

public interface CatalogueService {

		public List <Catalogue> getAllCatalogue();
		public Catalogue addCatalogue(Catalogue c);
		public void deleteCatalogue(Long id);
		public List<Catalogue> findCatalogueById(Long id);
		public List<Catalogue> findCatalogueByNom(String nom);
		

	}
