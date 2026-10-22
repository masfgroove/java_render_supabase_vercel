package br.com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.Produto;
import br.com.api.produtos.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio acao;

    // Método para listar todos os produtos
    public ResponseEntity<Iterable<Produto>> listar() {
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }

    // Método para cadastrar ou alterar produtos
    public ResponseEntity<?> cadastrarAlterar(Produto p, String tipoAcao) {
        if (p.getNome() == null || p.getNome().trim().isEmpty()) {
            return new ResponseEntity<>("O nome do produto é obrigatório!", HttpStatus.BAD_REQUEST);
        } else if (p.getValor() == null) {
            return new ResponseEntity<>("O valor do produto é obrigatório!", HttpStatus.BAD_REQUEST);
        } else {
            if (tipoAcao.equals("cadastrar")) {
                return new ResponseEntity<>(acao.save(p), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(acao.save(p), HttpStatus.OK);
            }
        }
    }

    // Método para remover produto
    public ResponseEntity<Void> remover(Long codigo) {
        acao.deleteById(codigo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}