public class Driver{
    public static void main (String[] args){
    	Barcode bar=new Barcode("08451");
	//System.out.println(bar);
	Barcode a=new Barcode("12345");
	//	System.out.println(a);
	//Barcode c=a.clone();
	//System.out.println(c);
	//Barcode b=new Barcode("1.111");
	//System.out.println(b);
	// System.out.println(a.compareTo(c));
	try{
	    System.out.println(Barcode.toZip("||||::|::|::|::|:|:|::::|||::::|"));
	}
	catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	try{
	    System.out.println(Barcode.toCode("1234a"));
	}
	catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	try{
	    System.out.println((new Barcode("12345")).compareTo((new Barcode("12345"))));
	}
	catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	// System.out.println(Barcode.toCode("12345"));
      	// System.out.println(new Barcode("12345").compareTo(new Barcode("12434")));
	// System.out.println(Barcode.toZip("|:::||::|:|::||::|::|:|:|::|:|:|"));
    }
}
