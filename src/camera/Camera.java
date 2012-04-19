package camera;

import raytracer.Ray;
import vecmath.Vector;

/**
 * Kameraklasse für den Raytracer.
 */
public class Camera implements ICamera{
    
    /**
     * #################################
     *            Attribute
     * #################################
     */
    
    /**
     * Blickrichtung
     */
    private Vector viewDirection;
    
    /**
     * Vektor der Oben darstellt
     */
    private Vector upVector;
    
    /**
     * Kameraposition
     */
    private Vector cameraPosition;
    
    /**
     * Öffnungswinkel
     */
    private float openingAngel;
    
    /**
     * #################################
     *            Konstruktoren
     * #################################
     */
    
    /**
     * Konstruktor für die Kamera des Raytracer
     * 
     * @param position  die Kameraposition
     * 
     * @param view  die Kamera-Blickrichtung
     * 
     * @param up    die Richtung die für die Kamera obene darstellt
     * 
     * @param angel der Öffnungswinkel
     */
    public Camera(final Vector position, final Vector view, final Vector up, final float angel){
        this.cameraPosition = position;
        this.viewDirection = view;
        this.upVector = up;
        this.openingAngel = angel;
    }

    /**
     * #################################
     *     Überschriebene Methoden
     * #################################
     */
    
    @Override
    public Vector getViewDirection() {
        return this.viewDirection;
    }

    @Override
    public Vector getUpVector() {
        return this.upVector;
    }

    @Override
    public Vector getCameraPosition() {
        return this.cameraPosition;
    }

    @Override
    public float getOpeningAngel() {
        return this.openingAngel;
    }

    @Override
    public Ray generateRay(final int x, final int y, final int resolutionX, final int resolutionY) {
        
        /**
         *      b
         *   ---------|
         *   \       n|
         *    \       |
         *     \      |
         *    c \     |a
         *       \    |
         *        \   |
         *         \ x|
         *          \ |
         *           \|
         * 
         * 
         *  bekannt Seite b, Winkel x, Winkel n
         *  gesucht a
         * 
         *  tan(x) = b / a 
         * 
         *  a = b / tan(x)
         * 
         * 
         *  resolutionX = Nx
         *  resolutionY = Ny
         * 
         *  Nx : Ny = w : h
         *  w = Nx * h : Ny
         *  w * Ny = Nx * h
         *  w * Ny : Nx = h
         **/
        
        int w = 10;
        int h = (w * resolutionY) / resolutionX;
        
        float z = w / (2f * (float)Math.tan(this.openingAngel/2f)); 
        
        float posX = -w/2f + (x + 0.5f) * (1.0f*w/resolutionX);
        float posY = -h/2f + (y + 0.5f) * (1.0f*h/resolutionY);
        Vector posPixel = new Vector(posX, posY, -z);
        
        Ray ray = new Ray(this.cameraPosition, posPixel.sub(this.cameraPosition).normalize());
        
        return ray;
    }
}
