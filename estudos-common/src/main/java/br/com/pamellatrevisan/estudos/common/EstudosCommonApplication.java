package br.com.pamellatrevisan.estudos.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EstudosCommonApplication {

  public static void main(String[] args) {
    SpringApplication.run(EstudosCommonApplication.class, args);
  }

}
