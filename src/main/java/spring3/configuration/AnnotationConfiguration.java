package spring3.configuration;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@ComponentScan(value = {"spring3"})
@PropertySource("classpath:application.yml")
@Profile("annotationConfiguration")
@EnableAspectJAutoProxy
@EnableScheduling
@EnableAsync
public class AnnotationConfiguration {
    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setThreadNamePrefix("AsyncTest-");
        executor.initialize();
        return executor;
    }
}
