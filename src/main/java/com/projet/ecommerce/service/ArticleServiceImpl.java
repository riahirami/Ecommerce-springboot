package com.projet.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ecommerce.entites.Article;
import com.projet.ecommerce.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService  {

	@Autowired
	ArticleRepository articleRepository;
	
	
	@Override
	public List<Article> getAllArticle() {
		// TODO Auto-generated method stub
		return articleRepository.findAll();
	}

	@Override
	public Article AddArticle(Article a) {
		// TODO Auto-generated method stub
		return articleRepository.save(a);
	}

	@Override
	public void deleteArticle(Long id) {
		// TODO Auto-generated method stub
		articleRepository.deleteById(id);
	}

	@Override
	public Article findArticleById(Long id) {
		// TODO Auto-generated method stub
		return articleRepository.getById(id);
	}

	@Override
	public List<Article> findArticleByNom(String Nom) {
		// TODO Auto-generated method stub
		return articleRepository.findByNomContains(Nom);
	}

	@Override
	public List<Article> findArticleByCat(Long id) {
		// TODO Auto-generated method stub
		return articleRepository.rechercherParCategorie(id);
	}

	


}
