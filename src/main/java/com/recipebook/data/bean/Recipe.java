package com.recipebook.data.bean;


import javax.persistence.*;
import java.util.Date;

/**
 * @author pallavi
 */

@Entity
@Table(name = "RECIPE")
public class Recipe {

    private Long id;
    private String name;
    private Date dateCreated;
    private Boolean isVeg;
    private Integer serves;
    private String ingredients;
    private String instructions;

    public Recipe() {
    }

    public Recipe(String name, Date dateCreated, Boolean isVeg, Integer serves, String ingredients, String instructions) {

        this.name = name;
        this.dateCreated = dateCreated;
        this.isVeg = isVeg;
        this.serves = serves;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

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
     * @return the name
     */
    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dateCreated
     */
    @Column(name = "DATECREATED", nullable = false)
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * @param dateCreated the dateCreated to set
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * @return the isVeg
     */
    @Column(name = "ISVEG", nullable = false)
    public Boolean getIsVeg() {
        return isVeg;
    }

    /**
     * @param isVeg the isVeg to set
     */
    public void setIsVeg(Boolean isVeg) {
        this.isVeg = isVeg;
    }

    /**
     * @return the serves
     */
    @Column(name = "SERVES", nullable = false)
    public Integer getServes() {
        return serves;
    }

    /**
     * @param serves the serves to set
     */
    public void setServes(Integer serves) {
        this.serves = serves;
    }

    /**
     * @return the ingredients
     */
    @Column(name = "INGREDIENTS", nullable = false)
    public String getIngredients() {
        return ingredients;
    }

    /**
     * @param ingredients the ingredients to set
     */
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * @return the instructions
     */
    @Column(name = "INSTRUCTIONS", nullable = false)
    public String getInstructions() {
        return instructions;
    }

    /**
     * @param instructions the instructions to set
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
