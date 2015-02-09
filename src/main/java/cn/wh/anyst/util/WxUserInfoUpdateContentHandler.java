package cn.wh.anyst.util;

import java.util.Map;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpCustomMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.wh.anyst.service.CustomerService;

@Component("contenthandler")
public class WxUserInfoUpdateContentHandler implements WxMpMessageHandler {
	private static Logger logger = LoggerFactory.getLogger(WxUserInfoUpdateContentHandler.class);

	@Autowired
	private CustomerService customerService;

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager)
			throws WxErrorException {
		String openId = wxMessage.getFromUserName();
		String content = wxMessage.getContent();
		customerService.CreateOrUpdateCustomer(openId,content);
		logger.debug("更新或者创建用户:");
		WxMpCustomMessage message = WxMpCustomMessage.TEXT().toUser(wxMessage.getFromUserName()).content("您的信息已经更新").build();
		wxMpService.customMessageSend(message);
		return null;
	}
}
