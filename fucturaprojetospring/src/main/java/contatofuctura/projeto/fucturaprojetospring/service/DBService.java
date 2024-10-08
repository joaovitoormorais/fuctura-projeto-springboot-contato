package contatofuctura.projeto.fucturaprojetospring.service;

import contatofuctura.projeto.fucturaprojetospring.model.Contato;
import contatofuctura.projeto.fucturaprojetospring.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ContatoRepository contatoRepository;

    public void instanciaDB() {

        Contato contato = new Contato(null, "João Vitor", "joaovitormorais04@gmail.com", "81- 992513706");
        Contato contato1 = new Contato(null, "Taize", "taizempereira@gmail.com", "81- 9666677777");
        Contato contato2 = new Contato(null, "Antonio", "Antoniomorais@gmail.com", "81- 777766655");

        this.contatoRepository.saveAll(Arrays.asList(contato, contato1, contato2));


    }
}
