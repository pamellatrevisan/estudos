package br.com.pamellatrevisan.estudos.common.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.pamellatrevisan.estudos.common.exception.DTOConverterException;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class EntityUtils {

  private final ObjectMapper objectMapper;

  public EntityUtils(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  public <T extends EntityBase<ID>, ID extends Serializable> T fromDTO(Object dto, Class<T> className) {
    return fromDTO(dto, className, null);
  }

  public <T extends EntityBase<ID>, ID extends Serializable> T fromDTO(Object dto, T entity) {
    return fromDTO(dto, entity, null);
  }

  public <T extends EntityBase<ID>, ID extends Serializable> T fromDTO(Object dto, Class<T> className, Class<?> serializationView) {
    try {
      T entity = className.getConstructor()
        .newInstance();
      return fromDTO(dto, entity, serializationView);
    } catch (Exception e) {
      log.error(e);
      throw new DTOConverterException();
    }
  }

  public <T extends EntityBase<ID>, ID extends Serializable> T fromDTO(Object dto, T entity, Class<?> serializationView) {
    try {
      String jsonInString = null;
      if (Objects.isNull(serializationView)) {
        jsonInString = this.objectMapper.writeValueAsString(dto);
      } else {
        jsonInString = this.objectMapper.writerWithView(serializationView)
          .writeValueAsString(dto);
      }
      return this.objectMapper.readerForUpdating(entity)
        .readValue(jsonInString);
    } catch (Exception e) {
      log.error(e);
      throw new DTOConverterException();
    }
  }

  public <D, ID extends Serializable> D toDTO(EntityBase<ID> entity, Class<D> dtoClassName) {
    return toDTO(entity, dtoClassName, null);
  }

  public <D, ID extends Serializable> D toDTO(EntityBase<ID> entity, Class<D> dtoClassName, Class<?> serializationView) {
    try {
      String json = null;
      if (Objects.isNull(serializationView)) {
        json = this.objectMapper.writeValueAsString(entity);
      } else {
        json = this.objectMapper.writerWithView(serializationView)
          .writeValueAsString(entity);
      }
      return this.objectMapper.readValue(json, dtoClassName);
    } catch (Exception e) {
      log.error(e);
      throw new DTOConverterException();
    }
  }

  public <T extends EntityBase<ID>, ID extends Serializable> T fromJson(String json, Class<T> className) {
    try {
      return this.objectMapper.readValue(json, className);
    } catch (Exception e) {
      log.error(e);
      throw new DTOConverterException();
    }
  }

}
