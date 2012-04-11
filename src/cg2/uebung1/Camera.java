package cg2.uebung1;

import cg1uebung3.ColumnVector;
import de.bht.fb6.cg1.math.IColumnVector;
import java.lang.Float;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Marius Hentschel - marius.hentschel@web.de
 * @since  06.04.2012
 */
public class Camera {
   //////////////////////////////// Attributes ////////////////////////////////
   /**
    * The camera's position
    */
   private final IColumnVector<Float> position;
   
   /**
    * the camera's viewing direction
    */
   private final IColumnVector<Float> direction;
   
   /**
    * the camera's up vector
    */
   private final IColumnVector<Float> upVector;
   
   /**
    * the camera's aperture angle
    */
   private final float apertureAngle;
   
   /////////////////////////////// Constructors ///////////////////////////////
   /**
    * Default constructor, initializes a camera at (0|0|0) looking along the negative
    * Z-axis (0|0|-1) with the y-axis as up vector and an aperture angle of 90°
    */
   public Camera() {
      this.position  = new ColumnVector<Float>( new ArrayList( Arrays.asList( new Float( 0 ), new Float( 0 ), new Float( 0 ) ) ) );
      this.direction = new ColumnVector<Float>( new ArrayList( Arrays.asList( new Float( 0 ), new Float( 0 ), Float.NEGATIVE_INFINITY ) ) );
      this.upVector  = new ColumnVector<Float>( new ArrayList( Arrays.asList( new Float( 0 ), Float.POSITIVE_INFINITY, new Float( 0 ) ) ) );
      this.apertureAngle = 90.0f;
   }

   ///////////////////////////// internal Methods /////////////////////////////
   /////////////////////////////// public Methods /////////////////////////////
   /**
    * Creates a ray through the specified pixel (px,py) of a specified image size.
    * 
    * @param pX
    *    the pixel's x coordinate
    * @param pY
    *    the pixel's x coordinate
    * @param sizeX
    *    the horizontal image size 
    * @param sizeY
    *    the vertical image size
    * @return 
    *    the ray from the camera's origin through the given pixel with a normalized 
    *    direction vector.
    */
   Ray generateRay( int pX, int pY, int sizeX, int sizeY ) {
      
      // x(i) = -w/2 + (i+0,5)*w/Nx
      float x = 0;
      
      // x(i) = -h/2 + (j+0,5)*h/Ny
      float y = 0;
      
      // Screenplane is in distance - z-alpha = width/2*tan(alpha/2)
      float z = 0;
      IColumnVector<Float> rayDirection = new ColumnVector<Float>( new ArrayList<Float>( Arrays.asList( x, y, z )));
      return new Ray( this.position, rayDirection );
   }
   ///////////////////////////// overridden Methods ///////////////////////////
   @Override
   public String toString() {
      return "[ cg2.uebung1.Camera: \n"
              + "  -      position: " + this.position.toString() + "\n"
              + "  -     direction: " + this.direction.toString() + "\n"
              + "  -      upVector: " + this.upVector.toString() + "\n"
              + "  - apertureAngle: " + this.apertureAngle + "°\n"
              + "]";
   }
}
