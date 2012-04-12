package camera;

import raytracer.Ray;
import vecmath.Vector;

/**
 * Interface für die Kameras des Raytracer
 * 
 * @author Bruno Kirschner <bruno.kirschner@online.de>
 */
public interface ICamera {
    /**
     * Gibt den Vektor für Richtung in die die Kamera schaut wieder.
     * 
     * @return die Kamera-Blickrichtung
     */
    public Vector getViewDirection();
   
    /**
     * Gibt den Vektor an der für die Kamera oben it.
     * 
     * @return der Vektor nach oben
     */
    public Vector getUpVector();
    
    /**
     * Gibt den Vektor für die Kameraposition wieder.
     * 
     * @return die Kameraposition
     */
    public Vector getCameraPosition();
    
    /**
     * Gibt den Öffnungswinkel wieder.
     * 
     * @return der Öffnungswinkel
     */
    public float getOpeningAngel();
    
    /**
     * Generiert einen Strahl
     * 
     * @param x
     * @param y
     * @param resolutionX
     * @param resolutionY
     * @return 
     */
    public Ray generateRay(final int x, final int y, final int resolutionX, final int resolutionY);
}
