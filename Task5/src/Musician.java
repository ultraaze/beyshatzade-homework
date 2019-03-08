public class Musician extends Person {
    private String Instrument;

    public Musician(String name, String surname, String Instrument) {
        super(name, surname);
        this.Instrument = Instrument;
    }

    public String getInstrument() {
        return Instrument;
    }

    public void setInstrument(String instrument) {
        Instrument = instrument;
    }
}
