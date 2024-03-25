import static org.junit.Assert.*;

import com.neostore.domain.exception.validation.CnpjValidation;
import org.junit.Test;


public class CnpjServiceTest {

    @Test
    public void testCnpjValidation() {
        assertTrue(CnpjValidation.validate("34.574.543/0001-98"));
        assertFalse(CnpjValidation.validate("34.574.543/0001-99"));
    }
}
