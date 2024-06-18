package com.org.backendjava.infra.service;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.org.backendjava.infra.enums.GroupTypeDB;

@Service
public class CodenameService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private Environment environment;
	
	public String getCodenameByGroupType(GroupTypeDB type) {
		return null;
	}
	
	private String getAvager() {
		//RestTemplate rest = new RestTemplate();
		//Object[] vingadores = rest.getForObject("https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json", Object[].class);
		
		//System.out.print(vingadores);
		
		return null;
	}
	
	private String getJusticeLeague() {
		//RestTemplate rest = new RestTemplate();
		//Object obj = rest.getForObject("https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml", Object.class);
		
		//System.out.print(obj);
		
		return null;
	}
}
