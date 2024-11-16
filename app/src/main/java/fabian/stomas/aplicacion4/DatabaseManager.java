package fabian.stomas.aplicacion4;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.Sampler;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DatabaseManager {
    private MyDatabaseHelper dbHelper;
    public DatabaseManager(Context context){
        dbHelper = new MyDatabaseHelper(context);
    }

    public void insertUsuario(Usuario usuario){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", usuario.getNombre());
        values.put("apellido", usuario.getApellido());
        values.put("telefono", usuario.getTelefono());
        values.put("correo", usuario.getCorreo());
        values.put("password", usuario.getPassword());
        db.insert("usuario", null, values);
        db.close();
    }
    public void updateEmailUsuario(String newEmail, String passwordActual, String emailActual){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Correo", newEmail);
        db.update("usuario", values, "Password = ? AND Correo = ?", new String[]{passwordActual, emailActual});
        db.close();
    }
    public void updatePassUsuario(String passwordActual, String newPassword){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Password", newPassword);
        db.update("usuario", values, "Password = ?", new String[]{passwordActual});
        db.close();
    }
    public void updateEstadoTarea(int idTarea){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Estado", "Terminada");
        db.update("tareas", values, "ID = ?", new String[]{String.valueOf(idTarea)});
        db.close();
    }
    public void updateCanalTarea_ID(int idCanal, int Tarea_id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Tarea_ID", Tarea_id);
        db.update("canales", values, "ID = ?", new String[]{String.valueOf(idCanal)});
        db.close();
    }
    public void updateEstadoSolicitudAceptada(int id_solicitud){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Estado", "ACEPTADA");
        db.update("solicitudes", values, "ID = ?", new String[]{String.valueOf(id_solicitud)});
        db.close();
    }
    public void updateEstadoSolicitudRechazada(int id_solicitud){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Estado", "RECHAZADA");
        db.update("solicitudes", values, "ID = ?", new String[]{String.valueOf(id_solicitud)});
        db.close();
    }
    public int insertCanal(Canal canal){
        int id_canal = 0;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Nombre", canal.getNombre());
        values.put("Descripcion", canal.getDescripcion());
        values.put("Tipo_canal", canal.getTipo_canal());
        values.put("Admin_ID", canal.getAdmin());
        db.insert("canales", null, values);
        dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT ID FROM canales ORDER BY ID DESC LIMIT 1", null);
        if(cursor.moveToFirst()){
            id_canal = cursor.getInt(0);
        }
        cursor.close();
        db.close();
        return id_canal;
    }
    public void insertAvance(Avance avance){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Titulo", avance.getTitulo());
        values.put("Descripcion", avance.getDescripcion());
        values.put("Fecha_avance", avance.getFecha_avancedb());
        values.put("id_usuario", avance.getId_usuario());
        values.put("id_canal", avance.getId_canal());
        db.insert("avances", null, values);
        db.close();
    }
    public int insertTarea(Tarea tarea){
        int id_tarea = 0;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Titulo", tarea.getTitulo());
        values.put("Descripcion", tarea.getDescripcion());
        values.put("Estado", tarea.getEstado());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Fecha_expiracion = formatter.format(tarea.getFecha_expiracion());
        values.put("Fecha_expiracion", Fecha_expiracion);
        db.insert("tareas", null, values);
        dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT ID FROM tareas ORDER BY ID DESC LIMIT 1", null);
        if(cursor.moveToFirst()){
            id_tarea = cursor.getInt(0);
        }
        cursor.close();
        db.close();
        return id_tarea;
    }
    public void insertTipoCanal(Tipo_canal tipo_canal){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Nombre", tipo_canal.getNombre());
        db.insert("tipo_canales", null, values);
        db.close();
    }
    public void insertUsuarios_canales(UsuariosCanales usuariosCanales){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_usuario", usuariosCanales.getId_usuario());
        values.put("id_canal", usuariosCanales.getId_canal());
        db.insert("usuarios_canales", null, values);
        db.close();
    }
    public void insertAmigos(Amigos amigos){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_usuario", amigos.getId_usuario());
        values.put("id_amigo", amigos.getId_amigo());
        db.insert("amigos", null, values);
        db.close();
    }
    public void insertSolicitud(Solicitudes solicitudes){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Estado", solicitudes.getEstado());
        values.put("id_remitente", solicitudes.getId_remitente());
        values.put("id_receptor", solicitudes.getId_receptor());
        db.insert("solicitudes", null, values);
        db.close();
    }
    public void deleteAmigo(int id_usuario, int id_amigo){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("amigos", "id_usuario = ? AND id_amigo = ?", new String[]{String.valueOf(id_usuario), String.valueOf(id_amigo)});
        db.close();
    }
    public ArrayList<Usuario> getAllUsuarios(){
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM usuario", null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String nombre = cursor.getString(1);
                String apellido = cursor.getString(2);
                String telefono = cursor.getString(3);
                String correo = cursor.getString(4);
                String password = cursor.getString(5);
                Usuario usuario = new Usuario(id, nombre, apellido, telefono, correo, password);
                listaUsuarios.add(usuario);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaUsuarios;
    }
    public ArrayList<Solicitudes> getAllSolicitudes(){
        ArrayList<Solicitudes> listaSolicitudes = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM solicitudes", null);
        if(cursor.moveToFirst()){
            do{
                int ID = cursor.getInt(0);
                String Estado = cursor.getString(1);
                int id_remitente = cursor.getInt(2);
                int id_receptor = cursor.getInt(3);
                Solicitudes solicitud = new Solicitudes(ID, Estado, id_remitente, id_receptor);
                listaSolicitudes.add(solicitud);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaSolicitudes;
    }
    public ArrayList<Solicitudes> getSolicitudesDelUsuario(int id_receptor){
        ArrayList<Solicitudes> listaSolicitudesDeUsuario = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT solicitudes.ID, solicitudes.id_remitente, usuario.Nombre, usuario.Apellido, usuario.Correo, solicitudes.Estado FROM solicitudes " +
                "INNER JOIN usuario ON usuario.ID = solicitudes.id_remitente " +
                "WHERE solicitudes.id_receptor = ? AND solicitudes.Estado = 'PENDIENTE'", new String[]{String.valueOf(id_receptor)});
        if(cursor.moveToFirst()){
            do{
                int ID = cursor.getInt(0);
                int id_remitente = cursor.getInt(1);
                String NombreRemitente = cursor.getString(2);
                String ApellidoRemitente = cursor.getString(3);
                String CorreoRemitente = cursor.getString(4);
                String Estado = cursor.getString(5);
                Solicitudes solicitudes = new Solicitudes(ID, id_remitente, NombreRemitente, ApellidoRemitente, CorreoRemitente, Estado);
                listaSolicitudesDeUsuario.add(solicitudes);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaSolicitudesDeUsuario;
    }
    public Solicitudes getSolicitudVerificacion(int id_remitente, int id_receptor){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM solicitudes WHERE id_remitente = ? AND id_receptor = ? AND Estado = 'PENDIENTE'", new String[]{String.valueOf(id_remitente), String.valueOf(id_receptor)});
        if(cursor != null && cursor.moveToFirst()){
            int ID = cursor.getInt(0);
            String Estado = cursor.getString(1);
            int id_remit = cursor.getInt(2);
            int id_recep = cursor.getInt(3);
            Solicitudes solicitud = new Solicitudes(ID, Estado, id_remit, id_recep);
            cursor.close();
            db.close();
            return solicitud;
        }
        cursor.close();
        db.close();
        return null;
    }
    public ArrayList<Amigos> getAllAmigos(){
        ArrayList<Amigos> listaAmigos = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM amigos", null);
        if(cursor.moveToFirst()){
            do{
                int id_usuario = cursor.getInt(0);
                int id_amigo = cursor.getInt(1);
                Amigos amigos = new Amigos(id_usuario, id_amigo);
                listaAmigos.add(amigos);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaAmigos;

    }
    public Amigos getAmigos(int id_usuario, int id_amigos){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id_usuario, id_amigo FROM amigos WHERE id_usuario = ? AND id_amigo = ?", new String[]{String.valueOf(id_usuario), String.valueOf(id_amigos)});
        if(cursor != null && cursor.moveToFirst()){
            int id_user = cursor.getInt(0);
            int id_friend = cursor.getInt(1);
            Amigos amigo = new Amigos(id_user, id_friend);
            cursor.close();
            db.close();
            return amigo;
        }
        cursor.close();
        db.close();
        return null;
    }
    public ArrayList<Usuario> getAmigosDelUsuario(int id_usuario){
        ArrayList<Usuario> listaAmigos = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT usuario.Nombre, usuario.Apellido, usuario.Correo, amigos.id_amigo FROM usuario " +
                "INNER JOIN amigos ON amigos.id_amigo = usuario.ID WHERE amigos.id_usuario = ?", new String[]{String.valueOf(id_usuario)});
        if(cursor.moveToFirst()){
            do{
                String amigoNombre = cursor.getString(0);
                String amigoApellido = cursor.getString(1);
                String amigoCorreo = cursor.getString(2);
                int id_amigo = cursor.getInt(3);
                Usuario usuario = new Usuario(amigoNombre, amigoApellido, amigoCorreo, id_amigo);
                listaAmigos.add(usuario);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaAmigos;
    }
    public ArrayList<Canal> getAllCanalesDelUsuario(int usuario_id){
        ArrayList<Canal> listaCanalesDelUsuario = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT canales.ID, canales.Nombre, canales.Descripcion, tipo_canales.Nombre, canales.Tarea_ID FROM canales " +
                "INNER JOIN usuarios_canales ON canales.ID = usuarios_canales.id_canal " +
                "INNER JOIN usuario ON usuario.ID = usuarios_canales.id_usuario " +
                "INNER JOIN tipo_canales ON tipo_canales.ID = canales.Tipo_canal WHERE usuarios_canales.id_usuario = ?", new String[]{String.valueOf(usuario_id)});
        if(cursor.moveToFirst()){
            do{
                int ID = cursor.getInt(0);
                String Nombre = cursor.getString(1);
                String Descripcion = cursor.getString(2);
                String Tipo_canal = cursor.getString(3);
                int Tarea_ID = cursor.getInt(4);
                Canal canal = new Canal(ID, Nombre, Descripcion, Tipo_canal, Tarea_ID);
                listaCanalesDelUsuario.add(canal);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaCanalesDelUsuario;
    }
    public ArrayList<Tipo_canal> getAllTipoCanales(){
        ArrayList<Tipo_canal> listaTipoCanales = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tipo_canales", null);
        if(cursor.moveToFirst()){
            do{
                int ID = cursor.getInt(0);
                String Nombre = cursor.getString(1);
                Tipo_canal tipo_canal = new Tipo_canal(ID, Nombre);
                listaTipoCanales.add(tipo_canal);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaTipoCanales;
    }
    public ArrayList<Tarea> getAllTareas(){
        ArrayList<Tarea> listaTareas = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tareas", null);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(cursor.moveToFirst()){
            do{
                int ID = cursor.getInt(0);
                String Titulo = cursor.getString(1);
                String Descripcion = cursor.getString(2);
                String Estado = cursor.getString(3);
                String Fecha_expiracion = cursor.getString(4);
                Date Fecha_expiracion2 = null;
                try{
                    Fecha_expiracion2 = formatter.parse(Fecha_expiracion);
                }catch (Exception e){

                }
                Tarea tarea = new Tarea(ID, Titulo, Descripcion, Estado, Fecha_expiracion2);
                listaTareas.add(tarea);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaTareas;
    }
    public Tarea getTareaDelCanal(int idTarea){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT tareas.Titulo, tareas.Descripcion, tareas.Estado, tareas.Fecha_expiracion FROM tareas " +
                "INNER JOIN canales ON canales.Tarea_ID = tareas.ID " +
                "WHERE canales.Tarea_ID = ?", new String[]{String.valueOf(idTarea)});
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(cursor != null && cursor.moveToFirst()){
            String Titulo = cursor.getString(0);
            String Descripcion = cursor.getString(1);
            String Estado = cursor.getString(2);
            String Fecha_expiracion = cursor.getString(3);
            Date Fecha_expiracion2 = null;
            try{
                Fecha_expiracion2 = formatter.parse(Fecha_expiracion);
            }catch (Exception e){

            }
            Tarea tarea = new Tarea(Titulo, Descripcion, Estado, Fecha_expiracion2);
            cursor.close();
            db.close();
            return tarea;
        }
        cursor.close();
        db.close();
        return null;
    }
    public ArrayList<Avance> getAvancesDelCanal(int canal_id){
        ArrayList<Avance> listaAvancesDelCanal = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT avances.Titulo, avances.Descripcion, avances.Fecha_avance, usuario.Nombre, usuario.Apellido FROM avances " +
                "INNER JOIN usuario ON usuario.ID = avances.id_usuario " +
                "INNER JOIN canales ON canales.ID = avances.id_canal " +
                "WHERE canales.id = ?", new String[]{String.valueOf(canal_id)});
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(cursor.moveToFirst()){
            do{
                String Tiulo = cursor.getString(0);
                String Descripcion = cursor.getString(1);
                String Fecha_avance = cursor.getString(2);
                String nombreUsuariodb = cursor.getString(3);
                String apellidoUsuariodb = cursor.getString(4);
                Date Fecha_avance2 = null;
                try{
                    Fecha_avance2 = formatter.parse(Fecha_avance);
                }catch (Exception e){

                }
                Avance avance = new Avance(Tiulo, Descripcion, Fecha_avance2, nombreUsuariodb, apellidoUsuariodb);
                listaAvancesDelCanal.add(avance);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaAvancesDelCanal;
    }
    public Usuario getUsuarioByPassEmail(String correo, String password){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuario WHERE correo = ? AND password = ?", new String[]{correo, password});
        if(cursor != null && cursor.moveToFirst()){
            int id = cursor.getInt(0);
            String nombre = cursor.getString(1);
            String apellido = cursor.getString(2);
            String telefono = cursor.getString(3);
            String email = cursor.getString(4);
            String passwordUsuario = cursor.getString(5);
            Usuario usuario = new Usuario(id, nombre, apellido, telefono, email, passwordUsuario);
            cursor.close();
            db.close();
            return usuario;
        }
        cursor.close();
        db.close();
        return null;
    }
    public ArrayList<Canal> getAllCanales(){
        ArrayList<Canal> listaCanales = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM canales", null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String nombre = cursor.getString(1);
                String descripcion = cursor.getString(2);
                int tipo_canal = cursor.getInt(3);
                int Admin_ID = cursor.getInt(4);
                int Tarea_ID = cursor.getInt(5);
                Canal canal = new Canal(id, nombre, descripcion, tipo_canal, Admin_ID, Tarea_ID);
                listaCanales.add(canal);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaCanales;
    }
    public ArrayList<Avance> getAllAvances(){
        ArrayList<Avance> listaAvances = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM avances", null);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(cursor.moveToFirst()){
            do{
                int ID = cursor.getInt(0);
                String Titulo = cursor.getString(1);
                String Descripcion = cursor.getString(2);
                String Fecha_avance = cursor.getString(3);
                Date Fecha_avance2 = null;
                int id_usuario = cursor.getInt(4);
                int id_canal = cursor.getInt(5);
                try{
                    Fecha_avance2 = formatter.parse(Fecha_avance);
                }catch (Exception e){

                }
                Avance avance = new Avance(ID, Titulo, Descripcion, Fecha_avance2, id_usuario, id_canal);
                listaAvances.add(avance);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaAvances;
    }
    public ArrayList<UsuariosCanales> getAllUsuarios_canales(){
        ArrayList<UsuariosCanales> listaUsuarios_canales = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios_canales", null);
        if(cursor.moveToFirst()){
            do{
                int id_usuario = cursor.getInt(0);
                int id_canal = cursor.getInt(1);
                UsuariosCanales usuarioCanal = new UsuariosCanales(id_usuario, id_canal);
                listaUsuarios_canales.add(usuarioCanal);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaUsuarios_canales;
    }
    public ArrayList<String> getTableNames(SQLiteDatabase db) {
        ArrayList<String> tableNames = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        if (cursor.moveToFirst()) {
            do {
                tableNames.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return tableNames;
    }
    public ArrayList<String> getColumnNames(SQLiteDatabase db, String tableName) {
        ArrayList<String> columnNames = new ArrayList<>();
        Cursor cursor = db.rawQuery("PRAGMA table_info(" + tableName + ")", null);
        if (cursor.moveToFirst()) {
            do {
                columnNames.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return columnNames;
    }
    public void printDatabaseInfo() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<String> tableNames = getTableNames(db);
        for (String tableName : tableNames) {
            System.out.println("Table: " + tableName);
            ArrayList<String> columnNames = getColumnNames(db, tableName);
            for (String columnName : columnNames) {
                System.out.println("  Column: " + columnName);
            }
        }
        db.close();
    }
}