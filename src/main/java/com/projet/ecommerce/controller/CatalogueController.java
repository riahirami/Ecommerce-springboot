package com.projet.ecommerce.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
import com.projet.ecommerce.entites.Catalogue;
import com.projet.ecommerce.entites.Categorie;
import com.projet.ecommerce.service.ArticleService;
import com.projet.ecommerce.service.CatalogueService;
import com.projet.ecommerce.service.CategorieService;

@Controller
@RequestMapping("/catalogue")
public class CatalogueController {

	
	@Autowired
	CatalogueService catalogueService ;
	@Autowired
	ArticleService articleService ;
	@Autowired
	CategorieService categorieService ;
	
	
	private String uploadDirectory = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\photos" ;


	@GetMapping("all")
	public String index (Model model) {
	
		model.addAttribute("catalogues",catalogueService.getAllCatalogue());
		return "catalogue/index";
	}
	
	
	@GetMapping("add")
	public String showForm (Model model) {
		model.addAttribute("catalogue", new Catalogue());
		model.addAttribute("article",articleService.getAllArticle());

		return "catalogue/addcatalogue";
	}
	
	@PostMapping("add")
	public String addcatalogue (@Validated Catalogue c,BindingResult result,Model model,@RequestParam("file") MultipartFile multipartfile) {
		if (result.hasErrors()) {
			model.addAttribute("categories",categorieService.getAllCategorie());
			model.addAttribute("article",articleService.getAllArticle());
			return "catalogue/addcatalogue";
		}
		String fileName=multipartfile.getOriginalFilename();
		Path fileNameAndPath = Paths.get(uploadDirectory,fileName) ;
		
		try {
			Files.write(fileNameAndPath, multipartfile.getBytes());
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		model.addAttribute("article",articleService.getAllArticle());

		c.setPhoto(fileName);
		catalogueService.addCatalogue(c);
		
		
		return "redirect:/catalogue/all";
	}
	
	@GetMapping("delete/{id}")
	public String suppcatalogue(@PathVariable Long id) {
		catalogueService.deleteCatalogue(id);
		return "redirect:/catalogue/all";
	}
	
	
	@GetMapping("edit/{id}")
	public String editercatalogue (@PathVariable Long id,Model model) {
		
		model.addAttribute("catalogue",catalogueService.findCatalogueById(id));
		return "editcatalogue";
	}
	
	@PostMapping("update")
	public String updatecatalogue (Catalogue c) {
		catalogueService.addCatalogue(c);
		return "redirect:/catalogue/all";
	}
	
	@PostMapping("search")
	public String updatecatalogue (@RequestParam String nom ,Model model) {
		model.addAttribute("catalogue",catalogueService.findCatalogueByNom(nom));
		return "catalogue/index";
	}
	
}
