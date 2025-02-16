package com.tacocloud.taco_cloud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tacocloud.taco_cloud.Ingredient;

@Repository
public class JdbcIngredientRepository implements IngredientRepository
{

    private JdbcTemplate jdbcTemplate;

    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable <Ingredient> findAll()
    {
        return jdbcTemplate.query("SELECT id, name, type FROM Ingredient", this::mapRowToIngredient);
    }

    @Override
    public Optional <Ingredient> findById(String id)
    {
        List<Ingredient> results = jdbcTemplate.query("SELECT id, name, type FROM Ingredient where id=?", this::mapRowToIngredient, id);

        return results.size()==0 ? Optional.empty() : Optional.of(results.get(0));
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException
    {
        return new Ingredient(row.getString("id"), row.getString("name"), Ingredient.Type.valueOf(row.getString("type")));
    }

    @Override
    public Ingredient save(Ingredient ingredient)
    {
        jdbcTemplate.update("INSERT into Ingredient (id, name, type) values (?, ?, ?)", ingredient.getId(), ingredient.getName(), ingredient.getType().toString());

        return ingredient;
    }

}
