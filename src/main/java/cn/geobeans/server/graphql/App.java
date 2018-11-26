package cn.geobeans.server.graphql;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(App.class);
        SpringApplication app = builder.build();
        app.addListeners(new ApplicationPidFileWriter("./bin/shutdown.pid"));
        app.run(args);
    }
}
