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
    // public static String insertionSort(int[] data){
    // 	for(int i=0;i<data.length;i++){
    // 	    for(int j=i+1;j<data.length;j++){
    // 		if(data[j]<data[i]){
    // 		    int a=data[j];
    // 		    data[j]=data[i];
    // 		    data[i]=a;
    // 		}
    // 	    }
    // 	}
    // 	return Arrays.toString(data);
    // }
    public static void insertionSort(int[] data){
	for(int i=1;i<data.length;i++){
	    int j=i-1;
	    int a=i;
	    int valMoving=data[i];
	    //System.out.println(a);
	    // System.out.println(valMoving);
	    while(j>-1){
		if(data[i]<data[j]){
		    a=j;
		    j--;
		}
		else {
		    j=-2;
		}
	    }
	    // for(int j=i-1;j>-1;j--){
	    // 	int a;
	    // 	int valMoving;
	    // 	if (data[i]<data[j]){
	    // 	    a=j;
	    // 	    valMoving=data[j];
	    // 	}
	    // }
	    for(int b=i;b>a;b--){
		data[b]=data[b-1];
	    }
	    data[a]=valMoving;
	}
	// System.out.print("[");
	// for(int i=0;i<data.length;i++){
	//     System.out.print(data[i]+",");
	// }
	// System.out.println("]");
	//	return Arrays.toString(data);
		
    }
    // for(int i=0;i<data.length-1;i++){
    //   if(...!=0){
    //     count=0;
    //     for(int j=1;j<data.length;j++)
    // ____________________________________________

    // count=0;
    // entered=0;
    // if (!(count==0&&entered==1)){
    // for(int i=0;i<data.length;i++){
    // 	entered=1;
    // 	if(data[i+1]<data[i]){
    // 		int x=data[i];
    // 		data[i]=data[i+1];
    // 		data[i+1]=x;
    // 		count+=1;
    // 	}
    // }
    // }
    public static void bubbleSort(int[] data){
	for(boolean done=false,int i=0;i<data.length-1&&!done;i++){
	    for(int j=0;j<data.length;j++){
		int count=0;
		if(data[i+1]<data[i]){
		    int x=data[i];
		    data[i]=data[i+1];
		    data[i+1]=x;
		    count+=1;
		}
	    }
	    if(count==0){
		done=true;
	    }
	}
	public static void main(String[] args){
	    // int[] a=new int[]{64,25,11,22,12,234,23,33,55,22,33,56};
	    // insertionSort(a);
	    // //	System.out.println(insertionSort(a));
	    // int[] b=new int[]{101,2,67,150,10};
	    // insertionSort(b);
	    // int[] c=new int[]{3, 7, 4, 9, 5, 2, 6, 1};
	    // insertionSort(c);
	    // int[] d=new int[]{9, 10, 4, 3, 0 , 2};
	    // insertionSort(d);
	    // int[] e=new int[]{1,2,4,6, 3,10,0,5};
	    // insertionSort(e);
	    //System.out.println(insertionSort(b));
	}
    }
