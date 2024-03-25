import static org.junit.Assert.*;

import com.neostore.domain.exception.validation.EmailValidation;
import org.junit.Test;

public class EmailServiceTest {

    @Test
    public void testEmailValidation() {
        assertTrue(EmailValidation.validate("valido@example.com"));
        assertFalse(EmailValidation.validate("invalido"));
    }
}
