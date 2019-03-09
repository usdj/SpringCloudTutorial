package com.usdj.springcloud.feign.controller;

import com.usdj.feign.product.dto.Product;
import com.usdj.springcloud.feign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: feign
 * @description:
 * @author: JerryDeng
 * @create: 2019-03-09 12:45
 **/
@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> list() {
		return this.productService.findAll();
	}

	@RequestMapping(value = "/{itemCode}", method = RequestMethod.GET)
	public Product detail(@PathVariable String itemCode) {
		return this.productService.loadByItemCode(itemCode);
	}

//	@RequestMapping(value = "/t/{itemCode}", method = RequestMethod.POST)
//	public Product detailEx(@PathVariable String itemCode) {
//		return this.productService.loadByItemCode(itemCode);
//	}
}
