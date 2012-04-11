package cg2.uebung1;

import cg2.uebung1.shapes.IShape;
import de.bht.fb6.cg1.math.IColumnVector;

/**
 *
 * @author Marius Hentschel - marius.hentschel@web.de
 * @since  06.04.2012
 */
public class Hit {
   //////////////////////////////// Attributes ////////////////////////////////
   /**
    * the ray
    */
   private Ray ray;
   
   /**
    * the shape, hit by the ray
    */
   private IShape shape;
   
   /**
    * the intersection, where the ray hits the shape
    */
   private IColumnVector<Float> intersection;
   /////////////////////////////// Constructors ///////////////////////////////
   /**
    * Default constructor, initializes attributes with values.
    */
   public Hit( Ray ray, IShape shape, IColumnVector<Float> intersection ) {
      this.ray = ray;
      this.shape = shape;
      this.intersection = intersection;
   }

   ///////////////////////////// internal Methods /////////////////////////////
   /////////////////////////////// public Methods /////////////////////////////
   public IColumnVector<Float> getIntersection() {
      return intersection;
   }

   public Ray getRay() {
      return ray;
   }

   public IShape getShape() {
      return shape;
   }
   ///////////////////////////// overridden Methods ///////////////////////////
   @Override
   public boolean equals(final Object o) {
      boolean retVal = false;
      if (this.getClass().isInstance(o)) {
         Hit obj = (Hit) o;
         //TODO: Check if attributes have the same value
         throw new UnsupportedOperationException("Not supported yet.");
      }
      return retVal;
   }
   
   @Override
   public String toString() {
      return "[ cg2.uebung1.Hit: \n"
              + "  - "
              + "]";
   }
}
