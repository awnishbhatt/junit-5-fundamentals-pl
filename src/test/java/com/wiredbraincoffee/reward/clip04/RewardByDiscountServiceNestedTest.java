package com.wiredbraincoffee.reward.clip04;

import com.wiredbraincoffee.product.Product;
import com.wiredbraincoffee.reward.RewardByDiscountService;
import com.wiredbraincoffee.reward.RewardInformation;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardByDiscountServiceNestedTest {
    private RewardByDiscountService reward = null;

    @BeforeEach
    void setUp() {
        reward = new RewardByDiscountService();
        reward.setPercentage(0.1);
        reward.setNeededPoints(100);
    }

    @Test
    void checkPercentageAndNeededPoints() {
        assertEquals(0.1, reward.getPercentage());
        assertEquals(100, reward.getNeededPoints());
    }

    @Nested
    class SmallOrder {
        private List<Product> smallOrder = null;

        @BeforeEach
        void setUp() {
            Product smallDecaf = new Product(1, "Small Decaf", 1.99);
            smallOrder = Collections.singletonList(smallDecaf);
        }

        @Nested
        class ZeroPoints {
            private RewardInformation info = null;

            @BeforeEach
            void setUp() {
                info = reward.applyReward(smallOrder, 0);
            }

            @Test
            void checkDiscount() {
                assertEquals(0, info.getDiscount());
            }

            @Test
            void checkPointsRedeemed() {
                assertEquals(0, info.getPointsRedeemed());
            }
        }
    }

    @Nested
    class BigOrder {
        private List<Product> bigOrder = null;

        @BeforeEach
        void setUp() {
            Product bigDecaf = new Product(2, "Big Decaf", 2.49);
            Product bigLatte = new Product(3, "Big Latte", 2.99);
            Product bigTea = new Product(4, "Big Tea", 2.99);
            Product espresso = new Product(5, "Espresso", 2.99);
            bigOrder = Arrays.asList(
                    bigDecaf, bigLatte, bigTea, espresso);
        }

        @Test
        void enoughCustomerPointsForDiscountInBigOrder() {
            RewardInformation info = reward.applyReward(bigOrder, 200);

            assertEquals(1.14, info.getDiscount(), 0.01);
            assertEquals(100, info.getPointsRedeemed());
        }
    }
}
