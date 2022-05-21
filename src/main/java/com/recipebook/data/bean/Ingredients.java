package com.recipebook.data.bean;

import javax.persistence.*;

/**
 * @author pallavi
 * Repository to connect to INGREDIENTS table.
 */
@Entity
@Table(name = "INGREDIENTS")
public class Ingredients {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RECIPE_ID", nullable = false)
    private Long recipe;
    private Long id;
    private String name;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the recipe
     */
    public Long getRecipe() {
        return recipe;
    }

    /**
     * @param recipe the recipe to set
     */
    public void setRecipe(Long recipe) {
        this.recipe = recipe;
    }

    /**
     * @return the name
     */
    @Column(name = "NAME", nullable = false, unique=true)
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
