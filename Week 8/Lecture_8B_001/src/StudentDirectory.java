import java.util.HashMap;

public class StudentDirectory {

  HashMap<Student, Student> students = new HashMap<>();

  public void addStudent(Student s) {
    students.put(s, s);
  }

  public void printSizeOfDirectory() {
    System.out.println("There are " + students.size() + " students in the directory");
  }

  private static class Student{
    String name;
    String email;
    int ID;

    public Student(String name, String email, int ID){
      this.name = name;
      this.email = email;
      this.ID = ID;
    }

    public int hashCode(){
      return this.ID * name.length();
    }

    @Override
    public boolean equals(Object obj) {
      if(obj.getClass() == Student.class) {
        return ((Student)obj).ID == this.ID && ((Student)obj).name.equals(this.name);
      } else {
        return false;
      }
    }
  }

  public static void main(String[] args) {
    StudentDirectory studentList = new StudentDirectory();
    studentList.addStudent(new Student("Eric", "eric.rapos@ontariotechu.ca", 123456));
    studentList.addStudent(new Student("Alice", "alice@example.com", 654321));
    studentList.printSizeOfDirectory();
  }

}