/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newimg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author sadeed
 */
public class TrafficJn {
 public TrafficRoad[] rd={new TrafficRoad(0,"a"),new TrafficRoad(0,"a"),new TrafficRoad(0,"b"),new TrafficRoad(0,"d")};
 int limit;
 public TrafficJn()
 { 
 limit=4;
 }
 public TrafficRoad HeavyTraffic()
 {
     int i;
     TrafficRoad heavy=rd[0];
     for(i=0;i<limit;i++)
     {
        if(heavy.traffic<rd[i].traffic)
            heavy=rd[i];
     }
     return heavy;
 }
 
 
private static final String FILENAME = "out.txt";

	public void myWrite(){

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = "";
                    int j;
                        for(j=0;j<limit;j++)
                        {
                             content  = content.concat("\n Traffic  Road "+rd[j].R_id+"->"+rd[j].traffic);
                            if(rd[j].iscongestion()) content =content.concat("~Congestion @ "+rd[j].R_id);
                        }

			fw = new FileWriter(FILENAME,false);
			bw = new BufferedWriter(fw);
			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}
  
}
