import java.util.*;

public class Main {
	public static void main(String[] args) {

		List<Building> buildings = new ArrayList<>();
		buildings.add(new Building(2, 10, "Red Building"));
		buildings.add(new Building(3, 10, "Green Building"));
		buildings.add(new Building(4, 10, "White Building"));
		printBuildings(buildings);


		List<House> houses = new ArrayList<>();
		houses.add(new House(2, 10));
		houses.add(new House(3, 10));
		houses.add(new House(4, 10));
		printBuildings(houses);

		List<Office> offices = new ArrayList<>();
		offices.add(new Office(2, 10));
		offices.add(new Office(3, 10));
		offices.add(new Office(4, 10));
		printBuildings(offices);


		List<School> schools = new ArrayList<>();
		schools.add(new School(2, 10));
		schools.add(new School(3, 10));
		schools.add(new School(4, 10));
		printBuildings(schools);

		add(houses);
		add(buildings);
		System.out.println("====================================");
		printBuildings(houses);
		printBuildings(buildings);

	}

	// wildcard example

	public static void printBuildings(List<? extends Building> buildings) {

		for (Building building : buildings) {
			System.out.println(building.getType() + " : " + building.getArea());
		}

	}

	public static void add(List<? super House> houses) {
		houses.add(new House(34, 10));

	}

}

class Building {
	private double height;
	private double wide;
	private String type;


	public Building(double height, double wide, String type) {
		this.height = height;
		this.wide = wide;
		this.type = type;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setWide(double wide) {
		this.wide = wide;
	}

	public double getHeight() {
		return this.height;
	}
	public double getWide() {
		return this.wide;
	}

	public double getArea() {
		return getHeight() * getWide();
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return this.type;
	}

}

class House extends Building {

	public House(double height, double wide) {
		super(height, wide, "House");
	}
}

class Office extends Building {
	public  Office(double height, double wide) {
		super(height, wide, "Office");
	}
}

class School extends Building {
	public School(double height, double wide) {
		super(height, wide, "School");
	}
}


