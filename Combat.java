// this class includes many combat functionalities that makes the code in Battle.java more concise

public class Combat {

    // generates a team of Pokemon
    public static Pokemon[] generateTeam() {
        Pokemon[] team = new Pokemon[6];
        for (int i = 0; i < 6; i++) {
            team[i] = new Pokemon((int) (31 * StdRandom.uniform()));
        }
        return team;
    }

    // prints the team to terminal
    public static void printTeam(int player, Pokemon[] team) {
        System.out.println("Team " + player + ":");
        for (int i = 0; i < 6; i++) {
            System.out.print(i + 1 + ". " + team[i].getName() + " ");
        }
        System.out.println();
    }

    // prompts the user for input
    public static void promptUser(int player, Pokemon[] team, int currentPokemon) {
        System.out.println(
                "Player " + player + ". Type number to choose action: 1. " + team[currentPokemon]
                        .getMove1().getName()
                        + " 2. " + team[currentPokemon].getMove2().getName() + " 3. "
                        + team[currentPokemon].getMove3().getName() + " 4. "
                        + team[currentPokemon].getMove4().getName() + " 5. Switch");
    }

    // decides which move to use
    public static Move decideMove(int input, Pokemon pokemon) {
        if (input == 1) {
            return pokemon.getMove1();
        }
        if (input == 2) {
            return pokemon.getMove2();
        }
        if (input == 3) {
            return pokemon.getMove3();
        }
        if (input == 4) {
            return pokemon.getMove4();
        }
        else {
            return null;
        }
    }

    // determines the super effectiveness of the move
    public static double superEffective(Move move, Pokemon pokemon2) {
        int attackType = 0;
        int defenseType1 = 0;
        int defenseType2 = -1;
        double superEffectivenessMultiplier = 1;
        String[] types = {
                "Normal", "Fire", "Water", "Electric", "Grass", "Ice", "Fighting", "Poison",
                "Ground", "Flying", "Psychic", "Bug", "Rock", "Ghost", "Dragon", "Dark", "Steel",
                "Fairy"
        };
        for (int i = 0; i < 18; i++) {
            if (move.getType().equals(types[i])) {
                attackType = i;
            }
            if (pokemon2.getType1().equals(types[i])) {
                defenseType1 = i;
            }
            if (pokemon2.getType2() != null) {
                if (pokemon2.getType2().equals(types[i])) {
                    defenseType2 = i;
                }
            }
        }
        double[][] superEffectiveness = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.5, 0, 1, 1, 0.5, 1 },
                { 1, 0.5, 0.5, 1, 2, 2, 1, 1, 1, 1, 1, 2, 0.5, 1, 0.5, 1, 2, 1 },
                { 1, 2, 0.5, 1, 0.5, 1, 1, 1, 2, 1, 1, 1, 2, 1, 0.5, 1, 1, 1 },
                { 1, 1, 2, 0.5, 0.5, 1, 1, 1, 0, 2, 1, 1, 1, 1, 0.5, 1, 1, 1 },
                { 1, 0.5, 2, 1, 0.5, 1, 1, 0.5, 2, 0.5, 1, 0.5, 2, 1, 0.5, 1, 0.5, 1 },
                { 1, 0.5, 0.5, 1, 2, 0.5, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1, 0.5, 1 },
                { 2, 1, 1, 1, 1, 2, 1, 0.5, 1, 0.5, 0.5, 0.5, 2, 0, 1, 2, 2, 0.5 },
                { 1, 1, 1, 1, 2, 1, 1, 0.5, 0.5, 1, 1, 1, 0.5, 0.5, 1, 1, 0, 2 },
                { 1, 2, 1, 2, 0.5, 1, 1, 2, 1, 0, 1, 0.5, 2, 1, 1, 1, 2, 1 },
                { 1, 1, 1, 0.5, 2, 1, 2, 1, 1, 1, 1, 2, 0.5, 1, 1, 1, 0.5, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 0.5, 1, 1, 1, 1, 0, 0.5, 1 },
                { 1, 0.5, 1, 1, 2, 1, 0.5, 0.5, 1, 0.5, 2, 1, 1, 0.5, 1, 2, 0.5, 0.5 },
                { 1, 2, 1, 1, 1, 2, 0.5, 1, 0.5, 2, 1, 2, 1, 1, 1, 1, 0.5, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 0.5, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0.5, 0 },
                { 1, 1, 1, 1, 1, 1, 0.5, 1, 1, 1, 2, 1, 1, 2, 1, 0.5, 1, 0.5 },
                { 1, 0.5, 0.5, 0.5, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 0.5, 2 },
                { 1, 0.5, 1, 1, 1, 1, 2, 0.5, 1, 1, 1, 1, 1, 1, 2, 2, 0.5, 1 }
        };
        double multiplier1 = superEffectiveness[attackType][defenseType1];
        superEffectivenessMultiplier = superEffectivenessMultiplier * multiplier1;
        if (defenseType2 != -1) {
            double multiplier2 = superEffectiveness[attackType][defenseType2];
            superEffectivenessMultiplier = superEffectivenessMultiplier * multiplier2;
        }
        return superEffectivenessMultiplier;
    }

    // determines the stab attack bonus
    public static double stab(Move move, Pokemon pokemon1) {
        if (move.getType().equals(pokemon1.getType1()) || move.getType()
                                                              .equals(pokemon1.getType2())) {
            return 1.5;
        }
        else {
            return 1;
        }
    }

    // calculates and performs damage
    public static int calculateDamage(Move move, Pokemon pokemon1, Pokemon pokemon2) {
        int damage = 0;
        double multiplier;
        double stab;
        double random = 100 * StdRandom.uniform();
        double hit = move.getAccuracy();
        if (move.getEffect() != null && move.getEffect().equals("Swift")) {
            hit = 100000000;
        }
        System.out.println(pokemon1.getName() + " used "
                                   + move.getName() + ".");
        if (random > hit) {
            System.out.println("But it missed!");
            return damage;
        }
        else {
            if (move.getCategory().equals("Physical")) {
                damage = (int) ((42.0 * move.getPower()
                        * pokemon1.getAttack()) / (50.0
                        * pokemon2.getDefense()) + 2);
            }
            if (move.getCategory().equals("Special")) {
                damage = (int) ((42.0 * move.getPower()
                        * pokemon1.getSpecialAttack()) / (50.0
                        * pokemon2.getSpecialDefense()) + 2);
            }
            multiplier = superEffective(move, pokemon2);
            stab = stab(move, pokemon1);
            damage = (int) (multiplier * stab * damage);
            if (damage > pokemon2.getHP()) {
                damage = pokemon2.getHP();
            }
        }
        if (multiplier == 0) {
            System.out.println("It had no effect!");
        }
        if (multiplier == 0.25 || multiplier == 0.5) {
            System.out.println("It's not very effective...");
        }
        if (multiplier == 2 || multiplier == 4) {
            System.out.println("It's super effective!");
        }
        if (multiplier != 0) {

            if (move.getEffect() != null) {
                if (move.getEffect().equals("Double-Edge")) {
                    int recoil = (int) (damage * 0.25);
                    pokemon1.takeDamage(recoil);
                    System.out.println(
                            pokemon1.getName() + " took " + recoil + " points of recoil damage.");
                }
                if (move.getEffect().equals("Poison")) {
                    System.out.println(pokemon2.getName() + " was poisoned!");
                    pokemon2.poison();
                }
                if (move.getEffect().equals("Swords Dance")) {
                    System.out.println(pokemon1.getName() + "'s Attack sharply increased!");
                    pokemon1.swordsDance();
                }
                if (move.getEffect().equals("Toxic")) {
                    System.out.println(pokemon2.getName() + " was badly poisoned.");
                    pokemon2.toxic();
                }
                if (move.getEffect().equals("Recover")) {
                    System.out.println(pokemon1.getName() + " restored some HP!");
                    pokemon1.recover();
                }

            }

        }
        if (damage == 0) {
            return damage;
        }
        else {
            System.out.println(pokemon1.getName() + " did " + damage
                                       + " points of damage!");
        }

        return damage;
    }

    // switches Pokemon
    public static void switchPokemon(Pokemon[] team, int currentPokemon) {
        System.out.println("Which Pokemon will you switch in?");
        for (int i = 0; i < 6; i++) {
            if (team[i].getAlive() && i != currentPokemon) {
                StdOut.println(i + 1 + ". " + team[i].getName() + " ");
            }
        }
    }

    public static void main(String[] args) {

    }
}
