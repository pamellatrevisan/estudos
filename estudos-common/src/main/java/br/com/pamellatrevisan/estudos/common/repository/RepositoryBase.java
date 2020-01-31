package br.com.pamellatrevisan.estudos.common.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.pamellatrevisan.estudos.common.model.EntityBase;

@NoRepositoryBean
public interface RepositoryBase<T extends EntityBase<ID>, ID extends Serializable> extends JpaRepository<T, ID> {

  EntityManager getEntityManager();

}
