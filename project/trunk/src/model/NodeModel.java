package model;

import java.util.Vector;

 class NodeModel {
	 
	private String ime = null;
	private Vector<TableModel> tabele = new Vector<>();
	
	public NodeModel()
	{
		
	}

	public NodeModel(String ime, Vector<TableModel> tabele)
	{
		setIme(ime);
		setTabele(tabele);
	}
	
	public String getIme()
	{
		return ime;
	}

	public void setIme(String ime)
	{
		this.ime = ime;
	}
	
	@Override
	public String toString()
	{
		return ime;
	}

	public Vector<TableModel> getTabele()
	{
		return tabele;
	}

	public void setTabele(Vector<TableModel> tabele)
	{
		this.tabele = tabele;
	}

}
