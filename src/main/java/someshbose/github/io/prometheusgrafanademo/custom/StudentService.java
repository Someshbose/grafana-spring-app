package someshbose.github.io.prometheusgrafanademo.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

  //@Autowired
  //private StudentDataRepo repo;

  public int save(List<Student> list){

    //repo.save(new Student(1,"Somesh"));

    return 1;
  }
}
