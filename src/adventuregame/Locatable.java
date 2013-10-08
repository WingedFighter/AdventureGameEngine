/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame;

/**
 *
 * @author t0ta1p0wn3r
 */
public interface Locatable {
    public void setPos( int x, int y);
    public void setX( int x );
    public void setY( int y );

    public int getX();
    public int getY();
}
