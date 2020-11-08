package com.practice.leetcode.leetcode_practice;
import java.util.*;
import java.util.Arrays;

public class PR04_TreePractice {
    
    public static int[] insertionSort(int[] arr){
        for(int i = 1 ; i < arr.length ; i++ ){
            int j = i;
            while( (j-1) >= 0 && arr[j] < arr[j-1]){
                int temp = arr[j-1];
                arr[j-1]= arr[j];
                arr[j] = temp;
                j--;
            }
        }
        return arr;
    }

    public static int[] mergeSort(int[] arr){
        mergeSortUtil(arr , 0 , arr.length - 1 );
        return arr;
    }

    public static void mergeSortUtil(int[] arr, int left ,int right){

        if(left < right){
            int mid = (left + right)/2; 
            mergeSortUtil(arr , left , mid);
            mergeSortUtil(arr, mid+1, right);
            finalMerge(arr, left ,mid,  right);
        }
        return;
    }

    public static void finalMerge(int[] arr, int  left , int mid , int right){
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        System.arraycopy(arr, left, leftArr, 0, leftArr.length);
        System.arraycopy(arr, mid+1, rightArr, 0, rightArr.length);

        int i = 0; int j = 0; int k = left;
        while(i < leftArr.length && j < rightArr.length){
            if(leftArr[i] < rightArr[j]){
                arr[k] = leftArr[i];
                i++;k++; continue;
            }else{
                arr[k] = rightArr[j];
                j++;k++;
            }
        }

        while(i < leftArr.length ){
            arr[k] = leftArr[i];
            i++;k++;
        }

        while(j< rightArr.length){
            arr[k] = rightArr[j];
            k++;j++;
        }
    }

    public static int[] quickSort(int [] arr){
        quickSortUtil(arr , 0 , arr.length -1);
        return arr;
    }

    public static void quickSortUtil(int[] arr , int left , int right){

        if(left < right){
            int part = partition(arr, left ,right);

            quickSortUtil(arr , left , part -1);
            quickSortUtil(arr , part+1 , right);
        }
    }

    public static int partition (int [] arr , int left ,int right){
        int pivot = arr[right];
        int i = left - 1;
        
        for(int j = left ; j <= right ; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr ,i , j);
            }
        }
        swap(arr , i+1 , right);
        return i+1;

    }

    public static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static int[] heapSort(int[] arr){

        for(int i = arr.length/2 - 1 ; i >=0 ; i--){
            heapify(arr , arr.length , i);
        }

        for(int i = arr.length - 1; i >= 0 ; i--){
            swap(arr , 0 ,i);
            heapify(arr, i , 0);
        }

        return arr;

    }

    public static int heapSortFind(int[] arr, int k){

        for(int i = arr.length/2 - 1 ; i >=0 ; i--){
            heapify(arr , arr.length , i);
        }

        // for(int i = arr.length - 1; i >= 0 ; i--){
        //     swap(arr , 0 ,i);
        //     heapify(arr, i , 0);
        // }
        int i = arr.length -1,j = k;
        while(j > 0){
            swap(arr, 0, i);
            heapify(arr , i , 0);j--;i--;
        }
        System.out.println(Arrays.toString(arr));
        return arr[arr.length - k ];

    }

    public static void heapify(int[] arr, int len , int index){

        int large = index;
        int l = 2*index;
        int r = 2*index + 1;

        if(l < len && arr[l] > arr[large]){
            large = l;
        }

        if(r < len && arr[r] > arr[large]){
            large = r;
        }

        if(large != index){
            swap(arr , large , index);
            heapify(arr , len , large);
        }
    }

    public static class Trie {
        HashMap<Character , Trie> charMap;
        Boolean isEnd;

        Trie(){
            charMap = new HashMap<>();
            isEnd = false;
        }

        void insert(String word){
            Trie curr = this;
            for(Character ch: word.toCharArray()){
                if(curr.charMap.containsKey(ch)){
                    curr = curr.charMap.get(ch);
                }else{
                    curr.charMap.put(ch, new Trie());
                    curr = curr.charMap.get(ch);
                }
            }

            curr.isEnd = true;
        }

        boolean search(String word){
            Trie curr = this;
            boolean isWord = searchUtil(word, curr);
            return isWord;
        }

        boolean searchUtil(String word , Trie root){
            
            for(Character ch : word.toCharArray()){
                if(root.charMap.containsKey(ch)){
                    root = root.charMap.get(ch);
                    continue;
                }else{
                    return false;
                }
            }

            return (root.isEnd == true) ? true:false;
        }
    }

    private static int solution(int N) {
        int flag = N >= 0 ? 1 : -1;
        N = Math.abs(N);
        String numStr = N + "";
        String[] numarr = numStr.split("");
        ArrayList<String> result = new ArrayList<>();
        boolean inserted = false;

        for (String tmpStr : numarr) {
            int tmp = Integer.parseInt(tmpStr);
            inserted = flag == 1 ? tmp < 5 : tmp > 5;
            if(inserted){
                result.add(50 + tmp + "");
                System.out.println(Arrays.toString(result.toArray()));
                break;
            }
            result.add(tmpStr);
        }

        // for(int i = 0 ; i < result.size() ; i++){
        //     System.out.print(result.get(i) + "\t");
        // }
        // System.out.print("\n");
        //System.out.println(Arrays.toString(result.toArray()));
        System.out.println(Arrays.toString(Arrays.asList(numarr).subList(result.size(), numarr.length).toArray()));
        result.addAll(Arrays.asList(numarr).subList(result.size(), numarr.length));
            
        if (!inserted) result.add("5");
        return flag * Integer.parseInt(String.join("", result));
    }

    public static int solution1(int A, int B) {
        int start = (int) Math.sqrt(A);
        int end = (int) Math.sqrt(B);
        System.out.println(start + "  " + end);
        int firstM = start * (start + 1);
        int endM = end * (end + 1);
        int includeFirst = firstM >= A && firstM <= B ? 1 : 0;
        int includeEnd = endM >= A && endM <= B ? 1 : 0;
        int result = end - start - 1 + includeFirst + includeEnd;
        return result >= 0 ? result : 0; //We need to do this as A can be equal to B
        }
        
    public static void main (String [] args){
        // System.out.println("Insertion Sort   " +  Arrays.toString(insertionSort(new int []{3,2,1,10,6,7})));
        // System.out.println("Merge Sort   " + Arrays.toString(mergeSort(new int []{3,2,1,10,6,7})));
        // System.out.println("Quick Sort   " + Arrays.toString(quickSort(new int []{3,2,1,10,6,7})));
         System.out.println("Heap Sort   " + Arrays.toString(heapSort(new int []{3,2,1,10,6,7})));
         System.out.println("Heap Sort   " + heapSortFind(new int []{3,2,1,10,6,7},3));

        // Trie root = new Trie();
        // root.insert("flow");
        // root.insert("flower");
        // root.insert("dog");


        // System.out.println("Is Word Prsent " + root.search("flow"));
        // System.out.println("Is Word Prsent " + root.search("flo"));
        // System.out.println("Is Word Prsent " + root.search("flowq"));

        // int N = solution(8000);
        // System.out.println(N);
        // int Q = solution1(6,20);
        // System.out.println(Q);

        //String str = "asd";
        StringBuilder str  = new StringBuilder("aaa");
        str = str.reverse();
    
    }

}
