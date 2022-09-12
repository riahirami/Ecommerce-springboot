package com.projet.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.ecommerce.entites.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

	public List<Article> findByNomContains(String Nom);
	
	@Query ("select a from Article a where a.categorie.id=?1")
	public List<Article> rechercherParCategorie(Long id);
}
