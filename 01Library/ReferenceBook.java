public class ReferenceBook extends LibraryBook{
    String collection;
    public ReferenceBook(String author, String title, String ISBN, String callNumber, String coll){
	super(author,title,ISBN,callNumber);
	collection=coll;
    }
    public String getCollection(){
	return collection;
    }
    public void setCollection(String c){
	collection=c;
    }
    public void checkout(String patron, String due){
	System.out.println(patron+" cannot check out a reference book.");
    }
    public void returned(){
	System.out.println("reference book could not have been checked out -- return impossible.");
    }
    public String circulationStatus(){
	String retString="non-circulating reference book";
	return retString;
    }
    public String toString(){
	return super.toString()+", "+collection;
    }
}
