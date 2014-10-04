package info.vector;

//A line in the form of a parametric equation (point and vector parallel to line).

public class Line {

	public double xCo, xPoint;
	public double yCo, yPoint;
	public double zCo, zPoint;
	
	public Line(double xCo, double xPoint, double yCo, double yPoint, double zCo, double zPoint)
	{
		this.xCo = xCo;
		this.xPoint = xPoint;
		this.yCo = yCo;
		this.yPoint = yPoint;
		this.zCo = zCo;
		this.zPoint = zPoint;
	}
	
	public Point t(double t)
	{
		return new Point(xCo*t + xPoint, yCo*t + yPoint, zCo*t + zPoint);
	}
	
	public Point intersect(Plane p)
	{
		double t = (p.d - (p.a*xPoint + p.b*yPoint + p.c*zPoint))/(p.a*xCo + p.b*yCo + p.c*zCo);
		return new Point(xCo*t + xPoint, yCo*t + yPoint, zCo*t + zPoint);
	}
	
	public Line unit()
	{
		double dist = Math.sqrt(Math.pow(xCo, 2) + Math.pow(yCo, 2) + Math.pow(zCo, 2));
		return new Line(xCo/dist,yCo/dist,zCo/dist,0,0,0);
	}
	
}
