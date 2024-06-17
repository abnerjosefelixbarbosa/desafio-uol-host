package com.org.backendjava.infra.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.org.backendjava.domain.enums.GroupType;

@Service
public class GroupService {

	
	public String getCodenameByGroupType(GroupType type) {
		if (type.getType() == "AVENGER") {
			getAvager();
		} else {
			getJusticeLeague();
		}
		
		
		return null;
	}
	
	private String getAvager() {
		RestTemplate rest = new RestTemplate();
		Object[] vingadores = rest.getForObject("https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json", Object[].class);
		
		System.out.print(vingadores);
		
		return null;
	}
	
	private String getJusticeLeague() {
		RestTemplate rest = new RestTemplate();
		Object obj = rest.getForObject("https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml", Object.class);
		
		System.out.print(obj);
		
		return null;
	}
}
