/* ---------------------------------------------------------------- */
/* This is not real code. It will not compile because it is         */
/* incomplete, and defines multiple classes and code snippets       */
/* It is just to illustrate the evolution of some related classes   */
/* ---------------------------------------------------------------- */

/* ---------------------------------------------------------------- */
/* Now, the  Item class knows nothing about how tags are magically  */
/* computed, and that logic can change without changing the Item c  */
/* class. The initial approach works nicely for Amazon              */
/*                                                                  */
/* VARIATION 3: Next, we need to have two kinds of Items, those     */
/* from Amazon and  those from Zappos.                              */
/* ---------------------------------------------------------------- */

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
	Item anitem = new ZapposItem(new CommaDelimtedTags());
	ArrayList<String> tags = anitem.getTagList();
	

/* ---------------------------------------------------------------- */
/* VARIATION 4: There is local knowledge of two catalogs, Zappos and*/
/* Amazon. Let's separate out the concern of what catelog(s) we are */
/* working with.                                                    */
/* ---------------------------------------------------------------- */


