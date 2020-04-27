package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "@target/rerun.txt",  //change it to txt created by failing test
        strict = false,
        plugin= {
                "html:target/failed-default-report", // report will be seperate by adding failed
                "json:target/failed_report.json",  // new profile not overriding original report
                "rerun:target/rerun.txt"
        }
)
public class FailedRunner {

        //normal runner ina plug in koyuyorsun oyle run ediyorsun o plugin de txt fail ederse oraya atiyor senin failedRunner die bir runner in var zaten surekli vardi o
        // onceden create ettigin oda feature olarak o txt yi cekiyor sende o runnera girip run ettiginde onceki fail edilmisi run etmis oluosun
}
