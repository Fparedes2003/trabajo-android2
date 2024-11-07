package fabian.stomas.aplicacion4;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "studyhub.db";

    private static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String createTable = "CREATE TABLE usuario(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Nombre TEXT NOT NULL, Apellido TEXT NOT NULL, Telefono TEXT NOT NULL UNIQUE," +
                "Correo TEXT NOT NULL UNIQUE, Password TEXT NOT NULL)";
        db.execSQL(createTable);
        String create_canales = "CREATE TABLE canales(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Nombre TEXT NOT NULL, Descripcion TEXT, Tipo_canal INTEGER," +
                "Admin_ID INTEGER," +
                "Tarea_ID INTEGER," +
                "FOREIGN KEY (Tipo_canal) REFERENCES tipo_canales(ID)," +
                "FOREIGN KEY (Admin_ID) REFERENCES usuario(ID)," +
                "FOREIGN KEY (Tarea_ID) REFERENCES tareas(ID))";
        db.execSQL(create_canales);
        String create_amigos = "CREATE TABLE amigos(id_usuario INTEGER," +
                "id_amigo INTEGER," +
                "PRIMARY KEY (id_usuario, id_amigo)," +
                "FOREIGN KEY (id_usuario) REFERENCES usuario(ID)," +
                "FOREIGN KEY (id_amigo) REFERENCES usuario(ID))";
        db.execSQL(create_amigos);
        String create_usuarios_canales = "CREATE TABLE usuarios_canales(id_usuario INTEGER," +
                "id_canal INTEGER," +
                "PRIMARY KEY (id_usuario, id_canal)," +
                "FOREIGN KEY (id_usuario) REFERENCES usuario(ID)," +
                "FOREIGN KEY (id_canal) REFERENCES canales(ID))";
        db.execSQL(create_usuarios_canales);
        String create_tipo_canales = "CREATE TABLE tipo_canales(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT)";
        db.execSQL(create_tipo_canales);
        String create_apuntes = "CREATE TABLE apuntes(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Titulo TEXT NOT NULL," +
                "Contenido TEXT," +
                "Fecha_creacion DATETIME," +
                "Fecha_modificacion DATETIME," +
                "id_propietario INTEGER," +
                "FOREIGN KEY (id_propietario) REFERENCES usuario(ID))";
        db.execSQL(create_apuntes);
        String create_canales_apuntes = "CREATE TABLE canales_apuntes(id_apunte INTEGER," +
                "id_canal INTEGER," +
                "PRIMARY KEY(id_apunte, id_canal)," +
                "FOREIGN KEY (id_apunte) REFERENCES apuntes(ID)," +
                "FOREIGN KEY (id_canal) REFERENCES canales(ID))";
        db.execSQL(create_canales_apuntes);
        String create_avances = "CREATE TABLE avances(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Titulo TEXT NOT NULL," +
                "Descripcion TEXT NOT NULL," +
                "Fecha_avance DATETIME," +
                "id_usuario INTEGER," +
                "id_canal INTEGER," +
                "FOREIGN KEY (id_usuario) REFERENCES usuario(ID)," +
                "FOREIGN KEY (id_canal) REFERENCES canales(ID))";
        db.execSQL(create_avances);
        String create_tareas = "CREATE TABLE tareas(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Titulo TEXT NOT NULL," +
                "Descripcion TEXT NOT NULL," +
                "Estado TEXT NOT NULL," +
                "Fecha_expiracion DATETIME)";
        db.execSQL(create_tareas);
        String create_solicitudes = "CREATE TABLE solicitudes(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Estado TEXT NOT NULL," +
                "id_remitente INTEGER," +
                "id_receptor INTEGER," +
                "FOREIGN KEY (id_remitente) REFERENCES usuario(ID)," +
                "FOREIGN KEY (id_receptor) REFERENCES usuario(ID))";
        db.execSQL(create_solicitudes);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS usuario");
        db.execSQL("DROP TABLE IF EXISTS canales");
        db.execSQL("DROP TABLE IF EXISTS amigos");
        db.execSQL("DROP TABLE IF EXISTS usuarios_canales");
        db.execSQL("DROP TABLE IF EXISTS tipo_canales");
        db.execSQL("DROP TABLE IF EXISTS apuntes");
        db.execSQL("DROP TABLE IF EXISTS canales_apuntes");
        db.execSQL("DROP TABLE IF EXISTS avances");
        db.execSQL("DROP TABLE IF EXISTS tareas");
        db.execSQL("DROP TABLE IF EXISTS solicitudes");
        onCreate(db);
    }


}
