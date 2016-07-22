package beans.crud;

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

import com.esprit.comman.CommanServiceLocal;
import com.esprit.entity.Boutique;
import com.esprit.entity.SecteurActivite;
import com.esprit.entity.ShopOwner;
import com.esprit.entity.Utilisateur;
import com.esprit.service.UserServiceLocal;



@SessionScoped
@ManagedBean(name = "ShopOwnerBean")
public class ShopOwnerBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserServiceLocal<ShopOwner>  serviceShopOwner;
	
	@EJB
	private CommanServiceLocal<SecteurActivite> serviceSecteurActivite;

	@EJB
	private CommanServiceLocal<Boutique> serviceBoutique;

	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */

	private List<ShopOwner> listShopOwners ;
	private List<ShopOwner> listSelectedShopOwners=new ArrayList<ShopOwner>() ;

	private ShopOwner shopOwner;
	private List<String> listSTanlayses ;
	private List<String> listSelectedStShopOwners ;
	private List<SecteurActivite> listSecteurActivite ;
	private List<Boutique> listBoutique;
	private String txt1;

	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */
	@PostConstruct
	public void initialization() {
		
		setListShopOwners(serviceShopOwner.findAll(new ShopOwner()));
		listSecteurActivite=serviceSecteurActivite.findAll(new SecteurActivite());
		listBoutique=serviceBoutique.findAll(new Boutique());
		
		shopOwner=new ShopOwner();
			}

	
	

	 
	 
	 
	public void adding(ShopOwner ta) {
				serviceShopOwner.create(ta);
		initialization();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Enregistré(e) avec succés", "");
		FacesContext.getCurrentInstance().addMessage

		(null, msg);
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void updating(ShopOwner ta) {

		serviceShopOwner.update(ta);
		initialization();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"mis(e) à jour avec succés", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void removing(ShopOwner ta) {
		try {

			System.out.println(ta.getId());
			serviceShopOwner.delete(new ShopOwner(),"id",ta.getId()+"");
			initialization();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Supprimé(e) avec succés", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			initialization();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"La Marque est encore utilisable", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}







	public UserServiceLocal<ShopOwner> getServiceShopOwner() {
		return serviceShopOwner;
	}







	public void setServiceShopOwner(UserServiceLocal<ShopOwner> serviceShopOwner) {
		this.serviceShopOwner = serviceShopOwner;
	}







	public List<ShopOwner> getListShopOwners() {
		return listShopOwners;
	}







	public void setListShopOwners(List<ShopOwner> listShopOwners) {
		this.listShopOwners = listShopOwners;
	}







	public List<ShopOwner> getListSelectedShopOwners() {
		return listSelectedShopOwners;
	}







	public void setListSelectedShopOwners(List<ShopOwner> listSelectedShopOwners) {
		this.listSelectedShopOwners = listSelectedShopOwners;
	}











	public ShopOwner getShopOwner() {
		return shopOwner;
	}







	public void setShopOwner(ShopOwner shopOwner) {
		this.shopOwner = shopOwner;
	}







	public List<String> getListSTanlayses() {
		return listSTanlayses;
	}







	public void setListSTanlayses(List<String> listSTanlayses) {
		this.listSTanlayses = listSTanlayses;
	}







	public List<String> getListSelectedStShopOwners() {
		return listSelectedStShopOwners;
	}







	public void setListSelectedStShopOwners(List<String> listSelectedStShopOwners) {
		this.listSelectedStShopOwners = listSelectedStShopOwners;
	}







	public String getTxt1() {
		return txt1;
	}







	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}







	public List<SecteurActivite> getListSecteurActivite() {
		return listSecteurActivite;
	}







	public void setListSecteurActivite(List<SecteurActivite> listSecteurActivite) {
		this.listSecteurActivite = listSecteurActivite;
	}







	public List<Boutique> getListBoutique() {
		return listBoutique;
	}







	public void setListBoutique(List<Boutique> listBoutique) {
		this.listBoutique = listBoutique;
	}







	public CommanServiceLocal<SecteurActivite> getServiceSecteurActivite() {
		return serviceSecteurActivite;
	}







	public void setServiceSecteurActivite(CommanServiceLocal<SecteurActivite> serviceSecteurActivite) {
		this.serviceSecteurActivite = serviceSecteurActivite;
	}







	public CommanServiceLocal<Boutique> getServiceBoutique() {
		return serviceBoutique;
	}







	public void setServiceBoutique(CommanServiceLocal<Boutique> serviceBoutique) {
		this.serviceBoutique = serviceBoutique;
	}


	

}
