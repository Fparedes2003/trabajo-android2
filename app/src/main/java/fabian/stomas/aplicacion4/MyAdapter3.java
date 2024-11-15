package fabian.stomas.aplicacion4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder> {
    private ArrayList<Usuario> items;
    private ArrayList<Usuario> listaBusq;
    private View.OnClickListener onClickListener;

    public MyAdapter3(ArrayList<Usuario> items) {
        this.items = items;
        listaBusq = new ArrayList<>();
        listaBusq.addAll(items);
    }

    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_usuarios, parent, false);
        view.setOnClickListener(onClickListener);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        Usuario usuario = items.get(position);
        holder.correoTextView.setText(usuario.getCorreo());
        holder.nombreTextView.setText(usuario.getNombre());
        holder.apellidoTextView.setText(usuario.getApellido());

    }
    public void filtrado(final String txtBuscar){
        int longitud = txtBuscar.length();
        if(longitud == 0){
            items.clear();
            items.addAll(listaBusq);
        }else{
            List<Usuario> colleccion = items.stream().filter(i -> i.getNombre().toLowerCase().contains(txtBuscar.toLowerCase())).collect(Collectors.toList());
            items.clear();
            items.addAll(colleccion);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){return items.size();}

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView correoTextView;
        TextView nombreTextView;
        TextView apellidoTextView;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            correoTextView = itemView.findViewById(R.id.descripcionCorreo);
            nombreTextView = itemView.findViewById(R.id.nombre_usuario);
            apellidoTextView = itemView.findViewById(R.id.apellido_usuario);
        }
    }


}
