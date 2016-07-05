package com.esprit.comman;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.entity.Boutique;



@Stateless
public class CommanService<T> implements CommanServiceLocal,CommanServiceRemote{

	
	@PersistenceContext
    EntityManager em;

	@Override
	public void create(Object o) {
		
		em.persist(o);
		
	}

	@Override
	public Object req(Object o, String req) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				return em.createQuery("select c from   "+o.getClass().getSimpleName()+" c where "+req).getSingleResult();

	}

	
	@Override
	public ArrayList<T> findReqList(Object o, String req) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				return (ArrayList<T>) em.createQuery("select c from   "+o.getClass().getSimpleName()+" c where "+req).getResultList();

	}

	
	@Override
	public Object findById(Object o, String field,String id) {
		// TODO Auto-generated method stub
		return em.createQuery("select c from "+o.getClass().getSimpleName()+" c where c."+field+"="+id).getSingleResult();
	}

	@Override
	public ArrayList<Object> findAll(Object o) {
		
		return (ArrayList<Object>) em.createQuery("Select u from "+o.getClass().getSimpleName()+" u",o.getClass()).getResultList();

	}

	@Override
	public void delete(Object o,String field,String id) {
		em.remove(findById(o,field,id));
		
	}
	
	@Override
	public void delete(Object o) {
		em.remove(o);
		
	}

	@Override
	public void update(Object o) {
		em.merge(o);
		
	}
	
	


}
