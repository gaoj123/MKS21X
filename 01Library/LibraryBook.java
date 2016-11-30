public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    String callNumber;
    public LibraryBook(String author, String title, String ISBN, String callNum){
        setAuthor(author);
	setTitle(title);
	setISBN(ISBN);
	callNumber=callNum;
    }
    public String getCallNumber(){
	return callNumber;
    }
    public void setCallNumber(String callNum){
	callNumber=callNum;
    }
    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();
    public String toString(){
	return super.toString()+" "+circulationStatus()+", "+callNumber;
    }
    public int compareTo(LibraryBook b){
	return this.callNumber.compareTo(b.callNumber);
    }
}
