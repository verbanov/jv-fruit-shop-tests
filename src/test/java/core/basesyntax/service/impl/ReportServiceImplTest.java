package core.basesyntax.service.impl;

import static org.junit.Assert.assertTrue;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ReportServiceImplTest {
    private ReportService reportService;

    @Before
    public void setUp() {
        reportService = new ReportServiceImpl();
    }

    @Test (expected = RuntimeException.class)
    public void getReport_fruitsNull_notOk() {
        reportService.getReport(null);
    }

    @Test (expected = RuntimeException.class)
    public void getReport_fruitsEmpty_notOk() {
        List<Fruit> emptyList = new ArrayList<>();
        reportService.getReport(emptyList);
    }

    @Test
    public void getReport_fruitsRight_Ok() {
        String expected = "fruit,quantity" + System.lineSeparator()
                + "orange,1520" + System.lineSeparator() + "kiwi,900";
        List<Fruit> fruitsList = new ArrayList<>();
        fruitsList.add(new Fruit("orange", 1520));
        fruitsList.add(new Fruit("kiwi", 900));
        String actual = reportService.getReport(fruitsList);
        assertTrue(expected.equals(actual));
    }
}
