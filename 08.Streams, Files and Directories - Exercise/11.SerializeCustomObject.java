import java.io.*;

public class SerializeCustomObject_11 {

    public static void main(String[] args) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src\\Outputs\\outputEleven.ser"));

        Course course = new Course("Java Advanced", 146);
        objectOutputStream.writeObject(course);
    }

    public static class Course implements Serializable {
        private String name;
        private Integer students;

        public Course(String name, Integer students) {
            this.name = name;
            this.students = students;
        }
    }

}

