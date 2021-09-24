package com.example.demo;

import static org.mockito.Mockito.mockitoSession;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.accenture.springexercise.mybatis.SimpleApplication;
import com.accenture.springexercise.mybatis.controller.StudentControllerRest;
import com.accenture.springexercise.mybatis.entity.StudentEntity;
import com.accenture.springexercise.mybatis.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;





@ExtendWith(SpringExtension.class)

@SpringBootTest(classes = SimpleApplication.class)
//测试环境使用，用来表示测试环境使用的ApplicationContext将是WebApplicationContext类型的
@WebAppConfiguration
public class StudentControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
  


	@BeforeEach
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();//建议使用这种
	}
	
	@Test
	public void selectAllTest() throws Exception {
		String responseString = mockMvc.perform(MockMvcRequestBuilders.get("/student/retrieve")).andReturn().getResponse().getContentAsString();
		System.out.println("result : "+responseString);
		
	}
	
	@Test
	public void selectbyIdTest() throws Exception{
		String responseString = mockMvc.perform(MockMvcRequestBuilders
				.get("/student/retrieve-by-id/4"))
				.andReturn().getResponse().getContentAsString();
		System.out.println("result : "+responseString);
	}
	
	@Test
	public void updateTest() throws Exception{
		StudentEntity st = new StudentEntity(1,"Tom",31,1,"2021-9-24",3,"2021-9-25");
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		java.lang.String requestJson = ow.writeValueAsString(st);

		
		
		String responseString = mockMvc.perform(MockMvcRequestBuilders
				.put("/student/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andReturn().getResponse().getContentAsString();
		System.out.println("result : "+responseString);
	}
	
	@Test
	public void insertTest() throws Exception{
		StudentEntity st = new StudentEntity(23,"Tom",30,1,"2021-9-24",3,"2021-9-25");
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		java.lang.String requestJson = ow.writeValueAsString(st);

		String responseString = mockMvc.perform(MockMvcRequestBuilders
				.post("/student/insert").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andReturn().getResponse().getContentAsString();
		System.out.println("result : "+responseString);
	}
	
	@Test
	public void deleteTest() throws Exception{
		String responseString = mockMvc.perform(MockMvcRequestBuilders
				.delete("/student/delete/21"))
				.andReturn().getResponse().getContentAsString();
		System.out.println("result : "+responseString);
	}
	
	

}

