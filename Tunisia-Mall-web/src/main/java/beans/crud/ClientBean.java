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
import com.esprit.entity.Client;
import com.esprit.entity.Utilisateur;
import com.esprit.service.UserServiceLocal;



@SessionScoped
@ManagedBean(name = "ClientBean")
public class ClientBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserServiceLocal<Client>  serviceClient;
	
	@EJB
	private CommanServiceLocal<SecteurActivite> serviceSecteurActivite;

	@EJB
	private CommanServiceLocal<Boutique> serviceBoutique;

	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */

	private List<Client> listClients ;
	private List<Client> listSelectedClients=new ArrayList<Client>() ;

	private Client client;
	private List<String> listSTanlayses ;
	private List<String> listSelectedStClients ;
	private List<SecteurActivite> listSecteurActivite ;
	private List<Boutique> listBoutique;
	private String txt1;

	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */
	@PostConstruct
	public void initialization() {
		
		setListClients(serviceClient.findAll(new Client()));
		client=new Client();
			}

	
	

	 
	 
	 
	public void adding(Client ta) {
				serviceClient.create(ta);
		initialization();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Enregistré avec succés", "");
		FacesContext.getCurrentInstance().addMessage

		(null, msg);
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void updating(Client ta) {

		serviceClient.update(ta);
		initialization();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"mis(e) � jour avec succ�s", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void removing(Client ta) {
		try {

			System.out.println(ta.getId());
			serviceClient.delete(new Client(),"id",ta.getId()+"");
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







	public UserServiceLocal<Client> getServiceClient() {
		return serviceClient;
	}







	public void setServiceClient(UserServiceLocal<Client> serviceClient) {
		this.serviceClient = serviceClient;
	}







	public List<Client> getListClients() {
		return listClients;
	}







	public void setListClients(List<Client> listClients) {
		this.listClients = listClients;
	}







	public List<Client> getListSelectedClients() {
		return listSelectedClients;
	}







	public void setListSelectedClients(List<Client> listSelectedClients) {
		this.listSelectedClients = listSelectedClients;
	}











	public Client getClient() {
		return client;
	}







	public void setClient(Client client) {
		this.client = client;
	}







	public List<String> getListSTanlayses() {
		return listSTanlayses;
	}







	public void setListSTanlayses(List<String> listSTanlayses) {
		this.listSTanlayses = listSTanlayses;
	}







	public List<String> getListSelectedStClients() {
		return listSelectedStClients;
	}







	public void setListSelectedStClients(List<String> listSelectedStClients) {
		this.listSelectedStClients = listSelectedStClients;
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
