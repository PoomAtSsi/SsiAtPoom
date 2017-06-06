package org.poom.sap.message.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.poom.sap.message.model.service.MessageService;
import org.poom.sap.message.model.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.istack.internal.logging.Logger;

@Controller
@RequestMapping("/message")
public class MessageController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private MessageService messageService;
	
	@ResponseBody
    @RequestMapping(value="msgList.do",method=RequestMethod.POST)
    public HashMap<String, Object> findPassword(@RequestBody HashMap<String,Object> param) throws Exception{
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		ArrayList<Message> rs = messageService.a(param.get("onUser").toString());
        
        resultMap.put("message", rs);
        return resultMap;
    }
	
}
