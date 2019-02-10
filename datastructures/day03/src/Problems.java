import java.awt.*;
import java.util.*;
import java.util.List;

public class Problems {

    public static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            next = null;
        }
    }

    public static List<Integer> removeKDigits(int[] A, int k) {
        // TODO: your code here
        // For now, return a List that's correct size, but contains only 0s
        /*
        List<Integer> l = new LinkedList<>();
        List<Integer> v = new LinkedList<>();
        List<Integer> b = new LinkedList<>();
        for (int j = 0; j<A.length; j++){
            v.add(A[j]);
        }
        int countprev=0;
        int count2= 0;
        int j = 1;
        int count = 0;
        while(count<(k)){
            System.out.println(v);
            System.out.println(j);
            System.out.println(count);
            System.out.println(countprev);
            if (count<k) {
                if ((v.get(j-1)>v.get(j))){
                    v.remove(j-1);
                    count++;
                    j--;
                    if (count-countprev>=2){
                        j=j-1;
                    }
                }
                else{
                    countprev=count;
                }
            }
            j++;
            if (j>=v.size()){
                j=1;
                count2++;
            }
            if (count2>10){
                for (int p = 0; p<k-1; p++){
                    if (A[p]<A[p+1]) {
                        b.add(A[p]);
                    }
                }
                if (b.size()==k-1) {
                    return b;
                }
            }
        }
        return v;
        */
        Stack <Integer> pancake = new Stack();
        int len = A.length;
        int count= 0;

        for (int i = 0; i<len; i++){
            while(!pancake.isEmpty() && A[i]<pancake.peek() && count<k){
                pancake.pop();
                count++;
            }

            if (pancake.size()<len-k){
                pancake.push(A[i]);
            }
        }
        return pancake;
    }

    public static boolean isPalindrome(Node n) {
        // TODO: your code here
        //List<Integer> l = new LinkedList<>();
        //List<Integer> v = new LinkedList<>();
        if (n==null){
            return true;
        }
        if (n.next==null){
            return true;
        }
        Node current = n;
        Node ex=n;
        Node bi=n;
        int size = 0;
        while (current!= null){
            current = current.next;
            size++;
        }

        int mid =size/2 + size%2;
        int exsize= size;

        current=n;

        while(exsize>mid){
            current=current.next;
            exsize--;
        }

        Node prev= null;
        while(current!=null){
            Node temp = current.next;
            current.next=prev;
            prev = current;
            current = temp;
        }
        current=prev;

        if(current==null){
            System.out.println("Fuck");
        }

        Node v = n;
        Node o = current;

        while(v!=null){
            System.out.println(v.val);
            v=v.next;
        }
        System.out.println("f");
        while(o!=null){
            System.out.println(o.val);
            o=o.next;
        }

        System.out.println("c");


         v = n;
         o = current;

        while(v!=null){
            System.out.println(v.val);
            v=v.next;
        }
        System.out.println("f");
        while(o!=null){
            System.out.println(o.val);
            o=o.next;
        }

        int boi =0;

        int j=0;


        while(j<mid){
            if (n.val==current.val){
                boi++;
                current=current.next;
                n=n.next;
            }
            else{
                return false;
            }
            if (boi==(size/2)+size%2){
                return true;
            }
            j++;
        }

        /*
        while (current.next != null){
            l.add(current.val);
            current = current.next;
            if (current.next==null){
                l.add(current.val);
            }
        }
   ;    current=n;
        while (current.next !=null){
            v.add(0,current.val);
            current = current.next;
            if (current.next==null){
                v.add(0,current.val);
            }
        }

        int count = 0;
        for (int i = 0; i < l.size();i++){
            System.out.println(l.get(i));
            System.out.println(v.get(v.size()-1-i));
            if (l.get(i)==v.get(i)){
                count++;
            }
        }
        if (count==l.size()){
            return true;
        }
        else {
            return false;
        }
        */
        return false;
    }

    public static String infixToPostfix(String s) {
        // TODO
        boolean num= true;
        Stack <Character> basic = new Stack();
        String str="";

        for (int i = 0; i < s.length(); i++) {
            char charca = s.charAt(i);
            if (Character.isDigit(charca)) {
                str+=((charca) + " ");
            }

            if (((charca=='*') || (charca=='+'))){
                basic.push(charca);
            }
            if (charca==')'){
                str+=(basic.pop() + " ");
            }
        }
        System.out.println(basic);
        str.trim();
        return str.trim();
        /*
        for (int i = 0; i < s.length(); i++) {
            try {
                Integer.parseInt(s.substring(i, i + 1));
            } catch (NumberFormatException nfe) {
                num = false;
            }
            if (num == false & pokki.charAt(i) != '(' & pokki.charAt(i) != ')' & pokki.charAt(i) != ' ') {
                beck.add(s.substring(i, i + 1));
            }
            num = true;
        }
        System.out.println(beck);
        String myNewString = beck.peek();
        beck.remove();
        for (String i : beck) {
            myNewString += " " + i;
        }

        return myNewString;

        String yarn = "";
        Stack <String> pankakke = new Stack();
        for(int k = 0; k<s.length();k++){
            if (s.substring(k,k+1)!=")" & s.substring(k,k+1)!=" "){
                pankakke.push(s.substring(k,k+1));
            }
            if (s.substring(k,k+1)==")"){
                yarn+= (" " +  pankakke.pop());
                String g = pankakke.pop();
                yarn+= " " + pankakke.pop();
                yarn+= " " + g;
                k++;
            }
            System.out.println(pankakke);
            System.out.println(yarn);
        }
        return yarn;
        */
    }

}
