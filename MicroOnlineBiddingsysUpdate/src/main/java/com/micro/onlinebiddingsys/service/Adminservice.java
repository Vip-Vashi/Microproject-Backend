package com.micro.onlinebiddingsys.service;

import java.util.List;

import com.micro.onlinebiddingsys.model.AdministrativeUser;

public interface Adminservice {
	public List<AdministrativeUser> getAllAdministrativeUsers();
	public AdministrativeUser getAdministrativeUserById(int adminid);
	public AdministrativeUser updateAdministrativeUser(AdministrativeUser admin);
	public AdministrativeUser saveAdministrativeUser(AdministrativeUser admin) ;
}
