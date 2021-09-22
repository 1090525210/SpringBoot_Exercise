package com.accenture.springexercise.student;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import net.bytebuddy.asm.Advice.This;

@ZipCodeValidation
public class StudentInfoForm {
	
	@NotNull(message = "Id must not be null.")
	@Min(value=100000,message="Id must be six-digit number.")
	@Max(value=999999,message ="Id must be six-digit number." )
	private Integer id;
	
	@NotNull(message = "Name must not be null.")
	@NotBlank(message = "Name must not be blank.")
	@Length(min=1,max=10,message = "The number of characters must be between 1 and 10.")
	private String name;

	private String address;
	
	
	//@ZipCodeValidation(message="When address is not null, the zipcode can not be null.", address =this)
	private String zipcode; //当有地址的时候，这个必须不为空
		
	
	
	@NotEmpty(message = "lable must not be empty.")
	@Size(min=1,max=5,message = "lable size must be between 1 and 5.")
	private List<String> lable;

	
	
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public List<String> getLable() {
		return lable;
	}

	public void setLable(List<String> lable) {
		this.lable = lable;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
