package bean.login;

import java.io.IOException;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.esprit.entity.Client;
import com.esprit.entity.ShopOwner;
import com.esprit.entity.SuperAdmin;
import com.esprit.entity.Utilisateur;
import com.esprit.service.UserServiceLocal;

@ManagedBean(name = "access")
@SessionScoped
public class AccessBean {

	@EJB
	private UserServiceLocal<Utilisateur> authentificationServiceLocal;

	FacesContext fc = FacesContext.getCurrentInstance();
	ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();

	public void redirect() throws IOException {
		System.out.println(connect());
		if (!connect()) {
			nav.performNavigation("/Web/PublicPage/Login/login?faces-redirect=true");// add
																					// your
																					// URL
																					// here,
																					// instead
																					// of
																					// list.do
		}
	}

	private String email;
	private String password;

	public String name() {

		return "xxx :" + authentificationServiceLocal.findAll(new SuperAdmin()).size();
	}

	String navigateTo = "/Web/FrontOffice/Login/Login.xhtml?faces-redirect=true";
	SuperAdmin u = new SuperAdmin();
	ShopOwner shopOwner = new ShopOwner();
	Client client = new Client();
	SuperAdmin found;
	ShopOwner found1;
	Client found2;

	public boolean connect() {

		u.setLogin(email);
		u.setPassword(password);

		shopOwner.setLogin(email);
		shopOwner.setPassword(password);

		client.setLogin(email);
		client.setPassword(password);

		found = (SuperAdmin) authentificationServiceLocal.auth(u);

		found1 = (ShopOwner) authentificationServiceLocal.auth(shopOwner);

		found2 = (Client) authentificationServiceLocal.auth(client);

		if (found instanceof SuperAdmin || found1 instanceof ShopOwner || found2 instanceof Client)
			return true;
		else
			return false;
	}

	public String doLogin() {

		if (connect()) {

			try {
				ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
				Map<String, Object> sessionMap = externalContext.getSessionMap();
				sessionMap.put("superAdmin", found);
				sessionMap.put("shopOwner", found1);
				sessionMap.put("client", found2);
			} catch (Exception e) {

			}
			navigateTo = "/Web/FrontOffice/home/HomePage.xhtml?faces-redirect=true";
		}

		else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "NON AUTORISE", null

					));
		}
		return navigateTo;
	}

	public AccessBean() {
	}

	public String getEmail() {
		return email;
	}

	public String doLogout() {
		String navigateTo = null;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		navigateTo = "/Web/FrontOffice/home/HomePage.xhtml?faces-redirect=true";
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
