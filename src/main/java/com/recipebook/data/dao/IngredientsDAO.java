package com.recipebook.data.dao;

import com.recipebook.data.bean.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pallavi
 * Repository to connect to INGREDIENTS table.
 */

public interface IngredientsDAO extends JpaRepository<Ingredients, Long> {

}
