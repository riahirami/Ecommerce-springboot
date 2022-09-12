package com.projet.ecommerce.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import org.springframework.web.servlet.ModelAndView;

import com.projet.ecommerce.entites.Catalogue;
import com.projet.ecommerce.entites.Utilisateur;
import com.projet.ecommerce.repository.UtilisateurRepository;
import com.projet.ecommerce.service.ArticleService;
import com.projet.ecommerce.service.CatalogueService;
import com.projet.ecommerce.service.CategorieService;
import com.projet.ecommerce.service.UtilisateurService;

@Controller
@RequestMapping("/")
public class AccueilController {

	
	@Autowired
	ArticleService articleService ;
	@Autowired
	CategorieService categorieService ;
	@Autowired
	UtilisateurService utilisateurService;
	
	@Autowired
	CatalogueService catalogueService;
	
	UtilisateurRepository userRepo;
	
	private String uploadDirectory = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\photos" ;

	@GetMapping("/")
	public String index (Model model) {
		model.addAttribute("article",articleService.getAllArticle());
		model.addAttribute("nombre",articleService.getAllArticle().size());
		model.addAttribute("categories",categorieService.getAllCategorie());
		model.addAttribute("catalogue",catalogueService.getAllCatalogue());

		return "/accueil";
	}
	

		

		
		@GetMapping("accueil")
		public String showForm (Model model) {
			model.addAttribute("user", new Utilisateur());
			model.addAttribute("article",articleService.getAllArticle());
			model.addAttribute("nombre",articleService.getAllArticle().size());
			model.addAttribute("categories",categorieService.getAllCategorie());
			return "/register_success";
		}
		
		@GetMapping("register")
		public String showRegistrationForm(Model model) {
		    model.addAttribute("user", new Utilisateur());
		     
			return "/inscription";
		}
		
		
		@PostMapping("process_register")
		public String inscription (@Validated Utilisateur u,BindingResult result,Model model,@RequestParam("file") MultipartFile multipartfile) {
			if (result.hasErrors()) {
				
			//	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//	    String encodedPassword = passwordEncoder.encode(u.getMotdepasse());
			   // u.setMotdepasse(encodedPassword);
				model.addAttribute("user",utilisateurService.Inscription(u));

				model.addAttribute("categories",categorieService.getAllCategorie());
				model.addAttribute("article",articleService.getAllArticle());
				return "/users";
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
			model.addAttribute("user",utilisateurService.Inscription(u));
			//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//    String encodedPassword = passwordEncoder.encode(u.getMotdepasse());
			u.setPhoto(fileName);
			//u.setRole("Client");	
			
		   // u.setMotdepasse(encodedPassword);
			utilisateurService.Inscription(u);
			
			return "register_success";
			}
		
		
	
		@GetMapping("/users")
		public String listUsers(Model model) {
		    List<Utilisateur> listUsers = userRepo.findAll();
		    model.addAttribute("listUsers", listUsers);
		     
		    return "users";
		}
		
	
	
}
