import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {

        String ultimosDois = s.substring(s.length() - 2);
        String period = s.substring(0, s.length() - 2);

        String[] parts = period.split(":");
        int hours = Integer.parseInt(parts[0]);
        String minutes = parts[1];
        String seconds = parts[2];

        if (ultimosDois.equalsIgnoreCase("PM")) {
            if (hours != 12) {
                hours += 12;
            }
        } else {
            if (hours == 12) {
                hours = 0;
            }
        }

        return String.format("%02d:%s:%s", hours, minutes, seconds);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}