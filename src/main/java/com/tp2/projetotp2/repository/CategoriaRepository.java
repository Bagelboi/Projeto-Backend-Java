package com.tp2.projetotp2.repository;

import com.tp2.projetotp2.model.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {

}
