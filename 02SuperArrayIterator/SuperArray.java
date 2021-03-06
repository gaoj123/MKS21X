import java.util.*;
public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;
    public Iterator<String> iterator(){
	return new SuperArrayIterator(this);
    }
    //0
    //constructor make an empty superArray should make size 0, 
    //but the data capacity 10.
    public SuperArray(){
	size=0;
	data=new String[10];
    }
    public SuperArray(int initialCapacity){
	if (initialCapacity<0){
	    throw new IllegalArgumentException();
	}
	else{
	    size=0;
	    data=new String[initialCapacity];
	}
    }

    //1
    /**add the value n to the next available slot in the superArray.
     *this will change the size. This function should always work
     *And will resize the SuperArray if needed.*/
    // public void add(int n){
    //     if (size==data.length){
    //         this.grow();
    //     }
    //     data[size]=n;
    //     size+=1;
    // }
 
    //2
    /**Resize the data, by making a new array, then copying over elements, use this as your data.
     */

    private void grow(){
	String[] updatedData=new String[data.length*2];
	for(int i=0;i<data.length;i++){
	    updatedData[i]=data[i];
	}
	data=updatedData;
    }

    //3
    /**format the super array like this :   [ 1, 3, 6, 8, 23, 99, -4, 5] 
     *commas between... square bracket start/end and no comma at end.*/
    public String toString(){
	String s="[";
	for (int i=0;i<size;i++){
	    s=s+data[i];
	    if(i!=(size-1)){
		s+=", ";
	    }
	}
	s+="]";
	return s;
    }

    //4
    /**format the super array like this :   [ 1, 8, 23, 99, -4, 5, _, _, _, _]   
     *(capacity is 10, but only 6 are used)
     *commas between... square bracket start/end and no comma at end.
     *unused slots should be printed as _ (underscores) */
    public String toStringDebug(){
	String s2="[";
	for (int i=0;i<size;i++){
	    s2+=data[i];
	    if(i!=(size-1)){
		s2+=", ";
	    }
	}
	for (int a=size;a<data.length;a++){
	    s2+="_";
	}
	s2+="]";
	return s2;
    }


    //You should have these:
    // 1.
    public boolean add(String element) {
	if (size==data.length){
	    this.grow();
	}
	data[size]=element;
	size+=1;
	return true;
    }
    //    Appends the specified element to the end of this list. It returns true (add this part)

    //2.
    public String get(int index) {
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	else{
	    return data[index];
	}

    }
    //   Returns the element at the specified position in this list.

    //3.
    public int size(){
	return size;
    }
    //    Returns the number of elements in this list.

    //4.
    //    public String toString()

    //5. String toStringDebug()

    //What do you think about these?

    //Easy ones:
    //6.
    public void clear(){
	size=0;
    }
    //    Removes all of the elements from this list.

    //7.
    public boolean isEmpty(){
	return size==0;
    }
    
    //    Returns true if this list contains no elements.

    //8. 
    public String set(int index, String element){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	else{
	    String temp=data[index];
	    data[index]=element;
	    return temp;
	}
    }
    // Replaces the element at the specified position in this list with the specified element. Returns the value of the element replaced. 

    //harder ones:

    //9.
    public void add(int index, String element){
	if(index<0||index>size){
	    throw new IndexOutOfBoundsException();
	}
	else{
	    this.grow();
	    if(size==index){
		data[index]=element;
	    }
	    else{
		for(int i=size;i>index;i--){
		    data[i]=data[i-1];
		}
		data[index]=element;
	    }
	    size+=1;
	}
    }
    // Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).

    //10.
    public String remove(int index){
	if(index<0||index>=size){
	    throw new IndexOutOfBoundsException();
	}
	else{
	    String temp=data[index];
	    // updatedData=new int[data.length-1];
	    // for(int i=0;i<index;i++){
	    // 	updatedData[i]=data[i];
	    // }
	    for(int i=index;i<size-1;i++){
	        data[i]=data[i+1];
	    }
	    // data=updatedData;
	    size-=1;
	    return temp;
	}
    }
        
    
    // Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices). The value returned is the value of the element removed.

    //11.
    public String[] toArray() {
	// for(int i=0;i<data.length;i++){
	//     if(data[i]=="_"){
	//     this.remove(i);
	//     }
	// }
	String[] updatedData=new String[size];
	for(int i=0;i<size;i++){
	    updatedData[i]=data[i];
	    //	    data=updatedData;
	}
	return updatedData;
    }
    // Returns an array containing all of the elements in this list in proper sequence (from first to last element).

    //12.
    public int indexOf(String i){
	int abc=0;
	for(int a=0;a<size;a++){
	    if(data[a].equals(i)&&abc==0){
		abc=1;
		return a;
	    }
	}
	return -1;
    }
    // Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.

    //13.
    public int lastIndexOf(String i) {
	int chk=0;
	for(int a=size-1;a>-1;a=a-1){
	    if(chk==0&&data[a].equals(i)){
		chk=1;
		return a;
	    }
	}
        return -1;        
    }
    // Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
    public void trimToSize(){
	String[] updatedData=new String[size];
	for(int i=0;i<size;i++){
	    updatedData[i]=data[i];
	}
	data=updatedData;
    }
    public static void main(String[] args){
    }
}
