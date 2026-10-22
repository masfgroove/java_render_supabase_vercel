package br.com.api.produtos.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "mp_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @JsonProperty("name")
    @Column(nullable = false)
    private String nome;

    @JsonProperty("description")
    @Column(columnDefinition = "TEXT")
    private String descricao;

    @JsonProperty("price")
    @Column(nullable = false)
    private BigDecimal valor;

    @JsonProperty("stock")
    @Column(nullable = false)
    private Integer estoque;

    @JsonProperty("imageUrl")
    @Column(name = "image_url", columnDefinition = "TEXT")
    private String imageUrl;

    @JsonProperty("categoria")
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // Construtor Vazio obrigatório pelo JPA
    public Produto() {}

    // Getters e Setters
    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public Integer getEstoque() { return estoque; }
    public void setEstoque(Integer estoque) { this.estoque = estoque; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}