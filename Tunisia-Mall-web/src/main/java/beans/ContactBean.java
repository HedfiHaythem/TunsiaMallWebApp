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
import com.esprit.entity.Contact;
import com.esprit.entity.SecteurActivite;



@SessionScoped
@ManagedBean(name = "ContactBean")
public class ContactBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CommanServiceLocal<Contact>  serviceContact;

	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */

	private Contact contact;


	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */
	@PostConstruct
	public void initialization() {
		
			setContact(new Contact());
			}
	 
	 
	public void adding(Contact ta) {
		serviceContact.create(ta);
		initialization();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Votre message a bien été envoyé, nous le traiterons dans les plus brefs délais.", "");
		FacesContext.getCurrentInstance().addMessage

		(null, msg);
	}


	public Contact getContact() {
		return contact;
	}


	public void setContact(Contact contact) {
		this.contact = contact;
	}


}
