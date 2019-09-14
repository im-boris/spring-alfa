package com.hakai.dragon.world.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class FamososSRV {

	
	
//    @Autowired
//    private FamososDAO famososSRV;
	
    
    public FamososMDL obtemObjetoFamosos () {
    	
    	String listaFamososJson = obtemListaFamososMock();
    	FamososMDL famosos = new FamososMDL();
    	
    	Gson gson = new Gson();  
    	PessoaMDL[] listaFamosos = gson.fromJson(listaFamososJson, PessoaMDL[].class); 
    	
    	famosos.setListaFamosos(obtemListaFamosos(listaFamosos));
    	
    	return famosos;

    }
    
   public FamososMDL obtemObjetoFamososSeparados (String sexo) {
    	
    	String listaFamososJson = obtemListaFamososMock();
    	FamososMDL famosos = new FamososMDL();
    	
    	Gson gson = new Gson();  
    	PessoaMDL[] listaFamosos = gson.fromJson(listaFamososJson, PessoaMDL[].class); 
    	
    	famosos.setListaFamosos(obtemListaFamososSeparados(listaFamosos, sexo));
    	
    	return famosos;

    }
    
    public List<PessoaMDL> obtemListaFamosos(PessoaMDL[] listaFamosos){
    
    	List<PessoaMDL> lista = new ArrayList<PessoaMDL>();
    	
    	for (int i = 0; i < listaFamosos.length; i++) {
    		String dataNova = trocaMascaraData(listaFamosos[i].getDataNasc());
    		listaFamosos[i].setDataNasc(dataNova); // Injetando data nova depois da formatação
    		lista.add(listaFamosos[i]);
		}
    	
    	return lista;
    	
    }
    
   
    public List<PessoaMDL> obtemListaFamososSeparados(PessoaMDL[] listaFamosos,String sexo){
        
    	List<PessoaMDL> lista = new ArrayList<PessoaMDL>();
    	
    	for (int i = 0; i < listaFamosos.length; i++) {
    		if (listaFamosos[i].getSexo().equalsIgnoreCase(sexo)) {
        		String dataNova = trocaMascaraData(listaFamosos[i].getDataNasc());
        		listaFamosos[i].setDataNasc(dataNova); // Injetando data nova depois da formatação
    			lista.add(listaFamosos[i]);				
			}
		}
    	
    	return lista;
    	
    }
    
	public String trocaMascaraData (String data) {
		
		String novoFormato = "";
		

		String mes[] = data.split(" ");
		String dia[] = data.split(",");
		String ano[] = data.split(",");
		String diaFinal[] = dia[0].split(" ");
		String diaFormatado = "";
		
		if (Integer.parseInt(diaFinal[1].replaceAll(" ", "")) < 10) {
			diaFormatado = "0"+diaFinal[1];
		}else {
			diaFormatado = ""+diaFinal[1];
		}
		
		novoFormato = obtemNumeroMes(mes[0])+"/"+diaFormatado+"/"+ano[1];
		
		return novoFormato.replaceAll(" ", "");
				
		
	}
	
	public String obtemNumeroMes(String mes) {
		
		if (mes.equalsIgnoreCase("January")) {
			return "01";
			
		} else if (mes.equalsIgnoreCase("February")) {
			return "02";
			
		} else if (mes.equalsIgnoreCase("March")) {
			return "03";
			
		} else if (mes.equalsIgnoreCase("April")) {
			return "04";
			
		} else if (mes.equalsIgnoreCase("May")) {
			return "05";
			
		} else if (mes.equalsIgnoreCase("June")) {
			return "06";
			
		} else if (mes.equalsIgnoreCase("July")) {
			return "07";
			
		} else if (mes.equalsIgnoreCase("August")) {
			return "08";
			
		} else if (mes.equalsIgnoreCase("September")) {
			return "09";
			
		} else if (mes.equalsIgnoreCase("October")) {
			return "10";
			
		} else if (mes.equalsIgnoreCase("November")) {
			return "11";
			
		} else if (mes.equalsIgnoreCase("December")) {
			return "12";
			
		}
		
		return null;
	}
    
    public String obtemListaFamososMock () {
    	
    	return "[\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Scarlett Johansson\",\r\n" + 
    			"      \"dataNasc\": \"November 22, 1984\",\r\n" + 
    			"      \"urlImagem\": \"https://amp.insider.com/images/5c8a8141dd08611286199063-750-56.jpg\",\r\n" + 
    			"      \"dica\": \"Viuva negra\",\r\n" + 
    			"      \"sexo\": \"f\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Robert Downey, Jr.\",\r\n" + 
    			"      \"dataNasc\": \"April 4, 1965\",\r\n" + 
    			"      \"urlImagem\": \"http://br.web.img2.acsta.net/pictures/18/06/29/00/35/0101925.jpg\",\r\n" + 
    			"      \"dica\": \"Homem de ferro\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Chris Evans\",\r\n" + 
    			"      \"dataNasc\": \"June 13, 1981\",\r\n" + 
    			"      \"urlImagem\": \"https://www.altfg.com/film/wp-content/uploads/images/2016/05/captain-america-civil-war-chris-evans.jpg\",\r\n" + 
    			"      \"dica\": \"Capitão america\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Chris Hemsworth\",\r\n" + 
    			"      \"dataNasc\": \"August 11, 1983\",\r\n" + 
    			"      \"urlImagem\": \"https://cdn.mamamia.com.au/wp/wp-content/uploads/2017/10/19170125/Thor-Ragnorok-Social-650x507.jpg\",\r\n" + 
    			"      \"dica\": \"Thor\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Jeremy Renner\",\r\n" + 
    			"      \"dataNasc\": \"January 7, 1971\",\r\n" + 
    			"      \"urlImagem\": \"https://media.wired.com/photos/5d7125ee9e087200080de8f1/master/pass/Culture_Monitor_Renner-972293712.jpg\",\r\n" + 
    			"      \"dica\": \"Gavião arqueiro\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Mark Ruffalo\",\r\n" + 
    			"      \"dataNasc\": \"November 22, 1967\",\r\n" + 
    			"      \"urlImagem\": \"https://upload.wikimedia.org/wikipedia/commons/1/11/Mark_Ruffalo_%2836201774756%29_%28cropped%29.jpg\",\r\n" + 
    			"      \"dica\": \"Hulk em os vingadores\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Tom Hiddleston\",\r\n" + 
    			"      \"dataNasc\": \"February 9, 1981\",\r\n" + 
    			"      \"urlImagem\": \"https://i.pinimg.com/736x/d4/c7/fe/d4c7fef4d58523e144b6282ac6fe7971.jpg\",\r\n" + 
    			"      \"dica\": \"Loki em os vingadores\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Samuel L. Jackson\",\r\n" + 
    			"      \"dataNasc\": \"December 21, 1948\",\r\n" + 
    			"      \"urlImagem\": \"https://cdn.britannica.com/77/191077-050-63262B99/Samuel-L-Jackson.jpg\",\r\n" + 
    			"      \"dica\": \"Nick Fury em os vingadores\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Paul Rudd\",\r\n" + 
    			"      \"dataNasc\": \"April 6, 1969\",\r\n" + 
    			"      \"urlImagem\": \"https://upload.wikimedia.org/wikipedia/commons/9/92/Paul_Rudd_%28cropped%29_2.jpg\",\r\n" + 
    			"      \"dica\": \"Homem-formiga\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Tom Holland\",\r\n" + 
    			"      \"dataNasc\": \"June 1, 1996\",\r\n" + 
    			"      \"urlImagem\": \"https://ewedit.files.wordpress.com/2018/06/tom-holland1.jpg?crop981px%2C103px%2C1010px%2C1010px&resize1200%2C1200\",\r\n" + 
    			"      \"dica\": \"Homem-aranha UCM\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Mariah Carey\",\r\n" + 
    			"      \"dataNasc\": \"March 27, 1970\",\r\n" + 
    			"      \"urlImagem\": \"\",\r\n" + 
    			"      \"dica\": \"Cantora\",\r\n" + 
    			"      \"sexo\": \"f\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Karen Gillan\",\r\n" + 
    			"      \"dataNasc\": \"November 28, 1987\",\r\n" + 
    			"      \"urlImagem\": \"https://gamespot1.cbsistatic.com/uploads/original/171/1712892/3360013-image.jpg\",\r\n" + 
    			"      \"dica\": \"Nebulosa em os vingadores\",\r\n" + 
    			"      \"sexo\": \"f\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Don Cheadle\",\r\n" + 
    			"      \"dataNasc\": \"November 29, 1964\",\r\n" + 
    			"      \"urlImagem\": \"https://cdn1.thr.com/sites/default/files/imagecache/scale_crop_768_433/2019/07/gettyimages-969551878_0.jpg\",\r\n" + 
    			"      \"dica\": \"War machine\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Josh Brolin\",\r\n" + 
    			"      \"dataNasc\": \"February 12, 1968\",\r\n" + 
    			"      \"urlImagem\": \"https://pmcvariety.files.wordpress.com/2019/02/josh-brolin.jpg?w1000\",\r\n" + 
    			"      \"dica\": \"Thanos e Cable\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Chris Pratt\",\r\n" + 
    			"      \"dataNasc\": \"June 21, 1979\",\r\n" + 
    			"      \"urlImagem\": \"https://upload.wikimedia.org/wikipedia/commons/d/d0/Chris_Pratt_%2828046276644%29_%28cropped%29.jpg\",\r\n" + 
    			"      \"dica\": \"Star Lord\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Anthony Mackie\",\r\n" + 
    			"      \"dataNasc\": \"September 23, 1978\",\r\n" + 
    			"      \"urlImagem\": \"https://www.indiewire.com/wp-content/uploads/2019/06/shutterstock_10216461ao.jpg\",\r\n" + 
    			"      \"dica\": \"Falcão em os vingadores\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Elizabeth Olsen\",\r\n" + 
    			"      \"dataNasc\": \"February 16, 1989\",\r\n" + 
    			"      \"urlImagem\": \"\",\r\n" + 
    			"      \"dica\": \"\",\r\n" + 
    			"      \"sexo\": \"f\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Benedict Cumberbatch\",\r\n" + 
    			"      \"dataNasc\": \"July 19, 1976\",\r\n" + 
    			"      \"urlImagem\": \"\",\r\n" + 
    			"      \"dica\": \"Doutor Estranho\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Sebastian Stan\",\r\n" + 
    			"      \"dataNasc\": \"August 13, 1982\",\r\n" + 
    			"      \"urlImagem\": \"\",\r\n" + 
    			"      \"dica\": \"Soldado Invernal\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Chadwick Aaron Boseman\",\r\n" + 
    			"      \"dataNasc\": \"November 29, 1977\",\r\n" + 
    			"      \"urlImagem\": \"\",\r\n" + 
    			"      \"dica\": \"Pantera Negra\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Dave Bautista\",\r\n" + 
    			"      \"dataNasc\": \"January 18, 1969\",\r\n" + 
    			"      \"urlImagem\": \"\",\r\n" + 
    			"      \"dica\": \"Drax\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Benedict Wong\",\r\n" + 
    			"      \"dataNasc\": \"June 3, 1971\",\r\n" + 
    			"      \"urlImagem\": \"\",\r\n" + 
    			"      \"dica\": \"Wong em doutor estranho\",\r\n" + 
    			"      \"sexo\": \"m\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"nome\": \"Letitia Wright\",\r\n" + 
    			"      \"dataNasc\": \"October 31, 1993\",\r\n" + 
    			"      \"urlImagem\": \"\",\r\n" + 
    			"      \"dica\": \"Shuri em pantera negra\",\r\n" + 
    			"      \"sexo\": \"f\"\r\n" + 
    			"    }\r\n" + 
    			"  ]";
    	 
    }
	
	
}
