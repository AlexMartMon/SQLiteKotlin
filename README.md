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
