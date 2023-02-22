package ssii.pai1;
import com.github.cliftonlabs.json_simple.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("data")
public class DataController {

  @Autowired
  DataService dataService;
  
  @GetMapping()
  @CrossOrigin(origins = "http://localhost:5173")
  public JsonObject getData(String nombreFichero, String token, RetoEnum retoEnum) {
    JsonObject json = new JsonObject();
    json.put("hash", dataService.generarHash(nombreFichero, token, retoEnum));
    return json;
  }

  @GetMapping("/all")
  @CrossOrigin(origins = "http://localhost:5173")
  public JsonObject getAll() {
    return dataService.getAll();
  }
}
