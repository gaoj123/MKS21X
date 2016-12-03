import java.util.*;
public class SuperArrayIterator implements Iterator<String>{
    SuperArray a;
    int index;
    int lenArr;
    public SuperArrayIterator(SuperArray arr){
	a=arr;
	index=0;
	lenArr=arr.size();
    }
    public String next(){
	if(hasNext()){
	    index++;
	    return a.get(index-1);
	}
	else{
	    throw new NoSuchElementException();
	}
    }
    public boolean hasNext(){
	return index<lenArr;
    }
    public void remove(){
	throw new UnsupportedOperationException();
    }
}
