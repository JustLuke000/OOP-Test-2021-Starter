package ie.tudublin;

public class Note 
{
    private char noteC;
    private int duration;
    private String type;
    
    public Note()
    {
        noteC = 0;
        duration = 0;
    }

    public Note(char note, int duration, String type) {
        this.noteC = note;
        this.duration = duration;
        this.type = type;
    }

    @Override
    public String toString() {
        return noteC + "     " + duration + "     " + getType();
    }

    public char getNote() {
        return noteC;
    }

    public void setNote(char note) {
        this.noteC = note;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
}
