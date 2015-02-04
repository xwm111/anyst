package cn.wh.anyst.rest;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.anyst.entity.Product;
import cn.wh.anyst.service.ProductService;

/*
 * 产品restful接口
 */
@RestController
@RequestMapping(value="/api/v1/product")
public class ProductRest {
	
	@Autowired
	private ProductService productService;
	
	//列出所有产品并分页
	@RequestMapping(method = RequestMethod.GET)
	public RestQueryResultModal<Product> list(
			@RequestParam(value = "productName", defaultValue = "") String productName,							//产品名称
			@RequestParam(value = "productCode", defaultValue = "") String productCode,							//产品编码
			@RequestParam(value = "productStatus", defaultValue = "-1") int productStatus,						//状态
			@RequestParam(value = "page", defaultValue = "1") int pageNumber, 									//分页第几页
			@RequestParam(value = "rows", defaultValue = RestCommonModal.PAGE_SIZE) int pageSize, 				//每页数量
            @RequestParam(value = "sortType", defaultValue = "auto") String sortType,							//排序规则
            ServletRequest request) throws UnsupportedEncodingException {
		Page<Product> productPage = productService.queryProduct(
				(productName.equals("") ? null : new String(productName.getBytes("ISO-8859-1"))),
				(productCode.equals("") ? null : productCode),
				productStatus,
				pageNumber, pageSize);
		RestQueryResultModal<Product> result = new RestQueryResultModal<Product>(productPage.getTotalElements(), productPage.getContent());
		return result;
	}
	
	//通过产品编码查找产品
	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public Product list(@PathVariable("code") String code) {
		return productService.findByCode(code);
	}
	
	//列出所有产品
	@RequestMapping(value = "/listAllProduct", method = RequestMethod.GET)
	public List<Product> listAllProduct() {
		return productService.listAllProduct();
	}
	
	//创建新产品
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void create(@RequestParam("productCode") String code,					//产品代码
            @RequestParam("productDescription") String description,					//产品描述
            @RequestParam("productName") String name,								//产品名称
            @RequestParam(value = "productTap", defaultValue = "") String tapCode,	//贴花Code
            ServletRequest request) {
		Product product = new Product();
		product.setCode(code);
		product.setDescription(description);
		product.setName(name);
		productService.newProduct(product);
	}
	
	//更新产品信息
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@RequestParam("productCode") String code,					//产品代码
            @RequestParam("productDescription") String description,					//产品描述
            @RequestParam("productName") String name,								//产品名称
            @RequestParam(value = "productTap", defaultValue = "") String tapCode,	//贴花Code
            ServletRequest request) {
		Product product = productService.findByCode(code);
		if (product != null) {
			product.setName(name);
			product.setDescription(description);
			productService.updateProduct(product);
		}
	}
	
	//删除产品
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public int update(@RequestParam("productCode") String code,					//产品代码
            ServletRequest request) {
		return productService.deleteProductByCode(code);
	}
}
