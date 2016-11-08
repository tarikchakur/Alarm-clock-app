
import static java.lang.Math.abs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tarik
 */
public class NewClass {
    public static Integer MIN(Integer[] T)
{
    Integer min=15;
    for(int i=1;i<T.length;i++)
    {
        if(T[i] <= min && T[i]>0)
            min=T[i];
        
    }
    return min;
}
    public static void main(String[] args)
    {
        Integer[] days={-1,2,5,7,1};
        System.out.print(""+MIN(days));
       
    }
    
}
