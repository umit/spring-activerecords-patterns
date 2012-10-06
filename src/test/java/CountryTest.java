import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.umitunal.model.Country;

import java.util.UUID;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


/**
 * Created by IntelliJ IDEA.
 * User: umitunal
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class CountryTest {

    @Before
    public void setUp()  {
      for (int i = 1; i<=100;i++){
          String name = UUID.randomUUID().toString();
          String code = UUID.randomUUID().toString();
          new Country(name, code).persist();
      }
    }

    @Test
    public void testFindAll() {
         assertEquals(100, Country.findAll().size());
    }


    @Test
    public void testPersist() {
        String name = UUID.randomUUID().toString();
        String code = UUID.randomUUID().toString();
        new Country(name, code).persist();
    }

    @Test
    public void testFindById() throws Exception {
        for (Country country : Country.findAll()) {
            assertNotNull(country.getId());
            Country expectedCountry = Country.findById(country.getId());
            assertNotNull(expectedCountry);
        }
    }
}
