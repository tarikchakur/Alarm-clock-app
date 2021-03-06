/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import Entities.Alarm;
import Time_MP3.MP3Player;
import dao.AlarmMetier;
import dao.Modele;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;



public class Test extends javax.swing.JFrame {
 
 Alarm A=new Alarm();
 int id_alarm_current=0;
 String song="",path="";
 AlarmMetier Am=new AlarmMetier();
 MP3Player track=new MP3Player();
  Vector<Alarm> Alarms;
 public void actualiser()
 {
 AlarmTable.setModel(new Modele(Am.display()));
 }
 
   
   
    public Test() {
        initComponents();
       actualiser();
     
         Alarms=Am.getAlarms(); 
         
          
          new Thread()
       {
        public void run(){
            
            int snooze=0;
            while(true)
        {
       
             
           for(int k=0;k<Alarms.size();)
           {           
            Calendar C=new GregorianCalendar();
            int day=C.get(Calendar.DAY_OF_WEEK);
            
            int h=C.get(Calendar.HOUR_OF_DAY);
            int m=C.get(Calendar.MINUTE);
            int s=C.get(Calendar.SECOND);
            int ms=C.get(Calendar.MILLISECOND);
           
            
           try{
               
               // si alarme va etre declencher aujourd'hui
            boolean today=false;
            
            for(int i=0;i<daysToInt(Alarms.elementAt(k).getDays()).size();i++)
           {
               if(day==daysToInt(Alarms.elementAt(k).getDays()).elementAt(i));
                  today=true;
           }
         // pour ajuster le temps
              adjustTime(Alarms.elementAt(k).getHour(),Alarms.elementAt(k).getMin(),Alarms.elementAt(k).getSnooze_temps());
            
            int p=2;
            if(today && h==Alarms.elementAt(k).getHour() && (m==Alarms.elementAt(k).getMin() || m==Alarms.elementAt(k).getMin()+snooze) && s==0 &&  ms <0.09)
            {
             track.Play(Alarms.elementAt(k).getPath());
             snooze+=Alarms.elementAt(k).getSnooze_temps(); // on active la repetition & ask him if he want too
             String msg="repeat after "+Alarms.elementAt(k).getSnooze_temps()+" minute(s) ?";
             p= JOptionPane.showConfirmDialog(null,  msg,Alarms.elementAt(k).getNom() , JOptionPane.YES_NO_OPTION);
                // if he doesn't wanna repeat the snooze will be zero so M==B.getMin()+0 it's already passed 
                if(p==1)
                {
                track.Stop();
                snooze=0;
                }
                 // if he wants to the it's activated
               else
                {
                track.Stop();
                // il faut incrementer le snooze pour satisfaire la condition de play tant qu'il n'a pas dit non 
                
                
                }
 
            }
            else{
                k++;
            }
            
           }
           
           catch(NumberFormatException e){}
         
            
        }
        }
       
    }
       
           }.start();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public String checkedDays()
    {
         String days="";
         if(sun.isSelected())
             days+="0-";
         if(mon.isSelected())
             days+="1-";
         if(tue.isSelected())
             days+="2-";
         if(wed.isSelected())
             days+="3-";
         if(thur.isSelected())
             days+="4-";
         if(fri.isSelected())
             days+="5-";
         if(sat.isSelected())
             days+="6-";
        return days;
    }
    public void UnCheckAll()
    {
        sun.setSelected(false);  
        mon.setSelected(false);
        tue.setSelected(false);
        wed.setSelected(false);
        thur.setSelected(false);
        fri.setSelected(false);
        sat.setSelected(false);

                    
    }
    public void DaysChecked(String S)
    {
          StringTokenizer St=new StringTokenizer(S,"-");
        
            while(St.hasMoreTokens())
            {
                switch(St.nextToken())
                {
                    case "0":  sun.setSelected(true);
                               break;
                    case "1":  mon.setSelected(true);
                               break;
                    case "2":  tue.setSelected(true);
                               break;
                    case "3":  wed.setSelected(true);
                               break;
                    case "4":  thur.setSelected(true);
                               break;
                    case "5":  fri.setSelected(true);
                               break;
                    case "6":  sat.setSelected(true);
                               break;
                    
                    
                }
  
            }
    }
    
     public  Vector<Integer> daysToInt(String S)
    {
        Vector<Integer> semaine=new Vector<Integer>(7);
        
        
        StringTokenizer St=new StringTokenizer(S,"-");
        
            while(St.hasMoreTokens())
            {
              semaine.add(new Integer(St.nextToken()));
                
            }
            return semaine;    
    }
    public void adjustTime(Integer h,Integer m,int addedTime)
    {
        if(m+addedTime>59)
        {
            h++;
            m=m+addedTime-60;
            return;
        }
      m=m+addedTime;        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkbox1 = new java.awt.Checkbox();
        jToggleButton1 = new javax.swing.JToggleButton();
        butSave = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AlarmTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtAlarm = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtHour = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sun = new javax.swing.JCheckBox();
        mon = new javax.swing.JCheckBox();
        tue = new javax.swing.JCheckBox();
        wed = new javax.swing.JCheckBox();
        thur = new javax.swing.JCheckBox();
        fri = new javax.swing.JCheckBox();
        sat = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        snoozeTemps = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        labelDisplay = new javax.swing.JLabel();
        butchooser = new javax.swing.JButton();
        butPlayStop = new javax.swing.JButton();

        checkbox1.setLabel("checkbox1");

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(700, 410));
        setMinimumSize(new java.awt.Dimension(700, 410));
        setPreferredSize(new java.awt.Dimension(700, 410));
        setResizable(false);
        getContentPane().setLayout(null);

        butSave.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        butSave.setText("ADD");
        butSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSaveActionPerformed(evt);
            }
        });
        getContentPane().add(butSave);
        butSave.setBounds(330, 130, 110, 30);

        delete.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(120, 130, 120, 30);

        AlarmTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        AlarmTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AlarmTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(AlarmTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 700, 120);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel1.setText("Description");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 200, 110, 34);

        txtAlarm.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        txtAlarm.setText("alarme");
        txtAlarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlarmActionPerformed(evt);
            }
        });
        getContentPane().add(txtAlarm);
        txtAlarm.setBounds(120, 200, 121, 34);

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel7.setText("Temps");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(320, 200, 65, 43);

        txtHour.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        txtHour.setText("00");
        txtHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHourActionPerformed(evt);
            }
        });
        getContentPane().add(txtHour);
        txtHour.setBounds(410, 200, 36, 43);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel6.setText(" :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(450, 200, 30, 43);

        txtMin.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        txtMin.setText("00");
        txtMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinActionPerformed(evt);
            }
        });
        getContentPane().add(txtMin);
        txtMin.setBounds(490, 200, 40, 43);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel3.setText("  Chaque");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 270, 95, 32);

        sun.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        sun.setText("dim");
        getContentPane().add(sun);
        sun.setBounds(120, 270, 57, 32);

        mon.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        mon.setText("lun");
        mon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monActionPerformed(evt);
            }
        });
        getContentPane().add(mon);
        mon.setBounds(200, 270, 55, 30);

        tue.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        tue.setText("mar");
        getContentPane().add(tue);
        tue.setBounds(270, 270, 59, 30);

        wed.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        wed.setText("mer");
        getContentPane().add(wed);
        wed.setBounds(340, 270, 60, 32);

        thur.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        thur.setText("jeu");
        getContentPane().add(thur);
        thur.setBounds(420, 270, 60, 32);

        fri.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        fri.setText("ven");
        fri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friActionPerformed(evt);
            }
        });
        getContentPane().add(fri);
        fri.setBounds(490, 270, 60, 32);

        sat.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        sat.setText("sam");
        getContentPane().add(sat);
        sat.setBounds(570, 270, 70, 32);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel2.setText("Repeter toutes les");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 330, 180, 35);

        snoozeTemps.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        snoozeTemps.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "3", "5", "7", "10" }));
        snoozeTemps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snoozeTempsActionPerformed(evt);
            }
        });
        getContentPane().add(snoozeTemps);
        snoozeTemps.setBounds(180, 329, 60, 40);

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel9.setText("minutes");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(260, 330, 68, 40);

        labelDisplay.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelDisplay.setText("select file");
        getContentPane().add(labelDisplay);
        labelDisplay.setBounds(390, 330, 95, 40);

        butchooser.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        butchooser.setText("+");
        butchooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butchooserActionPerformed(evt);
            }
        });
        getContentPane().add(butchooser);
        butchooser.setBounds(490, 330, 50, 36);

        butPlayStop.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        butPlayStop.setText("play");
        butPlayStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butPlayStopActionPerformed(evt);
            }
        });
        getContentPane().add(butPlayStop);
        butPlayStop.setBounds(560, 330, 70, 36);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHourActionPerformed

    private void snoozeTempsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snoozeTempsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snoozeTempsActionPerformed

    private void butchooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butchooserActionPerformed
          FileNameExtensionFilter filter= new FileNameExtensionFilter("MP3 FILES","mp3","mpeg3");
       JFileChooser chooser=new JFileChooser("C:\\Users\\Tarik\\Desktop\\mami");
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

    private void txtAlarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlarmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlarmActionPerformed

    private void butSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSaveActionPerformed
       
        if(butSave.getText().equalsIgnoreCase("ADD"))
        {
        try{  
               A.setNom(txtAlarm.getText());
               A.setDays(checkedDays());
               A.setHour(Integer.parseInt(txtHour.getText()));
               A.setMin(Integer.parseInt(txtMin.getText()));
               A.setSnooze_temps(Integer.parseInt((String)snoozeTemps.getSelectedItem()));
               A.setActive(true);
               A.setPath(path);
               Am.add(A);
               actualiser(); 
               Alarms=Am.getAlarms();
        }catch(Exception ex){}
        
        }
        else{
              try{  
               A.setIdAlarm(id_alarm_current);
               A.setNom(txtAlarm.getText());
               A.setDays(checkedDays());
               A.setHour(Integer.parseInt(txtHour.getText()));
               A.setMin(Integer.parseInt(txtMin.getText()));
               A.setSnooze_temps(Integer.parseInt((String)snoozeTemps.getSelectedItem()));
               A.setActive(true);
               A.setPath(path);
               Am.Update(A);
               actualiser(); 
                Alarms=Am.getAlarms();
               butSave.setText("ADD"); 
             
        }catch(Exception ex){}
        
        }
        
    }//GEN-LAST:event_butSaveActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
         Am.delete(id_alarm_current);
         Alarms=Am.getAlarms();
         actualiser();
    }//GEN-LAST:event_deleteActionPerformed

    private void butPlayStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPlayStopActionPerformed
          if(butPlayStop.getText().equalsIgnoreCase("Play"))
          {
              track.Stop();
              track.Play(path);
              butPlayStop.setText("Stop");
          }
          else{
              track.Stop();
              butPlayStop.setText("Play");
              
          }
    }//GEN-LAST:event_butPlayStopActionPerformed

    private void AlarmTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlarmTableMouseClicked
        TableModel Modele=AlarmTable.getModel();
    try{
        id_alarm_current=Integer.parseInt(Modele.getValueAt(AlarmTable.getSelectedRow(), 0).toString());
        txtAlarm.setText(Modele.getValueAt(AlarmTable.getSelectedRow(),1).toString());
        String Days=Modele.getValueAt(AlarmTable.getSelectedRow(),2).toString();
        UnCheckAll();
        DaysChecked(Days);

        txtHour.setText(Modele.getValueAt(AlarmTable.getSelectedRow(),3).toString());
        txtMin.setText(Modele.getValueAt(AlarmTable.getSelectedRow(),4).toString());
        
        snoozeTemps.setSelectedItem(Integer.parseInt(Modele.getValueAt(AlarmTable.getSelectedRow(),5).toString()));
       
        labelDisplay.setText(Modele.getValueAt(AlarmTable.getSelectedRow(),7).toString());
    }
    catch(NumberFormatException ex){}
    

        butSave.setText("UPDATE");        
        
    }//GEN-LAST:event_AlarmTableMouseClicked

    private void monActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monActionPerformed

    private void friActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_friActionPerformed

    private void txtMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinActionPerformed
  
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
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AlarmTable;
    private javax.swing.JButton butPlayStop;
    private javax.swing.JButton butSave;
    private javax.swing.JButton butchooser;
    private java.awt.Checkbox checkbox1;
    private javax.swing.JButton delete;
    private javax.swing.JCheckBox fri;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelDisplay;
    private javax.swing.JCheckBox mon;
    private javax.swing.JCheckBox sat;
    private javax.swing.JComboBox snoozeTemps;
    private javax.swing.JCheckBox sun;
    private javax.swing.JCheckBox thur;
    private javax.swing.JCheckBox tue;
    private javax.swing.JTextField txtAlarm;
    private javax.swing.JTextField txtHour;
    private javax.swing.JTextField txtMin;
    private javax.swing.JCheckBox wed;
    // End of variables declaration//GEN-END:variables
}
