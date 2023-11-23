package com.example.secondpract.controller;

import com.example.secondpract.dao.ProductDAO;
import com.example.secondpract.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductDAO _productDAO;

    @Autowired
    public ProductController(ProductDAO productDAO) {
        _productDAO = productDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("products", _productDAO.index());
        return "products/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", _productDAO.show(id));
        return "products/show";
    }

    @GetMapping("/new")
    public String newProduct(@ModelAttribute("product") ProductModel productModel) {
        return "products/new";
    }

    @PostMapping()
    public String createProduct(@ModelAttribute("product") ProductModel productModel) {
        _productDAO.save(productModel);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("product", _productDAO.show(id));
        return "products/edit";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@ModelAttribute("product") ProductModel productModel, @PathVariable("id") int id) {
        _productDAO.update(id, productModel);
        return "redirect:/products";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        _productDAO.delete(id);
        return "redirect:/products";
    }
}
