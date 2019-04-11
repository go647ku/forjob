package com.jt.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.manage.pojo.User;

public class ObjectMapperTest {

	
	@Test
	public void Json() throws IOException {
		User user=new User();
		user.setAge(100);
		user.setName("hhhhhhhh");
		user.setSex("男");
		
		ObjectMapper object=new ObjectMapper();
		
		String writeValueAsString = object.writeValueAsString(user);
		System.out.println(writeValueAsString);
		
		//将json串转化成对象
		User user1=object.readValue(writeValueAsString, User.class);
		System.out.println(user1.toString());
	}
	@SuppressWarnings("unchecked")
	@Test
	public void listToJson() throws IOException {
		List<User> userList=new ArrayList();
		User user=new User();
		user.setAge(25);
		user.setId(01);
		user.setName("王宝强");
		user.setSex("男");
		userList.add(user);
		ObjectMapper object=new ObjectMapper();
		String writeValueAsString = object.writeValueAsString(userList);
		System.out.println(writeValueAsString);
		List<User> readValue = object.readValue(writeValueAsString,userList.getClass());
		System.out.println(readValue);
	
		
	}
}
