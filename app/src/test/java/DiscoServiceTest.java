import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dto.Discoteca;

public class DiscoServiceTest {

    @Mock
    Discoteca discoteca;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void executeGetDiscosTest() {

    }

}
