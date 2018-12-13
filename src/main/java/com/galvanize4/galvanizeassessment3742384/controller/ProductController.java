package com.galvanize4.galvanizeassessment3742384.controller;

import com.galvanize4.galvanizeassessment3742384.entity.Product;
import com.galvanize4.galvanizeassessment3742384.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search/price/{price}")
    public Iterable<Product> searchByPrice(@PathVariable Double price) {
        return productService.searchByPrice(price);
    }
    @GetMapping("/search/color/{color}")
    public Iterable<Product> searchByColor(@PathVariable String color) {
        return productService.searchByColor(color);
    }

    @GetMapping("/search/brand/{brand}")
    public Iterable<Product> searchByBrand(@PathVariable String brand) {
        return productService.searchByBrand(brand);
    }

    @GetMapping("/search/ascending")
    public Iterable<Product> searchBypriceAscending() {
        return productService.sortByPriceASCE();
    }

    @GetMapping("/search/descending")
    public Iterable<Product> searchBypriceDescending() {
        return productService.sortByPriceDESC();
    }
}