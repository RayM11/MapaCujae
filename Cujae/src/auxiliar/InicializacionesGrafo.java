package auxiliar;

import java.util.ArrayList;
import java.util.Iterator;

import logica.Cafeteria;
import logica.Facultad;
import logica.Lugar;
import logica.LugarDeInteres;
import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

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
				"Escalinata",		    //Nombre
				"Descripción",			//Descripción
				"");					//Anotaciones
		grafo.insertVertex(luI0116A);

		//2
		LugarDeInteres luI0119A = new LugarDeInteres(
				"luI0119A",				
				0.40, 18.10,					
				"Entrada ciclovía",		
				"Descripción",			
				"");					
		grafo.insertVertex(luI0119A);	

		//3
		Lugar lu0619A = new Lugar("lu0619A", 5.87, 18.05);
		grafo.insertVertex(lu0619A);

		//4
		Lugar lu0114A = new Lugar("lu0114A", 0.75, 13.50);
		grafo.insertVertex(lu0114A);

		//5
		LugarDeInteres luI0113A = new LugarDeInteres("lu0113A", 0.78, 12.50,
				"Parada", 
				"Descripción",
				"");
		grafo.insertVertex(luI0113A);

		//6
		LugarDeInteres luI0111A = new LugarDeInteres("lu0113A", 1.00, 10.60,
				"Entrada Parqueo", 
				"Descripción",
				"");
		grafo.insertVertex(luI0111A);

		//7
		LugarDeInteres luI0214A = new LugarDeInteres("lu0214A", 1.20, 13.60,
				"Entrada caseta", 
				"Descripción",
				"");
		grafo.insertVertex(luI0214A);

		//8
		Lugar lu0214B = new Lugar("lu0214B", 1.50, 13.60);
		grafo.insertVertex(lu0214B);

		//9
		Lugar lu0214C = new Lugar("lu0214C", 1.75, 13.25);
		grafo.insertVertex(lu0214C);

		//10
		Lugar lu0311A = new Lugar("lu0311A", 2.10, 10.58);
		grafo.insertVertex(lu0311A);

		//11
		Lugar lu0314B = new Lugar("lu0314B", 3.00, 13.63);
		grafo.insertVertex(lu0314B);

		//12
		Lugar lu0314C = new Lugar("lu0314C", 3.00, 13.25);
		grafo.insertVertex(lu0314C);

		//13
		LugarDeInteres luI0415B = new LugarDeInteres("luI0415B", 3.08, 14.20,
				"Pasillo de los Vientos (Entrada)", 
				"Descripción",
				"");
		grafo.insertVertex(luI0415B);

		//14
		Lugar lu0415D = new Lugar("lu0415D", 3.08, 14.05);
		grafo.insertVertex(lu0415D);

		//15
		Lugar lu0311B = new Lugar("lu0311B", 2.60, 10.57);
		grafo.insertVertex(lu0311B);

		//16
		LugarDeInteres luI0310A = new LugarDeInteres("luI0310A", 2.56, 9.80,
				"Cancha de tenis", 
				"Descripción",
				"");
		grafo.insertVertex(luI0310A);

		//17
		LugarDeInteres luI0310B = new LugarDeInteres("luI0310B", 2.52, 9.17,
				"Cancha de Volleybol",
				"Descripción",
				"");
		grafo.insertVertex(luI0310B);

		//18
		LugarDeInteres luI0210A = new LugarDeInteres("luI0210A", 1.63, 9.18,
				"Cancha de Fútbol Sala", 
				"Descripción",
				"");
		grafo.insertVertex(luI0210A);

		//19
		Lugar lu0411A = new Lugar("lu0411A", 3.45, 10.56);
		grafo.insertVertex(lu0411A);

		//20
		LugarDeInteres luI0410A = new LugarDeInteres("luI0410A", 3.45, 9.16,
				"Gradas", 
				"Descripción",
				"");
		grafo.insertVertex(luI0410A);

		//21
		LugarDeInteres luI0409A = new LugarDeInteres("luI0409A", 3.30, 8.35,
				"DEDER", 
				"Descripción",
				"");
		grafo.insertVertex(luI0409A);

		//22
		LugarDeInteres luI0309A = new LugarDeInteres("luI0309A", 2.35, 8.33,
				"DEDER", 
				"Descripción",
				"");
		grafo.insertVertex(luI0309A);

		//23
		Lugar lu0409B = new Lugar("lu0409B", 4.00, 8.35);
		grafo.insertVertex(lu0409B);

		//24
		LugarDeInteres luI0408A = new LugarDeInteres("luI0408A", 4.00, 7.80,
				"Terrenos de Baseball y Fútbol 11", 
				"Descripción",
				"");
		grafo.insertVertex(luI0408A);

		//25
		Lugar lu0511A = new Lugar("lu0511A", 4.60, 10.55);
		grafo.insertVertex(lu0511A);

		//26
		LugarDeInteres luI0510A = new LugarDeInteres("luI0510A", 4.55, 9.15,
				"Cancha de baloncesto", 
				"Descripción",
				"");
		grafo.insertVertex(luI0510A);

		//27
		Lugar lu0509A = new Lugar("lu0509A", 4.54, 8.34);
		grafo.insertVertex(lu0509A);

		//28
		Facultad luIF0314A = new Facultad("luIF0314A", 2.18, 13.615,
				"Facultad de Telecomunicaciones", 
				"Descripción",
				"",
				"Decano");
		grafo.insertVertex(luIF0314A);

		//29
		Facultad luIF0415C = new Facultad("luIF0415C", 3.23, 14.10,
				"Facultad de Automática y Biomédica", 
				"Descripción",
				"",
				"Decano");
		grafo.insertVertex(luIF0415C);

		//30
		LugarDeInteres luI0315C = new LugarDeInteres("luI0315C", 2.95, 14.10,
				"Pasillo del rectorado", 
				"Descripción (Contiene el rectorado, la secretaría general, el museo de la universidad, entre otros puntos de interés)",
				"");
		grafo.insertVertex(luI0315C);

		//31
		Lugar lu0415A = new Lugar("lu0415A", 3.05, 15.00);
		grafo.insertVertex(lu0415A);

		//32
		Lugar lu0416B = new Lugar("lu0416B", 3.05, 15.25);
		grafo.insertVertex(lu0416B);

		//33
		LugarDeInteres luI0416A = new LugarDeInteres("luI0416A", 3.05, 15.45,
				"Pecera", 
				"Descripción",
				"");
		grafo.insertVertex(luI0416A);

		//34
		Cafeteria luIC0416C = new Cafeteria("luIC0416C", 3.68, 15.24,
				"Cafetería \"El Hueco\"", 
				"Descripción",
				"",
				new ArrayList<String>());
		grafo.insertVertex(luIC0416C);

		//35
		Lugar lu0216A = new Lugar("lu0216A", 1.20, 15.45);
		grafo.insertVertex(lu0216A);

		//36
		Lugar lu0215A = new Lugar("lu0215A", 1.20, 15.00);
		grafo.insertVertex(lu0215A);

		//37
		Lugar lu0316B = new Lugar("lu0316B", 2.35, 15.45);
		grafo.insertVertex(lu0316B);

		//38
		Lugar lu0315A = new Lugar("lu0315A", 2.35, 15.00);
		grafo.insertVertex(lu0315A);

		//39
		LugarDeInteres luI0316A = new LugarDeInteres("luI0316A", 2.55, 16.00,
				"Parque Coulón", 
				"Descripción",
				"");
		grafo.insertVertex(luI0316A);

		//40
		Facultad luIF0317A = new Facultad("luIF0317A", 2.95, 16.60,
				"Facultad de Arquitectura", 
				"Descripción",
				"",
				"Decano");
		grafo.insertVertex(luIF0317A);

		//41
		Facultad luIF0316C = new Facultad("luIF0316C", 2.82, 15.45,
				"Facultad de Química", 
				"Descripción",
				"",
				"Decano");
		grafo.insertVertex(luIF0316C);

		//42
		Facultad luIF0315B = new Facultad("luIF0315B", 2.82, 15.00,
				"Facultad de Industrial", 
				"Descripción",
				"",
				"Decano");
		grafo.insertVertex(luIF0315B);

		//43
		Lugar lu0616A = new Lugar("lu0616A", 5.70, 15.55);
		grafo.insertVertex(lu0616A);

		//44
		Lugar lu0616B = new Lugar("lu0616B", 5.68, 15.20);
		grafo.insertVertex(lu0616B);

		//45
		Lugar lu0615A = new Lugar("lu0615A", 5.64, 14.20);
		grafo.insertVertex(lu0615A);

		//46
		Lugar lu0614A = new Lugar("lu0614A", 5.60, 13.15);
		grafo.insertVertex(lu0614A);

		//47
		Lugar lu0612B = new Lugar("lu0612B", 5.55, 11.80);
		grafo.insertVertex(lu0612B);

		//48
		Lugar lu0611A = new Lugar("lu0611A", 5.50, 10.54);
		grafo.insertVertex(lu0611A);

		//49
		Lugar lu0610A = new Lugar("lu0610A", 5.44, 9.14);
		grafo.insertVertex(lu0610A);

		//50
		LugarDeInteres luI0609A = new LugarDeInteres("luI0609A", 5.42, 8.60,
				"Piscina deportiva", 
				"Descripción",
				"");
		grafo.insertVertex(luI0609A);

		//51
		Facultad luIF0816C = new Facultad("luIF0816C", 7.55, 15.50,
				"Facultad de Mecánica", 
				"Descripción",
				"",
				"Decano");
		grafo.insertVertex(luIF0816C);

		//52
		Lugar lu0816D = new Lugar("lu0816D", 7.70, 15.49);
		grafo.insertVertex(lu0816D);

		//53
		Lugar lu0816B = new Lugar("lu0816B", 7.75, 15.70);
		grafo.insertVertex(lu0816B);

		//54
		Lugar lu0816A = new Lugar("lu0816A", 7.58, 15.75);
		grafo.insertVertex(lu0816A);

		//55
		Cafeteria luIC0817A = new Cafeteria("luIC0817A", 7.65, 17.00,
				"Cafetería de Mecánica", 
				"Descripción",
				"",
				new ArrayList<String>());
		grafo.insertVertex(luIC0817A);

		//56
		Facultad luIF0715A = new Facultad("luIF0715A", 6.20, 14.19,
				"Facultad de Informática (CEIS)", 
				"Descripción",
				"",
				"Decano");
		grafo.insertVertex(luIF0715A);

		//57
		LugarDeInteres luI0815A = new LugarDeInteres("luI0815A", 7.45, 14.17,
				"CEMAT", 
				"Descripción",
				"");
		grafo.insertVertex(luI0815A);

		//58
		Lugar lu0915C = new Lugar("lu0915C", 8.70, 14.15);
		grafo.insertVertex(lu0915C);

		//59
		LugarDeInteres luI0915B = new LugarDeInteres("luI0915B", 8.72, 14.35,
				"Observatorio", 
				"Descripción",
				"");
		grafo.insertVertex(luI0915B);

		//60
		LugarDeInteres luI0915A = new LugarDeInteres("luI0915A", 8.76, 15.00,
				"Teatro de Informática y Mecánica ???", 
				"Descripción",
				"");
		grafo.insertVertex(luI0915A);

		//61
		LugarDeInteres luI0916B = new LugarDeInteres("luI0916B", 8.78, 15.15,
				"Docente de Mecánica", 
				"Descripción",
				"");
		grafo.insertVertex(luI0916B);

		//62
		Lugar lu0916A = new Lugar("lu0916A", 8.80, 15.45);
		grafo.insertVertex(lu0916A);

		//63
		Lugar lu1016A = new Lugar("lu1016A", 9.35, 15.43);
		grafo.insertVertex(lu1016A);

		//64
		LugarDeInteres luI1016B = new LugarDeInteres("luI1016B", 9.33, 15.10,
				"Docente de Biomédica", 
				"Descripción",
				"");
		grafo.insertVertex(luI1016B);

		//65
		LugarDeInteres luI1017A = new LugarDeInteres("luI1017A", 9.38, 16.08,
				"Docente de Informática (Edificio 19)", 
				"Descripción",
				"");
		grafo.insertVertex(luI1017A);

		//66
		LugarDeInteres luI0612A = new LugarDeInteres("luI0612A", 6.00, 12.00,
				"Dojo de Judo y Cátedra de EF", 
				"Descripción",
				"");
		grafo.insertVertex(luI0612A);

		//67
		LugarDeInteres luI0712A = new LugarDeInteres("luI0712A", 6.40, 12.00,
				"Librería \"Nicolás Guillén\"", 
				"Descripción",
				"");
		grafo.insertVertex(luI0712A);

		//68
		LugarDeInteres luI0712B = new LugarDeInteres("luI0712B", 6.80, 12.00,
				"Almacén de libros (Entrega-Recogida) ???????", 
				"Descripción",
				"");
		grafo.insertVertex(luI0712B);

		//69
		LugarDeInteres luI0711A = new LugarDeInteres("luI0711A", 6.50, 10.53,
				"Citi", 
				"Descripción",
				"");
		grafo.insertVertex(luI0711A);

		//70
		Lugar lu0811A = new Lugar("lu0811A", 7.40, 10.52);
		grafo.insertVertex(lu0811A);

		//71
		Lugar lu0809A = new Lugar("lu0809A", 7.08, 8.58);
		grafo.insertVertex(lu0809A);

		//72
		LugarDeInteres luI0708A = new LugarDeInteres("luI0708A", 7.00, 7.70,
				"Ranchón", 
				"Descripción",
				"");
		grafo.insertVertex(luI0708A);

		//73
		LugarDeInteres luI0911A = new LugarDeInteres("luI0911A", 8.15, 10.51,
				"Comedor", 
				"Descripción",
				"");
		grafo.insertVertex(luI0911A);

		//74
		LugarDeInteres luI1111A = new LugarDeInteres("luI1111A", 10.30, 10.49,
				"Becas (Entrada que no se usa) ?????", 
				"Descripción",
				"");
		grafo.insertVertex(luI1111A);

		//75
		LugarDeInteres luI0911B = new LugarDeInteres("luI0911B", 8.90, 10.05,
				"Becas (Entrada del comedor)", 
				"Descripción",
				"");
		grafo.insertVertex(luI0911B);

		//76
		Lugar lu0909B = new Lugar("lu0909B", 9.00, 8.70);
		grafo.insertVertex(lu0909B);

		//77
		LugarDeInteres luI0909A = new LugarDeInteres("luI0909A", 8.50, 8.56,
				"Becas (Entrada detrás del Citi) ???????", 
				"Descripción",
				"");
		grafo.insertVertex(luI0909A);

		//78
		Lugar lu0906A = new Lugar("lu0906A", 8.35, 5.70);
		grafo.insertVertex(lu0906A);

		//79
		Lugar lu1006A = new Lugar("lu1006A", 9.15, 5.10);
		grafo.insertVertex(lu1006A);

		//80
		Cafeteria luIC1006B = new Cafeteria("luIC1006B", 9.70, 5.10,
				"Cafetería \"Beca Cujae\"", 
				"Descripción",
				"",
				new ArrayList<String>());
		grafo.insertVertex(luIC1006B);

		//81
		LugarDeInteres luI1105A = new LugarDeInteres("luI1105A", 10.50, 4.70,
				"Hospitalito de la Cujae  ??????", 
				"Descripción",
				"");
		grafo.insertVertex(luI1105A);

		//82
		Lugar lu1001A = new Lugar("lu1001A", 9.15, 0.25);
		grafo.insertVertex(lu1001A);

		//83
		Lugar lu1101A = new Lugar("lu1101A", 10.20, 0.25);
		grafo.insertVertex(lu1101A);

		//84
		Lugar lu1104A = new Lugar("lu1104A", 10.30, 3.65);
		grafo.insertVertex(lu1104A);

		//85
		Lugar lu1204A = new Lugar("lu1204A", 11.20, 3.65);
		grafo.insertVertex(lu1204A);

		//86
		Lugar lu1207A = new Lugar("lu1207A", 11.45, 6.90);
		grafo.insertVertex(lu1207A);

		//87
		Lugar lu1108A = new Lugar("lu1108A", 10.10, 7.50);
		grafo.insertVertex(lu1108A);





		return grafo;

	}

	public static void agregarCamino(ILinkedWeightedEdgeNotDirectedGraph mapa, Lugar lu1, Lugar lu2){

	mapa.insertWEdgeNDG(indexDeLugar(mapa,lu1),indexDeLugar(mapa,lu2), lu1.calcularDistanciaA(lu2));	

	}
	
	public static int indexDeLugar (ILinkedWeightedEdgeNotDirectedGraph mapa, Lugar lu){
		
		int index = -1;
		int cont = 0;
		Iterator<Vertex> iter = mapa.getVerticesList().iterator();
		
		while (iter.hasNext()){
			
			Lugar luActual = (Lugar) iter.next().getInfo();
			if (luActual.equals(lu))
				index = cont;
			else
				cont++;
		}
		
		return index;
	}
	

}
