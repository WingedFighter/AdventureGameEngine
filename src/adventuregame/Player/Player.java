/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.Player;

/**
 *
 * @author t0ta1p0wn3r
 */

import adventuregame.*;
import adventuregame.Scenery.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

public class Player implements Locatable, Collidable{
    
    private Color color = Color.BLUE;
    private String imgLoc;
    private Image img;
    
    private int xPos;
    private int yPos;
    
    private int width;
    private int height;
    private int imgW;
    private int imgH;
    
    public Player(){
        xPos = 0;
        yPos = 0;
        
        width = 10;
        height = 10;
        
        imgLoc = "basic.png";
        File file = new File(imgLoc);
        
        try{
            img = ImageIO.read(file);
        }catch(Exception e){
            
        }
        
        imgW = img.getWidth(null);
        imgH = img.getHeight(null);
    }
    
    public Player(String loc){
        xPos = 0;
        yPos = 0;
        
        width = 10;
        height = 10;
        
        imgLoc = loc;
        File file = new File(imgLoc);
        
        try{
            img = ImageIO.read(file);
        }catch(Exception e){
            
        }
        
        imgW = img.getWidth(null);
        imgH = img.getHeight(null);
    }
    
    public Player(int xp, int yp){
        xPos = xp;
        yPos = yp;
        
        width = 10;
        height = 10;
        
        imgLoc = "basic.png";
        File file = new File(imgLoc);
        
        try{
            img = ImageIO.read(file);
        }catch(Exception e){
            
        }
        
        imgW = img.getWidth(null);
        imgH = img.getHeight(null);
    }
    
    public Player(int xp, int yp, String loc){
        xPos = xp;
        yPos = yp;
        
        width = 10;
        height = 10;
        
        imgLoc = loc;
        File file = new File(imgLoc);
        
        try{
            img = ImageIO.read(file);
        }catch(Exception e){
            
        }
        
        imgW = img.getWidth(null);
        imgH = img.getHeight(null);
    }
    
    public Player(int xp, int yp, int w, int h){
        xPos = xp;
        yPos = yp;
        
        width = w;
        height = h;
        
        imgLoc = "basic.png";
        File file = new File(imgLoc);
        
        try{
            img = ImageIO.read(file);
        }catch(Exception e){
            
        }
        
        imgW = img.getWidth(null);
        imgH = img.getHeight(null);
    }
    
    public Player(int xp, int yp, int w, int h, String loc){
        xPos = xp;
        yPos = yp;
        
        width = w;
        height = h;
        
        imgLoc = loc;
        File file = new File(imgLoc);
        
        try{
            img = ImageIO.read(file);
        }catch(Exception e){
            
        }
        
        imgW = img.getWidth(null);
        imgH = img.getHeight(null);
    }
    
    public Player(int xp, int yp, int w, int h, Color c){
        xPos = xp;
        yPos = yp;
        
        width = w;
        height = h;
        
        imgLoc = "";
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
    public boolean didCollide(Object obj){
        Block block = (Block)obj;
        if(this.getX()<block.getX()+block.getWidth() && this.getX()>block.getX()){
            if(this.getY()>block.getY() && this.getY()<block.getY()+block.getHeight()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
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
