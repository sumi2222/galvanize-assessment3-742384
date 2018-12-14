package com.galvanize4.galvanizeassessment3742384.service;
import com.galvanize4.galvanizeassessment3742384.entity.Product;
import com.galvanize4.galvanizeassessment3742384.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class ProductService {
private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    ProductRepository productRepository = new ProductRepository();

    public List<Product> searchByPrice(double price){
        System.out.println("the price is from service ::  " + price);
        List<Product> productList = new ArrayList<>();
        for (Product product : productRepository.productList ){
            if(product.getPrice() == price) {
                productList.add(product);
            }
         }
        LOGGER.info("From product service - searchByPrice  has been called ...............................");
        return productList;
    }
    public List<Product> searchByColor(String color){
        List<Product> productList = new ArrayList<>();

        for (Product product :productRepository.productList ){
            if(product.getColor().equalsIgnoreCase(color)) {
                productList.add(product);
            }
        }
        LOGGER.info("From product service - searchByColor  has been called ...............................");
        return productList;
    }

    public List<Product> searchByBrand(String brand){
        List<Product> productList = new ArrayList<>();

        for (Product product :productRepository.productList ){
            if(product.getBrand().equalsIgnoreCase(brand)) {
                productList.add(product);
            }
        }
        LOGGER.info("From product service - searchByBrand  has been called ...............................");
        return productList;
    }
    public List<Product>  sortByPriceASCE(){
        Collections.sort(productRepository.productList);
        return productRepository.productList;
    }
    public List<Product> sortByPriceDESC(){
        Collections.sort(productRepository.productList);
        List<Product> productList = new ArrayList<>();
        for (int i = productRepository.productList.size()-1; i>=0; i--){
                productList.add(productRepository.productList.get(i));
        }
        LOGGER.info("From product service - sortByPriceASCE  has been called ...............................");
        return productList;
    }
}
