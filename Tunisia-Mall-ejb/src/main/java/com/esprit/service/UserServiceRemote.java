package com.esprit.service;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.comman.CommanServiceLocal;
import com.esprit.comman.CommanServiceRemote;
import com.esprit.entity.Categorie;
import com.esprit.entity.Utilisateur;
 

@Remote
public interface UserServiceRemote<T> extends CommanServiceRemote<T> {
	

	Utilisateur auth(Object u);


}
