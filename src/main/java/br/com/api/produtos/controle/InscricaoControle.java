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
// Libera todas as origens, métodos (GET, POST, PUT, DELETE, OPTIONS) e cabeçalhos
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {
    org.springframework.web.bind.annotation.RequestMethod.GET,
    org.springframework.web.bind.annotation.RequestMethod.POST,
    org.springframework.web.bind.annotation.RequestMethod.PUT,
    org.springframework.web.bind.annotation.RequestMethod.DELETE,
    org.springframework.web.bind.annotation.RequestMethod.OPTIONS
})
public class InscricaoControle {

    @Autowired
    private InscricaoServico isv;

    // Aceita GET em "/inscricoes" e "/inscricoes/listar"
    @GetMapping(value = {"", "/listar"})
    public Iterable<Inscricao> listar() {
        return isv.listar();
    }

    // Aceita POST em "/inscricoes" e "/inscricoes/cadastrar"
    @PostMapping(value = {"", "/cadastrar"})
    public ResponseEntity<?> cadastrar(@RequestBody Inscricao obj) {
        return isv.cadastrarAlterar(obj, "cadastrar");
    }

    // Aceita PUT em "/inscricoes", "/inscricoes/alterar" e "/inscricoes/{codigo}"
    @PutMapping(value = {"", "/alterar", "/{codigo}"})
    public ResponseEntity<?> alterar(@RequestBody Inscricao obj, @PathVariable(required = false) Long codigo) {
        if (codigo != null) {
            obj.setId(codigo);
        }
        return isv.cadastrarAlterar(obj, "alterar");
    }

    // Aceita DELETE em "/inscricoes/{codigo}" e "/inscricoes/remover/{codigo}"
    @DeleteMapping(value = {"/{codigo}", "/remover/{codigo}"})
    public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo) {
        return isv.remover(codigo);
    }
}