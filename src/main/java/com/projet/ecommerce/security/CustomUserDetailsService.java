package com.projet.ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.projet.ecommerce.entites.Utilisateur;
import com.projet.ecommerce.repository.UtilisateurRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private UtilisateurRepository userRepo;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
     return new CustomUserDetails(user);
    }

}
