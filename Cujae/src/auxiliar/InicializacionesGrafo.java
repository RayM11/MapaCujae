package auxiliar;

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


	public static ILinkedWeightedEdgeNotDirectedGraph inicializarLugares(){

		ILinkedWeightedEdgeNotDirectedGraph grafo = new LinkedGraph();

		//1
		LugarDeInteres luI0116A = new LugarDeInteres(
				"luI0116A",				//Identificador
				0.50, 15.38,			//Coordenadas
				"Escalinata",		    //Nombre
				"Entrada principal de la CUJAE la cual en la cima de las escalinatas tiene "
				+ "una estatua en homenaje a José Antonio Echeverría",			//Descripción
				"");					//Anotaciones
		grafo.insertVertex(luI0116A);

		//2
		LugarDeInteres luI0119A = new LugarDeInteres("luI0119A", 0.40, 18.10,					
				"Entrada ciclovía",		
				"Entrada secundaria a la Universidad la cual está al costado de las gacetas de bicicletas",			
				"");					
		grafo.insertVertex(luI0119A);		

		//3
		Lugar lu0619A = new Lugar("lu0619A", 5.87, 18.05);
		grafo.insertVertex(lu0619A);

		//4
		Lugar lu0114A = new Lugar("lu0114A", 0.75, 13.50);
		grafo.insertVertex(lu0114A);

		//5
		LugarDeInteres luI0113A = new LugarDeInteres("luI0113A", 0.78, 12.50,
				"Parada", 
				"Parada donde se toman las rutas PC, A-35, A-70, A-77, P9, entre otras",
				"");
		grafo.insertVertex(luI0113A);

		//6
		Lugar lu0111A = new Lugar("lu0111A", 1.00, 10.60);
		grafo.insertVertex(lu0111A);

		//7
		LugarDeInteres luI0214A = new LugarDeInteres("luI0214A", 1.20, 13.60,
				"Entrada caseta", 
				"Entrada en los bajos de la Fcacultad de Telecomunicaciones donde hay unos cajeros automáticos donde "
				+ "se pueden extraer dinero siempre  cuando esten funcionando",
				"");
		grafo.insertVertex(luI0214A);

		//8
		Lugar lu0214B = new Lugar("lu0214B", 1.50, 13.60);
		grafo.insertVertex(lu0214B);

		//9
		Lugar lu0214C = new Lugar("lu0214C", 1.75, 13.25);
		grafo.insertVertex(lu0214C);

		//10
		LugarDeInteres luI0311A = new LugarDeInteres("luI0311A",  2.10, 10.58,
				"Entrada Parqueo", 
				"Entrada mas cercana a las canchas deportivas, por donde entran veiculos de servicios u otro",
				"");
		grafo.insertVertex(luI0311A);

		//11
		Lugar lu0314B = new Lugar("lu0314B", 3.00, 13.63);
		grafo.insertVertex(lu0314B);

		//12
		Lugar lu0314C = new Lugar("lu0314C", 3.00, 13.25);
		grafo.insertVertex(lu0314C);

		//13
		LugarDeInteres luI0415B = new LugarDeInteres("luI0415B", 3.08, 14.20,
				"Pasillo de los Vientos (Entrada)", 
				"Pasillo donde siempre corre una agradable brisa de la cual se puede degustar al tener turnos libres,"
				+ "ademas de que conecta el pasillo central a la calle que da a cara de la facultad de informática(CEIS)",
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
				"Cancha donde se practica tenis en la CUJAE",
				"");
		grafo.insertVertex(luI0310A);

		//17
		LugarDeInteres luI0310B = new LugarDeInteres("luI0310B", 2.52, 9.17,
				"Cancha de Volleybol",
				"Cancha donde se practica volleybol en la CUJAE",
				"");
		grafo.insertVertex(luI0310B);

		//18
		LugarDeInteres luI0210A = new LugarDeInteres("luI0210A", 1.63, 9.18,
				"Cancha de Fútbol Sala", 
				"Cancha donde se practica Fútbol Sala en la CUJAE",
				"");
		grafo.insertVertex(luI0210A);

		//19
		Lugar lu0411A = new Lugar("lu0411A", 3.45, 10.56);
		grafo.insertVertex(lu0411A);

		//20
		LugarDeInteres luI0410A = new LugarDeInteres("luI0410A", 3.45, 9.16,
				"Gradas", 
				"Estan ubicadas en las canchas de baloncesto donde se puede ver los partidos y animar a los jugadores",
				"");
		grafo.insertVertex(luI0410A);

		//21
		LugarDeInteres luI0409A = new LugarDeInteres("luI0409A", 3.30, 8.35,
				"DEDER", 
				"El Departamento de Educación Física Deportes y Recreación",
				"");
		grafo.insertVertex(luI0409A);

		//22
		LugarDeInteres luI0309A = new LugarDeInteres("luI0309A", 2.35, 8.33,
				"Ajedrez", 
				"Local donde se ppráctica ajedrez en la CUJAE",
				"");
		grafo.insertVertex(luI0309A);

		//23
		Lugar lu0409B = new Lugar("lu0409B", 4.00, 8.35);
		grafo.insertVertex(lu0409B);

		//24
		LugarDeInteres luI0408A = new LugarDeInteres("luI0408A", 4.00, 7.80,
				"Terrenos de Baseball y Fútbol 11", 
				"Terrenos donde se practica Baseball y Fútbol 11 en la CUJAE",
				"");
		grafo.insertVertex(luI0408A);

		//25
		Lugar lu0511A = new Lugar("lu0511A", 4.60, 10.55);
		grafo.insertVertex(lu0511A);

		//26
		LugarDeInteres luI0510A = new LugarDeInteres("luI0510A", 4.55, 9.15,
				"Cancha de baloncesto", 
				"Cancha donde se practica baloncesto en la CUJAE",
				"");
		grafo.insertVertex(luI0510A);

		//27
		Lugar lu0509A = new Lugar("lu0509A", 4.54, 8.34);
		grafo.insertVertex(lu0509A);

		//28
		Facultad luIF0314A = new Facultad("luIF0314A", 2.18, 13.615,
				"Facultade de Telecomunicaciones y Facultad de Automática y Biomédica", 
				"Edificio donde residen ambas facultades.\n"
				+ "La Facultad de Telecomunicacones se destaca por una alta vinculación con las entidades y en la busqueda de la mejoria de las "
				+ "redes asi como todas las comunicaciones vinculado con su principal promotor ETECSA en aras de  busacar que nuestros ingenieros "
				+ "sean los mejores\n"
				+ "La Facultad de Automática y Biomédica se destaca por una creciente producción científica, el liderazgo nacional y el reconocimiento "
				+ "internacional alcanzado por nuestros profesores. Además, el trabajo extensionista de la Cátedra de Ciencias para la "
				+ "Vida es baluarte de las actividades de prevención en salud y atención a los trabajadores de la Facultad y la Universidad.",
				"",
				"Telecomunicaciones: Dr.Pablo Montejo Valdés\n"
				+ "Automática y Biomédica: Adrián Rodríguez Ramos");
		grafo.insertVertex(luIF0314A);

		//29
		Facultad luIF0415C = new Facultad("luIF0415C", 3.23, 14.10,
				"Facultad de Civil", 
				"La Facultad se destaca por una creciente producción científica, el liderazgo nacional y el reconocimiento "
				+ "internacional alcanzado por nuestros profesores. Además, esta Facultad hace profesionales de la Ingeniería Civil "
				+ "y especialistas vinculados al sector de la construcción "
				+ "los cuales contribuyen enormemente a el desarrollo de nuestro pais asi como de nuestra infraestructura",
				"",
				"Odalys Álvarez Rodríguez");
		grafo.insertVertex(luIF0415C);

		//30
		LugarDeInteres luI0315C = new LugarDeInteres("luI0315C", 2.95, 14.10,
				"Pasillo del rectorado", 
				"Contiene el rectorado, la secretaría general, el museo de la universidad, entre otros puntos de interés",
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
				"lugar donde se hacen exposiciones, entrevistas y otra actividades extracurriculares",
				"");
		grafo.insertVertex(luI0416A);

		//34
		Cafeteria luIC0416C = new Cafeteria("luIC0416C", 3.68, 15.24,
				"Cafetería \"El Hueco\"", 
				"Recientemente remodelada y dirigidapor personal ajeno a la universidad que consta con una gran variedad"
				+ " de ofertas muy buenas para los universitarios",
				"");
		luIC0416C.anadirProducto("Cafe");
		luIC0416C.anadirProducto("Pizza");
		luIC0416C.anadirProducto("Sandiwch");
		luIC0416C.anadirProducto("Bisutería");
		luIC0416C.anadirProducto("Refresco");
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
				"Parque Ampere",  
				"Llamado parque Ampere vulgarmente entre los estudiantes y profesores porque se dice que pasa por delante"
				+ "de ti un Coulón por segundo",
				"");
		grafo.insertVertex(luI0316A);

		//40
		Facultad luIF0317A = new Facultad("luIF0317A", 2.95, 16.60,
				"Facultad de Arquitectura", 
				"La Facultad se destaca por una alta vinculación con las entidades y los territorios en la búsqueda de"
				+ " soluciones para el mejoramiento del hábitat en nuestras ciudades, el liderazgo nacional y el reconocimiento "
				+ "internacional alcanzado por nuestros profesores y estudiantes.",
				"",
				"Dr.Ruslan Muñoz Hernández");
		grafo.insertVertex(luIF0317A);

		//41
		Facultad luIF0316C = new Facultad("luIF0316C", 2.82, 15.45,
				"Facultad de Química", 
				"La Facultad de Ingeniería Química es una institución joven, dinámica, pujante y aún en crecimiento, "
				+ "comprometida socialmente con una sólida formación de pre- y posgrado, en el desarrollo de proyectos de "
				+ "investigación científico-tecnológica e innovación y mejora de procesos, orientados al desarrollo industrial con "
				+ "la consiguiente protección al medioambiente.",
				"",
				"Lianys Ortega Viera");
		grafo.insertVertex(luIF0316C);

		//42
		Facultad luIF0315B = new Facultad("luIF0315B", 2.82, 15.00,
				"Facultad de Industrial", 
				"La Facultad de Ingeniería Industrial es una institucion donde los se destaca por una creciente producción "
				+ "científica, el liderazgo nacional y el reconocimiento internacional alcanzado por sus profesores, permitiendo el desarrollo constaste de los estudiantes"
				+ "y su preparación. Es conocida despreciativamente por otras facultades como \"La optativa\"",
				"",
				"Dr.Yuniel Bolaño Rodríguez");
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
				"En este momento esta en estado de averia, esperando para su reparación",
				"");
		grafo.insertVertex(luI0609A);

		//51
		Facultad luIF0816C = new Facultad("luIF0816C", 7.55, 15.50,
				"Facultad de Mecánica", 
				"En esta facultad se crean es un profesionales con conocimientos, habilidades y valores, que le permiten "
				+ "poner al servicio de la humanidad y en particular de la sociedad cubana, el desarrollo de la ciencia y la tecnología "
				+ "vinculadas a la carrera, con racionalidad económica, adecuado uso de los recursos humanos y materiales, minimizando el "
				+ "consumo a la naturaleza, el deterioro del medioambiente y preservando los principios éticos de su sociedad. El ingeniero "
				+ "mecánico es el profesional encargado de garantizar la explotación de las máquinas, equipos e instalaciones mecánicas "
				+ "durante su ciclo vital.",
				"",
				"Dr. Deny Oliva Merencio");
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
				"Esta cafetería esta cerrada hasta nuevo aviso, la cual se encuentra en los bajos de la Facultad de Mecánica",
				"");
		grafo.insertVertex(luIC0817A);

		//56
		Facultad luIF0715A = new Facultad("luIF0715A", 6.20, 14.19,
				"Facultad de Informática (CEIS)", 
				"En esta facultad se prepara profesionales integrales comprometidos con la Revolución, cuya función es desarrollar "
				+ "los procesos relacionados con las soluciones y sistemas informáticos en las organizaciones, y así obtener un incremento en la "
				+ "eficacia y la eficiencia de estas mediante el uso de técnicas que permiten analizar el entorno para delimitar los procesos "
				+ "computacionales, la información a procesar y las interrelaciones correspondientes, así como la gestión de proyectos informáticos con "
				+ "profesionalidad.",
				"",
				"Raisa Socorro Llanes");
		grafo.insertVertex(luIF0715A);

		//57
		LugarDeInteres luI0815A = new LugarDeInteres("luI0815A", 7.45, 14.17,
				"CEMAT", 
				"Centro de Estudios de Matemática para las Ciencias Técnicas es un centro de formación de pre- y posgrado en Matemática "
				+ "para Ingeniería y Arquitectura, basado en un fuerte trabajo metodológico, con actividad científico-técnica dirigida a la enseñanza y "
				+ "el aprendizaje de la Matemática y la modelación de problemas en ingeniería, que contribuye al desarrollo sostenible de la sociedad cubana "
				+ "revolucionaria.",
				"");
		grafo.insertVertex(luI0815A);

		//58
		Lugar lu0915C = new Lugar("lu0915C", 8.70, 14.15);
		grafo.insertVertex(lu0915C);

		//59
		LugarDeInteres luI0915B = new LugarDeInteres("luI0915B", 8.72, 14.35,
				"Observatorio", 
				"Lugar donde trabaja parte del profesorado haciendo investigaciones, principalmente de la Facultad de Informática",
				"");
		grafo.insertVertex(luI0915B);

		//60
		LugarDeInteres luI0915A = new LugarDeInteres("luI0915A", 8.76, 15.00,
				"Teatro de Informática y Mecánica", 
				"Lugar de reunión, realizacion de actuvidades y donde se imparten algunas clases que lo requieran",
				"");
		grafo.insertVertex(luI0915A);

		//61
		LugarDeInteres luI0916B = new LugarDeInteres("luI0916B", 8.78, 15.15,
				"Docente de Mecánica", 
				"Donde se imparten las clases y otras atividades docentes de la carrera",
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
				"Donde se imparten las clases y otras atividades docentes de la carrera",
				"");
		grafo.insertVertex(luI1016B);

		//65
		LugarDeInteres luI1017A = new LugarDeInteres("luI1017A", 9.38, 16.08,
				"Docente de Informática (Edificio 19)", 
				"Donde se imparten las clases y otras atividades docentes de la carrera",
				"");
		grafo.insertVertex(luI1017A);

		//66
		LugarDeInteres luI0612A = new LugarDeInteres("luI0612A", 6.00, 12.00,
				"Dojo de Judo y Cátedra de Educación Física", 
				"Lugar donde se entrena y se hacen competiciones de Judo, lucha y otros deportes de combate",
				"");
		grafo.insertVertex(luI0612A);

		//67
		LugarDeInteres luI0712A = new LugarDeInteres("luI0712A", 6.40, 12.00,
				"Librería \"Nicolás Guillén\"", 
				"Donde puedes comprar cualquier libro relacionado con la carrera y muchos otros mas",
				"");
		grafo.insertVertex(luI0712A);

		//68
		LugarDeInteres luI0712B = new LugarDeInteres("luI0712B", 6.80, 12.00,
				"Almacén de libros (Entrega\\Recogida)", 
				"Lugar donde cada semestre de recogen o se entregan los libros de las respectivas asignaturas "
				+ "que tocan en ese momento",
				"");
		grafo.insertVertex(luI0712B);

		//69
		LugarDeInteres luI0711A = new LugarDeInteres("luI0711A", 6.50, 10.53,
				"Citi", 
				"Es el Complejo de Investigaciones Tecnológicas Integradas donde se investiga la Seguridad tecnológica, "
				+ "Informática aplicada, Electrónica, Automática, Telecomunicaciones, Gestión de procesos de negocios, entre otros.",
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
				"Lugar de recreación de los estudiantes, utilizado mayormente por los estudiantes becados.",
				"");
		grafo.insertVertex(luI0708A);

		//73
		LugarDeInteres luI0911A = new LugarDeInteres("luI0911A", 8.15, 10.51,
				"Comedor", 
				"Lugar donde almuerzan y comen los estudiantes becados en la CUJAE asi como trabajadores",
				"");
		grafo.insertVertex(luI0911A);

		//74
		LugarDeInteres luI1111A = new LugarDeInteres("luI1111A", 10.30, 10.49,
				"Becas (Acceso al Hospitalito)", 
				"acceso menos usado por los transeúntes por su lejanía a las facultades, esta conecta la calle principal+"
				+ " con el Hospitalito haciendo que sea rápida la respuesta en caso de algún tipo de accidente",
				"");
		grafo.insertVertex(luI1111A);

		//75
		LugarDeInteres luI0911B = new LugarDeInteres("luI0911B", 8.90, 10.05,
				"Becas (Acceso desde el comedor)", 
				"Es la más utilizada por los estudiantes debido a su cercanía al comedor y a su rápido acceso a la juguera."
				+ "Desde ella se accede directamente a los edificios",
				"");
		grafo.insertVertex(luI0911B);

		//76
		Lugar lu0909B = new Lugar("lu0909B", 9.00, 8.70);
		grafo.insertVertex(lu0909B);

		//77
		LugarDeInteres luI0909A = new LugarDeInteres("luI0909A", 8.50, 8.56,
				"Becas (acceso desde el área deportiva)", 
				"acceso a las becas desde las zonas deportivas, ubicado próximo al Citi, utilizada mayormente por los usuarios"
				+ " que quieran acceder a la juguera desde las canchas",
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
				"Cafetería \"La Juguera\"", 
				"Cafetería cercana a las becas donde trabaja personal particular y sus ofertas son orientadas a los universitarios",
				"");
		luIC1006B.anadirProducto("Helado");
		luIC1006B.anadirProducto("Chucherías");
		luIC1006B.anadirProducto("Galletas");
		luIC1006B.anadirProducto("Maní");
		luIC1006B.anadirProducto("Refresco");
		luIC1006B.anadirProducto("Jugo");
		grafo.insertVertex(luIC1006B);

		//81
		LugarDeInteres luI1105A = new LugarDeInteres("luI1105A", 10.50, 4.70,
				"Hospitalito de la Cujae", 
				"Zona médica destina a atender cualquier emergencia o necesidad médica de los estudiante y profesores",
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



		
		//---------------------------------- ARISTAS --------------------------------

		// 1 y 2
		agregarCamino(grafo, luI0116A ,luI0119A );
		
		// 2 y 3
		agregarCamino(grafo, luI0119A, lu0619A);
		
		// 1 y 4
		agregarCamino(grafo, luI0116A, lu0114A);
		
		// 4 y 5
		agregarCamino(grafo, lu0114A, luI0113A);
		
		// 4 y 7
		agregarCamino(grafo, lu0114A, luI0214A);
		
		// 5 y 7
		agregarCamino(grafo, luI0113A, luI0214A);
		
		// 5 y 6
		agregarCamino(grafo, luI0113A, lu0111A);
		
		// 7 y 8
		agregarCamino(grafo, luI0214A, lu0214B);
		
		// 8 y 9
		agregarCamino(grafo, lu0214B, lu0214C);
		
		// 9 y 10
		agregarCamino(grafo, lu0214C, luI0311A);
		
		// 10 y 6
		agregarCamino(grafo, luI0311A, lu0111A);
		
		// 8 y 28
		agregarCamino(grafo, lu0214B, luIF0314A);
		
		// 28 y 11
		agregarCamino(grafo, luIF0314A, lu0314B);
		
		// 9 y 12
		agregarCamino(grafo, lu0214C, lu0314C);
		
		// 11 y 12
		agregarCamino(grafo, lu0314B, lu0314C);
		
		// 11 y 14
		agregarCamino(grafo, lu0314B, lu0415D);
		
		// 14 y 29
		agregarCamino(grafo, lu0415D, luIF0415C);
		
		// 29 y 30
		agregarCamino(grafo, luIF0415C, luI0315C);
		
		// 13 y 14
		agregarCamino(grafo, luI0415B, lu0415D);
		
		// 10 Y 15
		agregarCamino(grafo, luI0311A, lu0311B);
		
		// 15 y 16
		agregarCamino(grafo, lu0311B, luI0310A);
		
		// 16 y 17
		agregarCamino(grafo, luI0310A, luI0310B);
		
		// 17 y 18
		agregarCamino(grafo, luI0310B, luI0210A);
		
		// 15 y 19
		agregarCamino(grafo, lu0311B, lu0411A);
		
		// 19 y 20
		agregarCamino(grafo, lu0411A, luI0410A);
		
		// 17 y 20
		agregarCamino(grafo, luI0310B, luI0410A);
		
		// 20 y 21
		agregarCamino(grafo, luI0410A, luI0409A);
		
		// 21 y 22
		agregarCamino(grafo, luI0409A, luI0309A);
		
		// 21 y 23
		agregarCamino(grafo, luI0409A, lu0409B);
		
		// 23 y 24
		agregarCamino(grafo, lu0409B, luI0408A);
		
		// 19 y 25
		agregarCamino(grafo, lu0411A, lu0511A);
		
		// 25 y 26 
		agregarCamino(grafo, lu0511A, luI0510A);
		
		// 20 y 26
		agregarCamino(grafo, luI0410A, luI0510A);
		
		// 26 y 27
		agregarCamino(grafo, luI0510A, lu0509A);
		
		// 23 y 27 
		agregarCamino(grafo, lu0409B, lu0509A);
		
		// 25 y 48
		agregarCamino(grafo, lu0511A, lu0611A);
		
		// 26 y 49
		agregarCamino(grafo, luI0510A, lu0610A);
		
		// 27 y 50
		agregarCamino(grafo, lu0509A, luI0609A);
		
		// 48 y 49
		agregarCamino(grafo, lu0611A, lu0610A);
		
		// 49 y 50
		agregarCamino(grafo, lu0610A, luI0609A);
		
		// 13 y 31
		agregarCamino(grafo, luI0415B, lu0415A);
		
		// 31 y 32
		agregarCamino(grafo, lu0415A, lu0416B);
		
		// 32 y 33
		agregarCamino(grafo, lu0416B, luI0416A);
		
		// 32 y 34
		agregarCamino(grafo, lu0416B, luIC0416C);
		
		// 1 y 35
		agregarCamino(grafo, luI0116A, lu0216A);
		
		// 35 y 36
		agregarCamino(grafo, lu0216A, lu0215A);
		
		// 35 y 37
		agregarCamino(grafo, lu0216A, lu0316B);
		
		// 8 y 37
		agregarCamino(grafo, lu0214B, lu0316B);
		
		// 36 y 38
		agregarCamino(grafo, lu0215A, lu0315A);
		
		// 37 y 38
		agregarCamino(grafo, lu0316B, lu0315A);
		
		// 37 y 39
		agregarCamino(grafo, lu0316B, luI0316A);
		
		// 39 y 40
		agregarCamino(grafo, luI0316A, luIF0317A);
		
		// 37 y 41
		agregarCamino(grafo, lu0316B, luIF0316C);
		
		// 38 y 42
		agregarCamino(grafo, lu0315A, luIF0315B);
		
		// 33 y 41 
		agregarCamino(grafo, luI0416A, luIF0316C);
		
		// 31 y 42
		agregarCamino(grafo, lu0415A, luIF0315B);
		
		// 3 y 43
		agregarCamino(grafo, lu0619A, lu0616A);
		
		// 43 y 44
		agregarCamino(grafo, lu0616A, lu0616B);
		
		// 34 y 44
		agregarCamino(grafo, luIC0416C, lu0616B);
		
		// 44 y 45
		agregarCamino(grafo, lu0616B, lu0615A);
		
		// 13 y 45
		agregarCamino(grafo, luI0415B, lu0615A);
		
		// 45 y 46
		agregarCamino(grafo, lu0615A, lu0614A);
		
		// 12 y 46
		agregarCamino(grafo, lu0314C, lu0614A);
		
		// 46 y 47
		agregarCamino(grafo, lu0614A, lu0612B);
		
		// 47 y 48
		agregarCamino(grafo, lu0612B, lu0611A);
		
		// 43 y 51
		agregarCamino(grafo, lu0616A, luIF0816C);
		
		// 51 y 52
		agregarCamino(grafo, luIF0816C, lu0816D);
		
		// 52 y 53
		agregarCamino(grafo, lu0816D, lu0816B);
		
		// 53 y 54
		agregarCamino(grafo, lu0816B, lu0816A);
		
		// 54 y 55
		agregarCamino(grafo, lu0816A, luIC0817A);
		
		// 45 y 56
		agregarCamino(grafo, lu0615A, luIF0715A);
		
		// 56 y 57
		agregarCamino(grafo, luIF0715A, luI0815A);
		
		// 57 y 58
		agregarCamino(grafo, luI0815A, lu0915C);
		
		// 58 y 59
		agregarCamino(grafo, lu0915C, luI0915B);
		
		// 59 y 60
		agregarCamino(grafo, luI0915B, luI0915A);
		
		// 60 y 61
		agregarCamino(grafo, luI0915A, luI0916B);
		
		// 61 y 62
		agregarCamino(grafo, luI0916B, lu0916A);
		
		// 52 y 62
		agregarCamino(grafo, lu0816D, lu0916A);
		
		// 62 y 63
		agregarCamino(grafo, lu0916A, lu1016A);
		
		// 63 y 64
		agregarCamino(grafo, lu1016A, luI1016B);
		
		// 63 y 65
		agregarCamino(grafo, lu1016A, luI1017A);
		
		// 47 y 66
		agregarCamino(grafo, lu0612B, luI0612A);
		
		// 66 y 67
		agregarCamino(grafo, luI0612A, luI0712A);
		
		// 67 y 68
		agregarCamino(grafo, luI0712A, luI0712B);
		
		// 68 y 69
		agregarCamino(grafo, luI0712B, luI0711A);
		
		// 48 y 69
		agregarCamino(grafo, lu0611A, luI0711A);
		
		// 69 y 70
		agregarCamino(grafo, luI0711A, lu0811A);
		
		// 70 y 71 
		agregarCamino(grafo, lu0811A, lu0809A);
		
		// 71 y 72
		agregarCamino(grafo, lu0809A, luI0708A);
		
		// 50 y 71
		agregarCamino(grafo, luI0609A, lu0809A);
		
		// 70 y 73
		agregarCamino(grafo, lu0811A, luI0911A);
		
		// 73 y 74 
		agregarCamino(grafo, luI0911A, luI1111A);
		
		// 73 y 75
		agregarCamino(grafo, luI0911A, luI0911B);
		
		// 75 y 76
		agregarCamino(grafo, luI0911B, lu0909B);
		
		// 71 y 77
		agregarCamino(grafo, lu0809A, luI0909A);
		
		// 76 y 77
		agregarCamino(grafo, lu0909B, luI0909A);
		
		// 77 y 78
		agregarCamino(grafo, luI0909A, lu0906A);
		
		// 78 y 79
		agregarCamino(grafo, lu0906A, lu1006A);
		
		// 79 y 80
		agregarCamino(grafo, lu0906A, luIC1006B);
		
		// 80 y 81
		agregarCamino(grafo, luIC1006B, luI1105A);
		
		// 79 y 82
		agregarCamino(grafo, lu0906A, lu1001A);
		
		// 82 y 83
		agregarCamino(grafo, lu1001A, lu1101A);
		
		// 83 y 84
		agregarCamino(grafo, lu1101A, lu1104A);
		
		// 81 y 84
		agregarCamino(grafo, luI1105A, lu1104A);
		
		// 84 y 85
		agregarCamino(grafo, lu1104A, lu1204A);
		
		// 85 y 86
		agregarCamino(grafo, lu1204A, lu1207A);
		
		// 86 y 87
		agregarCamino(grafo, lu1207A, lu1108A);
		
		// 74 y 87 
		agregarCamino(grafo, luI1111A, lu1108A);
		
		// 80 y 87
		agregarCamino(grafo, luIC1006B, lu1108A);
		
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
