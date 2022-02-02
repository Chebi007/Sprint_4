import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class AccountTest {
    private final String accName;
    private final boolean expectedResult;

    public AccountTest(String accName, boolean expectedResult) {
        this.accName = accName;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "{index}: Значение({0})=Ожидаемый результат({1})")
    public static Object[][] accNameData() {
        return new Object[][] {
                // Валидное значение: строка в диапазоне от 3 до 19 символов, пробел между символами (14)
                {"Чеби Чебурашка", true},
                // Валидное значение: строка 3 символа, пробел между символами
                {"Ч Б", true},
                // Невалидное значение: строка 4 символа без пробелов
                {"Чеби", false},
                // Невалидное значение: строка 2 символа без пробелов
                {"ЧБ", false},
                // Невалидное значение: строка 20 символов с пробелом
                {"Чеби Чебурашка123456", false},
                // Невалидное значение: строка 15 символов с пробелом в начале
                {" ЧебиЧебурашка", false},
                // Невалидное значение: строка 15 символов с пробелом в конце
                {"ЧебиЧебурашка ", false},
                // Невалидное значение: пустая строка
                {"", false},
                // Невалидное значение: строка с одним символом - пробелом
                {" ", false},
                // Невалидное значение: строка 18 символов с пробелами между символами
                {"Чеби Чебурашка Чеб", false},
        };
    }

    @Test
    @Description("Check name to emboss")
    public void checkNameToEmbossTest() {
        Account account = new Account(accName);
        boolean actualResult = account.checkNameToEmboss();
        assertEquals("Проверьте логику метода checkNameToEmboss() и корректность тестовых данных",
                expectedResult, actualResult);
    }
}