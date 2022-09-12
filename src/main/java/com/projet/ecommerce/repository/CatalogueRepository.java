package com.projet.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.ecommerce.entites.Article;
import com.projet.ecommerce.entites.Catalogue;
import com.projet.ecommerce.entites.Categorie;

public interface CatalogueRepository  extends JpaRepository<Catalogue, Long>  {

	public List<Catalogue> findByNomContains(String Nom);

	public List<Catalogue> findCatalogueById(Long id);

}
