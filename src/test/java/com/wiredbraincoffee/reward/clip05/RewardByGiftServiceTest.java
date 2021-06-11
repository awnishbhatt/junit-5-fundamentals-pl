package com.wiredbraincoffee.reward.clip05;

import com.wiredbraincoffee.product.Product;
import com.wiredbraincoffee.reward.RewardByGiftService;
import com.wiredbraincoffee.reward.RewardInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

public class RewardByGiftServiceTest {
    private RewardByGiftService reward = null;

    @BeforeEach
    void setUp() {
        reward = new RewardByGiftService();
        reward.setGiftProductId(4);
        reward.setNeededPoints(100);
    }

    private List<Product> buildSampleOrder(int numberOfProducts) {
        return IntStream.range(1, numberOfProducts)
                .mapToObj(i -> new Product(i, "Product " + i, 2.99))
                .collect(toList());
    }
}
