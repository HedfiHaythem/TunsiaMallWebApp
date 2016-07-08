package beans;



import java.io.Serializable;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.esprit.entity.Utilisateur;
import com.esprit.service.UserServiceLocal;

import utility.Iutility;
import utility.Utility;




@ViewScoped
@ManagedBean(name = "ProfileBean")
public class ProfileBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserServiceLocal<Utilisateur> serviceUser;




	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */
	public Utilisateur utilisateur = new Utilisateur();
	public Utilisateur utilisateur2 = new Utilisateur();


	
	private String email;
	private String idQualie;

	private Boolean ok;
	Iutility ut =new Utility();

	

	@PostConstruct
	public void initialization() {
	
		
		
		utilisateur = ut.getUserfromMapSession();
			
		
	}


	public void adding(Utilisateur user) {



		try {
	
			serviceUser.create(user);
			initialization();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Enregistré(e) avec succés", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Email existe déja !", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		
		}
	}




	/*----------------------------------------------------------------------------------------------------------*/
	public void updating(Utilisateur u) {
	
			serviceUser.update(u);
		
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"mis(e) à jour avec succés", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void removing(Utilisateur user) {
		try {

			serviceUser.delete(user);

		
			initialization();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Supprimé(e) avec succés", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
		
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Vous ne pouvez pas le supprimer Contacter l'adminisatrateur Systéme ", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */


	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdQualie() {
		return idQualie;
	}

	public void setIdQualie(String idQualie) {
		this.idQualie = idQualie;
	}

	public Boolean getOk() {
		return ok;
	}

	public void setOk(Boolean ok) {
		this.ok = ok;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Utilisateur getUtilisateur2() {
		return utilisateur2;
	}

	public void setUtilisateur2(Utilisateur utilisateur2) {
		this.utilisateur2 = utilisateur2;
	}


	public Iutility getUt() {
		return ut;
	}


	public void setUt(Iutility ut) {
		this.ut = ut;
	}


	public void setServiceUser(UserServiceLocal<Utilisateur> serviceUser) {
		this.serviceUser = serviceUser;
	}
}