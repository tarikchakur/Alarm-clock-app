package dao;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class Modele extends AbstractTableModel{
    private int nb_lignes = 0;
    private int nb_colonnes;
    private String[] titres;
    private ArrayList<Vector<String>> lignes = new ArrayList<Vector<String>>();

    public Modele(ResultSet rs){
        
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            nb_colonnes = rsmd.getColumnCount();
           titres = new String[nb_colonnes];
           for(int i = 0; i < nb_colonnes; i++)
               titres[i] = rsmd.getColumnLabel(i+1);
           
           while(rs.next())
           {
               Vector<String> ligne = new Vector<String>();
               for(int i = 0; i < nb_colonnes; i++)
                   ligne.add(rs.getObject(i+1).toString());
               lignes.add((ligne));
               nb_lignes++;
           }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Modele.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int getRowCount() {
        return nb_lignes;
    }

    @Override
    public int getColumnCount() {
        return nb_colonnes;
    }

    @Override
    public String getValueAt(int i, int j) {
        return lignes.get(i).get(j);
    }
    
    @Override
    public String getColumnName(int c){
        return titres[c];
    }
}
