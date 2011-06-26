/* ---------------------------------------------------------------- */
/* This is not real code. It will not compile because it is         */
/* incomplete, and defines multiple classes and code snippets       */
/* It is just to illustrate the evolution of some related classes   */
/* ---------------------------------------------------------------- */

/* ---------------------------------------------------------------- */
/* VARIATION 2: I need an alternative technique to find the tags   */
/* for Zappos products.
/* ---------------------------------------------------------------- */

/* --------------------------------------------------------- */
/* Represent a single item in a catalog.                     */
/* --------------------------------------------------------- */
class Item {
	
	public Item(TagCalculator aTagger) {
		TagCalculator this.tagger = aTagger;
	}
	
	public String getName() { return name; }
	public Float getPrice() { return price; }
	public String getDescription() { return desc;}	
	public String getMaterial() { return mat; }
	public String getCategory() { return cat;}
	
	public ArrayList<String> getTagsList() {
		// Ask the tagger to come up with a set of tags based on three properties
		result = tagger.getTags(name + desc + mat);
		return result;
	}
	
}

/* --------------------------------------------------------- */
/* Represent an algorithm for computing tags                 */
/* --------------------------------------------------------- */
class TagsFromStrings1 {
	
	ArrayList<String> getTags(String tagstrings) {
		res = ArrayList<String>;
		// do a smart algorithm by analyzing word frequencies occurring in the name, desc and material.
		// ...
		return res;
	}
}

/* ---------------------------------------------------------------- */
/* This code occurs elsewhere in the application, perhaps in a view */
/* ---------------------------------------------------------------- */
	Item anitem = new Item(new TagsFromStrings());
	ArrayList<String> tags = anitem.getTagList();
	

/* ---------------------------------------------------------------- */
/* Now, the  Item class knows nothing about how tags are magically  */
/* computed, and that logic can change without changing the Item c  */
/* class. The initial approach works nicely for Amazon              */
/*                                                                  */
/* VARIATION 3: Next, we need to have two kinds of Items, those     */
/* from Amazon and  those from Zappos.                              */
/* ---------------------------------------------------------------- */


