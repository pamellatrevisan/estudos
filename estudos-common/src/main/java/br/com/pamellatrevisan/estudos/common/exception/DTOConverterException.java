package br.com.pamellatrevisan.estudos.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class DTOConverterException extends RuntimeException {

  private static final long serialVersionUID = 2265258008263951311L;

}
