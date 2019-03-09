package com.usdj.springcloud.feign.service;

import com.usdj.feign.product.dto.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

/**
 * @program: feign
 * @description:
 * @author: JerryDeng
 * @create: 2019-03-09 19:09
 **/
@Component
public class ProductServiceFallback implements ProductService {
	@Override
	public List<Product> findAll() {
		return Collections.emptyList();
	}

	@Override
	public Product loadByItemCode(@PathVariable("itemCode") String itemCode) {
		return new Product("error", "unknown", "This is Fallback",0);
	}
}
