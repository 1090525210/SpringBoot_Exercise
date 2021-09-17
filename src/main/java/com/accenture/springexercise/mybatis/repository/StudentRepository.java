package com.accenture.springexercise.mybatis.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.accenture.springexercise.mybatis.entity.StudentEntity;

@Repository
public interface StudentRepository {

	List<StudentEntity> selectAll();
	StudentEntity selectbyId(Integer id);
	int update(Integer id, String name, Integer age);
}
