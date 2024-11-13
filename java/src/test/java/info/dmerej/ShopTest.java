package info.dmerej;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopTest {

    private final Address fsfAddress = new Address(
        "51 Franklin Street",
        "Fifth Floor",
        "Boston",
        "02110",
        "USA"
    );

    private final Address parisAddress = new Address(
        "33 quai d'Orsay",
        "",
        "Paris",
        "75007",
        "France"
    );

    //Added peronna to facilitate the use cases in the tests
    private final User majorVerifiedUser = new User("Bob", "bob@domain.tld", 25, true, fsfAddress);
    private final User minorVerifiedUser = new User("Alice", "alice@domain.tld", 16, true, fsfAddress);
    private final User minorNotVerifiedUser = new User("Bob", "bob@domain.tld", 16, false, fsfAddress);
    private final User majorNotVerifiedUser = new User("Bob", "bob@domain.tld", 25, false, parisAddress);


    @Test
    public void happy_path() {
        //final User user = new User("Bob", "bob@domain.tld", 25, true, fsfAddress);

        assertTrue(Shop.canOrder(majorVerifiedUser));
        assertFalse(Shop.mustPayForeignFee(majorVerifiedUser));
    }

    @Test
    public void minors_cannot_order_from_shop() {
        //final User user = new User("Bob", "bob@domain.tld", 16, true, fsfAddress);

        assertFalse(Shop.canOrder(minorVerifiedUser));
    }

    @Test
    public void must_be_verified_to_order_from_shop() {
        //final User user = new User("Bob", "bob@domain.tld", 16, false, fsfAddress);

        assertFalse(Shop.canOrder(minorNotVerifiedUser));
    }

    @Test
    public void foreigners_must_pay_foreign_fee() {
        //final User user = new User("Bob", "bob@domain.tld", 25, false, parisAddress);

        assertTrue(Shop.mustPayForeignFee(majorNotVerifiedUser));
    }

}
