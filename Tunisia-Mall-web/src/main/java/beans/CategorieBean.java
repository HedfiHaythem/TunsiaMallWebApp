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



@SessionScoped
@ManagedBean(name = "CategorieBean")
public class CategorieBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private CommanServiceLocal<Categorie>  serviceCategorie;
	
	@EJB
	private CommanServiceLocal<SecteurActivite>  serviceSecteurActivite;

	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */
	private List<SecteurActivite> listSecteurActivites ;
	private List<Categorie> listCategories ;
	private List<Categorie> listSelectedCategories=new ArrayList<Categorie>() ;
	private List<Categorie> listFilterCategories ;
	private Categorie categorie;
	private List<String> listSelectedStCategories ;
	
	private String txt1;

	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */
	@PostConstruct
	public void initialization() {
		
		setListSecteurActivites(serviceSecteurActivite.findAll(new SecteurActivite()));
	
		setListCategories(serviceCategorie.findAll(new Categorie()));
		setListFilterCategories(serviceCategorie.findAll(new Categorie()));	
		categorie=new Categorie();
			}

	
	

	 
	 
	 
	public void adding(Categorie ta) {
				serviceCategorie.create(ta);
		initialization();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Enregistré(e) avec succés", "");
		FacesContext.getCurrentInstance().addMessage

		(null, msg);
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void updating(Categorie ta) {

		serviceCategorie.update(ta);
		initialization();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"mis(e) à jour avec succés", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void removing(Categorie ta) {
		try {

			System.out.println(ta.getId());
			serviceCategorie.delete(new Categorie(),"id",ta.getId()+"");
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



















	public List<Categorie> getListCategories() {
		return listCategories;
	}







	public void setListCategories(List<Categorie> listCategories) {
		this.listCategories = listCategories;
	}







	public List<Categorie> getListSelectedCategories() {
		return listSelectedCategories;
	}







	public void setListSelectedCategories(List<Categorie> listSelectedCategories) {
		this.listSelectedCategories = listSelectedCategories;
	}







	public List<Categorie> getListFilterCategories() {
		return listFilterCategories;
	}







	public void setListFilterCategories(List<Categorie> listFilterCategories) {
		this.listFilterCategories = listFilterCategories;
	}







	public Categorie getCategorie() {
		return categorie;
	}







	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}












	public List<String> getListSelectedStCategories() {
		return listSelectedStCategories;
	}







	public void setListSelectedStCategories(List<String> listSelectedStCategories) {
		this.listSelectedStCategories = listSelectedStCategories;
	}







	public String getTxt1() {
		return txt1;
	}







	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}







	public CommanServiceLocal<Categorie> getServiceCategorie() {
		return serviceCategorie;
	}







	public void setServiceCategorie(CommanServiceLocal<Categorie> serviceCategorie) {
		this.serviceCategorie = serviceCategorie;
	}







	public CommanServiceLocal<SecteurActivite> getServiceSecteurActivite() {
		return serviceSecteurActivite;
	}







	public void setServiceSecteurActivite(CommanServiceLocal<SecteurActivite> serviceSecteurActivite) {
		this.serviceSecteurActivite = serviceSecteurActivite;
	}







	public List<SecteurActivite> getListSecteurActivites() {
		return listSecteurActivites;
	}







	public void setListSecteurActivites(List<SecteurActivite> listSecteurActivites) {
		this.listSecteurActivites = listSecteurActivites;
	}


	

}
