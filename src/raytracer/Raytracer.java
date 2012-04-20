package raytracer;

import camera.ICamera;
import vecmath.Color;

/**
 *  der Raytracer
 */
public class Raytracer implements Painter{

    /**
     * #################################
     *            Attribute
     * #################################
     */
    
    /**
     * Die Kamera von der das Bild erzeugt werden soll.
     */
    private ICamera camera;
    
    /**
     * Die Szene, welche dargestellt werden soll.
     */
    private Scene scene;
    
    /**
     * #################################
     *          Konstruktoren
     * #################################
     */
    
    /**
     * Erzeugt einen Raytracer.
     * 
     * @param camera    Kamera des Raytracer
     * @param scene     Szene die dargestellt wird
     */
    public Raytracer(final ICamera camera, final Scene scene){
        this.camera = camera;
        this.scene = scene;
    }

    /**
     * #################################
     *      überschriebene Methoden
     * #################################
     */
    
    @Override
    public Color pixelColorAt(final int x, final int y, final int resolutionX, final int resolutionY) {
        
        Ray currentRay = this.camera.generateRay(x, y, resolutionX, resolutionY);
        
        Hit sceneHit = this.scene.getNearestIntersectionWith(currentRay);
        
        if(sceneHit != null && sceneHit.getFactorForHitPoint() > 0){
            return sceneHit.getShape().getMaterial().shade(scene, sceneHit);
        } else {
            return new Color(0f,0f,0f);
        }
        
    }   
}