package org.poom.sap.message.model.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.poom.sap.message.model.dao.TemplateDao;
import org.poom.sap.message.model.vo.template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("templateService")
public class TemplateServiceImpl implements TemplateService {
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	TemplateDao templateDao;

	@Override
	public ArrayList<template> a(template t) {
		return (ArrayList<template>)templateDao.selectA(t);
	}
}