package com.galvanize4.galvanizeassessment3742384.service;


import com.galvanize4.galvanizeassessment3742384.entity.Product;
import com.galvanize4.galvanizeassessment3742384.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {


   ProductRepository productRepository;

   @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> searchByPrice(Double price){
        List<Product> productList = new ArrayList<>();

        for (Product product :productRepository.productList ){
            if(product.getPrice()==price) {
                productList.add(product);
            }
        }
        return productList;

    }
    public List<Product> searchByColor(String color){
        List<Product> productList = new ArrayList<>();

        for (Product product :productRepository.productList ){
            if(product.getColor().equalsIgnoreCase(color)) {
                productList.add(product);
            }
        }
        return productList;

    }

    public List<Product> searchByBrand(String brand){
        List<Product> productList = new ArrayList<>();

        for (Product product :productRepository.productList ){
            if(product.getBrand().equalsIgnoreCase(brand)) {
                productList.add(product);
            }
        }
        return productList;

    }
    public List<Product>  sortByPriceASCE(){
        Collections.sort(productRepository.productList);
        return productRepository.productList;
    }

    public List<Product> sortByPriceDESC(){
        List<Product> productList = new ArrayList<>();

        for (int i = productRepository.productList.size()-1; i< 0; i--){

                productList.add(productRepository.productList.get(i));
        }
        return productList;
    }

}
