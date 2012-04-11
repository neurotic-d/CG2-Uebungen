package cg2.uebung1;

import cg1uebung3.ColumnVector;
import de.bht.fb6.cg1.math.IColumnVector;
import de.bht.fb6.cg1.math.IMatrix;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Marius Hentschel - marius.hentschel@web.de
 * @since  06.04.2012
 */
public class Ray {
   //////////////////////////////// Attributes ////////////////////////////////
   private final IColumnVector<Float> origin;
   private final IColumnVector<Float> direction;
   /////////////////////////////// Constructors ///////////////////////////////
   /**
    * Default constructor, initializes attributes with values.
    */
   public Ray( IColumnVector<Float> origin, IColumnVector<Float> direction ) {
      this.origin = origin;
      this.direction = direction;
   }

   ///////////////////////////// internal Methods /////////////////////////////
   /////////////////////////////// public Methods /////////////////////////////   
   public IColumnVector<Float> getDirection() {
      return direction;
   }

   public IColumnVector<Float> getOrigin() {
      return origin;
   }   
   
   /**
    * returns the direction as a normalized vector (length = 1).
    * Works for n-dimensional vectors.
    * 
    * @return 
    *    the normalized direction
    */
   public IColumnVector<Float> getNormalizedDirection() {
      // normalize
      float length = 0;
      for( int i=0; i < this.direction.getRows(); i++ ) {
         length += ( this.direction.get(i, 0) * this.direction.get(i, 0) );
      }
      length = (float)Math.sqrt(length);
      
      // create new vector
      ArrayList<Float> newValues = new ArrayList<Float>();
      for( int i=0; i < this.direction.getRows(); i++ ) {
         newValues.add( 1 / length * this.direction.get(i, 0));
      }
      
      return new ColumnVector<Float>( newValues );
   }
   
   /**
    * returns the coordinates x(t) on the ray, for a given scalar t:
    * 
    * X(t) = x(origin) + t * x(direction)
    * 
    * @param t
    *    the scalar to multiply the direction with
    * @return 
    *    the 3D coordinate 
    */
   public IColumnVector<Float> getPoint( float t ) {
      IMatrix p = this.origin.add( this.getNormalizedDirection().mult( t ) );
      return new ColumnVector<Float>( new ArrayList( Arrays.asList( p.get(0,0), p.get(1,0), p.get(2,0) )));
   }
   
   ///////////////////////////// overridden Methods ///////////////////////////
   @Override
   public boolean equals(final Object o) {
      boolean retVal = false;
      if (this.getClass().isInstance(o)) {
         Ray obj = (Ray) o;
         //TODO: Check if attributes have the same value
         throw new UnsupportedOperationException("Not supported yet.");
      }
      return retVal;
   }
   
   @Override
   public String toString() {
      return "[ cg2.uebung1.Ray: \n"
              + "  - "
              + "]";
   }
}
