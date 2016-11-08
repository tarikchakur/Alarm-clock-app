/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import Entities.Alarm;
import static IHM.Alarms.alarms;
import Time_MP3.MP3Player;
import dao.AlarmMetier;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Tarik
 */
public class Add extends javax.swing.JFrame {
  
   static Alarm alarm=new Alarm();;
    String song="",path="";
 AlarmMetier Am;
 MP3Player track=new MP3Player();
 Image playImage,stopImage;
 boolean add=true;
    /**
     * Creates new form AddEdit
     */
    public Add() {
                initComponents();
                Am=new AlarmMetier();
                // centrer l'app
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
               this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
                // eliminer le bouton X le traitememet de fremeture de cette frame gere par cancel button
                setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
          //
                this.setTitle("Wake Me UP");

       //bg color
               
     this.getContentPane().setBackground(Color.DARK_GRAY);
          
        
          try {
  
    playImage = ImageIO.read(getClass().getResource("../IMG/play.png"));
    
    stopImage = ImageIO.read(getClass().getResource("../IMG/stop.jpg"));

     }
   
   
      catch (IOException ex) {}
          butPlay.setName("play");
    }
    
    
    
      
    public String checked()
    {
         String days="";
         
         if(mon.isSelected())
             days+="2-";
       
         if(tue.isSelected())
             days+="3-";
         
         if(wed.isSelected())
             days+="4-";
         
         if(thur.isSelected())
             days+="5-";
          
         if(fri.isSelected())
             days+="6-";
         
         if(sat.isSelected())
             days+="7-";
         
         if(sun.isSelected())
             days+="1-";
        
        return days;
    }
     public void Check(String S)
    {
          StringTokenizer St=new StringTokenizer(S,"-");
        
            while(St.hasMoreTokens())
            {
                switch(St.nextToken())
                {
                    case "1":  sun.setSelected(true);
                               break;
                    case "2":  mon.setSelected(true);
                               break;
                    case "3":  tue.setSelected(true);
                               break;
                    case "4":  wed.setSelected(true);
                               break;
                    case "5":  thur.setSelected(true);
                               break;
                    case "6":  fri.setSelected(true);
                               break;
                    case "7":  sat.setSelected(true);
                               break;
                    
                    
                }
  
            }
    }
     public void DaysChecked(String S)
    {
          StringTokenizer St=new StringTokenizer(S,"-");
        
            while(St.hasMoreTokens())
            {
                switch(St.nextToken())
                {
                    case "1":  sun.setSelected(true);
                               break;
                    case "2":  mon.setSelected(true);
                               break;
                    case "3":  tue.setSelected(true);
                               break;
                    case "4":  wed.setSelected(true);
                               break;
                    case "5":  thur.setSelected(true);
                               break;
                    case "6":  fri.setSelected(true);
                               break;
                    case "7":  sat.setSelected(true);
                               break;
                    
                    
                }
  
            }
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        thur = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        wed = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        tue = new javax.swing.JCheckBox();
        labelDisplay = new javax.swing.JLabel();
        sun = new javax.swing.JCheckBox();
        sat = new javax.swing.JCheckBox();
        txtAlarm = new javax.swing.JTextField();
        butSave1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        butPlay = new javax.swing.JButton();
        mon = new javax.swing.JCheckBox();
        snoozeTemps = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        fri = new javax.swing.JCheckBox();
        txtMin = new javax.swing.JSpinner();
        txtHour = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtmemo = new javax.swing.JTextArea();
        butCancel = new javax.swing.JButton();
        butchooser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        setMinimumSize(new java.awt.Dimension(460, 500));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));
        jPanel2.setMaximumSize(new java.awt.Dimension(460, 500));
        jPanel2.setMinimumSize(new java.awt.Dimension(460, 500));
        jPanel2.setLayout(null);

        thur.setBackground(new java.awt.Color(245, 245, 245));
        thur.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        thur.setText("jeudi");
        jPanel2.add(thur);
        thur.setBounds(340, 150, 90, 26);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText(" :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(200, 70, 24, 50);

        wed.setBackground(new java.awt.Color(245, 245, 245));
        wed.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        wed.setText("mercredi");
        jPanel2.add(wed);
        wed.setBounds(340, 120, 110, 26);

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        jLabel8.setText("Répeter(min)");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 140, 111, 35);

        tue.setBackground(new java.awt.Color(245, 245, 245));
        tue.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        tue.setText("mardi");
        jPanel2.add(tue);
        tue.setBounds(340, 100, 80, 20);

        labelDisplay.setBackground(new java.awt.Color(102, 102, 102));
        labelDisplay.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        labelDisplay.setText("                   Choisir Sonnerie");
        jPanel2.add(labelDisplay);
        labelDisplay.setBounds(0, 320, 310, 50);

        sun.setBackground(new java.awt.Color(245, 245, 245));
        sun.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        sun.setText("dimanche");
        jPanel2.add(sun);
        sun.setBounds(340, 240, 100, 26);

        sat.setBackground(new java.awt.Color(245, 245, 245));
        sat.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        sat.setText("samedi");
        jPanel2.add(sat);
        sat.setBounds(340, 210, 90, 26);

        txtAlarm.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtAlarm.setForeground(new java.awt.Color(102, 102, 102));
        txtAlarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlarmActionPerformed(evt);
            }
        });
        jPanel2.add(txtAlarm);
        txtAlarm.setBounds(140, 20, 170, 30);

        butSave1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        butSave1.setForeground(new java.awt.Color(102, 102, 102));
        butSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/save.PNG"))); // NOI18N
        butSave1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        butSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSave1ActionPerformed(evt);
            }
        });
        jPanel2.add(butSave1);
        butSave1.setBounds(70, 390, 120, 36);

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        jLabel3.setText("Temps");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 80, 111, 23);

        jLabel9.setBackground(new java.awt.Color(102, 102, 102));
        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        jLabel9.setText("chaque");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(320, 40, 111, 23);

        butPlay.setBackground(new java.awt.Color(102, 102, 102));
        butPlay.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        butPlay.setForeground(new java.awt.Color(102, 102, 102));
        butPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/play.png"))); // NOI18N
        butPlay.setMaximumSize(new java.awt.Dimension(50, 50));
        butPlay.setMinimumSize(new java.awt.Dimension(50, 50));
        butPlay.setPreferredSize(new java.awt.Dimension(50, 50));
        butPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butPlayActionPerformed(evt);
            }
        });
        jPanel2.add(butPlay);
        butPlay.setBounds(400, 320, 50, 50);

        mon.setBackground(new java.awt.Color(245, 245, 245));
        mon.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        mon.setText("lundi");
        mon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monActionPerformed(evt);
            }
        });
        jPanel2.add(mon);
        mon.setBounds(340, 70, 70, 26);

        snoozeTemps.setBackground(new java.awt.Color(245, 245, 245));
        snoozeTemps.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        snoozeTemps.setForeground(new java.awt.Color(102, 102, 102));
        snoozeTemps.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "3", "5", "7", "10" }));
        jPanel2.add(snoozeTemps);
        snoozeTemps.setBounds(150, 140, 59, 32);

        jLabel10.setBackground(new java.awt.Color(102, 102, 102));
        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        jLabel10.setText("Nom");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 20, 111, 32);

        fri.setBackground(new java.awt.Color(245, 245, 245));
        fri.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        fri.setText("vendredi");
        jPanel2.add(fri);
        fri.setBounds(340, 180, 110, 26);

        txtMin.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        txtMin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        txtMin.setOpaque(false);
        jPanel2.add(txtMin);
        txtMin.setBounds(230, 70, 50, 50);

        txtHour.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        txtHour.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        txtHour.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtHour.setFocusCycleRoot(true);
        txtHour.setOpaque(false);
        jPanel2.add(txtHour);
        txtHour.setBounds(140, 70, 50, 50);

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        jLabel5.setText("Memo");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 210, 111, 35);

        txtmemo.setColumns(20);
        txtmemo.setRows(5);
        jScrollPane1.setViewportView(txtmemo);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(140, 200, 170, 70);

        butCancel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        butCancel.setForeground(new java.awt.Color(102, 102, 102));
        butCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cancel.PNG"))); // NOI18N
        butCancel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        butCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCancelActionPerformed(evt);
            }
        });
        jPanel2.add(butCancel);
        butCancel.setBounds(230, 390, 120, 36);

        butchooser.setBackground(new java.awt.Color(102, 102, 102));
        butchooser.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        butchooser.setForeground(new java.awt.Color(102, 102, 102));
        butchooser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/add2.jpg"))); // NOI18N
        butchooser.setMaximumSize(new java.awt.Dimension(50, 50));
        butchooser.setMinimumSize(new java.awt.Dimension(50, 50));
        butchooser.setPreferredSize(new java.awt.Dimension(50, 50));
        butchooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butchooserActionPerformed(evt);
            }
        });
        jPanel2.add(butchooser);
        butchooser.setBounds(330, 320, 50, 50);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butchooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butchooserActionPerformed
 
        FileNameExtensionFilter filter= new FileNameExtensionFilter("MP3 FILES","mp3","mpeg3");
       JFileChooser chooser=new JFileChooser("Sounds");
       chooser.addChoosableFileFilter(filter);
       int val=chooser.showOpenDialog(null);
       if(val==JFileChooser.APPROVE_OPTION)
       {
           File monFile=chooser.getSelectedFile();
           path=monFile+" ";
           
           song=chooser.getSelectedFile().getName();
           labelDisplay.setText(song);
          
           
       }
    }//GEN-LAST:event_butchooserActionPerformed

    private void butCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCancelActionPerformed
            track.Stop();
            this.setVisible(false);
            new Alarms().setVisible(true);
    }//GEN-LAST:event_butCancelActionPerformed

    private void txtAlarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlarmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlarmActionPerformed

    private void butSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSave1ActionPerformed
       
        try{   
               alarm.setNom(txtAlarm.getText());
               alarm.setDays(checked());
               alarm.setHour(Integer.parseInt(txtHour.getValue().toString()));
               alarm.setMin(Integer.parseInt(txtMin.getValue().toString()));
               alarm.setSnooze_temps(Integer.parseInt((String)snoozeTemps.getSelectedItem()));
               alarm.setPath(path);
               alarm.setSnoozedHour(Integer.parseInt(txtHour.getValue().toString()));
               alarm.setSnoozedMin(Integer.parseInt(txtMin.getValue().toString()));
               alarm.setMemo(txtmemo.getText());
                if(Am.exist(alarm))
               {
                   JOptionPane.showMessageDialog(this,"Erreur : description ou l'heure existe deja !");
               }
               else
                {
                Am.add(alarm);
                }
                
             
        }catch(Exception ex){}
      finally{
            track.Stop();
          this.setVisible(false);
          new Alarms().setVisible(true);
          
      }
    }//GEN-LAST:event_butSave1ActionPerformed

    private void butPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPlayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butPlayActionPerformed

    private void monActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCancel;
    private javax.swing.JButton butPlay;
    private javax.swing.JButton butSave1;
    private javax.swing.JButton butchooser;
    private javax.swing.JCheckBox fri;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDisplay;
    private javax.swing.JCheckBox mon;
    private javax.swing.JCheckBox sat;
    private javax.swing.JComboBox snoozeTemps;
    private javax.swing.JCheckBox sun;
    private javax.swing.JCheckBox thur;
    private javax.swing.JCheckBox tue;
    private javax.swing.JTextField txtAlarm;
    private javax.swing.JSpinner txtHour;
    private javax.swing.JSpinner txtMin;
    private javax.swing.JTextArea txtmemo;
    private javax.swing.JCheckBox wed;
    // End of variables declaration//GEN-END:variables
}
