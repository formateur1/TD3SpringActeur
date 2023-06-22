package com.inti.TD3SpringActeur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.TD3SpringActeur.model.Utilisateur;
import com.inti.TD3SpringActeur.repository.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService
{
	
	@Autowired
	UtilisateurRepository ur;

	@Override
	public void saveUtilisateur(Utilisateur utilisateur)
	{
		ur.save(utilisateur);		
	}

	@Override
	public Utilisateur findByLoginAndMdp(String login, String mdp)
	{
		return ur.findByLoginAndMdp(login, mdp);
	}

}
