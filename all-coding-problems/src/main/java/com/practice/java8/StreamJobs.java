package com.practice.java8;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJobs {

    public static void main(String[] args) {

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 100, 23, 93, 99);
        int max = numbers.stream()
                .max(Comparator.naturalOrder())
                .get();

        int min = numbers.stream().min(Comparator.naturalOrder()).get();

        System.out.println("Max is: "+max);
        System.out.println("Min is: "+min);

        System.out.println("Hello World!");

        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        Consumer<Integer> pr = num -> System.out.println(num * 5);

        //list.forEach(pr.andThen(num -> System.out.println(num)));

        Stream<String> s1 = Stream.of("AA", "BB", "CC");
        Stream<String> s2 = Stream.of("AA", "BB", "DD");

        List<String> newList = s1.map(String::toLowerCase)
                .collect(Collectors.toList());
        // .forEach(System.out::println);

        newList.stream().forEach(System.out::print);

        ArrayList<Employee> employees = getUnsortedEmployeeList();

        Comparator<Employee> comp = Comparator
                .comparing(Employee::getfName)
                .thenComparing(Employee::getlName);

        employees.stream().sorted(comp).forEach(System.out::println);
        Double avgId = employees.stream()
                .mapToDouble(emp -> emp.getSalary())
                .average()
                .getAsDouble();

        System.out.println("Average salary is: "+avgId);


    }

    private static ArrayList<Employee> getUnsortedEmployeeList() {
        ArrayList<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(2l, "Lokesh", "Gupta"));
        list.add(new Employee(1l, "Alex", "Gussin"));
        list.add(new Employee(4l, "Brian", "Sux"));
        list.add(new Employee(5l, "Neon", "Piper"));
        list.add(new Employee(3l, "David", "Beckham"));
        list.add(new Employee(7l, "Alex", "Beckham"));
        list.add(new Employee(6l, "Brian", "Suxena"));
        return list;
    }

    private static class Employee {

        static Random random = new Random();

        long id;
        String fName;
        String lName;
        Double salary;

        public Employee(long id, String fName, String lName) {
            this.id = id;
            this.fName = fName;
            this.lName = lName;
            this.salary = random.nextDouble() * 1000;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public String getfName() {
            return fName;
        }

        public void setfName(String fName) {
            this.fName = fName;
        }

        public String getlName() {
            return lName;
        }

        public void setlName(String lName) {
            this.lName = lName;
        }


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", fName='" + fName + '\'' +
                    ", lName='" + lName + '\'' +
                    '}';
        }
    }
}
