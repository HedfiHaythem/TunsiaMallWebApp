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

import com.esprit.comman.CommanServiceLocal;
import com.esprit.entity.Boutique;
import com.esprit.entity.SecteurActivite;
import com.esprit.entity.SuperAdmin;
import com.esprit.entity.Utilisateur;
import com.esprit.service.UserServiceLocal;



@SessionScoped
@ManagedBean(name = "SuperAdminBean")
public class SuperAdminBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserServiceLocal<SuperAdmin>  serviceSuperAdmin;
	
	@EJB
	private CommanServiceLocal<SecteurActivite> serviceSecteurActivite;

	@EJB
	private CommanServiceLocal<Boutique> serviceBoutique;

	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */

	private List<SuperAdmin> listSuperAdmins ;
	private List<SuperAdmin> listSelectedSuperAdmins=new ArrayList<SuperAdmin>() ;

	private SuperAdmin superAdmin;
	private List<String> listSTanlayses ;
	private List<String> listSelectedStSuperAdmins ;
	private List<SecteurActivite> listSecteurActivite ;
	private List<Boutique> listBoutique;
	private String txt1;

	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */
	@PostConstruct
	public void initialization() {
		
		setListSuperAdmins(serviceSuperAdmin.findAll(new SuperAdmin()));
		superAdmin=new SuperAdmin();
			}

	
	

	 
	 
	 
	public void adding(SuperAdmin ta) {
				serviceSuperAdmin.create(ta);
		initialization();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Enregistré(e) avec succés", "");
		FacesContext.getCurrentInstance().addMessage

		(null, msg);
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void updating(SuperAdmin ta) {

		serviceSuperAdmin.update(ta);
		initialization();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"mis(e) à jour avec succés", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void removing(SuperAdmin ta) {
		try {

			System.out.println(ta.getId());
			serviceSuperAdmin.delete(new SuperAdmin(),"id",ta.getId()+"");
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







	public UserServiceLocal<SuperAdmin> getServiceSuperAdmin() {
		return serviceSuperAdmin;
	}







	public void setServiceSuperAdmin(UserServiceLocal<SuperAdmin> serviceSuperAdmin) {
		this.serviceSuperAdmin = serviceSuperAdmin;
	}







	public List<SuperAdmin> getListSuperAdmins() {
		return listSuperAdmins;
	}







	public void setListSuperAdmins(List<SuperAdmin> listSuperAdmins) {
		this.listSuperAdmins = listSuperAdmins;
	}







	public List<SuperAdmin> getListSelectedSuperAdmins() {
		return listSelectedSuperAdmins;
	}







	public void setListSelectedSuperAdmins(List<SuperAdmin> listSelectedSuperAdmins) {
		this.listSelectedSuperAdmins = listSelectedSuperAdmins;
	}











	public SuperAdmin getSuperAdmin() {
		return superAdmin;
	}







	public void setSuperAdmin(SuperAdmin superAdmin) {
		this.superAdmin = superAdmin;
	}







	public List<String> getListSTanlayses() {
		return listSTanlayses;
	}







	public void setListSTanlayses(List<String> listSTanlayses) {
		this.listSTanlayses = listSTanlayses;
	}







	public List<String> getListSelectedStSuperAdmins() {
		return listSelectedStSuperAdmins;
	}







	public void setListSelectedStSuperAdmins(List<String> listSelectedStSuperAdmins) {
		this.listSelectedStSuperAdmins = listSelectedStSuperAdmins;
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
