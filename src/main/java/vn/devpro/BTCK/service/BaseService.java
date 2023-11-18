package vn.devpro.BTCK.service;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vn.devpro.BTCK.model.BaseModel;



@Service
public abstract class BaseService<E extends BaseModel> {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public abstract Class<E> clazz();
	// trả về 1 bản ghi cho 1  table
	public E getById(int id) {
		return entityManager.find(clazz(), id);
	}
	// trả về bản ghi cho tất cả các table
	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		Table table = clazz().getAnnotation(Table.class);
		return (List<E>) entityManager.createNativeQuery("SELECT * FROM " + table.name(), clazz()).getResultList();
	}

	@Transactional
	public E saveOrUpdate(E entity) {
		if (entity.getId() == null || entity.getId() <= 0) { //Add
			entityManager.persist(entity);
			return entity;
		}
		else { //update
			return entityManager.merge(entity);
		}
	}
	
	public void delete(E entity) {
		entityManager.remove(entity);
		
	}
	
	public void deleteById(int id) {
		E entity = this.getById(id);
		delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<E> executeNativeSql(String sql) {
		try {
			Query query = entityManager.createNativeQuery(sql, clazz());
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<E>();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<E> executeNativeSql(String sql, int page, int sizeOfPage) {
		try {
			Query query = entityManager.createNativeQuery(sql, clazz());
			query.setFirstResult((page-1) * sizeOfPage); // vị trí bản ghi đầu trang
			
			query.setMaxResults(sizeOfPage);// số bản ghi trên 1 trang
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<E>();
		}
	}
	
	public E getEntityByNativeSql(String sql) {
		try {
			return this.executeNativeSql(sql).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
