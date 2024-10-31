import java.util.HashMap;

public class StudentDirectory {

  HashMap<Integer, Student> students = new HashMap<Integer, Student>();

  public void addStudent(Student s) {
    students.put(s.hashCode(), s);
  }

  public String getEmail(Student s) {
    return students.get(s.hashCode()).email;
  }

  public int studentCount() {
    return students.size();
  }

  private static class Student {
    String name;
    String email;
    int ID;

    Student(String name, String email, int ID) {
      this.name = name;
      this.email = email;
      this.ID = ID;
    }

    public int hashCode() {
      return ID * name.length();
    }

    @Override
    public boolean equals(Object obj) {
      if (obj.getClass() == Student.class) {
        return this.ID == ((Student) obj).ID;
      } else {
        return false;
      }
    }
  }
  public static void main(String[] args) {
    Student a = new Student("Eric", "eric.rapos@ontariotechu.ca", 12345678);
    Student b = new Student("Helen", "helen.smith@gmail.com", 87654321);

    StudentDirectory s = new StudentDirectory();

    s.addStudent(a);
    s.addStudent(b);

    System.out.println(s.studentCount());
    System.out.println(s.getEmail(new Student("Eric", "fsfds", 12345678)));
  }




}