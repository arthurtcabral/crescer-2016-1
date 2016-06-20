package br.com.crescer.controllers;

import br.com.crescer.entity.Pessoa;
import br.com.crescer.services.PessoaService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaService service;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, Pageable pageable) {
        PageRequest p = new PageRequest(pageable.getPageNumber(), 5);
        Page<Pessoa> pessoas = service.findAll(p);
        model.addAttribute("pessoas", pessoas);
        model.addAttribute("pessoa", new Pessoa());
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(Pessoa p) {
        if (p.getNascimento() == null) {
            p.setNascimento(new Date());
        }
        service.save(p);
        return "redirect:/pessoa";
    }

}
