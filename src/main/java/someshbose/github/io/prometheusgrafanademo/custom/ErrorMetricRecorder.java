package someshbose.github.io.prometheusgrafanademo.custom;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class ErrorMetricRecorder {


  private final MeterRegistry meterRegistry;
  private final ConcurrentHashMap<String, Counter> metrics;

  public ErrorMetricRecorder(){
    meterRegistry = Metrics.globalRegistry;
    metrics=new ConcurrentHashMap<>();
  }

  public void recordError(String endpoint){
    log.info("Incomong endpoint {}",endpoint);
    metrics.computeIfAbsent(endpoint,metric-> Counter.builder("test_application_endpoint_error")
        .tag("endPoint",endpoint)
        .register(meterRegistry));

    metrics.computeIfPresent(endpoint,(k,v)->{
      v.increment();
      return v;
    });
  }
}
