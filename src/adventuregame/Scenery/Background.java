/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.Scenery;

/**
 *
 * @author t0ta1p0wn3r
 */

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Background {
    
    private Color color = new Color(4, 254, 43);
    private String imgLoc;
    private BufferedImage img;
    
    private int width;
    private int height;
    
    public Background(){
        width = 640;
        height = 500;
        
        
        /*imgLoc = "resources/background.png";
        File file = new File(imgLoc);
       
        try{
            img = ImageIO.read(file);
        }catch(Exception e){
            
        }*/
    }
    
    public Background(int w, int h, String loc){
        width = w;
        height = h;
        
        imgLoc = loc;
        File file = new File(loc);
        
        try{
            img = ImageIO.read(file);
        }catch(Exception e){
            
        }
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public String getLoc(){
        return imgLoc;
    }
    
    public Color getColor(){
        return color;
    }
    
    public void draw(Graphics window){
        if(img==null){
            window.setColor(color);
            window.fillRect(0, 0, getWidth(), getHeight());
        }else{
            window.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        }
    }
    
}
