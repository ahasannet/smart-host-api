package com.shameem.smarthost.data.repository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HostRepository	{
	
	private static HostRepository instance;
	private Integer minPremiumRate = 100;
	private Set<Integer> rateList = new HashSet<Integer>(Arrays.asList(23, 45, 155, 374, 22, 99, 100, 101, 115, 209));
	
	private HostRepository() {}

	public static HostRepository getInstance() {
		if(instance == null) {
			instance = new HostRepository();
		}
		return instance;
	}

	public static void setInstance(HostRepository instance) {
		HostRepository.instance = instance;
	}
	
	public void addRate(Integer rate) {
		rateList.add(rate);
	}
	
	public void addRates(Set<Integer> rates) {
		rateList.addAll(rates);
	}

	public Integer getMinPremiumRate() {
		return minPremiumRate;
	}

	public void setMinPremiumRate(Integer minPremiumRate) {
		this.minPremiumRate = minPremiumRate;
	}

	public Set<Integer> getRateList() {
		return rateList;
	}

	public void setRateList(Set<Integer> rateList) {
		this.rateList = rateList;
	}
	
}
