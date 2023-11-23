package com.example.secondpract.dao;

import com.example.secondpract.model.ProductModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAO {
    private static int PRODUCT_COUNT;
    private List<ProductModel> products;

    {
        products = new ArrayList<>();

        products.add(new ProductModel(++PRODUCT_COUNT, "Product1", 29.99, "Category1"));
        products.add(new ProductModel(++PRODUCT_COUNT, "Product2", 39.99, "Category2"));
        products.add(new ProductModel(++PRODUCT_COUNT, "Product3", 19.99, "Category1"));
        products.add(new ProductModel(++PRODUCT_COUNT, "Product4", 49.99, "Category3"));
    }

    public List<ProductModel> index() {
        return products;
    }

    public ProductModel show(int id) {
        return products.stream().filter(product -> product.getId() == id).findAny().orElse(null);
    }

    public void save(ProductModel product) {
        product.setId(++PRODUCT_COUNT);
        products.add(product);
    }

    public void update(int id, ProductModel productModel) {
        ProductModel updateProduct = show(id);
        updateProduct.setProductName(productModel.getProductName());
        updateProduct.setPrice(productModel.getPrice());
        updateProduct.setCategory(productModel.getCategory());
    }

    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}
