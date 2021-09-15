package student;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Override
	public StudentInfoForm postRequest(StudentInfoForm st) {
		//System.out.println("Student id: "+ st.getId()+", name is: "+st.getName());
		//st.toString();
		return st;
	}

}
