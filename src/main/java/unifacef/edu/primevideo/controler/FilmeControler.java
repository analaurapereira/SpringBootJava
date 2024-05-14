package unifacef.edu.primevideo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unifacef.edu.primevideo.model.DTO.FilmeDTO;
import unifacef.edu.primevideo.service.FilmeService;

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


}
