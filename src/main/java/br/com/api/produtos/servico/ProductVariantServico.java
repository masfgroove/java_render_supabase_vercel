package br.com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.ProductVariant;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repositorio.ProductVariantRepositorio;

@Service
public class ProductVariantServico {

    @Autowired
    private ProductVariantRepositorio acao;

    @Autowired
    private RespostaModelo resposta;

    public Iterable<ProductVariant> listar() {
        return acao.findAll();
    }

    public ResponseEntity<?> cadastrarAlterar(ProductVariant obj, String acaoTipo) {
        if (obj.getStock() == null) {
            resposta.setMensagem("O stock da variante é obrigatório!");
            return new ResponseEntity<RespostaModelo>(resposta, HttpStatus.BAD_REQUEST);
        } else {
            if (acaoTipo.equals("cadastrar")) {
                return new ResponseEntity<ProductVariant>(acao.save(obj), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<ProductVariant>(acao.save(obj), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<RespostaModelo> remover(Long id) {
        acao.deleteById(id);
        resposta.setMensagem("A variante foi removida com sucesso!");
        return new ResponseEntity<RespostaModelo>(resposta, HttpStatus.OK);
    }
}