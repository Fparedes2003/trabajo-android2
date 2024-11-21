package fabian.stomas.aplicacion4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter4 extends RecyclerView.Adapter<MyAdapter4.MyViewHolder> {
    private ArrayList<Solicitudes> items;
    private View.OnClickListener onClickListener;
    public MyAdapter4(ArrayList<Solicitudes> items) {this.items = items;}
    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_solicitudes, parent, false);
        view.setOnClickListener(onClickListener);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        Solicitudes solicitudes = items.get(position);
        holder.nombreRemitente.setText(solicitudes.getNombreRemitente());
        holder.apellidoRemitente.setText(solicitudes.getApellidoRemitente());
        holder.correoRemitente.setText(solicitudes.CorreoRemitente);
        holder.estado.setText(solicitudes.getEstado());
    }
    @Override
    public int getItemCount() {return items.size();}

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nombreRemitente;
        TextView apellidoRemitente;
        TextView correoRemitente;
        TextView estado;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            nombreRemitente = itemView.findViewById(R.id.nombreRemitente);
            apellidoRemitente = itemView.findViewById(R.id.apellidoRemitente);
            correoRemitente = itemView.findViewById(R.id.correoRemitente);
            estado = itemView.findViewById(R.id.estado);
        }
    }


























}
