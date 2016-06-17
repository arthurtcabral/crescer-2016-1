package br.com.crescer.services;

import br.com.crescer.pojo.Pessoa;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    public List<Pessoa> list() {
        Pessoa p = new Pessoa();
        p.setNome("Arthur Tassinari Cabral");
        p.setNascimento(new Date());
        return Stream.of(p).collect(Collectors.toList());
    }

}
