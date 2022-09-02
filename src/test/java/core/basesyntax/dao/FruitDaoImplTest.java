package core.basesyntax.dao;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.StorageFruits;
import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitDaoImplTest {
    private static FruitDao fruitDao;
    private static Fruit fruit;

    @BeforeClass
    public static void beforeClass() {
        fruitDao = new FruitDaoImpl();
        fruit = new Fruit("orange", 10);
    }

    @Test(expected = RuntimeException.class)
    public void add_nullFruit_notOk() {
        fruitDao.add(null);
    }

    @Test
    public void add_notNullFruit_Ok() {
        List<Fruit> expectedFruits = new ArrayList<>();
        expectedFruits.add(fruit);
        fruitDao.add(fruit);
        Fruit actual = StorageFruits.fruits.get(0);
        Fruit expected = expectedFruits.get(0);
        assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void get_nullFruitName_notOk() {
        fruitDao.get(null);
    }

    @Test(expected = RuntimeException.class)
    public void get_EmptyFruitName_notOk() {
        fruitDao.get("");
    }

    @Test
    public void get_notNullFruitName_Ok() {
        StorageFruits.fruits.add(fruit);
        Fruit expected = fruit;
        Fruit actual = fruitDao.get(fruit.getFruitName());
        assertEquals(expected,actual);
    }

    @Test
    public void getAll_Ok() {
        Fruit fruitApple = new Fruit("Apple", 1000);
        List<Fruit> expectedFruits = new ArrayList<>();
        expectedFruits.add(fruit);
        expectedFruits.add(fruitApple);
        StorageFruits.fruits.add(fruit);
        StorageFruits.fruits.add(fruitApple);
        List<Fruit> actual = fruitDao.getAll();
        assertEquals(expectedFruits, actual);
    }

    @After
    public void tearDown() {
        StorageFruits.fruits.clear();
    }
}
