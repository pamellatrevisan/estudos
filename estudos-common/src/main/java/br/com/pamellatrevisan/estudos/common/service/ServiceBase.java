package br.com.pamellatrevisan.estudos.common.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Example;

import br.com.pamellatrevisan.estudos.common.model.EntityBase;

public interface ServiceBase<T extends EntityBase<ID>, ID extends Serializable> {

  public T findByID(ID id);

  public List<T> findBy(Example<T> example);

}
