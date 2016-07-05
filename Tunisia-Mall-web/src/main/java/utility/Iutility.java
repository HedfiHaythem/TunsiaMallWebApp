package utility;

import java.io.File;
import java.io.IOException;

import org.primefaces.event.FileUploadEvent;

import com.esprit.entity.Utilisateur;

public interface Iutility {

	File writeFile(FileUploadEvent event, String emplacement) throws IOException;

	boolean Removefile(String url);

	Utilisateur getUserfromMapSession();

	String DetrminerExtension(String urlFile);

	void SetUserSessionBean(Object u);

}
