package stepDefinations;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "Features",
glue = {"stepDefinations"},
tags = "@activity1_3"
)
public class ActivitiesRunner2 {

}
