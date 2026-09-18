package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.modelo.Inscricao;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.servico.InscricaoServico;

@RestController
@RequestMapping("/inscricoes")
@CrossOrigin(origins = "*")
public class InscricaoControle {

    @Autowired
    private InscricaoServico isv;

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo) {
        return isv.remover(codigo);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Inscricao obj) {
        return isv.cadastrarAlterar(obj, "alterar");
    }

    // Aceita tanto POST em "/inscricoes" quanto em "/inscricoes/cadastrar"
    @PostMapping(value = {"", "/cadastrar"})
    public ResponseEntity<?> cadastrar(@RequestBody Inscricao obj) {
        return isv.cadastrarAlterar(obj, "cadastrar");
    }

    // Aceita tanto GET em "/inscricoes" quanto em "/inscricoes/listar"
    @GetMapping(value = {"", "/listar"})
    public Iterable<Inscricao> listar() {
        return isv.listar();
    }
}