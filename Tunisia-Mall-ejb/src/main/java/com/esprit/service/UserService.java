package com.esprit.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.comman.CommanService;
import com.esprit.entity.SuperAdmin;
import com.esprit.entity.Categorie;
import com.esprit.entity.Utilisateur;

@Stateless
public class UserService<T> extends CommanService<T> implements UserServiceLocal,UserServiceRemote{



	@Override
	public Utilisateur auth(Object u) {
		
		try {
			return (Utilisateur) req(u, " c.login='"+((Utilisateur) u).getLogin()+"' and  c.password='"+((Utilisateur) u).getPassword()+"' and c.enabled='1' ");
		} catch (Exception e) {
			return null;
		}
	}



	
	
}
