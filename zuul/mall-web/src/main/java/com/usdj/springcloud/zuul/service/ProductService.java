package com.usdj.springcloud.zuul.service;

import com.usdj.springcloud.zuul.product.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @program: zuul
 * @description: ProductService
 * @author: JerryDeng
 * @create: 2019-03-10 14:36
 **/
@FeignClient("PRODUCT-SERVICE")
public interface ProductService {

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	List<Product> findAll();

	@RequestMapping(value = "/products/{itemCode}", method = RequestMethod.GET)
	Product loadByItemCode(@PathVariable("itemCode") String itemCode);
}
