package sortingAlgorithms;

import org.junit.jupiter.api.Test;
import shared.SharedFunctions;

public class BubbleSort
{
   static public void sortArray(int arr[])
   {
      int n = arr.length;

      for (int i = 0; i < n - 1; ++i)
      {
         // ith element is already in the correct position
         for (int j = 0; j < (n - i - 1); ++j)
         {
            if (arr[j] > arr[j+1])
            {
               // Swap items
               int temp = arr[j];
               arr[j] = arr[j+1];
               arr[j+1] = temp;
            }
         }
      }
   }

   @Test public void checkSortCorrectness()
   {
      int[] arr = new int[10];

      for (int i = 0; i < arr.length; ++i)
      {
         arr[i] = SharedFunctions.getRandomNumberInRange(1, 100);
      }

      int[] originalArrCopy = new int[10];

      System.arraycopy(arr, 0, originalArrCopy, 0, arr.length);

      sortArray(arr);

      assert(true == SharedFunctions.checksort(originalArrCopy, arr));
   }

}
