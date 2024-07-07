package com.org.backendjava.infra.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.org.backendjava.adapter.ICodeNameGateway;
import com.org.backendjava.infra.enums.GroupTypeDB;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CodeNameService implements ICodeNameGateway {
	@Autowired
	private Environment environment;
	@Autowired
	private ObjectMapper objectMapper;
	private List<String> codenameAvengersList = new ArrayList<String>();
	private List<String> codenameJusticeLeagueList = new ArrayList<String>();

	public String getCodenameByGroupType(GroupTypeDB type) {
		String codename = "";
		
		if (codenameAvengersList.isEmpty() || codenameJusticeLeagueList.isEmpty()) {
			loadAvengers();
			loadJusticeLeague();
		}

		if (type.getType() == "AVENGERS") {
			codename = codenameAvengersList.parallelStream().findFirst()
					.orElseThrow(() -> new EntityNotFoundException("code name not found"));
			codenameAvengersList.remove(codename);
		} else {
			codename = codenameJusticeLeagueList.parallelStream().findFirst()
					.orElseThrow(() -> new EntityNotFoundException("code name not found"));
			codenameJusticeLeagueList.remove(codename);
		}

		return codename;
	}

	@PostConstruct
	private void loadAvengers() {
		RestTemplate restTemplate = new RestTemplate();

		try {
			String response = restTemplate.getForObject(environment.getProperty("avengers"), String.class);
			JsonNode jsonNode = objectMapper.readTree(response);
			ArrayNode nodes = (ArrayNode) jsonNode.get("vingadores");

			for (JsonNode i : nodes) {
				codenameAvengersList.add(i.get("codinome").asText());
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@PostConstruct
	private void loadJusticeLeague() {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(environment.getProperty("justice.league"));
			NodeList nodeList = document.getElementsByTagName("codinome");

			for (int i = 0; i < nodeList.getLength(); i++) {
				Element element = (Element) nodeList.item(i);
				String codename = element.getTextContent();
				codenameJusticeLeagueList.add(codename);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
