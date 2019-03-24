package shared;

class TestCasesGenerator
{

   static final String kGenericSortBestCase = new String("Generic_Sort_BestCase");

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

         if (0 == kTestCase.compareToIgnoreCase(kGenericSortBestCase))
         {
            generateGenericSortBestCase(arr);

            SharedFunctions.writeToOutputFile(arr, kOutputFileName);
         }
         else
         {
            System.out.println("Invalid Inputs");
            System.out.println("Usage: TestCasesGenerator TestCase NumberOfItems \"outputFile.txt\"");
            System.out.println("Example: TestCasesGenerator Generic_Sort_BestCase 100 \"Generic_Sort_BestCase_100.txt\"");
            System.out.println("Valid TestCases Inputs: " + kGenericSortBestCase);
            System.exit(-1);
         }

      }
      else
      {
         System.out.println("Invalid Number of Arguments");
         System.out.println("Usage: TestCasesGenerator TestCase NumberOfItems \"outputFile.txt\"");
         System.out.println("Example: TestCasesGenerator Generic_Sort_BestCase 100 \"Generic_Sort_BestCase_100.txt\"");
         System.out.println("Valid TestCases Inputs: " + kGenericSortBestCase);
         System.exit(-1);
      }
   }

   public static void generateGenericSortBestCase(int[] arr)
   {
      // Generic sort best case is when numbers are ordered
      for (int i = 0; i < arr.length; ++i)
      {
         arr[i] = i;
      }
   }
}