import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Kata7 {
    public static int getCount(String str) {

        Pattern pattern=Pattern.compile("[aeiou]");
        Matcher matcher= pattern.matcher(str);

        return (int)matcher.results().count();
    }
    public static String disemvowel(String str) {
        return str.replaceAll("(?i)a|e|i|o|u","");
    }
    public static int squareDigits(int n) {
        String st=""+n;
        String r="";
        for(char i : st.toCharArray() )
        {
            r+=Integer.parseInt(i+"")*Integer.parseInt(i+"");
        }
        return Integer.parseInt(r);
    }
    public static String highAndLow(String numbers) {
        String[] splited=numbers.split(" ");
        int max=Integer.parseInt(splited[0]);
        int min=Integer.parseInt(splited[0]);
        for(String i :splited){
            if(max<Integer.parseInt(i)){max=Integer.parseInt(i);}
            if(min>Integer.parseInt(i)){min=Integer.parseInt(i);}
            System.out.println(i);
        }
        //System.out.println(max+" "+min);

        return max+" "+min;
    }
    public static int sortDesc(final int num) {

        char []srt=Integer.toString(num).toCharArray();
        int [] ne=new int[srt.length];

        for(int i=0;i<srt.length;i++){
            ne[i]=Character.digit(srt[i],10);
        }
        Arrays.sort(ne);
        StringBuilder h=new StringBuilder();
        for(int i=ne.length-1;i>=0;i--) {
            h.append(ne[i]);
        }
        return Integer.parseInt(h.toString());

    }
    public static List<Object> filterList(final List<Object> list) {
        List list2=new ArrayList();
        for (Object i : list) {
            if(i.getClass()== Integer.class){list2.add(i);}
        }
            return list2;
        }
    public static String getMiddle(String word) {
      int l=word.length();

      if(l==0){return null;}
      if(l==1){return word;}
      if(l%2==0){//pair
          return (word.charAt((l/2)-1)+"")+(word.charAt(l/2)+"");
      }
      if(l%2==1){//odd
         return word.charAt((l-1)/2)+"" ;
      }
      return null;
    }
    public static boolean isSquare(int n) {
        if(n<=0)return false;
        double r=Math.sqrt(n);
        if(r%1==0) return true;
        return false;
    }
    public static String accum(String s) {
        char[] tab=s.toCharArray();
        String result="";
        for(int i =0;i< tab.length;i++){
            result+=Character.toUpperCase(tab[i]);
            for(int j=1;j<=i;j++){
                result+=Character.toLowerCase(tab[i]);
            }
            result+="-";
        }
        return result.substring(0,result.length()-1);
    }
    public static boolean  isIsogram(String str) {
        HashSet<Character> set=new HashSet<Character>();
        for(Character c: str.toCharArray()){
            if(set.contains(Character.toLowerCase(c))) return false;
            set.add(Character.toLowerCase(c));
        }
        return true;
    }
    public static boolean getXO (String str) {
        str=str.toLowerCase();
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('o',0);
        map.put('x',0);
        for(Character c : str.toCharArray()){
            if(c=='x' || c=='o') map.replace(c,map.get(c)+1);
        }
        return map.get('o')==map.get('x');
    }
    public static String toJadenCase(String phrase) {
        if(phrase==null || phrase=="") return null;
        LinkedList<String>list=new LinkedList<>();
        String result="";
        for(String s: phrase.split(" ")){
            list.add(s);
            result+=Character.toUpperCase(s.charAt(0))+s.substring(1)+" ";
        }
        return result.substring(0,result.length()-1);
    }
    public static int findShort(String s) {
        int min=10000;
        for(String i: s.split(" ")){
            if(min>i.length()){min=i.length();}
        }
        return min;
    }
    public static String makeComplement(String dna) {
        dna=dna.replaceAll("[A]","t");
        dna=dna.replaceAll("[T]","A");
        dna=dna.replaceAll("[t]","T");
        dna=dna.replaceAll("[C]","t");
        dna=dna.replaceAll("[G]","C");
        dna=dna.replaceAll("[t]","G");
        return dna;
    }
    public static String maskify(String str) {
        //throw new UnsupportedOperationException("Unimplemented");
        if(str.length()<=4 || str=="") return str;
        String firstPart=str.substring(0,str.length()-4);
        String secondPart=str.substring(str.length()-4,str.length());
        firstPart=firstPart.replaceAll(".","#");
        return firstPart+secondPart;
    }
    public static long sumTwoSmallestNumbers(final long [] numbers) {
        long[] tab = numbers;
        Arrays.sort(tab);
        return tab[0]+tab[1];
    }
    public int GetSum(int a, int b){
        if(a==b)return a;
        int result=0;
        if(a>b){
            for (int i=b; i <=a ;i++) {
                result+=i;
            }
        }
        else {
            for (int i = a; i <= b; i++) {
                result += i;
            }
        }
        return result;
    }
    public static String longest (String s1, String s2) {
        TreeSet<Character> set=new TreeSet<>();
        for(char a:s1.toCharArray()){
            set.add(a);
        }
        for(char a:s2.toCharArray()){
            set.add(a);
        }
        String res="";
        for(char a:set){
            res+=a;
        }
        return res;
    }
    public static long findNextSquare(long sq) {
        if (Math.sqrt(sq)%1!=0)return -1;
        long next=sq+1;
        while(Math.sqrt(next)%1!=0){
            next++;
        }

        return next;
    }
    public static String printerError(String s) {
        int d= s.length();
        int n= 0;
        for (int i = 0; i < s.length(); i++) {
            if(Integer.valueOf(s.charAt(i))>109)n++;
        }
        return""+n+"/"+d;
    }
    public static boolean solution(String str, String ending) {
        if(str.length()<ending.length())return false;
        StringBuilder srtRev=new StringBuilder(str).reverse();
        StringBuilder EndingRev=new StringBuilder(ending).reverse();

        for (int i =0;i< ending.length() ; i++) {
            if(srtRev.charAt(i)!=EndingRev.charAt(i)) return false;
        }

        return true;
    }
}
