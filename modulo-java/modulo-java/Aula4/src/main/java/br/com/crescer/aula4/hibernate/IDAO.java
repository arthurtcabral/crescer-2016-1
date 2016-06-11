
package br.com.crescer.aula4.hibernate;

import java.util.List;

public interface IDAO {
    
    void save(Object object);
    List<?> listAll(Class classe);
    void update(Object object);
    void delete(Object object);
    
}
