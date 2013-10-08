/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame;

/**
 *
 * @author t0ta1p0wn3r
 */

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.File;
import static java.lang.Character.*;

public class MainScreen extends Canvas implements Runnable, KeyListener {
    
    private boolean[] keys;
    private BufferedImage back;
    private int width;
    private int height;
    private int pos;
    private boolean state;
    private BufferedImage n, c, sN, sC;
    
    public MainScreen(int w, int h){
        state = false;
        keys = new boolean[3];
        width = w;
        height = h;
        pos = 0;
        
        try{
            n = ImageIO.read(new File("resources/NewGame.jpg"));
            c = ImageIO.read(new File("resources/Continue.jpg"));
            sN = ImageIO.read(new File("resources/SelectedNewGame.jpg"));
            sC = ImageIO.read(new File("resources/SelectedContinue.jpg"));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        new Thread(this).start();
        addKeyListener(this);
    }
    
    @Override
    public void update(Graphics window) {
        paint(window);
    }
    
    @Override
    public void paint(Graphics window) {
        
        Graphics2D twoD = (Graphics2D) window;
        
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }
        
        Graphics backGraphic = back.createGraphics();
        
        backGraphic.setColor(Color.BLACK);
        backGraphic.fillRect(0, 0, width, height);
        
        if(pos == 0){
            backGraphic.drawImage(sN, 260, 190, 120, 40, null);
            backGraphic.drawImage(c, 260, 310, 120, 40, null);
        }else{
            backGraphic.drawImage(n, 260, 190, 120, 40, null);
            backGraphic.drawImage(sC, 260, 310, 120, 40, null);
        }
        
        if(keys[0] && pos != 0){
            pos = 0;
        }
        
        if(keys[1] && pos == 0){
            pos = 1;
        }
        
        if(keys[2]){
            state = true;
        }
        
        twoD.drawImage(back, null, 0, 0);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch(toUpperCase(e.getKeyChar())){
            case 'W': keys[0] = true; break;
            case 'S': keys[1] = true; break;
            case 'O': keys[2] = true; break;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        switch(toUpperCase(e.getKeyChar())){
            case 'W': keys[0] = false; break;
            case 'S': keys[1] = false; break;
            case 'O': keys[2] = false; break;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(8);
                repaint();
            }
        } catch (Exception e) {
            
        }
    }
    
    public boolean getState(){
        return state;
    }
    
    public int type(){
        return pos;
    }
}
