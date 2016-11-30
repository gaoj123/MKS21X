public class Book{
    String author;
    String title;
    String ISBN;
    public Book(){
    }
    public Book(String author, String title, String ISBN){
	this.author=author;
	this.title=title;
	this.ISBN=ISBN;
    }
    public String getAuthor(){
	return author;
    }
    public void setAuthor(String name){
	author=name;
    }
    public String getTitle(){
	return title;
    }
    public void setTitle(String TITLE){
	title=TITLE;
    }
    public String getISBN(){
	return ISBN;
    }
    public void setISBN(String isbn){
	ISBN=isbn;
    }
    public String toString(){
	String retString=title+", "+author+", "+ISBN;
	return retString;
    }
}
