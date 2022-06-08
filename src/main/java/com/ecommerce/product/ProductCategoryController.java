package com.ecommerce.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCategoryController {

	@Autowired
	ProductCategoryServiceImpl productCategoryService;

	@PostMapping("/addProductCategory")
	public String saveProductCategory(@RequestBody ProductCategory productCategory) {
		productCategoryService.saveProductCategory(productCategory);
		return "Added Successfully";
	}

	@GetMapping("/productCategory-by-id/{categoryId}")
	public ProductCategory getByCategoryId(@PathVariable Integer categoryId) {
		return productCategoryService.getByCategoryId(categoryId);
	}
	@GetMapping("/productCategories")
	public List<ProductCategory>getProductCategories(){
		return productCategoryService.getProductCategories();
	}
	
	@PutMapping("updateProductCategory/{categoryId}")
	public ProductCategory editProductCategory(@PathVariable Integer categoryId,@RequestBody ProductCategory productCategory) {
		return productCategoryService.editProductCategory(productCategory);		
	}

	@DeleteMapping("/delProductCategory/{categoryId}")
	public String deleteProductCategory(@PathVariable Integer categoryId) {
		productCategoryService.deleteProductCategory(categoryId);
		return "Deleted Successfully";
	}
	@DeleteMapping("/allProductCategories")
	public String deleteAllProductCategories() {
		productCategoryService.deleteAll();
		return "Deleted all Product Categories in the database";
	}


}
