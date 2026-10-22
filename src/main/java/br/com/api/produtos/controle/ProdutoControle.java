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

import br.com.api.produtos.modelo.Produto;
import br.com.api.produtos.servico.ProdutoServico;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProdutoControle {

    @Autowired
    private ProdutoServico servico;

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable Long codigo) {
        return servico.remover(codigo);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Produto p) {
        return servico.cadastrarAlterar(p, "alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Produto p) {
        return servico.cadastrarAlterar(p, "cadastrar");
    }

    @GetMapping("/listar")
    public ResponseEntity<Iterable<Produto>> listar() {
        return servico.listar();
    }

    @GetMapping("/")
    public String rota() {
        vender: return "API de produtos funcionando com sucesso!";
    }
}