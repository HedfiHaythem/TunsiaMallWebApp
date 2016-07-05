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
import com.esprit.entity.SecteurActivite;
import com.esprit.entity.Utilisateur;
import com.esprit.service.UserServiceLocal;



@SessionScoped
@ManagedBean(name = "SecteurActiviteBean")
public class SecteurActiviteBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserServiceLocal<SecteurActivite>  serviceSecteurActivite;
	


	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */

	private List<SecteurActivite> listSecteurActivites ;
	private List<SecteurActivite> listSelectedSecteurActivites=new ArrayList<SecteurActivite>() ;
	private List<SecteurActivite> listFilterSecteurActivites ;
	private SecteurActivite secteurActivite;
	private List<String> listSTanlayses ;
	private List<String> listSelectedStSecteurActivites ;
	
	private String txt1;

	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */
	@PostConstruct
	public void initialization() {
		
		setListSecteurActivites(serviceSecteurActivite.findAll(new SecteurActivite()));
		setListFilterSecteurActivites(serviceSecteurActivite.findAll(new SecteurActivite()));	
		secteurActivite=new SecteurActivite();
			}

	
	

	 
	 
	 
	public void adding(SecteurActivite ta) {
				serviceSecteurActivite.create(ta);
		initialization();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Enregistré(e) avec succés", "");
		FacesContext.getCurrentInstance().addMessage

		(null, msg);
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void updating(SecteurActivite ta) {

		serviceSecteurActivite.update(ta);
		initialization();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"mis(e) à jour avec succés", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void removing(SecteurActivite ta) {
		try {

			
			serviceSecteurActivite.delete(new SecteurActivite(),"id",ta.getId()+"");
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







	public UserServiceLocal<SecteurActivite> getServiceSecteurActivite() {
		return serviceSecteurActivite;
	}







	public void setServiceSecteurActivite(UserServiceLocal<SecteurActivite> serviceSecteurActivite) {
		this.serviceSecteurActivite = serviceSecteurActivite;
	}







	public List<SecteurActivite> getListSecteurActivites() {
		return listSecteurActivites;
	}







	public void setListSecteurActivites(List<SecteurActivite> listSecteurActivites) {
		this.listSecteurActivites = listSecteurActivites;
	}







	public List<SecteurActivite> getListSelectedSecteurActivites() {
		return listSelectedSecteurActivites;
	}







	public void setListSelectedSecteurActivites(List<SecteurActivite> listSelectedSecteurActivites) {
		this.listSelectedSecteurActivites = listSelectedSecteurActivites;
	}







	public List<SecteurActivite> getListFilterSecteurActivites() {
		return listFilterSecteurActivites;
	}







	public void setListFilterSecteurActivites(List<SecteurActivite> listFilterSecteurActivites) {
		this.listFilterSecteurActivites = listFilterSecteurActivites;
	}







	public SecteurActivite getSecteurActivite() {
		return secteurActivite;
	}







	public void setSecteurActivite(SecteurActivite secteurActivite) {
		this.secteurActivite = secteurActivite;
	}







	public List<String> getListSTanlayses() {
		return listSTanlayses;
	}







	public void setListSTanlayses(List<String> listSTanlayses) {
		this.listSTanlayses = listSTanlayses;
	}







	public List<String> getListSelectedStSecteurActivites() {
		return listSelectedStSecteurActivites;
	}







	public void setListSelectedStSecteurActivites(List<String> listSelectedStSecteurActivites) {
		this.listSelectedStSecteurActivites = listSelectedStSecteurActivites;
	}







	public String getTxt1() {
		return txt1;
	}







	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}


	

}
