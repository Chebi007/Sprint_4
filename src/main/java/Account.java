public class Account {
    private final String accName;
    // Регулярное выражение (только один пробел, не в начале и не в конце)
    private final String regex = "^(?=.{3,19}$)([a-zа-яёA-ZА-ЯЁ0-9]{1,19})+([\\s](?![\\s]))+([a-zа-яёA-ZА-ЯЁ0-9]{1,19})";

    public Account(String accName) {
        this.accName = accName;
    }

    /**
     * Метод - предикат. Проверка сохраненной через конструктор строки.
     * Валидация строки не более 19 символов и соответствие регулярному выражению.
     *
     * @return true если строка соответствует условиям, false если не соответствует.
     */
    public boolean checkNameToEmboss() {
        return (accName.length() <= 19 && accName.matches(regex));
    }
}