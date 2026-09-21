package br.com.api.produtos.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.api.produtos.modelo.Cliente;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {
}