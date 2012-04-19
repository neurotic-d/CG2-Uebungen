package shapes;

import raytracer.Ray;
import material.Material;
import raytracer.Hit;

/**
 * Schnittstelle für die Formen im Raytracer.
 */
public interface IShape {
    
    /**
     * Gibt die Schnittpunkte der Form mit einem Strahl wieder.
     * 
     * @param ray   Der Strahl, welcher die Form eventuell schneidet.
     * 
     * @return  der vorderste Schnittpunkt falls dieser existiert
     */
    public Hit getNearestIntersectionWith(final Ray ray);
    
    /**
     * Gibt das Material der Form wieder.
     * 
     * @return das Material
     */
    public Material getMaterial();
}