package shapes;

import material.Material;
import vecmath.Color;

/**
 * Stellt eine abstrakte Form dar.
 * 
 * @author Bruno Kirschner
 */
public abstract class AbstractShape implements IShape{

    // Material der Form
    private Material material;
    
    // Farbe der Form
    private Color color = new Color(255,0,0);

    @Override
    public Material getMaterial() {
        return this.material;
    }
    
    public void setMaterial(final Material material){
        this.material = material;
    }
}
