package techUplabs.CommonUtil.Hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import techUplabs.CommonUtil.BaseUtil.BaseClass;

public class CucumberHooks extends BaseClass {

    private BaseClass base;
    public CucumberHooks(BaseClass base){
        this.base = base;
    }

    @Before()
    public void BeforeTest(Scenario scenario){
        base.log.info("***********Test Execution Started**********");
    }

    @After
    public void tearDown(){
        base.log.info("***********Test Execution Ends************");
    }
}
