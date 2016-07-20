package beans;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.esprit.comman.CommanServiceLocal;
import com.esprit.entity.Categorie;

import com.esprit.entity.SecteurActivite;
import com.esprit.entity.ShopOwner;
import com.esprit.entity.SousCategorie;

import utility.Iutility;
import utility.Utility;




@SessionScoped
@ManagedBean(name = "SousCategorieBean")
public class SousCategorieBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private CommanServiceLocal<SousCategorie>  serviceSousCategorie;
	
	@EJB
	private CommanServiceLocal<Categorie>  serviceCategorie;

	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */
	private List<Categorie> listCategorie ;
	private List<SousCategorie> listSousCategories ;
	private List<SousCategorie> listSelectedSousCategories = new ArrayList<SousCategorie>() ;
	private List<SousCategorie> listFilterSousCategories ;
	private SousCategorie sousCategorie;
	private List<String> listSelectedStSousCategories ;
	private List<SousCategorie> listSousCategoriesByCategory = new ArrayList<SousCategorie>() ;
	
	private String txt1;

	 private Iutility ut =new Utility();

	private ShopOwner shopOwner;


	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */
	@PostConstruct
	public void initialization() 
	{
		shopOwner = (ShopOwner) ut.getUserfromMapSession();
		setListCategorie(serviceCategorie.findAll(new Categorie()));
	
		setListSousCategories(serviceSousCategorie.findAll(new SousCategorie()));
		setListFilterSousCategories(serviceSousCategorie.findAll(new SousCategorie()));	
				
		sousCategorie=new SousCategorie();
	}

	
	

	 
	 
	 
	public void adding(SousCategorie ta) {
		ta.setShopOwner(shopOwner);
		serviceSousCategorie.create(ta);
		initialization();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Enregistre avec succes", "");
		FacesContext.getCurrentInstance().addMessage

		(null, msg);
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void updating(SousCategorie ta) {
		ta.setShopOwner(shopOwner);
		serviceSousCategorie.update(ta);
		initialization();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"mise jour avec succes", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void removing(SousCategorie ta) {
		try {

			System.out.println(ta.getId());
			serviceSousCategorie.delete(new SousCategorie(),"id",ta.getId()+"");
			initialization();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Supprime avec succes", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			initialization();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"La Marque est encore utilisable", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	ArrayList<SousCategorie> a;


	public ArrayList<SousCategorie> getCategorie(Categorie categorie){
		
		return  serviceSousCategorie.findReqList(new SousCategorie(), "categorie.id = "+categorie.getId());
		
	}









	public String getTxt1() {
		return txt1;
	}







	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}







	public CommanServiceLocal<SousCategorie> getServiceCategorie() {
		return serviceSousCategorie;
	}







	public void setServiceCategorie(CommanServiceLocal<SousCategorie> serviceSousCategorie) {
		this.serviceSousCategorie = serviceSousCategorie;
	}

















	public List<SousCategorie> getListSelectedSousCategories() {
		return listSelectedSousCategories;
	}







	public void setListSelectedSousCategories(List<SousCategorie> listSelectedSousCategories) {
		this.listSelectedSousCategories = listSelectedSousCategories;
	}







	public List<SousCategorie> getListFilterSousCategories() {
		return listFilterSousCategories;
	}







	public void setListFilterSousCategories(List<SousCategorie> listFilterSousCategories) {
		this.listFilterSousCategories = listFilterSousCategories;
	}







	public SousCategorie getSousCategorie() {
		return sousCategorie;
	}







	public void setSousCategorie(SousCategorie sousCategorie) {
		this.sousCategorie = sousCategorie;
	}







	public List<String> getListSelectedStSousCategories() {
		return listSelectedStSousCategories;
	}







	public void setListSelectedStSousCategories(List<String> listSelectedStSousCategories) {
		this.listSelectedStSousCategories = listSelectedStSousCategories;
	}







	public List<Categorie> getListCategorie() {
		return listCategorie;
	}







	public void setListCategorie(List<Categorie> listCategorie) {
		this.listCategorie = listCategorie;
	}







	public List<SousCategorie> getListSousCategories() {
		return listSousCategories;
	}







	public void setListSousCategories(List<SousCategorie> listSousCategories) {
		this.listSousCategories = listSousCategories;
	}







	public List<SousCategorie> getListSousCategoriesByCategory() {
		return listSousCategoriesByCategory;
	}







	public ArrayList<SousCategorie> getA() {
		return a;
	}







	public void setA(ArrayList<SousCategorie> a) {
		this.a = a;
	}







	public void setListSousCategoriesByCategory(List<SousCategorie> listSousCategoriesByCategory) {
		this.listSousCategoriesByCategory = listSousCategoriesByCategory;
	}









	

}
