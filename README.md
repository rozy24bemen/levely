LEVELY 

QUE ES
Nuestra red social está pensada para crear una comunidad dinámica en la que los usuarios puedan compartir contenido, interactuar y destacar según su participación y aportes.

Cada usuario contará con un perfil personalizado que mostrará su nivel dentro de la plataforma. Este nivel reflejará su actividad, logros y el reconocimiento recibido por parte de otros usuarios.

El nivel de usuario podrá incrementarse de dos formas principales:

Completando logros dentro de la aplicación (como publicar contenido, interactuar con otros usuarios o alcanzar metas específicas).

Recibiendo valoraciones positivas o “me gusta” en las publicaciones realizadas.

La red social contará además con diferentes secciones temáticas, donde los usuarios podrán explorar y participar en comunidades centradas en intereses específicos. Dentro de cada sección, los contenidos podrán ordenarse o destacarse según las valoraciones y niveles de los usuarios, lo que permitirá dar mayor visibilidad a los aportes más relevantes y a los miembros más activos.
De esta forma, nuestra red social fomentará la participación, la calidad del contenido y el reconocimiento dentro de una comunidad diversa y en constante crecimiento.💻 Pilares Técnicos Fundamentales
Para que tu red social funcione como una aplicación web, necesitarás estas tres capas:
Capa
Propósito
Tecnologías Comunes (Primitivas)
1. Frontend
Lo que el usuario ve e interactúa.
HTML (estructura), CSS (estilos) y JavaScript (interactividad básica en el navegador).
2. Backend
El "cerebro": lógica del negocio y procesamiento de datos.
Java
3. Base de Datos
Donde se guarda toda la información (usuarios, posts, etc.).
SQLite (la más simple para empezar), MySQL, o PostgreSQL.

Consejo: Para una versión realmente primitiva y solo para la clase, puedes empezar con HTML, CSS y JavaScript, simulando la persistencia de datos con el almacenamiento local del navegador (localStorage) en lugar de una base de datos real. Esto simplifica mucho el proyecto, pero es menos robusto.

🛠️ Funcionalidades Mínimas Requeridas
Una red social primitiva debe tener al menos estas características básicas:
1. Sistema de Usuarios
Registro: Un formulario para que el usuario cree una cuenta (nombre de usuario y contraseña).
Inicio de Sesión: Un formulario para que el usuario acceda a su cuenta.
Perfil: Una página o sección donde se muestre la información del usuario (nombre, una pequeña biografía).
2. Creación y Visualización de Contenido
Crear un Post: Un campo de texto o formulario para escribir un mensaje.
Visualizar un Muro o Feed: Una lista donde se muestren los posts de todos los usuarios, ordenados cronológicamente.
3. Interacción Básica
Mostrar Autor y Fecha: Cada post debe indicar quién lo escribió y cuándo.

✅ Pasos Sugeridos para el Desarrollo
Diseño (Prototipo): Dibuja en papel cómo se verá la página de inicio, el perfil y el muro. Simplifica al máximo.
Estructura (HTML): Crea la estructura básica de las páginas (formularios, el feed, el navbar).
Estilo (CSS): Aplica un diseño sencillo para que sea legible y usable.
Backend y Base de Datos: Configura el entorno de programación que elegiste y crea las tablas básicas de tu base de datos (por ejemplo, Usuarios y Posts).
Lógica (Backend): Programa la lógica para:
Guardar un nuevo usuario en la base de datos.
Verificar el inicio de sesión.
Guardar un nuevo post.
Recuperar y mostrar todos los posts en el feed.


Plan de Persistencia de Datos con Java
Paso 1: Configurar el Proyecto Básico
Usaremos Spring Boot para configurar el servidor de manera rápida.
Generar el Proyecto: Ve a la web de Spring Initializr (puedes buscarlo en Google: Spring Initializr).
Seleccionar Dependencias Clave:
Lenguaje: Java
Proyecto: Maven (más común) o Gradle
Dependencias: Agrega las siguientes:
Spring Web: Para crear el servidor web.
Spring Data JPA: Para la persistencia de datos (el estándar de Java).
H2 Database: Es una base de datos en memoria que es ideal para pruebas y proyectos de clase, ya que no requiere instalación.
Descargar y Abrir: Descarga el proyecto (.zip) y ábrelo en tu IDE (como IntelliJ IDEA o VS Code).
Paso 2: Crear el Modelo de Datos (La Entidad)
Necesitas una clase en Java que represente un objeto que quieras guardar, por ejemplo, un Post o un Usuario. Usaremos el concepto de Entidad.
Crea una clase llamada Post.java:
Java
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // 1. Marca la clase como una tabla en la base de datos.
public class Post {
    
    @Id // 2. Indica que este es el campo clave (primary key).
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID único del post.

    private String autor; // Quién escribió el post.
    private String contenido; // El texto del post.

    // 3. ¡Muy importante! Necesitas un constructor vacío (sin argumentos)
    public Post() {}

    // Constructor para crear nuevos posts
    public Post(String autor, String contenido) {
        this.autor = autor;
        this.contenido = contenido;
    }

    // 4. Métodos Getters y Setters (para acceder a los datos)
    // ... (Tu IDE puede generarlos automáticamente, no los muestro por espacio)

    public Long getId() { return id; }
    public String getAutor() { return autor; }
    public String getContenido() { return contenido; }
    // ... y los setters
}

Paso 3: Crear la Conexión a la Base de Datos (El Repositorio)
Necesitas un componente que sepa cómo interactuar con la base de datos para guardar, buscar o eliminar instancias de tu entidad (Post). En Spring Boot, esto se llama Repositorio.
Crea una interfaz llamada PostRepository.java:
Java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Heredar de JpaRepository es la clave de la persistencia con Spring Data.
// El primer argumento es la Entidad (Post), y el segundo es el tipo de su ID (Long).
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
    // Spring te da automáticamente métodos como save(), findAll(), findById(), etc.
    
    // OPCIONAL: Puedes definir tus propios métodos de búsqueda.
    // Spring los implementa automáticamente. Ejemplo:
    // List<Post> findByAutor(String autor);
}

¡Listo! Con estos tres pasos, ya tienes configurada la persistencia de datos. El framework Spring Boot, a través de JpaRepository, ahora sabe cómo:
Crear la tabla Post en la base de datos.
Traducir un objeto Post de Java a una fila de la base de datos (save()).
Recuperar filas y convertirlas de nuevo a objetos Post de Java (findAll()).
El siguiente paso sería crear un Controlador (Controller) para exponer la funcionalidad a través de URLs (la API REST), permitiendo que tu frontend guarde y recupere posts.

🚀 Sistema de Nivel de Cuenta por Experiencia (XP)
El Nivel de Cuenta se define por los puntos de Experiencia (XP) acumulados.
I. Fórmulas de Experiencia (XP)
El usuario gana XP al realizar cualquier acción de valor.
Acción (Ganancia de XP)
XP por Unidad
Tipo de Enfoque que Premia
Publicar Contenido (Post, Foto, Video, Artículo)
+100 XP
Creación y Consistencia
Recibir un "Me Gusta"
+1 XP
Interacción Pasiva
Recibir un Comentario
+5 XP
Interacción Activa (Calidad)
Recibir un Compartido
+10 XP
Contenido Viral y Valioso
Participar en Tendencias (Usar un hashtag o audio viral)
+50 XP
Relevancia y Actualidad
Comentar/Interactuar con otro Post
+2 XP
Comunidad y Colaboración
Reportar Contenido Inapropiado (y ser validado)
+20 XP
Seguridad y Moderación
Sesión Diaria de 5 minutos (máx. 1 vez al día)
+10 XP
Fidelidad y Hábito
Completar un Logro (Ver sección III)
XP Variable (1K a 5K XP)
Hitos Específicos


II. Requisitos de Nivel (Ejemplo de Progresión)
Nivel
Nombre Sugerido
XP Acumulada Necesaria (Ejemplo)
Desbloqueo de Beneficios
1
El Novato
0 XP
Funcionalidades Básicas
10
Explorador
1,500 XP
Insignia Especial, Mejores Filtros
25
Colaborador
7,500 XP
Mayor Alcance de Publicaciones
50
Creador de Élite
30,000 XP
Prioridad en Tendencias, Soporte VIP
75
Maestro de Contenido
75,000 XP
Acceso a Estadísticas Premium
100
Leyenda de la Red
150,000 XP
Perfil Destacado, Reconocimiento Global


III. Hitos y Logros ("Misiones")
Para garantizar que el nivel refleje la calidad (y no solo la actividad simple), algunos logros o "Misiones" deben ser necesarios para avanzar a ciertos niveles, además de la XP. Estos logros se agrupan en categorías:
1. Misiones de Interacción y Comunidad
Logro
Requisito
Recompensa XP
Embajador Social
Invitar y conseguir que 5 amigos se unan a la red.
1,000 XP
Colaborador Frecuente
Realizar una colaboración (co-post) con 3 cuentas diferentes.
2,000 XP
Moderador Activo
Tener una conversación activa con un seguidor en los comentarios por más de 10 turnos.
500 XP
Respondedor VIP
Responder al 90% de los comentarios recibidos en una semana.
1,500 XP
Detector de Preguntas
Utilizar la herramienta de Preguntas/Encuestas en 10 publicaciones seguidas.
1,200 XP

2. Misiones de Consistencia y Calidad
Logro
Requisito
Recompensa XP
Racha de Publicación
Publicar al menos una vez al día durante 7 días consecutivos.
800 XP
Historiador Digital
Superar 100 publicaciones totales en el perfil.
2,500 XP
Contenido Visual
Publicar 25 fotos/videos con una calidad de imagen alta (detectada por IA).
3,000 XP
Lector de Biografía
El enlace en tu biografía es clicado por 100 usuarios únicos.
1,800 XP
Dominio de Formato
Crear 10 publicaciones usando un formato avanzado (Ej: Carrusel de 5+ fotos o Video de 2+ minutos).
2,200 XP

3. Misiones de Impacto (Viralidad de Calidad)
Logro
Requisito
Recompensa XP
El Viral
Una publicación recibe más de 500 Compartidos.
5,000 XP
Público Fiel
El 60% de tus "Me Gusta" recientes proviene de usuarios Nivel 25+.
4,500 XP
Salvador de Contenido
Una publicación es "Guardada" por 1,000 usuarios únicos.
4,000 XP
El Debate
Una publicación genera más de 100 comentarios variados (no solo emojis).
3,500 XP
Trendsetter
Publicar un contenido que otro usuario Nivel 50+ re-publique o mencione.
4,800 XP


Este sistema asegura que para alcanzar un Nivel alto (ej. Nivel 50) un usuario no solo necesita muchos "Me Gusta" (XP), sino también haber cumplido misiones específicas que demuestran su habilidad para construir comunidad, crear contenido de calidad y mantener una actividad constante.


1. Funcionalidades principales (lo que los usuarios pueden hacer)

🧍‍♂️ 1.1. Sistema de usuarios

Registro y autenticación (email/contraseña o redes sociales).

Perfil personal con:

Foto de perfil y portada.

Descripción o biografía.

Nivel y logros visibles.

Contador de seguidores o amigos.

Configuración de privacidad (público / privado).

🗣️ 1.2. Publicaciones y contenido

Creación de publicaciones con texto, imágenes, vídeos o enlaces.

Posibilidad de reaccionar (like, me encanta, etc.).

Sistema de comentarios y respuestas.

Opción de compartir o guardar publicaciones.

📈 1.3. Sistema de niveles y logros

Cada acción (publicar, recibir likes, comentar) otorga puntos de experiencia (XP).

Subida de nivel al alcanzar ciertos puntos.

Logros desbloqueables (por ejemplo: “Primer post”, “100 likes”, “Contribuidor nivel 10”).

Clasificación de usuarios (ranking semanal o global).

Recompensas visuales: medallas, insignias o efectos especiales en el perfil.

🧩 1.4. Secciones temáticas

Distintas comunidades o categorías de contenido.

Filtros por nivel del usuario (solo los de mayor nivel pueden publicar en ciertas secciones).

Valoración de publicaciones por calidad o relevancia.

🔔 1.5. Interacción social

Sistema de notificaciones (likes, comentarios, logros desbloqueados).

Seguimiento de usuarios y feed personalizado.

Mensajería privada o chat.

Sugerencias de amistad o contenido recomendado.

4. Otras funciones útiles o futuras

Modo administrador: gestión de usuarios, denuncias o publicaciones inapropiadas.

Modo competitivo: eventos, misiones o retos semanales.

Integración con IA: recomendaciones personalizadas o moderación automática.

App móvil completa (usando el mismo backend).

SISTEMA GESTION NIVELES EXPERIENCIA
🧠 1️⃣ Concepto del Sistema de Experiencia en LEVELY

En LEVELY, cada usuario tiene:

Puntos de experiencia (XP): representan su actividad y participación.

Nivel: refleja su progreso dentro de la comunidad.

Logros: hitos específicos que otorgan XP adicional.

📈 A medida que los usuarios interactúan, comparten o reciben reconocimiento, acumulan XP y suben de nivel, lo que desbloquea beneficios o estatus.

⚙️ 2️⃣ Cómo se gana XP

Cada acción dentro de la red otorga una cantidad de XP predefinida.
Estas acciones están agrupadas en categorías de interacción.

Categoría	Acción	XP Otorgada	Límite Diario	Comentario
📝 Publicaciones	Crear un post	+15 XP	5 veces/día	Fomenta contenido original
💬 Comentarios	Comentar en un post	+5 XP	20 veces/día	Participación activa
❤️ Likes recibidos	Otro usuario da like a tu post	+2 XP	Sin límite	Refuerza la calidad
💎 Likes dados	Dar like a un post	+1 XP	50 veces/día	Fomenta interacción
🔁 Compartir post	Compartir contenido de otro usuario	+3 XP	10 veces/día	Fomenta difusión
🌟 Logro desbloqueado	Completar un logro	Variable (25–200 XP)	-	Recompensas especiales
🧭 Misión completada	Completar misión semanal	Variable (50–500 XP)	-	Gamificación avanzada
🧱 Publicación en tendencia	Post entra al top de tendencias	+100 XP	-	Reconocimiento global
⏰ Racha diaria	Publicar varios días seguidos	+20 XP	1/día	Fomenta constancia
📊 3️⃣ Curva de progresión de niveles

La progresión de niveles debe ser no lineal, es decir, cada nivel requiere más XP que el anterior (como en los juegos o foros gamificados).
