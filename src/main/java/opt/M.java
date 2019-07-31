package opt;

import java.util.*;
import java.util.stream.Collectors;

public class M {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        M m = new M();

        personList.add(new Person("vasya",15,"male"));
        personList.add(new Person("kiril",75,"male"));
        personList.add(new Person("Oleg",20,"male"));
        personList.add(new Person("dima",20,"male"));
        personList.add(new Person("sasha",50,"female"));
        personList.add(new Person("bodya",60,"male"));
        personList.add(new Person("vitalina",10,"female"));

        System.out.println(m.groupPersonsByGender(personList));
        System.out.println(m.groupNamesByGender(personList));
        System.out.println(m.getTotalAgeByGender(personList));

    }
    Map<String,List<Person>> groupPersonsByGender(List<Person> personList){
        return  personList.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        }

    Map<String,List<String>> groupNamesByGender(List<Person> personList){
        return  personList.stream()
                .collect(
                        Collectors.groupingBy(Person::getGender,
                                Collectors.mapping(Person::getName, Collectors.toList())));
    }
    Map<String,Integer> getTotalAgeByGender(List<Person> personList){
        return  personList.stream()
                .collect(
                        Collectors.groupingBy(Person::getGender,
                                Collectors.mapping(Person::getAge,
                                        Collectors.reducing(0, Integer::sum))));

    }

}
