
package xyz.codingmentor.quicksort.main;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mhorvath
 */
public class Main {
    private static int[] arrayToSort ={1,25,3,2,5,3,5,5,6,2};
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    private Main() {
    }
    
    public static void main(String[] args) {
        quicksort(0, arrayToSort.length-1);
        LOGGER.log(Level.INFO,Arrays.toString(arrayToSort));
    }
    private static void quicksort(int minIndex,int maxIndex){
        if(maxIndex>minIndex){
        int pivotIndex=minIndex;
        int examinedElementIndex=minIndex+1;
        while (examinedElementIndex<=maxIndex) {
            if(arrayToSort[examinedElementIndex]<arrayToSort[pivotIndex]){
                swap(examinedElementIndex, pivotIndex+1);
                swap(pivotIndex, pivotIndex+1);
                pivotIndex++;
            }
            examinedElementIndex++;
        }
        quicksort(minIndex, pivotIndex-1);
        quicksort(pivotIndex+1, maxIndex);
        }
    }
    private static void swap(int index1, int index2){
        int temp;
        temp=arrayToSort[index1];
        arrayToSort[index1]=arrayToSort[index2];
        arrayToSort[index2]=temp;     
    }
   
}
