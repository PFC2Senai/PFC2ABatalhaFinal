package funcoes;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class BuscaCep {

//	public static void main(String[] args){
//		
//		try {
//			JAXBContext jc = JAXBContext.newInstance(Webservicecep.class);
//			
//		       Unmarshaller u = jc.createUnmarshaller();
//		       URL url = new URL( "http://cep.republicavirtual.com.br/web_cep.php?cep=11703240&formato=xml" );
//		       Webservicecep cep = (Webservicecep) u.unmarshal( url );
//		       
//		       System.out.println(cep);
//	
//			
//			
//		} catch (JAXBException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
	
	public static Webservicecep getEndereco(String cep) throws JAXBException, MalformedURLException{
		
		  JAXBContext jc = JAXBContext.newInstance(Webservicecep.class);
		
	       Unmarshaller u = jc.createUnmarshaller();
	       URL url = new URL( "http://cep.republicavirtual.com.br/web_cep.php?cep="+cep+"&formato=xml" );
	       Webservicecep wCep = (Webservicecep) u.unmarshal( url );
	       
	       return wCep;
		
	}

}
