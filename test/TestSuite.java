import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import medium.TestAdminFunctionalityMenu;
import medium.TestMenuHandler;
import medium.TestUserInputAdminCustomer;
import medium.TestUserInputHandler;
import easy.TestCreateCustomer;
import easy.TestConfigureEventDetails;
import easy.TestCustomerPurchase;
import hard.TestAdminInput;
import hard.TestDoShoppingScenarios;
import hard.TestExceptionLogger;
import hard.TestUserInputIncorrectInput;
import easy.TestCustomerCancelation;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    TestCreateCustomer.class, 
    TestConfigureEventDetails.class, 
    TestCustomerPurchase.class, 
    TestCustomerCancelation.class,
    TestAdminFunctionalityMenu.class,
    TestMenuHandler.class,
    TestUserInputAdminCustomer.class,
    TestUserInputHandler.class,
    TestAdminInput.class,
    TestAdminInput.class,
    TestExceptionLogger.class,
    TestUserInputIncorrectInput.class,
    TestDoShoppingScenarios.class

})
    
public class TestSuite {
    
}
