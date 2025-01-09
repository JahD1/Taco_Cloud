package com.tacocloud.taco_cloud;

import java.util.Optional;
import com.tacocloud.taco_cloud.Ingredient;

public interface IngredientRepository {


    Iterable <Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);


}
