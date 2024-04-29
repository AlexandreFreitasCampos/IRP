package br.com.claro.utils;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class AcoesWeb extends DriverFactory {
    private String nomeArquivo;
    public void getURL(String string) {
        String textorecebido = getDriver().getCurrentUrl();
        try {
            Assert.assertEquals(string, textorecebido);
            PDF.escreveDocumento("URL " + textorecebido);
        } catch (AssertionError e) {
            PDF.escreveErroTexto(string, textorecebido);
        }
    }

    public static void aguardaElementoPresente(WebElement elemento) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(elemento));
    }

    public static void aguardaElementoClicavel(WebElement elemento) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(elemento));
    }

    public static void aguardaElementoVisivel() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id='filter']/div/div/div/button")));
    }

    public static void clicarElementosListaSelo(int posicao){
        getDriver().findElement(By.xpath("//ul[@class='multiselect-container " +
                "dropdown-menu show']/li[" + posicao + "]/a/label/input")).click();
    }

    public static void selecionarPeriodoInicial() {

        getDriver().findElement(By.xpath("//*[@id='custonReports_firstPeriod']")).click();
        WebElement elemento = getDriver().findElement(By.xpath("//th[@class='datepicker-switch']"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].click();", elemento);

        getDriver().findElement(By.xpath("//*[text()='2023']")).click();
        getDriver().findElement(By.xpath("//*[text()='Out']")).click();
    }

    public static void selecionarPeriodoFinal() {

        getDriver().findElement(By.xpath("//*[@id='custonReports_lastPeriod']")).click();
        WebElement elemento = getDriver().findElement(By.xpath("//th[@class='datepicker-switch']"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].click();", elemento);

        getDriver().findElement(By.xpath("//*[text()='2023']")).click();
        getDriver().findElement(By.xpath("//*[text()='Dez']")).click();
    }

    public void atualizaPagina(){
        getDriver().navigate().refresh();
    }
    public void abrirPastaDownload(){
        // Caminho para a pasta onde os arquivos CSV estão localizados
        String caminhoPasta = System.getProperty("user.home") + "\\Downloads";

        // Cria um objeto File representando a pasta
        File pasta = new File(caminhoPasta);

        // Verifica se a pasta existe e é realmente uma pasta
        if (pasta.exists() && pasta.isDirectory()) {
            // Lista todos os arquivos na pasta
            File[] arquivos = pasta.listFiles();

            // Itera sobre os arquivos
            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    // Verifica se o arquivo é um arquivo CSV
                    if (arquivo.isFile() && arquivo.getName().endsWith(".csv")) {
                        // Obtém e imprime o nome do arquivo CSV
                        nomeArquivo = arquivo.getName();
                    }
                }
            }
        }

        String caminhoArquivo = System.getProperty("user.home") + "\\Downloads\\" + nomeArquivo;
        try (CSVReader reader = new CSVReader(new FileReader(caminhoArquivo))) {
            // Lê todas as linhas do arquivo
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                // Imprime os valores de cada linha
                for (String valor : linha) {
                    System.out.print(valor + "\t");
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public void pegarColunaArquivoCSV() throws IOException, CsvValidationException {
        // Caminho para a pasta onde os arquivos CSV estão localizados
        String caminhoPasta = System.getProperty("user.home") + "\\Downloads";

        // Cria um objeto File representando a pasta
        File pasta = new File(caminhoPasta);

        // Verifica se a pasta existe e é realmente uma pasta
        if (pasta.exists() && pasta.isDirectory()) {
            // Lista todos os arquivos na pasta
            File[] arquivos = pasta.listFiles();

            // Itera sobre os arquivos
            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    // Verifica se o arquivo é um arquivo CSV
                    if (arquivo.isFile() && arquivo.getName().endsWith(".csv")) {
                        // Obtém e imprime o nome do arquivo CSV
                        nomeArquivo = arquivo.getName();
                    }
                }
            }
        }

        CSVParser parser = new CSVParserBuilder().withSeparator(';').build(); // Configura o parser para o separador de vírgula
        CSVReader reader = new CSVReaderBuilder(new FileReader(System.getProperty("user.home") + "\\Downloads\\" + nomeArquivo)).withCSVParser(parser).build();

        String[] header = reader.readNext(); // Lê a primeira linha (cabeçalho)

        // Encontra o índice da coluna pelo nome
        int colunaIndex = -1;
        for (int i = 0; i < header.length; i++) {
            if ("FinalValue".equals(header[i])) { // Substitua "NomeDaColuna" pelo nome real da coluna
                colunaIndex = i;
                break;
            }
        }

        if (colunaIndex != -1) {
            // Lê a segunda linha
            String[] segundaLinha = reader.readNext();

            // Encontra o índice da coluna pelo nome
            int colunaIndex2 = -1;
            for (int i = 0; i < header.length; i++) {
                if ("FinalValue".equals(header[i])) { // Substitua "NomeDaColuna" pelo nome real da coluna
                    colunaIndex2 = i;
                    break;
                }
            }

            if (colunaIndex != -1) {
                // Pula a primeira linha (cabeçalho)
                String[] linha;

                while ((linha = reader.readNext()) != null) {
                    String valorColuna = linha[colunaIndex2];
                    System.out.println("Valor da coluna 'NomeDaColuna': " + valorColuna);
                }
            } else {
                System.out.println("Nome da coluna não encontrado.");
            }

            reader.close();
        }
    }

    public static void clicarElementoViaJavaScript(WebElement elemento){
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", elemento);
    }
    public boolean aguardaCarregamentoArquivo(){
        boolean existe = getDriver().findElements(By.xpath("//*[@data-icon='retweet']")).size() > 0;
        return existe;
    }

    public void trocarPosicaoDeColunas(String texto1, String texto2){
        WebElement elemento1 = getDriver().findElement(By.xpath("//span[.='" + texto1 + "']"));
        WebElement elemento2 = getDriver().findElement(By.xpath("//span[.='" + texto2 + "']"));
        highlightElement(elemento1);
        Actions acao = new Actions(getDriver());
        acao.clickAndHold(elemento1)
                .moveToElement(elemento2)
                .release()
                .perform();
        highlightElement(elemento2);
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid blue;');", element);
    }
    public static void excluirColunas(){
         int tamanhoColuna = 15;
//        int contador = 1;
//        while(contador <= 15){
//            getDriver().findElement(By.xpath(
//                    "//div[@class='c-grid-columns__item'][" + tamanhoColuna + "]/div/button")).click();
//            tamanhoColuna--;
//            contador++;
//        }

        for(int i = 1; i <=15; i++){
            getDriver().findElement(By.xpath( "//div[@class='c-grid-columns__item'][1]/div/button")).click();
        }
    }

    public static void scrollAteElemento(WebElement elemento){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", elemento);
    }

    public static void scrollPagina(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

    }

}
