package com.recipebook.data.dao;

import com.recipebook.data.bean.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsDAO extends JpaRepository<Ingredients, Long> {

}
