package shapes;

import material.Material;

/**
 * Stellt eine abstrakte Form dar.
 * 
 * @author Bruno Kirschner
 */
public abstract class AbstractShape implements IShape{

    // Material der Form
    private Material material;

    @Override
    public Material getMaterial() {
        return this.material;
    }
    
    public void setMaterial(final Material material){
        this.material = material;
    }
}
