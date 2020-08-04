package example.java.spring.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Executors;

@Controller
public class CreateLoadController {

    public static final int BUSY_TIME_MINUTES = 10;

    @RequestMapping(value = "/getbusy", method = RequestMethod.GET)
	@ResponseBody
	public String status() {
        new ExpensiveTask().execute();
		return "<h1>Busy!</h1>\n";
	}

    private class ExpensiveTask {
        public void execute() {
            Executors.newFixedThreadPool(1).submit(new BusyTask(BUSY_TIME_MINUTES * 60));
        }

    }
}

class BusyTask implements Runnable {

    private final double busyTimeSeconds;

    public BusyTask(double busyTimeSeconds) {
        this.busyTimeSeconds = busyTimeSeconds;
    }

    @Override
    public void run() {
        long endTime = (long) (currentTime() + (busyTimeSeconds * 1000));

        while (currentTime() < endTime) {
            fib(30);
        }
    }

    private int fib(int n) {
        if (n < 2) { return 1; } else { return fib(n-1) + fib(n-2); }
    }

    private long currentTime() {
        return System.currentTimeMillis();
    }
}