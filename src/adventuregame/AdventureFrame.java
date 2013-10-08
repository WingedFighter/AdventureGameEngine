/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author t0ta1p0wn3r
 */
public class AdventureFrame extends JFrame {

    public static final int CANVAS_WIDTH = 640;
    public static final int CANVAS_HEIGHT = 500;
    public static final String TITLE = "Adventure Game";
    
    public AdventureFrame() {
        super(TITLE);
        this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boolean first = true;
        
        MainScreen screen = new MainScreen(CANVAS_WIDTH, CANVAS_HEIGHT);
        
        ((Component) screen).setFocusable(true);
        getContentPane().add(screen);
        
        setVisible(true);
        while(first){
            System.out.print("");
            if(screen.getState()){
                first = false;
            }
        }
        
        int state = screen.type();
        
        getContentPane().removeAll();
        
        Game game = new Game(CANVAS_WIDTH, CANVAS_HEIGHT, state);
        
        ((Component) game).setFocusable(true);
        getContentPane().add(game);
        
        setVisible(true);
    }
}
