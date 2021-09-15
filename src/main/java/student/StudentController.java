package student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student-basis")
public class StudentController {

    @Autowired
    private StudentService stService;

    @RequestMapping(value="/post-request", method=RequestMethod.POST)
    @ResponseBody
    public StudentInfoForm postRequest(@RequestBody StudentInfoForm st) {
        return stService.postRequest(st);
    }
	
}
