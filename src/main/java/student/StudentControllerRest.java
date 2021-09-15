package student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student-rest")
public class StudentControllerRest {

    @Autowired
    private StudentService stService;

    @PostMapping("post-request")
    public StudentInfoForm postRequest(@RequestBody StudentInfoForm st) {
        return stService.postRequest(st);
    }
	
}
