/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Tarik
 */
public class DynamicHM {
    private int h,m;

    public DynamicHM(int h, int m) {
        this.h = h;
        this.m = m;
    }
    public void AdjustTime(int addedTime)
    {
  
        if(m+addedTime>59)
        {
            h++;
            m=m+addedTime-60;
            return;
        }
      m=m+addedTime;        
        
    }
    

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }
    
    
    
}
