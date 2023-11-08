package com.practice.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.practice.main.dao.CitizenAppRepo;
import com.practice.main.model.CitizenAppEntity;
import com.practice.main.request.CitizenApp;

public class AppRegServiceImpl implements AppRegService {

	private String SSA_API_URL = "http://192.168.3.1.8080/ssn/{ssn}";

	@Autowired
	private CitizenAppRepo appRepo;

	@Override
	public String createCitizen(CitizenApp app) {

		Long citizenSsn = app.getCitizenSsn();

		CitizenAppEntity appEntity = appRepo.findByCitizenSsn(citizenSsn);
		if (appEntity != null) {
			return "DUPICATE APPLICATION";
		}

		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> forEntity = rt.getForEntity(SSA_API_URL, String.class, citizenSsn);

		String body = forEntity.getBody();
		if (body.equals("Rhode Island")) {

			CitizenAppEntity entity = new CitizenAppEntity();
			BeanUtils.copyProperties(app, entity);
			appRepo.save(entity);
			return "Application Created with case No " + entity.getCaseNum();

		}
		return "Application Can not be Created : : INVALID SSN";
	}

	@Override
	public List<CitizenApp> getApplications(Integer userID, String userType) {

		List<CitizenAppEntity> entities = null;

		List<CitizenApp> apps = new ArrayList<>();

		if ("Admin".equals(userType)) {
			entities = appRepo.findAll();
		} else {
			entities = appRepo.findByCreatedBy(userID);
		}

		for (CitizenAppEntity entity : entities) {
			CitizenApp app = new CitizenApp();
			BeanUtils.copyProperties(entity, app);
			apps.add(app);
		}
		return apps;
	}
}
