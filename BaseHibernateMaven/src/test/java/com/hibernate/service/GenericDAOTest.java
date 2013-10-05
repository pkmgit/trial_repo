package com.hibernate.service;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hibernate.dao.generic.DAO;
import com.hibernate.entity.Stock;
import com.hibernate.exception.TransactionException;

public class GenericDAOTest {

	private static final String UPDATE_CODE = "1245";
	private static final String UPDATE_NAME = "Name Changed";
	private static final String STOCK_NAME = "xcsb";
	private static final String STOCK_CODE = "2638";


	static {
		ConfigurationBuilder.setCONFIG_FILE_LOCATION("config/hibernate.cfg.xml");
	}
	
    @Before
    public void startTransaction() {
    	System.out.println("Start Transaction");
    	TransactionHandler.beginTransaction();
    }
	
    @Test
    public void testSave() {
    	
    	System.out.println("Testing Save");
    	
    	DAO<Stock, Integer> dao = DAOFactory.getDAO(Stock.class);


    	
        try {
        	Stock stock = new Stock();
            
            stock.setStockCode(STOCK_CODE);
            stock.setStockName(STOCK_NAME);
        	
			dao.saveOrUpdate(stock);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
    	
        TransactionHandler.flushSession();
    }
	
    @Test
    public void testFindByProperty() {
        try {
        	DAO<Stock, Integer> dao = DAOFactory.getDAO(Stock.class);
            List<Stock> stocks = dao.findByProperty("stockCode", STOCK_CODE);
            System.out.println(stocks.size());
            if(stocks.size()==1){
            	Assert.assertEquals(stocks.get(0).getStockName(), STOCK_NAME);
            }
            else{
            	Assert.fail();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    
    
    @Test
    public void testUpdate() {
        try {
        	DAO<Stock, Integer> dao = DAOFactory.getDAO(Stock.class);
        	
        	Integer stockId = findAndUpdate(dao);
        	if(stockId!=null){
        		
        		Stock stock  = dao.findById(stockId, false);
        		Assert.assertEquals(stock.getStockCode(),UPDATE_CODE);
        		
        	}else{
        		Assert.fail("Stock id is null");
        	}
           
            
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Assert.fail();
        }
    }

	private Integer findAndUpdate(DAO<Stock, Integer> dao)
			throws TransactionException {
		List<Stock> stocks = dao.findByProperty("stockCode", STOCK_CODE);
		System.out.println(stocks.size());
		if(stocks.size()==1){
			
			TransactionHandler.clearSession();
			
			Stock newStock = new Stock();
			newStock.setStockId(stocks.get(0).getStockId());
			newStock.setStockName(UPDATE_NAME);
			newStock.setStockCode(UPDATE_CODE);
			
			dao.saveOrUpdate(newStock);

			return newStock.getStockId();
		}
		else{
			Assert.fail("No data is returned after find");
		}
		return null;
	}
    
    
    
    @Test
    public void testDelete() {
        try {
            List<Stock> stocks = DAOFactory.getDAO(Stock.class).loadAll();

            for (int i = 0; i < stocks.size(); i++) {
            	Stock stock = stocks.get(i);
                DAOFactory.getDAO(Stock.class).delete(stock);
            }
            
            List<Stock> stocksagain = DAOFactory.getDAO(Stock.class).loadAll();
            Assert.assertEquals(0, stocksagain.size());
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    
    @After
    public void endTransaction() {
    	TransactionHandler.completeTransaction();
    	System.out.println("End Transaction");
    }

}
