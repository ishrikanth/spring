import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

/**
 * Created by shrikanth on 8/9/16.

 */

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"poc.endpoints.*"})
@ComponentScan(basePackages = {"poc.endpoints"})
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages ={"poc.endpoints.mongo.repositories"})
@EntityScan("poc.endpoints.*")
public class MainLauncher extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MainLauncher.class);
    }



    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MainLauncher.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }

}