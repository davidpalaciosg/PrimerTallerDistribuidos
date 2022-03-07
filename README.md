# Primer taller Introducción a los Sistemas Distribuidos

Realizado por:

* David Enrique Palacios García
* José Fernando Zuluaga
* Daniel Morales

Profesora: Mariela Curiel

## Uso del taller

1. Compilar los archivos .java

```bash
$ javac *.java
```
2. Registro del RMI. En una terminal:

```bash
$ rmiregistry
```
3. Iniciar servidor. En otra terminal:
```java
$ java ServerEstudiante
```

4. Iniciar clientes. Para esto, existen 5 casos de uso que se ejecutan de la siguiente manera:
```bash
$ java ClientEstudiante <ipServidor:Puerto> <metodo> <parametro> 
```

 * getNombreEstudiante (id) : Devuelve el nombre de un estudiante dando su id. Ejemplo:
```java
$ java ClientEstudiante 25.72.66.53:1099 getNombreEstudiante 665
```
* getPromedioNotasEstudiante (id) : Devuelve el promedio de notas de un estudiante dando su id. Ejemplo:
```java
$ java ClientEstudiante 25.72.66.53:1099  getPromedioNotasEstudiante 665
```
* getPromedioNotasEstudiante (nombre) : Devuelve el promedio de notas de un estudiante dando su nombre. Ejemplo:
```java
$ java ClientEstudiante 25.72.66.53:1099  getPromedioNotasEstudiante Meneses,Enrique
```
* getGrupoEstudiante (id) : Devuelve el grupo de un estudiante dando su id. Ejemplo:
```java
$ java ClientEstudiante 25.72.66.53:1099  getGrupoEstudiante 665
```
* getMiembrosGrupo (grupo) : Devuelve la información del grupo de estudiantes pertenecientes a un grupo. Ejemplo:
```java
$ java ClientEstudiante 25.72.66.53:1099  getGrupoEstudiante G4
```
