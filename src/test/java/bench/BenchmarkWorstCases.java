package bench;

import org.openjdk.jmh.annotations.*;
import sortingAlgorithms.*;
import shared.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class BenchmarkWorstCases {

    private static int[] inputArray;

    //TODO: add test cases files
    /*
    @Param({
          "testCases/Generic_Sort_WorstCase_10.txt",
          "testCases/Generic_Sort_WorstCase_100.txt",
          "testCases/Generic_Sort_WorstCase_1000.txt",
          "testCases/Generic_Sort_WorstCase_10000.txt",
          "testCases/Generic_Sort_WorstCase_100000.txt",
          "testCases/Generic_Sort_WorstCase_1000000.txt",
          "testCases/Generic_Sort_WorstCase_10000000.txt"
    })
    public String fileName;
    */

    @Param({
          "testCases/Generic_Sort_BestCase_100.txt",
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
