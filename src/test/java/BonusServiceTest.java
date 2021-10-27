import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateBonusBelowLimitForRegistered() {
        BonusService service = new BonusService();
        //входные данные
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;
        //вызываем метод
        long actual = service.calculate(amount, registered);
        //проверка
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateBonusOverLimitForRegistered() {
        BonusService service = new BonusService();
        //входные данные
        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;
        //вызываем метод
        long actual = service.calculate(amount, registered);
        //проверка
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateBonusBelowLimitUnRegistered() {
        BonusService service = new BonusService();
        //входные данные
        long amount = 1_000_60;
        boolean registered = false;
        long expected = 10;
        //вызываем метод
        long actual = service.calculate(amount, registered);
        //проверка
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateBonusOverLimitUnRegistered() {
        BonusService service = new BonusService();
        //входные данные
        long amount = 1_000_000_60;
        boolean registered = false;
        long expected = 500;
        //вызываем метод
        long actual = service.calculate(amount, registered);
        //проверка
        assertEquals(expected, actual);
    }
}