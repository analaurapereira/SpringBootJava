package unifacef.edu.primevideo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unifacef.edu.primevideo.model.DTO.FilmeDTO;
import unifacef.edu.primevideo.service.FilmeService;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeControler {
    // injeção de dependência
    @Autowired
    FilmeService injecao;

    @PostMapping
    public FilmeDTO insert(@RequestBody FilmeDTO filmedto){
        return injecao.insert(filmedto);
    }

    @GetMapping
    public List<FilmeDTO> consultaTodos(){
        return injecao.consultaTodos();
    }

    @GetMapping("/{id}")
    public FilmeDTO consultarPorId(@PathVariable Long id){
        return injecao.consultaPorId(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable Long id){
        return injecao.remove(id);
    }
}
