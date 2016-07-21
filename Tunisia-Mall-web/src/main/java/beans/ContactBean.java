package beans;

import java.io.IOException;
import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.esprit.comman.CommanServiceLocal;
import com.esprit.entity.Categorie;
import com.esprit.entity.Contact;
import com.esprit.entity.SecteurActivite;
import com.esprit.mail.ConfigUtility;
import com.esprit.mail.EmailUtility;



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
	 

	private ConfigUtility configUtil = new ConfigUtility();
	public void adding(Contact ta) {
		
		
			Properties smtpProperties;
			try {
				smtpProperties = configUtil.loadProperties();
				EmailUtility.sendEmail(smtpProperties, "aymenbraiek0@gmail.com", "Contact", "quelque vient de te contacter ", null);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
	
	
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
