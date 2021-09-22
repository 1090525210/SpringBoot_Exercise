package com.example.demo;

import static org.mockito.Mockito.mockitoSession;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SimpleApplication.class)
//测试环境使用，用来表示测试环境使用的ApplicationContext将是WebApplicationContext类型的
@WebAppConfiguration
public class StudentControllerTest {

  @Autowired
  private MockMvc mockMvc;
  private WebApplicationContext webApplicationContext;
  
  //模拟出一个userService
  @MockBean
  private StudentService stService;

  @Before
  public void setUp() throws Exception{
      //MockMvcBuilders.webAppContextSetup(WebApplicationContext context)：指定WebApplicationContext，将会从该上下文获取相应的控制器并得到相应的MockMvc；
      mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();//建议使用这种
  }
  
  @Test
  public void selectAllTest() throws Exception {
	  List<StudentEntity> list = new ArrayList<>();
      StudentEntity st1 = new StudentEntity(1, "John");
      StudentEntity st2 = new StudentEntity(2, "Jack");
      StudentEntity st3 = new StudentEntity(3, "Jackson");
       
      list.add(st1);
      list.add(st2);
      list.add(st3);
      Mockito.when(stService.selectAll()).thenReturn(list);

      MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/student/retrieve")
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(MockMvcResultMatchers.status().isOk())             //等同于Assert.assertEquals(200,status);
              .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))  
              .andExpect(MockMvcResultMatchers.jsonPath("$.student_id").value(1))     //等同于 Assert.assertEquals("hello lvgang",content);
              .andDo(MockMvcResultHandlers.print())
              .andReturn();
  }

}

