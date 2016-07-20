package beans;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.esprit.entity.Categorie;
import com.esprit.entity.Produit;
import com.esprit.entity.SecteurActivite;
import com.esprit.entity.SousCategorie;
import com.esprit.service.UserServiceLocal;



@SessionScoped
@ManagedBean(name = "ProduitBean")
public class ProduitBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserServiceLocal<Produit>  serviceProduit;
	@EJB
	private UserServiceLocal<SecteurActivite>  serviceSecteurActivite;
	@EJB
	private UserServiceLocal<Categorie>  serviceCategorie;
	@EJB
	private UserServiceLocal<SousCategorie>  serviceSousCategorie;
	
	private List<Produit> listProduits ;
	private List<Produit> listSelectedProduits=new ArrayList<Produit>() ;
	private List<Produit> listFilterProduits ;
	private Produit produit;
	private List<String> listSTanlayses ;
	private List<String> listSelectedStProduits ;
	
	private String txt1;

	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */
	@PostConstruct
	public void initialization() {
		
		setListProduits(serviceProduit.findAll(new Produit()));
		setListFilterProduits(serviceProduit.findAll(new Produit()));	
		produit=new Produit();
			}
	 
	public void adding(Produit ta) {
				serviceProduit.create(ta);
		initialization();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Enregistr�(e) avec succ�s", "");
		FacesContext.getCurrentInstance().addMessage

		(null, msg);
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void updating(Produit ta) {

		serviceProduit.update(ta);
		initialization();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"mis(e) � jour avec succ�s", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void removing(Produit ta) {
		try {
			serviceProduit.delete(new Produit(),"id",ta.getId()+"");
			initialization();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Supprim�(e) avec succ�s", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			initialization();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"La Marque est encore utilisable", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public UserServiceLocal<Produit> getServiceProduit() {
		return serviceProduit;
	}

	public void setServiceProduit(UserServiceLocal<Produit> serviceProduit) {
		this.serviceProduit = serviceProduit;
	}


	public List<Produit> getListProduits() {
		return listProduits;
	}


	public void setListProduits(List<Produit> listProduits) {
		this.listProduits = listProduits;
	}


	public List<Produit> getListSelectedProduits() {
		return listSelectedProduits;
	}


	public void setListSelectedProduits(List<Produit> listSelectedProduits) {
		this.listSelectedProduits = listSelectedProduits;
	}


	public List<Produit> getListFilterProduits() {
		return listFilterProduits;
	}

	public void setListFilterProduits(List<Produit> listFilterProduits) {
		this.listFilterProduits = listFilterProduits;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public List<String> getListSTanlayses() {
		return listSTanlayses;
	}

	public void setListSTanlayses(List<String> listSTanlayses) {
		this.listSTanlayses = listSTanlayses;
	}

	public List<String> getListSelectedStProduits() {
		return listSelectedStProduits;
	}

	public void setListSelectedStProduits(List<String> listSelectedStProduits) {
		this.listSelectedStProduits = listSelectedStProduits;
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}
	
	public ArrayList<Categorie> getCategorie(SecteurActivite secteurActivite)
	{
		return  serviceCategorie.findReqList(new Categorie(), "secteurActivite.id = "+secteurActivite.getId());
	}
	public ArrayList<SousCategorie> getSousCategorie(Categorie categorie)
	{
		return  serviceSousCategorie.findReqList(new SousCategorie(), "categorie.id = "+categorie.getId());
	}
	public ArrayList<Produit> getProduct(SousCategorie sousCategorie){
		
		return  serviceProduit.findReqList(new Produit(), "categorie.id = "+sousCategorie.getId()+" LIMIT 3");
		
	}
}