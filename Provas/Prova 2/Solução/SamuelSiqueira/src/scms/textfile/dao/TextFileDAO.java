package scms.textfile.dao;

import java.util.ArrayList;
import java.util.List;
import mos.textfile.TextFile;

public class TextFileDAO implements DAO<Object> 
{
	private TextFile arquivo = new TextFile();
		
	@Override
	public boolean open(String nomeRecurso) throws Exception 
	{		
		try 
		{
			arquivo.open(nomeRecurso); 			
			return true;
		} 
		catch (Exception e) 
		{
			try 
			{
				arquivo.create(nomeRecurso);				
				arquivo.close();
				return true;
			} 
			catch (Exception e2) 
			{
				throw new Exception();
			}
		}
	}
	@Override
	public void close() throws Exception 
	{
		try
		{
			arquivo.close();
		} 
		catch (Exception e) 
		{
			throw new Exception();
		}
	}
	
	@Override
	public boolean insert(Object objeto) throws Exception 
	{
		try 
		{
			arquivo.open(arquivo.getFilename());
			String conteudo = arquivo.read();
			arquivo.close();
						
			arquivo.create(arquivo.getFilename());
			arquivo.write(conteudo + objeto);
			arquivo.close();
			
			return true;
			
		} 
		catch (Exception e) 
		{
			throw new Exception();
		}
	}
	
	@Override
	public boolean update(Object objeto) throws Exception 
	{
		return false;
	}
	
	@Override
	public boolean delete(Object objeto) throws Exception 
	{
		return false;
	}
	
	@Override
	public Object get()  throws Exception
	{
		return null;
	}
	
	@Override
	public int numberOfObjects() throws Exception 
	{
		try
		{
			int numLinhas = 0;
			arquivo.open(arquivo.getFilename());
			
			while(arquivo.readLine() != null)
				numLinhas++;
			
			arquivo.close();
			
			return numLinhas;
		} 
		catch (Exception e) 
		{
			throw new Exception();
		}
	}
	
	@Override
	public List<Object> listaObjetos() throws Exception 
	{				
		List<Object> listaObjetos =  new ArrayList<>();
		
		try
		{
			arquivo.open(arquivo.getFilename());
			
			String linha = "";
			
			while(true)
			{
				linha = arquivo.readLine() ;
				if(linha == null) break;
				listaObjetos.add(linha);
			}
			
			arquivo.close();
			return listaObjetos;		
		} 
		catch (Exception e) 
		{
			throw new Exception();
		}
	}
}

