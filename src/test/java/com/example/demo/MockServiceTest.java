package com.example.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.accenture.springexercise.mybatis.repository.StudentRepository;
import com.accenture.springexercise.mybatis.service.StudentServiceImpl;
import com.accenture.springexercise.mybatis.entity.*;


@ExtendWith(MockitoExtension.class)
public class MockServiceTest {
	
	
	@InjectMocks
	private StudentServiceImpl stService;
	
	@Mock
	private StudentRepository stMapper;
	
	@Test
	public void testselectAll() throws Exception{
		List<StudentEntity> list = new ArrayList<>();
        StudentEntity st1 = new StudentEntity(1, "John");
        StudentEntity st2 = new StudentEntity(2, "Jack");
        StudentEntity st3 = new StudentEntity(3, "Jackson");
         
        list.add(st1);
        list.add(st2);
        list.add(st3);
        
        Mockito.when(stMapper.selectAll()).thenReturn(list);
        List<StudentEntity> stList = stService.selectAll();
        Assertions.assertEquals(stList, list);
		Mockito.verify(stMapper).selectAll();
	}
	
	@Test
    public void selectByIdTest()
    {
        Mockito.when(stMapper.selectbyId(1)).thenReturn(new StudentEntity(1,"Louis"));
        StudentEntity st = stService.selectbyId(1);
        Assertions.assertEquals("Louis", st.getName());
        Assertions.assertEquals(1,st.getStudentid());
        Mockito.verify(stMapper).selectbyId(1);
    }

	
}

