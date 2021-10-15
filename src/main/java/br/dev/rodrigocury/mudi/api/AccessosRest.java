package br.dev.rodrigocury.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.rodrigocury.mudi.interceptor.InterceptadorDeAcessos;
import br.dev.rodrigocury.mudi.interceptor.InterceptadorDeAcessos.Acesso;

@RestController
@RequestMapping("/acessos")
public class AccessosRest {

  @GetMapping
  public List<Acesso> getAcessos() {
    return InterceptadorDeAcessos.getListaAcessos();
  }
}
