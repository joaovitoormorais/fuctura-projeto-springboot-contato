package contatofuctura.projeto.fucturaprojetospring.repository;

import contatofuctura.projeto.fucturaprojetospring.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {

    Optional<Contato> findById(Integer id);

    Optional<Contato> findByNome(String nome);

    Optional<Contato> findByNomeContainingIgnoreCase(String nome);
    }
