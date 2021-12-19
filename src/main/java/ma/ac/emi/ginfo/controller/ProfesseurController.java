package ma.ac.emi.ginfo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ma.ac.emi.ginfo.model.Compte;
import ma.ac.emi.ginfo.model.GradeType;
import ma.ac.emi.ginfo.model.Professeur;
import ma.ac.emi.ginfo.repository.CompteRepository;
import ma.ac.emi.ginfo.repository.ProfesseurRepository;

@Controller
public class ProfesseurController {

	@Autowired
	private ProfesseurRepository prr;

	@Autowired
	private CompteRepository cr;

	@RequestMapping(value = "/professeurs", method = RequestMethod.GET)
	public String index(Model model) {

		List<Professeur> pageprofesseurs = prr.findAll();
		model.addAttribute("listProfesseurs", pageprofesseurs);
		return "Professeurs";
	}

	@RequestMapping(value = "/chercherProfesseur")
	public String Chercher(Model model, @RequestParam(name = "nomProfesseur", defaultValue = "") String nom) {

		List<Professeur> pageProfesseurs;
		if (nom.length() == 0)
			pageProfesseurs = prr.findAll();
		else
			pageProfesseurs = prr.findByNom(nom);
		model.addAttribute("listProfesseurs", pageProfesseurs);

		return "Professeurs";
	}

	@RequestMapping(value = "/ajouterprofesseur", method = RequestMethod.GET)
	public String ajouterNote(Model model) {
		return "ajouterprofesseur";
	}

	@RequestMapping(value = "/ajouterprofesseur", method = RequestMethod.POST)
	public String ajouterNote(Model model, Long matricule, String nom, String prenom, LocalDate datenaissance,
			int numSomme, GradeType grade, String email, String password) {
		System.out.println(matricule);
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(datenaissance);
		System.out.println(numSomme);
		System.out.println(grade);
		System.out.println(email);
		System.out.println(password);
		if (matricule != 0L && nom != "" && prenom != "" && numSomme != 0 && email != "" && password != "") {
			Professeur prof = new Professeur(matricule, nom, prenom, datenaissance, numSomme, grade);
			prr.save(prof);
			Compte co = new Compte(nom, prenom, prof);
			cr.save(co);
			return "redirect:/professeurs";
		} else {
			model.addAttribute("matricule", matricule);
			model.addAttribute("nom", nom);
			model.addAttribute("prenom", prenom);
			model.addAttribute("datenaissance", datenaissance);
			model.addAttribute("numSomme", numSomme);
			model.addAttribute("grade", grade);
			model.addAttribute("email", email);
			model.addAttribute("password", password);
			return "ajouterprofesseur";
		}

	}

}
