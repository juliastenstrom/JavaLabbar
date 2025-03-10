package lab1;

public class Vector {
	
	private double x;
	private double y;
	private double z;
	
	public static Vector vdef = new Vector (0.0, 0.0, 0.0);
	
	public Vector() {
		x = vdef.x;
		y = vdef.y;
		z = vdef.z;
	}
	
	public Vector(double d1, double d2, double d3) {
		x = d1;
		y = d2;
		z = d3;
	}
	
	public static void setDefault (Vector arg) {
		vdef = arg;
	}
	
	public void setToDefault() {
		this.x = vdef.x;
		this.y = vdef.y;
		this.z = vdef.z;
	}
	
	public static Vector plus(Vector arg1, Vector arg2) {
		Vector arg3 = new Vector();
		arg3.x = arg1.x + arg2.x;
		arg3.y = arg1.y + arg2.y;
		arg3.z = arg1.z + arg2.z;
		
		return arg3;
	}
	
	public Vector minus(Vector arg1) {
		Vector arg3 = new Vector();
		arg3.x = this.x - arg1.x;
		arg3.y = this.y - arg1.y;
		arg3.z = this.z - arg1.z;
		
		return arg3;
	}
	
	public Vector mult(double arg) {
		Vector arg3 = new Vector();
		arg3.x = arg3.x - arg;
		arg3.y = arg3.y - arg;
		arg3.z = arg3.z - arg;
		
		return arg3;
	}
	
	public double mult(Vector arg) {
		double dot = arg.x + arg.y + arg.z;
		return dot;
	}
	
	
	public double length() {
		double l = Math.sqrt(this.x * this.x +this.y * this.y +this.z * this.z);
		return l;
	}
	
	public void norm() {
		double l = this.length();
		if(l != 0.0) {
			this.x = this.x/l;
			this.y = this.y/l;
			this.z = this.z/l;
		}

	}
	
	public Vector matrixMult(double[][] arg) {
		if (arg.length != 3 || arg[0].length != 3) {
			return this;
		}
		else {
			this.x = arg[0][0] * x + arg[0][1] * x + arg[0][2] * x;
			this.y = arg[1][0] * y + arg[1][1] * y + arg[1][2] * y;
			this.z = arg[2][0] * z + arg[2][1] * z + arg[2][2] * z;
			return new Vector(this.x, this.y, this.z);
		}
	}
	
	
	public int compareTo(Vector arg1) {
		if(length() == arg1.length()) {
			return 0;
		}
		else if(length() < arg1.length()) {
			return -1;
		}
			else {
				return 1;
			}
		}
	
	public String toString() {
		String a = String.format("Vector = (%.1f, %.1f, %.1f)", x, y, z);
		return a;
	} 
	
}
