import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Achievements.Repositories.NoteRepository

class NoteProvider(val repository: NoteRepository) {


suspend fun GetAllNotes() : MutableList<ItemData> {
    return repository.GetNotes()
}



}