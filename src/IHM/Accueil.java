/*
 * License MIT.
 * @author Tarik
 */
package IHM;

import Entities.Alarm;
import static IHM.Alarms.alarms;
import Time_MP3.MP3Player;
import dao.AlarmMetier;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.abs;
import java.net.URI;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Accueil extends javax.swing.JFrame {
static Vector<Alarm> alarms;
Image delimiteur;
JLabel jdate,jhour,facebook,twitter,instagram,youtube;
JButton next;
Vector<JLabel> jdelimiteur;
Image nextImage,face,twiter,insta,tube;
MP3Player track=new MP3Player();
String song="",path="";
AlarmMetier AM;
    public Accueil() {
        initComponents();
        AM= new AlarmMetier();
     alarms=AM.getAlarms();
     this.setTitle("Wake Me UP");
          //bg color
     this.getContentPane().setBackground(new Color(245,245,245));
      // centrer l'app 
     Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
     this.setSize(430, 500);
      this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
      //img delilimeteur
        try {
            delimiteur = ImageIO.read(getClass().getResource("../IMG/delimiteur.png"));
        } catch (Exception e) { }
    
         //labels delimiteur
        jdelimiteur=new Vector<JLabel>();
        int ypas=100;
        for(int i=0;i<3;i++)
        {
            
         jdelimiteur.add(new JLabel());
         jdelimiteur.elementAt(i).setLocation(0,ypas);
        jdelimiteur.elementAt(i).setSize(430,19);
         jdelimiteur.elementAt(i).setVisible(true);
         jdelimiteur.elementAt(i).setIcon(new ImageIcon(delimiteur));
                
        add(jdelimiteur.elementAt(i));
        ypas+=119;
    }
        // date label
         jdate=new JLabel();
               jdate.setLocation(0,0);
               jdate.setSize(430,100);
               jdate.setVisible(true);
               jdate.setBackground(new Color(245,245,245));
               jdate.setForeground(new Color(60,132,167));
               jdate.setOpaque(true);
             
               jdate.setFont(new Font("Arial", Font.PLAIN, 35));
               
                 jdate.setVisible(true);
               
               add(jdate);
               
           //heure label
         jhour=new JLabel();
               jhour.setLocation(0,119);
               jhour.setSize(430,100);
               jhour.setVisible(true);
               jhour.setBackground(new Color(245,245,245));
               jhour.setForeground(new Color(70,159,204));
               jhour.setOpaque(true);
             
               jhour.setFont(new Font("DS-DIGITAL", Font.PLAIN, 50));
               
                 jhour.setVisible(true);
               
               add(jhour);  
               //read images
                try {
  
    nextImage= ImageIO.read(getClass().getResource("../IMG/next.png"));
    face= ImageIO.read(getClass().getResource("../IMG/face.png"));
    tube= ImageIO.read(getClass().getResource("../IMG/tube.png"));
    twiter= ImageIO.read(getClass().getResource("../IMG/twitter.png"));
    insta= ImageIO.read(getClass().getResource("../IMG/insta.png"));
   

     }
   
   
      catch (IOException ex) {}
           
           facebook=new JLabel();
              facebook.setLocation(24,365);
              facebook.setSize(77,77);
               facebook.setVisible(true);
               facebook.setOpaque(true);
              facebook.setIcon(new ImageIcon(face));
              facebook.setVisible(true);
              facebook.addMouseListener(facebookListener());
              
              add(facebook); 
           
           
            instagram=new JLabel();
              instagram.setLocation(126,365);
              instagram.setSize(77,77);
              instagram.setVisible(true);
              instagram.setOpaque(true);
              instagram.setIcon(new ImageIcon(insta));
              instagram.setVisible(true);
              instagram.addMouseListener(instagramListener());
              add(instagram); 
           
           youtube=new JLabel();
              youtube.setLocation(228,365);
              youtube.setSize(77,77);
              youtube.setVisible(true);
              youtube.setOpaque(true);
              youtube.setIcon(new ImageIcon(tube));
              youtube.setVisible(true);
              youtube.addMouseListener(youtubeListener());
              add(youtube); 
           
           twitter=new JLabel();
             twitter.setLocation(330,365);
             twitter.setSize(77,77);
             twitter.setVisible(true);
             twitter.setOpaque(true);
             twitter.setIcon(new ImageIcon(twiter));
             twitter.setVisible(true);
             twitter.addMouseListener(twitterListener());
             add(twitter);
     
              
        // next page button
                next= new JButton();
               next.setLocation(165,242);
               next.setSize(90,90);
               next.setVisible(true);
              
               next.setOpaque(true);
             
              
                 next.setVisible(true);
                 next.setIcon(new ImageIcon(nextImage));
                 
                 next.addActionListener(listener);
               add(next);  
               
               
       new Thread()
       {
        public void run(){
            
           
            while(true)
        {
            
          try{  
                 Thread.sleep(1000);
        
            Calendar C=new GregorianCalendar();
            int day=C.get(Calendar.DAY_OF_WEEK);
           int jour=C.get(Calendar.DAY_OF_MONTH);
            int month=C.get(Calendar.MONTH);
            int year=C.get(Calendar.YEAR);
            int h=C.get(Calendar.HOUR_OF_DAY);
            int m=C.get(Calendar.MINUTE);
            int s=C.get(Calendar.SECOND);
         // presentation
            String Jour=""+jour,H=""+h,M=""+m,S=""+s;
            if(jour<10)
                Jour="0"+jour;
            if(h<10)
                H="0"+h;
            if(m<10)
                M="0"+m;
            if(s<10)
                S="0"+s;
             
            String txtdate="   "+Today(day)+" "+Jour+" "+Months(month)+" "+year;
               jdate.setText(txtdate);
            String txthour="         "+H+" : "+M+" : "+S;
               jhour.setText(txthour); 
           }
           catch(NumberFormatException | InterruptedException   e){}
 
        } 
    }
       
           }.start();
      
        

    
    }
     ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(e.getSource() instanceof JButton)
            {
                 (Accueil.this).setVisible(false);
                        new Alarms().setVisible(true);
                        
                
            }
        }
    }; 
    
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
public String Today(int n)
{
    switch(n)
    {
        case 1: 
             return "Dimanche";
        case 2:
             return "Lundi";
        case 3:
             return "Mardi";
        case 4:
             return "Mercredi";
        case 5:
             return "Jeudi";
        case 6:
             return "Vendredi";
        case 7:
             return "Samedi";
        default:
              return "Unknown";
    }
}
public String Months(int n)
{
    switch(n)
    {
        case 0: 
             return "Janvier";
        case 1:
             return "Février";
        case 2:
             return "Mars";
        case 3:
             return "Avril";
        case 4:
             return "Mai";
        case 5:
             return "Juin";
        case 6:
             return "Juillet";
        case 7: 
             return "Août";
        case 8:
             return "Septembre";
        case 9:
             return "Octobre";
        case 10:
             return "Novembre";
        default:
              return "Décembre";
    }
    
 }
public MouseAdapter facebookListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                
                try {
                    Desktop.getDesktop().browse(URI.create("www.facebook.com"));
                } catch (IOException ex) {}
            }
        };
    }
public MouseAdapter youtubeListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                
                try {
                    Desktop.getDesktop().browse(URI.create("www.youtube.com"));
                } catch (IOException ex) {}
            }
        };
    }
public MouseAdapter instagramListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                
                try {
                    Desktop.getDesktop().browse(URI.create("www.instagram.com"));
                } catch (IOException ex) {}
            }
        };
    }
public MouseAdapter twitterListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                
                try {
                    Desktop.getDesktop().browse(URI.create("www.twitter.com"));
                } catch (IOException ex) {}
            }
        };
    }

        


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(430, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );

        pack();
    }


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accueil().setVisible(true);
            }
        });
    }
}
