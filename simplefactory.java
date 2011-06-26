Creational Patterns

- Different ways of creating - instantiating a class
- Basic way is well known:

fred = new Fred()

Factory Pattern: "Namer"

// Base class
public class Namer {

  // Split name is stored here
  protected String last;
  protected String first;
  
  public String getFirst() {
    return first;
  }
  
  public String getLast() {
    return last;
  }
}

// e.g. first = new FirstFirst("Pito Salas").first(); => "Pito"

public class FirstFirst extends Namer {
  public FirstFirst(String s) {
    // look for space separating first from last name (Pito Salas)
    // store first name in 'first' and last name in 'last'
    this.first = ... ;
    this.last = ... ;
  }
}


//e.g last = new LastFirst("Salas, Pito").last(); => "Salas"

public class LastFirst extends Namer {
  public LastFirst(String s) {
    // look for comma separating last name from first name (Salas, Pito)
    // store first name in 'first' and last name in 'last'
    this.first = ... ;
    this.last = ... ;
  }
}

// Build a simple factory

public class NamerFactory {
	// Decide which class to return based on presence of comma
	public static Namer getNamer(String entry) {
		int i = entry.indexOf(".")
		if (i > 0) 
			return new LastFirst(entry);
		else
			return new FirtLast(entry);
	}
}

//e.g. last = NamerFactory.getNamer("Pito Salas").last(); => "Salaså"





