package com.snakhawa;

import java.util.HashMap;

public class flattenMap {

    /**
     * Flatten a Dictionary
     * A dictionary is a type of data structure that is supported natively in all major interpreted languages such as JavaScript, Python, Ruby and PHP,
     * where it’s known as an Object, Dictionary, Hash and Array, respectively.
     * In simple terms, a dictionary is a collection of unique keys and their values.
     * The values can typically be of any primitive type (i.e an integer, boolean, double, string etc) or other dictionaries (dictionaries can be nested).
     * However, for this exercise assume that values are either an integer, a string or another dictionary.
     *
     * Given a dictionary dict, write a function flattenDictionary that returns a flattened version of it .
     *
     * If you’re using a compiled language such Java, C++, C#, Swift and Go,
     * you may want to use a Map/Dictionary/Hash Table that maps strings (keys)
     * to a generic type (e.g. Object in Java, AnyObject in Swift etc.) to allow nested dictionaries.
     *
     * If a certain key is empty, it should be excluded from the output (see e in the example below).
     * @param args
     */
    public static void main(String[] args) {
        HashMap<String, Object> dict = new HashMap<String, Object>();
        dict.put("key1", "1");

        HashMap<String, Object> c = new HashMap<String, Object>();
        c.put("d", "3"); c.put("e", "1");

        HashMap<String, Object> key2 = new HashMap<String, Object>();
        key2.put("a", "2"); key2.put("b", "3"); key2.put("c", c);

        dict.put("key2", key2);

        flattenDictionary(dict);

    }

    public static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        // your code goes here
        HashMap<String, String> ans = new HashMap<>();
        flatten("",dict, ans);
        return ans;
    }

    private static void flatten(String initKey, HashMap<String, Object> dict, HashMap<String,String> ans) {
        for(String key: dict.keySet()){
            Object val = dict.get(key);

            if(!(val instanceof HashMap)){
                if(initKey == null || initKey == ""){
                    ans.put(key, (String) val);
                }else{
                    ans.put(initKey + "." + key, (String) val);
                }
            }
            else
            {
                HashMap<String,Object> map = (HashMap) val;
                if(initKey == null || initKey == ""){
                    flatten(key, map, ans);
                }else{
                    flatten(initKey + "." + key, map, ans);
                }
            }
        }
    }
}
