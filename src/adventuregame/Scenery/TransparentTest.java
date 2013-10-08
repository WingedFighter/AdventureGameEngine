/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.Scenery;

/**
 *
 * @author t0ta1p0wn3r
 */
public class TransparentTest extends Block{
    
    public TransparentTest(){
        super("resources/TestTransparency.png");
    }
    
    public TransparentTest(int x, int y, int w, int h){
        super(x, y, w, h, "resources/TestTransparency.png");
    }
}
