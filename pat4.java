/* ---------------------------------------------------------------- */
/* This is not real code. It will not compile because it is         */
/* incomplete, and defines multiple classes and code snippets       */
/* It is just to illustrate the evolution of some related classes   */
/* ---------------------------------------------------------------- */

/* ---------------------------------------------------------------- */
/* VARIATION 4: There is local knowledge of two catalogs, Zappos and*/
/* Amazon. Let's separate out the concern of what catelog(s) we are */
/* working with.                                                    */
/* ---------------------------------------------------------------- */

/* --------------------------------------------------------- */
/* Represent a catalog                                       */
/* --------------------------------------------------------- */
class Catalog {
	public String getCatalogName() {return "generic catalog";}

// Factory to create a new item for specified item key from relevant web service
	public abstract Item getItem(String itemKey);
	
// Do network REST call to get an XML structure containing data for specified item
	public abstract XML restGetValue(String itemKey);
	// ...
}

/* --------------------------------------------------------- */
/* Represent the Amazon Catalog                              */
/* --------------------------------------------------------- */
class AmazonCatalog extends Catalog {
	public String getCatalogName() {return "Amazon Catalog";}
	
// Factory to create a new item for specified item key from relevant web service
	public Item getItem(String itemkey) {
		XML val = getValue(itemkey);
		return new AmazonItem(val, new TagsFromStrings());
	}

// Do network REST call to get an XML structure containing data for specified item	
	public XML restGetValue() {
		String restURL = "http://www.amazon.com/item/"+key;
		return restCall(restURL);
	}
	// ...
}

/* --------------------------------------------------------- */
/* Represent the Zappos Catalog                              */
/* --------------------------------------------------------- */
class ZapposCatalog extends Catalog {
	public String getCatalogName() {return "Zappos Catalog";}

// Factory to create a new item for specified item key from relevant web service
	public Item getItem(String itemkey) {
		XML val = getValue(itemkey);
		return = new ZapposItem(val, new CommaDelimtedTags());
	}

// Do network REST call to get an XML structure containing data for specified item
	public XML restGetValue() {
		String restURL = "http://www.zappos.com/api/item/"+key;
		result = restCall(restURL);		
	}

	// ...
}
/* --------------------------------------------------------- */
/* Represent a single item in a catalog.                     */
/* --------------------------------------------------------- */
class Item {
	public String getName() { return "no name"; }
	public String getPrice() { return "no price"; }
	public String getDescription() { return "no description"; }	
	public String getMaterial() { return "no material"; }
	public String getCategory() { return "no category"; }
	public ArrayList<String> getTagsList() { return new ArrayList<String>(); }
}


/* --------------------------------------------------------- */
/* Represent a single item from the Amazon catalog           */
/* One annoying thing about the Amazon catalog is that there */
/* are no tags... So we have to come up with a different way */
/* to supply tags to the user in our product                 */
/* --------------------------------------------------------- */
class AmazonItem extends Item {
	
	public Item(TagCalculator aTagger) {
		TagCalculator this.tagger = aTagger;
	}

	public String getName() { }
	public Float getPrice() { }
	public String getDescription() { }	
	public String getMaterial() { }
	public String getCategory() { }
	
	public ArrayList<String> getTagsList() {
		// Ask the tagger to come up with a set of tags based on three properties
		result = tagger.getTags(name + desc + mat);
		return result;	
	}	
}

/* --------------------------------------------------------- */
/* Represent a single item from the Zappos catalog           */
/* Zappos items come with a tag, but it's a comma delimited  */
/* string... So we have to do a little work.                 */
/* --------------------------------------------------------- */
class ZapposItem extends Item {
	public Item(TagCalculator aTagger) {
		TagCalculator this.tagger = aTagger;
	}
	public String getName() { }
	public Float getPrice() { }
	public String getDescription() { }	
	public String getMaterial() { }
	public String getCategory() { }
	
	public ArrayList<String> getTagsList() {
		// Ask the tagger to come up with a set of tags based on three properties
		result = tagger.getTags(name + desc + mat);
		return result;	
}

/* --------------------------------------------------------- */
/* Represent an algorithm for computing tags from a string   */
/* --------------------------------------------------------- */
class TextStringTags {
	
	ArrayList<String> getTags(String textstring) {
		res = new ArrayList<String>;
		// do a smart algorithm by analyzing word frequencies occurring the string.
		// ...
		return res;
	}
}

/* --------------------------------------------------------- */
/* Represent another algorithm for computing tags            */
/* --------------------------------------------------------- */
class CommaDelimtedTags {
	
	ArrayList<String> getTags(String name, String desc, String mat) {
		res = new ArrayList<String>;
		// simply break the string up into comma delimted phrases.
		// ...
		return res;
	}
}

/* ---------------------------------------------------------------- */
/* This code occurs elsewhere in the application, perhaps in a view */
/* ---------------------------------------------------------------- */

	zap = new ZapposCatalog();
	Item itemOne = zap.getItem("1234-PHOOZEL-SKIM");
	itemOne.getTags();

	amz = new AmazonCatalog()
	Item itemTwo = amz.getItem("ZZ-999-3123-221");
	itemTwo.getTags();
	
	


