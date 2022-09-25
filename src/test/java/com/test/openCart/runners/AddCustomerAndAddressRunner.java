package com.test.openCart.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/openCart",
        glue = "com/test/openCart/stepDefiniitions",
        dryRun = false,
        tags = "@regression",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}
)
public class AddCustomerAndAddressRunner {
}
