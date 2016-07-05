package com.esprit.utility;

import javax.ejb.Local;


@Local
public interface CommanServiceGoMailLocal {

void msg(String EmailToSend,String Subject,String Body  );
}
