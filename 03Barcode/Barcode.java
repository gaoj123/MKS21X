public class Barcode implements Comparable<Barcode>{
    // instance variables
    private String _zip;
    private int _checkDigit;
    private int sumDigits1;

    // constructors
    //precondition: _zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    public Barcode(String zip) {
	if(zip.length()==5&&checkDigits(zip)){
	    for(int i=0;i<zip.length();i++){
		sumDigits1+=Integer.parseInt(zip.substring(i,i+1));
	    }
	    _checkDigit=checkSum();
	    _zip=zip;
	}
	else{
	    throw new IllegalArgumentException();
	}
    }

    // postcondition: Creates a copy of a bar code.
    public Barcode clone(){
	Barcode x=new Barcode(_zip);
	x._zip=_zip;
	x._checkDigit=_checkDigit;
	return x;
	//String 
    }
    public int sum(){
	int sumDigits=0;
	for(int start=0;start<_zip.length();start++){
	    sumDigits+=Integer.parseInt(_zip.substring(start,start+1));
	}
	return sumDigits;
    }
    public boolean checkDigits(String a){
	for(int i=0;i<a.length();i++){
	    char b=a.charAt(i);
	    if(!(b>='0'&&b<='9')){
		return false;
	    }
	}
	return true;
    }
    // postcondition: computes and returns the check sum for _zip
    private int checkSum(){
	int sumDigits=0;
	// for(int i=0;i<zip.length();i++){
	//     sumDigits+=Integer.parseInt(zip.substring(i,i+1));
	// }
	return sumDigits1%10;
	//return _zip+_checkDigit;	  
    }
    private String zipAndCheckDigit(){
	return _zip+_checkDigit;
    }
    //postcondition: format zip + check digit + Barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	String retStr="";
	retStr+="|";
	for(int i=0;i<_zip.length()+1;i++){
	    if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==1){
		retStr+=":::||";
	    }
	    else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==2){
		retStr+="::|:|";
	    }
	    else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==3){
		retStr+="::||:";
	    }
	    else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==4){
		retStr+=":|::|";
	    }
	    else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==5){
		retStr+=":|:|:";
	    }
	    else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==6){
		retStr+=":||::";
	    }
	    else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==7){
		retStr+="|:::|";
	    }
	    else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==8){
		retStr+="|::|:";
	    }
	    else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==9){
		retStr+="|:|::";
	    }
	    else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==0){
		retStr+="||:::";
	    }
	}
	retStr+="|";
	return retStr;
    }


    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	return zipAndCheckDigit().compareTo(other.zipAndCheckDigit());
    }
    public static void main(String[] args){
    }
    
}
