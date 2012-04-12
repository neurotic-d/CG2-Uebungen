package camera;

import raytracer.Ray;
import vecmath.Vector;

/**
 * Die Kameraklasse für den Raytracer.
 * 
 * @author Bruno Kirschner
 */
public class Camera implements ICamera{
    
    // Blickrichtung
    private Vector viewDirection;
    
    // Vektor für oben
    private Vector upVector;
    
    // Kameraposition
    private Vector cameraPosition;
    
    // Öfnungswinkel der Kamera
    private float openingAngel;
    
    public Camera(final Vector position, final Vector view, final Vector up, final float angel){
        this.cameraPosition = position;
        this.viewDirection = view;
        this.upVector = up;
        this.openingAngel = angel;
    }
    
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

    
    /**
     * 
     * @param x
     * @param y
     * @param resolutionX
     * @param resolutionY
     * @return 
     */
    @Override
    public Ray generateRay(int x, int y, int resolutionX, int resolutionY) {
        /**
         *      b
            ---------|
            \       n|
             \       |
              \      |
             c \     |a
                \    |
                 \   |
                  \ x|
                   \ |
                    \|


            bekannt Seite b, Winkel x, Winkel n
            gesucht a

            tan(x) = b / a 

            a = b / tan(x)
         * 
         * 
         * resolutionX = Nx
         * resolutionY = Ny
         * 
         * Nx : Ny = w : h
         * w = Nx * h : Ny
         * w * Ny = Nx * h
         * w * Ny : Nx = h
         **/
        
        int w = 10;
        int h = (w * resolutionY) / resolutionX;
        
        float z = w / (2f * (float)Math.tan(this.openingAngel/2f)); 
        
        float posX = -w/2f + (x + 0.5f) * (1.0f*w/resolutionX);;
        float posY = -h/2f + (y + 0.5f) * (1.0f*h/resolutionY);
        Vector posPixel = new Vector(posX, posY, -z);
        
        Ray ray = new Ray(this.cameraPosition, posPixel.sub(this.cameraPosition).normalize());
        
        return ray;
    }
}
