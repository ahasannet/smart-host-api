package com.shameem.smarthost.web;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shameem.smarthost.data.payloads.response.HostResponse;
import com.shameem.smarthost.models.HostSummary;
import com.shameem.smarthost.service.HostService;

import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rates")
@ApiResponses(value = {
		@io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
		@io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
		@io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
})
public class HostController {

	@Autowired
	HostService hostService;

	@PostMapping("/add")
	public ResponseEntity<HostResponse> addSingleRate(@RequestBody Integer rate) {
		return new ResponseEntity<HostResponse>(new HostResponse(hostService.addSingleRate(rate)), HttpStatus.CREATED);
	}

	@PostMapping("/addRates")
	public ResponseEntity<HostResponse> addRateList(@RequestBody Set<Integer> rateList) {
		return new ResponseEntity<HostResponse>(new HostResponse(hostService.addRateList(rateList)), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<HostResponse> updateMinimumPremiumRate(@PathVariable Integer rate) {
		return new ResponseEntity<HostResponse>(new HostResponse(hostService.updateMinimumPremiumRate(rate)), HttpStatus.OK);
	}

	@GetMapping("/summary")
	public ResponseEntity<List<HostSummary>> generateSummary (@RequestParam Integer economy, @RequestParam Integer premium) {
		return new ResponseEntity<List<HostSummary>>(hostService.generateSummary(economy, premium), HttpStatus.OK);
	}

}
