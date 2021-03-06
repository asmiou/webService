package com.server.service.interfaces;

import java.util.List;

import com.server.entities.impl.Rate;

public interface IRateService {

	public long getMaxId();

	public Rate add(Rate entity);
	
	public Rate update(Rate entity);
	
	public void delete(Rate rate);
	
	public Rate findOneById(Long id);
	
	public List<Rate> findBy(String field, Object value);
    
    public List<Rate> findBy(String[] fields, Object[] values);
     
    public List<Rate> findAll();
    
    public List<Rate> findAllSortedBy(String field, String order);

	
	public void deleteAll();
	
}
