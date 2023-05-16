package com.assessment.juniter.config;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.assessment.juniter.entity.Item;
import com.assessment.juniter.service.ItemService;

@Component
public class ItemDataLoader implements CommandLineRunner {

        @Autowired
        private ItemService itemService;

        @Override
        public void run(String... args) throws Exception {
                // Add Default Data to Test
                List<Item> defaultItem = Arrays.asList(
                                new Item("item_a", "user_a", LocalDateTime.now(), 10.0, 15.0, LocalDateTime.now(),
                                                "user_p",
                                                ItemStatus.AVAILABLE),
                                new Item("item_b", "user_b", LocalDateTime.now(), 20.0, 25.0, LocalDateTime.now(),
                                                "user_q",
                                                ItemStatus.SOLD),
                                new Item("item_c", "user_c", LocalDateTime.now(), 30.0, 35.0, LocalDateTime.now(),
                                                "user_r",
                                                ItemStatus.AVAILABLE),
                                new Item("item_d", "user_d", LocalDateTime.now(), 40.0, 45.0, LocalDateTime.now(),
                                                "user_s",
                                                ItemStatus.AVAILABLE),
                                new Item("item_e", "user_e", LocalDateTime.now(), 50.0, 55.0, LocalDateTime.now(),
                                                "user_t",
                                                ItemStatus.SOLD),
                                new Item("item_f", "user_f", LocalDateTime.now(), 60.0, 65.0, LocalDateTime.now(),
                                                "user_u",
                                                ItemStatus.AVAILABLE),
                                new Item("item_g", "user_g", LocalDateTime.now(), 70.0, 75.0, LocalDateTime.now(),
                                                "user_v",
                                                ItemStatus.AVAILABLE),
                                new Item("item_h", "user_h", LocalDateTime.now(), 80.0, 85.0, LocalDateTime.now(),
                                                "user_w",
                                                ItemStatus.AVAILABLE),
                                new Item("item_i", "user_i", LocalDateTime.now(), 90.0, 95.0, LocalDateTime.now(),
                                                "user_x",
                                                ItemStatus.SOLD));

                itemService.createDefaultItemList(defaultItem);
        }

}
