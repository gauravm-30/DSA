package org.example.LinearSearch;

public class LS_String {
    public static void performLinearSearchOnString(){
        String  s1="Welcome to java world";
        int index=linearSearchString_V1(s1,'c');
        boolean isElementPresent=linearSearchString_V2(s1,'c');
        System.out.println("Linear Search Index: " + index);
        System.out.println("Linear Search isElementPresent: " + isElementPresent);
    }

    //search the character target and return the index
    private static int linearSearchString_V1(String string, char target) {
        if(string == null || string.isEmpty()){
            //ideally we should be throwing exception here
            return -1;
        }
        for (int i = 0; i < string.length(); i++) {
            if(target == string.charAt(i)){
                return i;
            }
        }

        return -1;
    }

    //search the character target and return the true/false
    private static boolean linearSearchString_V2(String string, char target) {
        if(string == null || string.isEmpty()){
            //ideally we should be throwing exception here
            return false;
        }
        for (char ch : string.toCharArray()){
            if(target==ch){
                return true;
            }
        }

        return false;
    }
}
