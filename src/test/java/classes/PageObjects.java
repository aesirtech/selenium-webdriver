package classes;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import utilities.Base;

import java.io.File;
import java.io.IOException;



public class PageObjects extends Base {
    /**
     * 	SIGN UP STRING VALUES
     * */
    private final String SIGNUP_EMAIL = "galoh37179@tourcc.com";
    private final String SIGNUP_PASSWORD = "!Plu5L1f3#";
    private final String PASSWORD_CONFIRMATION = "!Plu5L1f3#";
    private final String CPF = "28746684000";
    private final String BIRTH_DATE = "12031980";
    private final String FULL_NAME = "João Alberto dos Santos";
    private final String PHONE_NUMBER = "48";
    private final String MOBILE_PHONE_NUMBER = "48";


    /**
     *  EXTENT REPORTS
     * */
    public static ExtentReports extent;
    public static ExtentTest test;


    /**
     * 	LOG IN STRING VALUES
     * */
    private final String LOGIN_EMAIL = "galoh37179@tourcc.com";
    private final String LOGIN_PASSWORD = "!Plu5L1f3#";


    /**
     * 	USING @FindBy ANNOTATION TO GET PAGE ELEMENTS
     * */
    // MAIN PAGE
    @FindBy(xpath = "//a[@class='btn-user btn btn-link btn-md text-right hidden-xs']")
    private WebElement entrarCadastrar;

    @FindBy(xpath = "((//div/a[@class='link_open'])[2])")
    private WebElement opcaoCadastrar;

    @FindBy(xpath = "//div[@id='menu-container']")
    private WebElement header;

    @FindBy(xpath = "((//div[@class='form'])[2])")
    private WebElement telaCadastro;



    // RADIO BUTTONS
    @FindBy(id = "ConteudoBodyMaster_ConteudoCorpo_CtlIdentificacao_rdlPessoaFisica")
    private WebElement pessoaFisica;

    @FindBy(id = "ConteudoBodyMaster_ConteudoCorpo_CtlIdentificacao_rdlPessoaJuridica")
    private WebElement pessoaJuridica;

    @FindBy(id = "ConteudoBodyMaster_ConteudoCorpo_CtlIdentificacao_rdlSexoMasculino")
    private WebElement sexoMasculino;

    @FindBy(id = "ConteudoBodyMaster_ConteudoCorpo_CtlIdentificacao_rdlSexoFeminino")
    private WebElement sexoFeminino;



    //	INPUTS
    @FindBy(id = "ConteudoBodyMaster_ConteudoCorpo_CtlIdentificacao_txtEmail")
    private WebElement email;

    @FindBy(id = "ConteudoBodyMaster_ConteudoCorpo_CtlIdentificacao_txtSenha")
    private WebElement criarSenha;

    @FindBy(id = "ConteudoBodyMaster_ConteudoCorpo_CtlIdentificacao_txtSenha2")
    private WebElement confirmarSenha;

    @FindBy(id = "ConteudoBodyMaster_ConteudoCorpo_CtlIdentificacao_txtCPF")
    private WebElement cpf;

    @FindBy(id = "ConteudoBodyMaster_ConteudoCorpo_CtlIdentificacao_txtDtNascimento")
    private WebElement dataNascimento;

    @FindBy(id = "ConteudoBodyMaster_ConteudoCorpo_CtlIdentificacao_txtNomeRazaoSocial")
    private WebElement nomeCompleto;

    @FindBy(id = "ConteudoBodyMaster_ConteudoCorpo_CtlIdentificacao_txtDDDFone")
    private WebElement telefone;

    @FindBy(id = "ConteudoBodyMaster_ConteudoCorpo_CtlIdentificacao_txtDDDCelular")
    private WebElement celular;

    @FindBy(id = "ConteudoBodyMaster_ConteudoCorpo_CtlIdentificacao_txtLoginEmail")
    private WebElement loginEmail;

    @FindBy(id = "ConteudoBodyMaster_ConteudoCorpo_CtlIdentificacao_txtLoginSenha")
    private WebElement loginPassword;



    // BUTTONS
    @FindBy(id = "ConteudoBodyMaster_ConteudoCorpo_CtlIdentificacao_lnkCriarConta")
    private WebElement botaoCriarConta;

    @FindBy(id = "ConteudoBodyMaster_ConteudoCorpo_CtlIdentificacao_lnkLogin")
    private WebElement botaoLogar;


    // CONSTRUCTOR
    public PageObjects(WebDriver driver) {
        super(driver);
    }



    /**
     * 	SIGN UP PAGE ACTIONS
     * */
    public void paniniUserRegistration() throws IOException, InterruptedException {
        extent = new ExtentReports(System.getProperty("user.dir") + "\\reports\\signUpPageTestResults.html");
        ExtentTest test = extent.startTest("Checking the browser opening and user registration being performed");

        test.log(LogStatus.INFO, "Browser is open");
        test.log(LogStatus.INFO, "Browser is maximized");
        File srcMainPage = driver.findElement(By.xpath("//div[@id='menu-container']")).getScreenshotAs(OutputType.FILE);
        if(header.isDisplayed()) {
            try {
                // HOME PAGE EVIDENCE
                FileHandler.copy(srcMainPage, new File(System.getProperty("user.dir") + "\\evidence\\mainPage\\home.png\\"));
                test.log(LogStatus.INFO, "Taking home page evidence");
                test.log(LogStatus.PASS, "Home page evidence success");
                Thread.sleep(3000);
                test.log(LogStatus.INFO, "3 second wait");

                this.entrarCadastrar.click();
                test.log(LogStatus.INFO, "Clicking on sign in/sign up session");
                Thread.sleep(2000);
                test.log(LogStatus.INFO, "2 second wait");
                this.opcaoCadastrar.click();
                test.log(LogStatus.INFO, "Choosing sign up option");
                this.opcaoCadastrar.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
                test.log(LogStatus.INFO, "Using the 'ARROW_DOWN' option to lower the screen and get better evidence");
                Thread.sleep(2000);
                test.log(LogStatus.INFO, "2 second wait");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(2000);
        test.log(LogStatus.INFO, "2 second wait");
        if(telaCadastro.isDisplayed()) {
            try {
                // SIGNUP PAGE EVIDENCE
                File srcSignupPage = driver.findElement(By.xpath("((//div[@class='form'])[2])")).getScreenshotAs(OutputType.FILE);
                FileHandler.copy(srcSignupPage, new File(System.getProperty("user.dir") + "\\evidence\\SignupPage\\signup.png\\"));
                test.log(LogStatus.INFO, "Taking sign up page evidence");
                test.log(LogStatus.PASS, "Sign up page evidence success");
            }catch(Exception e) {
                e.getStackTrace();
            }
        }

        // TYPING INPUT FIELDS
        this.email.sendKeys(SIGNUP_EMAIL);
        test.log(LogStatus.INFO, "Inserting e-mail value");
        this.criarSenha.sendKeys(SIGNUP_PASSWORD);
        test.log(LogStatus.INFO, "Inserting password value");
        this.confirmarSenha.sendKeys(PASSWORD_CONFIRMATION);
        test.log(LogStatus.INFO, "Inserting password confirmation value");
        this.cpf.sendKeys(CPF);
        test.log(LogStatus.INFO, "Inserting CPF value");
        this.dataNascimento.sendKeys(BIRTH_DATE);
        test.log(LogStatus.INFO, "Inserting birth date value");
        this.sexoMasculino.click();
        test.log(LogStatus.INFO, "Clicking male radio button");
        this.nomeCompleto.sendKeys(FULL_NAME);
        test.log(LogStatus.INFO, "Inserting full name");
        this.celular.sendKeys(MOBILE_PHONE_NUMBER, Keys.TAB, "988163310");
        test.log(LogStatus.INFO, "Inserting mobile phone value");
        this.botaoCriarConta.click();
        test.log(LogStatus.INFO, "Clicking account register button");
        test.log(LogStatus.PASS, "Screen home is displayed");

        // SIGNUP SUCCESS
        File srcSignupSuccess = driver.findElement(By.xpath("(//div[@class='bar-tools col-lg-9 col-md-9 col-sm-8 col-xs-12'])")).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcSignupSuccess, new File(System.getProperty("user.dir") + "\\evidence\\SignupSuccess\\signupSuccess.png\\"));
        test.log(LogStatus.INFO, "Taking evidence from the home page after registration");
        test.log(LogStatus.PASS, "Home page after registration evidence success");
        extent.flush();
    }



    /**
     * 	LOG IN PAGE ACTIONS
     * */
    public void paniniUserLogin() throws IOException, InterruptedException {
        extent = new ExtentReports(System.getProperty("user.dir") + "\\reports\\logInPageTestResults.html");
        ExtentTest test = extent.startTest("Checking browser opening and user logging in");
        
        test.log(LogStatus.INFO, "Browser is open");
        test.log(LogStatus.INFO, "Browser is maximized");
        this.entrarCadastrar.click();
        test.log(LogStatus.INFO, "Clicking on login session'");

        // LOGIN PAGE EVIDENCE
        File srcLoginPage = driver.findElement(By.xpath("(//div[@class='login'])")).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcLoginPage, new File(System.getProperty("user.dir") + "\\evidence\\LoginPage\\loginPage.png\\"));
        test.log(LogStatus.INFO, "Taking login page evidence");
        test.log(LogStatus.PASS, "Login page evidence success!");


        // LOGIN
        this.loginEmail.sendKeys(LOGIN_EMAIL);
        test.log(LogStatus.INFO, "Inserting e-mail value");
        this.loginPassword.sendKeys(LOGIN_PASSWORD);
        test.log(LogStatus.INFO, "Inserting password value");
        this.botaoLogar.click();
        test.log(LogStatus.INFO, "Clicking on login button");
        Thread.sleep(3000);
        test.log(LogStatus.PASS, "Login success!");

        // LOGIN EVIDENCE
        File srcLoginSuccess = driver.findElement(By.xpath("(//div[@id='content'])")).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcLoginSuccess, new File(System.getProperty("user.dir") + "\\evidence\\LoginSuccess\\loginSuccess.png\\"));
        test.log(LogStatus.INFO, "Taking login home evidence");
        test.log(LogStatus.PASS, "Login home evidence success!");
        extent.flush();
    }
}
