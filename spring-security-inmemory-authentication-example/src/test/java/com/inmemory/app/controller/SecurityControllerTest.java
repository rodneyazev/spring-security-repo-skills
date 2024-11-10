package com.inmemory.app.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@Test
	void testHomeEndpointAccess() throws Exception {
		this.mvc.perform(get("/").contentType(MediaType.ALL)).andExpect(status().isOk());
		this.mvc.perform(get("/").with(user("user"))).andExpect(status().isOk());
		this.mvc.perform(get("/").with(user("admin"))).andExpect(status().isOk());
		this.mvc.perform(get("/").with(user("guru"))).andExpect(status().isOk());
	}
	
	@Test
	void testUserEndpointAccess() throws Exception {
		this.mvc.perform(get("/user").with(user("user").password("password"))).andExpect(status().isOk());
		this.mvc.perform(get("/user").with(user("admin").password("password"))).andExpect(status().isOk());
		this.mvc.perform(get("/user").with(user("guru").password("password"))).andExpect(status().isOk());
	}
	
	@Test
	void testAdminEndpointAccess() throws Exception {
		this.mvc.perform(get("/admin").with(user("user").password("password").roles("USER"))).andExpect(status().isForbidden());
		this.mvc.perform(get("/admin").with(user("admin").password("password").roles("ADMIN"))).andExpect(status().isOk());
		this.mvc.perform(get("/admin").with(user("guru").password("password").roles("GURU"))).andExpect(status().isOk());
	}
	
	@Test
	void testGuruEndpointAccess() throws Exception {
		this.mvc.perform(get("/guru").with(user("user").password("password").roles("USER"))).andExpect(status().isForbidden());
		this.mvc.perform(get("/guru").with(user("admin").password("password").roles("ADMIN"))).andExpect(status().isForbidden());
		this.mvc.perform(get("/guru").with(user("guru").password("password").roles("GURU"))).andExpect(status().isOk());
	}

}
