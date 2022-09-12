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
import com.projet.ecommerce.service.CategorieService;
import com.projet.ecommerce.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	ArticleService articleService ;
	@Autowired
	CategorieService categorieService ;
	
	private String uploadDirectory = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\photos" ;
	
	
	
	@GetMapping("all")
	public String index (Model model) {
		model.addAttribute("article",articleService.getAllArticle());
		model.addAttribute("nombre",articleService.getAllArticle().size());
		model.addAttribute("categories",categorieService.getAllCategorie());
		return "article/index";
	}
	
	
	@GetMapping("add")
	public String showForm (Model model) {
		model.addAttribute("categories",categorieService.getAllCategorie());
		model.addAttribute("article", new Article());
		return "article/addarticle";
	}
	
	@PostMapping("add")
	public String addarticle (@Validated Article a,BindingResult result,Model model,@RequestParam("file") MultipartFile multipartfile) {
		if (result.hasErrors()) {
			model.addAttribute("categories",categorieService.getAllCategorie());
			
			return "article/addarticle";
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
		a.setPhoto(fileName);
		articleService.AddArticle(a);
		
		
		return "redirect:/article/all";
	}
	
	@GetMapping("delete/{id}")
	public String supparticle (@PathVariable Long id) {
		articleService.deleteArticle(id);
		return "redirect:/article/all";
	}
	
	
	
	
	@PostMapping("search")
	public String updatearticle (@RequestParam String nom ,Model model) {
		model.addAttribute("article",articleService.findArticleByNom(nom));
		return "article/index";
	}
	
	@GetMapping("parcat/{idcat}")
	public String findarticleByCat (@PathVariable Long idcat ,Model model) {
		
		if (idcat!=0L) {
		model.addAttribute("article",articleService.findArticleByCat(idcat));
		model.addAttribute("nombre",articleService.findArticleByCat(idcat).size());
		}
		
		else {
			model.addAttribute("article",articleService.getAllArticle());
			model.addAttribute("nombre",articleService.getAllArticle().size());
		}
		model.addAttribute("categories",categorieService.getAllCategorie());
		model.addAttribute("idcat",idcat);
		
		return "article/index";
		
	}
	
	@GetMapping("edit/{id}")
	public String editerarticle (@PathVariable Long id,Model model) {
		
		model.addAttribute("article",articleService.findArticleById(id));
		model.addAttribute("categories",categorieService.getAllCategorie());
		return "article/editarticle";
	}
	
	@PostMapping("update")
	public String updatearticle (@Validated Article a) {
		articleService.AddArticle(a);
		return "redirect:/article/all";
	}
	
	@GetMapping("detaill/{id}")
	public String showDetail (Model model,@PathVariable Long id) {
		model.addAttribute("categories",categorieService.getAllCategorie());
		model.addAttribute("article", articleService.findArticleById(id));
		model.addAttribute("ida",id);

		return "article/Detailarticle";
	}
	
	@PostMapping("show")
	public String showarticle (Model model,Article a) {
		Article art=articleService.findArticleById(a.getId());
		model.addAttribute("article",art);

		return "redirect:article/Detailarticle";
	}
}
