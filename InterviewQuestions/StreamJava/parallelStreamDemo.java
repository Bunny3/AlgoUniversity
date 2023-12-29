  import java.util.*;
  class Student {
    String name;
    int score;
    Student(String name, int score) {
      this.name = name;
      this.score = score;
    }
    public String getName() {
      return this.name;
    }
    public int getScore() {
      return this.score;
    }
  }
public class parallelStreamDemo {
  public static void main(String args[]) {
    List<Student> studentList = Arrays.asList(
                                new Student("David", 82),
                                new Student("Bob",90),
                                new Student("John",65),
                                new Student("Eric",55),
                                new Student("Canedy",85),
                                new Student("Smit",88),
                                new Student("Scott",50)
    );
    //using stream - sequential 
    studentList.stream()
               .filter(s->s.getScore()>=80)
               .limit(3)
               .forEach(stu->System.out.println(stu.getName()+" -- "+stu.getScore()));

    //parallelStream
    studentList.parallelStream()
               .filter(s->s.getScore()>=80)
               .limit(3)
               .forEach(stu->System.out.println(stu.getName()+" -- "+stu.getScore()));
    //convert sequential stream to parallel stream
    // Using parallel()
    studentList.stream().parallel()
               .filter(s->s.getScore()>=80)
               .limit(3)
               .forEach(stu->System.out.println(stu.getName()+" -- "+stu.getScore()));

  }
}
