package com.onejava.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1,3,5,6,8,9};
        int result = search(a, 5);
        System.out.println(result);
    }
    // Takes sorted array
    public static int search(int[] a, int k){
        int i= 0, j = a.length -1;
        while(i <= j){
            int mid = (i + j)/2;
            if(a[mid] == k){
                return mid;
            }
            else if(a[mid] > k){
                j = mid -1 ;
            }
            else{
                i = mid + 1;
            }

        }
        return -1;
    }
}
