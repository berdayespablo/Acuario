# Acuario
Proyecto de práctica para entender algunos conceptos de la POO y de Java. Es un proyecto Maven, por lo que las dependencias se gestionan en el archivo `POM.xml`. 

## Cómo ejecutarlo
Ejecutar la clase VentanaPrincipal desde tu IDE de confianza. Yo recomiendo IntelliJ IDEA Community Edition. 

## ¿Qué hay que hacer? 
Ir resolviendo todos los `TODO` dentro del código. Recomiendo empezar por la clase pez y seguir por la de acuario. Una vez tengas el acuario con peces, iremos añadiendo más funcionalidades. 

## ¿Cuál es el modo de trabajo? 
La rama arquetipo-base será tu rama de referencia. Tienes que clonar el repositorio desde esa rama, y una vez hecho, crearte la tuya propia con cualquier nombre. Siempre trabajarás en esa rama. Si tu IDE no ofrece simplicidad a la hora de hacer esto,
puedes usar descargar [Sourcetree](https://www.sourcetreeapp.com/) o [GitHub Desktop](https://desktop.github.com/) como GUI de GIT. 

## ¿Y mis tareas? 
Aquí puedes ir viendo los tickets con el detalle de cada tarea: [Tablero Kanban Acuario](https://ufitopuchi.atlassian.net/jira/software/projects/AC/boards/2)

## Guía de GIT

El flujo es tan sencillo como esto: te traes los cambios en el repositorio (en la nube) con `pull`. Cuando tengas cambios en tu local, se preparan con `add` y se dejan listos para enviar con `commit`. Un commit es como un paquete
con tus cambios listos para integrarse en el destino. Finalmente, se hace un `push` para enviarlos. 

![image](https://github.com/berdayespablo/Acuario/assets/22392106/73949402-e037-4d18-a68a-ba146bac76da)

Conceptos Fundamentales de Git:
- *Repositorio*: Es el directorio donde Git ha inicializado y está rastreando los cambios de los archivos. Cada repositorio de Git tiene un historial completo de commits.
- *Commit*: Es una instantánea de tu repositorio en un punto específico en el tiempo. Cada commit tiene un hash único que lo identifica.
- *Rama* (*Branch*): Permite trabajar en características o correcciones de errores en paralelo sin afectar la rama principal o 'main'.
- *Merge*: Es el proceso de combinar los cambios de una rama en otra.
- *Pull Request*: Es una solicitud para mezclar una rama en otra, comúnmente utilizada en GitHub para revisar y discutir los cambios antes de combinarlos.

Se puede trabajar por interfaz gráfica, como se comentó anteriormente, o por comandos. Estos son los comandos de GIT que deberías conocer:
- git clone: Para clonar el repositorio existente.
- git checkout: Para cambiar a una rama específica después de clonar.
```git
git clone URL_DEL_REPOSITORIO
cd NOMBRE_DEL_REPOSITORIO
git checkout NOMBRE_DE_LA_RAMA
```

Puedes usar -b con git checkout para crear y cambiar a la nueva rama en un solo comando:

```git
git checkout -b NOMBRE_DE_LA_NUEVA_RAMA
```

- git add: Para agregar los archivos modificados al área de ensayo.
- git commit: Para guardar los cambios en el repositorio local con un mensaje descriptivo.

```git
git add RUTA_DEL_ARCHIVO
git commit -m "MENSAJE_DE_COMMIT"
```

```git
git push origin NOMBRE_DE_LA_NUEVA_RAMA
```
