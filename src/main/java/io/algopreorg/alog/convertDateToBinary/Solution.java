package io.algopreorg.alog.convertDateToBinary;

public class Solution {

  /**
   * public String convertDateToBinary(String date) {
   *         String[] arr = date.split("-");
   *
   *         return "%s-%s-%s".formatted(
   *             numberToBinary(arr[0]),
   *             numberToBinary(arr[1]),
   *             numberToBinary(arr[2])
   *         );
   *     }
   *
   *     private String numberToBinary(String numberString) {
   *         Integer number = Integer.valueOf(numberString);
   *         StringBuilder sb = new StringBuilder();
   *
   *         while (number > 0) {
   *             sb.append(number % 2);
   *             number = number / 2;
   *         }
   *
   *         return sb.reverse().toString();
   *     }
   */

  private static final String SEPARATOR = "-";

  public String convertDateToBinary(String date) {
    String[] parts = date.split(SEPARATOR);
    int year = Integer.parseInt(parts[0]);
    int month = Integer.parseInt(parts[1]);
    int day = Integer.parseInt(parts[2]);

    String yearBinary = Integer.toBinaryString(year);
    String monthBinary = Integer.toBinaryString(month);
    String dayBinary = Integer.toBinaryString(day);

    return yearBinary + SEPARATOR + monthBinary + SEPARATOR + dayBinary;
  }

  public static void main(String[] args) {
    // Example date
    String date = "2025-01-22";
    String binaryDate = new Solution().convertDateToBinary(date);
    System.out.println("Binary representation: " + binaryDate);
  }
}
