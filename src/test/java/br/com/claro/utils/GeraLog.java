package br.com.claro.utils;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class GeraLog {

	public static void criaArquivo() {
		try {
			// initializeABlank document
			@SuppressWarnings("resource")
			XWPFDocument document =  new XWPFDocument();
			// createA new file
			FileOutputStream out =  new FileOutputStream(new File("document.docx"));
			// createA new paragraph paragraph
			XWPFParagraph paragraph =  document.createParagraph();
			XWPFRun run =  paragraph.createRun();
			run.setText("File Format Developer Guide -"+ "LearnABout computer files that you comeAcross in "
					+ "your daily workAt: www.fileformat.com ");
			document.write(out);
			out.close();
		} catch (Exception ignored) {
			
		}

	}
}
