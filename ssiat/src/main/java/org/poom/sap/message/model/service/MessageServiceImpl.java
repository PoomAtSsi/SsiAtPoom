package org.poom.sap.message.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.poom.sap.message.model.dao.MessageDao;
import org.poom.sap.message.model.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDao messageDao;

	@Override
	public ArrayList<Message> a(String string) {
		// TODO Auto-generated method stub
		return (ArrayList<Message>)messageDao.mList(string);
	}
}
