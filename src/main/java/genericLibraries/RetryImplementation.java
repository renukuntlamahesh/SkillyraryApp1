package genericLibraries;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer  
{
	int maxReties=3;
	int count=0;

	@Override
	public boolean retry(ITestResult result) {
				if(count<maxReties)
				{
					count++;
					return true;
				}
				return false;
	}
	

}
