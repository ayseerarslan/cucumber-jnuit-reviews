package com.cydeo.step_definitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before // it should come be from cucumber java NOT JUNIT
    public void setUp(){
        System.out.println("Set Up Before each scenario in the project");
    }

    @After // it should come be from cucumber java NOT JUNIT
    public void tearDown(){
        BrowserUtils.sleep(1);
        System.out.println("tearDown After each scenario in the project");
        Driver.closeDriver();
    }
}
