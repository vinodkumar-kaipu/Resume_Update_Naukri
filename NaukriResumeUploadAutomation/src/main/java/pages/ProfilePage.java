package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.WaitUtils;

public class ProfilePage {

	WebDriver driver;

	private By viewProfile = By.xpath("/html/body/main/div/div/div[3]/div/div[3]/div[2]/a");
	private By uploadResume = By.xpath("//input[@value='Update resume']");

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	public void uploadResume() throws AWTException {
		WaitUtils.waitForClickable(driver, viewProfile);
		driver.findElement(viewProfile).click();

		WaitUtils.waitForVisible(driver, uploadResume).click();
//		sendKeys(ConfigReader.get("resumePath"));
		
		String resumePath = ConfigReader.get("resumePath");

        File file = new File(resumePath).getAbsoluteFile();
        if (!file.exists()) {
            throw new RuntimeException("Resume file not found: " + file.getPath());
        }

        // Step 4: Copy file path to clipboard
        StringSelection s = new StringSelection(file.getPath());
        Toolkit.getDefaultToolkit()
               .getSystemClipboard()
               .setContents(s, null);

        // Step 5: Robot actions (CTRL + V + ENTER)
        Robot r = new Robot();
        r.setAutoDelay(800);

        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);

        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("Resume upload attempted using Robot class");
		
		
	}
}
