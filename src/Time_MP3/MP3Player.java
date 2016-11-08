/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Time_MP3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Tarik
 */
public class MP3Player {
    
    FileInputStream FIS;
    BufferedInputStream BIS;
    private long pauselocation;
    private long songlength;
    String Path;
    public Player player;
    
    public void Stop()
    {
        if(player != null)
        {
            player.close();
            pauselocation=0;
             songlength=0;
        }
    }
//     public void Pause()
//    {
//        if(player != null)
//        {
//            try {
//                pauselocation=FIS.available();
//                 player.close();
//            } catch (IOException ex) {}
//           
//        }
//    }
    
//   public void Resume(String path)
//    {
//        try {
//            FIS=new FileInputStream(path);
//            BIS=new BufferedInputStream(FIS);
//                player=new Player(BIS);try {
//                FIS.skip(songlength-pauselocation);
//                } catch (IOException ex) {}
//                
//           
//        }
//            catch ( FileNotFoundException | JavaLayerException  ex) { }
//           
//        new Thread()
//        {
//            public void run()
//            {
//                try {
//                    player.play();
//                    } 
//                catch (JavaLayerException ex) {}
//            }
//            
//        }.start();
//        
//    }
    
    public void Play(String path)
    {
        try {
            
            FIS=new FileInputStream(path);
            BIS=new BufferedInputStream(FIS);
                player=new Player(BIS);
               
            
            }
            catch ( FileNotFoundException | JavaLayerException  ex) { }
           
        new Thread()
        {
            public void run()
            {
                try {
                    player.play();
                    } 
                catch (JavaLayerException ex) {}
            }
            
        }.start();
        
    }
}
