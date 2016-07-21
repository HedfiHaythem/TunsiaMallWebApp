package beans;

import java.io.File;
import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import com.esprit.entity.Boutique;
import com.esprit.service.UserServiceLocal;

import utility.Iutility;
import utility.Utility;



@SessionScoped
@ManagedBean(name = "BoutiqueBean")
public class BoutiqueBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserServiceLocal<Boutique>  serviceBoutique;
	
	
	private List<Boutique> listBoutiques ;
	private List<Boutique> listSelectedBoutiques=new ArrayList<Boutique>() ;
	private List<Boutique> listFilterBoutiques ;
	private Boutique boutique;
	private List<String> listSTanlayses ;
	private List<String> listSelectedStBoutiques ;
	
	private String txt1;


	@PostConstruct
	public void initialization() {
		
		setListBoutiques(serviceBoutique.findAll(new Boutique()));
		setListFilterBoutiques(serviceBoutique.findAll(new Boutique()));	
		boutique=new Boutique();
			}

	

	public void fileUpload22(FileUploadEvent event) throws Exception {
		Iutility traitementImgText =new Utility(); 
		
		
		String path = FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("/");
		
		File file=traitementImgText.writeFile(event, "PublicImage/");
		
	
	
		
		
		boutique.setImg(file.getName());
		// getNosFormulaire().setUrlPhotot("thumb"+file.getName());
		
		serviceBoutique.update(boutique);
		 initialization();
		FacesMessage msg = new FacesMessage("chargement avec succès ", event
				.getFile().getFileName() + " is uploaded.");

		FacesContext.getCurrentInstance().addMessage(null, msg);


	}

	
	public void adding(Boutique ta) {
				serviceBoutique.create(ta);
		initialization();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Enregistré(e) avec succés", "");
		FacesContext.getCurrentInstance().addMessage

		(null, msg);
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void updating(Boutique ta) {

		serviceBoutique.update(ta);
		initialization();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"mis(e) à jour avec succés", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void removing(Boutique ta) {
		try {

			
			serviceBoutique.delete(new Boutique(),"id",ta.getId()+"");
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







	public UserServiceLocal<Boutique> getServiceBoutique() {
		return serviceBoutique;
	}







	public void setServiceBoutique(UserServiceLocal<Boutique> serviceBoutique) {
		this.serviceBoutique = serviceBoutique;
	}







	public List<Boutique> getListBoutiques() {
		return listBoutiques;
	}







	public void setListBoutiques(List<Boutique> listBoutiques) {
		this.listBoutiques = listBoutiques;
	}







	public List<Boutique> getListSelectedBoutiques() {
		return listSelectedBoutiques;
	}







	public void setListSelectedBoutiques(List<Boutique> listSelectedBoutiques) {
		this.listSelectedBoutiques = listSelectedBoutiques;
	}







	public List<Boutique> getListFilterBoutiques() {
		return listFilterBoutiques;
	}







	public void setListFilterBoutiques(List<Boutique> listFilterBoutiques) {
		this.listFilterBoutiques = listFilterBoutiques;
	}







	public Boutique getBoutique() {
		return boutique;
	}







	public void setBoutique(Boutique boutique) {
		this.boutique = boutique;
	}







	public List<String> getListSTanlayses() {
		return listSTanlayses;
	}







	public void setListSTanlayses(List<String> listSTanlayses) {
		this.listSTanlayses = listSTanlayses;
	}







	public List<String> getListSelectedStBoutiques() {
		return listSelectedStBoutiques;
	}







	public void setListSelectedStBoutiques(List<String> listSelectedStBoutiques) {
		this.listSelectedStBoutiques = listSelectedStBoutiques;
	}







	public String getTxt1() {
		return txt1;
	}







	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}


	

}
