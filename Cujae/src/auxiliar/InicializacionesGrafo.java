package auxiliar;

import logica.Cafeteria;
import logica.Facultad;
import logica.Lugar;
import logica.LugarDeInteres;
import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;

public class InicializacionesGrafo {	

	/*	FORMATO DE LOS IDENTIFICADORES
	 * 	
	 * 	lu - XX - YY - A
	 *	
	 *	lu: tipo de lugar (lu Lugar,  luI LugarDeInteres, luIF Facultad, luIC Cafetería)
	 * 
	 *	XX: cuadrante X en que se encuentra 
	 *	YY: cuadrante Y en que se encuentra
	 *
	 * 	A: la prioridad en caso de que hayan varios lugares en un mismo cuadrante
	 * 
	 * */


	public ILinkedWeightedEdgeNotDirectedGraph inicializarLugares(){

		ILinkedWeightedEdgeNotDirectedGraph grafo = new LinkedGraph();

		//1
		LugarDeInteres luI0116A = new LugarDeInteres(
				"luI0116A",				//Identificador
				0.50, 15.38,			//Coordenadas
				null,					//Foto frente
				null,					//Foto reverso
				"Escalinata",		    //Nombre
				"Descripción",			//Descripción
				"",						//Anotaciones
				null);					//Foto descripción
		grafo.insertVertex(luI0116A);

		//2
		LugarDeInteres luI0119A = new LugarDeInteres(
				"luI0119A",				
				0.40, 18.10,			
				null,					
				null,					
				"Entrada ciclovía",		
				"Descripción",			
				"",						
				null);					
		grafo.insertVertex(luI0119A);		

		//3
		Lugar lu0619A = new Lugar("lu0619A", 5.87, 18.05,
				null,
				null);
		grafo.insertVertex(lu0619A);

		//4
		Lugar lu0114A = new Lugar("lu0114A", 0.75, 13.50,
				null,
				null);
		grafo.insertVertex(lu0114A);

		//5
		LugarDeInteres luI0113A = new LugarDeInteres("lu0113A", 0.78, 12.50, 
				null, 
				null,
				"Parada", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0113A);

		//6
		LugarDeInteres luI0111A = new LugarDeInteres("lu0113A", 1.00, 10.60, 
				null, 
				null,
				"Entrada Parqueo", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0111A);

		//7
		LugarDeInteres luI0214A = new LugarDeInteres("lu0214A", 1.20, 13.60, 
				null, 
				null,
				"Entrada caseta", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0214A);

		//8
		Lugar lu0214B = new Lugar("lu0214B", 1.50, 13.60,
				null,
				null);
		grafo.insertVertex(lu0214B);

		//9
		Lugar lu0214C = new Lugar("lu0214C", 1.75, 13.25,
				null,
				null);
		grafo.insertVertex(lu0214C);

		//10
		Lugar lu0311A = new Lugar("lu0311A", 2.10, 10.58,
				null,
				null);
		grafo.insertVertex(lu0311A);

		//11
		Lugar lu0314B = new Lugar("lu0314B", 3.00, 13.63,
				null,
				null);
		grafo.insertVertex(lu0314B);

		//12
		Lugar lu0314C = new Lugar("lu0314C", 3.00, 13.25,
				null,
				null);
		grafo.insertVertex(lu0314C);

		//13
		LugarDeInteres luI0415B = new LugarDeInteres("luI0415B", 3.08, 14.20, 
				null, 
				null,
				"Pasillo de los Vientos (Entrada)", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0415B);

		//14
		Lugar lu0415D = new Lugar("lu0415D", 3.08, 14.05,
				null,
				null);
		grafo.insertVertex(lu0415D);

		//15
		Lugar lu0311B = new Lugar("lu0311B", 2.60, 10.57,
				null,
				null);
		grafo.insertVertex(lu0311B);

		//16
		LugarDeInteres luI0310A = new LugarDeInteres("luI0310A", 2.56, 9.80, 
				null, 
				null,
				"Cancha de tenis", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0310A);

		//17
		LugarDeInteres luI0310B = new LugarDeInteres("luI0310B", 2.52, 9.17,
				null,
				null,
				"Cancha de Volleybol",
				"Descripción",
				"", null);
		grafo.insertVertex(luI0310B);

		//18
		LugarDeInteres luI0210A = new LugarDeInteres("luI0210A", 1.63, 9.18, 
				null, 
				null,
				"Cancha de Fútbol Sala", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0210A);

		//19
		Lugar lu0411A = new Lugar("lu0411A", 3.45, 10.56,
				null,
				null);
		grafo.insertVertex(lu0411A);

		//20
		LugarDeInteres luI0410A = new LugarDeInteres("luI0410A", 3.45, 9.16, 
				null, 
				null,
				"Gradas", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0410A);

		//21
		LugarDeInteres luI0409A = new LugarDeInteres("luI0409A", 3.30, 8.35, 
				null, 
				null,
				"DEDER", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0409A);

		//22
		LugarDeInteres luI0309A = new LugarDeInteres("luI0309A", 2.35, 8.33, 
				null, 
				null,
				"DEDER", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0309A);

		//23
		Lugar lu0409B = new Lugar("lu0409B", 4.00, 8.35,
				null,
				null);
		grafo.insertVertex(lu0409B);

		//24
		LugarDeInteres luI0408A = new LugarDeInteres("luI0408A", 4.00, 7.80, 
				null, 
				null,
				"Terrenos de Baseball y Fútbol 11", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0408A);

		//25
		Lugar lu0511A = new Lugar("lu0511A", 4.60, 10.55,
				null,
				null);
		grafo.insertVertex(lu0511A);
		
		//26
		LugarDeInteres luI0510A = new LugarDeInteres("luI0510A", 4.55, 9.15, 
				null, 
				null,
				"Cancha de baloncesto", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0510A);
		
		//27
		Lugar lu0509A = new Lugar("lu0509A", 4.54, 8.34,
				null,
				null);
		grafo.insertVertex(lu0509A);
		
		//28
		Facultad luIF0314A = new Facultad("luIF0314A", 2.18, 13.615, 
				null, 
				null,
				"Facultad de Telecomunicaciones", 
				"Descripción",
				"", null,
				"Decano",
				"Vicedecano");
		grafo.insertVertex(luIF0314A);

		//29
		Facultad luIF0415C = new Facultad("luIF0415C", 3.23, 14.10, 
				null, 
				null,
				"Facultad de Automática y Biomédica", 
				"Descripción",
				"", null,
				"Decano",
				"Vicedecano");
		grafo.insertVertex(luIF0415C);
		
		//30
		LugarDeInteres luI0315C = new LugarDeInteres("luI0315C", 2.95, 14.10, 
				null, 
				null,
				"Pasillo del rectorado", 
				"Descripción (Contiene el rectorado, la secretaría general, el museo de la universidad, entre otros puntos de interés)",
				"", null);
		grafo.insertVertex(luI0315C);

		//31
		Lugar lu0415A = new Lugar("lu0415A", 3.05, 15.00,
				null,
				null);
		grafo.insertVertex(lu0415A);
		
		//32
		Lugar lu0416B = new Lugar("lu0416B", 3.05, 15.25,
				null,
				null);
		grafo.insertVertex(lu0416B);
		
		//33
		LugarDeInteres luI0416A = new LugarDeInteres("luI0416A", 3.05, 15.45, 
				null, 
				null,
				"Pecera", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0416A);

		//34
		Cafeteria luIC0416C = new Cafeteria("luIC0416C", 3.68, 15.24, 
				null, 
				null,
				"Cafetería \"El Hueco\"", 
				"Descripción",
				"", null,
				"Ofertas");
		grafo.insertVertex(luIC0416C);
		
		//35
		Lugar lu0216A = new Lugar("lu0216A", 1.20, 15.45,
				null,
				null);
		grafo.insertVertex(lu0216A);
		
		//36
		Lugar lu0215A = new Lugar("lu0215A", 1.20, 15.00,
				null,
				null);
		grafo.insertVertex(lu0215A);
		
		//37
		Lugar lu0316B = new Lugar("lu0316B", 2.35, 15.45,
				null,
				null);
		grafo.insertVertex(lu0316B);
		
		//38
		Lugar lu0315A = new Lugar("lu0315A", 2.35, 15.00,
				null,
				null);
		grafo.insertVertex(lu0315A);
		
		//39
		LugarDeInteres luI0316A = new LugarDeInteres("luI0316A", 2.55, 16.00, 
				null, 
				null,
				"Parque Coulón", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0316A);
		
		//40
		Facultad luIF0317A = new Facultad("luIF0317A", 2.95, 16.60, 
				null, 
				null,
				"Facultad de Arquitectura", 
				"Descripción",
				"", null,
				"Decano",
				"Vicedecano");
		grafo.insertVertex(luIF0317A);
		
		//41
		Facultad luIF0316C = new Facultad("luIF0316C", 2.82, 15.45, 
				null, 
				null,
				"Facultad de Química", 
				"Descripción",
				"", null,
				"Decano",
				"Vicedecano");
		grafo.insertVertex(luIF0316C);
		
		//42
		Facultad luIF0315B = new Facultad("luIF0315B", 2.82, 15.00, 
				null, 
				null,
				"Facultad de Industrial", 
				"Descripción",
				"", null,
				"Decano",
				"Vicedecano");
		grafo.insertVertex(luIF0315B);
		
		//43
		Lugar lu0616A = new Lugar("lu0616A", 5.70, 15.55,
				null,
				null);
		grafo.insertVertex(lu0616A);
		
		//44
		Lugar lu0616B = new Lugar("lu0616B", 5.68, 15.20,
				null,
				null);
		grafo.insertVertex(lu0616B);
		
		//45
		Lugar lu0615A = new Lugar("lu0615A", 5.64, 14.20,
				null,
				null);
		grafo.insertVertex(lu0615A);
		
		//46
		Lugar lu0614A = new Lugar("lu0614A", 5.60, 13.15,
				null,
				null);
		grafo.insertVertex(lu0614A);
		
		//47
		Lugar lu0612B = new Lugar("lu0612B", 5.55, 11.80,
				null,
				null);
		grafo.insertVertex(lu0612B);
		
		//48
		Lugar lu0611A = new Lugar("lu0611A", 5.50, 10.54,
				null,
				null);
		grafo.insertVertex(lu0611A);
		
		//49
		Lugar lu0610A = new Lugar("lu0610A", 5.44, 9.14,
				null,
				null);
		grafo.insertVertex(lu0610A);
		
		//50
		LugarDeInteres luI0609A = new LugarDeInteres("luI0609A", 5.42, 8.60, 
				null, 
				null,
				"Piscina deportiva", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0609A);
		
		//51
		Facultad luIF0816C = new Facultad("luIF0816C", 7.55, 15.50, 
				null, 
				null,
				"Facultad de Mecánica", 
				"Descripción",
				"", null,
				"Decano",
				"Vicedecano");
		grafo.insertVertex(luIF0816C);
		
		//52
		Lugar lu0816D = new Lugar("lu0816D", 7.70, 15.49,
				null,
				null);
		grafo.insertVertex(lu0816D);
		
		//53
		Lugar lu0816B = new Lugar("lu0816B", 7.75, 15.70,
				null,
				null);
		grafo.insertVertex(lu0816B);
		
		//54
		Lugar lu0816A = new Lugar("lu0816A", 7.58, 15.75,
				null,
				null);
		grafo.insertVertex(lu0816A);
		
		//55
		Cafeteria luIC0817A = new Cafeteria("luIC0817A", 7.65, 17.00, 
				null, 
				null,
				"Cafetería de Mecánica", 
				"Descripción",
				"", null,
				"Ofertas");
		grafo.insertVertex(luIC0817A);
		
		//56
		Facultad luIF0715A = new Facultad("luIF0715A", 6.20, 14.19, 
				null, 
				null,
				"Facultad de Informática (CEIS)", 
				"Descripción",
				"", null,
				"Decano",
				"Vicedecano");
		grafo.insertVertex(luIF0715A);
		
		//57
		LugarDeInteres luI0815A = new LugarDeInteres("luI0815A", 7.45, 14.17, 
				null, 
				null,
				"CEMAT", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0815A);
		
		//58
		Lugar lu0915C = new Lugar("lu0915C", 8.70, 14.15,
				null,
				null);
		grafo.insertVertex(lu0915C);
		
		//59
		LugarDeInteres luI0915B = new LugarDeInteres("luI0915B", 8.72, 14.35, 
				null, 
				null,
				"Observatorio", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0915B);
		
		//60
		LugarDeInteres luI0915A = new LugarDeInteres("luI0915A", 8.76, 15.00, 
				null, 
				null,
				"Teatro de Informática y Mecánica ???", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0915A);
		
		//61
		LugarDeInteres luI0916B = new LugarDeInteres("luI0916B", 8.78, 15.15, 
				null, 
				null,
				"Docente de Mecánica", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0916B);
		
		//62
		Lugar lu0916A = new Lugar("lu0916A", 8.80, 15.45,
				null,
				null);
		grafo.insertVertex(lu0916A);
		
		//63
		Lugar lu1016A = new Lugar("lu1016A", 9.35, 15.43 ,
				null,
				null);
		grafo.insertVertex(lu1016A);
		
		//64
		LugarDeInteres luI1016B = new LugarDeInteres("luI1016B", 9.33, 15.10, 
				null, 
				null,
				"Docente de Biomédica", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI1016B);
		
		//65
		LugarDeInteres luI1017A = new LugarDeInteres("luI1017A", 9.38, 16.08, 
				null, 
				null,
				"Docente de Informática (Edificio 19)", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI1017A);
		
		//66
		LugarDeInteres luI0612A = new LugarDeInteres("luI0612A", 6.00, 12.00, 
				null, 
				null,
				"Dojo de Judo y Cátedra de EF", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0612A);
		
		//67
		LugarDeInteres luI0712A = new LugarDeInteres("luI0712A", 6.40, 12.00, 
				null, 
				null,
				"Librería \"Nicolás Guillén\"", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0712A);
		
		//68
		LugarDeInteres luI0712B = new LugarDeInteres("luI0712B", 6.80, 12.00, 
				null, 
				null,
				"Almacén de libros (Entrega-Recogida) ???????", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0712B);
		
		//69
		LugarDeInteres luI0711A = new LugarDeInteres("luI0711A", 6.50, 10.53, 
				null, 
				null,
				"Citi", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0711A);
		
		//70
		Lugar lu0811A = new Lugar("lu0811A", 7.40, 10.52,
				null,
				null);
		grafo.insertVertex(lu0811A);
		
		//71
		Lugar lu0809A = new Lugar("lu0809A", 7.08, 8.58,
				null,
				null);
		grafo.insertVertex(lu0809A);
		
		//72
		LugarDeInteres luI0708A = new LugarDeInteres("luI0708A", 7.00, 7.70, 
				null, 
				null,
				"Ranchón", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0708A);
		
		//73
		LugarDeInteres luI0911A = new LugarDeInteres("luI0911A", 8.15, 10.51, 
				null, 
				null,
				"Comedor", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0911A);
		
		//74
		LugarDeInteres luI1111A = new LugarDeInteres("luI1111A", 10.30, 10.49, 
				null, 
				null,
				"Becas (Entrada que no se usa) ?????", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI1111A);
		
		//75
		LugarDeInteres luI0911B = new LugarDeInteres("luI0911B", 8.90, 10.05, 
				null, 
				null,
				"Becas (Entrada del comedor)", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0911B);
		
		//76
		Lugar lu0909B = new Lugar("lu0909B", 9.00, 8.70,
				null,
				null);
		grafo.insertVertex(lu0909B);
		
		//77
		LugarDeInteres luI0909A = new LugarDeInteres("luI0909A", 8.50, 8.56, 
				null, 
				null,
				"Becas (Entrada detrás del Citi) ???????", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI0909A);
		
		//78
		Lugar lu0906A = new Lugar("lu0906A", 8.35, 5.70,
				null,
				null);
		grafo.insertVertex(lu0906A);
		
		//79
		Lugar lu1006A = new Lugar("lu1006A", 9.15, 5.10,
				null,
				null);
		grafo.insertVertex(lu1006A);
		
		//80
		Cafeteria luIC1006B = new Cafeteria("luIC1006B", 9.70, 5.10, 
				null, 
				null,
				"Cafetería \"Beca Cujae\"", 
				"Descripción",
				"", null,
				"Ofertas");
		grafo.insertVertex(luIC1006B);
		
		//81
		LugarDeInteres luI1105A = new LugarDeInteres("luI1105A", 10.50, 4.70, 
				null, 
				null,
				"Hospitalito de la Cujae  ??????", 
				"Descripción",
				"", null);
		grafo.insertVertex(luI1105A);
		
		//82
		Lugar lu1001A = new Lugar("lu1001A", 9.15, 0.25,
				null,
				null);
		grafo.insertVertex(lu1001A);
		
		//83
		Lugar lu1101A = new Lugar("lu1101A", 10.20, 0.25,
				null,
				null);
		grafo.insertVertex(lu1101A);
		
		//84
		Lugar lu1104A = new Lugar("lu1104A", 10.30, 3.65,
				null,
				null);
		grafo.insertVertex(lu1104A);
		
		//85
		Lugar lu1204A = new Lugar("lu1204A", 11.20, 3.65,
				null,
				null);
		grafo.insertVertex(lu1204A);
		
		//86
		Lugar lu1207A = new Lugar("lu1207A", 11.45, 6.90,
				null,
				null);
		grafo.insertVertex(lu1207A);
		
		//87
		Lugar lu1108A = new Lugar("lu1108A", 10.10, 7.50,
				null,
				null);
		grafo.insertVertex(lu1108A);
		
		
		
		return grafo;

	}

}
