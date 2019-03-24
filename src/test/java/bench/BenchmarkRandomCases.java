package bench;

import org.openjdk.jmh.annotations.*;
import sortingAlgorithms.*;
import shared.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class BenchmarkRandomCases {

    private static int[] inputArray;

    //TODO: add test cases files
    /*
    @Param({
          "testCases/Generic_Sort_RandomCase_10.txt",
          "testCases/Generic_Sort_RandomCase_100.txt",
          "testCases/Generic_Sort_RandomCase_1000.txt",
          "testCases/Generic_Sort_RandomCase_10000.txt",
          "testCases/Generic_Sort_RandomCase_100000.txt",
          "testCases/Generic_Sort_RandomCase_1000000.txt",
          "testCases/Generic_Sort_RandomCase_10000000.txt"
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
}
