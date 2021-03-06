package com.server.service.impl;
import java.util.List;

import org.hibernate.HibernateException;

import com.server.dao.impl.DemandeDaoImpl;
import com.server.entities.impl.Demande;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;
import com.server.service.interfaces.IDemandeService;


public class DemandeService implements IDemandeService{
 
    private static DemandeDaoImpl demandeDao;
 
    public DemandeService() {
        demandeDao = new DemandeDaoImpl();
    }
    
    public DemandeDaoImpl demandeDao() {
        return demandeDao;
    }
    
    @Override
    public Demande add(Demande entity) {
    	try {
    		if(entity!=null) {
    			//demandeDao.openCurrentSessionwithTransaction();
                demandeDao.add(entity);
                //demandeDao.closeCurrentSessionwithTransaction();
                return entity;
    		}
		} catch (Exception e) {
			e.printStackTrace();	
		}
    	return null;
    }
    
    @Override
    public Demande update(Demande entity) {
    	try {
    		if(entity!=null) {
    			if(entity.getIdDemande()!=0L) {
    				//demandeDao.openCurrentSessionwithTransaction();
    	            demandeDao.update(entity);
    	            //demandeDao.closeCurrentSessionwithTransaction();
    	            return entity;
    			}
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
	@Override
	public void delete(Demande demande) {
		try {
			//if(id!=0L) {
				//demandeDao.openCurrentSessionwithTransaction();
		        //Demande demande = demandeDao.findOneById(id);
		        demandeDao.delete(demande);
		        //demandeDao.closeCurrentSessionwithTransaction();
			//}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Demande findOneById(Long id) {
		try {
			//if(id!=0L) {
				//demandeDao.openCurrentSession();
		        Demande demande = demandeDao.findOneById(id);
		        //demandeDao.closeCurrentSession();
		        return demande;
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public List<Demande> findAll() {
    	try {
    		//demandeDao.openCurrentSession();
            List<Demande> demandes = demandeDao.findAll();
            //demandeDao.closeCurrentSession();
            return demandes;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }

    @Override
	public List<Demande> findByProduct(Long idProduct, boolean isDone){
    	try{
			return demandeDao.findByProduct(idProduct, isDone);
		}catch (Exception e){
    		e.printStackTrace();
		}
    	return null;
	}
    
    @Override
    public void deleteAll() {
    	try {
    		//demandeDao.openCurrentSessionwithTransaction();
            demandeDao.deleteAll();
            //demandeDao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	@Override
	public List<Demande> findBy(String field, Object value) {
		// TODO Auto-generated method stub
		List<Demande> demandes = demandeDao.findBy(field, value);
		return demandes;
	}

	@Override
	public List<Demande> findBy(String[] fields, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Demande> findAllSortedBy(String field, String order) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<UserImpl> findWaitingUserByProduct(Product product){
		return demandeDao.findWaitingUserByProduct(product);
	}
}

