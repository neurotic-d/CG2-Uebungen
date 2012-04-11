package shapes;

import java.util.ArrayList;
import material.Material;
import raytracer.Hit;
import raytracer.Ray;
import vecmath.Color;
import vecmath.Vector;

/**
 * Repräsentiert eine Axis Aligned Bounding Box
 * 
 * @author Bruno Kirschner
 */
public class AxisAlignedBox extends AbstractShape{

    // Der Punkt mit den kleinsten Werten auf allen 3 Achsen.
    private Vector pMin;
    
    // Der Punkt mit den größten Werten auf allen 3 Achsen.
    private Vector pMax;
    
    public AxisAlignedBox(final Vector min, final Vector max){
        this.pMin = min;
        this.pMax = max;
        
        super.setMaterial(new Material(new Color(0,0,0)));
    }

    /**
     * Gibt den Punkt wieder der die maximal Werte repräsentiert.
     * 
     * @return der geforderte Punkt
     */
    public Vector getpMax() {
        return pMax;
    }

    /**
     * Setzt einen neuen maximal Punkt für die Box.
     * 
     * @param pMax der neue Punkt
     */
    public void setpMax(Vector pMax) {
        this.pMax = pMax;
    }

    /**
     * Gibt den Punkt wieder der die minmalen Werte repräsentiert.
     * 
     * @return 
     */
    public Vector getpMin() {
        return pMin;
    }

    /**
     * Gibt den Punkt wieder der die minimal Werte repräsentiert.
     * 
     * @param pMin der geforderte Punkt
     */
    public void setpMin(Vector pMin) {
        this.pMin = pMin;
    }
    
    @Override
    public Hit getNearestIntersectionWith(Ray ray) {
        
        /**
         * ----------------------------------
         * --------TODO----------------------
         * 
         * Diese normalen Stimmen nur für die aktuell vorgegeben Kamera
         * Möglichkeit für allgemeinere Form finden.
         * 
         * ----------------------------------
         * ----------------------------------
         * 
         * 6 Seiten: Pi: ni * x - di = 0
         * 
         * Algorithmus (Woo):
         * finde die 3 Ebenen ,deren Normalen in die Richtung des Ursprungs
         * des Strahls, zeigen.
         * 
         * => Vorzeichen der Komponenten von ray.direction müssen umgedreht werden
         * => Vorne, Unten, Links == -
         * => Hinten, Oben, Rechts == +
         * 
         * Parallel zur X-Achse: Vorne/Hinten
         * Parallel zur Y-Achse: Links/Rechts
         * Parallel zur Z-Achse: Oben/Unten
         * 
         * Vorne: {0,0,-1} * x - {0,0,1}*x0 = 0
         * Hinten: {0,0,1} * x - {0,0,-1}*x0 = 0
         * Links: {-1,0,0} * x - {-1,0,0}*x0 = 0
         * Rechts: {1,0,0} * x - {1,0,0}*x0 = 0
         * Oben: {0,1,0} * x - {0,1,0}*x0 = 0
         * Unten: {0,-1,0} * x - {0,-1,0}*x0 = 0
         **/
        
        Hit shapeHit = null;
        
        Plane parallelX, parallelY, parallelZ;
        Vector rayDirection = ray.getNormalizedDirection();
        
        parallelX = rayDirection.z < 0 ? new Plane(this.pMin, new Vector(0,0,1)) : new Plane(this.pMax, new Vector(0,0,-1));
        parallelY = rayDirection.x > 0 ? new Plane(this.pMin, new Vector(-1,0,0)) : new Plane(this.pMax, new Vector(1,0,0));
        parallelZ = rayDirection.y > 0 ? new Plane(this.pMin, new Vector(0,-1,0)) : new Plane(this.pMax, new Vector(0,1,0));
        
        ArrayList<Hit> hits = new ArrayList<Hit>();
        
        hits.add(parallelX.getNearestIntersectionWith(ray));
        hits.add(parallelY.getNearestIntersectionWith(ray));
        hits.add(parallelZ.getNearestIntersectionWith(ray));
        
        for(Hit h: hits){
            Vector hitPoint = ray.getPointAt(h.getFactorForHitPoint());
            
            if(hitPoint.x >= this.pMin.x && hitPoint.y >= this.pMin.y && hitPoint.z <= this.pMin.z &&
               hitPoint.x <= this.pMax.x && hitPoint.y <= this.pMax.y && hitPoint.z >= this.pMax.z){
                
                if(shapeHit == null){
                    shapeHit = h;
                }
                else if(h.getFactorForHitPoint() < shapeHit.getFactorForHitPoint()){
                    shapeHit = h;
                }
            } 
        }
        
        if(shapeHit != null){
            shapeHit.setShape(this);
        }
        
        return shapeHit;
    }    
}
