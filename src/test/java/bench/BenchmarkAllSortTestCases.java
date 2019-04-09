package bench;

import org.openjdk.jmh.annotations.*;
import sortingAlgorithms.*;
import shared.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class BenchmarkAllSortTestCases {

   private static int[] inputArray;

   @Param({
         "testCases/SortedInAscendingOrderCase_100.txt",
         "testCases/SortedInDescendingOrderCase_100.txt",
         "testCases/RandomOrderCase_100.txt",
         "testCases/RandomHighOnFirstHalfAndLowOnSecondHalf_100.txt",
         "testCases/RandomLowOnFirstHalfAndHighOnSecondHalf_100.txt",
         "testCases/AscendingOrderHighOnFirstHalfAndLowOnSecondHalf_100.txt",
         "testCases/DescendingOrderHighOnFirstHalfAndLowOnSecondHalf_100.txt",
         "testCases/SortedInAscendingOrderCase_1000.txt",
         "testCases/SortedInDescendingOrderCase_1000.txt",
         "testCases/RandomOrderCase_1000.txt",
         "testCases/RandomHighOnFirstHalfAndLowOnSecondHalf_1000.txt",
         "testCases/RandomLowOnFirstHalfAndHighOnSecondHalf_1000.txt",
         "testCases/AscendingOrderHighOnFirstHalfAndLowOnSecondHalf_1000.txt",
         "testCases/DescendingOrderHighOnFirstHalfAndLowOnSecondHalf_1000.txt",
         "testCases/SortedInAscendingOrderCase_10000.txt",
         "testCases/SortedInDescendingOrderCase_10000.txt",
         "testCases/RandomOrderCase_10000.txt",
         "testCases/RandomHighOnFirstHalfAndLowOnSecondHalf_10000.txt",
         "testCases/RandomLowOnFirstHalfAndHighOnSecondHalf_10000.txt",
         "testCases/AscendingOrderHighOnFirstHalfAndLowOnSecondHalf_10000.txt",
         "testCases/DescendingOrderHighOnFirstHalfAndLowOnSecondHalf_10000.txt",
         "testCases/SortedInAscendingOrderCase_100000.txt",
         "testCases/SortedInDescendingOrderCase_100000.txt",
         "testCases/RandomOrderCase_100000.txt",
         "testCases/RandomHighOnFirstHalfAndLowOnSecondHalf_100000.txt",
         "testCases/RandomLowOnFirstHalfAndHighOnSecondHalf_100000.txt",
         "testCases/AscendingOrderHighOnFirstHalfAndLowOnSecondHalf_100000.txt",
         "testCases/DescendingOrderHighOnFirstHalfAndLowOnSecondHalf_100000.txt",
         "testCases/SortedInAscendingOrderCase_1000000.txt",
         "testCases/SortedInDescendingOrderCase_1000000.txt",
         "testCases/RandomOrderCase_1000000.txt",
         "testCases/RandomHighOnFirstHalfAndLowOnSecondHalf_1000000.txt",
         "testCases/RandomLowOnFirstHalfAndHighOnSecondHalf_1000000.txt",
         "testCases/AscendingOrderHighOnFirstHalfAndLowOnSecondHalf_1000000.txt",
         "testCases/DescendingOrderHighOnFirstHalfAndLowOnSecondHalf_1000000.txt",
         "testCases/SortedInAscendingOrderCase_10000000.txt",
         "testCases/SortedInDescendingOrderCase_10000000.txt",
         "testCases/RandomOrderCase_10000000.txt",
         "testCases/RandomHighOnFirstHalfAndLowOnSecondHalf_10000000.txt",
         "testCases/RandomLowOnFirstHalfAndHighOnSecondHalf_10000000.txt",
         "testCases/AscendingOrderHighOnFirstHalfAndLowOnSecondHalf_10000000.txt",
         "testCases/DescendingOrderHighOnFirstHalfAndLowOnSecondHalf_10000000.txt",
         "testCases/SortedInAscendingOrderCase_100000000.txt",
         "testCases/SortedInDescendingOrderCase_100000000.txt",
         "testCases/RandomOrderCase_100000000.txt",
         "testCases/RandomHighOnFirstHalfAndLowOnSecondHalf_100000000.txt",
         "testCases/RandomLowOnFirstHalfAndHighOnSecondHalf_100000000.txt",
         "testCases/AscendingOrderHighOnFirstHalfAndLowOnSecondHalf_100000000.txt",
         "testCases/DescendingOrderHighOnFirstHalfAndLowOnSecondHalf_100000000.txt",
   })
   public String fileName;

   @Setup
   public void loadData()
   {

      inputArray = SharedFunctions.readFromInputFile(fileName);
   }

   @Benchmark
   public void BubbleSort()
   {
      BubbleSort.sortArray(inputArray);
   }

   @Benchmark
   public void InsertionSort()
   {
      InsertionSort.sortArray(inputArray);
   }

   @Benchmark
   public void ShellSort()
   {
      ShellSort.sortArray(inputArray);
   }

   @Benchmark
   public void TimSort()
   {
      ShellSort.sortArray(inputArray);
   }

   @Benchmark
   public void HeapSort()
   {
      ShellSort.sortArray(inputArray);
   }

   @Benchmark
   public void MergeSort()
   {
      ShellSort.sortArray(inputArray);
   }

   @Benchmark
   public void QuickSort()
   {
      ShellSort.sortArray(inputArray);
   }

   @Benchmark
   public void RadixSort()
   {
      ShellSort.sortArray(inputArray);
   }
}
