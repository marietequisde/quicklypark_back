# Backend de QuicklyPark
## Instalación
### 1. Descarga
1. Tener git y que funcione desde la terminal/cmd
2. Clonar el repositorio (yo suelo hacerlo dentro del workspace de eclipse)
```title="Clonar el repositorio"
git clone https://github.com/marietequisde/quicklypark_back
```
3. Cuando haya alguna actualización solo hay que hacer pull
```
git pull origin master
```
### 2. Base de datos
1. Instalar MySQL Workbench
2. Crear un esquema llamado **quicklypark**
3. Entrar al esquema
4. Ejecutar sql/init.sql
5. Ejecutar sql/datos_prueba.sql
### 3. Eclipse
1. Puedes probar con tu eclipse, pero si no funciona, yo he usado el [2026-03](https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2026-03/R/eclipse-java-2026-03-R-win32-x86_64.zip).
2. Importar el proyecto a un workspace (Import... -> Maven -> Existing Maven Projects -> Examinas la carpeta -> Finish)
3. Click derecho en el proyecto -> Run As -> **Maven clean**
4. Click derecho en el proyecto -> Run As -> **Maven install**
### 4. Lanzar
1. Buscar la clase **Application.java**, que está dentro del paquete principal.
2. Click derecho -> Run As -> Java Application
3. Si se lanza correctamente deberías poder testear la API desde [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

