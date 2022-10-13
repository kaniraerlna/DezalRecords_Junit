/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.DezalRecordsUtil;
import pojo.Orders;


/**
 *
 * @author Miss KaNiRa
 */
public class DAOOrders {
    public void addOrder (Orders order){
        Transaction trans = null;
        Session session = DezalRecordsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(order);
            trans.commit();
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    
    public void deleteOrder (Integer idO){
        Transaction trans = null;
        Session session = DezalRecordsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Orders order = (Orders) session.load(Orders.class, new Integer(idO));
            session.delete(order);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Orders> getbyIDAlbum (Integer idO){
        Orders order = new Orders();
        List<Orders> lOrder = new ArrayList();
        
        Transaction trans = null;
        Session session = DezalRecordsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Orders where id_order= :id");
            query.setInteger("id", idO);
        } catch (Exception e) {
            
        }
        return lOrder;
    }
    
    public List<Orders> retrieveTblOrder(){
        List stud = new ArrayList();
        Orders stud1 = new Orders();
        Transaction trans = null;
        Session session = DezalRecordsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Orders");
            stud = query.list();
            stud.add(stud1.getAmount());
            stud.add(stud1.getPrice());
            stud.add(stud1.getTotalPrice());
            stud.add(stud1.getIdAdmin());
            stud.add(stud1.getIdAlbum());
            stud.add(stud1.getOrderDate());
            trans.commit();
        } catch (Exception e) {
            
        }
        
        return stud;
    }
    
    public void updateOrder(Orders order){
        Transaction trans = null;
        Session session = DezalRecordsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(order);
            trans.commit();
        } catch (Exception e){
            
        }
    }
}
