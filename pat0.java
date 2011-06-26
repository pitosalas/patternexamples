/* ---------------------------------------------------------------- */
/* This is not real code. It will not compile because it is         */
/* incomplete, and defines multiple classes and code snippets       */
/* It is just to illustrate the evolution of some related classes   */
/* ---------------------------------------------------------------- */

/* ---------------------------------------------------------------- */
/* VARIATION 0: This is the very smelly initial version of the Item */
/* class. It simply needs to keep up with several properties of an  */
/* item and sometimes do some calculations to figure out the tags   */
/* ---------------------------------------------------------------- */

class Item {
	
	String catalog, key;
	String name, price, desc, mat, cat, tags;
	
	public String getName() { }
	public Float getPrice() { }
	public String getDescription() { }	
	public String getMaterial() { }
	public String getCategory() { }
	
//
// Contructor - retrieve item information from the appropriate REST URL
// and store them in instance variables, accounting for differen url and field names
//	
	public void Item(String theCat, String theKey) {
		String restUrl;
		XML result;
		catalog = theCat;
		key = theKey;
		if (catalog == "Amazon") {
			restURL = "http://www.amazon.com/item/"+key;
			result = restCall(restURL);
			name = result.name;
			price = result.price;
			mat = result.material;
			desc = result.description;
			tags = "";
		} else if (catalog == "Zappos") {
			restURL = "http://www.zappos.com/api/item/"+key;
			result = restCall(restURL);
			name = result.product;
			price = result.price_in_dollars;
			mat = "";
			desc = result.body;
		}
	}
	
	public ArrayList<String> getTagsList() {
		if (catalog == "Amazon")
			return calculateTagsFromStrings(name + desc + mat);
		else if (catalog == "Zappos") {
			return chopintoWords(name + desc + mat);
		}
	}
}

/* ---------------------------------------------------------------- */
/* This code occurs elsewhere in the application, perhaps in a view */
/* ---------------------------------------------------------------- */
	Item anitem = new Item();
	ArrayList<String> tags = anitem.getTagList();
	
	Item itemOne = new Item("Zappos", "1234-PHOOZEL-SKIM")
	System.out.println(itemOne.getTagsList());

	Item itemTwoe = new Item("Amazon", "ZZ-999-3123-221")
	System.out.println(itemTwo.getTagsList());
	
	
	

