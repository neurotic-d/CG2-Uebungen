package cg2.uebung1;

import cg2.uebung1.shapes.IShape;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Marius Hentschel - marius.hentschel@web.de
 * @since  06.04.2012
 */
public class Scene {
   //////////////////////////////// Attributes ////////////////////////////////
   /**
    * List of objects in this scene
    */
   private ArrayList<IShape> shapes;
   
   /**
    * The minimum x value in world coordinate metric
    */
   private final float MIN_WIDTH;
   
   /**
    * The maximum x value in world coordinate metric
    */
   private final float MAX_WIDTH;
   
   /**
    * The minimum y value in world coordinate metric
    */
   private final float MIN_HEIGHT;
   
   /**
    * The maximum y value in world coordinate metric
    */
   private final float MAX_HEIGHT;
   /////////////////////////////// Constructors ///////////////////////////////
   /**
    * Default constructor, initializes an empty shape list and a world coordinate
    * system from -1 to 1.
    */
   public Scene() {
      this.MIN_WIDTH  = -1;
      this.MAX_WIDTH  =  1;
      this.MIN_HEIGHT = -1;
      this.MAX_HEIGHT =  1;
      
      this.shapes = new ArrayList<IShape>();
   }

   ///////////////////////////// internal Methods /////////////////////////////
   /////////////////////////////// public Methods /////////////////////////////
   /**
    * Adds a shape to the scene.
    * 
    * @param shape 
    *    the shape to add
    */
   public void addShape( IShape shape ) {
      this.shapes.add(shape);
   }
   
   /**
    * @return 
    *    the world space width
    */
   public float getWidth() {
      return MAX_WIDTH - MIN_WIDTH;
   }
   
   /**
    * @return 
    *    returns the world space height
    */
   public float getHeight() {
      return MAX_HEIGHT - MIN_HEIGHT;
   }
   
   /**
    * @return
    *    an iterator over the shapes in this scene
    */
   public Iterator<IShape> getShapeIterator() {
      return this.shapes.iterator();
   }
   ///////////////////////////// overridden Methods ///////////////////////////
   @Override
   public String toString() {
      String retVal = "[ cg2.uebung1.Scene: \n"
              + "  - world space from (" + this.MIN_WIDTH + "|" + this.MIN_HEIGHT + ") to (" + this.MAX_WIDTH + "|" + this.MAX_HEIGHT + ")\n"
              + "  - currently " + this.shapes.size() + " shapes: ";
      for( IShape shape : this.shapes ) {
         retVal = retVal.concat( "  - " + shape.toString() );
      }
      retVal = retVal.concat( "]" );
      return retVal;
   }
}
