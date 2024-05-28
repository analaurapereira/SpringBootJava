package unifacef.edu.primevideo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.primevideo.model.DTO.FilmeDTO;
import unifacef.edu.primevideo.model.entity.FilmeEntity;
import unifacef.edu.primevideo.model.repository.FilmeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<FilmeDTO> consultaTodos(){
        return convertEntities(injecao.findAll()); //Retorna lista de filme entity. Deve ser convertida em filme dto
    }

    public List<FilmeDTO> convertEntities(List<FilmeEntity> filmesEntity){

        List<FilmeDTO> filmesDTos = new ArrayList<FilmeDTO>();
        for(FilmeEntity filmeEntity: filmesEntity){
            filmesDTos.add(convertEntity(filmeEntity));
        }

        return filmesDTos;
    }

    public FilmeDTO consultaPorId(Long id){
        // retorna um valor opcional, pois pode encontrar ou não
        Optional<FilmeEntity> optional = injecao.findById(id);

        if(optional.isPresent()){
            return convertEntity(optional.get());
        }

        else return null;
    }

    //remove filme por id
    public String remove(Long id){
       if(injecao.existsById(id)){
           injecao.deleteById(id);
           return "Remoção com sucesso";
       }

       else{ return "Filme não encontrado"; }
    }

    public List<FilmeDTO> atualizaNota10(){ //exemplo de PUT Maping (update)
        List<FilmeEntity> filmes = injecao.findAll(); //pega todos os filmes e coloca numa lista
        for(FilmeEntity filme: filmes) { //para cada filme percorrendo na lista filmes
            filme.setNota(10);
            injecao.save(filme); //setou como 10 em cima e usou o save para atualizar no DB
        }
        return converteEntities(filmes); //retornando o DTO para o front
    }
    public FilmeDTO atualizaId (Long id, FilmeDTO filmedto){ // exemplo de PatchMapping (update com Where)
        if(injecao.existsById(id)){ //verifica se o filme existe
            filmedto.setId(id); // defino o id do objeto para aterar
            // 1° converte filmeDTO em filmeEntity
            // 2° converte filmeEntity no BD
            // 3° converte filmeEntity em filmeDTO e retorno
            return convertEntity(injecao.save(converteDTO(filmedto)));
        }else{
            return null; //filme não existe
        }
    }

    public List<FilmeDTO> converteEntities(List<FilmeEntity> filmesEntities){
        //cria uma lista de FilmeDTO
        List<FilmeDTO> filmeDTOs = new ArrayList<FilmeDTO>();

        //percore filmeEntities
        for(FilmeEntity filmeEntity: filmesEntities){
            filmeDTOs.add(convertEntity(filmeEntity));
        }
        return filmeDTOs;
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
