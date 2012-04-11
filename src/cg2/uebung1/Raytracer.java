package cg2.uebung1;

import cg2.uebung0.DiskPainter;
import cg2.uebung1.shapes.IShape;
import cg2.vecmath.Color;
import cg2.warmup.ImageGenerator;
import cg2.warmup.Painter;
import java.util.Iterator;

/**
 *
 * @author Marius Hentschel - marius.hentschel@web.de
 * @since  06.04.2012
 */
public class Raytracer implements Painter {
   //////////////////////////////// Attributes ////////////////////////////////
   private Scene scene;
   private Camera camera;
   
   private static final int IMAGE_WIDTH  = 800;
   private static final int IMAGE_HEIGHT = 600;
   
   /////////////////////////////// Constructors ///////////////////////////////
   /**
    * Default constructor, initializes attributes with values.
    */
   public Raytracer() {
      new Scene( );
      new Camera( );
   }

   ///////////////////////////// internal Methods /////////////////////////////
   /////////////////////////////// public Methods /////////////////////////////
   public static void main( String[] args ) {
      // get the user's home directory - should work on all operating systems
		String path = System.getProperty("user.home");
		  
		{
		   String filename = path + "/Documents/Beuth/cg2uebung1/" + "raytracerOutput.png";
         new ImageGenerator(new Raytracer(), IMAGE_WIDTH, IMAGE_HEIGHT, filename, "png");
         ImageGenerator.showImage(filename);
      } 
   }
   
   ///////////////////////////// overridden Methods ///////////////////////////
  @Override
   public Color pixelColorAt(int x, int y, int resolutionX, int resolutionY) {
      Color retVal = null;
      Ray ray = this.camera.generateRay(x, y, resolutionX, resolutionY);
      Iterator<IShape> si = this.scene.getShapeIterator();
      while( si.hasNext() ) {
         IShape current = si.next();
         Hit hit = current.intersect(ray);
         if( hit != null ) {
            
         } else {
            retVal = new Color( 0, 0, 0 );
         }
      }
      return retVal;
   }
      
}
