package com.inti.TD3SpringActeur.service;

import com.inti.TD3SpringActeur.model.Utilisateur;

public interface UtilisateurService
{
	void saveUtilisateur(Utilisateur utilisateur);
	Utilisateur findByLoginAndMdp(String login, String mdp);
}
