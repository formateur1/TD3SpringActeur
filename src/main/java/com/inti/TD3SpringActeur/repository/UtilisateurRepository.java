package com.inti.TD3SpringActeur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.TD3SpringActeur.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>
{
	Utilisateur findByLoginAndMdp(String login, String mdp);
}
