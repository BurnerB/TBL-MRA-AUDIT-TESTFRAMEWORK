package StepDefinitions;


import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import gherkin.lexer.Th;
import io.cucumber.java.DataTableType;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BaseClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;




@RunWith(Cucumber.class)
public class stepDefinitions extends BaseClass  {
    public Properties Pro;
    public WebDriverWait five;
    public WebDriverWait ten ;
    public WebDriverWait fifteen;
    public WebDriverWait twenty ;
    public WebDriverWait twentyfive;
    public WebDriverWait thirty;
    public WebDriverWait thirtyfive;
    public WebDriverWait fourty;
    public WebDriverWait fourtyfive;
    public WebDriverWait fifty;
    public WebDriverWait fiftyfive;
    public WebDriverWait sixty;
    public WebDriverWait sixtyfive;
    public WebDriverWait seventy;
    public WebDriverWait seventyfive;
    public WebDriverWait eighty;
    public WebDriverWait eightyfive;
    public WebDriverWait ninety;
    public WebDriverWait ninetyfive;
    public WebDriverWait onehundred;
    public WebDriverWait twohundred;



    public static sharedatastep sharedata;


    public stepDefinitions(sharedatastep sharedata) {

        stepDefinitions.sharedata = sharedata;

    }

    @Before(order = 2)
    public void method1() throws Exception {
        Pro = new Properties();
        FileInputStream fls = new FileInputStream("src\\test\\resources\\global.properties");
        Pro.load(fls);
        driver = BaseClass.getDriver();
        five = new WebDriverWait(driver, 5);
        ten = new WebDriverWait(driver, 10);
        fifteen = new WebDriverWait(driver, 15);
        twenty = new WebDriverWait(driver, 20);
        twentyfive = new WebDriverWait(driver, 25);
        thirty = new WebDriverWait(driver, 30);
        thirtyfive = new WebDriverWait(driver, 35);
        fourty = new WebDriverWait(driver, 40);
        fourtyfive = new WebDriverWait(driver, 45);
        fifty = new WebDriverWait(driver, 50);
        fiftyfive = new WebDriverWait(driver, 55);
        sixty = new WebDriverWait(driver, 60);
        sixtyfive = new WebDriverWait(driver, 65);
        seventy = new WebDriverWait(driver, 70);
        seventyfive = new WebDriverWait(driver, 75);
        eighty = new WebDriverWait(driver, 80);
        eightyfive = new WebDriverWait(driver, 85);
        ninety = new WebDriverWait(driver, 90);
        ninetyfive = new WebDriverWait(driver, 95);
        onehundred = new WebDriverWait(driver, 100);
        twohundred = new WebDriverWait(driver, 200);

    }

    @Given("^User navigates to the login page$")
    public void user_navigates_to_the_login_page() throws Throwable {

//    	intergtation link for backoffice
//    	driver.get("http://18.202.88.7:8001/trips-ui/faces/login/tripsLogin.xhtml");

        //    	SIT link for backoffice
        driver.get("https://backoffice.mra.mw:8443/trips-ui/faces/login/tripsLogin.xhtml");
    }

    @When("^Enters the username \"([^\"]*)\" and password \"([^\"]*)\" to login$")
    public void enters_the_username_something_and_password_something_to_login(String strArg1, String strArg2) throws Throwable {
        driver.findElement(By.id("loginForm:username")).sendKeys(strArg1);
        driver.findElement(By.id("loginForm:password")).sendKeys(strArg2);
        driver.findElement(By.xpath("//*[@id=\"loginForm:j_idt19\"]/span")).click();
    }

    @Then("^User should be logged in$")
    public void user_should_be_logged_in() throws Throwable {
        String URL = driver.getCurrentUrl();

//    	Assert.assertEquals(URL, "http://18.202.88.7:8001/trips-ui/faces/login/Welcome.xhtml" );
        Assert.assertEquals(URL, "https://backoffice.mra.mw:8443/trips-ui/faces/login/Welcome.xhtml");
    }

    @Then("^User logs out successfully$")
    public void user_logs_out_successfully() throws Throwable {
        driver.findElement(By.id("Logout")).click();
    }

    //---------------------------------------------------------------------Verify the Process of Assign Audit Case-----------------------------------------------------------------------------------------------//
    @Given("^Open CRM URL Module as \"([^\"]*)\"$")
    public void open_crm_url_module_as_something(String strArg1) throws Throwable {
        driver.get("https://" + strArg1 + ":Passw0rd@trips-crm.mra.mw:5555/TripsWorkflow/main.aspx");
    }

    @And("^Close Popup Window$")
    public void close_Popup_Window() throws Throwable {

        WebDriverWait CloseWindow = new WebDriverWait(driver, 60);
        WebElement specificframe = CloseWindow.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame__ID"))));
        driver.switchTo().frame(specificframe);

        CloseWindow.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }

    @And("^Click on Case management dropdown$")
    public void click_on_case_management_dropdown() throws Throwable {
        switch_to_frame0();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Active Cases in Progress Overview')]"))).isDisplayed();
        switchToDefault();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"TabCS\"]/a/span")).click();

    }

    @And("^click on Queues$")
    public void click_on_revenue_collection_application() throws Throwable {
        Thread.sleep(3000);
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Queues']"))).click();

    }

    @And("^select queues im a member of$")
    public void select_queues_im_a_member_of() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement queueSelector = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmQueueSelector")));
        queueSelector.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Queues I'm a member of')]")).click();


    }


    @Then("^switch to frame0$")
    public void switch_to_frame0() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @Then("^switch to frame1$")
    public void switch_to_frame1() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @And("^enters Audit reference number in search results$")
    public void enters_exemption_reference_number_in_search_results() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria")));

        search.clear();
        Thread.sleep(2000);

          //search.sendKeys("*AV/000003419/2021");
        search.sendKeys("*"+sharedatastep.AUD_CRMARN);
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
    }

    @And("^picks the audit case$")
    public void picks_the_audit_case() throws Throwable {
        Thread.sleep(4000);
        WebElement pickCheckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));

        Actions actions = new Actions(driver);
        actions.click(pickCheckBox).perform();

        driver.switchTo().defaultContent();
    }
    @And("^pick the case$")
    public void pick_the_case() throws Throwable {
        WebElement pickButton = sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Pick ']")));
        Actions actions = new Actions(driver);
        actions.doubleClick(pickButton).perform();
    }

    @And("^click assign button$")
    public void click_assign_button() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 80);
        WebElement assignDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moreCommands")));
        assignDropdown.click();

        WebElement assignButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("queueitem|NoRelationship|HomePageGrid|tbg.Mscrm.HomepageGrid.queueitem.Assign")));
        assignButton.click();
    }
    @And("^click pick button$")
    public void click_pick_button() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement assignDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moreCommands")));
        assignDropdown.click();

        WebElement pickButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("queueitem|NoRelationship|HomePageGrid|tbg.queueitem.HomepageGrid.Pick")));
        pickButton.click();
    }

    @And("^click pick button dropdown$")
    public void click_pick_button_dropdown() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement assignDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moreCommands")));
        assignDropdown.click();

        WebElement pickButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("queueitem|NoRelationship|HomePageGrid|tbg.queueitem.HomepageGrid.Pick")));
        pickButton.click();
    }

    @Then("^Click on reference number$")
    public void click_on_reference_number() {
        WebElement elementLocator = driver.findElement(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr/td[1]"));

        Actions actions = new Actions(driver);
        actions.doubleClick(elementLocator).perform();

        driver.switchTo().defaultContent();
    }

    @Then("^create Create Audit Plan page is displayed$")
    public void create_create_audit_plan_page_is_displayed() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 100);
//        WebElement createAuditPlan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+strArg1+"']")));

        WebElement createAuditPlan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbg_auditapplication|NoRelationship|Form|tbg.tbg_auditapplication.CreateAuditPlan.Button\"]/span/a/span")));
        Assert.assertTrue(createAuditPlan.isDisplayed());
    }



    @Then("^Assign pop up is displayed$")
    public void assign_pop_up_is_displayed() throws Throwable {

        WebElement assignPopup = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("InlineDialog")));
        Assert.assertTrue(assignPopup.isDisplayed());

        driver.switchTo().frame("InlineDialog_Iframe");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        WebElement popupHeader = fifty.until(ExpectedConditions.visibilityOfElementLocated(By.id("assignheader_id")));
        String popupHeaderText = popupHeader.getText();
        Assert.assertEquals("Assign to Team or User", popupHeaderText);

    }

    @And("^search team to assign$")
    public void search_team_to_assign() throws Throwable {
        WebElement searchUserTeam = driver.findElement(By.xpath("//*[@id=\"systemuserview_id\"]/div[1]"));
        searchUserTeam.click();

        Thread.sleep(1000);
        WebElement searchIcon = driver.findElement(By.id("systemuserview_id_lookupSearch"));
        searchIcon.click();

    }

    @And("^selects the team \"([^\"]*)\"$")
    public void assigns_to_team_something(String strArg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement loadMore = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Look Up More Records']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loadMore);
        Thread.sleep(500);
        loadMore.click();

        driver.switchTo().defaultContent();
        Thread.sleep(500);
        driver.switchTo().frame("InlineDialog1_Iframe");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement lookforDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selObjects")));
        lookforDropdown.click();
        Thread.sleep(3000);

        WebElement team = driver.findElement(By.xpath("//*[text()='Team']"));
        team.click();


        String teamName = "BAL - " + strArg1;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ;
        WebElement teamCheckbox = driver.findElement(By.xpath("//a[contains(@title,'" + teamName + "')]"));
        Thread.sleep(2000);
        teamCheckbox.click();

        WebElement addButton = driver.findElement(By.xpath("//*[text()='Add']"));
        addButton.click();
    }

    @And("^assigns to the team or user$")
    public void assigns_to_the_team_or_user() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("//*[text()='Assign']"));
        addButton.click();
    }

    @And("^auditor selects team queue$")
    public void auditor_selects_team_queue() throws Throwable {
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        WebElement queueDropdown = driver.findElement(By.xpath("//*[@id=\"crmQueueSelector\"]"));
        queueDropdown.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ;
        WebElement team = driver.findElement(By.xpath("//option[contains(@title,'BAL - Auditor Queue')]"));
        team.click();
    }

//    @Then("^create \"([^\"]*)\" is displayed$")
//    public void create_something_is_displayed(String strArg1) throws Throwable {
//        driver.switchTo().defaultContent();
//        WebDriverWait wait = new WebDriverWait(driver, 100);
//        //*[@id="tbg_auditapplication|NoRelationship|Form|tbg.tbg_auditapplication.CreatePreliminaryAuditFindings.Button"]/span/a/span
//
//        WebElement createAuditPlan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbg_auditapplication|NoRelationship|Form|tbg.tbg_auditapplication.CreatePreliminaryAuditFindings.Button")));
//
////        WebElement createAuditPlan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+strArg1+"']")));
//
//
//
//        Assert.assertTrue(createAuditPlan.isDisplayed());
//    }


    @When("^clicks create audit plan$")
    public void clicks_create_audit_plan() throws Throwable {
        WebElement createAuditPlan = seventy.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Create Audit Plan ']")));
        createAuditPlan.click();

    }

    @When("^clicks create preliminary audit$")
    public void clicks_create_preliminary_audit() throws Throwable {
        Thread.sleep(500);
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement createAuditPlan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbg_auditapplication|NoRelationship|Form|tbg.tbg_auditapplication.CreatePreliminaryAuditFindings.Button\"]/span")));
        createAuditPlan.click();

    }
    @When("^clicks Create Final Audit Report$")
    public void clicks_create_final_audit_report() throws Throwable {
        Thread.sleep(500);
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement createAuditPlan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbg_auditapplication|NoRelationship|Form|tbg.tbg_auditapplication.CreateFinalAuditReport.Button\"]/span/a/span")));
        createAuditPlan.click();
    }



    @And("^verifies \"([^\"]*)\" entry fields are displayed$")
    public void verifies_something_entry_fields_are_displayed(String strArg1) throws Throwable {

        WebElement loadFrame = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_AuditApplicationAngular")));
        driver.switchTo().frame(loadFrame);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement createAuditPlan = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + strArg1 + "']")));
        Assert.assertTrue(createAuditPlan.isDisplayed());

    }

    @When("^selects FINAL AUDIT FINDINGS$")
    public void selects_final_audit_findings() throws Throwable {
        WebElement auditFinding= driver.findElement(By.xpath("//*[@id=\"finalAuditReport\"]/div[5]/div/app-audit-findings/div/div[2]/div/p-table/div/div[1]/table/tbody/tr"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", auditFinding);
        Thread.sleep(500);
        auditFinding.click();
    }

    @When("^selects ASSESSMENT DETAILS$")
    public void selects_assessment_details() throws Throwable {
        Actions action=new Actions(driver);
        WebElement assesmentDetails= driver.findElement(By.xpath("//*[@id=\"finalAuditReport\"]/div[6]/div/div/div[2]/tb-dropdown/div/div[2]/div/p-dropdown/div/label"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", assesmentDetails);
        Thread.sleep(500);
        assesmentDetails.click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement taxtypeSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finalAuditReport\"]/div[6]/div/div/div[2]/tb-dropdown/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]/span")));
        taxtypeSelect.click();
    }

    @And("^clicks update final audit findings button$")
    public void clicks_update_final_audit_findings_button() throws Throwable {
        WebElement submitButton = driver.findElement(By.xpath("//*[text()=' Update ']"));
        submitButton.click();
    }

    @And("^clicks add assesment details button$")
    public void clicks_add_assesment_details_button() throws Throwable {

        WebElement submitButton = driver.findElement(By.xpath("//*[text()=' Add ']"));
        submitButton.click();
    }

    @And("^clicks update assesment details button$")
    public void clicks_update_assesment_details_button() throws Throwable {
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"finalAuditReport\"]/div[6]/div/div/div[3]/button[2]"));
        submitButton.click();
    }

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String stringType(String cell) {
        return cell;
    }

    @When("^enters audit case plan details$")
    public void enters_audit_case_plan_details(DataTable auditTable) throws Throwable {
        Actions builder = new Actions(driver);
        //Initialize data table
        List<List<String>> data = auditTable.asLists();

        WebElement auditorsInput = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-audit-case-plan/div/form/div[1]/app-audit-plan-particulars/div/form/div[2]/div[2]/tb-input-text-area/div/div[2]/div/textarea"));
        auditorsInput.sendKeys(data.get(0).get(1));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement estStartDate = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-audit-case-plan/div/form/div[1]/app-audit-plan-particulars/div/form/div[2]/div[3]/tb-date-picker[1]/div/div[2]/div/p-calendar/span/input"));
        estStartDate.sendKeys(data.get(1).get(1));
        estStartDate.sendKeys(Keys.TAB);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement estEndDate = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-audit-case-plan/div/form/div[1]/app-audit-plan-particulars/div/form/div[2]/div[3]/tb-date-picker[2]/div/div[2]/div/p-calendar/span/input"));
        estEndDate.sendKeys(data.get(2).get(1));
        builder.click();

        WebElement cashOfficer = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-audit-case-plan/div/form/div[1]/app-audit-plan-particulars/div/form/div[2]/div[3]/tb-input-text[1]/div/div[2]/div/input"));
        cashOfficer.sendKeys(data.get(3).get(1));


        WebElement teamLeader = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-audit-case-plan/div/form/div[1]/app-audit-plan-particulars/div/form/div[2]/div[3]/tb-input-text[2]/div/div[2]/div/input"));
        teamLeader.sendKeys(data.get(4).get(1));

        WebElement objectives = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-audit-case-plan/div/form/div[2]/div/div/div[1]/tb-input-text-area/div/div[2]/div/textarea"));
        objectives.sendKeys(data.get(5).get(1));


        WebElement backgroundInfo = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-audit-case-plan/div/form/div[3]/div/div/div[1]/tb-input-text-area/div/div[2]/div/textarea"));
        backgroundInfo.sendKeys(data.get(6).get(1));


        WebElement trendAnalysis = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-audit-case-plan/div/form/div[4]/div/div[1]/tb-input-text-area/div/div[2]/div/textarea"));
        trendAnalysis.sendKeys(data.get(7).get(1));


        WebElement complianceHistory = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-audit-case-plan/div/form/div[5]/div/div[1]/tb-input-text-area/div/div[2]/div/textarea"));
        complianceHistory.sendKeys(data.get(8).get(1));


        WebElement testDocuments = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-audit-case-plan/div/form/div[6]/div/div[1]/tb-input-text-area/div/div[2]/div/textarea"));
        testDocuments.sendKeys(data.get(9).get(1));
    }

    @When("^enters PRELIMINARY AUDIT FINDING details$")
    public void enters_preliminary_audit_finding_details(DataTable auditTable) throws Throwable {
        Actions builder = new Actions(driver);
        //Initialize data table
        List<List<String>> data = auditTable.asLists();

        WebElement addressPostalInput = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-pre-audit-finding/div/div/form/div[2]/div/app-pre-audit-finding-particulars/div/form/div[2]/div[1]/tb-input-text-area[1]/div/div[2]/div/textarea"));
        addressPostalInput.sendKeys(data.get(0).get(1));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement addressVisitedInput = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-pre-audit-finding/div/div/form/div[2]/div/app-pre-audit-finding-particulars/div/form/div[2]/div[1]/tb-input-text-area[2]/div/div[2]/div/textarea"));
        addressVisitedInput.sendKeys(data.get(1).get(1));


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement datesVisitedINput = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-pre-audit-finding/div/div/form/div[2]/div/app-pre-audit-finding-particulars/div/form/div[2]/div[1]/tb-input-text-area[3]/div/div[2]/div/textarea"));
        datesVisitedINput.sendKeys(data.get(2).get(1));

        WebElement numberVisitsInput = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-pre-audit-finding/div/div/form/div[2]/div/app-pre-audit-finding-particulars/div/form/div[2]/div[1]/tb-png-input-number/div/div[2]/div/span/input"));
        numberVisitsInput.sendKeys(data.get(3).get(1));


        WebElement contactPersonInput = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-pre-audit-finding/div/div/form/div[2]/div/app-pre-audit-finding-particulars/div/form/div[2]/div[2]/tb-input-text/div/div[2]/div/input"));
        contactPersonInput.sendKeys(data.get(4).get(1));

        WebElement subjectInput = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-pre-audit-finding/div/div/form/div[3]/div/div/tb-input-text-area/div/div[2]/div/textarea"));
        subjectInput.sendKeys(data.get(5).get(1));


        WebElement backgroundInfo = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-pre-audit-finding/div/div/form/div[4]/div/div/tb-input-text-area/div/div[2]/div/textarea"));
        backgroundInfo.sendKeys(data.get(6).get(1));


        WebElement conslusionInput = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-pre-audit-finding/div/div/form/div[8]/div/div/tb-input-text-area/div/div[2]/div/textarea"));
        conslusionInput.sendKeys(data.get(7).get(1));

    }

    @When("^enters FINAL AUDIT REPORT details$")
    public void enters_final_audit_report_details(DataTable auditTable) throws Throwable {
        Actions builder = new Actions(driver);
        //Initialize data table
        List<List<String>> data = auditTable.asLists();

        WebElement addressPostalInput = driver.findElement(By.xpath("//*[@id=\"finalAuditReport\"]/div[2]/app-pre-audit-finding-particulars/div/form/div[2]/div[1]/tb-input-text-area[1]/div/div[2]/div/textarea"));
        addressPostalInput.sendKeys(data.get(0).get(1));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement addressVisitedInput = driver.findElement(By.xpath("//*[@id=\"finalAuditReport\"]/div[2]/app-pre-audit-finding-particulars/div/form/div[2]/div[1]/tb-input-text-area[2]/div/div[2]/div/textarea"));
        addressVisitedInput.sendKeys(data.get(1).get(1));


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement datesVisitedINput = driver.findElement(By.xpath("//*[@id=\"finalAuditReport\"]/div[2]/app-pre-audit-finding-particulars/div/form/div[2]/div[1]/tb-input-text-area[3]/div/div[2]/div/textarea"));
        datesVisitedINput.sendKeys(data.get(2).get(1));

        WebElement numberVisitsInput = driver.findElement(By.xpath("//*[@id=\"finalAuditReport\"]/div[2]/app-pre-audit-finding-particulars/div/form/div[2]/div[1]/tb-png-input-number/div/div[2]/div/span/input"));
        numberVisitsInput.sendKeys(data.get(3).get(1));


        WebElement contactPersonInput = driver.findElement(By.xpath("//*[@id=\"finalAuditReport\"]/div[2]/app-pre-audit-finding-particulars/div/form/div[2]/div[2]/tb-input-text/div/div[2]/div/input"));
        contactPersonInput.sendKeys(data.get(4).get(1));

        WebElement subjectInput = driver.findElement(By.xpath("//*[@id=\"finalAuditReport\"]/div[3]/div/div[1]/tb-input-text-area/div/div[2]/div/textarea"));
        subjectInput.sendKeys(data.get(5).get(1));


        WebElement backgroundInfo = driver.findElement(By.xpath("//*[@id=\"finalAuditReport\"]/div[4]/div/div[1]/tb-input-text-area/div/div[2]/div/textarea"));
        backgroundInfo.sendKeys(data.get(6).get(1));


        WebElement conslusionInput = driver.findElement(By.xpath("//*[@id=\"finalAuditReport\"]/div[10]/div/div[1]/tb-input-text-area/div/div[2]/div/textarea"));
        conslusionInput.sendKeys(data.get(7).get(1));

    }

    @When("^enters updated FINAL AUDIT REPORT details(.+) and (.+)$")
    public void enters_updated_final_audit_report_details_and(String updatedinfo, String particulars) throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement updateInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-audit-finding/div/form/div[1]/div/div[3]/p-editor/div/div[2]/div[1]")));
        updateInfo.sendKeys(updatedinfo);


        WebElement updateParticulars = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-audit-finding/div/form/div[1]/div/div[4]/tb-input-text/div/div[2]/div/input")));
        updateParticulars.sendKeys(particulars);

    }

    @When("^enters OFFICERS ASSESMENT details(.+) and (.+)$")
    public void enters_officers_assesment_details_and(String addressee, String address) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement addresseeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-officer-assessment/div/form/div[2]/div[3]/div[1]/tb-input-text-area/div/div[2]/div/textarea")));
        addresseeInput.sendKeys(addressee);


        WebElement addressInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-officer-assessment/div/form/div[2]/div[3]/div[2]/tb-input-text-area/div/div[2]/div/textarea")));
        addressInput.sendKeys(address);
    }

    @And("^clicks ok on update Info$")
    public void clicks_ok_on_update_info() throws Throwable {
            WebElement okButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-audit-finding/div/form/div[2]/div/div/button[1]"));
        okButton.click();
    }

    @And("^clicks officers assesment submit$")
    public void clicks_officers_assesment_submit() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-officer-assessment/div/form/div[3]/div/div/button[2]")));
        submitButton.click();
    }

    @And("^enters AUDIT SCOPE METHODOLOGY$")
    public void enters_audit_scope_methodology(DataTable auditScopeTable ) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 60);

        List<List<String>> data = auditScopeTable.asLists();

        WebElement okButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-audit-case-plan/div/form/div[8]/app-audit-scope/div/div[3]/div/button[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", okButton);
        Thread.sleep(500);
        okButton.click();

        WebElement taxType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-dropdown[1]/div/div[2]/div/p-dropdown/div/label")));
        Assert.assertTrue(taxType.isDisplayed());


        WebElement taxTypeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-dropdown[1]/div/div[2]/div/p-dropdown/div/label")));
        taxTypeDropdown.click();
        Thread.sleep(4000);

//    Confirm if class names are still as is
//        driver.findElement(By.xpath("//li[@class='ng-tns-c6-5 ui-dropdown-item ui-corner-all ui-state-highlight ng-star-inserted' and contains(., '" + data.get(0).get(1) +"')]")).click();
        //driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-dropdown[1]/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[4]/span")).click();
        driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-dropdown[1]/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[6]/span")).click();

        Thread.sleep(3000);
        WebElement periodDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-dropdown[2]/div/div[2]/div/p-dropdown/div")));
        periodDropdown.click();
        Thread.sleep(10000);

//        driver.findElement(By.xpath("//span[@class='ng-tns-c6-8 ng-star-inserted' and contains('" + data.get(1).get(1) +"')]")).click();
        driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-dropdown[2]/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]")).click();

        WebElement riskAreaDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-dropdown[3]/div/div[2]/div/p-dropdown/div/label")));
        riskAreaDropdown.click();
        Thread.sleep(4000);

//        driver.findElement(By.xpath("//li[@class='ng-tns-c7-7 ui-dropdown-item ui-corner-all ng-star-inserted' and contains(., '" + data.get(2).get(1) +"')]")).click();
        driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-dropdown[3]/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]")).click();

        WebElement percievedriskDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-dropdown[4]/div/div[2]/div/p-dropdown/div/label")));
        percievedriskDropdown.click();
        Thread.sleep(4000);
//        driver.findElement(By.xpath("//li[@class='ng-tns-c7-8 ui-dropdown-item ui-corner-all ng-star-inserted' and contains(., '" + data.get(2).get(1) +"')]")).click();
        driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-dropdown[4]/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]")).click();

        WebElement materiality = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-input-text[1]/div/div[2]/div/input")));
        materiality.sendKeys(data.get(3).get(1));

        WebElement methodology = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-input-text-area/div/div[2]/div/textarea")));
        methodology.sendKeys(data.get(4).get(1));

        WebElement responsibleAuditors = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-input-text[2]/div/div[2]/div/input")));
        responsibleAuditors.sendKeys(data.get(5).get(1));

        WebElement timeDays = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-png-input-number/div/div[2]/div/span/input")));
        timeDays.sendKeys(data.get(6).get(1));

        WebElement addButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[2]/div/div/button[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addButton);
        Thread.sleep(500);
        addButton.click();

    }

    @And("^Clicks submit audit plan button$")
    public void clicks_submit_audit_plan_button() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 60);

        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-audit-case-plan/div/form/div[9]/div/div/button")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @And("^Clicks submit Preliminary Audit Finding button$")
    public void clicks_submit_preliminary_audit_finding_button() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-pre-audit-finding/div/div/form/div[9]/div/div/button")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @And("^Clicks submit Submit Final Audit Report button$")
    public void clicks_submit_submit_final_audit_report_button() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-final-audit-report/div/form/div[2]/div/div/button[2]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @Then("^Audit status should be \"([^\"]*)\"$")
    public void application_account_adjustment_status_should_be_something(String Status) throws Throwable {
        driver.switchTo().frame("contentIFrame1");

        String text = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+Status+"']"))).getText();
        Assert.assertEquals(Status,text);
        Thread.sleep(2000);
    }

    @And("^clicks Approve from the dropdown$")
    public void clicks_Approve_from_the_dropdown() throws Throwable {

        Actions action=new Actions(driver);
        WebElement Outcome=driver.findElement(By.id(Pro.getProperty("Taxpayer_Accounting_Approval_Outcome_ID")));
        WebElement hasLoaded= driver.findElement(By.id("header_process_tbg_approvaloutcome_lock"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(7000);
        if(hasLoaded.isDisplayed()) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(5000);
        }else {
            action.doubleClick(Outcome).build().perform();
            Outcome.click();
            action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        }

    }

    @And("^clicks reject from the dropdown$")
    public void clicks_discontinue_from_the_dropdown() throws Throwable {

        Actions action=new Actions(driver);
        WebElement Outcome=driver.findElement(By.id(Pro.getProperty("Taxpayer_Accounting_Approval_Outcome_ID")));
        WebElement hasLoaded= driver.findElement(By.id("header_process_tbg_approvaloutcome_lock"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(7000);
        if(hasLoaded.isDisplayed()) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(5000);
        }else {
            action.doubleClick(Outcome).build().perform();
            Outcome.click();
            action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        }

    }



    @Then("^Click on Save button$")
    public void click_on_Save_button() throws Throwable {
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tbg_auditapplication|NoRelationship|Form|Mscrm.Form.tbg_auditapplication.Save")).click();


    }

    @And("^enters manager comments \"([^\"]*)\"$")
    public void enters_manager_comments_something(String strArg1) throws Throwable {
        WebElement managerCommentsInput = driver.findElement(By.id("Manager Comments_label"));
        managerCommentsInput.click();
        Thread.sleep(2000);

        WebElement managerCommentsInputBox = driver.findElement(By.id("tbg_managercomments_i"));
        managerCommentsInputBox.sendKeys(strArg1);

    }

    @Then("^Enter Outcome Notes (.+)$")
    public void enter_outcome_notes(String Notes) throws Throwable {
        Thread.sleep(3000);
        Actions action1 = new Actions(driver);
        WebElement element1 = driver.findElement(By.id(("Notes_label")));
        element1.click();
        Thread.sleep(1000);
        driver.findElement(By.id("tbg_outcomenotes_i")).sendKeys(Notes);
        Thread.sleep(5000);
    }

    @Then("^Enter Outcome Reason$")
    public void enter_Outcome_Reason() throws Throwable {
        Thread.sleep(2000);
        WebElement specificframe = (driver.findElement(By.id(Pro.getProperty("OutComeReason_Frame_ID"))));
        driver.switchTo().frame(specificframe);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("viewoptionReject")).click();
        WebDriverWait ReasonValue = new WebDriverWait(driver, 60);
        ReasonValue.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"statuscode_i_reject\"]/option[2]"))).click();
        Thread.sleep(8000);
    }

    @Then("^validation error displayed \"([^\"]*)\"$")
    public void validation_error_displayed_something(String strArg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement loadFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_AuditApplicationAngular")));
        driver.switchTo().frame(loadFrame);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement estStartDate = driver.findElement(By.xpath("/html/body/trips-app/div/app-audit/app-audit-case-plan/div/form/div[1]/app-audit-plan-particulars/div/form/div[2]/div[3]/tb-date-picker[1]/div/div[2]/div/p-calendar/span/input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", estStartDate);
        Thread.sleep(2000);
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + strArg1 +"']"))).getText();
        if(text.contains(strArg1))
        {
            System.out.println("Text Verified and"+strArg1);
        }
        else
        {
            System.out.println("Text Not Verfied and failed");
        }
        Thread.sleep(2000);
    }

    @Then("^validation error is displayed \"([^\"]*)\"$")
    public void validation_error_is_displayed_something(String strArg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement loadFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_AuditApplicationAngular")));
        driver.switchTo().frame(loadFrame);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-pre-audit-finding/div/div/form/div[8]/div/div/tb-input-text-area/div/div[2]/control-messages/div/div"))).getText();
        if(text.contains(strArg1))
        {
            System.out.println("Text Verified and"+strArg1);
        }
        else
        {
            System.out.println("Text Not Verfied and failed");
        }
        Thread.sleep(2000);
    }
    @Then("^final audit validation error is displayed \"([^\"]*)\"$")
    public void final_audit_validation_error_is_displayed_something(String strArg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement loadFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_AuditApplicationAngular")));
        driver.switchTo().frame(loadFrame);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finalAuditReport\"]/div[10]/div/div[1]/tb-input-text-area/div/div[2]/control-messages/div/div"))).getText();
        if(text.contains(strArg1))
        {
            System.out.println("Text Verified and"+strArg1);
        }
        else
        {
            System.out.println("Text Not Verfied and failed");
        }
        Thread.sleep(2000);
    }

    @Then("^final officers assesment validation error is displayed \"([^\"]*)\"$")
    public void final_officers_assesment_validation_error_is_displayed_something(String strArg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement loadFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_AuditApplicationAngular")));
        driver.switchTo().frame(loadFrame);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-officer-assessment/div/form/div[2]/div[3]/div[2]/tb-input-text-area/div/div[2]/control-messages/div/div"))).getText();
        if(text.contains(strArg1))
        {
            System.out.println("Text Verified and"+strArg1);
        }
        else
        {
            System.out.println("Text Not Verfied and failed");
        }
        Thread.sleep(2000);
    }


    @Then("^validation audit error displayed \"([^\"]*)\"$")
    public void validation_audit_error_displayed(String strArg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement image = driver.findElement(By.id("tbg_outcomenotes_warn"));
        if(image.isDisplayed())
        {
            System.out.println("Text Verified and"+strArg1);
        }
        else
        {
            System.out.println("Text Not Verfied and failed");
        }
        Thread.sleep(2000);
    }


    @Given("^User navigates to Audit>>Create case manually$")
    public void user_navigates_to_auditcreate_case_manually() throws Throwable {
        driver.findElement(By.xpath(Pro.getProperty("Audit_Button"))).click();
        driver.findElement(By.xpath(Pro.getProperty("Create_Case_Manually"))).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @And("^enters taxpayer details \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enters_taxpayer_details_something_and_something(String strArg1, String strArg2) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement tinButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit' and span='Find']")));
        tinButton.click();

        WebElement frame = driver.findElement(By.tagName("iframe"));
        //Switch to iframe to allow interaction with modal
        driver.switchTo().frame(frame);

        WebElement enterTin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:accountNumber")));
        enterTin.sendKeys(strArg1);

        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit' and span='Search']")));
        searchButton.click();

        switchToDefault();
        boolean TIN= wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("AuditAndVisitCaseForm:TIN"), strArg1));
        Assert.assertTrue(TIN);



        WebElement notesInput = driver.findElement(By.id("AuditAndVisitCaseForm:CaseNotes"));
        notesInput.sendKeys(strArg2);

    }

    @And("^clicks on the create audit case button$")
    public void clicks_on_the_create_audit_case_button() throws Throwable {
        WebElement createButton = driver.findElement(By.xpath("//button[@type='submit' and span='Create']"));
        createButton.click();
    }

    @Then("^Verify the ARN number \"([^\"]*)\"$")
    public void verify_the_ARN_number_ARN(String ARN) throws Throwable {

        WebDriverWait RefNumber = new WebDriverWait(driver, 150);
        RefNumber.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("Precessing_Completed_RefferenceNumber_ID")))).click();
        // Capture ARN Number
        String text = driver.findElement(By.id(Pro.getProperty("Precessing_Completed_RefferenceNumber_ID"))).getText();

        System.out.println(text);
        System.out.println("substring is " + text.substring(42));
        sharedatastep.AUD_CRMARN = text.substring(42);



        System.out.println(sharedatastep.AUD_CRMARN);
        System.out.println("Actual ARN to be used in CRM is " + sharedatastep.AUD_CRMARN);

        if (text.contains(ARN)) {
            //  System.out.println(text);
            System.out.println("Text Verified and passed");
        } else {
            System.out.println("Text Not Verified and failed");
        }

        Thread.sleep(5000);
    }


    @And("^wait for plan to load \"([^\"]*)\"$")
    public void wait_for_duplicate_check(String strArg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_AuditApplicationAngular")));
        driver.switchTo().frame(frame);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='"+strArg1+"']")));
    }

//-----------------------------------------------------Print Audit Processing Reports--------------------------------------------------------------------------------///
    @Then("^Goto reporting link$")
    public void goto_reporting_link() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement reporting = driver.findElement(By.xpath(Pro.getProperty("Reporting_Link_Xapth")));
        reporting.click();


    }

    @Then("^click on  Reports link$")
    public void click_on_Reports_link() throws Throwable {
        WebElement Reports = driver.findElement(By.xpath(Pro.getProperty("Reporting_Reports_Link_Xapth")));
        Reports.click();


        //ReportTree:t1:3:j_idt42
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)", "");


    }

    @Then("^Click on Refund Claims Paid Report$")
    public void click_on_Refund_Claims_Paid_Report() throws Throwable {
        driver.findElement(By.xpath("//a[contains(text(),''")).click();
        //span[contains(text(),'Processing Completed')]

    }

    @And("^Clicks on Audit Report \"([^\"]*)\"$")
    public void clicks_on_audit_report_something(String strArg1) throws Throwable {
        driver.findElement(By.xpath("//*[text()='"+strArg1 +"']")).click();
//        driver.findElement(By.xpath("//*[text()='"+TaxType+"']"));
    }

    @And("^Enter Report Paramenters (.+) , (.+) and (.+)$")
    public void enter_report_paramenters_and(String startdate, String enddate, String taxoffice) throws Throwable {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //StartDate
        WebElement startDateInput = driver.findElement(By.id("frmReportDetails:StartDate_input"));
        startDateInput.sendKeys(startdate);
//        date.sendKeys(Keys.ESCAPE);


        //enddate
        Thread.sleep(4000);
        WebElement endDateInput = driver.findElement(By.id("frmReportDetails:EndDate_input"));
        endDateInput.sendKeys(enddate);
        endDateInput.sendKeys(Keys.ESCAPE);
        Thread.sleep(4000);


        //////TaxOffice
        WebElement TaxOfficelist = driver.findElement(By.id("frmReportDetails:TAX_OFFICE_label"));
        TaxOfficelist.click();
        Thread.sleep(4000);

//        WebElement TaxOffice=driver.findElement(By.xpath("//li[contains(text(),'"+taxoffice+"')]"));
        WebElement TaxOffice = driver.findElement(By.id("frmReportDetails:TAX_OFFICE_2"));
        Thread.sleep(4000);
        TaxOffice.click();

    }

    @Then("^Click on Run Report button$")
    public void click_on_Run_Report_button() throws Throwable {

        driver.findElement(By.id(Pro.getProperty("Reporting_Reports_RefundClaimsPaidReport_RunReport_button_ID"))).click();

        Thread.sleep(5000);


    }

    @Then("^Click on Cancel Report button$")
    public void click_on_Cancel_Report_button() throws Throwable {

        driver.findElement(By.id(Pro.getProperty("Reporting_Reports_RefundClaimsPaidReport_CancelReport_button_ID"))).click();

        Thread.sleep(5000);


    }

    @Then("^verify file downloaded \"([^\"]*)\"$")
    public void verify_file_downloaded_and(String fileName) throws Throwable {
        boolean isPresent = false;
        File dir = new File("C:\\Users\\maxma\\Downloads");
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName)) {
                isPresent = true;
            }
            Thread.sleep(3000);
        }


        org.junit.Assert.assertTrue(isPresent);

    }

    @Then("^message is displayed \"([^\"]*)\"$")
    public void message_is_displayed_something(String strArg1) throws Throwable {
//    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement Message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + strArg1 + "')]")));
        if (Message.isDisplayed()) {
            Assert.assertTrue("Error message displayed", true);
        } else {
            Assert.fail("No Error message displayed");
        }
    }

    @Then("^should return to reports page$")
    public void should_return_to_reports_page() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement reportsPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReportTree:ReportReprintLabel")));
        Assert.assertTrue(reportsPage.isDisplayed());
    }


    @Then("Navigate to audit > Mantain risk bands")
    public void navigateToAuditMantainRiskBands() {
       thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Audit']"))).click();
       thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Maintain Risk Bands']"))).click();
    }

    @Then("Verify fields in Mantain risk bands screen")
    public void verifyFieldsInMantainRiskBandsScreen() {

        //buttons
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainAuditRiskBands:RiskBandTable:btnAddRiskBand"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainAuditRiskBands:RiskBandTable:btnUpdateRiskBand"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainAuditRiskBands:RiskBandTable:btnViewRiskBand"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainAuditRiskBands:SaveRiskBand"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainAuditRiskBands:Cancel"))).isDisplayed();
        //table columns
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[span='Risk Band Code']"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[span='Description']"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[span='From']"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[span='To']"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[span='No. of Days']"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[span='No. of Officers']"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[span='Officer Grade']"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[span='No. of Audits Performed']"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[span='Audit Frequency']"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[span='Status']"))).isDisplayed();

    }

    @Then("Click add to open add risk bands frame")
    public void clickAddToOpenAddRiskBandsFrame() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainAuditRiskBands:RiskBandTable:btnAddRiskBand"))).click();
    }

    @Then("Verify fields in add risk band frame")
    public void verifyFieldsInAddRiskBandFrame() {
        fifteen.until(ExpectedConditions.visibilityOfElementLocated(By.id("RiskBandDetails:RiskBand_input"))).isDisplayed();
        driver.findElement(By.id("RiskBandDetails:RiskBandDescription")).isDisplayed();
        driver.findElement(By.id("RiskBandDetails:RiskRatingFrom_input")).isDisplayed();
        driver.findElement(By.id("RiskBandDetails:RiskRatingTo_input")).isDisplayed();
        driver.findElement(By.id("RiskBandDetails:NumOfDaysForTheAudit_input")).isDisplayed();
        driver.findElement(By.id("RiskBandDetails:NumOfOfficersRequired_input")).isDisplayed();
        driver.findElement(By.id("RiskBandDetails:OfficerGrade_label")).isDisplayed();
        driver.findElement(By.id("RiskBandDetails:NumOfAuditsPerformed_input")).isDisplayed();
        driver.findElement(By.id("RiskBandDetails:AuditFrequency_input")).isDisplayed();
        driver.findElement(By.id("RiskBandDetails:Status_label")).isDisplayed();
        driver.findElement(By.id("RiskBandDetails:Ok")).isDisplayed();
        driver.findElement(By.id("RiskBandDetails:Cancel")).isDisplayed();

    }


    @Then("Select first table row in existing risk bands")
    public void clickFirstTableRowInExistingRiskBands() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MaintainAuditRiskBands:RiskBandTable_data\"]/tr[1]/td[1]"))).click();
        Thread.sleep(1000);

    }

    @Then("Click update button to update selected risk band")
    public void clickUpdateButtonToUpdateSelectedRiskBand() {
        driver.findElement(By.id("MaintainAuditRiskBands:RiskBandTable:btnUpdateRiskBand")).click();
    }

    @Then("Switch to frame")
    public void switchToFrame() {
        WebElement frame = fifteen.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);
    }

    @Then("Switch to default")
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    @Then("Fill in number of days of the audit field")
    public void fillInNumberOfDaysOfTheAuditField() throws InterruptedException {

        WebElement auditDaysField = fifteen.until(ExpectedConditions.visibilityOfElementLocated(By.id("RiskBandDetails:NumOfDaysForTheAudit_input")));
        String current = auditDaysField.getAttribute("value");
        System.out.println("Current value is "+current);
        int newFigure = Integer.parseInt(current)+1;
        auditDaysField.clear();
        Thread.sleep(1000);
        auditDaysField.sendKeys(String.valueOf(newFigure));
        Thread.sleep(1000);
        driver.findElement(By.id("RiskBandDetails:Ok")).click();
        Thread.sleep(1000);

    }

    @Then("Verify success message {string}")
    public void verifySuccessMessage(String Message) {
        WebElement successMessage = sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + Message + "')]")));

        if (successMessage.isDisplayed()) {
            System.out.println("Success message ('" + Message + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("Verify error message {string}")
    public void verifyErrorMessage(String Message) {
        WebElement ErrorMessage = sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + Message + "')]")));

        if (ErrorMessage.isDisplayed()) {
            System.out.println("!!Error message ('" + Message + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("Click save to process risk band update")
    public void clickSaveToProcessRiskBandUpdate() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainAuditRiskBands:SaveRiskBand"))).click();
    }

    @Then("Click view button to view selected risk band")
    public void clickViewButtonToViewSelectedRiskBand() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainAuditRiskBands:RiskBandTable:btnViewRiskBand"))).click();
    }

    @Then("Verify view risk band field is readonly")
    public void verifyViewRiskBandFieldIsReadonly() {
        Assert.assertTrue("riskband field is disabled",!twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("RiskBandDetails:RiskBand_input"))).isEnabled());
    }

    @Then("Click add button to add risk band")
    public void clickAddButtonToAddRiskBand() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainAuditRiskBands:RiskBandTable:btnAddRiskBand"))).click();
    }


    @Then("Click ok to trigger validation")
    public void clickOkToTriggerValidation() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("RiskBandDetails:Ok"))).click();
    }

    @Then("Navigate to audit > Mantain risk indicators")
    public void navigateToAuditMantainRiskIndicators() throws InterruptedException {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Audit']"))).click();
        Thread.sleep(2000);
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Maintain Risk Indicators']"))).click();
    }

    @Then("Verify fields in audit risk indicator screen")
    public void verifyFieldsInAuditRiskIndicatorScreen() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainRiskIndicators:TurnoverRiskIndicatorTable:btnAddTurnover"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainRiskIndicators:TurnoverRiskIndicatorTable:btnUpdateTurnover"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainRiskIndicators:TurnoverRiskIndicatorTable:btnViewTurnover"))).isDisplayed();

    }

    @Then("Click add to open risk indicator details screen")
    public void clickAddToOpenRiskIndicatorDetailsScreen() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainRiskIndicators:TurnoverRiskIndicatorTable:btnAddTurnover"))).click();

    }

    @Then("Verify fields in risk indicator details screen")
    public void verifyFieldsInRiskIndicatorDetailsScreen() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TurnoverRiskIndicatorDetails:Name"))).isDisplayed();
        driver.findElement(By.id("TurnoverRiskIndicatorDetails:TurnoverFrom_input")).isDisplayed();
        driver.findElement(By.id("TurnoverRiskIndicatorDetails:TurnoverTo_input")).isDisplayed();
        driver.findElement(By.id("TurnoverRiskIndicatorDetails:TurnoverScore_input")).isDisplayed();
        driver.findElement(By.id("TurnoverRiskIndicatorDetails:Ok")).isDisplayed();
        driver.findElement(By.id("TurnoverRiskIndicatorDetails:Cancel")).isDisplayed();
    }

    @Then("fill in Turnover risk indicator details")
    public void fillInTurnoverRiskIndicatorDetails() throws InterruptedException {

        WebElement currentTurnOverFromField =  twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TurnoverRiskIndicatorDetails:TurnoverTo_input")));
        String currentValue = currentTurnOverFromField.getAttribute("value");
        System.out.println("Current value is "+currentValue);
        int current = Integer.parseInt(currentValue.substring(0, currentValue.length() - 3).replace(",",""));
        System.out.println("Value to update is "+current);
        currentTurnOverFromField.clear();
        Thread.sleep(1000);
        currentTurnOverFromField.sendKeys(String.valueOf(current+10));
        Thread.sleep(2000);
        driver.findElement(By.id("TurnoverRiskIndicatorDetails:Ok")).click();
    }

    @Then("Select first table row in existing risk indicators")
    public void selectFirstTableRowInExistingRiskIndicators() throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MaintainRiskIndicators:TurnoverRiskIndicatorTable_data\"]/tr/td[1]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.id("MaintainRiskIndicators:TurnoverRiskIndicatorTable:btnUpdateTurnover")).click();

    }

    @Then("Click save to process risk indicator update")
    public void clickSaveToProcessRiskIndicatorUpdate() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainRiskIndicators:SaveRiskIndicator"))).click();
    }

    @Then("Select first table row to view existing risk indicators")
    public void selectFirstTableRowToViewExistingRiskIndicators() throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MaintainRiskIndicators:TurnoverRiskIndicatorTable_data\"]/tr/td[1]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.id("MaintainRiskIndicators:TurnoverRiskIndicatorTable:btnViewTurnover")).click();
    }

    @Then("Verify fields in risk indicator details screen are read only")
    public void verifyFieldsInRiskIndicatorDetailsScreenAreReadOnly() {
        Assert.assertTrue("Turnover from field is disabled",!twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TurnoverRiskIndicatorDetails:TurnoverFrom_input"))).isEnabled());
    }

    @Then("Click ok to trigger validation check in risk band details")
    public void clickOkToTriggerValidationCheckInRiskBandDetails() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TurnoverRiskIndicatorDetails:Ok"))).click();
    }

    @Then("Navigate to audit > Create Audit Selection Profile")
    public void navigateToAuditCreateAuditSelectionProfile() {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Audit']"))).click();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Create Audit Selection Profile']"))).click();
    }

    @Then("Enter profile name")
    public void enterProfileName() {
        sharedatastep.AuditProfileName = getRandom(6);
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("AuditSelectionProfileDetails:auditProfileName"))).sendKeys(sharedatastep.AuditProfileName);
    }


    @And("Select selection profile office")
    public void selectSelectionProfileOffice() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"AuditSelectionProfileDetails:Office\"]/div[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'All')]")).click();
    }

    @And("Select Audit period start")
    public void selectAuditPeriodStart() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("AuditSelectionProfileDetails:AuditPeriodStart_input")).click();
        driver.findElement(By.id("AuditSelectionProfileDetails:AuditPeriodStart_input")).sendKeys(Keys.ENTER);
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);
    }

    @And("Select Audit period end")
    public void selectAuditPeriodEnd() throws InterruptedException {
        driver.findElement(By.id("AuditSelectionProfileDetails:AuditPeriodEnd_input")).sendKeys(BaseClass.tomorrowsDate());
        Actions actions = new Actions(driver);
//        Thread.sleep(1000);
//        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);
    }

    @And("Select Profile status")
    public void selectProfileStatus() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"AuditSelectionProfileDetails:ProfileStatus\"]/div[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'Active')]")).click();
        Thread.sleep(1000);
    }


    @And("Select all industry sectors")
    public void selectAllIndustrySectors() {
        driver.findElement(By.xpath("//button[span='Add All']")).click();
    }

    @Then("Click save to submit audit profile")
    public void clickSaveToSubmitAuditProfile() throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("AuditSelectionProfileDetails:Save"))).click();
    }

    @Then("Navigate to audit > Update Audit Selection Profile")
    public void navigateToAuditUpdateAuditSelectionProfile() {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Audit']"))).click();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Update Audit Selection Profile']"))).click();
    }

    @Then("Enter audit selection profile id as {string} and click search")
    public void enterAuditSelectionProfileIdAsAndClickSearch(String id) {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:profileiID"))).sendKeys(id);
        driver.findElement(By.id("SearchForm:j_idt42")).click();
    }

    @Then("Search for audit selection profile")
    public void searchForAuditSelectionProfile() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:profileName"))).sendKeys(sharedatastep.AuditProfileName);
        driver.findElement(By.id("SearchForm:j_idt42")).click();
    }

    @Then("Update the audit selection profile status")
    public void updateTheAuditSelectionProfileStatus() throws InterruptedException {

        String currentStatus = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("AuditSelectionProfileDetails:ProfileStatus_label"))).getText();
        String nextStatus = "";
        System.out.println("Current status is "+currentStatus);
        if(currentStatus.equals("Active")){
           nextStatus = "//li[contains(text(),'Inactive')]";
        }
        else if(currentStatus.equals("Inactive")){
           nextStatus = "//li[contains(text(),'Active')]";
        }

        driver.findElement(By.xpath("//*[@id=\"AuditSelectionProfileDetails:ProfileStatus\"]/div[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(nextStatus)).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"AuditSelectionProfileDetails:Office\"]/div[3]")).click();
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();



    }

    @Then("Verify no data found in table")
    public void verifyNoDataFoundInTable() {

        Assert.assertTrue("",twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'No record(s) found.')]"))).isDisplayed());

    }

    @Then("Navigate to audit > Run Audit Selection Profile")
    public void navigateToAuditRunAuditSelectionProfile() {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Audit']"))).click();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Run Audit Selection Profile']"))).click();
    }

    @Then("Enter results to display as {string} and click run")
    public void enterResultsToDisplayAsAndClickRun(String disp) {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("RunAuditSelectionProfile:resultsToDisplay"))).sendKeys(disp);
        driver.findElement(By.id("RunAuditSelectionProfile:Run")).click();
    }

    @Then("Click accept button")
    public void clickAcceptButton() {
        twenty.until(ExpectedConditions.elementToBeClickable(By.id("RunAuditSelectionProfile:Accept")));
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("RunAuditSelectionProfile:Accept"))).click();
    }

    @Then("Click export as pdf")
    public void clickExportAsPdf() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("RunAuditSelectionProfile:ExportPDF"))).click();

    }
    @Then("Click export as excel")
    public void clickExportAsExcel() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("RunAuditSelectionProfile:ExportExcel"))).click();
    }



    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    @Then("^Verify file \"([^\"]*)\" has been downloaded in downloads directory \"([^\"]*)\"$")
    public void verify_file_has_been_downloaded_in_downloads_directory(String fileName, String downloadPath) throws Throwable {
        Thread.sleep(10000);
        if (isFileDownloaded(downloadPath, fileName)) {
            System.out.println(fileName + ": has been downloaded");
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(fileName + ": has not been downloaded", false);
        }
    }


    @Then("Click cancel so as not to save profile")
    public void clickCancelSoAsNotToSaveProfile() {
        twenty.until(ExpectedConditions.elementToBeClickable(By.id("RunAuditSelectionProfile:Accept")));
        driver.findElement(By.id("RunAuditSelectionProfile:cancel")).click();
    }

    @Then("^User is navigated back to homepage \"([^\"]*)\"$")
    public void user_is_navigated_back_to_homepage_something(String url) throws Throwable {
        Thread.sleep(4000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(url,URL );
    }

    @Then("Navigate to audit > View visit selection report")
    public void navigateToAuditViewVisitSelectionReport() {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Audit']"))).click();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='View Visit Selection Report']"))).click();
    }

    @Then("verify fields in view visit selection reports screen")
    public void verifyFieldsInViewVisitSelectionReportsScreen() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:ReportId"))).isDisplayed();
        driver.findElement(By.id("SearchForm:ReportName")).isDisplayed();
        driver.findElement(By.id("SearchForm:DateGeneartedFrom_input")).isDisplayed();
        driver.findElement(By.id("SearchForm:ReportName")).isDisplayed();
        driver.findElement(By.id("SearchForm:DateGeneartedTo_input")).isDisplayed();
        driver.findElement(By.id("SearchForm:j_idt42")).isDisplayed();
        driver.findElement(By.id("SearchForm:j_id13")).isDisplayed();
    }

    @Then("Enter report ID as {string} and click search")
    public void enterReportIDAsAndClickSearch(String id) {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:ReportId"))).sendKeys(id);
        driver.findElement(By.id("SearchForm:j_idt42")).click();
    }

    @Then("Verify same report ID {string} is displayed")
    public void verifySameReportIDIsDisplayed(String id) {
        System.out.println(twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("ViewVisitSelectionReport:reportId"))).getAttribute("value"));
        Assert.assertTrue("Data is displayed",twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("ViewVisitSelectionReport:reportId"))).getAttribute("value").equals(id));
    }

    @Then("Export view selection report as pdf")
    public void exportViewSelectionReportAsPdf() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("ViewVisitSelectionReport:ExportPDF"))).click();
    }

    @Then("Export view selection report as excel")
    public void exportViewSelectionReportAsExcel() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("ViewVisitSelectionReport:ExportExcel"))).click();
    }

}



