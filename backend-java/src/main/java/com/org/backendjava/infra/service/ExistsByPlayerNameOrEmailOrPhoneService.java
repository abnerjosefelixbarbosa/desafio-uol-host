package com.org.backendjava.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.adapter.IExistsByPlayerNameOrEmailOrPhoneGateway;
import com.org.backendjava.infra.interfaces.repository.IPlayerRepository;

@Service
public class ExistsByPlayerNameOrEmailOrPhoneService implements IExistsByPlayerNameOrEmailOrPhoneGateway {
	@Autowired
	private IPlayerRepository playerRepository;
	
	public boolean existsByPlayerNameOrEmailOrPhone(String name, String email, String phone) {
		return playerRepository.existsByPlayerNameOrEmailOrPhone(name, email, phone);
	}
}
