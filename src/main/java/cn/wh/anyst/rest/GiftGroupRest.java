package cn.wh.anyst.rest;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.anyst.entity.GiftGroup;
import cn.wh.anyst.service.BasicService;

/*
 * 礼品分类restful接口
 */
@RestController
@RequestMapping("/api/v1/class")
public class GiftGroupRest {

	@Autowired
	private BasicService basicService;

	// 列出所有客户分组并分页
	@RequestMapping(method = RequestMethod.GET)
	public RestQueryResultModal<GiftGroup> list(
			@RequestParam(value = "giftGroupName", defaultValue = "") String giftGroupName, 		// 查询的礼品分类名字
			@RequestParam(value = "page", defaultValue = "1") int pageNumber, 						// 分页第几页
			@RequestParam(value = "rows", defaultValue = RestCommonModal.PAGE_SIZE) int pageSize, 	// 每页数量
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, 				// 排序规则
			ServletRequest request) throws UnsupportedEncodingException {
		Page<GiftGroup> groups = basicService.queryGiftGroup(
				giftGroupName.equals("") ? null : new String(giftGroupName.getBytes("ISO-8859-1")), 
				pageNumber,pageSize);
		RestQueryResultModal<GiftGroup> result = new RestQueryResultModal<GiftGroup>(
				groups.getTotalElements(), groups.getContent());
		return result;
	}

	// 通过ID查询组信息
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public GiftGroup list(@PathVariable("id") Long id)
			throws UnsupportedEncodingException {
		return basicService.queryGiftGroupById(id);
	}

	// 创建客户分组
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public int create(
			@RequestParam(value = "giftGroupName") String name, 										// 分组名称
			@RequestParam(value = "giftGroupIsDisplay", defaultValue = "1") int isDisplay,				// 是否显示
			@RequestParam(value = "giftGroupOrder") int order,											// 显示序号
			@RequestParam(value = "giftGroupDescription") String description, 							// 分组描述
			ServletRequest request) {
		GiftGroup giftGroup = new GiftGroup();
		giftGroup.setName(name);
		giftGroup.setIsDisplay(isDisplay);
		giftGroup.setDisplayOrder(order);
		giftGroup.setDescription(description);
		basicService.createGiftGroup(giftGroup);
		return 1;
	}

	// 更新客户分组
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public int update(
			@RequestParam(value = "giftGroupId") Long id,												// 分租ID
			@RequestParam(value = "giftGroupName") String name, 										// 分组名称
			@RequestParam(value = "giftGroupIsDisplay") int isDisplay,									// 是否显示
			@RequestParam(value = "giftGroupOrder") int order,											// 显示序号
			@RequestParam(value = "giftGroupDescription") String description, 							// 分组描述
			ServletRequest request) {
		GiftGroup giftGroup = basicService.queryGiftGroupById(id);
		if (giftGroup != null) {
			giftGroup.setName(name);
			giftGroup.setIsDisplay(isDisplay);
			giftGroup.setDisplayOrder(order);
			giftGroup.setDescription(description);
			basicService.updateGiftGroup(giftGroup);
			return 1;
		}
		return 0;
	}

	// 删除客户分组
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public int delete(@RequestParam(value = "giftGroupId") Long id, // 分组ID
			ServletRequest request) {
		basicService.deleteGiftGroupById(id);
		return 1;
	}
}
