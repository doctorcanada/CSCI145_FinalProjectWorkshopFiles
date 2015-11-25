import greenfoot.*;
import java.util.List; // Ex. 7.11

/**
 * A block that bounces back and forth across the screen.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Block extends Actor
{
    private int delta = 2;
    
    /**
     * Move across the screen, bounce off edges. Turn leaves, if we touch any.
     */
    public void act() 
    {
        move();
        checkEdge();
        checkMouseClick();
        checkLeaf();
    }
    
    /**
     * Move sideways, either left or right.
     */
    private void move()
    {
        setLocation(getX()+delta, getY());
    }
    
    /**
     * Check whether we are at the edge of the screen. If we are, turn around.
     */
    private void checkEdge()
    {
        if ( isAtEdge() ) 
        {
            delta = -delta;  // reverse direction
            
            // MyWorld world = (MyWorld)getWorld();
            // getWorld().addObject( new Leaf(), 100, 100 );
            // world.addObject( new Leaf(), getX(), getY() );
            
            /* 
             * Ex. 7.16: Turn all apple objects by 90 degrees 
             */
            MyWorld world = (MyWorld)getWorld(); // <-- make instance variable b/c of reuse?
            
            List<Apple> apples = world.getObjects( Apple.class );
            for ( Apple apple : apples )
            {
                apple.turn(90);
                
                /* optional "debug" statement to print out the current apple object */
                System.out.println( "Object " + apple + " has been rotated 90 degrees!" );
                
                // (and we'll do the same for any remaining apples in the List)
            } // end for-each 
            
            /*
             * Ex 7.18
             */
            List<Pear> pears = world.getObjects( Pear.class );
            for ( Pear pear : pears )
            {
                // pear.move(20); // we could incorporate some smoother animation as well
                  
                /*
                 * Modify the above for Ex. 7.19
                 */
                if ( pear.getX() >= (world.getWidth() - 20) ) // allow for 20 pixel threshold
                {
                    pear.setLocation( 0, pear.getY() ); // same Y, but move to left screen edge
                }
                else
                {
                    // pear.move(20); // as before
                    
                    // for smoother animation:
                    if ( !(pear.isMoving()) )
                    {
                        pear.setMoving( true );
                    } // end if
                } // end if-else
                
               
                /* optional "debug" statement to print out the current apple object */
                System.out.println( "Object " + pear + " has been moved!" );
                
                // (and we'll do the same for any remaining pears in the List)
            } // end for-each 
        }
    }
    
    /**
     * Check whether the mouse button was clicked. If it was, change all leaves.
     */
    private void checkMouseClick()
    {
        if (Greenfoot.mouseClicked(null)) 
        {
            // do this when the mouse is clicked. currently: nothing.
            
            /* optional debug statement to confirm mouse click */
            System.out.println( "\nMouse clicked at " + new java.util.Date() + "\n" );
            
            // for exercise 7.14 (this is somewhat different from the book)
            // store a reference to the current MyWorld object
            MyWorld world = (MyWorld)getWorld(); 
            
            // get all of the objects of the Leaf class (as a List of Leaf objects), and 
            // assign a reference to this List to the reference variable, leaves
            List<Leaf> leaves = world.getObjects( Leaf.class );
            
            // enhanced for loop, used to iterate through all objects
            // in the leaves List (so this is basically a "for each" loop)
            for ( Leaf leaf : leaves )
            {
                // "leaf" is the reference to the current Leaf object, 
                // so we will call the INSTANCE METHOD changeImage to 
                // "tell" the current Leaf object to change its image
                // leaf.changeImage();
                
                /*
                 * Ex 7.20 check position of leaf; only change image if in 
                 *   the left half of the world
                 */
                if ( leaf.getX() <= world.getWidth() / 2.0 )
                {
                    leaf.changeImage();
                }
                
                /* optional "debug" statement to print out the current leaf */
                System.out.println( "Image for object " + leaf + " has changed!" );
                
                // (and we'll do the same for any remaining leaves in the List)
            } // end for-each 
        } // <-- don't forget to label all curly braces
    }
    
    /**
     * Check to see if we are intersecting a leaf, and if we are, then 
     * we will turn 9 degrees
     */
    private void checkLeaf()
    {
        // Leaf leaf = getOneIntersectingObject( Leaf.class );
        Leaf leaf = (Leaf)getOneIntersectingObject( Leaf.class );
        if ( leaf != null )
        {
            leaf.turn(9);
        } // end if
    } // end method checkLeaf
}
