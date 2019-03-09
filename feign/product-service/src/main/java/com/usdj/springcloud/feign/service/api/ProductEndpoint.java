package com.usdj.springcloud.feign.service.api;



import com.usdj.feign.product.dto.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @program: feign
 * @description: endpoint
 * @author: JerryDeng
 * @create: 2019-03-09 12:19
 **/
@RestController
@RequestMapping("/products")
public class ProductEndpoint {
	

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> list() {
		return this.buildProducts();
	}

	@RequestMapping(value = "/{itemCode}", method = RequestMethod.GET)
	public Product detail(@PathVariable String itemCode) {
		List<Product> products = this.buildProducts();
		for (Product product : products) {
			if (product.getItemCode().equalsIgnoreCase(itemCode)) {
				return product;
			}
		}
		return null;
	}

//	@RequestMapping(value = "/item/{itemCode}/instruction/execute", method = RequestMethod.POST)
//	public Product detailEx(@PathVariable String itemCode,
//	                        @RequestParam(value = "user_id", required = false) String userId,
//	                        @RequestParam(value = "instruction_code") String instructionCode) {
//		System.out.println("userId = " + userId);
//		List<Product> products = this.buildProducts();
//		for (Product product : products) {
//			if (product.getItemCode().equalsIgnoreCase(itemCode)) {
//				return product;
//			}
//		}
//		return null;
//	}

	protected List<Product> buildProducts() {
		List<Product> products = new ArrayList<>();
		products.add(new Product("item-1", "产品-1", "NotFake", 100));
		products.add(new Product("item-2", "产品-2", "NotFake", 200));
		products.add(new Product("item-3", "产品-3", "NotFake", 300));
		products.add(new Product("item-4", "产品-4", "NotFake", 400));
		products.add(new Product("item-5", "产品-5", "NotFake", 500));
		products.add(new Product("item-6", "产品-6", "NotFake", 600));
		return products;
	}
}
