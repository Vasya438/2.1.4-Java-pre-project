import app.config.AppConfig;
import app.model.AnimalsCage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {AppConfig.class}
)
public class MainTest {
    @Autowired
    private ApplicationContext applicationContext;

    public MainTest() {
    }

    @Test
    public void mainTest() {
        long time = 0L;

        for(int i = 0; i < 5; ++i) {
            AnimalsCage bean = (AnimalsCage)this.applicationContext.getBean(AnimalsCage.class);
            if (i == 0) {
                time = bean.getTimer().getTime();
            } else {
                Assert.assertEquals("Тест провален, не корректная реализация бинов.", Optional.of(time), bean.getTimer().getTime());
                System.out.println(time);
            }
        }

    }
}