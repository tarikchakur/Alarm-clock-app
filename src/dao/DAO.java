/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 import java.sql.*;
  import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    private String pilote;
    private String URL;
    private String login;
    private String password;
    private Connection Connexion;

    public DAO() {}
    
    public DAO(String pilote, String URL, String login, String password) {
        this.pilote = pilote;
        this.URL = URL;
        this.login = login;
        this.password = password;
    }
    
    public void seConnecter(){
        try {
            Class.forName(pilote);
            System.out.println("Pilote correctement chargé ..");
            Connexion = DriverManager.getConnection(URL, login, password);
            System.out.println("Connexion établie ..");
        } 
        catch (ClassNotFoundException ex) {
            System.err.println("Problème de chargement du pilote [" + pilote + "].");
        } 
        catch (SQLException ex) {
            System.err.println("Problème de connexion : vérifier l'URL, le login et le mot de passe.");
        }
    }

    public void setPilote(String pilote) {
        this.pilote = pilote;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Connection getConnexion(){
        return Connexion;
    }
}

