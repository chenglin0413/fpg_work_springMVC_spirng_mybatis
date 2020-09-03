package com.adrbook.spring.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;

//@Qualifier("adrbookDaoIMP")
public interface AdrbookDaoIMP   {
	public void insert(AdrbookVO adrbookVO);
	public void update(AdrbookVO adrbookVO);
	public void delete(String xuid);
	public List<AdrbookVO> getAll();
}
