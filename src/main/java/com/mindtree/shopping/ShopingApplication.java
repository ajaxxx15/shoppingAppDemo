package com.mindtree.shopping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mindtree.shopping.model.Category;
import com.mindtree.shopping.model.Product;
import com.mindtree.shopping.model.User;
import com.mindtree.shopping.repository.CategoryRepository;
import com.mindtree.shopping.repository.ProductRepository;
import com.mindtree.shopping.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories({ "com.mindtree.shopping.repository" })
public class ShopingApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CategoryRepository categoryrepo;

	@Autowired
	private ProductRepository productRepo;

	public static void main(String[] args) {
		SpringApplication.run(ShopingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Inserting the data in the h2 table.
		List<User> userList = new ArrayList<User>();
		User user1 = new User("ajay", "test", "ajay@mail.com");
		User user2 = new User("somee", "test", "somee@mail.com");
		userList.add(user1);
		userList.add(user2);
		userRepo.saveAll(userList);

		List<Category> categoryList = new ArrayList<Category>();

		Category category1 = new Category("Book", "Books");
		Category category2 = new Category("Cloth", "Clothing");
		Category category3 = new Category("Groceries", "Groceries");
		categoryList.add(category1);
		categoryList.add(category2);
		categoryList.add(category3);

		categoryrepo.saveAll(categoryList);

		List<Product> productList = new ArrayList<Product>();
		Product product1 = new Product("Java", 200, category1);
		Product product2 = new Product("C++", 150, category1);
		Product product3 = new Product("C", 100, category1);

		Product product4 = new Product("Shirt", 600, category2);
		Product product5 = new Product("Pant", 1000, category2);
		Product product6 = new Product("T-Shirt", 400, category2);

		Product product7 = new Product("Rice", 100, category3);
		Product product8 = new Product("Dal", 120, category3);
		Product product9 = new Product("Oil", 180, category3);

		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
		productList.add(product5);
		productList.add(product6);
		productList.add(product7);
		productList.add(product8);
		productList.add(product9);

		productRepo.saveAll(productList);

		// ob.save() method
//		userRepo.save(first);
	}

}
