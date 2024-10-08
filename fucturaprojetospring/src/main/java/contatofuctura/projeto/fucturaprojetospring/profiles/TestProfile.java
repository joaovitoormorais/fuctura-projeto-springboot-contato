package contatofuctura.projeto.fucturaprojetospring.profiles;


import contatofuctura.projeto.fucturaprojetospring.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestProfile {

    @Autowired
    private DBService dbService;

    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            dbService.instanciaDB();

        };

    }

}