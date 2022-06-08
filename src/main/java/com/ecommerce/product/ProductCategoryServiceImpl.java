package com.ecommerce.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl {

	@Autowired
	ProductCategoryRepository productCategoryRepository;

	public ProductCategory saveProductCategory(ProductCategory productCategory) {
		return productCategoryRepository.save(productCategory);
	}

	public List<ProductCategory> getProductCategories() {
		return productCategoryRepository.findAll();
	}

	public ProductCategory editProductCategory(ProductCategory productCategory) {
		return productCategoryRepository.save(productCategory);
	}

	public void deleteProductCategory(Integer categoryId) {
		productCategoryRepository.deleteById(categoryId);
	}

	public ProductCategory getByCategoryId(Integer categoryId) {
		List<ProductCategory>categories = productCategoryRepository.findAll();
		ProductCategory productCategory = null;
		for(ProductCategory product:categories) {
			if(product.getCategoryId()==categoryId)
				productCategory=product;
		}
		return productCategory;
		}

	public void deleteAll() {
		productCategoryRepository.deleteAll();
	}	
}
