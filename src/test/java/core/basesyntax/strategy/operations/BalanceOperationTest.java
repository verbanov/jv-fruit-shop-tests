package core.basesyntax.strategy.operations;

//import static org.junit.Assert.assertTrue;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.StorageFruits;
import core.basesyntax.exceptions.WrongDataException;
//import core.basesyntax.model.Fruit;
//import core.basesyntax.model.FruitTransaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BalanceOperationTest {
    private BalanceOperation balanceOperation;
    private FruitDao fruitDao;

    @Before
    public void setUp() throws Exception {
        fruitDao = new FruitDaoImpl();
        balanceOperation = new BalanceOperation(fruitDao);
    }

    @Test (expected = WrongDataException.class)
    public void apply_dailyTransactionNull_notOk() {
        balanceOperation.apply(null);
    }

    /*@Test
    public void apply_allOk() {
        FruitTransaction fruitTransaction = new FruitTransaction(
                FruitTransaction.Operation.BALANCE, "kiwi", 200);
        balanceOperation.apply(fruitTransaction);
        Fruit actual = StorageFruits.fruits.get(0);
        Fruit expected = new Fruit("kiwi", 200);
        boolean isEqual = actual.equals(expected);
        assertTrue(isEqual);
    }
    */

    @After
    public void tearDown() throws Exception {
        StorageFruits.fruits.clear();
    }
}
