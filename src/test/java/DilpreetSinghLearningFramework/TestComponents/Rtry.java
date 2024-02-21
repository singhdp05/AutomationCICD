package DilpreetSinghLearningFramework.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Rtry implements IRetryAnalyzer { // if you are implementing an interface its your duty to implement all
												// the methods which are exposed by the interface

	int count=0;
	int maxTry=1;
	
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxTry)
		{
			count++;
			return true;
		}
		return false;
	}

}
