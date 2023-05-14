package com.formation.app.service;

import java.util.List;
import java.util.Map;

import com.formation.app.enums.StatusEnum;

public interface ImportQuantitiesService {
	Map<StatusEnum, List<String>> updateQuantities(String path);
}
