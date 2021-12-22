import driver.DriverFactory;
import org.testng.annotations.BeforeMethod;

public class BaseTest{

    @BeforeMethod
    public void initTest(){
        new DriverFactory().initDriver(System.getProperty("browser"));
    }
}
