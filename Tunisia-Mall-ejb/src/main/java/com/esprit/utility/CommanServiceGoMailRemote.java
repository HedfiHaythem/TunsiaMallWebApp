package com.esprit.utility;


import javax.ejb.Remote;


@Remote
public interface CommanServiceGoMailRemote {
	void msg(String EmailToSend,String Subject,String Body  );

}
