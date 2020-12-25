package com.skankhunt220.api.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.skankhunt220.entity.User;
import com.skankhunt220.service.UserService;

@Controller
@RequestMapping(value = "/user", produces = {"application/json"})
public class UserController {
	private static final UserService userService = new UserService();
	private static final ObjectMapper mapper = new ObjectMapper();
	
	@ResponseBody 
	private void sendResponse(String message, HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		try (PrintWriter out = response.getWriter()) {
			out.print(message);
		}
	}
	private User getUserInfo(HttpServletRequest request) throws IOException {
		try {
			String bodyInfo = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			return mapper.readValue(bodyInfo, User.class);
		} catch (IOException ex) {
			// ...
		}
		return new User();
	}
	@RequestMapping(method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Read			
		sendResponse(userService.readUser(getUserInfo(request).getId()).toJson(), response);
	}
	@RequestMapping(method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Create
		User user = getUserInfo(request);
		userService.createUser(user);
		sendResponse(new Gson().toJson(user), response);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Update
		User user = getUserInfo(request);
		userService.editUser(user);
		sendResponse(new Gson().toJson(user), response);
	}
	@RequestMapping(method = RequestMethod.DELETE)
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Delete
		userService.deleteUser(getUserInfo(request).getId());
		sendResponse("Object was deleted", response);
	}
}