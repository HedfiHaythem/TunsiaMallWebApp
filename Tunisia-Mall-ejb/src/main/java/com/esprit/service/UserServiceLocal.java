package com.esprit.service;

import java.util.List;

import javax.ejb.Local;

import com.esprit.comman.CommanServiceLocal;
import com.esprit.comman.CommanServiceRemote;
import com.esprit.entity.Categorie;
import com.esprit.entity.Utilisateur;

@Local
public interface UserServiceLocal<T> extends CommanServiceLocal<T>{

		Utilisateur auth(Object u);


}
