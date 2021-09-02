package someshbose.github.io.prometheusgrafanademo.custom;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Slf4j
@Component
public class CustomAspect {

  @Autowired
  private ErrorMetricRecorder recorder;

  @Around("execution (public * someshbose.github.io.prometheusgrafanademo.custom.StudentService.save(..)) && args(list)")
  public int proceed(ProceedingJoinPoint pjp, List<Student> list){
    log.info("Number of Record received {}",list.size());
    int output = 0;
    try {
      output = (int)pjp.proceed();
      log.info("Number of Record persisted {} out of {}",output,list.size());
      for (int i=0;i<list.size()-output;i++){
        recorder.recordError("Listen");
      }
    }catch (Throwable t){
      log.error("Something bad happend");
      for (int i=0;i<list.size();i++){
        recorder.recordError("Listen");
      }
    }
    return 0;
  }
}
