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
import pojo.Albums;
import pojo.DezalRecordsUtil;

/**
 *
 * @author Miss KaNiRa
 */
public class DAOAlbums {
    public void addAlbum(Albums album) {
        Transaction trans = null;
        Session session = DezalRecordsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(album);
            trans.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void deleteAlbum (Integer idAlbum){
        Transaction trans = null;
        Session session = DezalRecordsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Albums album = (Albums) session.load(Albums.class, new Integer(idAlbum));
            session.delete(album);
            trans.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public List<Albums> getbyID(String idA){
        Albums album = new Albums();
        List<Albums> lAlbum = new ArrayList();
        
        Transaction trans = null;
        Session session = DezalRecordsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Albums where id_album= :id");
            query.setString("id",idA);
            album = (Albums) query.uniqueResult();
            lAlbum = query.list();
            trans.commit();
        } catch (Exception e){
            
        }
        
        return lAlbum;
    }
    
    public List<Albums> retrieveTblAlbums(){
        List stud = new ArrayList();
        Albums studl = new Albums();
        Transaction trans = null;
        Session session = DezalRecordsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Albums");
            stud = query.list();
            stud.add(studl.getAlbumName());
            stud.add(studl.getArtist());
            stud.add(studl.getYears());
            stud.add(studl.getType());
            stud.add(studl.getPrice());
            stud.add(studl.getStock());
            trans.commit();
        } catch (Exception e) {
            
        }
        
        return stud;
    }
    
    public void updateAlbum(Albums album) {
        Transaction trans = null;
        Session session = DezalRecordsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(album);
            trans.commit();
        } catch (Exception e){
            
        }
    }
}
