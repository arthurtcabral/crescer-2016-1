package br.com.crescer.controllers;

import br.com.crescer.services.PessoaService;
import br.com.crescer.entity.Pessoa;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carlos H. Nonnemacher
 */
@RestController
@RequestMapping("/rest/pessoa")
public class PessoaRest {

    @Autowired
    PessoaService service;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Pessoa> list(Pageable pgbl) {
        return service.findAll(pgbl);
    }

    @RequestMapping(value = "/save_or_update", method = RequestMethod.POST)
    public void save(@RequestParam Pessoa p) {
        p.setNascimento(new Date());
        service.save(p);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
