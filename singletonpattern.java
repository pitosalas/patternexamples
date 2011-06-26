Singleton Pattern

// Used when you want to guarantee that there's one and only one instance of a certain class.
// Example: There is one and only one GameSpace in your class structure.
// Note that there are several ways to do a Singleton in Java

public class GameSpace {
	private static GameSpace theSpace;

// N.B. A private constructor?
	private GameSpace() {
	}
	
// Create the one and only, or if you did before, just return it.
	public static synchronized GameSpace instance() {
		if (theSpace == null)
			theSpace = new GameSpace();
		return theSpace;
	}
	
// ... the rest of the class goes here.
}

// And now, whenever you need to access GameSpace:

g = GameSpace.instance();
g.reset();	// for example
