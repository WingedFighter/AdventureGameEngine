/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame;

/**
 *
 * @author t0ta1p0wn3r
 */

import java.io.*;
import java.util.Scanner;
import adventuregame.Scenery.*;

public class SaveLoader {
    
    private String loc;
    private File file;
    private Scanner fileReader;
    private int index;
    private int length;
    private int width;
    private int height;
    
    
    public SaveLoader(){
        width = 10;
        height = 10;
        loc = "resources/default.txt";
        try{
            file = new File(loc);
            fileReader = new Scanner(file);
            index = fileReader.nextInt();
            length = fileReader.nextInt();
            fileReader.nextLine();
        }catch(Exception e){
            e.printStackTrace();;
        }
    }
    
    public SaveLoader(int w, int h, String l){
        loc = l;
        width = w;
        height = h;
        try{
            file = new File(loc);
            fileReader = new Scanner(file);
            index = fileReader.nextInt();
            length = fileReader.nextInt();
            fileReader.nextLine();
        }catch(Exception e){
            e.printStackTrace();;
        }
    }
    
    public Block[][] getSave(){
        Block[][] save = new Block[index][length];
        for(int i=0; i<save.length; i++){
            for(int j=0; j<save[i].length; j++){
                save[i][j] = getBlock(fileReader.nextInt(), i, j);
            }
            fileReader.nextLine();
        }
        return save;
    }
    
    public Block getBlock(int ind, int i, int j){
        Block b = null;
        switch(ind){
            case 0: b = new Block(i*width, j*height, width, height); break;
            case 1: b = new Tree(i*width, j*height, width, height); break;
            case 2: b = new Mystery(i*width, j*height, width, height); break;
            case 3: b = new Up(i*width, j*height, width, height); break;
            case 4: b = new Down(i*width, j*height, width, height); break;
            default: b = new Block(i*width, j*height, width, height); break;
        }
        return b;
    }
}
