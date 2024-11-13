import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedList;

public class Kata6 {
    public static int solution(int number) {
        int cnt=0;
        for(int i=0;i<number;i++){
            if(i%3==0 || i%5==0){
                cnt+=i;}
        }
        return  cnt;
    }
    public static String spinWords(String sentence) {
        String result="";
        System.out.println(Arrays.toString(sentence.split(" ")));
        for(String s:sentence.split(" ")){
            System.out.println(s);
            if(s.length()>4){
                result += new StringBuilder(s).reverse()+" ";
                System.out.println(result);
            }
            else{
                result+=s+" ";
                System.out.println(result);
            }
        }
        return result.substring(0,result.length()-1);
    }
    public static String whoLikesIt(String... names) {
        switch (names.length){
            case 0 ->{return "no one likes this";}
            case 1 ->{return names[0]+" likes this";}
            case 2 ->{return names[0]+" and "+names[1]+" like this";}
            case 3 ->{return names[0]+", "+names[1]+" and "+names[2]+" like this";}
            default -> {return names[0]+", "+names[1]+" and "+ (names.length-2)+" others like this";}
        }
    }
    public static int findIt(int[] a) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(a[0],1);

        for(int i=1;i<a.length;i++){
            if(!map.containsKey(a[i])){
                map.put(a[i],1);
            }
            else{
                map.replace(a[i],map.get(a[i])+1);

            }
        }
        for(int i: map.keySet()){
           System.out.println(map.get(i)%2);
           System.out.println(i);
           if(map.get(i)%2==1){
               System.out.println(i);
               return i;
           }
           }
        return 0;
        }
    public static BigInteger Sn(int n){
        int r=0;
        for(int i=1;i<=n;i++){
            r+=i;
        }
        return new BigInteger(String.valueOf(r));
    }
    public static int Zn(int n){
        int result=(0);
        int j=n;
        for(int i=1;i<=n;i++){
            result+=i*j;
            j--;
        }
        return result;
    }
    public static BigInteger BigZn(int n){
        BigInteger result = new BigInteger("0");
        BigInteger j = new BigInteger(String.valueOf(n));
        for (BigInteger i = BigInteger.ONE; i.compareTo(j) < 0; i = i.add(BigInteger.ONE)){
            result = result.add(i.multiply(j));
            j = j.subtract(BigInteger.ONE);
        }
        return result;
    }
    public static int greedy(int[] dice){
        int[] cnt=new int[dice.length+2];
        int result=0;

        for(int i=0;i<dice.length;i++){
            cnt[dice[i]]+=1;
        }
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
        System.out.println(cnt[2]);
        System.out.println(cnt[3]);
        System.out.println(cnt[4]);
        System.out.println(cnt[5]);
        System.out.println(cnt[6]);
        for (int i = 1;i<cnt.length;i++){
            switch(i){
                case 1 -> {
                    if(cnt[i]==1){ result+=100;}
                    if(cnt[i]==2){ result+=200;}
                    if(cnt[i]==3){ result+=1000;}
                    if(cnt[i]==4){ result+=1100;}
                    if(cnt[i]==5){ result+=1200;}
                }case 2 -> {
                    if(cnt[i]==3){ result+=200;}
                    if(cnt[i]==4){ result+=200;}
                }case 3 -> {
                    if(cnt[i]==3){ result+=300;}
                    if(cnt[i]==4){ result+=300;}
                }case 4 -> {
                    if(cnt[i]==3){ result+=400;}
                    if(cnt[i]==4){ result+=400;}
                }case 5 -> {
                    if(cnt[i]==1){ result+=50;}
                    if(cnt[i]==2){ result+=100;}
                    if(cnt[i]==3){ result+=500;}
                    if(cnt[i]==4){ result+=550;}
                    if(cnt[i]==5){ result+=600;}
                }case 6 -> {
                    if(cnt[i]==3){ result+=600;}
                    if(cnt[i]==4){ result+=600;}
                }

            }

        }


        return result;
    }//not done yet WIP!
    public static int[] snail(int[][] array){
        // LinkedList<Integer> result=new LinkedList<Integer>();
        int i=0;
        int j=0;
        int m = array.length - 1;
        int k = 0;
        int l = m;
        if(m%2!=0) {
            for (int r = 0; r <= m; r++) {
                k += r;
                l -= r;
                for (i = r; i < array.length; i++) {
                    System.out.println(array[k][i]);
                    if (k == l) return null;
                }
                for (j = r; j < array.length; j++) {
                    System.out.println(array[j][l]);
                    if (k == l) return null;
                }
                for (int n = m - r; n >= 0; n--) {
                    System.out.println(array[l][n]);
                    if (k == l) return null;
                }
                for (int n = m - r; n > 0; n--) {
                    if(n==l) return null;
                    System.out.println(array[n][l]);
                }
            }
        }
        else {
            for (int r = 0; r <= m; r++) {
                k += r;
                l -= r;
                for (i = r; i < array.length; i++) {
                    System.out.println(array[k][i]);
                    if (k == l) return null;
                }
                for (j = r; j < array.length; j++) {
                    System.out.println(array[j][l]);
                    if (k == l) return null;
                }
                for (int n = m - r; n >= 0; n--) {
                    System.out.println(array[l][n]);
                    if (k == l) return null;
                }
                for (int n = m - r; n > 0; n--) {
                    System.out.println(array[n][l]);
                    if (k == l) return null;
                }
            }
        }
        return null;
    } // not done yet WIP!
    public static String[] towerBuilder(int nFloors) {
        if (nFloors == 0) return null;
        String[] tower = new String[nFloors];
        tower[0] = "*";
        System.out.println(tower[0].format("%" + nFloors + "s", tower[nFloors - 1]));
        int tmp = nFloors;
        for (int i = 1; i < nFloors; i++) {
            tower[i] = "*" + tower[i - 1] + "*";
            System.out.println(tower[i].format("%" + i + "s", tower[i]));
        }
        return tower;
    }
    public static String CrossSum(int[][] matrix){
        int sumPDiag=0;
        int sumSDiag=0;
        int i =0;
        int j =0;
        while(i>=matrix.length-1){
            sumPDiag=sumPDiag+matrix[i][j];
            sumSDiag=sumSDiag+matrix[matrix.length-i][j];
        }
        if(sumSDiag>sumPDiag) return "Secondary Diagonal win!";
        else if (sumSDiag>sumPDiag) {return "Principal Diagonal win!";}
        return "Draw!";
    }
    public static int[] arrayDiff(int[] a, int[] b) {
        //Integer[] aAsInteger = new Integer[a.length];
        //Arrays.setAll(aAsInteger, i -> a[i]);
        LinkedList<Integer> listLookUp=new LinkedList();

        for(int i:a){//add all elements of a to linked list
            System.out.println(i);
            listLookUp.add(i);
        }

        for(int i=0;i<b.length;i++){//for all int in b
            System.out.println(b[i]);
            while(listLookUp.contains(Integer.valueOf(b[i]))){//look if is in linked list
                System.out.println(b[i] + " will be removed");
                System.out.println("items in Liked lsit= "+ listLookUp.size());
                listLookUp.remove(Integer.valueOf(b[i]));
            }
            System.out.println(b[i] + " is removed");
        }
        int [] re=new int [listLookUp.size()];
        for (int i = 0; i < listLookUp.size(); i++) {
           re[i]=listLookUp.get(i);
        }

        return re;
    }
    public static int digital_root(int n) {
        String number=""+n;
        int sum=0;
        for (int i = 0; i < number.length(); i++) {
            sum+=Character.getNumericValue(number.charAt(i));
            System.out.println(Character.getNumericValue(number.charAt(i)));
        }
        if((int)sum/10==0) return sum;
        return digital_root(sum);
    }
    public static int countBits(int n){
        String biN=Integer.toBinaryString(n);
        int cnt=0;
        for (int i = 0; i < biN.length(); i++) {
            if(biN.charAt(i)=='1')cnt++;
        }
        return cnt;
    }
    static int find(int[] integers) {
        if (integers[0]% 2!=0 && integers[1]% 2!=0){
            for (int integer : integers) {
                if (integer % 2==0) return integer;
            }
        }
        if (integers[0]% 2==0 && integers[1]% 2==0) {
            for (int integer : integers) {
                if (integer % 2 != 0) return integer;

            }
        }
        if (integers[0]% 2==0 && integers[1]% 2!=0 && integers[2]% 2==0)  return integers[1];
        if (integers[0]% 2!=0 && integers[1]% 2==0 && integers[2]% 2==0)  return integers[0];
        if (integers[0]% 2!=0 && integers[1]% 2==0 && integers[2]% 2!=0)  return integers[1];
        if (integers[0]% 2==0 && integers[1]% 2!=0 && integers[2]% 2!=0)  return integers[0];
        return 0;
        }
    public static int duplicateCount(String text) {
        int count=0;
        HashMap<Character,Integer> map=new HashMap();
        for(char a: text.toLowerCase().toCharArray()){
           // System.out.println(a);
            if(map.containsKey(a)){
                //System.out.println(map.get(a));
                map.replace(a,map.get(a)+1);
            //System.out.println(map.get(a));
            }
            else map.put(a,1);
            //System.out.println(map.get(a));
        }
        for(Character a : map.keySet()){
            if(map.get(a)>1) count++;
        }
        return count ;
    }
}