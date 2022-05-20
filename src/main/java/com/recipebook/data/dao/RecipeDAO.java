package com.recipebook.data.dao;

import com.recipebook.data.bean.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author pallavi
 */

@Repository
public interface  RecipeDAO extends JpaRepository<Recipe, Long> {

}
