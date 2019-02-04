package test.needstests;

import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

    @Test
    public void notWorkingInThisEnvironment() {
        Assume.assumeTrue(false);
    }

    @Test
    public void passing0() {}

    @Test
    public void passing1() {}

    @Test
    public void passing2() {}

    @Test
    public void passing3() {}

    @Test
    public void passing4() {}

    @Test
    public void passing5() {}

    @Test
    public void passing6() {}

    @Test
    public void passing7() {}

    @Test
    public void passing8() {}

    @Test
    public void passing9() {}

}

