package com.example.appet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_registro1.*

class Registro1Activity : AppCompatActivity() , AdapterView.OnItemSelectedListener{

    private var spinner: Spinner? = null //creamos una variable para el Spinner
    private var arrayAdapter:ArrayAdapter<String> ? = null //Creamos un ArrayAdapter, se utiliza a la hora de pasar el arreglo al Spinner
    private var result:TextView ? = null //Esta variable debe ser eliminada, solo se utiliza para mostrar que si se esta seleccionando el departamento
    private lateinit var departamento: String //En esta variable se almacenara mas adelante, el departamento seleccionado por el usuario
    private lateinit var ciudad: String //Esta variable se utiliza para almacenar el valor de la ciudad seleccionada por el usuario

    private val itemList = arrayDep() //Creamos el Array de departamentos de Colombia y lo guardamos en la constante itemList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro1)
        departamento = "Seleccionar Departamento";
        ciudad = "Seleccione"
        spinnerCiudadMunicipio.setVisibility(View.INVISIBLE)
        spinner = findViewById(R.id.spinnerDepto) //Accedemos al Spinner que hicimos en el archivo xml con la ayuda de su id
        result = findViewById(R.id.resultText)//Esta linea debe ser eliminada, solo se utiliza para mostrar que si se esta seleccionando el departamento
        arrayAdapter =ArrayAdapter(applicationContext , android.R.layout.simple_spinner_item , itemList) //se llama el array que ya creamos y se adapta
        spinner?.adapter = arrayAdapter //Se envia el array que ya hemos adatado al spinner
        spinner?.onItemSelectedListener = this //Se define el spinner


/*
        spinner = findViewById(R.id.spinnerCiudadMunicipio) //Accedemos al Spinner que hicimos en el archivo xml con la ayuda de su id
        result = findViewById(R.id.resultText)//Esta linea debe ser eliminada, solo se utiliza para mostrar que si se esta seleccionando el departamento
        arrayAdapter =ArrayAdapter(applicationContext , android.R.layout.simple_spinner_item , arrayCity("Cundinamarca")) //se llama el array que ya creamos y se adapta
        spinner?.adapter = arrayAdapter //Se envia el array que ya hemos adatado al spinner
        spinner?.onItemSelectedListener = this //Se define el spinner
        */




        buttonNext.setOnClickListener {

            //Llamamos la actividad Registro 2
            showRegistro2(departamento)
            //val textooculto = findViewById(R.id.ciudadMunicipioText)

           /* TextView view = (TextView) findViewById(R.id.textView);
            view.setText("Add your text here");
            view.setVisibility(View.VISIBLE);*/
        }


    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(applicationContext,"Nothing Selected", Toast.LENGTH_LONG).show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if(parent==spinnerDepto) {
            departamento = parent?.getItemAtPosition(position) as String
            result?.text = departamento//jhj
            if (departamento != "Seleccionar Departamento") {
                spinnerCiudadMunicipio.visibility=View.VISIBLE
                ciudadMunicipioText.visibility=View.VISIBLE
            } else {
                spinnerCiudadMunicipio.visibility = View.INVISIBLE
                ciudadMunicipioText.visibility= View.INVISIBLE
            }

            spinner = findViewById(R.id.spinnerCiudadMunicipio) //Accedemos al Spinner que hicimos en el archivo xml con la ayuda de su id
            result = findViewById(R.id.resultText)//Esta linea debe ser eliminada, solo se utiliza para mostrar que si se esta seleccionando el departamento
            arrayAdapter =ArrayAdapter(applicationContext , android.R.layout.simple_spinner_item , arrayCity(departamento)) //se llama el array que ya creamos y se adapta
            spinner?.adapter = arrayAdapter //Se envia el array que ya hemos adatado al spinner
            spinner?.onItemSelectedListener = this //Se define el spinner
        }

        else{
            ciudad = parent?.getItemAtPosition(position) as String
        }

        println("La ciudad es: " + ciudad + " El depto es:" + departamento)


        //Toast.makeText(applicationContext , "$items", Toast.LENGTH_LONG).show()
    }

    //Creamos una funcion para crear el array de departamentos de Colombia
    private fun arrayDep(): ArrayList<String> {
        val departamentos = arrayListOf<String>() //Creamos el array de departamentos de Colombia
        departamentos.addAll(listOf("Seleccionar Departamento","Amazonas","Antioquia",
            "Arauca","Atlántico","Bogotá","Bolívar","Boyacá",
            "Caldas","Caquetá","Casanare","Cauca","Cesar","Chocó",
            "Córdoba","Cundinamarca","Guainía","Guaviare","Huila",
            "La Guajira","Magdalena","Meta","Nariño","Norte de Santander",
            "Putumayo","Quindío","Risaralda","San Andrés y Providencia",
            "Santander","Sucre","Tolima","Valle del Cauca","Vaupés","Vichada"))
        return departamentos
    }


    //Creamos una funcion para crear el array de las ciudades de cada departamentos de Colombia// En lo posible cambiar esto a json
    private fun arrayCity(departamento:String?): ArrayList<String> {
        val ciudades = arrayListOf<String>() //Creamos el array de ciudades del departamento de Colombia
        if(departamento.equals("Seleccionar Departamento")){
            ciudades.addAll(listOf("Seleccion"))
        }
        else if(departamento.equals("Amazonas")){
            ciudades.addAll(listOf("Leticia","Puerto Nariño","Abriaqu\u00ed"))
        }else if (departamento.equals("Antioquia")){
            ciudades.addAll(listOf("Abejorral", "Abriaqu\u00ed", "Alejandr\u00eda", "Amag\u00e1",
                "Amalfi", "Andes", "Angel\u00f3polis", "Angostura", "Anor\u00ed", "Anz\u00e1",
                "Apartad\u00f3", "Arboletes", "Argelia", "Armenia", "Barbosa", "Bello", "Belmira",
                "Betania", "Betulia", "Brice\u00f1o", "Buritic\u00e1", "C\u00e1ceres", "Caicedo",
                "Caldas", "Campamento", "Ca\u00f1asgordas", "Caracol\u00ed", "Caramanta", "Carepa",
                "Carolina del Pr\u00edncipe", "Caucasia", "Chigorod\u00f3", "Cisneros", "Ciudad Bol\u00edvar",
                "Cocorn\u00e1", "Concepci\u00f3n", "Concordia", "Copacabana", "Dabeiba", "Donmat\u00edas",
                "Eb\u00e9jico", "El Bagre", "El Carmen de Viboral", "El Pe\u00f1ol", "El Retiro", "El Santuario",
                "Entrerr\u00edos", "Envigado", "Fredonia", "Frontino", "Giraldo", "Girardota", "G\u00f3mez Plata",
                "Granada", "Guadalupe", "Guarne", "Guatap\u00e9", "Heliconia", "Hispania", "Itag\u00fc\u00ed",
                "Ituango", "Jard\u00edn", "Jeric\u00f3", "La Ceja", "La Estrella", "La Pintada", "La Uni\u00f3n",
                "Liborina", "Maceo", "Marinilla", "Medell\u00edn", "Montebello", "Murind\u00f3", "Mutat\u00e1",
                "Nari\u00f1o", "Nech\u00ed", "Necocl\u00ed", "Olaya", "Peque", "Pueblorrico", "Puerto Berr\u00edo",
                "Puerto Nare", "Puerto Triunfo", "Remedios", "Rionegro", "Sabanalarga", "Sabaneta", "Salgar",
                "San Andr\u00e9s de Cuerquia", "San Carlos", "San Francisco", "San Jer\u00f3nimo", "San Jos\u00e9 de la Monta\u00f1a", "San Juan de Urab\u00e1",
                "San Luis", "San Pedro de Urab\u00e1", "San Pedro de los Milagros", "San Rafael", "San Roque",
                "San Vicente", "Santa B\u00e1rbara", "Santa Fe de Antioquia", "Santa Rosa de Osos", "Santo Domingo", "Segovia",
                "Sons\u00f3n", "Sopetr\u00e1n", "T\u00e1mesis", "Taraz\u00e1", "Tarso", "Titirib\u00ed", "Toledo",
                "Turbo", "Uramita", "Urrao", "Valdivia", "Valpara\u00edso", "Vegach\u00ed", "Venecia", "Vig\u00eda del Fuerte",
                "Yal\u00ed", "Yarumal", "Yolomb\u00f3", "Yond\u00f3", "Zaragoza"))
        }else if (departamento.equals("Arauca")){
            ciudades.addAll(listOf("Arauca", "Arauquita",
                "Cravo Norte", "Fortul", "Puerto Rond\u00f3n",
                "Saravena", "Tame"))
        }else if (departamento.equals("Atlántico")){
            ciudades.addAll(listOf("Baranoa", "Barranquilla", "Campo de la Cruz",
                "Candelaria", "Galapa", "Juan de Acosta", "Luruaco", "Malambo",
                "Manat\u00ed", "Palmar de Varela", "Pioj\u00f3", "Polonuevo",
                "Ponedera", "Puerto Colombia", "Repel\u00f3n", "Sabanagrande",
                "Sabanalarga", "Santa Luc\u00eda", "Santo Tom\u00e1s", "Soledad",
                "Su\u00e1n", "Tubar\u00e1", "Usiacur\u00ed"))
        }else if (departamento.equals("Bogotá")){
            ciudades.addAll(listOf("Antonio Nariño","Barrios Unidos", "Bosa", "Chapinero",
                "Ciuadad Bolívar", "Engativá", "Fontibón", "Kennedy", "La Candelaria", "Los mártires",
                "Puente Aranda", "Rafael Uribe Uribe", "San Cristóbal", "Santa Fe", "Suba",
                "Sumapaz", "Teusaquillo", "Tunjuelito", "Usaquén", "Usme"))
        }else if (departamento.equals("Bolívar")){
            ciudades.addAll(listOf("Ach\u00ed", "Altos del Rosario", "Arenal", "Arjona", "Arroyohondo",
                "Barranco de Loba", "Brazuelo de Papayal", "Calamar", "Cantagallo", "Cartagena de Indias",
                "Cicuco", "Clemencia", "C\u00f3rdoba", "El Carmen de Bol\u00edvar", "El Guamo", "El Pe\u00f1\u00f3n",
                "Hatillo de Loba", "Magangu\u00e9", "Mahates", "Margarita", "Mar\u00eda la Baja", "Momp\u00f3s",
                "Montecristo", "Morales", "Noros\u00ed", "Pinillos", "Regidor", "R\u00edo Viejo", "San Crist\u00f3bal",
                "San Estanislao", "San Fernando", "San Jacinto del Cauca", "San Jacinto", "San Juan Nepomuceno", "San Mart\u00edn de Loba",
                "San Pablo", "Santa Catalina", "Santa Rosa", "Santa Rosa del Sur", "Simit\u00ed", "Soplaviento",
                "Talaigua Nuevo", "Tiquisio", "Turbaco", "Turban\u00e1", "Villanueva", "Zambrano"))
        }else if (departamento.equals("Boyacá")){
            ciudades.addAll(listOf("Almeida", "Aquitania", "Arcabuco", "Bel\u00e9n", "Berbeo", "Bet\u00e9itiva",
                "Boavita", "Boyac\u00e1", "Brice\u00f1o", "Buenavista", "Busbanz\u00e1", "Caldas", "Campohermoso",
                "Cerinza", "Chinavita", "Chiquinquir\u00e1", "Ch\u00edquiza", "Chiscas", "Chita", "Chitaraque", "Chivat\u00e1",
                "Chivor", "Ci\u00e9nega", "C\u00f3mbita", "Coper", "Corrales", "Covarach\u00eda", "Cubar\u00e1", "Cucaita",
                "Cu\u00edtiva", "Duitama", "El Cocuy", "El Espino", "Firavitoba", "Floresta", "Gachantiv\u00e1", "G\u00e1meza",
                "Garagoa", "Guacamayas", "Guateque", "Guayat\u00e1", "G\u00fcic\u00e1n", "Iza", "Jenesano", "Jeric\u00f3",
                "La Capilla", "La Uvita", "La Victoria", "Labranzagrande", "Macanal", "Marip\u00ed", "Miraflores",
                "Mongua", "Mongu\u00ed", "Moniquir\u00e1", "Motavita", "Muzo", "Nobsa", "Nuevo Col\u00f3n", "Oicat\u00e1",
                "Otanche", "Pachavita", "P\u00e1ez", "Paipa", "Pajarito", "Panqueba", "Pauna", "Paya", "Paz del R\u00edo",
                "Pesca", "Pisba", "Puerto Boyac\u00e1", "Qu\u00edpama", "Ramiriqu\u00ed", "R\u00e1quira", "Rond\u00f3n", "Saboy\u00e1", "S\u00e1chica", "Samac\u00e1",
                "San Eduardo", "San Jos\u00e9 de Pare", "San Luis de Gaceno", "San Mateo", "San Miguel de Sema", "San Pablo de Borbur",
                "Santa Mar\u00eda", "Santa Rosa de Viterbo", "Santa Sof\u00eda", "Santana", "Sativanorte", "Sativasur",
                "Siachoque", "Soat\u00e1", "Socha", "Socot\u00e1", "Sogamoso", "Somondoco", "Sora", "Sorac\u00e1",
                "Sotaquir\u00e1", "Susac\u00f3n", "Sutamarch\u00e1n", "Sutatenza", "Tasco", "Tenza", "Tiban\u00e1",
                "Tibasosa", "Tinjac\u00e1", "Tipacoque", "Toca", "Tog\u00fc\u00ed", "T\u00f3paga", "Tota", "Tunja",
                "Tunungu\u00e1", "Turmequ\u00e9", "Tuta", "Tutaz\u00e1", "\u00dambita", "Ventaquemada", "Villa de Leyva",
                "Viracach\u00e1", "Zetaquira"))
        }else if (departamento.equals("Caldas")){
            ciudades.addAll(listOf("Aguadas", "Anserma", "Aranzazu", "Belalc\u00e1zar",
                "Chinchin\u00e1", "Filadelfia", "La Dorada", "La Merced", "Manizales",
                "Manzanares", "Marmato", "Marquetalia", "Marulanda", "Neira", "Norcasia",
                "P\u00e1cora", "Palestina", "Pensilvania", "Riosucio", "Risaralda", "Salamina",
                "Saman\u00e1", "San Jos\u00e9", "Sup\u00eda", "Victoria", "Villamar\u00eda",
                "Viterbo"))
        }else if (departamento.equals("Caquetá")){
            ciudades.addAll(listOf("Albania", "Bel\u00e9n de los Andaqu\u00edes",
                "Cartagena del Chair\u00e1", "Curillo", "El Doncello", "El Paujil",
                "Florencia", "La Monta\u00f1ita", "Mil\u00e1n", "Morelia",
                "Puerto Rico", "San Jos\u00e9 del Fragua", "San Vicente del Cagu\u00e1n",
                "Solano", "Solita", "Valpara\u00edso"))
        }else if (departamento.equals("Casanare")){
            ciudades.addAll(listOf("Aguazul", "Ch\u00e1meza", "Hato Corozal", "La Salina",
                "Man\u00ed", "Monterrey", "Nunch\u00eda", "Orocu\u00e9", "Paz de Ariporo",
                "Pore", "Recetor", "Sabanalarga", "S\u00e1cama", "San Luis de Palenque",
                "T\u00e1mara", "Tauramena", "Trinidad", "Villanueva", "Yopal"))
        }else if (departamento.equals("Cauca")){
            ciudades.addAll(listOf("Almaguer", "Argelia", "Balboa", "Bol\u00edvar",
                "Buenos Aires", "Cajib\u00edo", "Caldono", "Caloto", "Corinto",
                "El Tambo", "Florencia", "Guachen\u00e9", "Guap\u00ed", "Inz\u00e1",
                "Jambal\u00f3", "La Sierra", "La Vega", "L\u00f3pez de Micay",
                "Mercaderes", "Miranda", "Morales", "Padilla", "P\u00e1ez",
                "Pat\u00eda", "Piamonte", "Piendam\u00f3", "Popay\u00e1n", "Puerto Tejada",
                "Purac\u00e9", "Rosas", "San Sebasti\u00e1n", "Santa Rosa", "Santander de Quilichao",
                "Silvia", "Sotar\u00e1", "Su\u00e1rez", "Sucre", "Timb\u00edo",
                "Timbiqu\u00ed", "Torib\u00edo", "Totor\u00f3", "Villa Rica"))
        }else if (departamento.equals("Cesar")){
            ciudades.addAll(listOf("Aguachica", "Agust\u00edn Codazzi", "Astrea",
                "Becerril", "Bosconia", "Chimichagua", "Chiriguan\u00e1", "Curuman\u00ed",
                "El Copey", "El Paso", "Gamarra", "Gonz\u00e1lez", "La Gloria",
                "La Jagua de Ibirico", "La Paz", "Manaure Balc\u00f3n del Cesar",
                "Pailitas", "Pelaya", "Pueblo Bello", "R\u00edo de Oro", "San Alberto",
                "San Diego", "San Mart\u00edn", "Tamalameque", "Valledupar"))
        }else if (departamento.equals("Chocó")){
            ciudades.addAll(listOf("Acand\u00ed", "Alto Baud\u00f3", "Bagad\u00f3",
                "Bah\u00eda Solano", "Bajo Baud\u00f3", "Bojay\u00e1", "Cant\u00f3n de San Pablo",
                "C\u00e9rtegui", "Condoto", "El Atrato", "El Carmen de Atrato", "El Carmen del Dari\u00e9n",
                "Istmina", "Jurad\u00f3", "Litoral de San Juan", "Llor\u00f3", "Medio Atrato", "Medio Baud\u00f3",
                "Medio San Juan", "N\u00f3vita", "Nuqu\u00ed", "Quibd\u00f3", "R\u00edo Ir\u00f3", "R\u00edo Quito",
                "Riosucio", "San Jos\u00e9 del Palmar", "Sip\u00ed", "Tad\u00f3", "Uni\u00f3n Panamericana", "Ungu\u00eda"))
        }else if (departamento.equals("Córdoba")){
            ciudades.addAll(listOf("Ayapel", "Buenavista", "Canalete", "Ceret\u00e9", "Chim\u00e1",
                "Chin\u00fa", "Ci\u00e9naga de Oro", "Cotorra", "La Apartada", "Lorica", "Los C\u00f3rdobas",
                "Momil", "Montel\u00edbano", "Monter\u00eda", "Mo\u00f1itos", "Planeta Rica", "Pueblo Nuevo",
                "Puerto Escondido", "Puerto Libertador", "Pur\u00edsima", "Sahag\u00fan", "San Andr\u00e9s de Sotavento",
                "San Antero", "San Bernardo del Viento", "San Carlos", "San Jos\u00e9 de Ur\u00e9", "San Pelayo", "Tierralta",
                "Tuch\u00edn", "Valencia"))
        }else if (departamento.equals("Cundinamarca")){
            ciudades.addAll(listOf(            "Agua de Dios", "Alb\u00e1n", "Anapoima", "Anolaima", "Apulo",
                "Arbel\u00e1ez", "Beltr\u00e1n", "Bituima", "Bojac\u00e1", "Cabrera", "Cachipay", "Cajic\u00e1",
                "Caparrap\u00ed", "C\u00e1queza", "Carmen de Carupa", "Chaguan\u00ed", "Ch\u00eda", "Chipaque",
                "Choach\u00ed", "Chocont\u00e1", "Cogua", "Cota", "Cucunub\u00e1", "El Colegio", "El Pe\u00f1\u00f3n", "El Rosal",
                "Facatativ\u00e1", "F\u00f3meque", "Fosca", "Funza", "F\u00faquene", "Fusagasug\u00e1", "Gachal\u00e1",
                "Gachancip\u00e1", "Gachet\u00e1", "Gama", "Girardot", "Granada", "Guachet\u00e1", "Guaduas", "Guasca", "Guataqu\u00ed", "Guatavita", "Guayabal de S\u00edquima", "Guayabetal", "Guti\u00e9rrez",
                "Jerusal\u00e9n", "Jun\u00edn", "La Calera", "La Mesa", "La Palma", "La Pe\u00f1a", "La Vega",
                "Lenguazaque", "Machet\u00e1", "Madrid", "Manta", "Medina", "Mosquera", "Nari\u00f1o", "Nemoc\u00f3n",
                "Nilo", "Nimaima", "Nocaima", "Pacho", "Paime", "Pandi", "Paratebueno", "Pasca", "Puerto Salgar", "Pul\u00ed",
                "Quebradanegra", "Quetame", "Quipile", "Ricaurte", "San Antonio del Tequendama", "San Bernardo",
                "San Cayetano", "San Francisco", "San Juan de Rioseco", "Sasaima", "Sesquil\u00e9", "Sibat\u00e9",
                "Silvania", "Simijaca", "Soacha", "Sop\u00f3", "Subachoque", "Suesca", "Supat\u00e1", "Susa", "Sutatausa",
                "Tabio", "Tausa", "Tena", "Tenjo", "Tibacuy", "Tibirita", "Tocaima", "Tocancip\u00e1", "Topaip\u00ed", "Ubal\u00e1", "Ubaque", "Ubat\u00e9", "Une", "\u00datica",
                "Venecia", "Vergara", "Vian\u00ed", "Villag\u00f3mez", "Villapinz\u00f3n", "Villeta", "Viot\u00e1",
                "Yacop\u00ed", "Zipac\u00f3n", "Zipaquir\u00e1"))
        }else if (departamento.equals("Guainía")){
            ciudades.addAll(listOf("In\u00edrida"))
        }else if (departamento.equals("Guaviare")){
            ciudades.addAll(listOf("Calamar", "El Retorno", "Miraflores", "San Jos\u00e9 del Guaviare"))
        }else if (departamento.equals("Huila")){
            ciudades.addAll(listOf("Acevedo", "Agrado", "Aipe", "Algeciras", "Altamira",
                "Baraya", "Campoalegre", "Colombia", "El Pital", "El\u00edas", "Garz\u00f3n",
                "Gigante", "Guadalupe", "Hobo", "\u00cdquira", "Isnos", "La Argentina",
                "La Plata", "N\u00e1taga", "Neiva", "Oporapa", "Paicol", "Palermo", "Palestina",
                "Pitalito", "Rivera", "Saladoblanco", "San Agust\u00edn", "Santa Mar\u00eda", "Suaza",
                "Tarqui", "Tello", "Teruel", "Tesalia", "Timan\u00e1", "Villavieja", "Yaguar\u00e1"))
        }else if (departamento.equals("La Guajira")){
            ciudades.addAll(listOf("Albania", "Barrancas", "Dibulla", "Distracci\u00f3n",
                "El Molino", "Fonseca", "Hatonuevo", "La Jagua del Pilar", "Maicao",
                "Manaure", "Riohacha", "San Juan del Cesar", "Uribia", "Urumita", "Villanueva"))
        }else if (departamento.equals("Magdalena")){
            ciudades.addAll(listOf("Algarrobo", "Aracataca", "Ariguan\u00ed", "Cerro de San Antonio",
                "Chibolo", "Ci\u00e9naga", "Concordia", "El Banco", "El Pi\u00f1\u00f3n", "El Ret\u00e9n",
                "Fundaci\u00f3n", "Guamal", "Nueva Granada", "Pedraza", "Piji\u00f1o del Carmen", "Pivijay",
                "Plato", "Pueblo Viejo", "Remolino", "Sabanas de San \u00c1ngel", "Salamina", "San Sebasti\u00e1n de Buenavista",
                "San Zen\u00f3n", "Santa Ana", "Santa B\u00e1rbara de Pinto", "Santa Marta", "Sitionuevo", "Tenerife",
                "Zapay\u00e1n", "Zona Bananera"))
        }else if (departamento.equals("Meta")){
            ciudades.addAll(listOf("Acac\u00edas", "Barranca de Up\u00eda", "Cabuyaro", "Castilla la Nueva",
                "Cubarral", "Cumaral", "El Calvario", "El Castillo", "El Dorado", "Fuente de Oro",
                "Granada", "Guamal", "La Macarena", "La Uribe", "Lejan\u00edas", "Mapirip\u00e1n", "Mesetas",
                "Puerto Concordia", "Puerto Gait\u00e1n", "Puerto Lleras", "Puerto L\u00f3pez", "Puerto Rico", "Restrepo",
                "San Carlos de Guaroa", "San Juan de Arama", "San Juanito", "San Mart\u00edn", "Villavicencio", "Vista Hermosa"))
        }else if (departamento.equals("Nariño")){
            ciudades.addAll(listOf("Aldana", "Ancuy\u00e1", "Arboleda", "Barbacoas", "Bel\u00e9n", "Buesaco",
                "Chachag\u00fc\u00ed", "Col\u00f3n", "Consac\u00e1", "Contadero", "C\u00f3rdoba", "Cuaspud", "Cumbal",
                "Cumbitara", "El Charco", "El Pe\u00f1ol", "El Rosario", "El Tabl\u00f3n", "El Tambo", "Francisco Pizarro",
                "Funes", "Guachucal", "Guaitarilla", "Gualmat\u00e1n", "Iles", "Imu\u00e9s", "Ipiales", "La Cruz",
                "La Florida", "La Llanada", "La Tola", "La Uni\u00f3n", "Leiva", "Linares", "Los Andes", "Mag\u00fc\u00ed Pay\u00e1n",
                "Mallama", "Mosquera", "Nari\u00f1o", "Olaya Herrera", "Ospina", "Pasto", "Policarpa", "Potos\u00ed",
                "Providencia", "Puerres", "Pupiales", "Ricaurte", "Roberto Pay\u00e1n", "Samaniego", "San Bernardo",
                "San Jos\u00e9 de Alb\u00e1n", "San Lorenzo", "San Pablo", "San Pedro de Cartago", "Sandon\u00e1", "Santa B\u00e1rbara", "Santacruz", "Sapuyes",
                "Taminango", "Tangua", "Tumaco", "T\u00faquerres", "Yacuanquer"))
        }else if (departamento.equals("Norte de Santander")){
            ciudades.addAll(listOf("\u00c1brego", "Arboledas", "Bochalema", "Bucarasica", "C\u00e1chira",
                "C\u00e1cota", "Chin\u00e1cota", "Chitag\u00e1", "Convenci\u00f3n", "C\u00facuta", "Cucutilla",
                "Duran\u00eda", "El Carmen", "El Tarra", "El Zulia", "Gramalote", "Hacar\u00ed", "Herr\u00e1n",
                "La Esperanza", "La Playa de Bel\u00e9n", "Labateca", "Los Patios", "Lourdes", "Mutiscua",
                "Oca\u00f1a", "Pamplona", "Pamplonita", "Puerto Santander", "Ragonvalia", "Salazar de Las Palmas", "San Calixto",
                "San Cayetano", "Santiago", "Santo Domingo de Silos", "Sardinata", "Teorama", "Tib\u00fa", "Toledo",
                "Villa Caro", "Villa del Rosario"))
        }else if (departamento.equals("Putumayo")){
            ciudades.addAll(listOf("Col\u00f3n", "Mocoa", "Orito", "Puerto As\u00eds", "Puerto Caicedo",
                "Puerto Guzm\u00e1n", "Puerto Legu\u00edzamo", "San Francisco", "San Miguel", "Santiago",
                "Sibundoy", "Valle del Guamuez", "Villagarz\u00f3n"))
        }else if (departamento.equals("Quindío")){
            ciudades.addAll(listOf("Armenia", "Buenavista", "Calarc\u00e1", "Circasia",
                "C\u00f3rdoba", "Filandia", "G\u00e9nova", "La Tebaida",
                "Montenegro", "Pijao", "Quimbaya", "Salento"))
        }else if (departamento.equals("Risaralda")){
            ciudades.addAll(listOf("Ap\u00eda", "Balboa", "Bel\u00e9n de Umbr\u00eda", "Dosquebradas",
                "Gu\u00e1tica", "La Celia", "La Virginia", "Marsella", "Mistrat\u00f3", "Pereira",
                "Pueblo Rico", "Quinch\u00eda", "Santa Rosa de Cabal", "Santuario"))
        }else if (departamento.equals("San Andrés y Providencia")){
            ciudades.addAll(listOf("Providencia y Santa Catalina Islas", "San Andr\u00e9s"))
        }else if (departamento.equals("Santander")){
            ciudades.addAll(listOf("Aguada", "Albania", "Aratoca", "Barbosa", "Barichara", "Barrancabermeja",
                "Betulia", "Bol\u00edvar", "Bucaramanga", "Cabrera", "California", "Capitanejo", "Carcas\u00ed",
                "Cepit\u00e1", "Cerrito", "Charal\u00e1", "Charta", "Chima", "Chipat\u00e1", "Cimitarra", "Concepci\u00f3n",
                "Confines", "Contrataci\u00f3n", "Coromoro", "Curit\u00ed", "El Carmen de Chucur\u00ed", "El Guacamayo",
                "El Pe\u00f1\u00f3n", "El Play\u00f3n", "El Socorro", "Encino", "Enciso", "Flori\u00e1n", "Floridablanca",
                "Gal\u00e1n", "G\u00e1mbita", "Gir\u00f3n", "Guaca", "Guadalupe", "Guapot\u00e1", "Guavat\u00e1",
                "G\u00fcepsa", "Hato", "Jes\u00fas Mar\u00eda", "Jord\u00e1n", "La Belleza", "La Paz", "Land\u00e1zuri",
                "Lebrija", "Los Santos", "Macaravita", "M\u00e1laga", "Matanza", "Mogotes", "Molagavita", "Ocamonte",
                "Oiba", "Onzaga", "Palmar", "Palmas del Socorro", "P\u00e1ramo", "Piedecuesta", "Pinchote",
                "Puente Nacional", "Puerto Parra", "Puerto Wilches", "Rionegro", "Sabana de Torres", "San Andr\u00e9s",
                "San Benito", "San Gil", "San Joaqu\u00edn", "San Jos\u00e9 de Miranda", "San Miguel", "San Vicente de Chucur\u00ed",
                "Santa B\u00e1rbara", "Santa Helena del Op\u00f3n", "Simacota", "Suaita", "Sucre", "Surat\u00e1",
                "Tona", "Valle de San Jos\u00e9", "V\u00e9lez", "Vetas",
                "Villanueva", "Zapatoca"))
        }else if (departamento.equals("Sucre")){
            ciudades.addAll(listOf("Buenavista", "Caimito", "Chal\u00e1n", "Colos\u00f3", "Corozal",
                "Cove\u00f1as", "El Roble", "Galeras", "Guaranda", "La Uni\u00f3n", "Los Palmitos",
                "Majagual", "Morroa", "Ovejas", "Sampu\u00e9s", "San Antonio de Palmito", "San Benito Abad",
                "San Juan de Betulia", "San Marcos", "San Onofre", "San Pedro", "Sinc\u00e9", "Sincelejo",
                "Sucre", "Tol\u00fa", "Tol\u00fa Viejo"))
        }else if (departamento.equals("Tolima")){
            ciudades.addAll(listOf("Alpujarra", "Alvarado", "Ambalema", "Anzo\u00e1tegui", "Armero",
                "Ataco", "Cajamarca", "Carmen de Apical\u00e1", "Casabianca", "Chaparral", "Coello",
                "Coyaima", "Cunday", "Dolores", "El Espinal", "Fal\u00e1n", "Flandes", "Fresno",
                "Guamo", "Herveo", "Honda", "Ibagu\u00e9", "Icononzo", "L\u00e9rida", "L\u00edbano", "Mariquita",
                "Melgar", "Murillo", "Natagaima", "Ortega", "Palocabildo", "Piedras", "Planadas", "Prado",
                "Purificaci\u00f3n", "Rioblanco", "Roncesvalles", "Rovira", "Salda\u00f1a", "San Antonio",
                "San Luis", "Santa Isabel", "Su\u00e1rez", "Valle de San Juan", "Venadillo", "Villahermosa", "Villarrica"))
        }else if (departamento.equals("Valle del Cauca")){
            ciudades.addAll(listOf("Alcal\u00e1", "Andaluc\u00eda", "Ansermanuevo", "Argelia", "Bol\u00edvar",
                "Buenaventura", "Buga", "Bugalagrande", "Caicedonia", "Cali", "Calima", "Candelaria", "Cartago",
                "Dagua", "El \u00c1guila", "El Cairo", "El Cerrito", "El Dovio", "Florida", "Ginebra", "Guacar\u00ed",
                "Jamund\u00ed", "La Cumbre", "La Uni\u00f3n", "La Victoria", "Obando", "Palmira", "Pradera", "Restrepo",
                "Riofr\u00edo", "Roldanillo", "San Pedro", "Sevilla", "Toro", "Trujillo", "Tulu\u00e1", "Ulloa", "Versalles",
                "Vijes", "Yotoco", "Yumbo", "Zarzal"))
        }else if (departamento.equals("Vaupés")){
            ciudades.addAll(listOf("Carur\u00fa", "Mit\u00fa", "Taraira"))
        }else if (departamento.equals("Vichada")){
            ciudades.addAll(listOf("Cumaribo", "La Primavera", "Puerto Carre\u00f1o", "Santa Rosal\u00eda"))
        }
        /*departamentos.addAll(listOf("Amazonas","Antioquia",
            "Arauca","Atlántico","Bogotá","Bolívar","Boyacá",
            "Caldas","Caquetá","Casanare","Cauca","Cesar","Chocó",
            "Córdoba","Cundinamarca","Guainía","Guaviare","Huila",
            "La Guajira","Magdalena","Meta","Nariño","Norte de Santander",
            "Putumayo","Quindío","Risaralda","San Andrés y Providencia",
            "Santander","Sucre","Tolima","Valle del Cauca","Vaupés","Vichada"))*/
        return ciudades
    }





    private fun showRegistro2(depto: String) {
        // IR A HOME
      /* val registro2Intent = Intent(this, Registro2Activity::class.java).apply {    //CREAR UN INTENT A LA NUEVA PANTALLA Y NAVEGAR A LA NUEVA PANTALLA
            //PARAMETROS A PASAR
            putExtra("departamento", depto) //Pasamos el departamento a la siguiente aplicacion
        }
        startActivity(registro2Intent) //LA NAVEGACION A LA NUEVA PANTALLA

       */

        val homeIntent = Intent(this, HomeActivity::class.java)
        startActivity(homeIntent)
    }

}