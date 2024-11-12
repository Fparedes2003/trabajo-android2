package fabian.stomas.aplicacion4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    private ArrayList<Avance> avanceList;

    public MyAdapter2(ArrayList<Avance> avanceList){
        this.avanceList = avanceList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_avances, parent, false);
        return new MyViewHolder(view);
    }
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        Avance avance = avanceList.get(position);
        holder.titleTextView.setText(avance.getTitulo());
        holder.descirptionTextView.setText(avance.getDescripcion());
        holder.fechaTextView.setText(avance.getFecha_avancedb());
        holder.nombreUsuarioTextView.setText(avance.getNombreUsuariodb());

    }
    @Override
    public int getItemCount(){
        return avanceList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;
        TextView descirptionTextView;
        TextView fechaTextView;
        TextView nombreUsuarioTextView;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titulo);
            descirptionTextView = itemView.findViewById(R.id.descripcion);
            fechaTextView = itemView.findViewById(R.id.fecha);
            nombreUsuarioTextView = itemView.findViewById(R.id.nombre_usuario);
        }
    }
}
