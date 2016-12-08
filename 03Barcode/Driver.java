public class Driver{
    public static void main (String[] args){
    	Barcode bar=new Barcode("08451");
	System.out.println(bar);
	Barcode a=new Barcode("12345");
	System.out.println(a);
	Barcode c=a.clone();
	System.out.println(c);
	//Barcode b=new Barcode("1.1111");
	//System.out.println(b);
	System.out.println(a.compareTo(c));
    }
}
