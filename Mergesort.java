import java.util.Random;

public class Mergesort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10]; 

        for (int i = 0; i < numbers.length; i++){
            numbers[i] = rand.nextInt(100000);
        }
        
        System.out.println("before:");
        printArray(numbers);

        mergeSort(numbers);

        System.out.println("\nafter:");
        printArray(numbers);
    }

    private static void mergeSort(int[] inputArray){
        int inputLength = inputArray.length;

        //if it only has one/zero element
        if (inputLength < 2){
            return;
        }

        //divide portion 

        //created the arrays that contain the right and left half of the orignal array
        int midIndex = inputLength/2; 
        int[] leftHalf = new int[midIndex];
        //inputLength - midIndex to account for odd array lengths
        int[] rightHalf = new int[inputLength - midIndex]; 

        //left half
        for (int i = 0; i < midIndex; i++){
            leftHalf[i] = inputArray[i];
        }

        //right half
        for (int i = midIndex; i < inputLength; i++){
            rightHalf[i - midIndex] = inputArray[i]; 
        }

        //mergesort each halfarray

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
    }

    private static void merge (int[] inputArray, int[] rightHalf, int[] leftHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        //3 iterators to go through left, right, and merged
        
        //left
        int i = 0;
        //right
        int j = 0;
        //merged
        int k = 0;

        while (i < leftSize && j < rightSize){
            if (leftHalf[i] <= rightHalf[j]){
                inputArray[k] = leftHalf[i];
                i++;
            }
            else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        //cleanup incase there are elements left
        while (i < leftSize){
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightSize){
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }

    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
          System.out.println(numbers[i]);
        }
      }





}