package ListenersDemo;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

public class CustomListners extends BaseListeners implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Failed Test");
        try {
            failed();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
