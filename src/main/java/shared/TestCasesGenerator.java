package shared;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestCasesGenerator
{

   static final String kUsage = new String("Usage: TestCasesGenerator TestCase NumberOfItems \"outputFile.txt\"");
   static final String kExampleUsage = new String(
         "Example: TestCasesGenerator SortedInAscendingOrderCase 100 \"Sorted_AscendingOrder_100.txt\"");

   // TODO: add new cases here
   static final String kSortedInAscendingOrderCase = new String("SortedInAscendingOrderCase");
   static final String kSortedInDescendingOrderCase = new String("SortedInDescendingOrderCase");
   static final String kRandomOrderCase = new String("RandomOrderCase");
   static final String kRandomHighOnFirstHalfAndLowOnSecondHalf = new String("RandomHighOnFirstHalfAndLowOnSecondHalf");
   static final String kRandomLowOnFirstHalfAndHighOnSecondHalf = new String("RandomLowOnFirstHalfAndHighOnSecondHalf");
   static final String kAscendingOrderHighOnFirstHalfAndLowOnSecondHalf = new String ("AscendingOrderHighOnFirstHalfAndLowOnSecondHalf");
   static final String kDescendingOrderHighOnFirstHalfAndLowOnSecondHalf = new String ("DescendingOrderHighOnFirstHalfAndLowOnSecondHalf");
   public static String getValidTestCases()
   {
      // TODO: add new cases here
      String[] validTestCases = new String[] {
            kSortedInAscendingOrderCase,
            kSortedInDescendingOrderCase,
            kRandomOrderCase,
            kRandomHighOnFirstHalfAndLowOnSecondHalf,
            kRandomLowOnFirstHalfAndHighOnSecondHalf,
            kAscendingOrderHighOnFirstHalfAndLowOnSecondHalf,
            kDescendingOrderHighOnFirstHalfAndLowOnSecondHalf,
      };

      StringBuilder sb = new StringBuilder();

      int size = validTestCases.length;

      for (int i = 0; i < size; ++i)
      {
         sb.append(validTestCases[i]);

         if(i != (size - 1))
         {
            sb.append(" ,");
         }
      }

      return sb.toString();
   }

   // Usage: TestCasesGenerator TestCase NumberOfItems "OutputFile.txt"
   // Example: TestCasesGenerator Generic_Sort_BestCase 10 "Generic_Sort_BestCase_10.txt"
   public static void main(String args[])
   {
      final int kExpectedNumberOfArguments = 3;

      if (kExpectedNumberOfArguments == args.length)
      {
         final String kTestCase = args[0];
         final int kDataSetSize = Integer.parseInt(args[1]);
         final String kOutputFileName = args[2];

         int[] arr = new int[kDataSetSize];

         if (0 == kTestCase.compareToIgnoreCase(kSortedInAscendingOrderCase))
         {
            generateSortedInAscendingOrderCase(arr);
         }
         else if (0 == kTestCase.compareToIgnoreCase(kSortedInDescendingOrderCase))
         {
            generateSortedInDescendingOrderCase(arr);
         }
         else if (0 == kTestCase.compareToIgnoreCase(kRandomOrderCase))
         {
            generateRandomOrderCase(arr);
         }
         else if (0 == kTestCase.compareToIgnoreCase(kRandomHighOnFirstHalfAndLowOnSecondHalf))
         {
            generateRandomHighOnFirstHalfAndLowOnSecondHalf(arr);
         }
         else if (0 == kTestCase.compareToIgnoreCase(kRandomLowOnFirstHalfAndHighOnSecondHalf))
         {
            generateRandomLowOnFirstHalfAndHighOnSecondHalf(arr);
         }
         else if (0 == kTestCase.compareToIgnoreCase(kAscendingOrderHighOnFirstHalfAndLowOnSecondHalf))
         {
            generateAscendingOrderHighOnFirstHalfAndLowOnSecondHalf(arr);
         }
         else if (0 == kTestCase.compareToIgnoreCase(kDescendingOrderHighOnFirstHalfAndLowOnSecondHalf))
         {
            generateDescendingOrderHighOnFirstHalfAndLowOnSecondHalf(arr);
         }
         else
         {
            System.out.println("Invalid Inputs");
            System.out.println(kUsage);
            System.out.println(kExampleUsage);
            System.out.println("Valid TestCases Inputs: " + getValidTestCases());
            System.exit(-1);
         }

         // Write case to file.
         SharedFunctions.writeToOutputFile(arr, kOutputFileName);
      }
      else
      {
         System.out.println("Invalid Number of Arguments");
         System.out.println(kUsage);
         System.out.println(kExampleUsage);
         System.out.println("Valid TestCases Inputs: " + getValidTestCases());
         System.exit(-1);
      }
   }

   public static void generateSortedInAscendingOrderCase(int[] arr)
   {
      // Generic sort best case is when numbers are ordered
      for (int i = 0; i < arr.length; ++i)
      {
         arr[i] = i;
      }
   }

   @Test public void verifySortedInAscendingOrderCaseOutput()
   {
      int[] sortedInAscending = {0, 1, 2, 3};
      int[] arr = new int[4];

      generateSortedInAscendingOrderCase(arr);

      assertArrayEquals(sortedInAscending, arr);
   }

   public static void generateSortedInDescendingOrderCase(int[] arr)
   {
      // Generic sort best case is when numbers are ordered
      for (int i = (arr.length - 1), j = 0; i >= 0; --i, ++j)
      {
         arr[j] = i;
      }
   }

   @Test public void verifySortedInDescendingOrderCaseOutput()
   {
      int[] sortedInAscending = {3, 2, 1, 0};
      int[] arr = new int[4];

      generateSortedInDescendingOrderCase(arr);

      assertArrayEquals(sortedInAscending, arr);
   }

   public static void generateRandomOrderCase(int[] arr)
   {
      final int kLowerRange = -1000000;
      final int kUpperRange = 1000000;
      final int kSize = arr.length;
      arr = SharedFunctions.getRandomArray(kSize, kLowerRange, kUpperRange);
   }

   public static void generateRandomHighOnFirstHalfAndLowOnSecondHalf(int[] arr)
   {
      // This case needs high numbers on the first half of array and
      // lower numbers on the second half of array
      final int kArrayHalfCutOff = arr.length/2;
      for (int i = 0; i < arr.length; ++i)
      {
         if (i < kArrayHalfCutOff)
         {
            // Lower half. Put high numbers
            arr[i] = SharedFunctions.getRandomNumberInRange(1000, 1000000);
         }
         else
         {
            // Upper half (i >= arr.length/2 ). Put low numbers
            arr[i] = SharedFunctions.getRandomNumberInRange(-1000000, -1000);
         }
      }
   }

   @Test public void verifyRandomHighOnFirstHalfAndLowOnSecondHalfOutput()
   {
      int[] arr = new int[20];

      generateRandomHighOnFirstHalfAndLowOnSecondHalf(arr);

      final int kArrayHalfCutOff = arr.length/2;

      for (int i = 0; i < arr.length; ++i)
      {
         if (i < kArrayHalfCutOff)
         {
            // Lower half. Must be high numbers
            for (int j = (arr.length - 1); j >= arr.length/2; --j)
            {
               // check that all numbers in the upper half are lower
               assertTrue(arr[i] > arr[j]);
            }
         }
         else
         {
            // Upper half (i >= arr.length/2 ). Must be low numbers
            for (int j = 0; j < kArrayHalfCutOff; ++j)
            {
               // check that all numbers in the upper half are lower
               assertTrue(arr[i] < arr[j]);
            }
         }
      }
   }

   public static void generateRandomLowOnFirstHalfAndHighOnSecondHalf(int[] arr)
   {
      // This case needs high numbers on the first half of array and
      // lower numbers on the second half of array
      final int kArrayHalfCutOff = arr.length/2;
      for (int i = 0; i < arr.length; ++i)
      {
         if (i < kArrayHalfCutOff)
         {
            // Lower half. Put high numbers
            arr[i] = SharedFunctions.getRandomNumberInRange(-1000000, -1000);
         }
         else
         {
            // Upper half (i >= arr.length). Put low numbers
            arr[i] = SharedFunctions.getRandomNumberInRange(1000, 1000000);
         }
      }
   }

   @Test public void verifyRandomLowOnFirstHalfAndHighOnSecondHalfOutput()
   {
      int[] arr = new int[10];

      generateRandomLowOnFirstHalfAndHighOnSecondHalf(arr);

      final int kArrayHalfCutOff = arr.length/2;

      for (int i = 0; i < arr.length; ++i)
      {
         if (i < kArrayHalfCutOff)
         {
            // Lower half. Must be low numbers
            for (int j = (arr.length - 1); j >= arr.length/2; --j)
            {
               // check that all numbers in the upper half are higher
               assertTrue(arr[i] < arr[j]);
            }
         }
         else
         {
            // Upper half (i >= arr.length/2 ). Must be high numbers
            for (int j = 0; j < kArrayHalfCutOff; ++j)
            {
               // check that all numbers in the upper half are higher
               assertTrue(arr[i] > arr[j]);
            }
         }
      }
   }

   public static void generateAscendingOrderHighOnFirstHalfAndLowOnSecondHalf(int[] arr)
   {
      // This case needs high numbers on the first half of array and
      // lower numbers on the second half of array
      final int kArrayHalfCutOff = arr.length/2;
      for (int i = 0, j = (arr.length - 1); i < arr.length; ++i, --j)
      {
         if (i < kArrayHalfCutOff)
         {
            // Lower half. Put high numbers
            arr[i] = j;
         }
         else
         {
            // Upper half (i >= arr.length). Put low numbers
            arr[i] = kArrayHalfCutOff - j - 1;
         }
      }
   }

   @Test public void verifyAscendingOrderHighOnFirstHalfAndLowOnSecondHalfOutput()
   {
      final int[] kExpectedOutput = new int[] {9, 8, 7, 6, 5, 0, 1, 2, 3,4};

      int[] arr = new int[10];
      generateAscendingOrderHighOnFirstHalfAndLowOnSecondHalf(arr);
      assertArrayEquals(kExpectedOutput, arr);
   }

   public static void generateDescendingOrderHighOnFirstHalfAndLowOnSecondHalf(int[] arr)
   {
      // This case needs high numbers on the first half of array and
      // lower numbers on the second half of array
      final int kArrayHalfCutOff = arr.length/2;
      for (int i = 0, j = (arr.length - 1); i < arr.length; ++i, --j)
      {
         if (i < kArrayHalfCutOff)
         {
            // Lower half. Put high numbers
            arr[i] =  kArrayHalfCutOff + i;
         }
         else
         {
            // Upper half (i >= arr.length). Put low numbers
            arr[i] = j;
         }
      }
   }

   @Test public void verifyDescendingOrderHighOnFirstHalfAndLowOnSecondHalf()
   {
      final int[] kExpectedOutput = new int[] {5, 6, 7, 8, 9, 4, 3, 2, 1, 0};

      int[] arr = new int[10];
      generateDescendingOrderHighOnFirstHalfAndLowOnSecondHalf(arr);
      assertArrayEquals(kExpectedOutput, arr);
   }
}