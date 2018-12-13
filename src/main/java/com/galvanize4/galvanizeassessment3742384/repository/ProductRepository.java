package com.galvanize4.galvanizeassessment3742384.repository;

import com.galvanize4.galvanizeassessment3742384.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductRepository {

   public  List<Product> productList = new ArrayList<>();

    private void buildProductRepo() {

        productList.add(new Product(1,"dress1","guccii","yelloew",200.00));
        productList.add(new Product(2,"dress2","best buy","yelloew",200.00));
        productList.add(new Product(3,"dress3","marni","brown",300.00));
        productList.add(new Product(4,"dress4","guccii","brown",500.00));
        productList.add(new Product(5,"dress5","marni","yelloew",200.00));
        productList.add(new Product(6,"dress6","macy's","white",600.00));
        productList.add(new Product(7,"dress7","marni","brown",300.00));
        productList.add(new Product(8,"dress8","guccii","brown",500.00));
        productList.add(new Product(9,"dress9","marni","black",200.00));
        productList.add(new Product(10,"dress10","macy's","white",600.00));
    }


}


