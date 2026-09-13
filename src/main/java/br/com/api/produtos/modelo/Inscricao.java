package br.com.api.produtos.modelo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inscricoes")
public class Inscricao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nomeCompleto;
    private Integer idade;
    private String nomeResponsavel;
    private String telefone;
    private String email;
    private String lojaIndicacao;
    
    @Column(length = 1000)
    private String fotoUrl;
    
    private LocalDateTime dataInscricao = LocalDateTime.now();

    public Inscricao() {
    }

    public Inscricao(String nomeCompleto, Integer idade, String nomeResponsavel, String telefone, String email, String lojaIndicacao, String fotoUrl) {
        this.nomeCompleto = nomeCompleto;
        this.idade = idade;
        this.nomeResponsavel = nomeResponsavel;
        this.telefone = telefone;
        this.email = email;
        this.lojaIndicacao = lojaIndicacao;
        this.fotoUrl = fotoUrl;
        this.dataInscricao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLojaIndicacao() {
        return lojaIndicacao;
    }

    public void setLojaIndicacao(String lojaIndicacao) {
        this.lojaIndicacao = lojaIndicacao;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public LocalDateTime getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(LocalDateTime dataInscricao) {
        this.dataInscricao = dataInscricao;
    }
}