package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExampleStreams {
    public static void extractList() {
        // for
    }

    public void listToMap() {
        List<User> uList = new ArrayList<>();
        uList.add(new User(3L, "Lolol",1));
        uList.add(new User(4L, "pasha"));
        uList.add(new User(5L, "vasya"));

        Map<Long, User> xMap = uList.stream()
                .collect(Collectors.toMap(User::getId, user -> user));
        System.out.println(xMap);

        Map<Long, User> xMap2 = uList.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println(xMap2);

        Map<Integer, List<User>> groupingBy = uList.stream()
                .collect(Collectors.groupingBy(User::getAge, Collectors.toList()));

        System.out.println(groupingBy);

        groupingBy.entrySet().stream()
                .flatMap(item -> item.getValue().stream())
                .map(x -> x.age + "-" + x.username)
                .collect(Collectors.toList()).forEach(System.out::println);

        Integer sumAge = groupingBy.entrySet().stream()
                .flatMap(item -> item.getValue().stream())
                .map(x -> x.age)
                .reduce(0,Integer::sum);
        System.out.println(sumAge);


        String[] arr = {"12,323", "vasya,pasha,olya", "siska,piska"};
        List<String> arrList = Arrays.stream(arr)
                .flatMap(x -> Arrays.stream(x.split(",",5)))
                .peek(System.out::println).collect(Collectors.toList());

    }

    public void parallelSum() {
        int[] arr = {4,5,7,8,2,4,5,7,5,3,5,6,7,0,4, -1, 0,3,4, -9};
        long startTime = System.nanoTime();
        int amount = Arrays.stream(arr).parallel().sum();
        long endTime = System.nanoTime();
        System.out.println(amount);
        System.out.println("time duration parallel (.sec) - " + ((double) (endTime - startTime) / 1_000_000_000));
    }

    public void sequentialSum() {
        int[] arr = {4,5,7,8,2,4,5,7,5,3,5,6,7,0,4, -1, 0,3,4, -9};
        long startTime = System.nanoTime();
        int amount = Arrays.stream(arr).sum();
        long endTime = System.nanoTime();
        System.out.println(amount);
        System.out.println("time duration sequential (.sec) - " + ((double) (endTime - startTime) / 1_000_000_000));
    }

//    public static Map<Long, Long> splitToMap(List<String> stringsList) {
//        return stringsList.stream()
//                .filter(StringUtils::isNotEmpty)
//                .map(line -> line.split(","))
//                .filter(array -> array.length == 2
//                        && NumberUtils.isNumber(array[0])
//                        && NumberUtils.isNumber(array[1]))
//                .collect(Collectors.toMap(array -> Long.valueOf(array[0]),
//                        array -> Long.valueOf(array[1]), (first, second) -> first)));
//    }

    class User {
        private Long id;
        private String username;
        private Integer age;
        private List<String> skills;

        User(Long id, String username ) {
            this.id = id;
            this.username = username;
            this.age = 3;
        }

        User(Long id, String username, Integer age ) {
            this.id = id;
            this.username = username;
            this.age = age;
        }

        public Long getId() {
            return this.id;
        }
        public void setId(Long id) {
            this.id = id;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public List<String> getSkills() {
            return skills;
        }

        public void setSkills(String... xskills) {
            this.skills = Arrays.stream(xskills).sequential().collect(Collectors.toList());
        }
    }
}
