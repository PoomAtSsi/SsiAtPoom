package org.poom.sap.message.model.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.poom.sap.message.model.vo.template;

@Repository("templateDao")
public class TemplateDao {
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public ArrayList<template> selectA(template t) {
		return (ArrayList<template>)sqlSession.selectList("selectA", t);
	}
}