package com.xenia.mobile.tests;
import com.google.common.io.Files;
import com.xenia.mobile.framework.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() throws IOException {
        // Capabilities caps = new DesiredCapabilities();
        app.init();
    }

    @AfterSuite(enabled = false)
    public void tearDown() throws InterruptedException {
      //  app.board().clearBoardList();
        app.stop();
    }

    @BeforeMethod
    public void startLogger(Method m) {
        logger.info("start test" + m.getName());
    }
    @AfterMethod(alwaysRun = true)
    public void stopLogger(Method m) {
        logger.info("stop test" + m.getName());
    }
}