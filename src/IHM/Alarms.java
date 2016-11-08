/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import Entities.Alarm;
import static IHM.Accueil.alarms;
import Time_MP3.MP3Player;
import dao.AlarmMetier;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


/**
 *
 * @author Tarik
 */
public class Alarms extends javax.swing.JFrame {
static Vector<Alarm> alarms;
MP3Player track=new MP3Player();
AlarmMetier AM;
Vector<JButton> jbut;
Vector<JLabel> jlabel;
Vector<JLabel> jdelimiteur;
Vector<JLabel> jours;
Vector<JButton>jsup;
Vector<JButton>jmemo;


Image active,notActive,sup,delimiteur,add,snooze,back,memo2;


 
    public Alarms() {
       
        initComponents();
         AM= new AlarmMetier();
     alarms=AM.getAlarms();
     // centrer l'app 
     Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
      // scroll pane
      JPanel container = new JPanel();
      JScrollPane scrPane = new JScrollPane(container);
       add(scrPane); 
     //bg color
     this.getContentPane().setBackground(new Color(245,245,245));
    //title
     this.setTitle("Wake Me UP");
      //algo d'alarme
     
           new Thread()
       {
        public void run(){
            
     
            while(true)
        {
            
          try{  
                 Thread.sleep(1000);
             
           for(int k=0;k<alarms.size() ;k++)
           {           
            Calendar C=new GregorianCalendar();
            int day=C.get(Calendar.DAY_OF_WEEK);
            
            int h=C.get(Calendar.HOUR_OF_DAY);
            int m=C.get(Calendar.MINUTE);
           
           
            
           
               // si alarme va etre declencher aujourd'hui
            boolean today=false;
            
            for(int i=0;i<WeekInt(alarms.elementAt(k).getDays()).length;i++)
           {
               if(day==WeekInt(alarms.elementAt(k).getDays())[i])
               {
                  today=true;
                  break;
               }
           }
         // pour ajuster le temps
              //adjustTime(alarms.elementAt(k).getHour(),alarms.elementAt(k).getMin(),alarms.elementAt(k).getSnooze_temps());
           
         
          
            if(alarms.elementAt(k).isActive() && today==true && h==alarms.elementAt(k).getSnoozedHour() && m==alarms.elementAt(k).getSnoozedMin()   )
            {
              if(alarms.elementAt(k).getSnoozedMin()+alarms.elementAt(k).getSnooze_temps() > 59)
              {
           alarms.elementAt(k).setSnoozedHour(alarms.elementAt(k).getSnoozedHour()+1);
           alarms.elementAt(k).setSnoozedMin(alarms.elementAt(k).getSnoozedMin()+alarms.elementAt(k).getSnooze_temps()-60);
              }
              else
              {
           alarms.elementAt(k).setSnoozedMin( alarms.elementAt(k).getSnoozedMin()+alarms.elementAt(k).getSnooze_temps());
           alarms.elementAt(k).setSnoozedHour(alarms.elementAt(k).getSnoozedHour());
          
              }
             
             AM.Update(alarms.elementAt(k));
                 
              
              
//  snooze+=alarms.elementAt(k).getSnooze_temps();
                 // track.Stop();
              if(alarms.elementAt(k).getMemo()!=null)
              {
                new Memo(alarms.elementAt(k)).setVisible(true);
              }
             track.Play(alarms.elementAt(k).getPath());
            String msg="répèter aprés  "+alarms.elementAt(k).getSnooze_temps()+" minute(s) ?";
              int reponse= JOptionPane.showConfirmDialog(null, msg,alarms.elementAt(k).getNom() , JOptionPane.YES_NO_OPTION,QUESTION_MESSAGE,new ImageIcon(snooze));
                     
// if he doesn't wanna repeat the snooze will be zero so M==B.getMin()+0 it's already passed 
             if(reponse==JOptionPane.NO_OPTION)
                {
                track.Stop();
              alarms.elementAt(k).setSnoozedHour(alarms.elementAt(k).getHour()-1);
              alarms.elementAt(k).setSnoozedMin(alarms.elementAt(k).getMin());
              AM.Update(alarms.elementAt(k));
                Thread.sleep(60*1000);
              alarms.elementAt(k).setSnoozedHour(alarms.elementAt(k).getHour()+1);// arret d'une minute <=> maximum temps a attendre pour la condition soit false & stop the alarm till next time
                AM.Update(alarms.elementAt(k));
                }
                 // if he wants to the it's activated
             else 
                {
                 track.Stop();
                
                         
             //Thread.sleep(alarms.elementAt(k).getSnooze_temps()*59*1000);
                // il faut incrementer le snooze pour satisfaire la condition de play tant qu'il n'a pas dit non  
                }
         
            }

            
           }
           
           }
           catch(NumberFormatException | InterruptedException  e){}
        
            
        
        }
             
       
    }
       
           }.start();

   try {
   // Image img1 = ImageIO.read(getClass().getResource("../IMG/active-alarm.png"));
    active = ImageIO.read(getClass().getResource("../IMG/active-alarm.png"));
    notActive = ImageIO.read(getClass().getResource("../IMG/not-active-alarm.png"));
    sup = ImageIO.read(getClass().getResource("../IMG/sup.png"));
    add = ImageIO.read(getClass().getResource("../IMG/add2.jpg"));
    delimiteur = ImageIO.read(getClass().getResource("../IMG/delimiteur.png"));
    snooze= ImageIO.read(getClass().getResource("../IMG/snooze.png"));
    memo2= ImageIO.read(getClass().getResource("../IMG/memo2.png"));
    back= ImageIO.read(getClass().getResource("../IMG/precedent.png"));
   
    
     }
   
   
      catch (IOException ex) {}
       
        
    
    
 // previous button  add label & button
     JButton butback=new JButton();
          butback.setSize(50, 50);
          butback.setLocation(0,0);
         butback.setIcon(new ImageIcon(back));
          butback.setOpaque(false);
          add(butback);
          butback.addActionListener(listenerback);
          
          
     JLabel labelAdd=new JLabel();
   
            labelAdd.setLocation(50,0); 
            labelAdd.setSize(318, 49); 
            labelAdd.setVisible(true);
            labelAdd.setOpaque(false);
            labelAdd.setText("          Alarmes");
            labelAdd.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            labelAdd.setForeground(Color.black);
            add(labelAdd);
     JButton butAdd=new JButton();
          butAdd.setSize(50, 50);
          butAdd.setLocation(370,0);
          butAdd.setIcon(new ImageIcon(add));
        butAdd.setBackground(Color.darkGray);
         
          butAdd.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
          butAdd.setOpaque(false);
          add(butAdd);
          butAdd.addActionListener(listenerAdd);
          
     // the icons button & days & description label
      jlabel=new Vector<JLabel>();
      jbut=new Vector<JButton>();
      jsup=new Vector<JButton>();
      jdelimiteur=new Vector<JLabel>();
      jours=new Vector<JLabel>();
      jmemo=new Vector<JButton>();
      
        int ypas=0;
        
         for(int i=0; i<alarms.size() ;i++)
        {  
           // creation des jbuttons
            if(alarms.elementAt(i).isActive())
              jbut.add(new JButton(new ImageIcon(active)));
            else
          jbut.add(new JButton(new ImageIcon(notActive)));
         jbut.elementAt(i).setLocation(0,19+50+22+ypas);
         jbut.elementAt(i).setSize(95, 48);        
         jbut.elementAt(i).setVisible(true);
        
      
         jbut.elementAt(i).addActionListener(listener);
         
         add( jbut.elementAt(i));
        
        //label delimiteur
          jdelimiteur.add(new JLabel());
         jdelimiteur.elementAt(i).setLocation(0,50+ypas);
         jdelimiteur.elementAt(i).setSize(430,19);
         jdelimiteur.elementAt(i).setVisible(true);
         jdelimiteur.elementAt(i).setIcon(new ImageIcon(delimiteur));
                
        add(jdelimiteur.elementAt(i));
       
      
          // creation des jlabels
         
         jlabel.add(new JLabel());
         jlabel.elementAt(i).setLocation(95,50+19+ypas);
         jlabel.elementAt(i).setSize(275,75);
         jlabel.elementAt(i).setVisible(true);
         jlabel.elementAt(i).setBackground(new Color(245,245,245));
         jlabel.elementAt(i).setForeground(Color.DARK_GRAY);
         jlabel.elementAt(i).setOpaque(true);
         jlabel.elementAt(i).setFont(new Font("Gadugi", Font.PLAIN, 55));
       
         // presentation
            String H=""+alarms.elementAt(i).getHour();
            String M=""+alarms.elementAt(i).getMin();
           
            if(alarms.elementAt(i).getHour()<10)
                H="0"+alarms.elementAt(i).getHour();
            if(alarms.elementAt(i).getMin()<10)
                M="0"+alarms.elementAt(i).getMin();
            
         
       String txt="   "+H+" : "+M;
        
       jlabel.elementAt(i).setText(txt);
      
       
       jlabel.elementAt(i).addMouseListener(createMouseListener());
       this.add(jlabel.elementAt(i));
        //
           // label des jours
         
         jours.add(new JLabel());
         jours.elementAt(i).setLocation(95,19+125+ypas);
         jours.elementAt(i).setSize(275,35);
         jours.elementAt(i).setVisible(true);
         jours.elementAt(i).setBackground(new Color(245,245,245));
         jours.elementAt(i).setForeground(Color.GRAY);
          jours.elementAt(i).setOpaque(true);
       jours.elementAt(i).setFont(new Font("Gadugi", Font.PLAIN, 20));
       String text="       "+JOURS(WeekInt(alarms.elementAt(i).getDays()));
       jours.elementAt(i).setText(text);
        this.add(jours.elementAt(i));
    // creation des button sup
         
           jsup.add(new JButton(new ImageIcon(sup)));
         jsup.elementAt(i).setLocation(370, 65+ypas);
         jsup.elementAt(i).setSize(50, 50);  
         jsup.elementAt(i).setOpaque(false);
         jsup.elementAt(i).setVisible(true);
         
         jsup.elementAt(i).addActionListener(listenerSup);
         add(jsup.elementAt(i));
         // jmemo
         
         jmemo.add(new JButton(new ImageIcon(memo2)));
         jmemo.elementAt(i).setLocation(370,115+ypas);
         jmemo.elementAt(i).setSize(50, 50);  
         jmemo.elementAt(i).setOpaque(false);
         jmemo.elementAt(i).setVisible(true);
         
         jmemo.elementAt(i).addActionListener(listenermemo);
         
         this.add( jmemo.elementAt(i));
          ypas+=129;
    }
    }
    
 public  String JOURS(Integer[] T)
    {
         String days="";
        
             
      for(int i=0;i<T.length;i++)  
      {
         if(T[i]==2)
             days+="LUN,";
         if(T[i]==3)
             days+="MAR,";
         if(T[i]==4)
             days+="MER,";
         if(T[i]==5)
             days+="JEU,";
         if(T[i]==6)
             days+="VEN,";
         if(T[i]==7)
             days+="SAM,";
         if(T[i]==1)
             days+="DIM,";
      }
//          if(T[T.length-1]==2)
//             days+="LUN";
//         if(T[T.length-1]==3)
//             days+="MAR";
//         if(T[T.length-1]==4)
//             days+="MER";
//         if(T[T.length-1]==5)
//             days+="JEU";
//         if(T[T.length-1]==6)
//             days+="VEN";
//         if(T[T.length-1]==7)
//             days+="SAM";
//         if(T[T.length-1]==1)
//             days+="DIM";
    
      if(days.length()==27)
         days="CHAQUE JOURS";  
      if(days.length()==0)
          days="Aucun jour ";
        return days;
    }
      
    ActionListener listenerSup = new ActionListener(){
     public void actionPerformed(ActionEvent e){
         for(int i=0;i<jsup.size();i++)
            if(e.getSource() instanceof JButton && e.getSource()==jsup.elementAt(i))
            {
                 AM.delete(alarms.elementAt(i).getIdAlarm());
                 alarms=AM.getAlarms();
                 (Alarms.this).setVisible(false);
                        new Alarms().setVisible(true);
            }
        }
    }; 
     ActionListener listenermemo = new ActionListener(){
     public void actionPerformed(ActionEvent e){
         for(int i=0;i<jmemo.size();i++)
            if(e.getSource() instanceof JButton && e.getSource()==jmemo.elementAt(i))
            {
               
                 
                        new Memo(alarms.elementAt(i)).setVisible(true);
            }
        }
    }; 
        
  
    ActionListener listenerAdd = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(e.getSource() instanceof JButton)
            {
                 (Alarms.this).setVisible(false);
                        new Add().setVisible(true);
                        
                
            }
        }
    }; 
    ActionListener listenerback = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(e.getSource() instanceof JButton)
            {
                 (Alarms.this).setVisible(false);
                        new Accueil().setVisible(true);
                        
                
            }
        }
    }; 
     ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
              
      
            for(int i=0;i<jbut.size();i++)
            {
                if (e.getSource() instanceof JButton && e.getSource()==jbut.elementAt(i)) 
                {
                   if(alarms.elementAt(i).isActive())
                   {
                     ((JButton) e.getSource()).setIcon(new ImageIcon(notActive));
                     alarms.elementAt(i).setActive(false);
                  
                     
                   }
                   else
                   {
                      ((JButton) e.getSource()).setIcon(new ImageIcon(active)); 
                      alarms.elementAt(i).setActive(true);
                     
                      
                  
                   }
                       AM.Update(alarms.elementAt(i));
                      alarms=AM.getAlarms();
                 
                 }
            }
        }

  };
      public MouseAdapter createMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                
             for(int i=0;i<jlabel.size();i++)
                {   
                    if(e.getSource() instanceof JLabel && jlabel.elementAt(i)==e.getSource())
                     {
                       (Alarms.this).setVisible(false);
                        new Edit(alarms.elementAt(i)).setVisible(true);
                        AM.Update(alarms.elementAt(i));
                        
                        
                     }
                }
            }
        };
    }
        public  Integer[] WeekInt(String S)
    {
         Integer[] semaine={8,8,8,8,8,8,8};
                
        int i=0;
        StringTokenizer St=new StringTokenizer(S,"-");
        
            while(St.hasMoreTokens())
            {
                
              semaine[i]=Integer.parseInt(St.nextToken());
              i++;
                
            }
            return semaine;    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);
        setMaximumSize(new java.awt.Dimension(430, 500));
        setMinimumSize(new java.awt.Dimension(430, 500));
        setPreferredSize(new java.awt.Dimension(430, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Alarms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alarms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alarms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alarms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alarms().setVisible(true);
            }
        });
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
