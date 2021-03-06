package com.server.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.server.utils.Database;
import com.server.utils.DateTool;
import com.server.utils.PostgresDataSource;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.server.dao.interfaces.IUserDao;
import com.server.entities.impl.UserImpl;
import com.server.utils.EncodeSha;
 
 
public class UserDaoImpl implements IUserDao<UserImpl, Long> {
 
    private Session currentSession;
    private Transaction currentTransaction;

    private Database database;
 
    public UserDaoImpl() {
        PostgresDataSource postgresDataSource = new PostgresDataSource();

        database = new Database(postgresDataSource);
    }
    
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        //currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
     
    @SuppressWarnings("static-access")
	private static SessionFactory getSessionFactory() {
    	/*HibernateFiveUtils utils=new HibernateFiveUtils();
    	return utils.getSessionFactory();*/
    	Configuration config = new Configuration();
    	SessionFactory session=config.configure("hibernate.cfg.xml").buildSessionFactory();
    	//session.openSession();
    	return session;
    }
 
    public Session getCurrentSession() {
        return currentSession;
    }
    
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public UserImpl parseUser(String[][] data, int i) {
        UserImpl user = new UserImpl();

        user.setIdUser(Long.parseLong(data[i][0]));
        user.setBirthday(DateTool.stringToDate(data[i][1]));
        user.setDomain(data[i][2]);
        user.setEmail(data[i][3]);
        user.setFirstName(data[i][4]);
        user.setGraduate(data[i][5]);
        user.setLastName(data[i][6]);
        user.setMatricule(Integer.valueOf(data[i][7]));
        user.setPassword(data[i][8]);
        user.setPhone(data[i][9]);
        user.setRegisteredAt(DateTool.stringToDate(data[i][10]));
        user.setRole(data[i][11]);
        user.setStatus(data[i][12]);

        return user;
    }

    @Override
    public void add(UserImpl entity) {
        entity.setIdUser(this.getMaxId()+1);
        database.insert("userimpl", entity);
    }
    
    @Override
    public void update(UserImpl entity) {
        database.update("userimpl", entity);
    }

    @Override
    public long getMaxId() {
        long id;
        String[][] data = database.executeQuery("select max(idUser) as max from userimpl");
        if(data[1][0]!=null)
            id = Long.parseLong(data[1][0]);
        else
            id = 0L;
        return id;
    }

    @Override
    public UserImpl findOneById(Long id) {
    	UserImpl user = findBy("idUser", id).get(0);
        return user;
    }
    
    @Override
    public void delete(UserImpl entity) {
        database.delete("userimpl", "idUser",entity.getIdUser());
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<UserImpl> findAll() {
        String[][] users = database.select("userimpl");
        List<UserImpl> usersList = new ArrayList<>();

        for(int i=1; i<users.length; i++){
            usersList.add(parseUser(users,i));
        }

        return usersList;
    }
    
    @Override
    public void deleteAll() {
        List<UserImpl> entityList = findAll();
        for (UserImpl entity : entityList) {
            delete(entity);
        }
    }

	@Override
	public List<UserImpl> findBy(String field, Object value) {
        String[][] users = database.select("userimpl", field, value);
        List<UserImpl> usersList = new ArrayList<>();

        for(int i=1; i<users.length; i++){
            usersList.add(parseUser(users,i));
        }
		return usersList;
	}

	@Override
	public List<UserImpl> findBy(String[] fields, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserImpl> findAllSortedBy(String field, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public Boolean checkLogin(String email, String password){
        String p= EncodeSha.getHash(password);
        List<UserImpl> usersList = new ArrayList<UserImpl>();
        String[][] data = database.executeQuery("select * from userimpl where email='"+email+"' and password='"+p+"'");
        for(int i=1; i<data.length; i++){
            usersList.add(parseUser(data,i));
        }
        if(usersList.size()>0){
            return true;
        }

        return false;
    }

}
