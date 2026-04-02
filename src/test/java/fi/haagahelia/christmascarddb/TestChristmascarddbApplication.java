package fi.haagahelia.christmascarddb;

import org.springframework.boot.SpringApplication;

public class TestChristmascarddbApplication {

    public static void main(String[] args) {
        SpringApplication
                .from(ChristmascarddbApplication::main)
                .with(TestcontainersConfiguration.class)
                .run(args);
    }
}