package com.crm.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.qa.base.Base;

public class FailedScreenShots extends Base implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		  // TODO Auto-generated method stub
		  
		 }
		public void onTestSuccess(ITestResult result) {
		  // TODO Auto-generated method stub
		 
		 }
		public void onTestFailure(ITestResult result) {
		  System.out.println("Failed Test Method");
		  failedscreenshot(result.getMethod().getMethodName());
		  
		 }
		public void onTestSkipped(ITestResult result) {
		  // TODO Auto-generated method stub
		  
		 }
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		  // TODO Auto-generated method stub
		 }
		public void onStart(ITestContext context) {
		  // TODO Auto-generated method stub
		  
		 }
		public void onFinish(ITestContext context) {
		  // TODO Auto-generated method stub
		  
		 }
		
}

