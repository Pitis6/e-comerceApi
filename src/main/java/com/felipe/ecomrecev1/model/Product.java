package com.felipe.ecomrecev1.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "productsCollection")
public class Product implements Serializable {

    private static final long serialversinUID = 1L;

        @Id
        private String id;
        private String slug;
        private String name;
        private Image image;
        private String category;

        private CategoryImage categoryImage;
        private Boolean  isNew;
        private Double price;
        private String description;
        private String features;
        private List<IncludedItems> includes;
        private Gallery gallery;

        public Product() {
        }

    public Product(String slug, String name, Image image, String category, CategoryImage categoryImage, Boolean isNew, Double price, String description, String features, List<IncludedItems> includes, Gallery gallery) {
        this.slug = slug;
        this.name = name;
        this.image = image;
        this.category = category;
        this.categoryImage = categoryImage;
        this.isNew = isNew;
        this.price = price;
        this.description = description;
        this.features = features;
        this.includes = includes;
        this.gallery = gallery;
    }

    public Product(Product product) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CategoryImage getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(CategoryImage categoryImage) {
        this.categoryImage = categoryImage;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public List<IncludedItems> getIncludes() {
        return includes;
    }

    public void setIncludes(List<IncludedItems> includes) {
        this.includes = includes;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }
}



