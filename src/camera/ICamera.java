package camera;

import raytracer.Ray;
import vecmath.Vector;

/**
 * Schnittstelle für eine Kamera des Raytracer
 */
public interface ICamera {
    
    /**
     * #################################
     *        öffentliche Methoden
     * #################################
     */
    
    /**
     * Gibt die Blickrichtung der Kamera wieder.
     * 
     * @return die Blickrichtung
     */
    public Vector getViewDirection();
   
    /**
     * Gibt den Vektor wieder der für die Kamera oben darstellt.
     * 
     * @return der Vektor für Oben
     */
    public Vector getUpVector();
    
    /**
     * Gibt die Kameraposition wieder.
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
     * Generiert einen Strahl von der Kamera zum angegebenen Punkt auf der Bildebene
     * 
     * @param x der X-Wert des Punktes auf der Bildebene
     * @param y der Y-Wert des Punktes auf der Bildebene
     * @param resolutionX   die Breite der Bildebene
     * @param resolutionY   die Höhe der Bildebene
     * 
     * @return der generierte Strahl
     */
    public Ray generateRay(final int x, final int y, final int resolutionX, final int resolutionY);
}