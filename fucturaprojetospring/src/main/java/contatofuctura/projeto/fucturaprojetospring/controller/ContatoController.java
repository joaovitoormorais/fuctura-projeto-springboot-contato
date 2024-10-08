package contatofuctura.projeto.fucturaprojetospring.controller;

import contatofuctura.projeto.fucturaprojetospring.config.ModelMapperConfig;
import contatofuctura.projeto.fucturaprojetospring.dto.ContatoDto;
import contatofuctura.projeto.fucturaprojetospring.model.Contato;
import contatofuctura.projeto.fucturaprojetospring.service.ContatoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Controller
@CrossOrigin("x")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ContatoDto> findById(@PathVariable Integer id) {
        Contato con = contatoService.findById(id);
        ContatoDto conDto = modelMapper.map(con, ContatoDto.class);
        return ResponseEntity.ok().body(conDto);
    }

    @GetMapping
    public ResponseEntity<List<ContatoDto>> findAll() {
        List<Contato> list = contatoService.findAll();
        return ResponseEntity.ok().body(list.stream().map(obj -> modelMapper.map(obj, ContatoDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<ContatoDto> save(@RequestBody ContatoDto contatoDTO) {
        Contato cat = contatoService.save(contatoDTO);
        return ResponseEntity.ok().body(modelMapper.map(cat, ContatoDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoDto> update(@PathVariable Integer id, @RequestBody ContatoDto contatoDTO) {
        contatoDTO.setId(id);
        Contato con = contatoService.update(contatoDTO);
        ContatoDto conDto = modelMapper.map(con, ContatoDto.class);
        return ResponseEntity.ok().body(conDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        contatoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

