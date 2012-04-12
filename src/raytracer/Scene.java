package raytracer;

import java.util.ArrayList;
import java.util.List;

import shapes.IShape;

/**
 * Stellt eine Szene mit ihren Objekten dar.
 * 
 * @author Bruno Kirschner
 */
public class Scene {
    
    // Liste der Objekte in der Szene.
    private List<IShape> shapes;
    
    public Scene(){
        this.shapes = new ArrayList<IShape>();
    }
    
    /**
     * Fügt verschiedene Formen dieser Szene hinzu.
     * 
     * @param shapes die Liste der Formen die der Szene hinzugefügt werden sollen.
     */
    public void addShapeToScene(IShape... shapes){
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
     * Getter für die Liste der Formen in der Szene wieder.
     * 
     * @return die Liste der Formen.
     */
    public List<IShape> getShapes() {
        return shapes;
    }

    /**
     * Setzt eine neue Liste an Formen für die Szene.
     * 
     * @param shapes    die neue Liste an Formen
     */
    public void setShapes(List<IShape> shapes) {
        this.shapes = shapes;
    }
    
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