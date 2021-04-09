package spring3.configuration;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(value = {"spring3.zoo"})
@PropertySource("classpath:application.yml")
@Profile("annotationConfiguration")
public class AnnotationConfiguration {

}
