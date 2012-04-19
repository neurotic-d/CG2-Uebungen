package shapes;

import material.Material;

/**
 * Stellt eine abstrakte Form dar.
 */
public abstract class AbstractShape implements IShape{

    /**
     * #################################
     *            Attribute
     * #################################
     */
    
    /**
     * Das Material der Form.
     */
    private Material material;

    /**
     * #################################
     *      überschriebene Methoden
     * #################################
     */
    
    @Override
    public Material getMaterial() {
        return this.material;
    }
    
    /**
     * #################################
     *       öffentliche Methoden
     * #################################
     */
    
    public void setMaterial(final Material material){
        this.material = material;
    }
}
