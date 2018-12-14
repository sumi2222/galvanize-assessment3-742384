package com.galvanize4.galvanizeassessment3742384.controller;

import com.galvanize4.galvanizeassessment3742384.entity.Product;
import com.galvanize4.galvanizeassessment3742384.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search/price/{price}")
    public Iterable<Product> searchByPrice(@PathVariable String price) {
        return productService.searchByPrice(Double.parseDouble(price));
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
    public Iterable<Product> searchByPriceAscending() {
        return productService.sortByPriceASCE();
    }

    @GetMapping("/search/descending")
    public Iterable<Product> searchByPriceDescending() {
        return productService.sortByPriceDESC();
    }
}