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
import adventuregame.Scenery.Block;

public class SaveMaker {
    public SaveMaker(Block[][] map){
        try{
            FileWriter stream = new FileWriter("resources/default.txt");
            BufferedWriter out = new BufferedWriter(stream);
            out.write(" " + map.length + " " + map[1].length + "\n");
            for(int i=0; i<map.length; i++){
                for(int j=0; j<map[i].length; j++){
                    out.write(" " + getIndex(map[i][j]));
                }
                out.write("\n");
            }
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public int getIndex(Block b){
        System.out.println(b.getLoc());
        if(b.getLoc().equals("basic.png")){
            return 0;
        }else if(b.getLoc().equals("resources/Tree.jpg")) {
            return 1;
        }else if(b.getLoc().equals("resources/Mystery.jpg")){
            return 2;
        }else if(b.getLoc().equals("resources/Up.jpg")){
            return 3;
        }else if(b.getLoc().equals("resources/Down.jpg")){
            return 4;
        }else{
            return 0;
        }
    }
}
