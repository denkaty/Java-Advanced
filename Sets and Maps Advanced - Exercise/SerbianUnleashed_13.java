import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed_13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> statisticsMap = new LinkedHashMap<>();
        String regex = "^(?<singer>[A-Za-z]+[ ]?[A-Za-z]+[ ]?[A-Za-z]+) @(?<venue>[A-Za-z]+[ ]?[A-Za-z]+[ ]?[A-Za-z]+) (?<ticketsPrice>[0-9]+) (?<ticketsCount>[0-9]+)";

        Pattern pattern = Pattern.compile(regex);
        String input = "";
        while (!"End".equals(input = scanner.nextLine())) {

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int ticketsPrice = Integer.parseInt(matcher.group("ticketsPrice"));
                int ticketsCount = Integer.parseInt(matcher.group("ticketsCount"));

                statisticsMap.putIfAbsent(venue, new LinkedHashMap<>());
                Map<String, Integer> singersMap = statisticsMap.get(venue);
                singersMap.putIfAbsent(singer, 0);
                int currentTicketsMoney = singersMap.get(singer);
                currentTicketsMoney += ticketsPrice * ticketsCount;
                singersMap.put(singer, currentTicketsMoney);

            }

        }

        statisticsMap.entrySet().stream()
                .forEach(city -> {
                    System.out.printf("%s%n", city.getKey());

                    Map<String, Integer> singersMap = city.getValue();
                    singersMap.entrySet().stream()
                            .sorted((singer1, singer2) -> singer2.getValue().compareTo(singer1.getValue()))
                            .forEach(singer -> System.out.printf("#  %s -> %d%n", singer.getKey(), singer.getValue()));
                });

    }
}
