/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adventuregame.Scenery;

/**
 *
 * @author t0ta1p0wn3r
 */

        
public class Tree extends Block{
    
    public Tree(){
        super("resources/Tree.png");
    }
    
    public Tree(int x, int y, int w, int h){
        super(x, y, w, h, "resources/Tree.png");
    }
    
}
