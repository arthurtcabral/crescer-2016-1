package br.com.crescer.repository;

import br.com.crescer.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
 