package com.practice.leetcode.leetcode_practice;

import java.util.*;
import java.util.stream.Collectors;

public class PR01_JavaTipsAndTricks {
	/**
	 *  TODO
	 *   1. Explore Arrays and its tricks
	 *   2. Explore Hashmaps and its applications
	 *   3. Explore String Operations
	 */

	public static void main (String [] args){
		System.out.println("JAVA TIPS AND TRICKS - PR01");

		////////////////////ARRAYS////////////////////////
		System.out.print("////////////////////ARRAYS////////////////////////\n");
		int[] arr1 = new int[] {1,2,3,4,5,6,7};
		System.out.print("To String : " + Arrays.toString(arr1) + "\n");
		int[] cpyArr1 = Arrays.copyOf(arr1 , arr1.length);
		System.out.print("Copy Array : " + Arrays.toString(cpyArr1) + "\n");
		int[] cpyArr2a = new int[arr1.length/2];
		int[] cpyArr3a = new int[arr1.length - arr1.length/2];
		System.arraycopy(arr1,0,cpyArr2a,0,arr1.length/2);
		System.arraycopy(arr1, arr1.length/2 , cpyArr3a , 0, arr1.length - arr1.length / 2);
		System.out.print("Print Arr2a and Arr3a : " + Arrays.toString(cpyArr2a) + "\t" +  Arrays.toString(cpyArr3a) + "\n");
		int[] cpyArr2b = Arrays.copyOfRange(arr1 , 0 , arr1.length/2);
		int[] cpyArr3b = Arrays.copyOfRange(arr1, arr1.length/2 , arr1.length);
		System.out.print("Print Arr2b and Arr3b : " + Arrays.toString(cpyArr2b) + "\t" + Arrays.toString(cpyArr3b) + "\n");
		List<Integer> list1 = Arrays.stream(arr1).boxed().collect(Collectors.toList()); 
		int[] lstArr1 = list1.stream().mapToInt(Integer::intValue).toArray();
		System.out.print("Print list1 and listArr1 : " + Arrays.toString(list1.toArray()) + "\t" + Arrays.toString(lstArr1) + "\n");
		String [] strArr1 = new String[] {"ab", "cd" , "dc"};
		List<String> listStrArr1 = Arrays.asList(strArr1);
		String [] strArr2 = listStrArr1.toArray(new String[] {});
		System.out.print("Print listStrArr1 and strArr2 : " + Arrays.toString(listStrArr1.toArray()) + "\t" + Arrays.toString(strArr2));
		System.out.print("\n\n");


		////////////////////HASHAMP////////////////////////
		System.out.print("////////////////////HASHAMP////////////////////////\n");
		HashMap<Integer , Integer> hashMap1 = new HashMap<Integer , Integer>();
		hashMap1.put(1,5);
		hashMap1.put(2,4);
		hashMap1.put(3,3);
		hashMap1.put(4,2);
		hashMap1.put(5,1);
		System.out.print(" Print hashMap1 : " + "\n");
		hashMap1.entrySet().stream().forEach( entry -> { System.out.println(entry.getKey() + " ==> " + entry.getValue()); });

		HashMap<Integer, Integer> hashMap2 = (HashMap<Integer, Integer>) hashMap1.clone();
		System.out.print(" Print hashMap2 : " + "\n");
		hashMap2.entrySet().stream().forEach( entry -> { System.out.println(entry.getKey() + " ==> " + entry.getValue()); });
		LinkedHashMap<Integer, Integer> lnkHashMap1 =   hashMap2.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey , Map.Entry::getValue , (x,y) -> x , LinkedHashMap::new ));
		System.out.print(" Print lnkHashMap1 : " + "\n");
		lnkHashMap1.entrySet().stream().forEach( entry -> { System.out.println(entry.getKey() + " ==> " + entry.getValue()); });
		System.out.print("\n\n");

		////////////////////STRINGS////////////////////////
		System.out.print("////////////////////STRINGS////////////////////////\n");
		String str1 = "This  is a temp string str1 str1";
		System.out.print("Last Index Of Str1 : " + str1.lastIndexOf("is") + "\n");
		System.out.print("Substring of str1 : " + str1.substring(10 , str1.length()) + "\n");
		System.out.print("Contains 'is' of str1 : " + str1.contains("this") + "\n");

	}
}
