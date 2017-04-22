package ua.rozborsky.shop.interfaces;

import ua.rozborsky.shop.classes.Category;

import java.util.List;

/**
 * Created by roman on 21.04.2017.
 */
public interface DaoGoods {
    List<Category> getCategories();
    Category getCategory();
    void addCategory(Category category);
    void deleteCategory(String name);
}
