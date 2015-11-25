import greenfoot.*;

/**
 * Autumn. A world with some leaves.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class MyWorld extends World
{
    /**
     * Create the world and objects in it.
     */
    public MyWorld()
    {    
        super(600, 400, 1);
        setUp();
    }
    
    /**
     * Create the initial objects in the world.
     */
    private void setUp()
    {
        addObject(new Block(), 300, 200);
        
        /*
         * Place 18 leaves in the world at random locations
         */
        int counter = 0;
        while ( counter < 18 )
        {
            int x = Greenfoot.getRandomNumber( getWidth() );
            int y = Greenfoot.getRandomNumber( getHeight() );
            addObject( new Leaf(), x, y );
            counter++;
        } // end while
        
        /*
         * Exercise 7.15: Place 12 apples at random locations
         */
        counter = 0; // note that counter needs to be reset to zero
        while ( counter < 12 )
        {
            // remember that the x and y variables above only existed within the 
            // scope of the above while loop, so they will need to be declared again
            int x = Greenfoot.getRandomNumber( getWidth() );
            int y = Greenfoot.getRandomNumber( getHeight() );
            addObject( new Apple(), x, y );
            counter++;
        } // end while
        
        /*
         * Exercise 7.17: Place 8 pears in the world 
         * (this time, let's use a for loop, which is usually the appropriate
         *  choice of a loop to use when you know exactly how many times
         *  the loop needs to iterate)
         *  
         *  Note that we can't re-declare counter, since it already exists 
         *  outside the scope of the for loop, but we still need to reset it to zero... 
         */
        for ( counter = 0; counter < 8; counter++ ) // or just use a different counter
        {
            int x = Greenfoot.getRandomNumber( getWidth() );
            int y = Greenfoot.getRandomNumber( getHeight() );
            addObject( new Pear(), x, y );
        } // end for 
        
    } // end method setUp
} // end class MyWorld
