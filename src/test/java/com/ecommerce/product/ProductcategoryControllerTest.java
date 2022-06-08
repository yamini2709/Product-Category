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
public class ProductcategoryControllerTest {
	
	@Mock
	ProductCategoryServiceImpl service;
	
	@InjectMocks
	ProductCategoryController controller;
	ProductCategory allData = new ProductCategory(1,"Mobiles",new Date());
	
	@Test
	public void saveCategory() {
		when(service.saveProductCategory(allData)).thenReturn(allData);
		assertEquals("Added Successfully", controller.saveProductCategory(allData));
	}
	
	@Test
	public void getProductCategories() {
		List<ProductCategory> allData = new ArrayList<ProductCategory>();
		allData.add(new ProductCategory(1, "Boat", new Date()));
		allData.add(new ProductCategory(2, "Noise", new Date()));
		when(service.getProductCategories()).thenReturn(allData);
		assertEquals(allData, controller.getProductCategories());
	}
	
	@Test
	public void getByCategoryId() {
		Integer categoryId = 1;
		controller.getByCategoryId(categoryId);
		when(service.getByCategoryId(categoryId)).thenReturn(allData);
		assertEquals(1, controller.getByCategoryId(categoryId).getCategoryId());
	}

	@Test
	public void editProductCategory() {
		ProductCategory category = new ProductCategory(3, "FireBolt", new Date());
		Integer categoryId=3;
		when(service.editProductCategory(category)).thenReturn(category);
		assertEquals(category, controller.editProductCategory(categoryId, category));
	}
		
	@Test
	public void deleteProductCategory() {
		Integer categoryId = 2;
		controller.deleteProductCategory(categoryId);
		verify(service, times(1)).deleteProductCategory(categoryId);
	}
	
	@Test
	public void deleteAll() {
		service.deleteAll();
		assertEquals("Deleted all Product Categories in the database", controller.deleteAllProductCategories());
}
}