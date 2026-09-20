package br.com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.Pedido;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repositorio.PedidoRepositorio;

@Service
public class PedidoServico {

    @Autowired
    private PedidoRepositorio acao;

    @Autowired
    private RespostaModelo resposta;

    public Iterable<Pedido> listar() {
        return acao.findAll();
    }

    public ResponseEntity<?> cadastrarAlterar(Pedido obj, String acaoTipo) {
        if (obj.getTotalAmount() == null) {
            resposta.setMensagem("O valor total do pedido é obrigatório!");
            return new ResponseEntity<RespostaModelo>(resposta, HttpStatus.BAD_REQUEST);
        } else {
            if (acaoTipo.equals("cadastrar")) {
                return new ResponseEntity<Pedido>(acao.save(obj), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Pedido>(acao.save(obj), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<RespostaModelo> remover(Long id) {
        acao.deleteById(id);
        resposta.setMensagem("O pedido foi removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(resposta, HttpStatus.OK);
    }
}