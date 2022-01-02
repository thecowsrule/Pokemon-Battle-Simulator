// this class implements the Pokemon data type, representing all of a Pokemon's various abilities

public class Pokemon {

    private final int pokedexNumber; // pokemon pokedex number
    private final String name; // pokemon name
    private final String type1; // pokemon first type
    private final String type2; // pokemon second type (if applicable)
    private final int maxHP; // pokemon max hp
    private int hp; // pokemon current hp
    private int attack; // pokemon current attack
    private final int baseAttack; // pokemon base attack
    private int defense; // pokemon defense
    private int specialAttack; // pokemon special attack
    private int specialDefense; // pokemon special defense
    private int speed; // pokemon speed
    private String status; // pokemon status
    private boolean alive; // pokemon is alive or not
    private final int uniqueIdentifier; // unique random number to identify pokemon
    private final Move move1; // first move
    private final Move move2; // second move
    private final Move move3; // third move
    private final Move move4; // fourth move
    private final String image; // image of Pokemon

    // creates a pokemon that corresponds to pokedex number a + 1;
    public Pokemon(int a) {
        pokedexNumber = a + 1;
        // arrays that correspond to various values of the pokemon
        String[] names = {
                "Venusaur", "Charizard", "Blastoise", "Pidgeot",
                "Pikachu", "Raichu",
                "Nidoqueen",
                "Nidoking", "Ninetales",
                "Vileplume",
                "Arcanine",
                "Poliwrath", "Alakazam", "Machamp",
                "Golem",
                "Gengar",
                "Starmie", "Scyther",
                "Gyarados", "Lapras", "Vaporeon",
                "Jolteon", "Flareon",
                "Aerodactyl", "Snorlax", "Articuno", "Zapdos", "Moltres", "Dragonite", "Mewtwo",
                "Mew"
        };
        String[] type1s = {
                "Grass", "Fire", "Water", "Normal", "Electric", "Electric", "Poison", "Poison",
                "Fire", "Grass", "Fire", "Water", "Psychic", "Fighting", "Rock", "Ghost", "Water",
                "Bug", "Water", "Water", "Water", "Electric",
                "Fire", "Rock", "Normal", "Ice",
                "Electric", "Fire", "Dragon", "Psychic", "Psychic"
        };
        String[] type2s = {
                "Poison", "Flying", null, "Flying", null, null, "Ground", "Ground", null, "Poison",
                null, "Fighting", null, null, "Ground", "Poison", "Psychic", "Flying", "Flying",
                "Ice", null, null, null, "Flying", null, "Flying", "Flying", "Flying", "Flying",
                null, null
        };
        int[] maxHPs = {
                80, 78, 79, 83, 35, 60, 90, 81, 73, 75, 90, 90, 55, 90, 80, 60, 60, 70, 95, 130,
                130, 65, 65, 80, 160, 90, 90, 90, 91, 106, 100
        };
        int[] hps = {
                80, 78, 79, 83, 35, 60, 90, 81, 73, 75, 90, 90, 55, 90, 80, 60, 60, 70, 95, 130,
                130, 65, 65, 80, 160, 90, 90, 90, 91, 106, 100
        };
        int[] attacks = {
                82, 84, 83, 80, 55, 90, 92, 102, 76, 80, 110, 95, 50, 130, 120, 65, 75, 110, 125,
                85, 65, 65, 130, 105, 110, 85, 90, 100, 134, 110, 100
        };
        int[] baseAttacks = {
                82, 84, 83, 80, 55, 90, 92, 102, 76, 80, 110, 95, 50, 130, 120, 65, 75, 110, 125,
                85, 65, 65, 130, 105, 110, 85, 90, 100, 134, 110, 100
        };
        int[] defenses = {
                83, 78, 100, 75, 40, 55, 87, 77, 75, 85, 80, 95, 45, 80, 130, 60, 85, 80, 79, 80,
                60, 60, 60, 65, 65, 100, 85, 90, 95, 90, 100
        };
        int[] specialAttacks = {
                100, 109, 85, 70, 50, 90, 75, 85, 81, 110, 100, 70, 135, 65, 55, 130, 100, 55, 60,
                85, 110, 110, 95, 60, 65, 95, 125, 125, 100, 154, 100
        };
        int[] specialDefenses = {
                100, 85, 105, 70, 50, 80, 85, 75, 100, 90, 80, 90, 95, 85, 65, 75, 85, 80, 100, 95,
                95, 95, 110, 75, 110, 125, 90, 85, 100, 90, 100
        };
        int[] speeds = {
                80, 100, 78, 101, 90, 110, 76, 85, 100, 50, 95, 70, 120, 55, 45, 110, 115, 105, 81,
                60, 65, 130, 65, 130, 30, 85, 100, 90, 80, 130, 100
        };
        int[] move1s = {
                1, 2, 8, 10, 13, 13, 2, 2, 5, 3, 5, 8, 17, 20, 6, 7, 8, 2, 8, 8, 8, 13, 5, 16, 2,
                9, 2, 2, 8, 17, 17
        };
        int[] move2s = {
                2, 5, 9, 11, 14, 14, 6, 6, 11, 7, 2, 2, 2, 2, 2, 13, 2, 7, 13, 9, 9, 2, 11, 2, 8,
                10, 10, 15, 9, 9, 8
        };
        int[] move3s = {
                3, 6, 2, 12, 2, 2, 9, 9, 2, 1, 15, 9, 18, 6, 15, 17, 13, 11, 9, 2, 2, 11, 2, 10, 6,
                2, 13, 10, 13, 13, 9
        };
        int[] move4s = {
                7, 7, 6, 2, 11, 11, 13, 13, 15, 2, 16, 6, 19, 15, 21, 2, 17, 12, 15, 13, 11, 16, 15,
                15, 9, 12, 12, 12, 15, 1, 13
        };

        String[] images = {
                "Venusaur.png", "Charizard.png", "Blastoise.png", "Pidgeot.png",
                "Pikachu.png", "Raichu.png",
                "Nidoqueen.png",
                "Nidoking.png", "Ninetales.png",
                "Vileplume.png",
                "Arcanine.png",
                "Poliwrath.png", "Alakazam.png", "Machamp.png",
                "Golem.png",
                "Gengar.png",
                "Starmie.png", "Scyther.png",
                "Gyarados.png", "Lapras.png", "Vaporeon.png",
                "Jolteon.png", "Flareon.png",
                "Aerodactyl.png", "Snorlax.png", "Articuno.png", "Zapdos.png", "Moltres.png",
                "Dragonite.png", "Mewtwo.png",
                "Mew.png"
        };
        // assigns the pokemon the correct value for each attribute
        // each attribute is calculated using the values a pokemon would have at level 100,
        // using various formulas taken from https://bulbapedia.bulbagarden.net/wiki/Damage
        name = names[a];
        type1 = type1s[a];
        type2 = type2s[a];
        maxHP = 2 * maxHPs[a] + 110;
        hp = 2 * hps[a] + 110;
        attack = 2 * attacks[a] + 5;
        baseAttack = 2 * baseAttacks[a] + 5;
        defense = 2 * defenses[a] + 5;
        specialAttack = 2 * specialAttacks[a] + 5;
        specialDefense = 2 * specialDefenses[a] + 5;
        speed = 2 * speeds[a] + 5;
        status = "";
        alive = true;
        uniqueIdentifier = (int) (100000000 * StdRandom
                .uniform()); // generates a random large number to identify pokemon
        move1 = new Move(move1s[a]);
        move2 = new Move(move2s[a]);
        move3 = new Move(move3s[a]);
        move4 = new Move(move4s[a]);
        image = images[a];
    }

    // gets pokedex number
    public int getPokedexNumber() {
        return pokedexNumber;
    }

    // gets name
    public String getName() {
        return name;
    }

    // gets type1
    public String getType1() {
        return type1;
    }

    // gets type2
    public String getType2() {
        return type2;
    }

    // gets max hp
    public int getMaxHP() {
        return maxHP;
    }

    // gets current
    public int getHP() {
        return hp;
    }

    // gets current attack
    public int getAttack() {
        return attack;
    }

    // gets base attack
    public int getBaseAttack() {
        return baseAttack;
    }

    // gets defense
    public int getDefense() {
        return defense;
    }

    // gets special attack
    public int getSpecialAttack() {
        return specialAttack;
    }

    // gets special defense
    public int getSpecialDefense() {
        return specialDefense;
    }

    // gets speed
    public int getSpeed() {
        return speed;
    }

    // gets status
    public String getStatus() {
        return status;
    }

    // gets if pokemon is alive
    public boolean getAlive() {
        return alive;
    }

    // gets unique identifier
    public int getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    // gets move1
    public Move getMove1() {
        return move1;
    }

    // gets move2
    public Move getMove2() {
        return move2;
    }

    // gets move3
    public Move getMove3() {
        return move3;
    }

    // gets move4
    public Move getMove4() {
        return move4;
    }

    // gets imageURL
    public String getImage() {
        return image;
    }

    // simulates pokemon taking damage
    public void takeDamage(int damage) {
        hp = hp - damage;
    }

    // makes pokemon faint
    public void faint() {
        alive = false;
    }

    // poisons pokemon
    public void poison() {
        status = "Poison";
    }

    // uses swords dance move
    public void swordsDance() {
        attack = attack + baseAttack;
    }

    // badly poisons pokemon
    public void toxic() {
        status = "Toxic";
    }

    // uses recover move
    public void recover() {
        hp = hp + (int) (0.5 * maxHP);
    }


    public static void main(String[] args) {

    }
}
