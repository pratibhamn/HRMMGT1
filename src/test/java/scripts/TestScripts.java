package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import generic.BasePage;
import generic.BaseTest;
import generic.ExcelFile;
import generic.GenericUtils;
import pom.HomePage;

public class TestScripts  extends BaseTest{
	@Test(enabled=false)
	public void testCreateEmployee() {
		HomePage pi=new HomePage(driver);
		pi.setUserName("Admin");
		pi.setPwd("admin123");
		pi.clickLogin();
		BasePage.verifyTitle("OrangeHRM");
		pi.clickPim_Menu();
		pi.clickAddEmp_Menu();
		pi.setFirstName("Lilly");
		pi.setLastName("Fernandes");
		pi.clickSaveBtn();
		pi.verifyFirstName("Lilly");
		
	}
	@Test(enabled=true)
	public void testSortListBox() throws EncryptedDocumentException, InvalidFormatException, IOException {
		HomePage pi=new HomePage(driver);
		pi.setUserName(ExcelFile.readData("Sheet1", 0, 1));
		pi.setPwd(ExcelFile.readData("Sheet1", 1, 1));
		pi.clickLogin();
		BasePage.verifyTitle("OrangeHRM");
		pi.clickPim_Menu();
		pi.clickEmp_List();
		GenericUtils.sortListBox(driver.findElement(By.xpath("//select[@id='empsearch_job_title']")));
	}

}
