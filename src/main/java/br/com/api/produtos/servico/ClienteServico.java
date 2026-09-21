package br.com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.Cliente;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repositorio.ClienteRepositorio;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepositorio acao;

    @Autowired
    private RespostaModelo resposta;

    public Iterable<Cliente> listar() {
        return acao.findAll();
    }

    public ResponseEntity<?> cadastrarAlterar(Cliente obj, String acaoTipo) {
        if (obj.getName() == null || obj.getName().isEmpty()) {
            resposta.setMensagem("O nome do cliente é obrigatório!");
            return new ResponseEntity<RespostaModelo>(resposta, HttpStatus.BAD_REQUEST);
        } else if (obj.getEmail() == null || obj.getEmail().isEmpty()) {
            resposta.setMensagem("O email do cliente é obrigatório!");
            return new ResponseEntity<RespostaModelo>(resposta, HttpStatus.BAD_REQUEST);
        } else {
            if (acaoTipo.equals("cadastrar")) {
                return new ResponseEntity<Cliente>(acao.save(obj), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Cliente>(acao.save(obj), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<RespostaModelo> remover(Long id) {
        acao.deleteById(id);
        resposta.setMensagem("O cliente foi removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(resposta, HttpStatus.OK);
    }
}