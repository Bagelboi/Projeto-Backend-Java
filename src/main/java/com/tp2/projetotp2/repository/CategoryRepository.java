package com.tp2.projetotp2.repository;

import com.tp2.projetotp2.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
