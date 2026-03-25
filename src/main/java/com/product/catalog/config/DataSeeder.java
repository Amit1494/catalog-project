package com.product.catalog.config;


import com.product.catalog.model.Category;
import com.product.catalog.model.Product;
import com.product.catalog.repository.CategoryRepository;
import com.product.catalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner

{
    private final ProductRepository productRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    private final CategoryRepository categoryRepository;
    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        categoryRepository.deleteAll();
        Category electronics=new Category();
        electronics.setName("Electronics");

        Category clothing=new Category();
        clothing.setName("Clothing");

        Category home=new Category();
        home.setName("Home and Kitchen");


        categoryRepository.saveAll(Arrays.asList(electronics,home,clothing));
        Product phone =new Product();
        phone.setName("Redmi");
        phone.setDescription("Latest Model smartphone");

        phone.setImage("https://placehold.in/300x200@2x.png/dark");
        phone.setPrice(69000.0);
        phone.setCategory(electronics);


        Product phone2 =new Product();
        phone2.setName("OnePlus");
        phone2.setDescription("Latest Model smartphone with Android 16");
        phone2.setImage("https://placehold.in/300x200@2x.png/dark");
        phone2.setPrice(59000.0);
        phone2.setCategory(electronics);



        Product jacket =new Product();
        jacket.setName("Amiri");
        jacket.setDescription("Winter Jacket");
        jacket.setImage("https://placehold.in/300x200@2x.png/dark");
        jacket.setPrice(47999.0);
        jacket.setCategory(clothing);

        Product grinder =new Product();
        grinder.setName("Philips");
        grinder.setDescription("High speed grinder Jacket");
        grinder.setImage("https://placehold.in/300x200@2x.png/dark");
        grinder.setPrice(4999.0);
        grinder.setCategory(home);

    productRepository.saveAll(Arrays.asList(phone,phone2,jacket,grinder));


    }
}

