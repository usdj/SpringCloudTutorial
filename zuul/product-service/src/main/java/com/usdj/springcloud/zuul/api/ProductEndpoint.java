package com.usdj.springcloud.zuul.api;

import com.usdj.springcloud.zuul.product.dto.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: zuul
 * @description: ProductEndpoint
 * @author: JerryDeng
 * @create: 2019-03-10 11:52
 **/
@RestController
@RequestMapping("/productList")
public class ProductEndpoint {

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> list() {
		return this.buildProducts();
	}

	@RequestMapping(value = "/{itemCode}", method = RequestMethod.GET)
	public Product detail(@PathVariable("itemCode") String itemCode) {
		List<Product> productList = this.buildProducts();
		for (Product product :
				productList) {
			if (product.getItemCode().equalsIgnoreCase(itemCode)) {
				return product;
			}
		}
		return null;
	}

	protected List<Product> buildProducts() {
		List<Product> productList = new ArrayList<>();
		productList.add(new Product("item-1", "产品-1", "NotFake", 100));
		productList.add(new Product("item-2", "产品-2", "NotFake", 200));
		productList.add(new Product("item-3", "产品-3", "NotFake", 300));
		productList.add(new Product("item-4", "产品-4", "NotFake", 400));
		productList.add(new Product("item-5", "产品-5", "NotFake", 500));
		productList.add(new Product("item-6", "产品-6", "NotFake", 600));
		return productList;
	}
}
