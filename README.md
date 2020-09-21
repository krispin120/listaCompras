### listaCompras
Proyecto para manejar listas de compras realizado con spring-boot.<br />

correr main en: listaCompras/listacompras/src/main/java/com/sebastian/listacompras/ListacomprasApplication.java

dirección: http://localhost:8080/

Funcionalidades:<br />
  Agregar productos a una lista:<br />
    HTTP post request a /listas/{nombre de la lista}/productos/agregar, con un json en el body con:<br />
      -codigo (String, codigo que identifica al producto)<br />
      -nombre (String, nombre del producto)<br />
      -descripcion (String, descripcion del producto)<br />
      -cantidad (int, cantidad de unidades)<br />
      -precio (int, precio unitario)<br />
      -comprado (boolean, estado del producto)<br />
      
  Quitar productos de una lista:<br />
    HTTP post request a /listas/{nombre de la lista}/productos/eliminar, con un json en el body con:<br />
      -codigo (String, codigo que identifica al producto)<br />
      
  Comprar producto de una lista:<br />
    HTTP post request a /listas/{nombre de la lista}/productos/comprado, con un json en el body con:<br />
      -codigo (String, codigo que identifica al producto)<br />
      
  Consultar las listas:<br />
    HTTP get request a /listas/consultar obtiene un json con todas las listas con sus productos y el precio total.<br />
    
  Consultar una lista:<br />
    HTTP get request a /listas/{nombre de la lista}/consultar obtiene un json con los productos y el precio total.<br />
    
  Eliminar lista:<br />
    HTTP post request a /listas/{nombre de la lista}/eliminar, elimina la lista completa.<br />

Todo esto se realizó con una base de datos PostgreSQL:<br />

 listaCompras/listacomprassrc/main/java/com/sebastian/listacompras/db/BaseDeDatos.java:<br />

   variables url, user, password para configurar la conexión.

  BD con unica tabla, script:<br />
    
    CREATE TABLE productos
    (
        lista varchar(30) NOT NULL,
        codigo varchar(13) NOT NULL,
        nombre varchar(20) NOT NULL,
        descripcion varchar(200) NOT NULL,
        cantidad integer NOT NULL,
        precio integer NOT NULL,
        comprado boolean NOT NULL,
        CONSTRAINT productos_pkey PRIMARY KEY (lista, codigo)
    );
