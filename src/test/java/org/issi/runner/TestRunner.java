package org.issi.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Appfeatures/BidsAndProposals/TF25_RFPandProposals.feature"},
        //src/test/resources/Appfeatures/TF04_AgencyOrFirm.feature
        glue = {"org.issi.stepdefinitions","org.issi.hooks"},
        dryRun = false, // to check mapping make it 'true' (or) to execute your script make sure 'dryRun' should be in 'false'
        tags = "@History",
        //"@CapturePlanTab or @RequirementsTab",
        //tags = "not @regression or @smoke or @sanity",
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                // "timeline:test-output-thread/"
        }
)
public class TestRunner {
 }
