import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.R

class AchievementViewHolder(view: View) : ViewHolder(view) {
    val name by lazy {view.findViewById<TextView>(R.id.achievement_cell_title)}
    val description by lazy {view.findViewById<TextView>(R.id.achievement_cell_description)}

    fun SetupWith(achievement: ItemData) {
        name.text = achievement.name
        description.text = achievement.description
    }
}