package example.java.spring.app;

import example.java.spring.app.BusyTask;
import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BusyTaskTest {

    @Test
    public void runsForSpecifiedNumberAmountOfTime() {

        BusyTask task = new BusyTask(1.2);

        long startTime = currentTime();
        task.run();
        long duration = currentTime() - startTime;

        assertThat(duration, is(greaterThan(1100L)));
        assertThat(duration, is(lessThan(1300L)));
    }

    private long currentTime() {
        return System.currentTimeMillis();
    }
}
