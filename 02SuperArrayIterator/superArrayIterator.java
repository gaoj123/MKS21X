import java.util.*;
public class superArrayInterator implements Iterator<String>{
    public superArrayInterator(){
    }
    public String next(){
	if(hasNext()){
	}
	else{
	    throw new NoSuchElementException();
	}
    }
    public boolean hasNext(){
    }
    public void remove(){
	throw new UnsupportedOperationException();
    }
}
