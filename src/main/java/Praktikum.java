public class Praktikum {
    static String testAccName = "Чеби Чебурашка";

    public static void main(String[] args) {
        Account account = new Account(testAccName);
        System.out.println(account.checkNameToEmboss());
    }
}