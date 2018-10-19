# SQLiteKotlin
<h1>SQLite con kotlin</h1>
<p>
En este proyecto simple, veremos el funcionamiento de SQLite en android con kotlin
para ello creamos un proyecto nuevo con soporte en kotlin, y creamos una empty activity,
una vez generado el proyecto creamos una nueva clase kotlin que sera la encargada de administrar la base de datos,
yo la he llamado AdminSQLite.
</p>
<hr style="color: #0056b2;" />
<h3>AdminSQLite </h3>

<p>
En el constructor de la clase vemos que se le pasan 4 parametros,Context, Name, Factory y Version respectivamente
por el momento solo nos interesa name y factory
</p>
<p>
  name: le dara un nombre a la base de datos cuando se cree
  version: sera la versión de la base de datos, su uso se explicara más abajo.
</p>

<h4>onCreate & onUpgrade</h4>
<p>
estos dos métodos deben estar siempre implementados dentro de nuestra clase administradora de la base de datos,
  onCreate se ejecutara una única vez al instalar la aplicación y ejecutarse y realizara todas las órdenes que le hallamos asignado dentro, se usa para definir la estructura de la base de datos.
  
  Cada vez que abrimos la aplicación con nuestro dispositivo el administrador revisara la versión de SQLite que tenía la última vez que se ejecuto la app con la actual que le entra, sí es diferente (x<y siendo "x" la versión anterior y "y" la nueva versión) ejecutara el método onUpgrade.
  
  onUpgrade: lo usaremos para modificar la estructura de la base de datos o añadir nuevas tablas que se nos olvidasen incluir
</p>

<h3>Main Activity</h3>

<p>
En el código de la activity, creamos una variable del administrador a la cual le pasamos el contexto de la activity, un nombre, factory se deja null y una versión inicial 1
</p>

<p>
 para dar de alta un registro en la base de datos, en el setOnclickListener de mi boton crear,
  hago uso de una variable bd que abrira la base de datos en modo lectura y escritura
  y una variable de tipo contentValues donde meteremos pares de valores, la key de todos pares debe coincidir con el nombre de los campos de la tabla.
            val bd = admin!!.writableDatabase
            val registro = ContentValues()
            registro.put("codigo", codigoAlumno.getText().toString())
  
una vez introducidos todos los pares en la variable, asigno una variable "i" de tipo Int a la ejecución del insert

              val i = bd.insert("alumnos", null, registro)
              
i tomara valor mayor de 0 si se ha insertado correctamente él registro
si es igual a 0 es porque ya existe un registro con dicha PK 
y si es -1 es un código de error, suele ser porque la PK introducida esta null o algún campo que no admite nulos le ha entrado un nulo

              bd.close()
              
 Es importante al final cerrar la base de datos del modo lectura y escritura pues podríamos dañar el telefono, pues en caso de que mientras esta abierta nuestro telefono recibe una llamada por ejemplo o alguna app externa de mayor prioridad necesite de ser usada en ese momento nuestra app pasara a la pila de app o en caso de no tener ram en el dispositivo se cierre forzadamente generando datos corruptos en nuestra base de datos
</p>
