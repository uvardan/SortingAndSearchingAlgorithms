package sortingAlgorithms;


import org.junit.jupiter.api.Test;
import shared.SharedFunctions;

import java.rmi.activation.ActivationGroup_Stub;

import static org.junit.jupiter.api.Assertions.assertTrue;

// Nice video: https://www.youtube.com/watch?v=emeME__917E
// Reference: https://www.geeksforgeeks.org/timsort/
public class TimSort
{
   final private static int RUN = 32;

   private static void mergeSort(int[] arr, int leftStartIndex, int middleIndex, int rightEndIndex)
   {
      final int kLeftArraySize = middleIndex - leftStartIndex + 1;

      // No need for +1 since we want elements after middleIndex
      final int kRightArraySize = rightEndIndex - middleIndex;
      // Create two arrays of correct sizes
      int[] leftArray = new int[kLeftArraySize];
      int[] rightArray = new int[kRightArraySize];

      // Copy elements into arrays

      // Copy left array
      for (int i = 0; i < kLeftArraySize; ++i)
      {
         leftArray[i] = arr[leftStartIndex + i];
      }

      // Copy right array
      for (int i = 0; i < kRightArraySize; ++i)
      {
         rightArray[i] = arr[middleIndex + i + 1];
      }

      // Now sort elements into array
      int leftArrayIndex = 0;
      int rightArrayIndex = 0;
      int finalArrayIndex = leftStartIndex;

      while (leftArrayIndex < kLeftArraySize && rightArrayIndex < kRightArraySize)
      {
         if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex])
         {
            arr[finalArrayIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
         }
         else
         {
            arr[finalArrayIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
         }

         finalArrayIndex++;
      }

      // Copy rest of elements
      while (leftArrayIndex < kLeftArraySize)
      {
         arr[finalArrayIndex] = leftArray[leftArrayIndex];
         leftArrayIndex++;
         finalArrayIndex++;
      }

      while (rightArrayIndex < kRightArraySize)
      {
         arr[finalArrayIndex] = rightArray[rightArrayIndex];
         rightArrayIndex++;
         finalArrayIndex++;
      }
   }

   @Test void checkMergeCorrectness()
   {
      int[] arr1 = {1, 4, 7};
      int[] arr2 = {3, 5, 6, 11};

      int[] arr = new int[arr1.length + arr2.length];

      mergeSort(arr, 0, 0 + (arr.length/2), arr.length - 1);

      if (!SharedFunctions.checkIfArrayIsSorted(arr))
      {
         SharedFunctions.printArrayToConsole(arr);
         assertTrue(SharedFunctions.checkIfArrayIsSorted(arr));
      }
   }

   public static void sortArray(int[] arr)
   {
      if (null == arr)
      {
         throw new IllegalArgumentException("Input array cannot be null!");
      }

      // sort sub-arrays for size RUN using insertionSort
      for (int i = 0; i < arr.length; i += RUN)
      {
         InsertionSort.sortArrayInRange(arr, i, Math.min((i + RUN - 1) , (arr.length - 1)));
      }

      // Once we have sorted sub-arrays, we need to merge them.
      // Array sizes with start with size RUN and then double after
      // every merge operation.
      for (int size = RUN; size < arr.length; size *= 2)
      {
         // Start at the first sub-array and merge two sub-arrays of length size
         // where size doubles on every iteration of outer loop.
         for (int leftIndex = 0; leftIndex < arr.length; leftIndex += 2*size)
         {
            final int kMiddleIndex = leftIndex + size - 1;
            final int kRightEndIndex = Math.min((leftIndex + 2*size - 1), (arr.length - 1));
            mergeSort(arr, leftIndex, kMiddleIndex, kRightEndIndex);
         }
      }

      // If the array length is not sized correctly

   }

   @Test
   public void checkSortCorrectness()
   {
      final int kSize = 10;
      int[] arr = SharedFunctions.getRandomArray(kSize);

      int[] originalArrCopy = new int[arr.length];

      System.arraycopy(arr, 0, originalArrCopy, 0, arr.length);

      sortArray(arr);

      SharedFunctions.printArrayToConsole(originalArrCopy);
      SharedFunctions.printArrayToConsole(arr);

      assertTrue(SharedFunctions.checksort(originalArrCopy, arr));
   }

   // TODO: figure out why it does not handle if array size is not multiples of 32.
   @Test public void checkSortCorrectnessComprehensive()
   {
      // Test multiple random inputs
      for (int i = 0; i < 100; ++i)
      {
         final int kSize = 64;
         int[] arr = SharedFunctions.getRandomArray(kSize);

         int[] originalArrCopy = new int[arr.length];

         System.arraycopy(arr, 0, originalArrCopy, 0, arr.length);

         sortArray(arr);

         if (!SharedFunctions.checksort(originalArrCopy, arr))
         {
            SharedFunctions.printArrayToConsole(originalArrCopy);
            SharedFunctions.printArrayToConsole(arr);
            assertTrue(SharedFunctions.checksort(originalArrCopy, arr));
         }

         //assertTrue(SharedFunctions.checksort(originalArrCopy, arr));
      }
   }
}
