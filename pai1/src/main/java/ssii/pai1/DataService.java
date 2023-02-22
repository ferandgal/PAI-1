package ssii.pai1;
import java.util.Base64;
import org.springframework.stereotype.Service;

import com.github.cliftonlabs.json_simple.JsonObject;

@Service
public class DataService {

  public String generarHash(DataDTO data){
    String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    
    for (int i = 0; i < data.getToken().length(); i++) {
        if(!banco.contains(String.valueOf(data.getToken().charAt(i)))) {
            return "Caracter no permitido";
        }
    }
    
    String cadenaBase64 = "";
    String entradaOriginal = data.getFichero();
    String cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());
    
    if(data.getReto() == RetoEnum.RETO1) {
    cadenaBase64 = cadenaCodificada + data.getToken();
    }else if(data.getReto() == RetoEnum.RETO2){
    cadenaBase64 = data.getToken() + cadenaCodificada;
    } else {
      return "Tipo de reto no permitido";
    }

    String hash = hashUtils.sha256(cadenaBase64);
    
    return hash;
  }

  public JsonObject getAll() {
    JsonObject json = new JsonObject();
    json.put("fichero1", "clients-emails");
    json.put("fichero2", "presupuesto2020");
    json.put("fichero3", "coches");
    json.put("fichero4", "notasSSII");
    json.put("fichero5", "preciosIVA");
    json.put("fichero6", "confidencial");
    return json;
  }
  
}
