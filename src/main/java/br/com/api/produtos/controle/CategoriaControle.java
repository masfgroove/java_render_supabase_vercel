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

import br.com.api.produtos.modelo.Categoria;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.servico.CategoriaServico;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaControle {

    @Autowired
    private CategoriaServico servico;

    @GetMapping("")
    public Iterable<Categoria> listar() {
        return servico.listar();
    }

    @PostMapping("")
    public ResponseEntity<?> cadastrar(@RequestBody Categoria obj) {
        return servico.cadastrarAlterar(obj, "cadastrar");
    }

    @PutMapping("")
    public ResponseEntity<?> alterar(@RequestBody Categoria obj) {
        return servico.cadastrarAlterar(obj, "alterar");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable Long id) {
        return servico.remover(id);
    }
}