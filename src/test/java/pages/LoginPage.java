package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import runner.RunCucumber;

import static support.Commands.*;

public class LoginPage extends RunCucumber {

    // elementos
    private String URL = "http://automationpratice.com.br/";
    private By botaoAcessarLogin = By.cssSelector(".right_list_fix > li > a > .fa-user");
    private By campoEmail = By.id("user");
    private By campoSenha = By.id("password");
    private By botaoFazerLogin = By.id("btnLogin");
    private By botaoAcessarCadastro = By.cssSelector(".right_list_fix > li > a > .fa-lock");

    // ações / funções / métodos
    public void acessarAplicao() {
        getDriver("chrome").get(URL);
    }

    public void acessarTelaLogin() {
        //getDriver().findElement(botaoAcessarLogin).click();
        clickElement(botaoAcessarLogin);
    }

    public void preencheEmail(String email){
        //getDriver().findElement(campoEmail).sendKeys(email);
        fillField(campoEmail, email);
    }

    public void preencherSenha(String senha){
        //getDriver().findElement(campoSenha).sendKeys(senha);
        fillField(campoSenha, senha);
    }

    public void clicarLogin(){
        //getDriver().findElement(botaoFazerLogin).click();
        clickElement(botaoFazerLogin);
    }

    public void verificaLoginSucesso(){
        checkMessage(By.id("swal2-title"), "Login realizado");
        //waitElementBeVisible(By.id("swal2-title"), 1000);
        //String textoLoginSucesso = getDriver().findElement(By.id("swal2-title")).getText();
        //Assert.assertEquals("Os textos não são iguais!", "Login realizado", textoLoginSucesso);
    }

    public void verificaCampoVazio(String message){
        checkMessage(By.className("invalid_input"), message);
        //String textError = getDriver().findElement(By.className("invalid_input")).getText();
        //Assert.assertEquals(message, textError);
    }

    public void acessarTelaCadastro(){
        //getDriver().findElement(botaoAcessarCadastro).click();
        clickElement(botaoAcessarCadastro);
    }

}
