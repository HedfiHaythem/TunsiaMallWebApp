package com.esprit.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Message implements Serializable{
	
	private Integer id;
	private Integer num;
	private Date dateMiseEnLigne;
	private String msg;
	private ShopOwner shopOwner;
	private Client client;
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Date getDateMiseEnLigne() {
		return dateMiseEnLigne;
	}
	public void setDateMiseEnLigne(Date dateMiseEnLigne) {
		this.dateMiseEnLigne = dateMiseEnLigne;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	public ShopOwner getShopOwner() {
		return shopOwner;
	}
	public void setShopOwner(ShopOwner shopOwner) {
		this.shopOwner = shopOwner;
	}
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	
}
