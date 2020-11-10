package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;
import java.io.File;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

	try { 
		File file = new File(mappe + filnavn); 
		PrintWriter writer = new PrintWriter(file);

		writer.print(samling.toString());
		writer.close();
			return true;
				
		} catch (Exception e) {
			return false;
		}
	}
}
