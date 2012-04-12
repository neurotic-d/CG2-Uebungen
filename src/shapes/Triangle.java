package shapes;

import raytracer.Hit;
import raytracer.Ray;
import vecmath.Vector;

public class Triangle extends AbstractShape {

	private Vector p1;
	private Vector p2;
	private Vector p3;
	
	public Triangle(final Vector p1, final Vector p2, final Vector p3){
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	@Override
	public Hit getNearestIntersectionWith(Ray ray) {
		
		/**
		 * 
		 * 3 Punkte vom Dreieck => Ebene im Raum (new Plane(p1,p2,p3));
		 * Schnittpunkt Ebene - Strahl
		 * prüfen ob Schnittpunkt im Dreieck
		 * 
		 */
		
		Plane trianglePlane = new Plane(this.p1, this.p2, this.p3);
		
		Hit hitWithPlane = trianglePlane.getNearestIntersectionWith(ray);
		Vector hitPoint = ray.getPointAt(hitWithPlane.getFactorForHitPoint());
		
		
		
		return null;
	}

}
