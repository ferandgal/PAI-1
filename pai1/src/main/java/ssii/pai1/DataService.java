package ssii.pai1;
import java.util.Base64;
import org.springframework.stereotype.Service;

import com.github.cliftonlabs.json_simple.JsonObject;

@Service
public class DataService {

  public String generarHash(String entrada, String clave, RetoEnum reto){
    String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    
    for (int i = 0; i < clave.length(); i++) {
        if(!banco.contains(String.valueOf(clave.charAt(i)))) {
            return "Caracter no permitido";
        }
    }
    
    String cadenaBase64 = "";
    String entradaOriginal = entrada;
    String cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());
    
    if(reto == RetoEnum.RETO1) {
    cadenaBase64 = cadenaCodificada + clave;
    }else if(reto == RetoEnum.RETO2){
    cadenaBase64 = clave + cadenaCodificada;
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
