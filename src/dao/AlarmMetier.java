/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entities.Alarm;
import java.sql.*;
import java.util.Vector;


/**
 *
 * @author Tarik
 */
public class AlarmMetier {
    private  DAO daoEtudiant;
    private Connection connexion;
    
    public AlarmMetier()
    {
        daoEtudiant=new DAO();
        daoEtudiant.setPilote("com.mysql.jdbc.Driver");
        daoEtudiant.setURL("jdbc:mysql://localhost:3306/alaram");
        daoEtudiant.setLogin("root");
        daoEtudiant.setPassword("");
        daoEtudiant.seConnecter();
        connexion=daoEtudiant.getConnexion();
        
        
  
    }
    public void add(Alarm A)
    {
        try {
            String sql="insert into alarm(nom,days,hour,min,snooze_temps,active,path_song,snoozed_hour,snoozed_min,memo) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement=connexion.prepareStatement(sql);
            
            statement.setString(1,A.getNom());
            statement.setString(2,A.getDays());
            statement.setInt(3,A.getHour());
            statement.setInt(4,A.getMin());
            statement.setInt(5, A.getSnooze_temps());
            statement.setBoolean(6, A.isActive());
            statement.setString(7, A.getPath());
            statement.setInt(8,A.getSnoozedHour());
            statement.setInt(9,A.getSnoozedMin());
            statement.setString(10,A.getMemo());
            
           statement.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("error ADD");
        }
        
    }
      public ResultSet display()
    {
       
        try {
            Statement statement=connexion.createStatement();
          ResultSet  rs=statement.executeQuery("select * from alarm");
             return rs;
        } catch (SQLException e) {
            System.out.println("error Display");
            return null;
        }
        
       
        
    }
      public Alarm getAlarm(int id_alarm )
    {
      
        try {
             Alarm A=new Alarm();
          
                PreparedStatement statement=connexion.prepareStatement("select * from alarm where id_alarm=?");
                statement.setInt(1,id_alarm);
                ResultSet  rs=statement.executeQuery();         
         while(rs.next())
         {
              A.setIdAlarm(rs.getInt(1));
              A.setNom(rs.getString(2));
              A.setDays(rs.getString(3));
              A.setHour(rs.getInt(4));
              A.setMin(rs.getInt(5));
              A.setSnooze_temps(rs.getInt(6));
              A.setActive(rs.getBoolean(7));
              A.setPath(rs.getString(8));
              A.setSnoozedHour(rs.getInt(9));
              A.setSnoozedMin(rs.getInt(10));
              A.setMemo(rs.getString(11));
              
         }
            
            return A;
        } catch (SQLException e) {
            System.out.println("error getting the Alarm Object");
            return null;
        }
        
       
      
    }
       public Vector<Alarm> getAlarms( )
    {
      
        try {
             Vector<Alarm> VA=new Vector<Alarm>();
              
                Statement statement=connexion.createStatement();
                ResultSet  rs=statement.executeQuery("select * from alarm ");         
         while(rs.next())
         {
             Alarm A=new Alarm();
              A.setIdAlarm(rs.getInt(1));
              A.setNom(rs.getString(2));
              A.setDays(rs.getString(3));
              A.setHour(rs.getInt(4));
              A.setMin(rs.getInt(5));
              A.setSnooze_temps(rs.getInt(6));
              A.setActive(rs.getBoolean(7));
              A.setPath(rs.getString(8));
              A.setSnoozedHour(rs.getInt(9));
              A.setSnoozedMin(rs.getInt(10));
              A.setMemo(rs.getString(11));
              VA.add(A);
         }
            
            return VA;
        } catch (SQLException e) {
            System.out.println("error getting the Alarm Object");
            return null;
        }
        
       
      
    }
      
      public void Update( Alarm A)
      {
       
          try {
              PreparedStatement statement=connexion.prepareStatement("UPDATE alarm SET nom=?,days=?,hour=?,min=?,snooze_temps=?,active=?,path_song=?,snoozed_hour=?,snoozed_min=?,memo=?  WHERE id_alarm=?");
               statement.setString(1,A.getNom());
               statement.setString(2,A.getDays());
               statement.setInt(3,A.getHour());
               statement.setInt(4,A.getMin());
               statement.setInt(5, A.getSnooze_temps());
               statement.setBoolean(6, A.isActive());
               statement.setString(7, A.getPath());
                statement.setInt(8,A.getSnoozedHour());
                 statement.setInt(9,A.getSnoozedMin());
                  statement.setString(10, A.getMemo());
                  statement.setInt(11, A.getIdAlarm());
                
             
               statement.executeUpdate();
          
             }
          catch (SQLException e) {
               System.out.println("error Update");
             }
          
      }
    public void delete(int id)
    {
        String sql="DELETE FROM alarm WHERE id_alarm=?";
        try {
            PreparedStatement statement=connexion.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
             System.out.println("error Delete");
        }
    }
    public void activer(int id, int a)
    {
        if(a==0)
        {
            try {
            PreparedStatement statement=connexion.prepareStatement("update alarm set active=? where id_alarm=?");
            statement.setBoolean(1,false);
            statement.setInt(2,id);
            statement.executeUpdate();
             } 
            catch (SQLException e) {
             System.out.println("error Delete");
             }
        }
        else{
             try {
                PreparedStatement statement=connexion.prepareStatement("update alarm set active=? where id_alarm=?");
                statement.setBoolean(1,true);
                 statement.setInt(2,id);
                statement.executeUpdate();
             } catch (SQLException e) {
             System.out.println("error Delete");
             }
            
        }
    }
    public boolean exist(Alarm A)
    {
        boolean exist=true;
        try {
            PreparedStatement statement=connexion.prepareStatement("select * from alarm where (nom=? or (hour=? and min=?)) and id_alarm<>?");
            statement.setString(1,A.getNom());
            statement.setInt(2,A.getHour());
            statement.setInt(3,A.getMin());
            statement.setInt(4,A.getIdAlarm());
            ResultSet rs=statement.executeQuery();
            if(rs.first()==false)
             exist=false;  
            else 
                exist=true;
            
        } catch (SQLException e) { 
        System.out.println("error exist()");}
        
        return exist;
        
    }

    public void Add(Alarm alarm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
