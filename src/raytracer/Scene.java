package raytracer;

import java.util.ArrayList;
import java.util.List;

import light.Lightsource;
import shapes.IShape;
import vecmath.Color;

/**
 * Stellt eine Szene mit ihren Objekten dar.
 */
public class Scene {
    
    /**
     * #################################
     *            Attribute
     * #################################
     */
    
    /**
     * Die Liste der Formen in der Szene.
     */
    private List<IShape> shapes;
    
    /**
     * Die Liste aller Lichtquellen.
     */
    private List<Lightsource> lights;
    
    /**
     * Die Farbe des Umgebungslichtes.
     */
    private Color ambientLight;
    
    /**
     * #################################
     *           Konstruktoren
     * #################################
     */
    
    /**
     * Erzeugt eine leere Szene.
     */
    public Scene(){
        this.shapes = new ArrayList<IShape>();
    }
    
    /**
     * #################################
     *        öffentliche Methoden
     * #################################
     */
    
    /**
     * Fügt Formen zur Szene hinzu.
     * 
     * @param shapes Formen, die hinzugefügt werden sollen.
     */
    public void addShapeToScene(final IShape... shapes){
        if(shapes == null){
            throw new IllegalArgumentException("Scene: addShapeToScene: shapes ist null");
        }
        
        for(IShape s: shapes){
            if(s != null){
                this.shapes.add(s);
            }
        }
    }
    
    /**
     * Fügt Lichtquellen zur Szene hinzu.
     * 
     * @param lights Lichtquellen, die hinzugefügt werden sollen.
     */
    public void addLightToScene(final Lightsource... lights){
        if(lights == null){
            throw new IllegalArgumentException("Scene: addLightToScene: lights ist null");
        }
        
        for(Lightsource l: lights){
            if(l != null){
                this.lights.add(l);
            }
        }
    }

    /**
     * Gibt für die Liste der Formen in der Szene wieder.
     * 
     * @return Liste der Formen
     */
    public List<IShape> getShapes() {
        return shapes;
    }
    
    /**
     * Gibt die Liste der Lichtquellen in der Szene wieder.
     * 
     * @return Liste der Lichtquellen
     */
    public List<Lightsource> getLights(){
        return this.lights;
    }
    
    /**
     * Gibt die Farbe des Umgebungslichts wieder.
     * 
     * @return Umgebungslicht
     */
    public Color getAmbientLight(){
        return this.ambientLight;
    }
    
    public void setAmbientLight(final Color ambient){
        this.ambientLight = ambient;
    }
    
    /**
     * Gibt den vordersten Treffer des Strahls in der Szene wieder.
     * 
     * @param ray   Strahl dessen Treffer geprüft wird
     * 
     * @return vorderster Treffer
     */
    public Hit getNearestIntersectionWith(final Ray ray){
        
        Hit nearestHit = null;
        
        for(IShape s : this.shapes){
            Hit currentHit = s.getNearestIntersectionWith(ray);
            
            if(nearestHit == null && currentHit != null && currentHit.getFactorForHitPoint() > 0){
                nearestHit = currentHit;
            }
            else if(currentHit != null && currentHit.getFactorForHitPoint() > 0 && currentHit.getFactorForHitPoint() < nearestHit.getFactorForHitPoint()){
                
                nearestHit = currentHit;
            }
        }
        
        return nearestHit;
    }
}