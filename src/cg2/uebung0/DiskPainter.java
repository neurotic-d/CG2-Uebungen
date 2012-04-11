package cg2.uebung0;

import cg1uebung3.ColumnVector;
import cg2.vecmath.Color;
import cg2.warmup.ImageGenerator;
import cg2.warmup.Painter;
import de.bht.fb6.cg1.math.IColumnVector;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implementation of the Painter interface for painting a 90% wide disk in red on a grey 
 * background.
 * 
 * @author Marius Hentschel - marius.hentschel@web.de
 * @since  29.03.2012
 */
public class DiskPainter implements Painter {
   //////////////////////////////// Attributes ////////////////////////////////
   private static final Color FRONT_COLOR = new Color( 1.0f, 0.0f, 0.0f ); //red
   private static final Color BACK_COLOR  = new Color( 0.5f, 0.5f, 0.5f ); //grey
   private static final float CIRCLE_PCT  = 0.9f; // circle size as percentage of picture height or width
   
   /////////////////////////////// Constructors ///////////////////////////////
   /**
    * Default constructor, initializes attributes with values.
    */
   public DiskPainter() {
   }

   ///////////////////////////// internal Methods /////////////////////////////
   /**
     * Tests, if a given coordinate (x, y) is inside a circle (center p, radius r).
    * 
     * @param p
     *    the circle's center
     * @param r
     *    the circle's radius
     * @param x
     *    the x value of the point to test
     * @param y
     *    the y value of the point to test
     * @return
     *    TRUE, if point is inside or on the outline of the circle, otherwise FALSE
     * @author 
     *    Marius Hentschel
     * @date 
     *    2012/02/07
     */
    private boolean isInCircle(IColumnVector<Float> p, float r, int x, int y) {
        float result =   ( ( x - p.get(0, 0) ) * ( x - p.get(0, 0) ) )
                       + ( ( y - p.get(1, 0) ) * ( y - p.get(1, 0) ) )
                       - ( r * r );
        return ( result <= 0 ) ? true : false;
    }
    
    /**
     * Returns the circle's center point as ColumnVector<Float>.
     * 
     * @param resX
     *    the picture's desired width
     * @param resY
     *    the pictures's desired height
     * @return 
     *    a column vector representing the center point of the image
     */
    private IColumnVector<Float> getCircleCenter( int resX, int resY ) {
       return new ColumnVector<Float>( 
                new ArrayList<Float>( 
                        Arrays.asList( 
                               new Float( resX/2.0f ), new Float( resY/2.0f )
        )       )       );
    }
    
    /**
     * returns the circle's radius, which is the length of the smallest side of the picture, 
     * multiplied with the percentage set for the circle and divided by 2.
     * 
     * @param resX
     *    the picture's width
     * @param resY
     *    the picture's heigth
     * @return 
     *    a float representing the radius as defined above
     */
    private float getCircleRadius( int resX, int resY ) {
       if( resX < resY ) {
          return resX * CIRCLE_PCT / 2;
       } else {
          return resY * CIRCLE_PCT / 2;
       }
    }
    
   /////////////////////////////// public Methods /////////////////////////////
   public static void main( String[] args ) {
      // get the user's home directory - should work on all operating systems
		String path = System.getProperty("user.home");
		  
		{
		   String filename = path + "/Documents/Beuth/cg2uebung0/" + "disk.png";
         new ImageGenerator(new DiskPainter(), 750, 750, filename, "png");
         ImageGenerator.showImage(filename);
      } 
   }
   
   ///////////////////////////// overridden Methods ///////////////////////////
   @Override
   public Color pixelColorAt(int x, int y, int resolutionX, int resolutionY) {
      // get circle center and size for the specified resolution
      IColumnVector<Float> center = getCircleCenter( resolutionX, resolutionY );
      float radius = getCircleRadius( resolutionX, resolutionY );
      
      // test, if the specified pixel is in the circle and return either FRONT or BACK COLOR
      return( isInCircle( center, radius, x, y) ? FRONT_COLOR : BACK_COLOR );
   }
   
   @Override
   public boolean equals(final Object o) {
      boolean retVal = false;
      if (this.getClass().isInstance(o)) {
         DiskPainter obj = (DiskPainter) o;
         //TODO: Check if attributes have the same value
         throw new UnsupportedOperationException("Not supported yet.");
      }
      return retVal;
   }
   
   @Override
   public String toString() {
      return "[ cg2.uebung0.DiskPainter: \n"
              + "  - "
              + "]";
   }
}
