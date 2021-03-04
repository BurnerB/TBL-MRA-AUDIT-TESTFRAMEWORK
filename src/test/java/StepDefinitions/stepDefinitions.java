package StepDefinitions;


import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
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
public class stepDefinitions extends BaseClass {
    public Properties Pro;
    public static WebDriver driver;

    public static sharedatastep sharedata;

    public stepDefinitions(sharedatastep sharedata) {

        stepDefinitions.sharedata = sharedata;

    }

    @Before(order = 2)
    public void method1() throws Exception {
        Pro = new Properties();
        FileInputStream fls = new FileInputStream("src\\test\\resources\\global.properties");
        Pro.load(fls);

    }

    @Given("^User navigates to the login page$")
    public void user_navigates_to_the_login_page() throws Throwable {
        driver = BaseClass.getDriver();
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
        driver = BaseClass.getDriver();
        driver.get("https://" + strArg1 + ":Passw0rd@trips-crm.mra.mw:5555/TripsWorkflow/main.aspx");
    }

    @And("^Close Popup Window$")
    public void close_Popup_Window() throws Throwable {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement specificframe = (driver.findElement(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame__ID"))));
        driver.switchTo().frame(specificframe);
        WebDriverWait CloseWindow = new WebDriverWait(driver, 60);
        CloseWindow.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }

    @And("^Click on Case management dropdown$")
    public void click_on_case_management_dropdown() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"TabCS\"]/a/span")).click();
    }

    @And("^click on Queues$")
    public void click_on_revenue_collection_application() throws Throwable {
        driver.findElement(By.xpath("//*[text()='Queues']")).click();
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
        search.sendKeys("*AV/000000861/2021");
//        search.sendKeys("*"+sharedatastep.AUD_CRMARN);
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
    }

    @And("^picks the audit case$")
    public void picks_the_audit_case() throws Throwable {
        WebElement pickCheckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));

        Actions actions = new Actions(driver);
        actions.doubleClick(pickCheckBox).perform();

        driver.switchTo().defaultContent();
    }


    @And("^click assign button$")
    public void click_assign_button() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
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
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement assignPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("InlineDialog")));
        Assert.assertTrue(assignPopup.isDisplayed());

        driver.switchTo().frame("InlineDialog_Iframe");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        WebElement popupHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assignheader_id")));
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

//    @And("^auditor picks the case$")
//    public void auditor_picks_the_case() throws Throwable {
//
//
//
//
//
//
////        WebElement caseCheckbox = driver.findElement(By.xpath("//input[@type='checkbox' and title='Audit and Visit - "++"']"));
//        WebElement caseCheckbox = driver.findElement(By.xpath("//input[@type='checkbox' and title='Audit and Visit - AV/000000834/2021']"));
//        caseCheckbox.click();
//
//        Actions actions = new Actions(driver);
//        actions.doubleClick(elementLocator).perform();
//
//        driver.switchTo().defaultContent();
//        Thread.sleep(2000);
//    }

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

    @Then("^create \"([^\"]*)\" is displayed$")
    public void create_something_is_displayed(String strArg1) throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 100);
//        WebElement createAuditPlan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+strArg1+"']")));

        WebElement createAuditPlan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+strArg1+"']")));



        Assert.assertTrue(createAuditPlan.isDisplayed());
    }


    @When("^clicks create audit plan$")
    public void clicks_create_audit_plan() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement createAuditPlan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Create Audit Plan ']")));
        createAuditPlan.click();

    }

    @When("^clicks create preliminary audit$")
    public void clicks_create_preliminary_audit() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement createAuditPlan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbg_auditapplication|NoRelationship|Form|tbg.tbg_auditapplication.CreatePreliminaryAuditFindings.Button\"]/span/a/span")));
        createAuditPlan.click();

    }

    @And("^verifies \"([^\"]*)\" entry fields are displayed$")
    public void verifies_something_entry_fields_are_displayed(String strArg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement loadFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_AuditApplicationAngular")));
        driver.switchTo().frame(loadFrame);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement createAuditPlan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + strArg1 + "']")));
        Assert.assertTrue(createAuditPlan.isDisplayed());

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

    @And("^enters AUDIT SCOPE METHODOLOGY$")
    public void enters_audit_scope_methodology(DataTable auditScopeTable ) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);

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
        driver.findElement(By.xpath("//li[@class='ng-tns-c7-5 ui-dropdown-item ui-corner-all ng-star-inserted' and contains(., '" + data.get(0).get(1) +"')]")).click();

        WebElement periodDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-dropdown[2]/div/div[2]/div/p-dropdown/div")));
        periodDropdown.click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//li[@class='ng-tns-c7-6 ui-dropdown-item ui-corner-all ng-star-inserted' and contains(., '" + data.get(1).get(1) +"')]")).click();

        WebElement riskAreaDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-dropdown[3]/div/div[2]/div/p-dropdown/div/label")));
        riskAreaDropdown.click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//li[@class='ng-tns-c7-7 ui-dropdown-item ui-corner-all ng-star-inserted' and contains(., '" + data.get(2).get(1) +"')]")).click();

        WebElement percievedriskDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-audit/app-add-update-case-plan/div/form/div[1]/div/div/tb-dropdown[4]/div/div[2]/div/p-dropdown/div/label")));
        percievedriskDropdown.click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//li[@class='ng-tns-c7-8 ui-dropdown-item ui-corner-all ng-star-inserted' and contains(., '" + data.get(2).get(1) +"')]")).click();

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
        WebDriverWait wait = new WebDriverWait(driver, 30);

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

    @Then("^Audit status should be \"([^\"]*)\"$")
    public void application_account_adjustment_status_should_be_something(String Status) throws Throwable {
        driver.switchTo().frame("contentIFrame1");
        WebDriverWait wait = new WebDriverWait(driver,30);
        Thread.sleep(3000);

//        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Status_label"))).getText();

        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+Status+"']"))).getText();
//        if(text.contains(Status))
//        {
//
//            System.out.println("Text Verified and"+Status);
//        }
//        else
//        {
//            System.out.println("Text Not Verfied and failed");
//        }
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



}



