package com.example.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/detail/{id}")
    @ResponseBody
    public String detail(@PathVariable String id) {
        try {
            int productId = Integer.parseInt(id);
            if (productId <= 0) {
                return "Error: Product ID must be greater than 0.";
            }
            return "Product ID = " + productId;
        } catch (NumberFormatException exception) {
            return "Error: Product ID is invalid.";
        }
    }

    @GetMapping("/category")
    @ResponseBody
    public String category(@RequestParam(required = false) String name) {
        if (name == null || name.isBlank()) {
            return "Error: Category name is required.";
        }
        return "Category = " + name;
    }
}
