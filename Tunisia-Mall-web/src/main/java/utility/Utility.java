package utility;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;


import org.primefaces.event.FileUploadEvent;

import com.esprit.entity.Utilisateur;



public class Utility implements Iutility {
	
	//private static final int IMG_WIDTH = 300;
	//private static final int IMG_HEIGHT =300;

	

	@Override
	public File writeFile(FileUploadEvent event,String emplacement  ) throws IOException{

		String path = FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("/");
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		String name = fmt.format(new Date())
				+ event.getFile()
						.getFileName()
						.substring(
								event.getFile().getFileName().lastIndexOf('.'));
		
		File file =new File(path + "/"+emplacement);
		if (!file.exists()){file.mkdir();}
		
		file = new File(path +"/"+emplacement  );
		if (!file.exists()){file.mkdir();}
		file = new File(path + "/"+emplacement  + name);
		
		
	InputStream is = event.getFile().getInputstream();
	OutputStream out = new FileOutputStream(file);
	byte buf[] = new byte[1024];
	int len;
	while ((len = is.read(buf)) > 0)
		out.write(buf, 0, len);
	is.close();
	out.close();
	System.out.println(path + emplacement);
	return file;
	}
	
	@Override
	public boolean Removefile (String url){
		
		File file = new File(url);
		 
		if(file.delete()){
			return true;
		}else{
			return false;
		}
		
	}





	@Override
	public Utilisateur getUserfromMapSession(){
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();

		try{
			if(sessionMap.get("superAdmin")!=null)
		return (Utilisateur) sessionMap.get("superAdmin");
			if(sessionMap.get("shopOwner")!=null)
				return (Utilisateur) sessionMap.get("shopOwner");
			if(sessionMap.get("client")!=null)
				return (Utilisateur) sessionMap.get("client");
			return null;
		}catch(Exception e){
			
			return null;	
		}
		
						}


public void CreateDirectoryIfNotExiste(String  directoryName){
	try {
		String pathPdf	= new File(Utility.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getPath().replace('\\', '/')+"/";
	
	
		 File theDir = new File(pathPdf+directoryName);

		  // if the directory does not exist, create it
		  if (!theDir.exists()) {

		    try{
		        theDir.mkdir();
		     } catch(SecurityException se){
		        //handle it
		     }        
		  
		  }
		  
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

@Override
public String DetrminerExtension( String urlFile) {   
	String extension = "";
	int i = urlFile.lastIndexOf('.');
	int p = Math.max(urlFile.lastIndexOf('/'), urlFile.lastIndexOf('\\'));

	if (i > p) {
	    extension = urlFile.substring(i+1);
	}
	
	String[] ExtensionImgArray = new String[]{"PNG","JPG","JPEG","GIF","BMP"};
	
	if (extension.equalsIgnoreCase("pdf")){return "pdf";}
	if(Arrays.asList(ExtensionImgArray).contains(extension.toUpperCase())){ return "img";}
	return "null";
}


@Override
public void SetUserSessionBean(Object u){
	
	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	Map<String, Object> sessionMap = externalContext.getSessionMap();
	 sessionMap.put("user", u);
}



		
}
