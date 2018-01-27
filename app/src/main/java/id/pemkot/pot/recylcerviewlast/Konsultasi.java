package id.pemkot.pot.recylcerviewlast;

import android.os.Parcel;
import android.os.Parcelable;

public class Konsultasi implements Parcelable {

    private int id;
    private String name;
    private String team;
    private int thumb;

    public Konsultasi() {
    }

    protected Konsultasi(Parcel in) {
        id = in.readInt();
        name = in.readString();
        team = in.readString();
        thumb = in.readInt();
    }

    public static final Creator<id.pemkot.pot.recylcerviewlast.Konsultasi> CREATOR = new Creator<id.pemkot.pot.recylcerviewlast.Konsultasi>() {
        @Override
        public id.pemkot.pot.recylcerviewlast.Konsultasi createFromParcel(Parcel in) {
            return new id.pemkot.pot.recylcerviewlast.Konsultasi(in);
        }

        @Override
        public id.pemkot.pot.recylcerviewlast.Konsultasi[] newArray(int size) {
            return new id.pemkot.pot.recylcerviewlast.Konsultasi[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(team);
        dest.writeInt(thumb);
    }
}
