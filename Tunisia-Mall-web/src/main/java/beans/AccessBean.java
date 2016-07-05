package beans;

import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.esprit.entity.SuperAdmin;
import com.esprit.entity.Utilisateur;
import com.esprit.service.UserServiceLocal;


@ManagedBean( name="access")
@RequestScoped
public class AccessBean {
	
	@EJB
	private UserServiceLocal<Utilisateur> authentificationServiceLocal;
	

	
	private String email;
	private String password;
	
	public String name(){
		
		return "xxx :"+authentificationServiceLocal.findAll(new SuperAdmin()).size();
	}
	
	public String doLogin(){
		String navigateTo="";
		SuperAdmin u = new SuperAdmin();
		u.setLogin(email);
		u.setPassword(password);
		
		SuperAdmin found = (SuperAdmin) authentificationServiceLocal.auth(u);

		if (found instanceof SuperAdmin) {
			
			 try{
					ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
					Map<String, Object> sessionMap = externalContext.getSessionMap();
				 sessionMap.put("user", found);
				 }catch(Exception e){
					 
					 
				 }
				navigateTo = "/WebFrontOffice/Page/MonProfile/Profile.xhtml?faces-redirect=true";
			}
			
		else {
			FacesContext
			.getCurrentInstance()
			.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"NON AUTORISE",
					null
					
			));
		}
		return navigateTo;
	}
	public AccessBean() {
	}

	public String getEmail() {
		return email;
	}
	
	
	public String doLogout(){
		String navigateTo = null;
		FacesContext
		.getCurrentInstance()
		.getExternalContext()
		.getSessionMap()
		.clear();
		navigateTo = "/login?faces-redirect=true";
		return navigateTo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public UserServiceLocal<Utilisateur> getAuthentificationServiceLocal() {
		return authentificationServiceLocal;
	}

	public void setAuthentificationServiceLocal(UserServiceLocal<Utilisateur> authentificationServiceLocal) {
		this.authentificationServiceLocal = authentificationServiceLocal;
	}
	


}
