package unipa.fooddelivery;

import org.junit.jupiter.api.*;


public class DataBaseTest {

    @Test
    public void dataBaseTest() {
        Assertions.assertNotNull(DataBase.getInstance(), "Singleton instance should not be null!");
    }
}