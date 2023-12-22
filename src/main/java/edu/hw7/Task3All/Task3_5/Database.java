package edu.hw7.Task3All.Task3_5;

import edu.hw7.Task3All.Person;
import edu.hw7.Task3All.PersonDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class Database implements PersonDatabase {
    private final Map<Integer, Person> idMap = new HashMap<>();
    private final Map<Object, List<Person>> nameMap = new HashMap<>();
    private final Map<Object, List<Person>> addressMap = new HashMap<>();
    private final Map<Object, List<Person>> phoneMap = new HashMap<>();
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    public Database() {

    }

    public Database(@NotNull List<Person> people) {
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
    public void add(Person person) {
        if (person != null) {
            readWriteLock.writeLock().lock();
            try {
                idMap.put(person.id(), person);
                addPersonToMap(nameMap, person.name(), person);
                addPersonToMap(addressMap, person.address(), person);
                addPersonToMap(phoneMap, person.phoneNumber(), person);
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }
    }

    @Override
    public void delete(int id) {
        readWriteLock.writeLock().lock();
        try {
            Person person = idMap.remove(id);
            deletePersonFromMap(nameMap, person.name(), person);
            deletePersonFromMap(addressMap, person.address(), person);
            deletePersonFromMap(phoneMap, person.phoneNumber(), person);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        readWriteLock.readLock().lock();
        try {
            return nameMap.get(name);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        readWriteLock.readLock().lock();
        try {
            return addressMap.get(address);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        readWriteLock.readLock().lock();
        try {
            return phoneMap.get(phone);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    private void addPersonToMap(@NotNull Map<Object, List<Person>> map, Object key, Person person) {
        List<Person> people = map.getOrDefault(key, new ArrayList<>());
        if (!people.contains(person)) {
            people.add(person);
            map.put(key, people);
        }
    }

    private void addPeopleToMap(
        Map<Object, List<Person>> map,
        Function<Person, Object> keyFunction,
        @NotNull List<Person> people
    ) {
        for (Person person : people) {
            addPersonToMap(map, keyFunction.apply(person), person);
        }
    }

    private void deletePersonFromMap(@NotNull Map<Object, List<Person>> map, Object key, Person person) {
        List<Person> people = map.getOrDefault(key, new ArrayList<>());
        people.remove(person);
        map.put(key, people);
    }
}
