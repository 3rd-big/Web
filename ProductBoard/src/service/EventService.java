package service;

import java.util.ArrayList;

import model.ProductDao;
import model.ProductVO;

public class EventService {
    private ProductDao dao;

    public EventService(){
        dao = ProductDao.getDao();
    }

    public void insert(ProductVO m){
        dao.insert(m);
    }
    
    public ArrayList<ProductVO> list(){
    	return dao.getAll();
    }
    
    public ProductVO getMember(int num) {
    	return dao.getMember(num);
    }
    
    public void edit(ProductVO m) {
    	dao.edit(m);
    }
    
    public void delete(int num) {
    	dao.delete(num);
    }
}
