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
import org.springframework.stereotype.Component;
@Component
public class WxUserInfoUpdateEventHandler implements WxMpMessageHandler {
	private static Logger logger = LoggerFactory.getLogger(WxUserInfoUpdateEventHandler.class);

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager)
			throws WxErrorException {
		logger.debug("处理用户点击信息更新的消息:");
		String content = "请您按以下格式\n zc 医院科室   \n回复您的医院信息和科室信息，\n例如：zc 武汉同济医院皮肤科";
		WxMpCustomMessage message = WxMpCustomMessage.TEXT().toUser(wxMessage.getFromUserName()).content(content).build();
		wxMpService.customMessageSend(message);
		return null;
	}
}
