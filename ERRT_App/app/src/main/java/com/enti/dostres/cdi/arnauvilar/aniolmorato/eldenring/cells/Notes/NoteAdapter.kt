import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.R

class NoteAdapter(private val noteList: List<ItemData>) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(layoutInflater.inflate(R.layout.achievement_cell, parent, false))
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.SetupWith(noteList[position])
    }
}