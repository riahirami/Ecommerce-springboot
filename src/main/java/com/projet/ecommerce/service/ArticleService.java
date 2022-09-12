package com.projet.ecommerce.service;

import java.util.List;

import com.projet.ecommerce.entites.Article;

public interface ArticleService {
	
	public List <Article> getAllArticle();
	public Article AddArticle(Article a);
	public void deleteArticle(Long id);
	public Article findArticleById(Long id);
	public List<Article> findArticleByNom(String Nom);
	public List<Article> findArticleByCat(Long id);
	


}
