package mybatis;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.Length;

public class StudentEntity {
	@NotNull(message = "Id must not be null.")
	@Min(value=100000,message="Id must be six-digit number.")
	@Max(value=999999,message ="Id must be six-digit number." )
	private Integer id;
	
	@NotNull(message = "Name must not be null.")
	@NotBlank(message = "Name must not be blank.")
	@Length(min=1,max=10,message = "The number of characters must be between 1 and 10.")
	private String name;

	@Null(message="Address must be null.")
	private String address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
