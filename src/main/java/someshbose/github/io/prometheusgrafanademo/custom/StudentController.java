package someshbose.github.io.prometheusgrafanademo.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

  @Autowired
  private StudentService service;

  @PostMapping("/test")
  public void saveData(){
    List<Student> list = new ArrayList<>();
    list.add(new Student(1,"Somesh"));
    list.add(new Student(2,"Mrinal"));
    list.add(new Student(3,"Sasank"));


    service.save(list);
  }
}
