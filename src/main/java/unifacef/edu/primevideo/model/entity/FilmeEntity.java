package unifacef.edu.primevideo.model.entity;

import jakarta.persistence.*;

@Entity //entidade do banco de dados
@Table(name = "filme") //tabela filme do banco de dados
public class FilmeEntity {
    @Id //chave primaria
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "anoLancamento")
    private int anoLancamento;
    @Column(name = "nota")
    private float nota;
}
