# Tarea-Programada-2-CI112
Fecha de entrega: 20 de junio del 2021
Gestor de tareas

Descripción del problema:

Se requiere abstraer el problema de administrar listas, mediante el diseño y creación de una herramienta para la gestión de estas. La composición y nivel con que administra la lista debe ser definido por el usuario, acorde con las reglas dadas mas adelante.

Como parte de esta herramienta y usando una combinación de Colecciones y archivo en java, se debe:
1.	permitir la creación de listas (poseen un identificador, un nombre y quizás una descripción) con actividades, tareas o elementos dentro de ella (id, nombre, fecha inicio, fecha de fin, responsable, estimación (tiempo, dinero, esfuerzo,…), grado de avance)(atributos de la lista)
2.	las listas deben poder crearse. En ellas el estado de las actividades, tareas o elementos debe poderse cambiar.(método de cambio de estados) Cada estado debe presentarse asociado con una columna (que también debe tener un nombre, un identificador y una composición de actividades, tareas o elementos)
3.	permitir secuenciar o asociar actividades según orden de ejecución (precedencia de ejecución con base en el id de las tareas o actividades) (Sort). Para permitir iniciar una tarea que dependa de otra y que ésta no esté aún terminada, cree un “proxy”: tarea ficticia que reemplaza momentáneamente la otra que aún no finaliza. En el proxy debe identificarse el nombre de los responsables de ambas tareas(¿?)
4.	definir responsables para la ejecución de tareas. Esto significa que debe poderse tener un grupo de colaboradores a quienes se puede delegar la responsabilidad de hacer algunas de las tareas, al delegar indíquese la cantidad de tiempo semanal que se le da para eso.(Colección de String como atributo de cada tarea)
5.	Definir los recursos a asignar para las tareas (nombre, id y % de asignación(qué le toca a cada responsable?))
6.	Se debe soportar el IMEC (inserciones, modificaciones, exclusiones y consultas) de las tareas, responsables, listas entre otras: estado, avance, impedimentos, etc,

La aplicación debe permitir crear, administrar y gestionar un conjunto de diversas listas y categorías. Estas se deben poder guardar en disco duro o bien cargar en memoria, actualizar, consultar y volver a guardar en disco duro (Generarlas como archivos .txt).

Funcionalidades deseadas

1.	Admitir la creación y uso de categorías de listas
2.	Permitir la definición de listas.
3.	Poblar listas con datos
4.	Dentro de una lista, filtrar datos que satisfacen algún conjunto de condiciones definidas en tiempo real por el usuario. Para definir las condiciones se debe permitir que el usuario:
5.	Permitir guardar y cargar en memoria las listas para ser editadas o consultadas (archivos)

Criterios de evaluación:
1.	Tarea a ser realizada en equipos de 2 o 3 personas
2.	Se debe usar git
3.	se va a calificar lo que esté disponible en git
4.	aspectos a considerar: inicio y fin de trabajos, cantidad de commits realizados en actividades terminadas
5.	funcionalidad que posea la aplicación (como mínimo que permita realizar lo indicado)
6.	documentación usando javadoc
7.	Ideas de mockups para una posible aplicación
