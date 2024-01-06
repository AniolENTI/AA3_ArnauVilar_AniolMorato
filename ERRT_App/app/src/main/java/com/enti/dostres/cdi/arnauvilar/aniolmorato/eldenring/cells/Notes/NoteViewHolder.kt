import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.R

class NoteViewHolder(view: View) : ViewHolder(view) {
    val name by lazy {view.findViewById<TextView>(R.id.achievement_cell_title)}
    val description by lazy {view.findViewById<TextView>(R.id.achievement_cell_description)}

    fun SetupWith(note: ItemData) {
        name.text = note.name
        description.text = note.description
    }
}