package com.projet.ecommerce.service;

import java.util.List;

import com.projet.ecommerce.entites.Categorie;

public interface CategorieService {

		public List <Categorie> getAllCategorie();
		public Categorie addCategorie(Categorie c);
		public void deleteCategorie(Long id);
		public Categorie findCategorieById(Long id);
		public Object findCategorieByNom(String nom);
		

	}


