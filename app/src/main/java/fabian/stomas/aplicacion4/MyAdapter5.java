package fabian.stomas.aplicacion4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter5 extends RecyclerView.Adapter<MyAdapter5.MyViewHolder> {

    private ArrayList<Apuntes> itemList;
    private View.OnClickListener onClickListener;

    public MyAdapter5(ArrayList<Apuntes> itemList){this.itemList = itemList;}
    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_apuntes, parent, false);
        view.setOnClickListener(onClickListener);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        Apuntes apuntes = itemList.get(position);
        holder.fecha_apunte.setText(apuntes.getFecha_creaciondb());
        holder.nombreUsuario.setText(apuntes.getUsuarioNombre());
        holder.apellidoUsuario.setText(apuntes.getUsuarioApellido());
        holder.titulo_apunte.setText(apuntes.getTitulo());
        holder.contenidoDelApunte.setText(apuntes.getContenido());
    }
    @Override
    public int getItemCount(){return itemList.size();}

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView fecha_apunte;
        TextView nombreUsuario;
        TextView apellidoUsuario;
        TextView titulo_apunte;
        TextView contenidoDelApunte;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            fecha_apunte = itemView.findViewById(R.id.fecha_apunte);
            nombreUsuario = itemView.findViewById(R.id.nombreUsuario);
            apellidoUsuario = itemView.findViewById(R.id.apellidoUsuario);
            titulo_apunte = itemView.findViewById(R.id.titulo_apunte);
            contenidoDelApunte = itemView.findViewById(R.id.contenidoDelApunte);
        }
    }






}
