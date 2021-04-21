package ie.tudublin;

public class Note {
    
    private char note;
    private int duration;
    private String type;
    
    public Note(char note, int duration) {
        this.note = note;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Note [duration=" + duration + ", note=" + note + "]";
    }

    public char getNote() {
        return note;
    }

    public void setNote(char note) {
        this.note = note;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        if ( duration == 1) type = "Quaver";
        if ( duration == 2) type = "Crotchet";
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
}
