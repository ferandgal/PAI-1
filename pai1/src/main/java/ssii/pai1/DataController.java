package ssii.pai1;
import com.github.cliftonlabs.json_simple.JsonObject;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("data")
public class DataController {

  @Autowired
  DataService dataService;
  
  // @PostMapping()
  // @CrossOrigin(origins = "http://localhost:5173")
  // public JsonObject getData(@Valid DataDTO data) {
  //   JsonObject json = new JsonObject();
  //   json.put("hash", dataService.generarHash(data));
  //   return json;
  // }

  @PostMapping()
  @CrossOrigin(origins = "http://localhost:5173")
  public String getData(@RequestBody @Valid DataDTO data) {
    return dataService.generarHash(data);
  }

  @GetMapping("/all")
  @CrossOrigin(origins = "http://localhost:5173")
  public JsonObject getAll() {
    return dataService.getAll();
  }
}
