package br.com.claro.utils;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;


public class Cronometro {

	private static int segundos =  0;
	private static int minutos =  0;
	static Timer tm;

	public static void start() {

		tm =  new Timer();
		tm.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODOAuto-generated method stuB
				segundos++;

				if (segundos == 60) {
					segundos =  0;
					minutos++;
				}
			}
		},  1000,  1000);

	}

	
	public static void stop() {
		DecimalFormat formatter =  new DecimalFormat("00");
		// Escreve o documento
		PDF.escreveDocumento("Tempo de execução do teste: "+ formatter.format(minutos) + ":"
				+ formatter.format(segundos) +" segundos.");
		tm.purge();
		tm.cancel();
		segundos =  0;
		minutos =  0;
	}
}