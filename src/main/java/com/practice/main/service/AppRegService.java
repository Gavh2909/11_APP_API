package com.practice.main.service;

import java.util.List;

import com.practice.main.request.CitizenApp;

public interface AppRegService {

	public String createCitizen(CitizenApp app);

	public List<CitizenApp> getApplications(Integer userId, String userType);
}
