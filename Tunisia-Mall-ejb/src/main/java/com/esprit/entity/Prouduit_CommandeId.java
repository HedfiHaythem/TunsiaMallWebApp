package com.esprit.entity;

import java.io.Serializable;

public class Prouduit_CommandeId implements Serializable {

	  private long produitId;

	  private long commandeId;
	 

	  public int hashCode() {
	    return (int)(produitId + commandeId);
	  }

	  public boolean equals(Object object) {
	    if (object instanceof Prouduit_CommandeId) {
	    	Prouduit_CommandeId otherId = (Prouduit_CommandeId) object;
	      return (otherId.produitId == this.produitId) && (otherId.produitId == this.commandeId);
	    }
	    return false;
	  }

	}