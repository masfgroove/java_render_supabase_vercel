package br.com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.Inscricao;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repositorio.InscricaoRepositorio;

@Service
public class InscricaoServico {

    @Autowired
    private InscricaoRepositorio ir;

    public Iterable<Inscricao> listar() {
        return ir.findAll();
    }

    public ResponseEntity<?> cadastrarAlterar(Inscricao obj, String acao) {
        RespostaModelo rm = new RespostaModelo();

        if (obj.getNomeCompleto() == null || obj.getNomeCompleto().trim().isEmpty()) {
            rm.setMensagem("O nome completo do modelo é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if (obj.getTelefone() == null || obj.getTelefone().trim().isEmpty()) {
            rm.setMensagem("O telefone de contato é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                obj.setId(null);
                Inscricao salva = ir.save(obj);
                return new ResponseEntity<Inscricao>(salva, HttpStatus.CREATED);
            } else {
                Inscricao salva = ir.save(obj);
                return new ResponseEntity<Inscricao>(salva, HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<RespostaModelo> remover(long codigo) {
        RespostaModelo rm = new RespostaModelo();
        ir.deleteById(codigo);
        rm.setMensagem("A inscrição foi removida com sucesso!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }
}