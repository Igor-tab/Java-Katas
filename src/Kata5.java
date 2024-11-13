import java.awt.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Kata5 {
    public static String pigIt(String str) {
        String res = "";
        for (String s : str.split(" ")) {
            if (s.equals("!") || s.equals(",") || s.equals(".") || s.equals("?")) {
                res += s + " ";
            } else res += s.substring(1) + s.charAt(0) + "ay" + " ";
        }
        return res.substring(0, res.length() - 1);
    }
    public static String makeReadable(int seconds) {
        //if(seconds==0) return "00:00:00";
        int hour = (int) seconds / 3600;
        int minute = (int) ((seconds - (hour * 3600)) / 60);
        int sec = (int) (seconds - (minute * 60) - (hour * 3600));
        String result = "";

        if (hour < 10) result += "0" + Integer.toString(hour) + ":";
        else result += Integer.toString(hour) + ":";
        if (minute < 10) result += "0" + Integer.toString(minute) + ":";
        else result += Integer.toString(minute) + ":";
        if (sec < 10) result += "0" + Integer.toString(sec);
        else result += Integer.toString(sec);

        return result;
    }
    public static String[] dirReduc(String[] arr) {
        LinkedList<String> list=new LinkedList<>();
        int in,out;
        for (int i = 0; i < arr.length; i++) {list.add(arr[i]);}
        list.add("Stop");
        list.forEach(System.out::println);
        in= list.size();
        out=0;
        while(out!=in) {
            in= list.size();
            for (int i = 0; i < list.size()-1; i++) {
                if (!compare(list.get(i), list.get(i+1))) {
                    list.set(i,"Kill");
                    list.set(i + 1,"Kill");
                }
               list.forEach(System.out::println);
            }
            list.remove("Kill");
            out= list.size();
            list.forEach(System.out::println);
        }
        list.removeLast();
        return list.toArray(new String[list.size()]);

    }
    public static boolean compare(String a,String b){

        if(a==b) return true;
        if(a=="NORTH"&&b=="SOUTH") return false;
        if(b=="NORTH"&&a=="SOUTH") return false;
        if(b=="EAST"&&a=="WEST") return false;
        if(a=="EAST"&&b=="WEST") return false;

        return true;
    }
    public static String rgb(int r, int g, int b) {
        int[] tab = {r, g, b};
        String result = "";
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<String> listR=new ArrayList<>();

        for (int n : tab) {
            System.out.println("iterating over tab and @ "+ n);
            if (n <= 0) {
                System.out.println("in <0 ");
                list.add(0);
                list.add(0);
                list.forEach(System.out::println);
            } else if (n>255) {
                list.add(15);
                list.add(15);
            } else if (n < 10) {
                System.out.println("in <10 ");
                list.add(0);
                list.add(n);
                list.forEach(System.out::println);
            }
            else {

                int tmp1 = (n / 16);
                System.out.println(tmp1);
                int tmp2 = n - (tmp1 * 16);
                list.add(tmp1);
                list.add(tmp2);
                System.out.println("in tmp ");
                list.forEach(System.out::println);
            }
        }
        list.forEach(integer ->{
            if (integer == 10) listR.add("A");
            else if (integer == 11)  listR.add("B");
            else if (integer == 12)  listR.add("C");
            else if (integer == 13) listR.add("D");
            else if (integer == 14) listR.add("E");
            else if (integer == 15) listR.add("F");
            else listR.add(""+integer);
        } );
        for(String mot :listR){
            result+=mot;
        }
        return result;

    }
    public static int sequence(int[] arr) {
        if(arr==null||arr.length==0) return 0;
        int max=IntStream.of(arr).sum();
        int globalMax=IntStream.of(arr).max().getAsInt();
        globalMax = (max>globalMax)? max:globalMax; // define global max to compare
        if(globalMax<=0) return 0; // if only 0 or negative values in input array
        int maxL=0;//Arrays.stream(Arrays.copyOfRange(arr,0,arr.length-1)).sum();
        int maxR=0;//Arrays.stream(Arrays.copyOfRange(arr,1,arr.length)).sum();
        //create array list for easier manipulation
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(Integer i:arr){list.add(i);}
        while (list.size()>1) {
            maxL=list.subList(0,list.size()-1).stream().reduce(0,Integer::sum);
            System.out.println("maxL " + maxL);
            maxR=list.subList(1,list.size()).stream().reduce(0,Integer::sum);
            System.out.println("maxR "+maxR);

            if (maxL > maxR) {
                list.remove(list.size()-1);
                System.out.println("maxL is bigger ");
            }
            else if (maxR>maxL) {
                list.remove(0);
                System.out.println("maxR is bigger ");
            }
            else{
                System.out.println(" maxR==maxL");
                System.out.println(list.get(0));
                System.out.println(list.get(list.size()-1));
                if(list.get(1)>=list.get(list.size()-2)){
                    list.remove(list.size()-1);
                }
                else list.remove(0);



            }
            if(globalMax<maxL) globalMax=maxL;
            if(globalMax<maxR) globalMax=maxR;

        }
        return globalMax;
    }
    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        int[] tab=new int[recipe.size()];
        int i=0;
        for (String s: recipe.keySet()) {
           if(available.containsKey(s)){
               //System.out.println(s);
               //System.out.println(available.get(s));
               tab[i]=available.get(s)/recipe.get(s);
              // System.out.println(available.get(s)/recipe.get(s));
           i++;
           }
           else i++;

        }
        return Arrays.stream(tab).min().getAsInt();
    }
    public static long Binet(int n){
        double phi=(1+Math.sqrt(5))/2;
        return (long) ((Math.pow(phi,n) - Math.pow(-phi,-n))/Math.sqrt(5));
    }
    public static int Iterate(int n){
        if(n==0 || n==1){return n;}

        int Sn;
        int S1=1;
        int S0=0;

        for(int i=2; i <= n ; i++){

            Sn=S1+S0;
            S0=S1;
            S1=Sn;

        }
        return S1;

    }
    public static long[] productFib(long prod) {
        long result=0;
        int index=0;
        for (int i = 0; result < prod ; i++) {
            result+=Math.pow(Binet(i),2);
            index=i;
        }
        if(result==prod){return new long[]{Binet(index),Binet(index+1),1};}
        else return new long[]{Iterate(index),Iterate(index+1),0} ;
    }
    public static String firstNonRepeatingLetter(String s){
        if(s.length()==1)return s; //if only one char then return s
        StringBuilder str=new StringBuilder(s.toLowerCase()); //moldable string
        for(int j=0;j<s.length();j++){// for every char in original string
            char c=s.toLowerCase().charAt(j);
            System.out.println("lookiong at = "+c);
            str.deleteCharAt(j);//delete current so no duplicates
           // System.out.println(strTmp.toString().contains(c+""));
            if(!str.toString().contains(c+"")){
                System.out.println(str.toString().contains(c+""));
                return ""+s.charAt(j);
            }
            str=new StringBuilder(s.toLowerCase());
        }return "";
    }
    public static int sumChars(String s){
        int result=0;
        for (int i = 0; i < s.length(); i++) {
            result+=Character.digit(s.charAt(i),10);


        }
        System.out.println(result);
        return result;
    }
    public static String orderWeight(String strng) {
        ArrayList input=new ArrayList<>();
        ArrayList weight=new ArrayList<>();

        String result="";
        for(String s : strng.split(" ")){
            input.add(Integer.parseInt(s));
            weight.add(sumChars(s));

        }
        weight.sort(Comparator.naturalOrder());
        return "";
    }
    public static String incrementString(String str) {//need to account for biger numbers than long + 1 chars
        if(str=="")return "1";
        Character a=str.charAt(str.length()-1);
        if(!Character.isDigit(a)) return str+"1";
        long newEnd=0;
        int indexForSubstring=0;
        for (int i = str.length()-1; ; i--) {
            a=str.charAt(i);
            if(Character.isDigit(a)) {
                BigInteger p=new BigInteger(""+Math.pow(10,(str.length()-1)-i));
                //newEnd += BigInteger.valueOf(a+"") * p;
                indexForSubstring = i;
            }
            else break;
        }
        newEnd++;
        final int numberZeroes=str.length()-indexForSubstring;
        String l=String.format("%0"+numberZeroes+"d",newEnd);
        return str.substring(0,indexForSubstring)+ l; // you code here
    }
    public static void main(String[] args) {
        System.out.println(incrementString("Klope"));



    }
}



