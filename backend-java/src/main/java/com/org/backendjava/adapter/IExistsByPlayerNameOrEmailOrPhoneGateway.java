package com.org.backendjava.adapter;

public interface IExistsByPlayerNameOrEmailOrPhoneGateway {
	boolean existsByPlayerNameOrEmailOrPhone(String name, String email, String phone); 
}