package scms.textfile.dao;

import java.util.List;

public interface DAO <T> extends AutoCloseable   
{
	boolean open(String nomeRecurso) throws Exception;

	void close() throws Exception;
	
	boolean insert(T objeto) throws Exception;
	
	boolean update(T objeto) throws Exception;
	
	boolean delete(T objeto) throws Exception;
	
	T get() throws Exception;
	
	int numberOfObjects() throws Exception;
	
	List<T> listaObjetos() throws Exception;	
}
