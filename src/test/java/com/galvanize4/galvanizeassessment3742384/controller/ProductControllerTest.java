package com.galvanize4.galvanizeassessment3742384.controller;

import com.galvanize4.galvanizeassessment3742384.entity.Product;
import com.galvanize4.galvanizeassessment3742384.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class, secure = false)
public class ProductControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void getSearchByColor_Test() throws Exception {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "dress1", "guccii", "brown", 200.00));
        productList.add(new Product(2, "dress2", "best buy", "brown", 200.00));
        productList.add(new Product(3, "dress3", "marni", "brown", 300.00));
        productList.add(new Product(4, "dress4", "guccii", "brown", 500.00));
        when(productService.searchByColor("brown")).thenReturn(productList);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/product/search/color/{color}", "brown")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andReturn();
        verify(productService, times(1)).searchByColor("brown");
    }
    @Test
    public void getSearchByBrand_Test() throws Exception {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "dress1", "guccii", "red", 200.00));
        productList.add(new Product(2, "dress2", "guccii", "yellow", 200.00));
        productList.add(new Product(3, "dress3", "guccii", "brown", 300.00));
        productList.add(new Product(4, "dress4", "guccii", "yellow", 500.00));
        when(productService.searchByBrand("guccii")).thenReturn(productList);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/product/search/brand/{brand}", "guccii")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andReturn();
        verify(productService, times(1)).searchByBrand("guccii");
    }

    @Test
    public void getSearchByPrice_Test() throws Exception {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "dress1", "guccii", "red", 200.00));
        productList.add(new Product(2, "dress2", "guccii", "yellow", 200.00));
        when(productService.searchByPrice(200.00)).thenReturn(productList);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/product/search/price/{price}", "200.00")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andReturn();
        verify(productService, times(1)).searchByPrice(200.00);
    }

    @Test
    public void getPriceInASCEOrder_Test() throws Exception {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "dress1", "guccii", "red", 200.00));
        productList.add(new Product(2, "dress2", "best buy", "yellow", 200.00));
        productList.add(new Product(3, "dress3", "macy's", "brown", 300.00));
        productList.add(new Product(4, "dress4", "wall mart", "yellow", 500.00));
        when(productService.sortByPriceASCE()).thenReturn(productList);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/product/search/ascending")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andReturn();
        verify(productService, times(1)).sortByPriceASCE();
    }

    @Test
    public void getPriceInDESCOrder_Test() throws Exception {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "dress1", "guccii", "red", 600.00));
        productList.add(new Product(2, "dress2", "best buy", "yellow", 400.00));
        productList.add(new Product(3, "dress3", "macy's", "brown", 300.00));
        productList.add(new Product(4, "dress4", "wall mart", "yellow", 100.00));
        when(productService.sortByPriceDESC()).thenReturn(productList);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/product/search/descending")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andReturn();
        verify(productService, times(1)).sortByPriceDESC();
    }
}