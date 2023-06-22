package com.inti.TD3SpringActeur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.TD3SpringActeur.model.Acteur;
import com.inti.TD3SpringActeur.repository.ActeurRepository;

@Service
public class ActeurServiceImpl implements ActeurService
{
	@Autowired
	ActeurRepository ar;

	@Override
	public void save(Acteur a)
	{
		ar.save(a);
	}

	@Override
	public Acteur findByNom(String nom)
	{
		return ar.findByNom(nom);
	}

	@Override
	public Acteur findByNomAndPrenom(String nom, String prenom)
	{
		return ar.findByNomAndPrenom(nom, prenom);
	}

	@Override
	public void updateNomActeurById(int id, String nom)
	{
		ar.updateNomActeurById(id, nom);
		
	}

	@Override
	public List<Acteur> getActeurs()
	{
		return ar.findAll();
	}

	@Override
	public Acteur getActeur(int id)
	{
		return ar.getById(id);
	}

	@Override
	public void saveActeur(Acteur acteur)
	{
		ar.save(acteur);
	}

	@Override
	public void deleteActeur(int id)
	{
		ar.deleteById(id);
		
	}

	@Override
	public void updateActeur(Acteur p)
	{
		ar.save(p);		
	}
	
	

}
