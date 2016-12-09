import java.util.*;
public class Barcode implements Comparable<Barcode>{
    // instance variables
    private String _zip;
    private int _checkDigit;
    private int sumDigits1;
    static String[] mappings=new String[]{"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    // mappings[0]="||:::";
    // mappings[1]=":::||";
    // mappings[2]="::|:|";
    // mappings[3]="::||:";
    // mappings[4]=":|::|";
    // mappings[5]=":|:|:";
    // mappings[6]=":||::";
    // mappings[7]="|:::|";
    // mappings[8]="|::|:";
    // mappings[9]="|:|::";
    static ArrayList<String> m=new ArrayList<String>(Arrays.asList(mappings));

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
	    // mappings[0]="||:::";
	    // mappings[1]=":::||";
	    // mappings[2]="::|:|";
	    // mappings[3]="::||:";
	    // mappings[4]=":|::|";
	    // mappings[5]=":|:|:";
	    // mappings[6]=":||::";
	    // mappings[7]="|:::|";
	    // mappings[8]="|::|:";
	    // mappings[9]="|:|::";
	    // m=new ArrayList<String>(Arrays.asList(mappings));
	}
	else if(zip.length()!=5){
	    throw new IllegalArgumentException("Length of zip needs to be 5");
	}
	else if(!checkDigits(zip)){
	    throw new IllegalArgumentException("Zip can only have int digits");
	}
	//	else{
	//   throw new IllegalArgumentException();
	//	}
    }
    public static boolean checkBarcode(String bar){
	if(bar.length()!=32){
	    throw new IllegalArgumentException("Barcode is not 32 characters long");
	}
	else if(!(bar.substring(0,1).equals("|"))||!(bar.substring(31,32).equals("|"))){
	    throw new IllegalArgumentException("Barcode doesn't start/end with a |");
	}
	for(int i=0;i<bar.length();i++){
	    if(!(bar.substring(i,i+1).equals("|"))&&!(bar.substring(i,i+1).equals(":"))){
		throw new IllegalArgumentException("Invalid characters.  Only : and | allowed");
	    }
	}
	for(int a=1;a<bar.length()-5;a=a+5){
	    int count=0;
	    for(int b=0;b<mappings.length;b++){
		if(!(bar.substring(a,a+5).equals(mappings[b]))){
		    count+=1;
		}
	    }
	    if (count==10){
		throw new IllegalArgumentException("Some sets of symbols don't have corresponding int values");
	    }
	}
	return true;
	
    }
    public static String toCode(String zip){
	if(zip.length()==5&&checkDigits(zip)){
	    int cDigit=0;
	    //int sumDig=0;
	    String s="";
	    s+="|";
	    for(int i=0;i<zip.length();i++){
		s+=mappings[Integer.parseInt(zip.substring(i,i+1))];
	    }
	    //for(int a=0;a<zip.length();a++){
	    //	sumDig+=Integer.parseInt(zip.substring(a,a+1));
	    //}
	    // cDigit=sumDig%10;
	    cDigit=checkSum(zip);
	    s+=mappings[cDigit];
	    s+="|";
	    return s;
	}
	else{
	    throw new IllegalArgumentException("Invalid zip");
	}
    }
    public static String toZip(String code){
	String s="";
	int cDigit=0;
	int sumDig=0;
	if(checkBarcode(code)){
	    for(int a=0;a<m.size();a++){
		if(code.substring(26,31).equals(m.get(a))){
		    cDigit=a;
		}
	    }
	    for(int c=1;c<code.length()-6;c=c+5){
		for(int b=0;b<m.size();b++){
		    if(code.substring(c,c+5).equals(m.get(b))){
			sumDig+=b;
		    }
		}
	    }
	    if(cDigit==sumDig%10){
		for(int start=1;start<code.length()-6;start=start+5){
		    for(int i=0;i<mappings.length;i++){
			if (code.substring(start,start+5).equals(mappings[i])){
			    s=s+""+i;
			}
		    }
		}
		return s;
	    }
	    else{
		throw new IllegalArgumentException("Invalid checksum/check digit");
	    }
	}
	else{
	    throw new IllegalArgumentException("Invalid zipcode");
	}
    }
    // postcondition: Creates a copy of a bar code.
    // public Barcode clone(){
    // 	Barcode x=new Barcode(_zip);
    // 	x._zip=_zip;
    // 	x._checkDigit=_checkDigit;
    // 	return x;
    // 	//String 
    // }
    public int sum(){
	int sumDigits=0;
	for(int start=0;start<_zip.length();start++){
	    sumDigits+=Integer.parseInt(_zip.substring(start,start+1));
	}
	return sumDigits;
    }
    public static boolean checkDigits(String a){
	for(int i=0;i<a.length();i++){
	    char b=a.charAt(i);
	    if(!(b>='0'&&b<='9')){
		return false;
	    }
	}
	return true;
    }
    // postcondition: computes and returns the check sum for _zip
    private static int checkSum(String zip){
	int cDigit=0;
	int sumDig=0;
	for(int a=0;a<zip.length();a++){
	    sumDig+=Integer.parseInt(zip.substring(a,a+1));
	}
	cDigit=sumDig%10;
	return cDigit;
    }
    private int checkSum(){
	int sumDigits=0;
	return sumDigits1%10;	  
    }
    private String zipAndCheckDigit(){
	return _zip+_checkDigit;
    }
    //postcondition: format zip + check digit + Barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	String retStr="";
	retStr+="|";
	for(int i=0;i<zipAndCheckDigit().length();i++){
	    retStr+=mappings[Integer.parseInt(zipAndCheckDigit().substring(i,i+1))];
	    // if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==1){
	    // 	retStr+=":::||";
	    // }
	    // else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==2){
	    // 	retStr+="::|:|";
	    // }
	    // else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==3){
	    // 	retStr+="::||:";
	    // }
	    // else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==4){
	    // 	retStr+=":|::|";
	    // }
	    // else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==5){
	    // 	retStr+=":|:|:";
	    // }
	    // else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==6){
	    // 	retStr+=":||::";
	    // }
	    // else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==7){
	    // 	retStr+="|:::|";
	    // }
	    // else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==8){
	    // 	retStr+="|::|:";
	    // }
	    // else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==9){
	    // 	retStr+="|:|::";
	    // }
	    // else if(Integer.parseInt(zipAndCheckDigit().substring(i,i+1))==0){
	    // 	retStr+="||:::";
	    // }
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
