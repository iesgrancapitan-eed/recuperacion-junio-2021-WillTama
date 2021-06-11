## La tarea consiste en depurar el código suministrado. Realizara las siguientes actividades en el depurador de Eclipse y adjunta pantallazos para demostrarlo:

#### 1. Definido y activado el filtrado de depuración para que no entre en ninguna librería externa:
![1](1.PNG) 


#### 2. En el paquete factorial:

##### Punto de ruptura en la entrada del main. Avanza de forma libre para entender el funcionamiento del código
![1](2-1.PNG)

##### Punto de ruptura en la salida del método Factorial.recursivo(). Avanzo con resume y muestro el estado de las variables del método.
![1](2-2.PNG)

##### Punto de ruptura condicional en el método Factorial.recursivo() cuando número sea menor que 9. Avanzo con resume y muestro el estado de las variables del método. ¿Cuántas veces se activa?
![1](2-3.PNG)
### Se activa 3 veces

##### Pila de llamadas en la función recursiva cuando ésta es mayor
![1](2-4.PNG)

##### Dos puntos de observación en Factorial.iterativo: numero y resultado. Añade puntos de ruptura y muestra el cambio de los valores en distintos pantallazos
![1](2-5.1.PNG)
![1](2-5.2.PNG)


#### 3. En el paquete contador:

##### En TestContador añado un punto de ruptura en cada pasada del for y visualizo el cambio de variables.
![1](3-1.1.PNG)
![1](3-1.2.PNG)

##### En Contador añado un punto de ruptura para la excepción MaximoContadorException (Add Java Exception Breakpoint). Pantallazo de la vista Debug con la pila.
![1](3-2.PNG)

##### Código modificado para que la excepción sea capturada y se informe al usuario de forma correcta.

#### 4. En el paquete calculadora: 

##### Pon un punto de ruptura cuando el divisor sea 0
![1](4-1.PNG)

##### Añade un punto de ruptura cuando se lance la excepción java.lang.ArithmeticException. Captura la excepción para que muestre el mensaje "No se puede realizar la división por cero"
![1](4-2.PNG)

##### Modifica el main para que solicite ambos números desde teclado de forma iterativa(10 veces)

#### 5. Vista de puntos de ruptura expandidos y agrupados por proyectos, unos habilitados y otros no
![1](5.PNG)

#### 6. Vista de puntos de ruptura expandidos y agrupados por ficheros y tipos, todos anulados (Skip All Breakpoints)
![1](6.PNG)
