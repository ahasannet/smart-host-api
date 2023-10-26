package com.shameem.smarthost.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.shameem.smarthost.models.HostSummary;

@Component
public interface HostService {
	
	boolean updateMinimumPremiumRate(Integer rate);
	boolean addSingleRate(Integer rate);
	boolean addRateList(Set<Integer> rates);
	List<HostSummary> generateSummary(Integer economy, Integer premium);
	
}
