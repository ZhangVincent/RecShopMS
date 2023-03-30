package com.zkp.recshop.dto;

/**
 * 物品分类实体类代码
 */
public class Category {
    private int categoryId;
    private String categoryName;
    private String categoryIcon;
    private String categoryStatus;

    public Category() {
    }

    public Category(int category_id, String category_name, String category_icon, String category_status) {
        this.categoryId = category_id;
        this.categoryName = category_name;
        this.categoryIcon = category_icon;
        this.categoryStatus = category_status;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + categoryId +
                ", category_name='" + categoryName + '\'' +
                ", category_icon='" + categoryIcon + '\'' +
                ", category_status='" + categoryStatus + '\'' +
                '}';
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    public String getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(String categoryStatus) {
        this.categoryStatus = categoryStatus;
    }
}
