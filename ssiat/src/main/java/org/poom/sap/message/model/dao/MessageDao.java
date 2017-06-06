package org.poom.sap.message.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.poom.sap.message.model.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("messageDao")
public class MessageDao {
	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private SqlSessionTemplate sqlSession;
	public ArrayList<Message> mList(String string) {
		return (ArrayList<Message>)sqlSession.selectList("mList", string);
	}
}
