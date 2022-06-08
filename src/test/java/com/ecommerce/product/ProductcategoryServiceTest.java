package com.ecommerce.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductcategoryServiceTest {

	@Mock
	ProductCategoryRepository repository;;
	
	@InjectMocks
	ProductCategoryServiceImpl service;
	
	@Test
	public void saveProductCategoryTest() {
		ProductCategory productCategory = new ProductCategory(1, "DELL", new Date());
		when(repository.save(productCategory)).thenReturn(productCategory);
		assertEquals(productCategory, service.saveProductCategory(productCategory));
	}
	
	@Test
	public void getProductCategoriesTest() {
		List<ProductCategory> categories = new ArrayList<ProductCategory>();
		categories.add(new ProductCategory(1,"DELL",new Date()));
		categories.add(new ProductCategory(2,"HP",new Date()));
		when(repository.findAll()).thenReturn(categories);
		assertEquals(2, service.getProductCategories().size());
	}
	
	@Test
	public void editProductCategoryServiceTest() {
		ProductCategory productCategory = new ProductCategory(1, "DELL", new Date());
		when(repository.save(productCategory)).thenReturn(productCategory);
		assertEquals(productCategory, service.editProductCategory(productCategory));
	}
	
	@Test
	public void getByCategoryIdTest() {
		List<ProductCategory>allCategories=new ArrayList<ProductCategory>();
		 allCategories.add(new ProductCategory(111, "Watches", new Date()));
		 allCategories.add(new ProductCategory(22, "Laptop", new Date()));
		 int categoryId = 111;
		 service.getByCategoryId(categoryId);
		 when(repository.findAll()).thenReturn(allCategories);
		 assertEquals(categoryId, service.getByCategoryId(categoryId).getCategoryId());
	}
	
	@Test
	public void deleteProductCategoryTest() {
		ProductCategory productCategory = new ProductCategory(111, "Watches", new Date());
		int categoryId = 111;
		service.deleteProductCategory(categoryId);
		verify(repository,times(1)).deleteById(111);
	}
	
	@Test
	public void deleteAllproductcategories() {
		service.deleteAll();
		verify(repository, times(1)).deleteAll();
		
	}
}
