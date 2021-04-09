package spring3.configuration;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(value = {"spring3.zoo"})
@PropertySource("classpath:application.yml")
@Profile("annotationConfiguration")
@EnableAspectJAutoProxy
@EnableScheduling
@EnableAsync
public class AnnotationConfiguration {

}
