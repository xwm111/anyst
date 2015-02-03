package cn.wh.anyst.rest;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.anyst.entity.Gift;
import cn.wh.anyst.service.GiftService;

/*
 * 礼物restful接口
 */
@RestController
@RequestMapping(value="/api/v1/gift")
public class GiftRest {
	
	@Autowired
	private GiftService giftService;

	@RequestMapping(method = RequestMethod.GET)
	public RestQueryResultModal<Gift> list(
			@RequestParam(value = "giftCode") String code,												//礼物编码
			@RequestParam(value = "giftName") String name,												//礼物名称
			@RequestParam(value = "giftGroup", defaultValue = "-1") Long groupId,						//分组ID
			@RequestParam(value = "page", defaultValue = "1") int pageNumber, 							//分页第几页
			@RequestParam(value = "rows", defaultValue = RestCommonModal.PAGE_SIZE) int pageSize, 		//每页数量
            @RequestParam(value = "sortType", defaultValue = "auto") String sortType,					//排序规则
            ServletRequest request
			) throws UnsupportedEncodingException {
		Page<Gift> giftPqge = giftService.listGift(
				(name.equals("") ? null : new String(name.getBytes("ISO-8859-1"))),
				code,
				groupId,
				pageNumber, pageSize);
		RestQueryResultModal<Gift> result = new RestQueryResultModal<Gift>(giftPqge.getTotalElements(), giftPqge.getContent());
		return result;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public int create(
			@RequestParam("giftCode") String code,								//礼物编码
			@RequestParam("giftName") String name,								//礼物名称
			@RequestParam("giftDescription") String description,				//礼物说明
			@RequestParam("productCode") String productCode,					//礼物对应的产品编码
			@RequestParam("giftGroup") Long groupId,							//礼物对应分组ID 
			@RequestParam("giftPrice") int price,								//礼物的市场价格
			@RequestParam("giftCost") int cost,									//礼物的成本价格
			ServletRequest request
			) {
		Gift gift = new Gift();
		gift.setCode(code);
		gift.setGiftName(name);
		gift.setGiftDiscribe(description);
		gift.setProduct(productCode);
		gift.setGiftGroup(groupId);
		gift.setGiftPrice(price);
		gift.setGiftCost(cost);
		giftService.createGift(gift);
		return 1;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public int update(
			@RequestParam("giftCode") String code,								//礼物编码
			@RequestParam("giftName") String name,								//礼物名称
			@RequestParam("giftDescription") String description,				//礼物说明
			@RequestParam("productCode") String productCode,					//礼物对应的产品编码
			@RequestParam("giftGroup") Long groupId,							//礼物对应分组ID 
			@RequestParam("giftPrice") int price,								//礼物的市场价格
			@RequestParam("giftCost") int cost,									//礼物的成本价格
			ServletRequest request
			) {
		Gift gift = giftService.queryGiftByCode(code);
		if (gift != null) {
			gift.setCode(code);
			gift.setGiftName(name);
			gift.setGiftDiscribe(description);
			gift.setProduct(productCode);
			gift.setGiftGroup(groupId);
			gift.setGiftPrice(price);
			gift.setGiftCost(cost);
			giftService.createGift(gift);
			return 1;
		}
		return 0;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public int delete(
			@RequestParam("giftCode") String code,								//礼物编码
			ServletRequest request
			) {
		giftService.deleteGiftByCode(code);
		return 1;
	}
	
}
