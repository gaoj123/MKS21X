public class Driver{
    public static void main (String[] args){
    	Barcode bar=new Barcode("08451");
	Barcode a=new Barcode("12345");
	Barcode c=new Barcode("12233");
        System.out.println(c);
	try{
	    System.out.println("this should fail: wrong checksum");
	    System.out.println(Barcode.toZip("|:::||::|:|::|:|::||:::||:::||:|"));
	}
	catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	try{
	    System.out.println("this should work: normal one");
	    System.out.println(Barcode.toZip("|:::||::|:|::|:|::||:::||::::|||"));
	}
	catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	try{
	    System.out.println("this should fail: no corresponding int value");
	    System.out.println(Barcode.toZip("|:::||::|:|::|:|::||:::||:::::||"));
	}
	catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	try{
	    System.out.println("this should fail: non-barcode chars used");
	    System.out.println(Barcode.toZip("|:::||::|:|::|:|::||@::||::::|||"));
	}
	catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	try{
	    System.out.println("this should fail: length of barcode is not 32");
	    System.out.println(Barcode.toZip("|::||::|:|::|:|::||:::||::::|||"));
	}
	catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	try{
	    System.out.println("this should fail: doesn't start/end with |");
	    System.out.println(Barcode.toZip("|||::||::|:|::|:|::||:::||::::|:"));
	}
	catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
       	// try{
	//     System.out.println(Barcode.toZip("||||::|::|::|::|:|:|::::|||::::|"));
	// }
	// catch(IllegalArgumentException e){
	//     e.printStackTrace();
	// }
	// try{
	//     System.out.println(Barcode.toZip("||||::|::|::|::|:|:|::::|||::::|"));
	// }
	// catch(IllegalArgumentException e){
	//     e.printStackTrace();
	// }
	// try{
	//     System.out.println(Barcode.toZip("||||::|::|::|::|:|:|::::|||::::|"));
	// }
	// catch(IllegalArgumentException e){
	//     e.printStackTrace();
	// }
	// try{
	//     System.out.println(Barcode.toZip("||||::|::|::|::|:|:|::::|||::::|"));
	// }
	// catch(IllegalArgumentException e){
	//     e.printStackTrace();
	// }
	try{
	    System.out.println("this should work");
	    System.out.println(Barcode.toCode("08451"));
	}
	catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	try{
	    System.out.println("this should fail: non digits used");
	    System.out.println(Barcode.toCode("1234a"));
	}
	catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	try{
	    System.out.println("this should fail: length not 5");
	    System.out.println(Barcode.toCode("1234"));
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
	try{
	    System.out.println((new Barcode("55555")).compareTo((new Barcode("22222"))));
	}
	catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	// System.out.println(Barcode.toCode("12345"));
      	// System.out.println(new Barcode("12345").compareTo(new Barcode("12434")));
	// System.out.println(Barcode.toZip("|:::||::|:|::||::|::|:|:|::|:|:|"));
    }
}
