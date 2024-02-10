import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregistredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1500;
        boolean registred = false;
        long expected = 15;

        long actual = service.calculate(amount, registred);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateForUnregistredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 100_000;
        boolean registred = false;
        long expected = 500;

        long actual = service.calculate(amount, registred);

        Assertions.assertEquals(expected, actual);
    }
}