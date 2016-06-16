package br.com.crescer.controllers.abstracts;

import br.com.crescer.service.abstracts.AbstractService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 * @author Carlos H. Nonnemacher
 * @param <Entity>
 * @param <Service>
 */
public abstract class AbstractController<Entity, Service extends AbstractService<Entity>> implements IAbstractController<Entity, Service>, Serializable {

    private Entity entity;
    private List<Entity> list;

    @Override
    public void saveOrUpdate() {
        this.getService().saveOrUpdate(entity);
    }

    @Override
    public void remove() {
        this.getService().remove(entity);
    }

    @Override
    public void listAll() {
        this.list = this.getService().listAll();
    }
    
    @Override
    public void find() {
        this.list = this.getService().find(entity);
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    public abstract Service getService();

    public List<Entity> getList() {
        return list;
    }

    public void setList(List<Entity> list) {
        this.list = list;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
    
}
