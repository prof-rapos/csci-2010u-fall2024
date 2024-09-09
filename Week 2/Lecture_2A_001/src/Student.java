public class Student {

  public static void main(String[] args) {
    Student bob = new Student(1, "Bob Smith");
    Student christine = new Student(2, "Christine Johnson");

    System.out.println(bob);
    System.out.println(christine);

    System.out.println("There are " + Student.getCount() + " students in the course.");

    christine.setName("Chris Johnson");

    System.out.println(bob);
    System.out.println(christine);

    System.out.println("There are " + Student.getCount() + " students in the course.");

  }

  private int studentNo;
  private String name;
  private static int count;

  public Student() {
    this.studentNo = 0;
    this.name = "";
    count++;
  }

  public Student(int studentNo, String name) {
    this.studentNo = studentNo;
    this.name = name;
    count++;
  }

  public String getName() {
    return name;
  }

  public int getStudentNo() {
    return studentNo;
  }

  public static int getCount() {
    return count;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStudentNo(int studentNo) {
    this.studentNo = studentNo;
  }

  @Override
  public String toString(){
    return name + " (" + studentNo + ")";
  }


}