package raytracer;

import camera.ICamera;
import vecmath.Color;

/**
 *  Raytracer
 *  @author Bruno Kirschner
 */
public class Raytracer implements Painter{

    private ICamera camera;
    private Scene scene;
    
    public Raytracer(final ICamera camera, final Scene scene){
        this.camera = camera;
        this.scene = scene;
    }
            
    @Override
    public Color pixelColorAt(int x, int y, int resolutionX, int resolutionY) {
        
        Ray currentRay = this.camera.generateRay(x, y, resolutionX, resolutionY);
        
        Hit sceneHit = this.scene.getNearestIntersectionWith(currentRay);
        
        if(sceneHit != null && sceneHit.getFactorForHitPoint() > 0){
            return sceneHit.getShape().getMaterial().getColor();
        } else {
            return new Color(0f,0f,0f);
        }
        
    }   
}