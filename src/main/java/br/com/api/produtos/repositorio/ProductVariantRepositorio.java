package br.com.api.produtos.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.api.produtos.modelo.ProductVariant;

@Repository
public interface ProductVariantRepositorio extends CrudRepository<ProductVariant, Long> {
}