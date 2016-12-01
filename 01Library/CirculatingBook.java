public class CirculatingBook extends LibraryBook{
    String currentHolder;
    String dueDate;
    public CirculatingBook(String author, String title, String ISBN, String callNumber){
	super(author,title,ISBN,callNumber);
	currentHolder=null;
	dueDate=null;
    }
    public String getCurrentHolder(){
	return currentHolder;
    }
    public String getDueDate(){
	return dueDate;
    }
    public void setCurrentHolder(String name){
	currentHolder=name;
    }
    public void setDueDate(String date){
	dueDate=date;
    }
    public void checkout(String patron, String due){
	currentHolder=patron;
	dueDate=due;
    }
    public void returned(){
	currentHolder=null;
	dueDate=null;
    }
    public String circulationStatus(){
	if (currentHolder==null&&dueDate==null){
	    return "book available on shelves";
	}
	else{
	    return "borrowed by "+currentHolder+" and due on: "+dueDate;
	}
    }
    public String toString(){
	if (currentHolder==null&&dueDate==null){
	    return super.toString();
	}
	else{
	    return super.toString()+", "+currentHolder+", "+dueDate;
	}
    }
	
}
