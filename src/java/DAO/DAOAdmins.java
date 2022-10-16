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
import pojo.Admins;
import pojo.DezalRecordsUtil;

/**
 *
 * @author Miss KaNiRa
 */
public class DAOAdmins {
    public List<Admins> getBy (String uEmail, String uPass){
        Admins a = new Admins();
        List<Admins> admin = new ArrayList();
        
        Transaction trans = null;
        Session session = DezalRecordsUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from Admins where email= :uEmail AND password= :uPass");
            query.setString("uPass", uPass);
            query.setString("uEmail", uEmail);
            a = (Admins) query.uniqueResult();
            admin = query.list();
            trans.commit();
        } catch(Exception e){
            System.out.println("Error" + e);
        }
        
        return admin;
    }
    
    public String add_admin(Admins admin){
        Transaction trans = null;
        Session session = DezalRecordsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(admin);
            trans.commit();
            return "index";
        } catch (Exception e) {
            System.out.println(e);
        }
        return "register_failed";
    }
    
    public List<Admins> retrieveTblAdmin(){
        List stud = new ArrayList();
        Admins stud1 = new Admins();
        Transaction trans = null;
        Session session = DezalRecordsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Admins");
            stud = query.list();
            stud.add(stud1.getAdminName());
            stud.add(stud1.getEmail());
            stud.add(stud1.getPassword());
            trans.commit();
        } catch (Exception e){

        }
        return stud;
    }
    
    public void updateAdmin(Admins admin){
        Transaction trans = null;
        Session session = DezalRecordsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(admin);
            trans.commit();
        } catch (Exception e) {
            
        }
    }
    
    public void deleteAdmin(Integer idAd){
        Transaction trans = null;
        Session session = DezalRecordsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Admins admin = (Admins) session.load(Admins.class, new Integer(idAd));
            session.delete(admin);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Admins> getbyID(String idAd){
        Admins admin = new Admins();
        List<Admins> lAdmin = new ArrayList();
        
        Transaction trans = null;
        Session session = DezalRecordsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Admins where id_admin= :id");
            query.setString("id", idAd);
            admin = (Admins) query.uniqueResult();
            lAdmin = query.list();
            trans.commit();
        } catch (Exception e) {
            
        }
        return lAdmin;
    }
    
    public void resetAdmin(Integer idAd)
    {
       Transaction trans = null;
       Session session = DezalRecordsUtil.getSessionFactory().openSession();
       
       try{
           trans = session.beginTransaction();
           Admins admin = (Admins) session.load(Admins.class, new Integer(idAd));
           session.clear();
           trans.commit();
       }catch(Exception e){
           System.out.println(e);
       }
    }
}
