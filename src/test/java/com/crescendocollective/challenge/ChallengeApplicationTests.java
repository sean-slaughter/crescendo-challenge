package com.crescendocollective.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ChallengeApplicationTests {

    @Autowired
    private YelpController yelpController;

    @Autowired
    private YelpService yelpService;

    @Test
    void contextLoads() {
        assertThat(yelpController).isNotNull();
        assertThat(yelpService).isNotNull();
    }

}
