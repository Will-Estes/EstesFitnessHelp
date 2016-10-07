import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.estesfitnesshelp.model.business.AllBusinessTests;
import com.estesfitnesshelp.model.services.AllTests;

@RunWith(Suite.class)
@SuiteClasses({AllBusinessTests.class, AllTests.class})
public class ApplicationTestSuite {

}
