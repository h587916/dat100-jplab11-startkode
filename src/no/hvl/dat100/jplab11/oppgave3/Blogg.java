package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggTab;
	private int nesteLedig;

	public Blogg() {
		this(20);
	}

	public Blogg(int lengde) {
		innleggTab = new Innlegg[lengde];
		nesteLedig = 0;
	}

	public int getAntall() {
		return nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return this.innleggTab;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		int x = -1;
		for (int i = 0; i < nesteLedig; i++) {
			if (innleggTab[i].erLik(innlegg)) {
				x = i;
			}
		}
		return x;
	}

	public boolean finnes(Innlegg innlegg) {
		boolean funnet = false;
		for (int i = 0; i < nesteLedig; i++) {
			if (innleggTab[i].erLik(innlegg) && innleggTab[i] != null) {
				funnet = true;
			}
		}
		return funnet;	
	}
 
	public boolean ledigPlass() {
		return nesteLedig < innleggTab.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		boolean ny = false;
		if (!finnes(innlegg) && ledigPlass()) {
			innleggTab[nesteLedig] = innlegg;
			nesteLedig++;
			ny = true;
		}
		return ny;
	}
	
	public String toString() {
		String svar = "" + nesteLedig + "\n";
		for (int i = 0; i < nesteLedig; i++) {
			svar += innleggTab[i].toString();
		}
		return svar;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() { 
		Innlegg[] nytab = new Innlegg[innleggTab.length * 2]; 
		for (int i = 0; i < nesteLedig; i++) { 
			nytab[i] = innleggTab[i]; 
			} 
		innleggTab = nytab; 
		}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if (finnes(innlegg)) { 
			return false; 
			} 
		if (!ledigPlass()) { 
			utvid(); 
			} 
			innleggTab[nesteLedig] = innlegg; 
			nesteLedig++; 
			return true; 
	}
	
	public boolean slett(Innlegg innlegg) {
		boolean svar = false;
		int pos = finnInnlegg(innlegg);
		if (pos >= 0) {
			nesteLedig--;
			innleggTab[pos] = innleggTab[nesteLedig];
			innleggTab[nesteLedig] = null;
			svar = true;
		}
		return svar;
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}