public class CosinePod extends Pod {
    public CosinePod(String name, double amplitude, double offset) {
        super(name, t -> amplitude * Math.cos(t) + offset);
    }
}