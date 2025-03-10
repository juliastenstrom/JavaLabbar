package lab5;

public abstract class Building implements Comparable <Building>{
	
	private String address;
	private double price;
	protected int squareMeters;
	protected static int selection = 1;
	
	public Building(String arg1, double arg2, int arg3) {
		address = arg1;
		price = arg2;
		squareMeters = arg3;
	}
	
	public abstract double maintenance();
	
	public int compareTo(Building arg) {
		
		
		if(selection == 1) {
			
			if(arg.price > this.price) {
				return -1;
			}
			else if (arg.price < this.price) {
				return 1;
			}
			return 0;
		}
		
		else{
			
			if(arg.squareMeters > this.squareMeters) {
				return -1;
			}
			else if (arg.squareMeters < this.squareMeters) {
				return 1;
			}
			return 0;
		}
	}
	
	public String toString() {
		String result = String.format("Address: %16s", address) + ", ";

	        result += String.format("Living area: %4d", squareMeters) + ", ";
	        result += String.format("Price: %.2f", price) + ", ";
	        result += String.format("Maintanance (per month): %.2f", maintenance()) + "\n";
	        
	        if (this instanceof CityProperty) {
	        	result += "Property tax: " + ((CityProperty)this).computePropertyTax() + "\n";
	        }
	        else if (this instanceof Cottage) {
	        	result += "\n";
	        }
	        
	        return result;
	}

}
