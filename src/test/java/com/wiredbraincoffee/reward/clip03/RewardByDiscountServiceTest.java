package com.wiredbraincoffee.reward.clip03;

import com.wiredbraincoffee.product.Product;
import com.wiredbraincoffee.reward.RewardByDiscountService;
import com.wiredbraincoffee.reward.RewardInformation;
import org.junit.jupiter.api.*;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RewardByDiscountServiceTest {

    RewardByDiscountServiceTest() {
        System.out.println("Constructor");
    }

    @BeforeAll
    static void setUpAll() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("AfterAll");
    }

    @Test
    void setNeededPoints() {
        System.out.println("Test setNeededPoints");
        RewardByDiscountService reward = new RewardByDiscountService();

        reward.setNeededPoints(100);

        assertEquals(100, reward.getNeededPoints());
    }

    @Test
    void setPercentageForPoints() {
        System.out.println("Test setPercentageForPoints");
        RewardByDiscountService reward = new RewardByDiscountService();

        reward.setPercentage(0.1);

        assertEquals(0.1, reward.getPercentage());
    }

    @Test
    void zeroCustomerPoints() {
        System.out.println("Test zeroCustomerPoints");
        RewardByDiscountService reward = new RewardByDiscountService();
        Product smallDecaf = new Product(1, "Small Decaf", 1.99);
        List<Product> order = Collections.singletonList(smallDecaf);

        RewardInformation info = reward.applyReward(order, 0);

        assertEquals(0, info.getDiscount());
    }
}
