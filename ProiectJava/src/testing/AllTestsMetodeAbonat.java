package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCaseLoadPersoane.class, TestCaseInserAbonat.class, TestCaseGetAbonatById.class })
public class AllTestsMetodeAbonat {

}
