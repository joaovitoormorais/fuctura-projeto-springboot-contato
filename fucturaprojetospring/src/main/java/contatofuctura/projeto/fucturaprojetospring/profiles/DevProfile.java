package contatofuctura.projeto.fucturaprojetospring.profiles;


import contatofuctura.projeto.fucturaprojetospring.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.awt.image.DataBuffer;

public class DevProfile {

    @Autowired
    private DBService dbService;

    @Bean
    public void instanciaDB() {
        this.dbService.instanciaDB();
    }
}
