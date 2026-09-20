package br.com.api.produtos.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.api.produtos.modelo.Pedido;

@Repository
public interface PedidoRepositorio extends CrudRepository<Pedido, Long> {
}