public class Birthday {
  public static void main(String[] args) {
    int[] dates = new int[]{12, 45, 16, 360, 35, 25, 5, 300, 104, 6, 365};
    System.out.println(latestBirthday(dates, 0, dates.length-1));

  }

  public static int latestBirthday(int[] dates, int low, int high) {
    if (low == high) {
      return dates[low];
    } else {
      int midpoint = (low + high) / 2;
      return Math.max(latestBirthday(dates, low, midpoint), latestBirthday(dates, midpoint+1, high));
    }
  }
}