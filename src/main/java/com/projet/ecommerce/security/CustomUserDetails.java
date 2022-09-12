package com.projet.ecommerce.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.projet.ecommerce.entites.Utilisateur;

public class CustomUserDetails implements UserDetails {

	
	private Utilisateur u;
	
	public CustomUserDetails(Utilisateur user) {
        this.u = user;
    }
 
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return u.getMotdepasse();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return u.getPrenom();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getFullName() {
        return u.getNom() + " " + u.getPrenom();
    }
}
