package com.projet.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.ecommerce.entites.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	@Query("SELECT u FROM Utilisateur u WHERE u.email = ?1")
    public Utilisateur findByEmail(String email);
}
