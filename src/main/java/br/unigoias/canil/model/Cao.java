package br.unigoias.canil.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "raca_id")
    private Raca raca;

    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(length = 1, nullable = false)
    private CaoSexoEnum sexo;

    @CreationTimestamp
    @Column(name = "data_inclusao", nullable = false)
    private Date dataInclusao;

    public Cao() {
    }

    public Cao(Long id, Raca raca, String nome, CaoSexoEnum sexo, Date dataInclusao) {
        this.id = id;
        this.raca = raca;
        this.nome = nome;
        this.sexo = sexo;
        this.dataInclusao = dataInclusao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CaoSexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(CaoSexoEnum sexo) {
        this.sexo = sexo;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }
}
