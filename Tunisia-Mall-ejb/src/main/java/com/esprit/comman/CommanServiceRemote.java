package com.esprit.comman;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;


@Remote
public interface CommanServiceRemote<T> {
	void create(T o);
	Object req(T o ,String req);
	Object findById(T o, String field,String id);
	ArrayList <T> findAll(T o);
	ArrayList<T> findReqList(Object o, String req);
	void delete(T o,String field,String id);
	void delete(T o);
	void update(T o);

}
