/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newimg;

/**
 *
 * @author sadeed
 */
public class TrafficRoad {
     double traffic;
     String R_id;
    public  TrafficRoad()
    {
        traffic=0;
    }
    public  TrafficRoad(double t)
    {
        traffic=t;
    }
     public  TrafficRoad(double t,String id)
     {
          traffic=t;
          R_id=id;
     }
     public double getTraffic()
     {
         return traffic;
     }
     public void setId(String id)
     {
         R_id=id;
     }
     public void setTraffic(double t)
     {
         traffic=t;
     }
     public boolean iscongestion()
     {
         if(traffic>75) 
             return true;
         else 
             return false;
     }
    
}

