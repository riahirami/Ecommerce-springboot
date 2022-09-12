package com.projet.ecommerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.projet.ecommerce.entites.Article;
import com.projet.ecommerce.entites.Categorie;
import com.projet.ecommerce.service.ArticleService;
import com.projet.ecommerce.service.CategorieService;

@Controller
@RequestMapping("/categorie")
public class CategorieController {

	@Autowired
	ArticleService articleService ;
	@Autowired
	CategorieService categorieService ;
	
	
	@GetMapping("all")
	public String index (Model model) {
	
		model.addAttribute("categories",categorieService.getAllCategorie());
		return "categorie/index";
	}
	
	
	@GetMapping("add")
	public String showForm (Model model) {
		model.addAttribute("categories", new Categorie());
		return "addcategorie";
	}
	
	@PostMapping("add")
	public String addcategorie (Categorie c,BindingResult result,Model model) {
		
			model.addAttribute("categories",categorieService.addCategorie(c));
			
			return "addcategorie";
		
	}
	
	@GetMapping("delete/{id}")
	public String suppcategorie (@PathVariable Long id) {
		categorieService.deleteCategorie(id);
		return "redirect:/categorie/all";
	}
	
	
	@GetMapping("edit/{id}")
	public String editercategorie (@PathVariable Long id,Model model) {
		
		model.addAttribute("categories",categorieService.findCategorieById(id));
		return "editcategorie";
	}
	
	@PostMapping("update")
	public String updatecategorie (Categorie c) {
		categorieService.addCategorie(c);
		return "redirect:/categorie/all";
	}
	
	@PostMapping("search")
	public String updatecategorie (@RequestParam String nom ,Model model) {
		model.addAttribute("categories",categorieService.findCategorieByNom(nom));
		return "categorie/index";
	}
}
