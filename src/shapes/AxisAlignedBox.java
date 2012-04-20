package shapes;

import java.util.ArrayList;
import material.Material;
import raytracer.Hit;
import raytracer.Ray;
import vecmath.Vector;

/**
 * Repräsentiert eine an den Achsen ausgerichtete Box dar.
 */
public class AxisAlignedBox extends AbstractShape{

    /**
     * #################################
     *            Attribute
     * #################################
     */
    
    /**
     * Der kleinste Punkt der Box.
     */
    private Vector pMin;
    
    /**
     * Der größste Punkt der Box.
     */
    private Vector pMax;
    
    /**
     * Liste der Ebenen die die Box darstellt
     */
    ArrayList<Plane> sites;
    
    /**
     * #################################
     *           Konstruktoren
     * #################################
     */
    
    /**
     * Erzeugt eine schwarze Box.
     * 
     * @param min   Punkt mit den kleinsten Werten
     * 
     * @param max   Punkt mit den größsten Werten
     */
    public AxisAlignedBox(final Vector min, final Vector max){
        this.pMin = min;
        this.pMax = max;
        
        super.setMaterial(new Material());
       
        /**
         * 6 Seiten: P: n * x - d = 0
         * 
         * d = n*x0
         * 
         * Algorithmus (Woo):
         * finde die 3 Ebenen ,deren Normalen in die Richtung des Ursprungs
         * des Strahls, zeigen.
         * 
         * => Vorzeichen der Komponenten von ray.direction m�ssen umgedreht werden
         * => Vorzeichen der ray.direction kompontente:
         * => Hinten, Unten, Links == -
         * => Vorne, Oben, Rechts == +
         * 
         * (Achtung Vorne/Hinten sind bei der Sicht nach negativ Z getauscht)
         * (d.h. die ebene die am weitesten entfernt ist ist vorne)
         * 
         * Parallel zur X-Achse: Vorne/Hinten
         * Parallel zur Y-Achse: Links/Rechts
         * Parallel zur Z-Achse: Oben/Unten
         * 
         *          * 
         * Vorne: {0,0,1} * x - {0,0,1}*x0 = 0
         * Hinten: {0,0,-1} * x - {0,0,-1}*x0 = 0
         * Links: {-1,0,0} * x - {-1,0,0}*x0 = 0
         * Rechts: {1,0,0} * x - {1,0,0}*x0 = 0
         * Oben: {0,1,0} * x - {0,1,0}*x0 = 0
         * Unten: {0,-1,0} * x - {0,-1,0}*x0 = 0
         **/
        this.sites = new ArrayList<Plane>();
        sites.add(new Plane(this.pMin, new Vector(0,0,-1)));
        sites.add(new Plane(this.pMax, new Vector(0,0,1)));
        sites.add(new Plane(this.pMin, new Vector(-1,0,0)));
        sites.add(new Plane(this.pMax, new Vector(1,0,0)));
        sites.add(new Plane(this.pMin, new Vector(0,-1,0)));
        sites.add(new Plane(this.pMax, new Vector(0,1,0)));
    }

    /**
     * #################################
     *      öffentliche Methoden
     * #################################
     */
    
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
    public void setpMax(final Vector pMax) {
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
    
    /**
     * #################################
     *      überschriebene Methoden
     * #################################
     */
    
    /**
     * Der Fall, dass die Box um die Kamera gelegt ist wird nicht betrachtet
     **/
    @Override
    public Hit getNearestIntersectionWith(final Ray ray) {
        
        Hit shapeHit = null;
        Vector rayDirection = ray.getNormalizedDirection();
        
        ArrayList<Hit> hits = new ArrayList<Hit>();
        
        for(Plane p: this.sites){
            Hit tmp = p.getNearestIntersectionWith(ray);
            
            hits.add(tmp);
        }
        
        for(Hit h: hits){
            if(h == null){
                continue;
            }
            
            Vector hitPoint = ray.getPointAt(h.getFactorForHitPoint());
            
            if(hitPoint.x >= this.pMin.x && hitPoint.y >= this.pMin.y && hitPoint.z >= this.pMin.z &&
               hitPoint.x <= this.pMax.x && hitPoint.y <= this.pMax.y && hitPoint.z <= this.pMax.z){
                
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
