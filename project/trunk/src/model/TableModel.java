package model;

import java.util.Vector;

public class TableModel {

	private String kod = null;
	private String naziv = null;
	private Vector<String> kolone = new Vector<String>();
	private int brojKolona;
	
	
	public String getKod() {
		return kod;
	}
	public void setKod(String procedura) {
		this.kod = procedura;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public Vector<String> getKolone() {
		return kolone;
	}
	public void setKolone(Vector<String> kolone) {
		this.kolone = kolone;
	}
	
	public int getBrojKolona() {
		return brojKolona;
	}
	public void setBrojKolona(int brojKolona) {
		this.brojKolona = brojKolona;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return naziv;
	}
	
	public TableModel(String kod, String naziv)
	{
		setKod(kod);
		setNaziv(naziv);
	}
	
	public TableModel() {
		// TODO Auto-generated constructor stub
	}
	
}
