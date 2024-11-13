package info.dmerej;

public class Shop {
    public static boolean canOrder(User user) {
        boolean major = user.age() >= 18;
        boolean verified = user.verified();
        //Should check if the user is verified when returning
        return major && verified;
    }

    public static boolean mustPayForeignFee(User user) {
        return !user.addres().country().equals("USA");
    }
}
