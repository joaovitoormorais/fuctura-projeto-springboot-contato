package contatofuctura.projeto.fucturaprojetospring.service;

import contatofuctura.projeto.fucturaprojetospring.dto.ContatoDto;
import contatofuctura.projeto.fucturaprojetospring.model.Contato;
import contatofuctura.projeto.fucturaprojetospring.repository.ContatoRepository;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Contato findById(Integer id) {
        Optional<Contato> con = contatoRepository.findById(id);
        if (con.isPresent()) {
            return con.get();
        }
        throw new ObjectNotFoundException(id, Contato.class.getName());
    }

    public List<Contato> findAll() {
        return contatoRepository.findAll();
    }

    public Contato save(ContatoDto contatoDTO) {
        findByNome(contatoDTO);
        contatoDTO.setId(null);
        return contatoRepository.save(modelMapper.map(contatoDTO, Contato.class));
    }

    public Contato update(ContatoDto  contatoDTO) {
        findById(contatoDTO.getId());
        findByNome(contatoDTO);
        return contatoRepository.save(modelMapper.map(contatoDTO, Contato.class));
    }

    public void delete(Integer id) {
        findById(id);
        Optional<Contato> con = contatoRepository.findById(id);
        contatoRepository.deleteById(id);
    }

    private void findByNome(ContatoDto contatoDTO) {
        Optional<Contato> con = contatoRepository.findByNome(contatoDTO.getNome());
        if(con.isPresent()) {
            throw new IllegalArgumentException("Contato com nome já existe");
        }
    }

    public void buscarPorNome(String nome) {
        Optional<Contato> con = contatoRepository.findByNomeContainingIgnoreCase(nome);
        if (con.isEmpty()) {
            throw new IllegalArgumentException("Contato não encontrado!");
        }
    }
}