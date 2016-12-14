import java.util.Arrays;
public class Sorts{
    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "10.Gao.Jenny"; 
    }

    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void selectionSort(int[] data){
	for(int s=0;s<data.length;s++){//check
	    int smallerInd=s;
	    for(int i=s+1;i<data.length;i++){
		if(data[i]<data[smallerInd]){
		    smallerInd=i;
		}
	    }
	    int smallestVal=data[smallerInd];
	    int frontVal=data[s];
	    data[s]=smallestVal;
	    data[smallerInd]=frontVal;	  
	}
	//	return Arrays.toString(data);
    }
    public static void main(String[] args){
	// int[] a=new int[]{64,25,11,22,12};
	// System.out.println(selectionSort(a));
	// int[] b=new int[]{101,2,67,150,10,1};
	// System.out.println(selectionSort(b));
    }
}
