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

import com.projet.ecommerce.entites.Categorie;
import com.projet.ecommerce.service.CategorieService;

@RestController
@RequestMapping("/api/categorie/")
public class RestCategorieController {

	
	@Autowired
	CategorieService categorieservice;
	
	
	@GetMapping()
	public  List<Categorie> getAllCategorie(){
	return categorieservice.getAllCategorie();
	}
	@GetMapping("{id}")
	public Categorie getCategorie (@PathVariable Long id) {
	return categorieservice.findCategorieById(id);
	}
	@PostMapping("add")
	public Categorie addCategorie(@RequestBody Categorie c)
	{
		return categorieservice.addCategorie(c);
	}
	
	
	@DeleteMapping("{id}")
	public String deleteCategorie(@PathVariable Long id) {
		categorieservice.deleteCategorie(id);;
	return "Suppression réussite";
	}
	@PutMapping("update")
	public Categorie updateCategorie(@RequestBody Categorie c ) {
	return categorieservice.addCategorie(c);
	}	
}
