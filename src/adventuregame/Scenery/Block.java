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
import adventuregame.*;
import javax.imageio.ImageIO;

        
public class Block implements Locatable{
    
    private Color color = new Color(4, 254, 43);
    private String imgLoc;
    private BufferedImage img;
    
    private int xPos;
    private int yPos;
    
    private int width;
    private int height;
    private int imgW;
    private int imgH;
    
    public Block(){
        xPos = 0;
        yPos = 0;
        
        width = 10;
        height = 10;
        
        imgLoc = "basic.png";
        File file = new File(imgLoc);
        
        try{
            img = ImageIO.read(file);
            imgW = img.getWidth(null);
            imgH = img.getHeight(null);
        }catch(Exception e){
            
        }
    }
    
    public Block(String loc){
        xPos = 0;
        yPos = 0;
        
        width = 10;
        height = 10;
        
        imgLoc = loc;
        File file = new File(imgLoc);
        
        try{
            img = ImageIO.read(file);
            imgW = img.getWidth(null);
            imgH = img.getHeight(null);
        }catch(Exception e){
            
        }
        
        color = Color.WHITE;
    }
    
    public Block(int xp, int yp){
        xPos = xp;
        yPos = yp;
        
        width = 10;
        height = 10;
        
        imgLoc = "basic.png";
        File file = new File(imgLoc);
        
        try{
            img = ImageIO.read(file);
            imgW = img.getWidth(null);
            imgH = img.getHeight(null);
        }catch(Exception e){
            
        }
    }
    
    public Block(int xp, int yp, String loc){
        xPos = xp;
        yPos = yp;
        
        width = 10;
        height = 10;
        
        imgLoc = loc;
        File file = new File(imgLoc);
        
        try{
            img = ImageIO.read(file);
            imgW = img.getWidth(null);
            imgH = img.getHeight(null);
        }catch(Exception e){
            
        }
        color = Color.WHITE;
    }
    
    public Block(int xp, int yp, int w, int h){
        xPos = xp;
        yPos = yp;
        
        width = w;
        height = h;
        
        imgLoc = "basic.png";
        File file = new File(imgLoc);
        
        try{
            img = ImageIO.read(file);
            imgW = img.getWidth(null);
            imgH = img.getHeight(null);
        }catch(Exception e){
            
        }
        
    }
    
    public Block(int xp, int yp, int w, int h, String loc){
        xPos = xp;
        yPos = yp;
        
        width = w;
        height = h;
        
        imgLoc = loc;
        
        try{
            img = ImageIO.read(new File(loc));
            imgW = img.getWidth(null);
            imgH = img.getHeight(null);
        }catch(Exception e){
            
        }
        color = Color.WHITE;
        
    }
    
    public Block(int xp, int yp, int w, int h, Color c){
        xPos = xp;
        yPos = yp;
        
        width = w;
        height = h;
        
        imgLoc = "basic.png";
        img = null;
        
        color = c;
    }
    
    public void draw(Graphics window){
        if(img==null){
            window.setColor(color);
            window.fillRect(getX(), getY(), getWidth(), getHeight());
        }else{
            window.drawImage(img, xPos, yPos, imgW, imgH, null);
        }
    }
    
    @Override
    public void setPos(int x, int y){
        xPos = x;
        yPos = y;
    }
    
    @Override
    public void setX(int x){
        xPos = x;
    }
    
    @Override
    public void setY(int y){
        yPos = y;
    }
    
    @Override
    public int getX(){
        return xPos;
    }
    
    @Override
    public int getY(){
        return yPos;
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
    
    @Override
    public String toString(){
        String output = "";
        output+=xPos + " ";
        output+=yPos + " ";
        output+=width + " ";
        output+=height + " ";
        output+=color + " ";
        output+=imgLoc + " ";
        return output;
    }
}
