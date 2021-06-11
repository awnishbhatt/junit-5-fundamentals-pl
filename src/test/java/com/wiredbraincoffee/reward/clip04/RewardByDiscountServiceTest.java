package com.wiredbraincoffee.reward.clip04;

import com.wiredbraincoffee.product.Product;
import com.wiredbraincoffee.reward.RewardByDiscountService;
import com.wiredbraincoffee.reward.RewardInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardByDiscountServiceTest {
    private RewardByDiscountService reward = null;

    @BeforeEach
    void setUp() {
        reward = new RewardByDiscountService();
    }

    @Test
    void setNeededPoints() {
        reward.setNeededPoints(100);

        assertEquals(100, reward.getNeededPoints());
    }

    @Test
    void setPercentageForPoints() {
        reward.setPercentage(0.1);

        assertEquals(0.1, reward.getPercentage());
    }

    @Test
    void zeroCustomerPoints() {
        reward.setPercentage(0.1);
        reward.setNeededPoints(100);
        Product smallDecaf = new Product(1, "Small Decaf", 1.99);
        List<Product> order = Collections.singletonList(smallDecaf);

        RewardInformation info = reward.applyReward(order, 0);

        assertEquals(0, info.getDiscount());
        assertEquals(0, info.getPointsRedeemed());
    }
}
