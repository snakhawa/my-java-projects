package com.snakhawa.crackingthecode;

public class OneEdit {

    public static void main(String[] args){
//        System.out.println(oneEdit("test","tet"));
//        System.out.println(oneEdit("test","best"));
        System.out.println(oneEdit("aab","cc"));
    }

    public static boolean oneEdit(String s1, String s2){
        if(s1 == null || s2 == null || s1.length()==0 || s2.length() == 0) return false;
        if(Math.abs (s1.length() - s2.length()) > 1) return false;
        int[] table = new int[26];
        String longest = s1.length() > s2.length() ? s1: s2;
        String shortest = s1.length() > s2.length() ? s2 : s1;

        for(int i=0 ; i< longest.length(); i++){
            table[longest.charAt(i) -'a']++;
            if(!oob(shortest, i)){
                table[shortest.charAt(i) - 'a']--;
            }
        }

        int count = 0;
        for(int k: table){
            if(Math.abs(k) >=1){
                count++;
            }
        }

        return count <= 1;

    }

    public static boolean oob(String s, int index){
        return index < 0 || index > s.length()-1;
    }
}
