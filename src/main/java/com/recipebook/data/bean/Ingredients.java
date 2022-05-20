package com.recipebook.data.bean;

import javax.persistence.*;

@Entity
@Table(name = "INGREDIENTS")
public class Ingredients {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RECIPE_ID", nullable = false)
    private Long recipe;
    private Long id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRecipe() {
        return recipe;
    }

    public void setRecipe(Long recipe) {
        this.recipe = recipe;
    }

    @Column(name = "NAME", nullable = false, unique=true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
