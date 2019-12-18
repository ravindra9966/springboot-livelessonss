package org.cloudcafe.boot2.ms.social.app.chapter4.repository;

import org.cloudcafe.boot2.ms.social.app.chapter4.model.Image;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;

@Configuration
public class InitDatabase {

    @Bean
    CommandLineRunner init(MongoOperations operations) {
        return (args) -> {

            operations.dropCollection(Image.class);

            operations.insert(new Image("1",
                    "learning-spring-boot-cover.jpg"));
            operations.insert(new Image("2",
                    "learning-spring-boot-2nd-edition-cover.jpg"));
            operations.insert(new Image("3",
                    "bazinga.png"));

            System.out.println(operations.findAll(Image.class));
        };
    }

}
