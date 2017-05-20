package prArrayAsociativo;

import java.util.NoSuchElementException;

public class ArrayAsociativo {
	//Clases internas
	private class Nodo{
		private String clave;
		private String valor;
		private Nodo sig; //siguiente nodo
		
		public Nodo(String c, String v, Nodo s){
			clave = c;
			valor = v;
			sig = s;
		}
	}
	
	//Variables de instancia
	private Nodo primero;
	
	
	//Constructores
	public ArrayAsociativo(){
		primero = null;
	}
	
	public ArrayAsociativo(String[] claves, String[] valores){
		this();
		if (claves.length > 0){
			primero = new Nodo(claves[0], valores[0],null);
			for (int i = 1; i< claves.length; i++){
				Nodo nuevo = new Nodo(claves[i], valores[i],primero);
				primero = nuevo;
			}
		}
	}
	
	public int size(){
		int i=0;
		if(primero==null){
			return 0;
		}else{
			while(primero!=null){
				i++;
				primero=primero.sig;
			}
		}
		return i;
	}
	
	public String get(String clave){
		
		boolean encontrado=false;

		while(primero != null && !encontrado){
			if(primero.clave==clave){
				encontrado=true;
			}else{
				primero=primero.sig;
			}
		}
		if(encontrado){//encontrado
			return primero.valor;
		}
		else{
			throw new NoSuchElementException("No se encontro la clave");
		}
	}
	
	public void put(String clave, String valor){
		boolean duplicado=false;
		
		while(primero!=null && !duplicado){
			if(primero.clave==clave){
				duplicado=true;
			}else{
				primero=primero.sig;
			}
		}
		
		if(!duplicado){				//nueva entrada se mete al final
			Nodo nuevo=new Nodo(clave,valor,null);
			primero=nuevo;
			
		}else{
			primero.valor=valor;	//lo encontre duplicado
		}
	}
	
	public String getOrElse(String clave, String valorPorDefecto){
		boolean encontrado=false;
		
		while(primero!=null && !encontrado){
			if(primero.clave==clave){
				encontrado=true;
			}else{
				primero=primero.sig;
			}
		}
		if(encontrado){
			return primero.valor;
		}else{
			return valorPorDefecto;
		}
		
		
	}
	
	public boolean containsKey(String clave){
		
		boolean encontrado=false;
		while(primero!=null && !encontrado){
			if(primero.clave==clave){
				encontrado=true;
			}else{
				primero=primero.sig;
			}
		}
		return encontrado;
	}
	
	public boolean remove(String clave){
		boolean encontrado=false;
		Nodo anterior=null;
		while(primero!=null && !encontrado){
			anterior=primero;
			if(primero.clave==clave){
				encontrado=true;
			}
			primero=primero.sig;
		}
		
		if(encontrado){
			if(primero==null){
				anterior.sig=null;
			}else{
				anterior.sig=primero.sig;
			}
		}
		
		
		return encontrado;
	}
	
}