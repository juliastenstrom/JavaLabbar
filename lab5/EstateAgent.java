package lab5;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;


public class EstateAgent {
	
	public final static int ALLBUILDNINGS = 1;
	public final static int CITYBUILDNINGS = 2;
	public final static int COTTAGES = 3;
	
	public final String NAME;
	private ArrayList<Building> theBuildnings = new ArrayList();
	private ArrayList<CityProperty> theCityBuildnings = new ArrayList();
	private ArrayList<Cottage> theCottages = new ArrayList();
	
	public EstateAgent(String arg) {
		NAME = arg;
	}
	
	public String addBuilding(Building arg) {
		theBuildnings.add(arg);
		if(arg instanceof Cottage) {
		theCottages.add((Cottage) arg);
		return "Added cottage";
		}
		else {
			theCityBuildnings.add((CityProperty) arg);
			return "added city building";
		}
		
	}
	//måste man alltid ha updatelist efter?
	public String sort(int arg) {
		String input = JOptionPane.showInputDialog("Sorting by price(1) or area(2)?");
		int number = Integer.parseInt(input);	
	

		if(number == 1 || number == 2) {
			Building.selection = number;
			
			
			if(arg == ALLBUILDNINGS) {
				Collections.sort(theBuildnings);
				updateLists();
			}
			
			else if(arg == COTTAGES) {
				Collections.sort(theCottages);
				updateLists(COTTAGES);
			}
			
			//arrays of interfaces????????????????????????
			else if(arg == CITYBUILDNINGS) {
			
				ArrayList<Building> b = new ArrayList<Building>();
				for(int i = 0; i < theCityBuildnings.size(); i++) {
					b.add((Building) theCityBuildnings.get(i));
				}
				Collections.sort(b);
				
				for(int i = 0; i < b.size(); i++) {
					theCityBuildnings.set(i, (CityProperty) b.get(i));
				}
				updateLists(CITYBUILDNINGS);
			}
			
		}
		
		if(number ==1) {
			return "Sorted by price";
		}
		
		else if(number == 2) {
			return "Sorted by area";
		}
		
		return "Not Sorted";
	}
	
	//???????????????????????????????????????????????
	public void updateLists() {
		int c = 0;
		int a = 0;
		for(int i = 0; i < theBuildnings.size(); i++) {
			if(theBuildnings.get(i) instanceof Cottage) {
				theCottages.set(c, (Cottage) theBuildnings.get(i));
				c++;
			}
			else if(theBuildnings.get(i) instanceof CityProperty) {
				theCityBuildnings.set(a, (CityProperty) theBuildnings.get(i));
				a++;
			}
		}
	}
	
	//?????????????????????????
	public void updateLists(int arg) {
		int t = 0;
		if (arg == COTTAGES) {
			for(int i = 0; i < theBuildnings.size(); i++) {
				if(theBuildnings.get(i) instanceof Cottage) {
					theBuildnings.set(i, (Building) theCottages.get(t));
					t++;
					if(t == theCottages.size()) {
						break;
					}
				}
			}
		}
		
		else if(arg == CITYBUILDNINGS) {
			int y = 0;
			for(int i = 0; i < theBuildnings.size(); i++) {
				if(theBuildnings.get(i) instanceof CityProperty) {
					theBuildnings.set(i, (Building) theCityBuildnings.get(y));
					y++;
					if(y == theCottages.size()) {
						break;
					}
				}
			}
		}
	}
	
	public String toString() {
	
		String result = "Estate agent: " + NAME + "\n";
		result += "All buildings \n";
		for (int i = 0; i < theBuildnings.size(); i++) {
			result += theBuildnings.get(i) + "\n";
		}
		
		result += "Cottages \n";
		for (int i = 0; i < theCottages.size(); i++) {
			result += theCottages.get(i) + "\n";
		}
		
		result += "Villas and apartments \n";
		for (int i = 0; i < theCityBuildnings.size(); i++) {
			result += theCityBuildnings.get(i) + "\n";
		}
		return result;
	}

}
