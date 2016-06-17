package br.com.crescer.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Example {

    @RequestMapping(value = "/exemplo") //
    String toIndex(@RequestParam(required = false) String name, Model model) { // http://localhost:9090/exemplo(?name=Arthur)
        name = name == null ? "Student" : name;
        model.addAttribute("name", "Student: " + name);
        return "index";
    }

//    @ResponseBody
//    @RequestMapping(value = "/current_date_time")
//    public Date date() {
//        return new Date();
//    }

//    @ResponseBody
//    @RequestMapping(value = "/pessoa.json", method = RequestMethod.POST) //Conversão de JSON em objeto
//    public List<Pessoa> list(@RequestBody Pessoa p) {
//        p.setNascimento(new Date());
//        return Stream.of(p).collect(Collectors.toList());
//    }
    
    

}
