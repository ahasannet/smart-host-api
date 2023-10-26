package com.shameem.smarthost.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.shameem.smarthost.HostApplication;

@SpringBootTest
@SpringBootConfiguration
@WebAppConfiguration
@ContextConfiguration(classes = HostApplication.class, loader = SpringBootContextLoader.class)
class HostApplicationTests {
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@BeforeEach
	public void setup() throws Exception {
		mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void test3Economy3Premium() throws Exception {
		mockMvc.perform(get("/rates/summary?economy=3&premium=3")).andExpect(status().isOk()).andExpect(content().string("[{\"roomType\":\"ECONOMY\",\"room\":3,\"income\":167},{\"roomType\":\"PREMIUM\",\"room\":3,\"income\":738}]"));
	}
	
	@Test
	public void test5Economy7Premium() throws Exception {
		mockMvc.perform(get("/rates/summary?economy=5&premium=7")).andExpect(status().isOk()).andExpect(content().string("[{\"roomType\":\"ECONOMY\",\"room\":5,\"income\":90},{\"roomType\":\"PREMIUM\",\"room\":7,\"income\":1153}]"));
	}
	
	@Test
	public void test7Economy2Premium() throws Exception {
		mockMvc.perform(get("/rates/summary?economy=7&premium=2")).andExpect(status().isOk()).andExpect(content().string("[{\"roomType\":\"ECONOMY\",\"room\":7,\"income\":189},{\"roomType\":\"PREMIUM\",\"room\":2,\"income\":583}]"));
	}
	
	@Test
	public void test1Economy10Premium() throws Exception {
		mockMvc.perform(get("/rates/summary?economy=1&premium=10")).andExpect(status().isOk()).andExpect(content().string("[{\"roomType\":\"ECONOMY\",\"room\":1,\"income\":45},{\"roomType\":\"PREMIUM\",\"room\":7,\"income\":1153}]"));
	}
	
	@Test
	public void test0Economy0Premium() throws Exception {
		mockMvc.perform(get("/rates/summary?economy=0&premium=0")).andExpect(status().isOk()).andExpect(content().string("[{\"roomType\":\"ECONOMY\",\"room\":0,\"income\":0},{\"roomType\":\"PREMIUM\",\"room\":0,\"income\":0}]"));
	}
	
}
