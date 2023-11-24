package edu.hw7.Task3All.Task3;

import edu.hw7.Task3All.Person;
import edu.hw7.Task3All.PersonDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Database implements PersonDatabase {
    private final Map<Integer, Person> idMap = new HashMap<>();
    private final Map<Object, List<Person>> nameMap = new HashMap<>();
    private final Map<Object, List<Person>> addressMap = new HashMap<>();
    private final Map<Object, List<Person>> phoneMap = new HashMap<>();

    public Database() {

    }

    public Database(List<Person> people) {
        idMap.putAll(people.stream()
            .collect(Collectors.toMap(Person::id, person -> person)));

        addPeopleToMap(nameMap, Person::name, people);
        addPeopleToMap(addressMap, Person::address, people);
        addPeopleToMap(phoneMap, Person::phoneNumber, people);
    }

    public Database(Person... people) {
        this(List.of(people));
    }

    @Override
    public synchronized void add(Person person) {
        if (person != null) {
            idMap.put(person.id(), person);
            addPersonToMap(nameMap, person.name(), person);
            addPersonToMap(addressMap, person.address(), person);
            addPersonToMap(phoneMap, person.phoneNumber(), person);
        }
    }

    @Override
    public synchronized void delete(int id) {
        Person person = idMap.remove(id);
        deletePersonFromMap(nameMap, person.name(), person);
        deletePersonFromMap(addressMap, person.address(), person);
        deletePersonFromMap(phoneMap, person.phoneNumber(), person);
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        return nameMap.get(name);
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        return addressMap.get(address);
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        return phoneMap.get(phone);
    }

    private void addPersonToMap(Map<Object, List<Person>> map, Object key, Person person) {
        List<Person> people = map.getOrDefault(key, new ArrayList<>());
        if (!people.contains(person)) {
            people.add(person);
            map.put(key, people);
        }
    }

    private void addPeopleToMap(
        Map<Object, List<Person>> map,
        Function<Person, Object> keyFunction,
        List<Person> people
    ) {
        for (Person person : people) {
            addPersonToMap(map, keyFunction.apply(person), person);
        }
    }

    private void deletePersonFromMap(Map<Object, List<Person>> map, Object key, Person person) {
        List<Person> people = map.getOrDefault(key, new ArrayList<>());
        people.remove(person);
        map.put(key, people);
    }
}
