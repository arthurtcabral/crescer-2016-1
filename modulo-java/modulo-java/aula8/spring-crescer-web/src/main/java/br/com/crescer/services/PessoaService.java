package br.com.crescer.services;

import br.com.crescer.entity.Pessoa;
import br.com.crescer.repository.PessoaRepository;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author Carlos H. Nonnemacher
 */
@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public List<Pessoa> list() {
        Pessoa p = new Pessoa();
        p.setNome("Arthur Tassinari Cabral");
        p.setNascimento(new Date());
        return Stream.of(p).collect(Collectors.toList());
    }

    public Iterable<Pessoa> findAll() {
        return repository.findAll();
    }

    public void save(Pessoa p) {
        repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
    
    public Pessoa findById(Long id){
        return repository.findOne(id);
    }
    
}
