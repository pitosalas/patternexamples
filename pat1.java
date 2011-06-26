/* ---------------------------------------------------------------- */
/* This is not real code. It will not compile because it is         */
/* incomplete, and defines multiple classes and code snippets       */
/* It is just to illustrate the evolution of some related classes   */
/* ---------------------------------------------------------------- */

/* ---------------------------------------------------------------- */
/*	VARIATION 1: Simplest way to represent an Item in a catalog.    */
/* ---------------------------------------------------------------- */

/* --------------------------------------------------------- */
/* Represent a single item in a catalog.                     */
/* --------------------------------------------------------- */

class Item {
	
	public Item() { }
	
	public String getName() { return name; }
	public Float getPrice() { return price; }
	public String getDescription() { return desc;}	
	public String getMaterial() { return mat; }
	public String getCategory() { return cat;}
	
	public ArrayList<String> getTagsList() {
		// create an array list by pulling out the unique words
		// out of Name, Description and Materials. This kind of works for Amazon, but not
		// at all for Zappos.
		result = calculateTagsFromStrings(name + desc + mat);
		return result;
	}
}


/* ---------------------------------------------------------------- */
/* This code occurs elsewhere in the application, perhaps in a view */
/* ---------------------------------------------------------------- */
	Item anitem = new Item();
	ArrayList<String> tags = anitem.getTagList();


	
/* ---------------------------------------------------------------- */
/* VARIATION 2: I need an alternative technique to find the tags   */
/* for Zappos products.
/* ---------------------------------------------------------------- */
