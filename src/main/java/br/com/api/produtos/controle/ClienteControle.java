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

import br.com.api.produtos.modelo.Cliente;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.servico.ClienteServico;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "*")
public class ClienteControle {

    @Autowired
    private ClienteServico servico;

    @GetMapping("/listar")
    public Iterable<Cliente> listar() {
        return servico.listar();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Cliente obj) {
        return servico.cadastrarAlterar(obj, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Cliente obj) {
        return servico.cadastrarAlterar(obj, "alterar");
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable Long id) {
        return servico.remover(id);
    }
}