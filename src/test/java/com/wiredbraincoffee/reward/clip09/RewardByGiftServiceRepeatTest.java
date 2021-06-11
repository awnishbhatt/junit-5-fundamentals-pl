package com.wiredbraincoffee.reward.clip09;

import com.wiredbraincoffee.reward.RewardByGiftService;
import com.wiredbraincoffee.reward.RewardInformation;
import com.wiredbraincoffee.reward.RewardService;
import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RewardByGiftServiceRepeatTest implements TestHelper {
    private RewardByGiftService reward = null;

    @BeforeEach
    void setUp() {
        reward = new RewardByGiftService();
        reward.setNeededPoints(100);
        System.out.println("setUp called");
    }

    @DisplayName("When gift product is not in order, reward should not be applied")
    void giftProductNotInOrder() {
        reward.setGiftProductId(getRandomProductIdNotInOrder());

        RewardInformation info = reward.applyReward(
                getSampleOrder(), 200);

        assertEquals(0, info.getDiscount());
        assertEquals(0, info.getPointsRedeemed());
    }

    private long getRandomProductIdNotInOrder() {
        Random r = new Random();
        return r.longs(1000,2000)
                .findFirst().getAsLong();
    }

    @Override
    public RewardService getRewardService() {
        return reward;
    }
}
