/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.Scenery;

/**
 *
 * @author t0ta1p0wn3r
 */
public class Down extends Block{
    
    public Down(){
        super("resources/Down.png");
    }
    
    public Down(int x, int y, int w, int h){
        super(x, y, w, h, "resources/Down.png");
    }
}
