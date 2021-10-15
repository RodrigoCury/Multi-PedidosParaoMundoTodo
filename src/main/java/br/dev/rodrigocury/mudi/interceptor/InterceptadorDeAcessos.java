package br.dev.rodrigocury.mudi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class InterceptadorDeAcessos implements HandlerInterceptor {

  public static List<Acesso> listaAcessos = new ArrayList<>();

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    Acesso acesso = new Acesso();
    acesso.path = request.getRequestURI();
    acesso.data = LocalDateTime.now();

    request.setAttribute("acesso", acesso);

    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    Acesso acesso = (Acesso) request.getAttribute("acesso");
    acesso.duration = Duration.between(acesso.data, LocalDateTime.now());
    listaAcessos.add(acesso);
  }

  public static List<Acesso> getListaAcessos() {
    return listaAcessos;
  }

  public static class Acesso {
    private String path;
    private LocalDateTime data;
    private Duration duration;

    @Override
    public String toString() {
      return String.format("P: %s, Dia: %s - duração : %d", this.path, this.data, this.duration);
    }

    /**
     * @return String return the path
     */
    public String getPath() {
      return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
      this.path = path;
    }

    /**
     * @return LocalDateTime return the data
     */
    public LocalDateTime getData() {
      return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(LocalDateTime data) {
      this.data = data;
    }

    /**
     * @return Duration return the duration
     */
    public Duration getDuration() {
      return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Duration duration) {
      this.duration = duration;
    }
  }

}
