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
import com.projet.ecommerce.entites.Catalogue;
import com.projet.ecommerce.service.ArticleService;
import com.projet.ecommerce.service.CatalogueService;

@RestController
@RequestMapping("/api/catalogue/")
public class RestCatalogueController {

	@Autowired
	CatalogueService catalogueservice;
	
	
	@GetMapping()
	public  List<Catalogue> getAllCatalogue(){
	return catalogueservice.getAllCatalogue();
	}
	@GetMapping("{id}")
	public List<Catalogue> getCatalogue (@PathVariable Long id) {
	return catalogueservice.findCatalogueById(id);
	}
	@PostMapping("add")
	public Catalogue addCatalogue(@RequestBody Catalogue c)
	{
		return catalogueservice.addCatalogue(c);
	}
	
	
	@DeleteMapping("{id}")
	public String deleteCatalogue(@PathVariable Long id) {
		catalogueservice.deleteCatalogue(id);
	return "Suppression réussite";
	}
	@PutMapping("update")
	public Catalogue updateCatalogue(@RequestBody Catalogue c) {
	return catalogueservice.addCatalogue(c);
	}	
}
