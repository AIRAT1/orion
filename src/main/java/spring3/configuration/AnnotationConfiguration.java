package spring3.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(value = {"spring3.zoo"},
        excludeFilters = @ComponentScan.Filter(classes = {BeanConfiguration.class}, type = FilterType.ASSIGNABLE_TYPE))
public class AnnotationConfiguration {

}
