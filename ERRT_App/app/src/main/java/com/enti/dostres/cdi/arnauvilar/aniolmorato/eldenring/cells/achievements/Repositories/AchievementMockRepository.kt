
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.achievements.Repositories.AchievementData
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.achievements.Repositories.AchievementRepository

class AchievementMockRepository: AchievementRepository {
    companion object {

        private val achievementsListHardcoded = mutableListOf(
            AchievementData(name = "ELDEN RING", image = "", description = "Obtain all trophies"),
            AchievementData(name = "ELDEN LORD", image = "", description = "Achieve the \"Elden Lord\" ending"),
            AchievementData(name = "AGE OF THE STARS", image = "", description = "Achieve the \"Age of the Stars\" ending"),
            AchievementData(name = "LORD OF FRENZIED FLAME", image = "", description = "Achieve the \"Lord of Frenzied Flame\" ending [Endings]"),
            AchievementData(name = "ELSHARDBEARER GODRICKDEN", image = "", description = "Defeat Shardbearer Godrick"),
            AchievementData(name = "SHARDBEARER RADAHN", image = "", description = "Defeat Shardbearer Radahn"),
            AchievementData(name = "SHARDBEARER MORGOTT", image = "", description = "Defeat Shardbearer Morgott"),
            AchievementData(name = "SHARDBEARER RYKARD", image = "", description = "Defeat Shardbearer Rykard"),
            AchievementData(name = "SHARDBEARER MALENIA", image = "", description = "Defeat Shardbearer Malenia"),
            AchievementData(name = "SHARDBEARER MOHG", image = "", description = "Defeat Shardbearer Mohg"),
            AchievementData(name = "MALIKETH THE BLACK BLADE", image = "", description = "Defeat Maliketh the Black Blade"),
            AchievementData(name = "HOARAH LOUX THE WARRIOR", image = "", description = "Defeat Hoarah Loux the Warrior"),
            AchievementData(name = "DRAGONLORD PLACIDUSAX", image = "", description = "Defeat Dragonlord Placidusax"),
            AchievementData(name = "GOD-SLAYING ARMAMENT", image = "", description = "Upgrade any armament to its highest stage [Upgrades]"),
            AchievementData(name = "LEGENDARY ARMAMENTS", image = "", description = "Obtain"),
            AchievementData(name = "LEGENDARY ASHEN REMAINS", image = "", description = "Obtain"),
            AchievementData(name = "LEGENDARY SORCERIES AND INCANTATIONS", image = "", description = "Obtain"),
            AchievementData(name = "LEGENDARY TALISMANS", image = "", description = "Obtain"),
            AchievementData(name = "RENNALA, QUEEN OF THE FULL MOON", image = "", description = "Defeat Rennala, Queen of the Full Moon"),
            AchievementData(name = "LICHDRAGON FORTISSAX", image = "", description = "Defeat Lichdragon Fortissax"),
            AchievementData(name = "GODSKIN DUO", image = "", description = "Defeat the Godskin Duo"),
            AchievementData(name = "FIRE GIANT", image = "", description = "Defeat the Fire Giant"),
            AchievementData(name = "DRAGONKIN SOLDIER OF NOKSTELLA", image = "", description = "Defeat Dragonkin Soldier of Nokstella"),
            AchievementData(name = "REGAL ANCESTOR SPIRIT", image = "", description = "Defeat Regal Ancestor Spirit"),
            AchievementData(name = "VALIANT GARGOYLE", image = "", description = "Defeat Valiant Gargoyle"),
            AchievementData(name = "MARGIT, THE FELL OMEN", image = "", description = "Defeat Margit, the Fell Omen"),
            AchievementData(name = "RED WOLF OF RADAGON", image = "", description = "Defeat Red Wolf of Radagon"),
            AchievementData(name = "GODSKIN NOBLE", image = "", description = "Defeat Godskin Noble"),
            AchievementData(name = "MAGMA WYRM MAKAR", image = "", description = "Defeat Magma Wyrm Makar"),
            AchievementData(name = "GODFREY THE FIRST LORD", image = "", description = "Defeat Godfrey the First Lord"),
            AchievementData(name = "MOHG, THE OMEN", image = "", description = "Defeat Mohg, the Omen"),
            AchievementData(name = "MIMIC TEAR", image = "", description = "Defeat Mimic Tear"),
            AchievementData(name = "KNIGHT OF THE HALIGTREE", image = "", description = "Defeat Loretta, Knight of the Haligtree"),
            AchievementData(name = "ASTEL, NATURALBORN OF THE VOID", image = "", description = "Defeat Astel, Naturalborn of the Void"),
            AchievementData(name = "LEONINE MISBEGOTTEN", image = "", description = "Defeat Leonine Misbegotten"),
            AchievementData(name = "ROYAL KNIGHT LORETTA", image = "", description = "Defeat Royal Knight Loretta"),
            AchievementData(name = "ELEMER OF THE BRIAR", image = "", description = "Defeat Elemer of the Briar"),
            AchievementData(name = "ANCESTOR SPIRITDEN", image = "", description = "Defeat Ancestor Spirit"),
            AchievementData(name = "COMMANDER NIALL", image = "", description = "Defeat Commander Niall"),
            AchievementData(name = "ROUNDTABLE HOLD", image = "", description = "Arrive at Roundtable Hold"),
            AchievementData(name = "GREAT RUNE", image = "", description = "Restore the power of a Great Rune"),
            AchievementData(name = "ERDTREE AFLAME", image = "", description = "Use kindling to set the Erdtree Aflame"),

            )
    }

    override suspend fun GetAchievements(): MutableList<AchievementData> {
        return achievementsListHardcoded    }
}
