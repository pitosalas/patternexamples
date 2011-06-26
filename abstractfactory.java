Abstractbstract Factory Pattern

public class Plant {
	public String getColor() {...}
	public String getWaterNeeded() { ...}
	public String getSpacingRequired() { ... }
}

// Abstract Garden class. All kinds of gardens have recommended plants for
// Center, Border and Shade.
public abstract class Garden {
	public abstract Plant getCenter();
	public abstract Plant getBorder();
	public abstract Plant getShade();
}

// First kind of garden is a Veggie garden.
public class VeggieGarden extends Garden {
	public Plant getShade() {
		return new Plant("Broccoli");
	}
	public Plant getCenter() {
		return new Plant("Corn");
	}
	public Plant getBorder() {
		return new Plant("Peas");
	}
}

// Similarly, there will be a Perennial and Annual garden...

// Now the gardener can easily work with any kind of garden:

	gardentype = new VeggieGarden();
	centerplants = gardentype.getCenter();
	c = centerplants.getColor(); => "Green"
	c = centerplants.getSpacingRequired(); => "3"
	
	
