package img.service;

import java.util.ArrayList;

import img.dao.Dao;
import img.dao.DaoImpl;
import model.Img;

public class ServiceImpl implements Service{

	private Dao dao;
	
	public ServiceImpl() {
		dao = new DaoImpl();
	}
	@Override
	public void addImg(Img img) {
		dao.insert(img);
	}

	@Override
	public ArrayList<Img> getAll() {
		return dao.selectAll();
	}

}
