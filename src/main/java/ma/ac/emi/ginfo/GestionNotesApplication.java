package ma.ac.emi.ginfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.ac.emi.ginfo.model.Compte;
import ma.ac.emi.ginfo.model.Matiere;
import ma.ac.emi.ginfo.model.Note;
import ma.ac.emi.ginfo.model.Professeur;
import ma.ac.emi.ginfo.model.Student;
import ma.ac.emi.ginfo.repository.CompteRepository;
import ma.ac.emi.ginfo.repository.MatiereRepository;
import ma.ac.emi.ginfo.repository.NoteRepository;
import ma.ac.emi.ginfo.repository.PersonneRepository;
import ma.ac.emi.ginfo.repository.ProfesseurRepository;
import ma.ac.emi.ginfo.repository.StudentRepository;

@SpringBootApplication
public class GestionNotesApplication {

	@Autowired
	PersonneRepository pr;
	@Autowired
	StudentRepository sr;
	@Autowired
	ProfesseurRepository prr;
	@Autowired
	CompteRepository cr;
	@Autowired
	MatiereRepository mr;
	@Autowired
	NoteRepository nr;

	public static void main(String[] args) {
		SpringApplication.run(GestionNotesApplication.class, args);
	}

	@Bean
	public CommandLineRunner console() {
		return args -> {
			System.out.println("-----------Execution du programme------------");

			System.out.println("findAll");
			String[] nomProf = {"Belouadha", "El Faddouli", "Bouzoubaa", "Kabbaj", "Anwar"};
			String[] prenomProf = {"Fatima-zahra", "Nourdinne", "Karim", "Mohammed Issam", "Adil"};
			Long[] matricule = {2000L, 2001L, 2002L, 2003L, 2004L};
			int[] somme = {2000, 2001, 2002, 2003, 2004};
			List<Professeur> profs = new ArrayList<Professeur>();
			for(int i = 0; i<nomProf.length; i++) {
				Professeur prof = new Professeur(matricule[i], nomProf[i], prenomProf[i], LocalDate.of(1992, 05, 07), somme[i]);
				prr.save(prof);
				Compte c = new Compte(nomProf[i]+"@emi.ac.ma", ""+matricule[i], prof);
				c.setEnabled(true);
				c.setLocked(false);
				cr.save(c);
				profs.add(prof);
			}
			
			List<Matiere> matieres = new ArrayList<>();
			Matiere m;
			
			m = new Matiere("JEE", 28, 4);
			m.addProfesseur(profs.get(2));
			m.addProfesseur(profs.get(3));
			mr.save(m);
			matieres.add(m);
			
			m = new Matiere("C", 28, 1);
			m.addProfesseur(profs.get(0));
			m.addProfesseur(profs.get(1));
			mr.save(m);
			matieres.add(m);
			
			m = new Matiere("Design Pattern", 28, 4);
			m.addProfesseur(profs.get(4));
			m.addProfesseur(profs.get(3));
			mr.save(m);
			matieres.add(m);

			m = new Matiere("Systeme exploitation", 28, 2);
			m.addProfesseur(profs.get(0));
			m.addProfesseur(profs.get(1));
			mr.save(m);
			matieres.add(m);
			
			m = new Matiere("Structure de données", 28, 2);
			m.addProfesseur(profs.get(0));
			mr.save(m);
			matieres.add(m);
			
			m = new Matiere("Introduction Bases de Données", 28, 1);
			m.addProfesseur(profs.get(0));
			m.addProfesseur(profs.get(1));
			mr.save(m);
			matieres.add(m);

			m = new Matiere("Méthode Orienté Objet", 28, 4);
			m.addProfesseur(profs.get(3));
			m.addProfesseur(profs.get(4));
			mr.save(m);
			matieres.add(m);
			
			m = new Matiere("UML", 28, 3);
			m.addProfesseur(profs.get(4));
			mr.save(m);
			matieres.add(m);

			m = new Matiere("IHM", 28, 3);
			m.addProfesseur(profs.get(2));
			mr.save(m);
			matieres.add(m);
			
			m = new Matiere("Administration Oracle", 28, 5);
			m.addProfesseur(profs.get(1));
			mr.save(m);
			matieres.add(m);
			
			m = new Matiere("Urbanisation", 28, 5);
			m.addProfesseur(profs.get(0));
			mr.save(m);
			matieres.add(m);

			Long[] matriculeS = {100L, 101L, 102L, 103L, 104L, 105L, 106L, 107L, 108L};
			int[] niveau = {1, 1, 1, 2, 2, 2, 3, 3, 3};
			String[] nomStud = {"Mouradi", "Lakdar", "Bennani", "Benchaqroun", "Tabit", "Oufkir", "benkirane", "Youssefi", "Sabir"};
			String[] prenomStud = {"Mourad", "Khadija", "Ilyass", "Kawtar", "Nabil", "Hiba", "Souad", "Lilla", "ali"};
			Boolean[] reserves = {false, false, true, false, false, true, false, false, true};
			List<Student> students = new ArrayList<>();
			for(int i = 0; i<nomStud.length; i++) {
				Student s = new Student(matriculeS[i], nomStud[i], prenomStud[i], LocalDate.of(1992, 05, 07), niveau[i], reserves[i]);
				sr.save(s);
				Compte c = new Compte(nomStud[i]+"@student.emi.ac.ma", ""+matriculeS[i], s);
				c.setEnabled(true);
				c.setLocked(false);
				cr.save(c);
				students.add(s);
			}

			Random r = new Random();

			for(int i=0; i<100; i++) {
				float random = 4 + r.nextFloat() * 16;
				String ab;
				if(random<8)
					ab = "médiocre";
				else if(random < 11)
					ab = "faible";
				else if(random < 13)
					ab = "moyen";
				else if(random < 15)
					ab = "Assez bien";
				else
					ab = "bien";
				int ns = r.nextInt(students.size());
				int nm = r.nextInt(matieres.size());
				Note n = new Note(random, ab, students.get(ns), matieres.get(nm));
				nr.save(n);
			}

			System.out.println("Find All Personne");
			System.out.println(pr.findAll());
			System.out.println("Find By Nom");
			System.out.println(pr.findByNom("Kabbaj"));
			System.out.println(pr.findByNom("Belouadha"));
			System.out.println("Find All Compte");
			System.out.println(cr.findAll());
			System.out.println("Find All Matiere");
			System.out.println(mr.findAll());
			System.out.println("Find All Matiere d'un professeur");
			mr.findById(1L).get().getProfesseurs()
					.forEach(p -> System.out.println("name = " + p.getNom() + " matieres = " + p.getMatieres()));

			System.out.println("Find All Note");
			nr.findAll().forEach(System.out::println);

			System.out.println("-----------Fin Execution du programme------------");
		};
	}

}
