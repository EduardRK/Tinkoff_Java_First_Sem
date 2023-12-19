package edu.hw10;

import edu.hw10.Task1.Classes.MyClass;
import edu.hw10.Task1.Classes.MyRecord;
import edu.hw10.Task1.RandomObjectGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    @DisplayName("Test random class generator constructor")
    public void randomClassGeneratorConstructor() {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator(MyClass.class);

        for (int i = 0; i < 1_000; ++i) {
            MyClass myClass = (MyClass) randomObjectGenerator.nextObject();

            Assertions.assertTrue(myClass.getValue() >= -1_000 && myClass.getValue() <= 5_000);
            Assertions.assertNotNull(myClass.getName());
        }
    }

    @Test
    @DisplayName("Test random class generator factory method")
    public void randomClassGeneratorFactoryMethod() {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator(MyClass.class);

        for (int i = 0; i < 1_000; ++i) {
            MyClass myClass = (MyClass) randomObjectGenerator.nextObject("create");

            Assertions.assertTrue(myClass.getValue() >= -1_000 && myClass.getValue() <= 5_000);
            Assertions.assertNotNull(myClass.getName());
        }
    }

    @Test
    @DisplayName("Test random record generator constructor")
    public void randomRecordGenerator() {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator(MyRecord.class);

        for (int i = 0; i < 1_000; ++i) {
            MyRecord myRecord = (MyRecord) randomObjectGenerator.nextObject();

            Assertions.assertTrue(myRecord.valueFirst() >= -10_000 && myRecord.valueFirst() <= 10_000);
            Assertions.assertTrue(myRecord.valueSecond() >= -10_000 && myRecord.valueSecond() <= 10_000);
            Assertions.assertNotNull(myRecord.string());
        }
    }

    @Test
    @DisplayName("Test random record generator factory method")
    public void randomRecordFactoryMethod() {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator(MyRecord.class);

        Assertions.assertThrows(Exception.class, () -> randomObjectGenerator.nextObject("create"));
    }
}
