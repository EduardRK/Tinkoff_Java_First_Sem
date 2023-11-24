package edu.hw7;

import edu.hw7.Task3All.Person;
import edu.hw7.Task3All.PersonDatabase;
import edu.hw7.Task3All.Task3_5.Database;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3_5Test {
    @Test
    @DisplayName("Test add, delete and find in single thread")
    public void testAddDeleteAndFindSingleThread() {
        Person person1 = new Person(1, "Oleg", "Russia", "128303");
        Person person2 = new Person(2, "Anna", "China", "781245");
        Person person3 = new Person(3, "Billy", "USA", "781245");

        PersonDatabase personDatabase = new Database(person1, person2, person3);

        List<Person> nameFoundExpected = new ArrayList<>(List.of(person1));
        List<Person> addressFoundExpected = new ArrayList<>(List.of(person2));
        List<Person> phoneNumberFoundExpected = new ArrayList<>(List.of(person2, person3));

        Assertions.assertEquals(nameFoundExpected, personDatabase.findByName("Oleg"));
        Assertions.assertEquals(addressFoundExpected, personDatabase.findByAddress("China"));
        Assertions.assertEquals(phoneNumberFoundExpected, personDatabase.findByPhone("781245"));

        Person person4 = new Person(4, "Oleg", "Italy", "124125");
        Person person5 = new Person(5, "Lida", "Japan", "781245");
        Person person6 = new Person(6, "Olga", "China", "1718926");

        personDatabase.add(person5);
        personDatabase.add(person4);
        personDatabase.add(person6);

        nameFoundExpected.add(person4);
        addressFoundExpected.add(person6);
        phoneNumberFoundExpected.add(person5);

        Assertions.assertEquals(nameFoundExpected, personDatabase.findByName("Oleg"));
        Assertions.assertEquals(addressFoundExpected, personDatabase.findByAddress("China"));
        Assertions.assertEquals(phoneNumberFoundExpected, personDatabase.findByPhone("781245"));

        personDatabase.delete(1);
        personDatabase.delete(5);

        nameFoundExpected.remove(person1);
        phoneNumberFoundExpected.remove(person5);

        Assertions.assertEquals(nameFoundExpected, personDatabase.findByName("Oleg"));
        Assertions.assertEquals(addressFoundExpected, personDatabase.findByAddress("China"));
        Assertions.assertEquals(phoneNumberFoundExpected, personDatabase.findByPhone("781245"));
    }

    @Test
    @DisplayName("Test add, delete and find in multi threads")
    public void testAddDeleteAndFindMultiThreads() throws InterruptedException {
        PersonDatabase personDatabase = new Database();

        List<Thread> threadList = new ArrayList<>();
        threadList.add(new Thread(() -> {
            for (int j = 0; j < 100; ++j) {
                personDatabase.add(new Person(j, "Name" + j, "Address" + j, "PhoneNumber" + j));
            }
        }));
        threadList.add(new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 75; ++i) {
                personDatabase.delete(i);
            }
        }));

        for (Thread thread : threadList) {
            thread.start();
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        Thread nameFoundThreadEmpty = new Thread(() -> {
            for (int i = 0; i < 75; i++) {
                Assertions.assertTrue(personDatabase.findByName("Name" + i).isEmpty());
            }
        });

        Thread addressFoundThreadEmpty = new Thread(() -> {
            for (int i = 0; i < 75; i++) {
                Assertions.assertTrue(personDatabase.findByAddress("Address" + i).isEmpty());
            }
        });

        Thread phoneFoundThreadEmpty = new Thread(() -> {
            for (int i = 0; i < 75; i++) {
                Assertions.assertTrue(personDatabase.findByPhone("PhoneNumber" + i).isEmpty());
            }
        });

        Thread nameFoundThread = new Thread(() -> {
            for (int i = 75; i < 100; i++) {
                Assertions.assertTrue(personDatabase.findByName("Name" + i)
                    .contains(new Person(i, "Name" + i, "Address" + i, "PhoneNumber" + i)));
            }
        });

        Thread addressFoundThread = new Thread(() -> {
            for (int i = 75; i < 100; i++) {
                Assertions.assertTrue(personDatabase.findByAddress("Address" + i)
                    .contains(new Person(i, "Name" + i, "Address" + i, "PhoneNumber" + i)));
            }
        });

        Thread phoneFoundThread = new Thread(() -> {
            for (int i = 75; i < 100; i++) {
                Assertions.assertTrue(personDatabase.findByPhone("PhoneNumber" + i)
                    .contains(new Person(i, "Name" + i, "Address" + i, "PhoneNumber" + i)));
            }
        });

        nameFoundThreadEmpty.start();
        addressFoundThreadEmpty.start();
        phoneFoundThreadEmpty.start();
        nameFoundThread.start();
        addressFoundThread.start();
        phoneFoundThread.start();

        nameFoundThreadEmpty.join();
        addressFoundThreadEmpty.join();
        phoneFoundThreadEmpty.join();
        nameFoundThread.join();
        addressFoundThread.join();
        phoneFoundThread.join();
    }
}
