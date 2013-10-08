/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author t0ta1p0wn3r
 */
package adventuregame;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.Random;
import adventuregame.Player.*;
import adventuregame.Scenery.*;
import static java.lang.Character.*;

public class Game extends Canvas implements Runnable, KeyListener {
    
    private Block[][] map;
    private int[][] playerLoc;
    private int[] pos;
    private boolean[] keys;
    private BufferedImage back;
    private Player player;
    private Random generator;
    private Background backGr;
    private boolean exit;
    private boolean fightState;
    private int dir;
    
    private final int BLOCK_WIDTH = 40;
    private final int BLOCK_HEIGHT = 40;
    
    public Game(int w, int h, int s) {
        
        dir = 0;
        exit = false;
        fightState = false;
        backGr = new Background(640, 500, "resources/Background.png");
        generator = new Random();
        
        if(s == 0){
            map = new Block[16][12];
            playerLoc = new int[16][12];
            pos = new int[2];
        
            for(int i=0; i<map.length; i++){
                for(int j=0; j<map[i].length; j++){
                    int k = generator.nextInt(100);
                    if(k<60){
                        map[i][j] = new Block(i*BLOCK_WIDTH, j*BLOCK_HEIGHT, 
                                BLOCK_WIDTH, BLOCK_HEIGHT);
                    }else if(k<90){
                        map[i][j] = new Tree(i*BLOCK_WIDTH, j*BLOCK_HEIGHT, 
                                BLOCK_WIDTH, BLOCK_HEIGHT);
                    }else if(k<99){
                        map[i][j] = new Mystery(i*BLOCK_WIDTH, j*BLOCK_HEIGHT, 
                                BLOCK_WIDTH, BLOCK_HEIGHT);
                    }else if(k<100){
                        map[i][j] = new Up(i*BLOCK_WIDTH, j*BLOCK_HEIGHT, 
                                BLOCK_WIDTH, BLOCK_HEIGHT);
                    }else{
                        map[i][j] = new Down(i*BLOCK_WIDTH, j*BLOCK_HEIGHT, 
                                BLOCK_WIDTH, BLOCK_HEIGHT);
                    }
                }
            }
        }else{
            SaveLoader save = new SaveLoader(BLOCK_WIDTH, BLOCK_HEIGHT,
                    "resources/default.txt");
            map = save.getSave();
            playerLoc = new int[16][12];
            pos = new int[2];
        }
        pos[0]=8;
        pos[1]=8;
        
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j].getLoc().equals("resources/Up.png")){
                    exit = true;
                }
            }
        }
        
        Random rand = new Random();
        if(!exit){
            int i = rand.nextInt(16);
            int j = rand.nextInt(12);
            map[i][j] = new Up(i * BLOCK_WIDTH, j*BLOCK_HEIGHT, 
                                BLOCK_WIDTH, BLOCK_HEIGHT);
        }
        
        player = new Player(pos[0]*BLOCK_WIDTH, pos[1]*BLOCK_HEIGHT, BLOCK_WIDTH,
                BLOCK_HEIGHT, Color.BLUE);
        
        keys = new boolean[6];
        
        setBackground(Color.WHITE);
        setVisible(true);
        
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
        
        if(fightState){
            fightWorld(backGraphic);
        }else{
            outWorld(backGraphic);
        }
        
        twoD.drawImage(back, null, 0, 0);
        
        if(map[pos[0]][pos[1]].getLoc().equals("resources/Up.png")){
            regenerate();
        }else if(map[pos[0]][pos[1]].getLoc().equals("resources/Mystery.png")){
            fightState = true;
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch(toUpperCase(e.getKeyChar())){
            case 'W': keys[0] = true; break;
            case 'A': keys[1] = true; break;
            case 'S': keys[2] = true; break;
            case 'D': keys[3] = true; break;
            case 'P': keys[4] = true; break;
            case 'E': keys[5] = true; break;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        switch(toUpperCase(e.getKeyChar())){
            case 'W': keys[0] = false; break;
            case 'A': keys[1] = false; break;
            case 'S': keys[2] = false; break;
            case 'D': keys[3] = false; break;
            case 'P': keys[4] = false; break;
            case 'E': keys[5] = false; break;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    public void regenerate(){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                int k = generator.nextInt(100);
                if(k<60){
                    map[i][j] = new Block(i*BLOCK_WIDTH, j*BLOCK_HEIGHT, 
                                BLOCK_WIDTH, BLOCK_HEIGHT);
                }else if(k<90){
                    map[i][j] = new Tree(i*BLOCK_WIDTH, j*BLOCK_HEIGHT, 
                                BLOCK_WIDTH, BLOCK_HEIGHT);
                }else if(k<99){
                    map[i][j] = new Mystery(i*BLOCK_WIDTH, j*BLOCK_HEIGHT, 
                                BLOCK_WIDTH, BLOCK_HEIGHT);
                }else if(k<100){
                    map[i][j] = new Up(i*BLOCK_WIDTH, j*BLOCK_HEIGHT, 
                                BLOCK_WIDTH, BLOCK_HEIGHT);
                }else{
                    map[i][j] = new Down(i*BLOCK_WIDTH, j*BLOCK_HEIGHT, 
                                BLOCK_WIDTH, BLOCK_HEIGHT);
                }
            }
        }
        
        exit = false;
        
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j].getLoc().equals("resources/Up.png")){
                    exit = true;
                }
            }
        }
        
        Random rand = new Random();
        if(!exit){
            int i = rand.nextInt(16);
            int j = rand.nextInt(12);
            map[i][j] = new Up(i * BLOCK_WIDTH, j*BLOCK_HEIGHT, 
                                BLOCK_WIDTH, BLOCK_HEIGHT);
        }
    }
    
    public void fightWorld(Graphics backGraphic){
        backGr.draw(backGraphic);
        new TransparentTest(300, 250, 40, 40).draw(backGraphic);
    }
    
    public void outWorld(Graphics backGraphic){
        
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                map[i][j].draw(backGraphic);
            }
        }
        
        if(keys[0] && pos[1] >0){
            if(!player.didCollide(map[pos[0]][pos[1]-1]) 
                    && !map[pos[0]][pos[1]-1].getLoc().equals("resources/Tree.png")){
                pos[1]--;
                keys[0] = false;   
            }
            dir = 0;
        }
        
        if(keys[1] && pos[0] > 0){
            if(!player.didCollide(map[pos[0]-1][pos[1]]) 
                    && !map[pos[0]-1][pos[1]].getLoc().equals("resources/Tree.png")){
                pos[0]--;
                keys[1] = false;
            }
            dir = 1;
        }
        
        if(keys[2] && pos[1] < map[1].length-1){
            if(!player.didCollide(map[pos[0]][pos[1]+1]) 
                    && !map[pos[0]][pos[1]+1].getLoc().equals("resources/Tree.png")){
                pos[1]++;
                keys[2] = false;
            }
            dir = 2;
        }
        
        if(keys[3] && pos[0] < map.length-1){
            if(!player.didCollide(map[pos[0]+1][pos[1]]) 
                    && !map[pos[0]+1][pos[1]].getLoc().equals("resources/Tree.png")){
                pos[0]++;
                keys[3] = false;
            }
            dir = 3;
        }
        
        if(keys[4]){
            SaveMaker save = new SaveMaker(map);
            keys[4] = false;
        }
        
        if(keys[5]){
            switch(dir){
                case 0: map[pos[0]][pos[1]-1] = new Block(pos[0] * BLOCK_WIDTH, 
                        (pos[1]-1) * BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
                    break;
                case 1: map[pos[0]-1][pos[1]] = new Block((pos[0]-1) * BLOCK_WIDTH, 
                        (pos[1]) * BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
                    break;
                case 2: map[pos[0]][pos[1]+1] = new Block((pos[0]) * BLOCK_WIDTH, 
                        (pos[1]+1) * BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
                    break;
                case 3: map[pos[0]+1][pos[1]] = new Block((pos[0]+1) * BLOCK_WIDTH, 
                        (pos[1]) * BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
                    break;
                default: break;
            }
            keys[5] = false;
        }
        
        player.setX(pos[0] * BLOCK_WIDTH);
        player.setY(pos[1] * BLOCK_HEIGHT);
        
        player.draw(backGraphic);
        
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
}
