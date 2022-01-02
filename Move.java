// this class implements the move data type, which represents all of the values associated with
// moves

public class Move {

    private final int moveNumber; // move number
    private final String name; // move name
    private final String type; // move type
    private final String category; // move category
    private final int power; // move power
    private final double accuracy; // move accuracy
    private final String effect; // move effect

    // creates a move that corresponds to move number a
    public Move(int a) {
        moveNumber = a;
        // each array corresponds to each move's name, type, category, power, accuracy, and effect
        String[] names = {
                "Solar Beam", "Double-Edge", "Poison Powder", "Sleep Powder",
                "Flamethrower", "Earthquake", "Swords Dance",
                "Surf", "Ice Beam",
                "Sky Attack", "Quick Attack", "Swift",
                "Thunderbolt", "Thunder",
                "Fire Blast",
                "Bite",
                "Psychic", "Toxic", "Recover",
                "Karate Chop",
                "Rock Slide",
                "Hypnosis"
        };
        String[] types = {
                "Grass", "Normal", "Poison", "Grass",
                "Fire", "Ground", "Normal",
                "Water", "Ice",
                "Flying", "Normal", "Normal",
                "Electric", "Electric",
                "Fire",
                "Dark",
                "Psychic", "Poison", "Normal",
                "Fighting",
                "Rock",
                "Psychic"
        };
        String[] categories = {
                "Special", "Physical", "Status", "Status",
                "Special", "Physical", "Status",
                "Special", "Special",
                "Physical", "Physical", "Physical",
                "Special", "Special",
                "Special",
                "Special",
                "Special", "Status", "Status",
                "Physical",
                "Physical",
                "Status"
        };
        int[] powers = {
                120, 120, 0, 0,
                90, 100, 0,
                90, 90,
                140, 40, 60,
                90, 110,
                110,
                60,
                90, 0, 0,
                50,
                75,
                0
        };
        double[] accuracies = {
                100, 100, 200, 200,
                100, 100, 200,
                100, 100,
                90, 100, 200,
                100, 70,
                85,
                100,
                100, 90, 200,
                100,
                90,
                60
        };
        String[] effects = {
                null, "Double-Edge", "Poison", "Sleep",
                null, null, "Swords Dance",
                null, null,
                null, "Quick Attack", "Swift",
                null, null,
                null,
                null,
                null, "Toxic", "Recover",
                null,
                null,
                "Sleep"
        };
        // assigns the correct values for the move
        name = names[a - 1];
        type = types[a - 1];
        category = categories[a - 1];
        power = powers[a - 1];
        accuracy = accuracies[a - 1];
        effect = effects[a - 1];
    }

    // gets the move number
    public int getMoveNumber() {
        return moveNumber;
    }

    // gets the move name
    public String getName() {
        return name;
    }

    // gets the move type
    public String getType() {
        return type;
    }

    // gets the move category
    public String getCategory() {
        return category;
    }

    // gets the move power
    public int getPower() {
        return power;
    }

    // gets the move accuracy
    public double getAccuracy() {
        return accuracy;
    }

    // gets the move effect
    public String getEffect() {
        return effect;
    }

    public static void main(String[] args) {

    }
}
