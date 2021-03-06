package com.server.dao.interfaces;

import com.server.entities.impl.Comment;

import java.io.Serializable;
import java.util.List;
 
public interface ICommentDao<T, Id extends Serializable> {

    public long getMaxId();

    public void add(T entity);

    public Comment parseComment(String[][] data, int i);
     
    public void update(T entity);
     
    public T findOneById(Id id);
     
    public List<T> findBy(String field, Object value);
    
    public List<T> findBy(String[] fields, Object[] values);
     
    public List<T> findAll();
    
    public List<T> findAllSortedBy(String field, String order);
     
    public void delete(T entity);
    
    public void deleteAll();
     
}
