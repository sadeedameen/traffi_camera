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
// Java Program to compare two images
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
 
class ImageComparision  implements Runnable
{
    double percentage=0;
    boolean loop=true;
    private Thread t;
    int cam;
    String Ipaddr;
    public ImageComparision(int camera,String Ip)
    {
        cam = camera;
       Ipaddr = Ip;
    }
    public void run() {
    
        BufferedImage imgA = null;
        BufferedImage imgB = null;
        while(loop){
        try
        {
            File fileA = new File("image"+cam+".jpg");
            imgA = ImageIO.read(fileA);
            BufferedImage image = null;
            URL url = new URL("http://"+Ipaddr+":8080/photo.jpg");
            imgB = ImageIO.read(url);
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        int width1 = imgA.getWidth();
        int width2 = imgB.getWidth();
        int height1 = imgA.getHeight();
        int height2 = imgB.getHeight();
 
        if ((width1 != width2) || (height1 != height2))
            System.out.println("Error: Images dimensions"+
                                             " mismatch");
        else
        {
            long difference = 0;
            for (int y = 0; y < height1; y++)
            {
                for (int x = 0; x < width1; x++)
                {
                    int rgbA = imgA.getRGB(x, y);
                    int rgbB = imgB.getRGB(x, y);
                    int redA = (rgbA >> 16) & 0xff;
                    int greenA = (rgbA >> 8) & 0xff;
                    int blueA = (rgbA) & 0xff;
                    int redB = (rgbB >> 16) & 0xff;
                    int greenB = (rgbB >> 8) & 0xff;
                    int blueB = (rgbB) & 0xff;
                    difference += Math.abs(redA - redB);
                    difference += Math.abs(greenA - greenB);
                    difference += Math.abs(blueA - blueB);
                }
            }
 
            // Total number of red pixels = width * height
            // Total number of blue pixels = width * height
            // Total number of green pixels = width * height
            // So total number of pixels = width * height * 3
            double total_pixels = width1 * height1 * 3;
 
            // Normalizing the value of different pixels
            // for accuracy(average pixels per color
            // component)
            double avg_different_pixels = difference /
                                          total_pixels;
 
            // There are 255 values of pixels in total
            percentage = (avg_different_pixels /
                                            255) * 100;
 
            System.out.println("Difference Percentage-->" +
                                                percentage);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ImageComparision.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        }
        System.out.println("Stoped");
    }
    public void start () {
     // System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this);
         t.start ();
      }
   }
    public double traffic()
    {
        return percentage;
    }
    public void Stop(){
        loop=false;
    }

}
    
