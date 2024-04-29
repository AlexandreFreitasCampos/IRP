package br.com.claro.utils;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.lowagie.text.pdf.PdfPTable;
import org.apache.commons.io.FileUtils;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;

import com.lowagie.text.pdf.PdfWriter;

public class
PDF {
	private static Document document;
	public static int contador = 1;
	static PdfPTable table;
	private static PdfPCell novaLinha;
	private static Font font;

	public static void criaDocumento(String nomeDocumento) throws DocumentException, IOException {
		document = new Document(PageSize.A4, 30, 30, 30, 30);
		PdfWriter.getInstance(document, new FileOutputStream("C:\\Automacao\\Evidencias\\" + nomeDocumento + ".pdf"));

		Cronometro.start();
		System.out.println("Criando o documento");
	}

	public static void insereCaBecalho() {
		try {
			// HeaderFooter header = new HeaderFooter(new Phrase("This isA header."),
			// false);

			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 0);
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

			String dataFormatada = format1.format(cal.getTime());

			HeaderFooter footer = new HeaderFooter(new Phrase(dataFormatada
					+ "                  © 2023 Claro. Todos os direitos reservados                    Página  "),
					new Phrase("."));
			footer.setAlignment(Element.ALIGN_JUSTIFIED);

			document.setFooter(footer);

			document.open();

			Image logoIRP = Image.getInstance(System.getProperty("user.dir") + "/src/img/LogoIRP.png");
			logoIRP.scaleAbsolute(50, 50);
			logoIRP.setAlignment(Element.ALIGN_CENTER);
			Image logoImusica = Image.getInstance(System.getProperty("user.dir") + "/src/img/LogoImusica.png");
			logoImusica.scaleAbsolute(50, 50);
			logoImusica.setAlignment(Element.ALIGN_CENTER);

			table = new PdfPTable(new float[] { 20, 60, 20 });
			table.setWidthPercentage(100);

			PdfPCell cellHeader1 = new PdfPCell();
			cellHeader1.addElement(logoImusica);

			font = new Font(Font.HELVETICA, 18, Font.BOLDITALIC, new Color(0, 0, 205));
			// Text textoCaBecalho = new Text("Evidência de testesAutomatzados")
			PdfPCell cellHeader2 = new PdfPCell(new Paragraph("Evidência de testes automatizados", font));
			cellHeader2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellHeader2.setPaddingTop(15);

			PdfPCell cellHeader3 = new PdfPCell();
			cellHeader3.addElement(logoIRP);

			table.addCell(cellHeader1);
			table.addCell(cellHeader2);
			table.addCell(cellHeader3);

			// Adicona uma liha em branco depois do cabeçalho
			PdfPCell pulaLinha = new PdfPCell(new Paragraph(" "));
			pulaLinha.setColspan(3);
			pulaLinha.setBorder(-1);
			table.addCell(pulaLinha);

			table.setHeaderRows(1);

			System.out.println("Inserindo o cabeçalho e rodapé...");

		} catch (Exception e) {

		}
	}

	public static void escreveTitulo(String parametro) {
		final String ANSI_BLUE = "\u001B[34m";
		final String ANSI_RESET = "\u001B[0m";

		font = new Font(Font.HELVETICA, 18, Font.BOLDITALIC, new Color(0, 0, 205));
		PdfPCell titulo1 = new PdfPCell(new Paragraph(""));
		PdfPCell titulo = new PdfPCell(new Paragraph(parametro, font));
		PdfPCell titulo2 = new PdfPCell(new Paragraph(""));
		titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
		titulo.setColspan(3);
		titulo.setBorder(-1);
		titulo.setExtraParagraphSpace(20);
		table.addCell(titulo);

		System.out.println(ANSI_BLUE + "Inserindo o título '" + parametro + "'..." + ANSI_RESET);
	}
	
	public static void escreveSubTitulo(String parametro) {
		final String ANSI_BLUE = "\u001B[34m";
		final String ANSI_RESET = "\u001B[0m";

		font = new Font(Font.HELVETICA, 12, Font.BOLD, new Color(0, 0, 205));
		PdfPCell subTitulo = new PdfPCell(new Paragraph(parametro, font));
		subTitulo.setHorizontalAlignment(Element.ALIGN_LEFT);
		subTitulo.setColspan(3);
		subTitulo.setBorder(-1);
		subTitulo.setPaddingTop(5);
		subTitulo.setPaddingBottom(-4);
		table.addCell(subTitulo);

		System.out.println(ANSI_BLUE + "Inserindo o subtítulo '" + parametro + "'..." + ANSI_RESET);
	}

	public static void escreveDocumento(String parametro) {
		PdfPCell descricao;
		if (parametro.contains("Tempo de execução do teste:")) {
			descricao = new PdfPCell(new Paragraph(parametro));
		} else {
			descricao = new PdfPCell(new Paragraph(parametro + " - Ok"));
		}
		descricao.setHorizontalAlignment(Element.ALIGN_LEFT);
		descricao.setPaddingTop(5);
		descricao.setColspan(3);
		descricao.setBorder(-1);

		table.addCell(descricao);
	}

	public static void escreveStep(String parametro) {
		try {
			final String ANSI_GREEN = "\u001B[32m";
			final String ANSI_RESET = "\u001B[0m";

			font = new Font(Font.HELVETICA, 14, Font.BOLDITALIC, new Color(0, 100, 0));
			PdfPCell steps = new PdfPCell(new Paragraph("1." + contador + " - " + parametro, font));
			steps.setHorizontalAlignment(Element.ALIGN_LEFT);
			steps.setPaddingTop(15);
			steps.setColspan(3);
			steps.setBorder(-1);
			table.addCell(steps);

			System.out.println(ANSI_GREEN + "1." + contador + "-" + parametro + ANSI_RESET);

			contador++;

		} catch (Exception e) {

		}
	}

	public static void inserePrint() {
		try {
			Thread.sleep(200);
			TiraPrint.screenShot();
			Image img = Image.getInstance("C:\\Automacao\\Img\\" + TiraPrint.nomeArquivo);

			PdfPCell print = new PdfPCell(new PdfPCell(img));
			print.setPaddingTop(10);
			img.scaleAbsolute(550, 650);
			img.setAlignment(Element.ALIGN_CENTER);
			print.addElement(img);
			print.setBorder(-1);
			print.setColspan(3);
			table.addCell(print);
		} catch (Exception e) {

		}
	}

	public static void salvaDocumento() {
		try {
			Cronometro.stop();

			document.add(table);
			contador = 1;

			document.close();

			// Limpa os prints da pasta
			File diretorio = new File("C:\\Automacao\\Img\\");
			System.gc();
			FileUtils.cleanDirectory(diretorio);

			System.out.println("Salva o documento");
		} catch (Exception e) {

		}
	}

	public static void escreveErroComponente(String componente) {

		final String ANSI_RED = "\u001B[31m";
		final String ANSI_RESET = "\u001B[0m";

		// Adicona uma linha em branco depois do cabeçalho
		PdfPCell pulaLinha = new PdfPCell(new Paragraph(" "));
		pulaLinha.setColspan(3);
		pulaLinha.setBorder(-1);
		table.addCell(pulaLinha);

		font = new Font(Font.HELVETICA, 16, Font.BOLDITALIC, new Color(255, 0, 0));
		PdfPCell tituloLog = new PdfPCell(new Paragraph("Falha ao validar o componente!!!", font));
		// textoLog = new PdfPCell(new Paragraph(parametro));
		tituloLog.setColspan(3);
		tituloLog.setHorizontalAlignment(Element.ALIGN_CENTER);
		tituloLog.setBorder(-1);
		table.addCell(tituloLog);

		PdfPCell textoloLog = new PdfPCell(new Paragraph(componente));
		// textoLog = new PdfPCell(new Paragraph(parametro));
		textoloLog.setColspan(3);
		textoloLog.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		textoloLog.setBorder(-1);
		table.addCell(textoloLog);

		// PDF.salvaDocumento();

		System.out.println(ANSI_RED + "Falha na execução do teste, favor consultar o log!!!" + ANSI_RESET);
	}

	public static void escreveErroTexto(String textoEsperado, String textorecebido) {
		final String ANSI_RED = "\u001B[31m";
		final String ANSI_RESET = "\u001B[0m";

		font = new Font(Font.HELVETICA, 16, Font.BOLDITALIC, new Color(255, 0, 0));
		PdfPCell tituloLog = new PdfPCell(new Paragraph("Falha ao validar os textos!!!", font));
		tituloLog.setColspan(3);
		tituloLog.setHorizontalAlignment(Element.ALIGN_CENTER);
		tituloLog.setBorder(-1);
		table.addCell(tituloLog);

		font = new Font(Font.HELVETICA, 12, Font.BOLDITALIC, new Color(255, 0, 0));
		PdfPCell textoLog = new PdfPCell(
				new Paragraph("Texto esperado:\n" + textoEsperado + "\n\nTexto recebido:\n" + textorecebido, font));
		textoLog.setColspan(3);
		textoLog.setHorizontalAlignment(Element.ALIGN_LEFT);
		textoLog.setBorder(-1);
		table.addCell(textoLog);

		System.out.println(ANSI_RED + "Falha ao validar os textos" + ANSI_RESET);
		System.out.println(ANSI_RED + "Texto esperado " + textoEsperado + ANSI_RESET);
		System.out.println(ANSI_RED + "Texto recebido " + textorecebido + ANSI_RESET);
	}

	public static void escreveDocumentacao(String parametro, String texto) {

		switch (parametro) {
		case "descricao":
			font = new Font(Font.HELVETICA, 12, Font.BOLDITALIC, new Color(0, 0, 0));
			novaLinha = new PdfPCell(new Paragraph(texto, font));
			novaLinha.setColspan(3);
			novaLinha.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			novaLinha.setPaddingTop(5);
			novaLinha.setPaddingLeft(5);
			novaLinha.setPaddingBottom(5);
			novaLinha.setPaddingRight(5);
			// textoLog.setBorder(8);
			table.addCell(novaLinha);
			break;
		case "suBTitulo":
			font = new Font(Font.HELVETICA, 14, Font.BOLDITALIC, new Color(0, 0, 205));
			novaLinha = new PdfPCell(new Paragraph(texto, font));
			novaLinha.setColspan(3);
			novaLinha.setHorizontalAlignment(Element.ALIGN_CENTER);
			novaLinha.setPaddingTop(5);
			novaLinha.setPaddingLeft(5);
			novaLinha.setPaddingBottom(5);
			novaLinha.setPaddingRight(5);
			novaLinha.setBorder(0);
			table.addCell(novaLinha);
			break;
		case "texto":
			font = new Font(Font.HELVETICA, 12, Font.NORMAL, new Color(0, 0, 0));
			novaLinha = new PdfPCell(new Paragraph(texto, font));
			novaLinha.setColspan(3);
			novaLinha.setHorizontalAlignment(Element.ALIGN_LEFT);
			novaLinha.setPaddingTop(5);
			novaLinha.setPaddingLeft(5);
			novaLinha.setPaddingBottom(5);
			novaLinha.setPaddingRight(5);
			table.addCell(novaLinha);
			break;
		case "classes":
			font = new Font(Font.HELVETICA, 12, Font.NORMAL, new Color(0, 0, 0));
			novaLinha = new PdfPCell(new Paragraph(texto, font));
			novaLinha.setColspan(3);
			novaLinha.setHorizontalAlignment(Element.ALIGN_LEFT);
			novaLinha.setPaddingTop(5);
			novaLinha.setPaddingLeft(5);
			novaLinha.setPaddingBottom(5);
			novaLinha.setPaddingRight(5);
			novaLinha.setBorder(0);
			novaLinha.setBorderWidthTop(1);
			novaLinha.setBorderWidthLeft(1);
			novaLinha.setBorderWidthRight(1);

			table.addCell(novaLinha);
			break;

		default:
			break;
		}
	}

}
