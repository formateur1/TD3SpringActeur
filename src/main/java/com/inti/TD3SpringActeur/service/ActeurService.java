package com.inti.TD3SpringActeur.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.inti.TD3SpringActeur.model.Acteur;

public interface ActeurService
{
	void save(Acteur a);
	Acteur findByNom(String nom);
	Acteur findByNomAndPrenom(String nom, String prenom);
	void updateNomActeurById(int id, String nom);
	
	List<Acteur> getActeurs();
	Acteur getActeur(int id);
	void saveActeur(Acteur acteur);
	void deleteActeur(int id);
	void updateActeur(Acteur p);
}
