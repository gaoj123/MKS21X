public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
   private int _checkDigit;

// constructors
//precondition: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
  public Barcode(String zip) {
      if(zip.length()==5&&checkDigit(zip)){
	  _checkDigit=checkSum()%10;
	  _zip=zip;
      }
      else{
	  //throw exception
      }
}

// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
      //String 
}

  public boolean checkDigit(String a){
      for(int i=0;i<a.length();i++){
	  String b=a.substring(i,i+1);
	  if!((b>="A"&&b<="Z")||(b>="a"&&b<="z")){
		  return false;
	  }
      }
      return true;
  }
// postcondition: computes and returns the check sum for _zip
  private int checkSum(){
      return _zip+_checkDigit;	  
  }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
      String retStr="";
}


// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){}
    
}
