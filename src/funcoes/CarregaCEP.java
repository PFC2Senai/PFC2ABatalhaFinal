package funcoes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Josy
 */
public class CarregaCEP {

    
//    public XmlCep buscaEnderecoCep(String nrCep,String format) {
//
//    XmlCep xmlCep = null;   
//
//    StringBuffer url= new StringBuffer();       
//    url.append("http://viacep.com.br/ws/");     
//    url.append(nrCep);
//    url.append("/"+format);     
//
//    HttpClient client = new DefaultHttpClient();            
//    HttpGet method = new HttpGet(url.toString());            
//    method.addHeader("User-Agent", USER_AGENT);
//
//    try {   
//
//        HttpResponse response = client.execute(method);
//        System.out.println("\nSending 'GET' request to URL : " + url.toString());           
//        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());  
//
//        HttpEntity entity = response.getEntity();
//        String resultado = EntityUtils.toString(entity,"UTF-8");            
//
//        System.out.println(resultado);
//
//         if(resultado!=null) {          
//             XStream stream = new XStream(new DomDriver());
//             stream.autodetectAnnotations(true);
//             stream.aliasSystemAttribute(null, "class");
//             stream.processAnnotations(XmlCep.class);   
//             xmlCep = (XmlCep) stream.fromXML(resultado);           
//           }
//
//    } catch (UnsupportedEncodingException e) {
//        e.printStackTrace();
//    } catch (ClientProtocolException e) {
//        e.printStackTrace();
//    } catch (IOException e) {
//        e.printStackTrace();        
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//
//    return xmlCep;
//}
//    
    
    
    
//    public String getEndereco(String CEP) throws IOException {
//
//        //***************************************************
//        try {
//
//            Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP)
//                    .timeout(120000)
//                    .get();
//            Elements urlPesquisa = doc.select("span[itemprop=streetAddress]");
//            for (Element urlEndereco : urlPesquisa) {
//                return urlEndereco.text();
//            }
//
//        } catch (SocketTimeoutException e) {
//
//        } catch (HttpStatusException w) {
//
//        }
//        return CEP;
//    }
//
//    public String getBairro(String CEP) throws IOException {
//
//        //***************************************************
//        try {
//
//            Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP)
//                    .timeout(120000)
//                    .get();
//            Elements urlPesquisa = doc.select("td:gt(1)");
//            for (Element urlBairro : urlPesquisa) {
//                return urlBairro.text();
//            }
//
//        } catch (SocketTimeoutException e) {
//
//        } catch (HttpStatusException w) {
//
//        }
//        return CEP;
//    }
//
//    public String getCidade(String CEP) throws IOException {
//
//        //***************************************************
//        try {
//
//            Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP)
//                    .timeout(120000)
//                    .get();
//            Elements urlPesquisa = doc.select("span[itemprop=addressLocality]");
//            for (Element urlCidade : urlPesquisa) {
//                return urlCidade.text();
//            }
//
//        } catch (SocketTimeoutException e) {
//
//        } catch (HttpStatusException w) {
//
//        }
//        return CEP;
//    }
//
//    public String getUF(String CEP) throws IOException {
//
//        //***************************************************
//        try {
//
//            Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP)
//                    .timeout(120000)
//                    .get();
//            Elements urlPesquisa = doc.select("span[itemprop=addressRegion]");
//            for (Element urlUF : urlPesquisa) {
//                return urlUF.text();
//            }
//
//        } catch (SocketTimeoutException e) {
//
//        } catch (HttpStatusException w) {
//
//        }
//        return CEP;
//    }
}
