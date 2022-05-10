package com.dfz.sucurity;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * test
 *
 * @author 花葱
 * @date 2022/1/22 11:37
 */
@Slf4j
public class EncoderTest {

    @Test
    public void encoderPass() {
        log.info(new BCryptPasswordEncoder().encode("pwd"));
    }

}
