package bench;

import org.openjdk.jmh.annotations.*;
import sortingAlgorithms.*;
import shared.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class BenchmarkAverageCases {

   private static int[] inputArray;

   //TODO: add test cases files
   /*
   @Param({
         "testCases/Generic_Sort_AverageCase_10.txt",
         "testCases/Generic_Sort_AverageCase_100.txt",
         "testCases/Generic_Sort_AverageCase_1000.txt",
         "testCases/Generic_Sort_AverageCase_10000.txt",
         "testCases/Generic_Sort_AverageCase_100000.txt",
         "testCases/Generic_Sort_AverageCase_1000000.txt",
         "testCases/Generic_Sort_AverageCase_10000000.txt"
   })
   public String fileName;
   */

   @Param({
         "testCases/Generic_Sort_BestCase_100.txt",
         "testCases/Generic_Sort_BestCase_1000.txt",
   })
   public String fileName;

   @Setup
   public void loadData() {
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
}
