package com.projet.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ecommerce.entites.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	public List<Categorie> findByNomContains(String Nom);

}
