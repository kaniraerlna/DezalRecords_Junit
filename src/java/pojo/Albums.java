package pojo;
// Generated Oct 11, 2022 1:20:50 PM by Hibernate Tools 4.3.1

import DAO.DAOAlbums;
import java.util.List;
import javax.faces.bean.ManagedBean;




/**
 * Albums generated by hbm2java
 */

@ManagedBean
public class Albums  implements java.io.Serializable {


     private Integer idAlbum;
     private String albumName;
     private String artist;
     private String years;
     private String type;
     private Integer price;
     private Integer stock;

     
    public String saveAlbum(){
        DAOAlbums album = new DAOAlbums();
        album.addAlbum(this);
        
        return "album_list";
    }
    
    public String deleteAlbum(){
        DAOAlbums album = new DAOAlbums();
        album.deleteAlbum(idAlbum);
        
        return "album_list";
    }
    
    public String getbyID(){
        String id = idAlbum.toString();
        DAOAlbums album = new DAOAlbums();
        List<Albums> lAlbum = album.getbyID(id);
        try {
            if (lAlbum != null) {
                albumName = lAlbum.get(0).albumName;
                artist = lAlbum.get(0).artist;
                years = lAlbum.get(0).years;
                type = lAlbum.get(0).type;
                price = lAlbum.get(0).price;
                stock = lAlbum.get(0).stock;
            return "album_form";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        albumName = "";
        artist = "";
        price = 0;
        stock = 0;
        type = "";
        years = "";
        return "album_form_failed";
    }
    
    public List<Albums> getAllRecords(){
        DAOAlbums album = new DAOAlbums();
        List<Albums> lAlbum = album.retrieveTblAlbums();
        return lAlbum;
    }
    
    public String updateAlbum(){
        DAOAlbums album = new DAOAlbums();
        album.updateAlbum(this);
        
        return "album_list";
    }
     
    public String resetAlbum(){
        DAOAlbums album = new DAOAlbums();
        album.resetAlbum(idAlbum);
        idAlbum = 0;
        albumName = "";
        artist = "";
        price = 0;
        stock = 0;
        type = "";
        years = "";
        
        return "album_form";
    }
     
    public Albums() {
    }

	
    public Albums(String albumName) {
        this.albumName = albumName;
    }
    public Albums(String albumName, String artist, String years, String type, Integer price, Integer stock) {
       this.albumName = albumName;
       this.artist = artist;
       this.years = years;
       this.type = type;
       this.price = price;
       this.stock = stock;
    }
   
    public Integer getIdAlbum() {
        return this.idAlbum;
    }
    
    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }
    public String getAlbumName() {
        return this.albumName;
    }
    
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
    public String getArtist() {
        return this.artist;
    }
    
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getYears() {
        return this.years;
    }
    
    public void setYears(String years) {
        this.years = years;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public Integer getPrice() {
        return this.price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getStock() {
        return this.stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }


}


