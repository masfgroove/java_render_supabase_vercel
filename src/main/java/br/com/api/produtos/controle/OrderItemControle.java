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

import br.com.api.produtos.modelo.OrderItem;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.servico.OrderItemServico;

@RestController
@RequestMapping("/order-items")
@CrossOrigin(origins = "*")
public class OrderItemControle {

    @Autowired
    private OrderItemServico servico;

    @GetMapping("/listar")
    public Iterable<OrderItem> listar() {
        return servico.listar();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody OrderItem obj) {
        return servico.cadastrarAlterar(obj, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody OrderItem obj) {
        return servico.cadastrarAlterar(obj, "alterar");
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable Long id) {
        return servico.remover(id);
    }
}