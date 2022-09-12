package com.projet.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ecommerce.entites.Article;
import com.projet.ecommerce.service.ArticleService;

@RestController
@RequestMapping("/api/article/")
public class RestArticleController {

	@Autowired
	ArticleService articlservice;
	
	
	@GetMapping()
	public  List<Article> getAllArticle(){
	return articlservice.getAllArticle();
	}
	@GetMapping("{id}")
	public Article getArticle (@PathVariable Long id) {
	return articlservice.findArticleById(id);
	}
	@PostMapping("add")
	public Article addArticle(@RequestBody Article a)
	{
		return articlservice.AddArticle(a);
	}
	
	
	@DeleteMapping("{id}")
	public String deleteArticle(@PathVariable Long id) {
		articlservice.deleteArticle(id);
	return "Suppression réussite";
	}
	@PutMapping("update")
	public Article updateArticle(@RequestBody Article a) {
	return articlservice.AddArticle(a);
	}	
}
