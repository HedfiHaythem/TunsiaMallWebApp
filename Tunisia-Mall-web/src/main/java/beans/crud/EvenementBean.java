package beans.crud;

import java.io.File;
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

import org.primefaces.event.FileUploadEvent;

import com.esprit.entity.Evenement;
import com.esprit.entity.Utilisateur;
import com.esprit.service.UserServiceLocal;

import utility.Iutility;
import utility.Utility;



@SessionScoped
@ManagedBean(name = "EvenementBean")
public class EvenementBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserServiceLocal<Evenement>  ServiceEvenement;
	


	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */

	private List<Evenement> listEvenements ;
	private List<Evenement> listSelectedEvenements=new ArrayList<Evenement>() ;
	private List<Evenement> listFilterEvenements ;
	private Evenement Evenement;
	private List<String> listSTanlayses ;
	private List<String> listSelectedStEvenements ;
	
	private String txt1;

	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */
	@PostConstruct
	public void initialization() {
		
		
		setListEvenements(ServiceEvenement.findAll(new Evenement()));
		setListFilterEvenements(ServiceEvenement.findAll(new Evenement()));	
		Evenement=new Evenement();
			}

	
	
	

	public void fileUpload22(FileUploadEvent event) throws Exception {
		Iutility traitementImgText =new Utility(); 
		
		
		String path = FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("/");
		
		File file=traitementImgText.writeFile(event, "PublicImage/");
		
	
	
		
		
		Evenement.setImg(file.getName());
		// getNosFormulaire().setUrlPhotot("thumb"+file.getName());
		
		ServiceEvenement.update(Evenement);
		 initialization();
		FacesMessage msg = new FacesMessage("chargement avec succès ", event
				.getFile().getFileName() + " is uploaded.");

		FacesContext.getCurrentInstance().addMessage(null, msg);


	}

	

	 
	 
	 
	public void adding(Evenement ta) {
		ServiceEvenement.create(ta);
		initialization();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Enregistré(e) avec succés", "");
		FacesContext.getCurrentInstance().addMessage

		(null, msg);
	}
	

	/*----------------------------------------------------------------------------------------------------------*/
	public void updating(Evenement ta) {

		ServiceEvenement.update(ta);
		initialization();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"mis(e) à jour avec succés", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void removing(Evenement ta) {
		try {

			
			ServiceEvenement.delete(new Evenement(),"id",ta.getId()+"");
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







	public UserServiceLocal<Evenement> getServiceEvenement() {
		return ServiceEvenement;
	}







	public void setServiceEvenement(UserServiceLocal<Evenement> serviceEvenement) {
		this.ServiceEvenement = serviceEvenement;
	}







	public List<Evenement> getListEvenements() {
		return listEvenements;
	}







	public void setListEvenements(List<Evenement> listEvenements) {
		this.listEvenements = listEvenements;
	}







	public List<Evenement> getListSelectedEvenements() {
		return listSelectedEvenements;
	}







	public void setListSelectedEvenements(List<Evenement> listSelectedEvenements) {
		this.listSelectedEvenements = listSelectedEvenements;
	}







	public List<Evenement> getListFilterEvenements() {
		return listFilterEvenements;
	}







	public void setListFilterEvenements(List<Evenement> listFilterEvenements) {
		this.listFilterEvenements = listFilterEvenements;
	}







	public Evenement getEvenement() {
		return Evenement;
	}







	public void setEvenement(Evenement evenement) {
		this.Evenement = evenement;
	}







	public List<String> getListSTanlayses() {
		return listSTanlayses;
	}







	public void setListSTanlayses(List<String> listSTanlayses) {
		this.listSTanlayses = listSTanlayses;
	}







	public List<String> getListSelectedStEvenements() {
		return listSelectedStEvenements;
	}







	public void setListSelectedStEvenements(List<String> listSelectedStEvenements) {
		this.listSelectedStEvenements = listSelectedStEvenements;
	}







	public String getTxt1() {
		return txt1;
	}







	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}


	

}
