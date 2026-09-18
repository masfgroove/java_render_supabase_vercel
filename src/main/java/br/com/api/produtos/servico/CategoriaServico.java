package br.com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.Categoria;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServico {

    @Autowired
    private CategoriaRepositorio acao;

    @Autowired
    private RespostaModelo resposta;

    // Listar categorias
    public Iterable<Categoria> listar() {
        return acao.findAll();
    }

    // Cadastrar ou Alterar Categoria
    public ResponseEntity<?> cadastrarAlterar(Categoria obj, String acaoTipo) {
        if (obj.getName() == null || obj.getName().isEmpty()) {
            resposta.setMensagem("O nome da categoria é obrigatório!");
            return new ResponseEntity<RespostaModelo>(resposta, HttpStatus.BAD_REQUEST);
        } else {
            if (acaoTipo.equals("cadastrar")) {
                return new ResponseEntity<Categoria>(acao.save(obj), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Categoria>(acao.save(obj), HttpStatus.OK);
            }
        }
    }

    // Remover Categoria
    public ResponseEntity<RespostaModelo> remover(Long id) {
        acao.deleteById(id);
        resposta.setMensagem("A categoria foi removida com sucesso!");
        return new ResponseEntity<RespostaModelo>(resposta, HttpStatus.OK);
    }
}