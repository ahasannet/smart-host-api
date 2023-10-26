package com.shameem.smarthost.service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.shameem.smarthost.data.repository.HostRepository;
import com.shameem.smarthost.models.HostSummary;
import com.shameem.smarthost.models.RoomType;

@Service
public class HostServiceImpl implements HostService {
	
    @Override
	public boolean addSingleRate(Integer rate) {
    	boolean isFound = HostRepository.getInstance().getRateList().contains(rate);
    	if(isFound == false) {
    		HostRepository.getInstance().addRate(rate);
    	}
		return !isFound;
	}
    
    @Override
	public boolean addRateList(Set<Integer> rates) {
    	HostRepository.getInstance().addRates(rates);
		return true;
	}
    
    @Override
    public List<HostSummary> generateSummary(Integer economy, Integer premium) {
    	Set<Integer> rateList = HostRepository.getInstance().getRateList();
    	Integer minPremiumRate = HostRepository.getInstance().getMinPremiumRate();
    	
    	List<Integer> economyRate = rateList.stream()
                .filter(rate -> rate < minPremiumRate)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        List<Integer> premiumRate = rateList.stream()
                .filter(rate -> rate >= minPremiumRate)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        
        int premiumSum = 0;
        int premiumSize = premiumRate.size() > premium ? premium : premiumRate.size(); 
        
        for(int i=0; i < premiumSize; i++) {
            premiumSum += premiumRate.get(i);
        }

        if(premium > premiumRate.size()) {
            premium = premiumRate.size();
            if (economyRate.size() > 0) {
                premiumSum += economyRate.remove(0);
                premium += 1;
            }
        }

        int economySum = 0;
        int economySize = economyRate.size() > economy ? economy : economyRate.size(); 
        
        for(int i=0; i < economySize; i++) {
            economySum += economyRate.get(i);
        }

        HostSummary economySummary = new HostSummary(RoomType.ECONOMY, economy, economySum);
        HostSummary premiumSummary = new HostSummary(RoomType.PREMIUM, premium, premiumSum);
    	
        return Stream.of(economySummary, premiumSummary).collect(Collectors.toList());
    }
    
    @Override
    public boolean updateMinimumPremiumRate(Integer rate) {
    	HostRepository.getInstance().setMinPremiumRate(rate);
    	return true;
    }

}
