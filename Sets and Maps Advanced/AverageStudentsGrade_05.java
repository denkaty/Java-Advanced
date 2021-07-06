import java.util.*;

public class AverageStudentsGrade_05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentsGradesMap = new TreeMap<>();
        int counter = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < counter; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String student = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            studentsGradesMap.putIfAbsent(student, new ArrayList<>());
            studentsGradesMap.get(student).add(grade);
        }


        studentsGradesMap.entrySet()
                .stream()
                .forEach(entry -> {
                    double sum = 0;
                    for (Double grade : entry.getValue()) {
                        sum += grade;
                    }
                    double averageGrade = sum / entry.getValue().size();

                    System.out.print(entry.getKey() + " -> ");
                    entry.getValue()
                            .forEach(grade -> {
                                System.out.printf("%.2f ", grade);
                            });
                    System.out.printf("(avg: %.2f)%n", averageGrade);

                });

    }
}