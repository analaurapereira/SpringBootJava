package unifacef.edu.primevideo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.primevideo.model.DTO.FilmeDTO;
import unifacef.edu.primevideo.model.entity.FilmeEntity;
import unifacef.edu.primevideo.model.repository.FilmeRepository;

@Service
public class FilmeService {
    //injeção de dependência
    @Autowired
    FilmeRepository injecao;

    public FilmeDTO insert(FilmeDTO filmedto){
        //convertemos DTO em Entity para enviar ao BD
        FilmeEntity entidade= converteDTO(filmedto);
        FilmeEntity resposta =  injecao.save(entidade);
       return convertEntity(resposta);
    }

    //converte FilmeDTO em FilmeEntity
    public FilmeEntity converteDTO(FilmeDTO filmedto){
        return new FilmeEntity(filmedto.getId(), filmedto.getNome(), filmedto.getAnoLancamento(), filmedto.getNota());
    }

    //converte FilmeEntity em FilmeDTO
    public FilmeDTO convertEntity(FilmeEntity filmeEntity){
        return new FilmeDTO(filmeEntity.getId(), filmeEntity.getNome(), filmeEntity.getAnoLancamento(), filmeEntity.getNota());
    }
}
