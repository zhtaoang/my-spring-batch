package com.tao.myspringbatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    CustomJobLauncher launcher;

    @Test
    public void contextLoads() throws InterruptedException {
        launcher.run();
        Thread.sleep(10000);
    }


}
