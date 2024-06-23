package jp.co.pokexample.entity.species;

import java.net.MalformedURLException;
import java.net.URL;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@ToString
public class Variety {

  String name;
  String id;

  Variety(String name, String urlString) {
    this.name = name;
    try {
      URL url = new URL(urlString);
      String[] pathList = url.getPath().split("/");
      // Pathの最後がIDとなっている
      this.id = pathList[pathList.length - 1];
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }
}
