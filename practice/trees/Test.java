package com.practice.trees;

public class Test {



    public static void main(String[] args) {

        String s1 = "a";
        String s2 = "b";

        System.out.println(test(s1,s2));

    }

    static boolean test(String s1, String s2){

        if(s1.length()!=s2.length())
            return false;

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                sb1.append(s1.charAt(i));
                sb2.append(s2.charAt(i));
                if(sb1.length()>2)
                    return false;
            }
        }
        if(s1.length()==1)
            return true;

        if(new String(sb1.reverse()).equals(new String(sb2))){
            return true;
        }else {
            return false;
        }
    }

}
