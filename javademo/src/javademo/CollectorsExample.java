package javademo;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectorsExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35),
                new Person("Alice", 40)
        );

        
        people.parallelStream()
//        .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
//        .filter
        .forEach(System.out::println);
        
        // Collect as List
        List<Person> peopleList = people.stream()
                .collect(Collectors.toList());
        System.out.println("List of People: " + peopleList);

        // Collect as Set
        Set<Person> peopleSet = people.stream()
                .collect(Collectors.toSet());
        System.out.println("Set of People: " + peopleSet);

        // Collect as Map
//        Map<String, Integer> peopleMap = people.stream()
//                .collect(Collectors.toMap(Person::getName, Person::getAge, Integer::max));
//        System.out.println("Map of People: " + peopleMap);

        // GroupingBy
        Map<String, List<Person>> peopleByAgeGroup = people.stream()
                .collect(Collectors.groupingBy(person -> person.getAge() < 30 ? "Young" : "Old"));
        System.out.println("People grouped by age: " + peopleByAgeGroup);

        // Mapping
        Map<String, List<String>> namesByAgeGroup = people.stream()
                .collect(Collectors.groupingBy(person -> person.getAge() < 30 ? "Young" : "Old",
                        Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println("Names grouped by age: " + namesByAgeGroup);

        // AveragingInt
        double averageAge = people.stream()
                .collect(Collectors.averagingInt(Person::getAge));
        System.out.println("Average Age: " + averageAge);

        // SummingInt
        int totalAge = people.stream()
                .collect(Collectors.summingInt(Person::getAge));
        System.out.println("Total Age: " + totalAge);

        // SummarizingInt
        IntSummaryStatistics ageSummary = people.stream()
                .collect(Collectors.summarizingInt(Person::getAge));
        System.out.println("Age Summary: " + ageSummary);

        // Joining
        String allNames = people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));
        System.out.println("All Names: " + allNames);

        // Counting
        long count = people.stream()
                .collect(Collectors.counting());
        System.out.println("Count: " + count);

        // MinBy
        Person youngestPerson = people.stream()
                .min((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .orElse(null);
        System.out.println("Youngest Person: " + youngestPerson);

        // MaxBy
        Person oldestPerson = people.stream()
                .max((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .orElse(null);
        System.out.println("Oldest Person: " + oldestPerson);

        // Reducing
        BinaryOperator<Integer> ageSumReducer = (age1, age2) -> age1 + age2;
        int reducedAgeSum = people.stream()
                .map(Person::getAge)
                .reduce(0, ageSumReducer);
        System.out.println("Reduced Age Sum: " + reducedAgeSum);

        // Filtering
        Predicate<Person> ageFilter = person -> person.getAge() > 30;
        List<Person> filteredPeople = people.stream()
                .collect(Collectors.filtering(ageFilter, Collectors.toList()));
        System.out.println("Filtered People: " + filteredPeople);

        // CollectingAndThen
        Function<List<Person>, String> nameConcatenator = personList ->
                personList.stream()
                        .map(Person::getName)
                        .collect(Collectors.joining(", "));
        String namesInUpperCase = people.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), nameConcatenator))
                .toUpperCase();
        System.out.println("Names in Upper Case: " + namesInUpperCase);
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
