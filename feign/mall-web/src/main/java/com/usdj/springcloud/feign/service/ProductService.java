package com.usdj.springcloud.feign.service;

import com.usdj.feign.product.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: feign
 * @description:
 * @author: JerryDeng
 * @create: 2019-03-09 12:37
 **/
@FeignClient("PRODUCT-SERVICE")
@Component
public interface ProductService {
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	List<Product> findAll();

	@RequestMapping(value = "/products/{itemCode}", method = RequestMethod.GET)
	Product loadByItemCode(@PathVariable("itemCode") String itemCode);

//	@RequestMapping(value = "/products/{itemCode}/instruction/execute", method = RequestMethod.POST)
//	Product loadByItemCodeEx(@PathVariable("itemCode") String itemCode,
//	                         @RequestParam("user_id") String userId,
//	                         @RequestParam("instruction_code") String instructionCode);
}

