package com.inti.TD3SpringActeur;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.TD3SpringActeur.model.Acteur;
import com.inti.TD3SpringActeur.model.Utilisateur;
import com.inti.TD3SpringActeur.repository.ActeurRepository;
import com.inti.TD3SpringActeur.service.ActeurService;
import com.inti.TD3SpringActeur.service.ActeurServiceImpl;
import com.inti.TD3SpringActeur.service.UtilisateurService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController
{
	
	@Autowired
	ActeurService as;
	
	@Autowired
	UtilisateurService us;
	
	@GetMapping("/test")
	public String test()
	{
//		ar.save(new Acteur("Paul"));
//		ar.save(new Acteur("Pierre"));
//		ar.save(new Acteur("Sophie"));
//		ar.save(new Acteur("Jean"));
		
//		log.info("nombre de ligne dans la table acteur : " + ar.count());
//		
//		for (Acteur a : ar.findAll())
//		{
//			log.info("acteur : " + a);
//
//		}
//		
//		log.info("un acteur : " + ar.getById(1));
//		
//		ar.delete(ar.getById(3));
//		
//		log.info("existe : " + ar.existsById(15));
		
//		as.save(new Acteur("Hélène"));
		
//		log.info("acteur : " +  as.findByNomAndPrenom("Pierre", null));
		
		as.updateNomActeurById(2, "Ronaldo");


		
		return "test";
	}
	
	@GetMapping("/accueil")
	public String accueil(Model m, HttpSession session)
	{
		if(session.getAttribute("login") == null)
		{
			return "redirect:/connexion";
		}
		else
		{
			String login = (String) session.getAttribute("login");
			
			log.info("login : " + login);
			
			m.addAttribute("listeActeur", as.getActeurs());
			
			return "accueil";
		}

	}
	
	@PostMapping("/enrActeur")
	public String saveActeur(@ModelAttribute("acteur") Acteur p)
	{
		log.info("acteur : " + p);

		
		as.saveActeur(p);
		
		return "redirect:/accueil";
	}
	
	@GetMapping("/formActeur")
	public String formActeur()
	{
		
		return "formActeur";
	}
	
	@GetMapping("/delActeur/{id}")
	public String delActeur(@PathVariable int id)
	{
		
		as.deleteActeur(id);
		
		
		return "redirect:/accueil";
	}
	
	@GetMapping("/modifActeur/{id}")
	public String modifActeur(@PathVariable int id, Model m)
	{
		
		m.addAttribute("acteur", as.getActeur(id));
		
		
		return "modifier_Acteur";
	}
	
	@PostMapping("/modifActeur/updtActeur")
	public String updateActeur(@ModelAttribute("acteur") Acteur p)
	{
		as.updateActeur(p);
		return "redirect:/accueil";
	}
	
	@GetMapping("/connexion")
	public String connexion()
	{
		
		return "connexion";
	}
	
	@GetMapping("/enregistrerUtilisateur")
	public String enregistrerUtilisateur()
	{
		
		return "enregistrerUtilisateur";
	}
	
	@PostMapping("/enrUser")
	public String enrUser(@ModelAttribute("utilisateur") Utilisateur u)
	{
		log.info("hash : " + u.hashCode());
		
		u.setMdp(String.valueOf(u.hashCode()));

		
		us.saveUtilisateur(u);
		
		return "redirect:/connexion";
	}
	
	@PostMapping("/verifierUser")
	public String verifierUser(@ModelAttribute("utilisateur") Utilisateur u, HttpSession session)
	{
		session.setAttribute("login", u.getLogin());
		
		String mdp = String.valueOf(u.hashCode());
		
		Utilisateur u1 = us.findByLoginAndMdp(u.getLogin(), mdp);
		
		if(u1 != null)
		{
			return "redirect:/accueil";
		}
		
		return "redirect:/connexion";
	}

}
