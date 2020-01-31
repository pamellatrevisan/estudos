package br.com.pamellatrevisan.estudos.common.model;

import java.io.Serializable;

public interface EntityBase<ID extends Serializable> extends Serializable {

  public ID getId();
}
