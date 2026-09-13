package br.com.api.produtos.repositorio;

import br.com.api.produtos.modelo.Inscricao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRepositorio extends CrudRepository<Inscricao, Long> {
}