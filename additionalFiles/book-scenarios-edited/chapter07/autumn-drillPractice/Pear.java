import greenfoot.*;

/**
 * Write a description of class Pear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pear extends Actor
{
    private boolean moving;
    private int pixelsMoved;
    
    public Pear()
    {
        moving = false;
        pixelsMoved = 0;
    }
    
    /**
     * Act - do whatever the Pear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        /*
        if ( pixelsMoved >= 20 )
        {
            moving = false;
            pixelsMoved = 0;
        }
        */
        if ( moving )
        {
            move(1);
            pixelsMoved++;
            
            if ( pixelsMoved >= 20 )
            {
                setMoving( false );
            }
        }
    }    
    
    public boolean isMoving()
    {
        return moving;
    }
    
    public void setMoving( boolean moving )
    {
        this.moving = moving;
        if ( !moving )
        {
            pixelsMoved = 0;
        }
    }
    
    public void incrementPixelsMoved()
    {
        pixelsMoved++;
    }
    
    public int getPixelsMoved()
    {
        return pixelsMoved;
    }
}
