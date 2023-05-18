package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

import parser.ReadXMLFile;

public class TableDataModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private ReadXMLFile tableXmlParser;
	public String tabela;
	private Vector<String> columnName = new Vector<String>();
	public Vector<Object> polja = new Vector<Object>();
	private DBConnection dbConnection;
	private int columnCount = 0;
	private int rowCount = 0;
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowCount;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnCount;
	}

	// vraca vrijednost celije na osnovu indeksa reda i kolone.
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return polja.get(columnIndex + rowIndex * columnCount);
	}


	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	public void setColumnName(Vector<String> columnName) {
		this.columnName = columnName;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}
	
	public ReadXMLFile getTableXmlParser() {
		return tableXmlParser;
	}

	public void setTableXmlParser(ReadXMLFile tableXmlParser) {
		this.tableXmlParser = tableXmlParser;
	}


	public Vector<Object> getPolja() {
		return polja;
	}

	public void setPolja(Vector<Object> polja) {
		this.polja = polja;
	}

	public Vector<String> getColumnName() {
		return columnName;
	}

	public TableDataModel(String tabela) {
		setTableXmlParser(new ReadXMLFile(tabela));
		setColumnName(tableXmlParser.getColumnName());
	}
	
	//brisanje vrijednosti polja na osnovu indeksa reda i kolone.
	public void removeFromPoljaAt(int rowIndex, int columnIndex)
	{
		polja.remove(columnIndex + rowIndex * columnCount);
	}
	public int getPoljeIndex(int rowIndex, int columnIndex)
	{
		return columnIndex + rowIndex * columnCount;
	}

	
	@SafeVarargs
	public final void executeStoredProcedure(String procedure, Object... params)
	{
		try
		{
			Connection connection = dbConnection.createConnection();
			CallableStatement callableStatement = connection.prepareCall("{ call " + procedure + " }",
					SQLServerResultSet.TYPE_SCROLL_INSENSITIVE, SQLServerResultSet.CONCUR_READ_ONLY);

			if (procedure.contains("?"))
			{
				for (int i = 0; i < params.length; i++)
				{
					callableStatement.setObject(i + 1, params[i]);
				}
			}
			ResultSet resultSet = callableStatement.executeQuery();
			ResultSetMetaData rsMetaData = resultSet.getMetaData();
				
			polja.clear();
				
			columnName.clear();
				
			rowCount = 0;
				
			columnCount = rsMetaData.getColumnCount();
				
				
				
			while (resultSet.next())
				{
					rowCount++;
					for (int i = 1; i <= columnCount; i++)
					{
						polja.add(resultSet.getObject(i));
					}
				}
			for (int i = 1; i <= columnCount; i++)
				{
					columnName.add(rsMetaData.getColumnName(i));
				}
			
			resultSet.close();
				
			this.fireTableStructureChanged();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@SafeVarargs
	public final void executeCreateStoredProcedure(String procedure, Object... params)
	{
		try
		{
			Connection connection = dbConnection.createConnection();
			CallableStatement callableStatement = connection.prepareCall("{ call " + procedure + " }",
					SQLServerResultSet.TYPE_SCROLL_INSENSITIVE, SQLServerResultSet.CONCUR_READ_ONLY);

			if (procedure.contains("?"))
			{
				for (int i = 0; i < params.length; i++)
				{
					callableStatement.setObject(i + 1, params[i]);
				}
			}
			callableStatement.execute();
		
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
