package characters.of.game.gameofcharacters;

import android.os.Parcel;
import android.os.Parcelable;

public class GoTCharacter implements Parcelable {
    public static final GoTCharacter[] GOT_CHARACTERS =
            {
                    new GoTCharacter("Arya Stark", R.drawable.arya, R.drawable.arya_full, true, "Stark", R.drawable.stark, "Arya Stark is the third child and second daughter of Lord Eddard Stark and Lady Catelyn Tully"),
                    new GoTCharacter("Bran Stark", R.drawable.bran, R.drawable.bran_full, true, "Stark", R.drawable.stark, "Brandon Stark, typically called Bran, is the second son of Lord Eddard Stark and Lady Catelyn Tully."),
                    new GoTCharacter("Brienne Tarth", R.drawable.brienne, R.drawable.brienne_full, true, "Stark", R.drawable.stark, "Brienne is sometimes called the Maid of Tarth and mocked as Brienne the Beauty."),
                    new GoTCharacter("Catelyn Stark", R.drawable.catelyn, R.drawable.catelyn_full, false, "Stark", R.drawable.stark, "Lady Catelyn Stark, also called Catelyn Tully, is the wife of Lord Eddard Stark and Lady of Winterfell."),
                    new GoTCharacter("Cercei Lannister", R.drawable.cercei, R.drawable.cercei_full, true, "Lannister", R.drawable.lannister, "Cersei Lannister is the eldest child of Tywin and Joanna Lannister by mere moments, and the twin sister of Jaime Lannister."),
                    new GoTCharacter("Daenerys Targaryen", R.drawable.daenerys, R.drawable.daenerys_full, true, "Targaryen", R.drawable.targaryen, "Princess Daenerys Targaryen, known as Daenerys Stormborn and Dany, is one of the last confirmed members of House Targaryen"),
                    new GoTCharacter("Davos Seaworth", R.drawable.davos, R.drawable.davos_full, true, "Baratheon", R.drawable.baratheon, "Ser Davos Seaworth, commonly called the Onion Knight, is the head of House Seaworth. He was once a smuggler."),
                    new GoTCharacter("Eddard Stark", R.drawable.eddard, R.drawable.eddard_full, false, "Stark", R.drawable.stark, "Eddard Stark, also affectionately called 'Ned', is the head of House Stark, Lord of Winterfell, and Warden of the North."),
                    new GoTCharacter("Hodor", R.drawable.hodor, R.drawable.hodor_full, true, "Stark", R.drawable.stark, "Hodor, the giant, simple-minded stableboy of Winterfell."),
                    new GoTCharacter("Jaime Lannister", R.drawable.jaime, R.drawable.jaime_full, true, "Lannister", R.drawable.lannister, "Ser Jaime Lannister, known as the Kingslayer, is a knight from House Lannister. He is the twin brother of Queen Cersei Lannister."),
                    new GoTCharacter("Jaqen Hagar", R.drawable.jaqen, R.drawable.jaqen_full, true, "Faceless Men", R.drawable.faceless, "Jaqen Hagar is the name of a sly Lorathi criminal who meets Arya Stark on her way to the Wall."),
                    new GoTCharacter("Joffrey Baratheon", R.drawable.joffrey, R.drawable.joffrey_full, false, "Baratheon", R.drawable.baratheon, "Prince Joffrey Baratheon is known to the Seven Kingdoms as the eldest son and heir of King Robert I Baratheon and Queen Cersei Lannister."),
                    new GoTCharacter("Jon Snow", R.drawable.jon, R.drawable.jon_full, false, "Stark", R.drawable.stark, "Jon Snow doesn't know anything"),
                    new GoTCharacter("Khal Drogo", R.drawable.khal, R.drawable.khal_full, false, "Khalasar", R.drawable.dothraki, "Drogo is a powerful khal or warlord of the fearsome Dothraki nomads."),
                    new GoTCharacter("Melisandre", R.drawable.melisandre, R.drawable.melisandre_full, true, "Baratheon", R.drawable.baratheon, "Melisandre is a priestess of R'hllor and a shadowbinder, hailing from the eastern city of Asshai. She has joined the entourage of Stannis Baratheon."),
                    new GoTCharacter("Petyr Baelish", R.drawable.petyr, R.drawable.petyr_full, true, "Lannister", R.drawable.lannister, "Petyr Baelish, sometimes called Littlefinger, is the head of House Baelish of the Fingers. Petyr wears a mockingbird as his personal crest instead of House Baelish's sigil, a titan's head."),
                    new GoTCharacter("Podrick Payne", R.drawable.podrick, R.drawable.podrick_full, true, "Lannister", R.drawable.lannister, "Podrick Payne is the squire of Tyrion Lannister. He is from a cadet branch of House Payne."),
                    new GoTCharacter("Grand Maester Pycelle", R.drawable.pycelle, R.drawable.pycelle_full, true, "Lannister", R.drawable.lannister, "Pycelle is a Grand Maester of the Citadel who has served in King's Landing and on the small council for over forty years."),
                    new GoTCharacter("Ramsay Bolton", R.drawable.ramsay, R.drawable.ramsay_full, true, "Bolton", R.drawable.bolton, "Ramsay Bolton (formerly Ramsay Snow) is the legitimized bastard son of Lord Roose Bolton. He is known as the Bastard of Bolton and the Bastard of the Dreadfort."),
                    new GoTCharacter("Renly Baratheon", R.drawable.renly, R.drawable.renly_full, false, "Baratheon", R.drawable.baratheon, "Renly Baratheon is the Lord of Storm's End and Lord Paramount of the Stormlands. The younger brother of King Robert I and Lord Stannis."),
                    new GoTCharacter("Robb Stark", R.drawable.robb, R.drawable.robb_full, false, "Stark", R.drawable.stark, "Robb Stark is the eldest son of Eddard Stark and Catelyn Tully and is the heir of House Stark to Winterfell and the north."),
                    new GoTCharacter("Robert Baratheon", R.drawable.robert, R.drawable.robert_full, false, "Baratheon", R.drawable.baratheon, "King Robert I Baratheon is the Lord of the Seven Kingdoms of Westeros and the head of House Baratheon of King's Landing"),
                    new GoTCharacter("Roose Bolton", R.drawable.roose, R.drawable.roose_full, true, "Bolton", R.drawable.bolton, "Roose Bolton is the Lord of the Dreadfort and head of House Bolton."),
                    new GoTCharacter("Sansa Stark", R.drawable.sansa, R.drawable.sansa_full, true, "Stark", R.drawable.stark, "Arya Stark is the third child and second daughter of Lord Eddard Stark and Lady Catelyn Tully."),
                    new GoTCharacter("Stannis Baratheon", R.drawable.stannis, R.drawable.stannis_full, false, "Baratheon", R.drawable.baratheon, "Stannis Baratheon is the head of House Baratheon of Dragonstone and the Lord of Dragonstone."),
                    new GoTCharacter("Tyrion Lannister", R.drawable.tyrion, R.drawable.tyrion_full, true, "Lannister", R.drawable.lannister, "Tyrion is a dwarf, with stubby legs, a jutting forehead, mismatched eyes of green and black, and a mixture of pale blond and black hair."),
                    new GoTCharacter("Tywin Lannister", R.drawable.tywin, R.drawable.tywin_full, false, "Lannister", R.drawable.lannister, "Tywin Lannister is Lord of Casterly Rock, Shield of Lannisport and Warden of the West. The head of House Lannister, Tywin is one of the most powerful lords in Westeros."),
                    new GoTCharacter("Varys", R.drawable.varys, R.drawable.varys_full, true, "Lannister", R.drawable.lannister, "Varys, called the Spider, is an enigmatic member of the small council and the master of whisperers, or spymaster, for the Iron Throne of the Seven Kingdoms.")
            };

    public final String name;
    public final int resId;
    public final boolean alive;
    public final int fullResId;
    public final int houseResId;
    public final String house;
    public final String description;

    public GoTCharacter(String name, int resId, int fullResId, boolean alive, String house, int houseResId, String description) {
        this.name = name;
        this.resId = resId;
        this.alive = alive;
        this.fullResId = fullResId;
        this.houseResId = houseResId;
        this.house = house;
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.resId);
        dest.writeByte(alive ? (byte) 1 : (byte) 0);
        dest.writeInt(this.fullResId);
        dest.writeInt(this.houseResId);
        dest.writeString(this.house);
        dest.writeString(this.description);
    }

    protected GoTCharacter(Parcel in) {
        this.name = in.readString();
        this.resId = in.readInt();
        this.alive = in.readByte() != 0;
        this.fullResId = in.readInt();
        this.houseResId = in.readInt();
        this.house = in.readString();
        this.description = in.readString();
    }

    public static final Creator<GoTCharacter> CREATOR = new Creator<GoTCharacter>() {
        public GoTCharacter createFromParcel(Parcel source) {
            return new GoTCharacter(source);
        }

        public GoTCharacter[] newArray(int size) {
            return new GoTCharacter[size];
        }
    };
}
