package shared;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SharedFunctions
{
   public static String printArray(int arr[])
   {
      StringBuilder sb = new StringBuilder();

      int size = arr.length;
      sb.append("Number of Elements: " + size);
      sb.append("\n");

      sb.append("[");

      for (int i = 0; i < size; ++i)
      {
         sb.append(arr[i]);

         if(i != (size - 1))
         {
            sb.append(", ");
         }
      }

      sb.append("]");

      return sb.toString();
   }

   public static boolean checksort(int[] pre, int[] post)
   {
      // 1. post has elements in sorted order <=
      // 2. pre and post have the same length
      // 3. pre is a permutation of post

      if (pre.length != post.length)
      {
         return false;
      }

      for (int i = 0; i < post.length - 1; i++)
      {
         if (post[i] > post[i + 1])
         {
            return false;
         }
      }

      for (int e: pre)
      {
         if (count(pre, e) != count(post, e))
         {
            return false;
         }
      }

      return true;
   }

   public static int count(int[] arr, int x)
   {
      // returns the #occurrences of x in arr
      int count = 0;
      for (int e: arr) {
         if (e == x) count++;
      }
      return count;
   }

   public static int[] readFromInputFile(String fileName)
   {
      int[] arr = null;

      try (Stream<String> stream = Files.lines(Paths.get(fileName)))
      {
         // This remove data from stream object into fileLines
         final List<String> fileLines = stream.collect(Collectors.toList());

         final int kSize = fileLines.size();
         arr = new int[kSize];

         for (int lineIndex = 0; lineIndex < kSize; ++lineIndex)
         {
            arr[lineIndex] = Integer.parseInt(fileLines.get(lineIndex));
         }

      }
      catch (Exception e)
      {
         System.out.println("Exception While Reading File: " + e.toString());
         System.exit(-1);
      }

      return arr;
   }

   public static void writeToOutputFile(int arr[], String fileName)
   {
      try
      {
         BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

         StringBuilder sb = new StringBuilder();

         int size = arr.length;

         for (int i = 0; i < size; ++i)
         {
            sb.append(arr[i]);

            if(i != (size - 1))
            {
               sb.append("\n");
            }
         }

         writer.write(sb.toString());
         writer.close();
      }
      catch (Exception e)
      {
         System.out.println("Exception While Writing To File: " + e.toString());
         System.exit(-1);
      }

   }

   // Reference: https://www.mkyong.com/java/java-generate-random-integers-in-a-range/
   public static int getRandomNumberInRange(int min, int max)
   {

      if (min >= max)
      {
         throw new IllegalArgumentException("max must be greater than min");
      }

      Random r = new Random();
      return r.nextInt((max - min) + 1) + min;
   }
}
