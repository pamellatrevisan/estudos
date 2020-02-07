package br.com.pamellatrevisan.estudos.common.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import br.com.pamellatrevisan.estudos.common.model.EntityBase;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Getter
@Component
@Log4j2
public class RepositoryBaseImpl<T extends EntityBase<ID>, ID extends Serializable> extends SimpleJpaRepository<T, ID>
    implements RepositoryBase<T, ID> {

  private EntityManager entityManager;

  @Autowired
  public RepositoryBaseImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
    super(entityInformation, entityManager);
    this.entityManager = entityManager;
  }

  // TODO: implementar Override do delete, deleteAll, save, saveAll e saveAndFlush guardando um Tracker automático

}
