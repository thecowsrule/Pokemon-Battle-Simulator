// simulates a Pokemon battle, generating a random team, taking input from the
// terminal and displaying the output to both the terminal and picture

import java.awt.Font;

public class Battle {

    // updates screen with each active Pokemon
    private static void updateScreen(Pokemon[] team1, Pokemon[] team2, int team1CurrentPokemon,
                                     int team2CurrentPokemon) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.textLeft(10, 625, "Go " + team1[team1CurrentPokemon].getName() + "!");
        StdDraw.text(150, 560,
                     team1[team1CurrentPokemon].getName() + ": " + team1[team1CurrentPokemon]
                             .getHP() + "/" + team1[team1CurrentPokemon].getMaxHP() + " HP");
        StdDraw.text(150, 600, "Player 1");
        StdDraw.rectangle(150, 580, team1[team1CurrentPokemon].getHP() * 100.0
                / team1[team1CurrentPokemon].getMaxHP(), 5);
        StdDraw.picture(150, 460, team1[team1CurrentPokemon].getImage());

        if (team1[team1CurrentPokemon].getHP() > 0) {
            StdDraw.setPenColor(StdDraw.GREEN);
            if (team1[team1CurrentPokemon].getHP() < team1[team1CurrentPokemon].getMaxHP() / 2)
                StdDraw.setPenColor(StdDraw.YELLOW);
            if (team1[team1CurrentPokemon].getHP() < team1[team1CurrentPokemon].getMaxHP() / 4)
                StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledRectangle(150, 580,
                                    team1[team1CurrentPokemon].getHP() * 100.0
                                            / team1[team1CurrentPokemon].getMaxHP(), 5);
        }

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.textRight(790, 135, "Go " + team2[team2CurrentPokemon].getName() + "!");
        StdDraw.text(650, 200,
                     team2[team2CurrentPokemon].getName() + ": " + team2[team2CurrentPokemon]
                             .getHP() + "/" + team2[team2CurrentPokemon].getMaxHP() + " HP");
        StdDraw.text(650, 160, "Player 2");
        StdDraw.rectangle(650, 180,
                          team2[team2CurrentPokemon].getHP() * 100.0
                                  / team2[team2CurrentPokemon].getMaxHP(), 5);
        StdDraw.picture(650, 300, team2[team2CurrentPokemon].getImage());

        if (team2[team2CurrentPokemon].getHP() > 0) {
            StdDraw.setPenColor(StdDraw.GREEN);
            if (team2[team2CurrentPokemon].getHP() < team2[team2CurrentPokemon].getMaxHP() / 2)
                StdDraw.setPenColor(StdDraw.YELLOW);
            if (team2[team2CurrentPokemon].getHP() < team2[team2CurrentPokemon].getMaxHP() / 4)
                StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledRectangle(650, 180,
                                    team2[team2CurrentPokemon].getHP() * 100.0
                                            / team2[team2CurrentPokemon].getMaxHP(), 5);
        }
    }

    // updates screen after switch
    private static void updateSwitch(Pokemon[] team1, Pokemon[] team2, int team1CurrentPokemon,
                                     int team2CurrentPokemon) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.textLeft(10, 625, "Go " + team1[team1CurrentPokemon].getName() + "!");
        StdDraw.text(150, 560,
                     team1[team1CurrentPokemon].getName() + ": "
                             + team1[team1CurrentPokemon]
                             .getHP() + "/" + team1[team1CurrentPokemon].getMaxHP()
                             + " HP");
        StdDraw.text(150, 600, "Player 1");
        StdDraw.rectangle(150, 580, team1[team1CurrentPokemon].getHP() * 100.0
                / team1[team1CurrentPokemon].getMaxHP(), 5);
        StdDraw.picture(150, 460, team1[team1CurrentPokemon].getImage());

        if (team1[team1CurrentPokemon].getHP() > 0) {
            StdDraw.setPenColor(StdDraw.GREEN);
            if (team1[team1CurrentPokemon].getHP()
                    < team1[team1CurrentPokemon].getMaxHP() / 2)
                StdDraw.setPenColor(StdDraw.YELLOW);
            if (team1[team1CurrentPokemon].getHP()
                    < team1[team1CurrentPokemon].getMaxHP() / 4)
                StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledRectangle(150, 580,
                                    team1[team1CurrentPokemon].getHP() * 100.0
                                            / team1[team1CurrentPokemon].getMaxHP(), 5);
        }

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.textRight(790, 135, "Go " + team2[team2CurrentPokemon].getName() + "!");
        StdDraw.text(650, 200,
                     team2[team2CurrentPokemon].getName() + ": "
                             + team2[team2CurrentPokemon]
                             .getHP() + "/" + team2[team2CurrentPokemon].getMaxHP()
                             + " HP");
        StdDraw.text(650, 160, "Player 2");
        StdDraw.rectangle(650, 180,
                          team2[team2CurrentPokemon].getHP() * 100.0
                                  / team2[team2CurrentPokemon].getMaxHP(), 5);
        StdDraw.picture(650, 300, team2[team2CurrentPokemon].getImage());

        if (team2[team2CurrentPokemon].getHP() > 0) {
            StdDraw.setPenColor(StdDraw.GREEN);
            if (team2[team2CurrentPokemon].getHP()
                    < team2[team2CurrentPokemon].getMaxHP() / 2)
                StdDraw.setPenColor(StdDraw.YELLOW);
            if (team2[team2CurrentPokemon].getHP()
                    < team2[team2CurrentPokemon].getMaxHP() / 4)
                StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledRectangle(650, 180,
                                    team2[team2CurrentPokemon].getHP() * 100.0
                                            / team2[team2CurrentPokemon].getMaxHP(), 5);
        }
    }

    // evaluates statuses of pokemon
    private static void status(Pokemon pokemon) {
        if (pokemon.getStatus() != null && pokemon.getAlive()) {
            if (pokemon.getStatus().equals("Poison")) {
                pokemon.takeDamage((int) (pokemon.getMaxHP() * 0.0625));
                System.out.println(pokemon.getName() + " took some poison damage.");
            }
            if (pokemon.getStatus().equals("Toxic")) {
                pokemon.takeDamage(
                        (int) (pokemon.getMaxHP() * 0.125 * StdRandom.uniform()));
                System.out
                        .println(pokemon.getName() + " took some poison damage.");
            }
        }
    }

    // switches Pokemon after fainting
    private static void victory(int pokemonLeft, String loser, String winner) {
        if (pokemonLeft == 0) {
            System.out.println(loser + " has no more usable Pokemon.");

            System.out.println(winner + " Wins!");

            StdDraw.clear();
            Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 48);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setFont(font);
            StdDraw.text(400, 325, winner + " Wins!");
        }
    }

    // simulates a Pokemon battle
    public static void main(String[] args) {

        // begins battle by playing music, generating and printing teams
        StdAudio.loop("Battle Theme.wav");
        Pokemon[] team1 = Combat.generateTeam();
        Pokemon[] team2 = Combat.generateTeam();
        Combat.printTeam(1, team1);
        Combat.printTeam(2, team2);
        int team1PokemonLeft = 6;
        int team2PokemonLeft = 6;
        int team1CurrentPokemon = 0;
        int team2CurrentPokemon = 0;

        // battle loop while teams still have Pokemon
        while (team1PokemonLeft != 0 && team2PokemonLeft != 0) {

            StdDraw.setXscale(0, 800);
            StdDraw.setYscale(0, 650);
            updateScreen(team1, team2, team1CurrentPokemon, team2CurrentPokemon);
            System.out.println(team1[team1CurrentPokemon].getName() + " vs. "
                                       + team2[team2CurrentPokemon].getName());

            // prompts both users for inputs and determines move and order
            Combat.promptUser(1, team1, team1CurrentPokemon);
            int input1 = StdIn.readInt();
            if (input1 == 5) {
                Combat.switchPokemon(team1, team1CurrentPokemon);
                team1CurrentPokemon = StdIn.readInt() - 1;
                updateSwitch(team1, team2, team1CurrentPokemon, team2CurrentPokemon);
                System.out.println("Go " + team1[team1CurrentPokemon].getName() + "!");
            }
            Combat.promptUser(2, team2, team2CurrentPokemon);
            int input2 = StdIn.readInt();
            if (input2 == 5) {
                Combat.switchPokemon(team2, team2CurrentPokemon);
                team2CurrentPokemon = StdIn.readInt() - 1;
                updateSwitch(team1, team2, team1CurrentPokemon, team2CurrentPokemon);
                System.out.println("Go " + team2[team2CurrentPokemon].getName() + "!");
            }
            Pokemon firstPokemon;
            Pokemon secondPokemon;
            Move firstPokemonMove;
            Move secondPokemonMove;
            if (team1[team1CurrentPokemon].getSpeed() > team2[team2CurrentPokemon]
                    .getSpeed()) {
                firstPokemon = team1[team1CurrentPokemon];
                secondPokemon = team2[team2CurrentPokemon];
                firstPokemonMove = Combat.decideMove(input1, firstPokemon);
                secondPokemonMove = Combat.decideMove(input2, secondPokemon);
            }
            else {
                firstPokemon = team2[team2CurrentPokemon];
                secondPokemon = team1[team1CurrentPokemon];
                firstPokemonMove = Combat.decideMove(input2, firstPokemon);
                secondPokemonMove = Combat.decideMove(input1, secondPokemon);
            }
            if (input1 != 5 && input2 != 5 && (firstPokemonMove.getEffect() == null
                    || !firstPokemonMove.getEffect().equals("Quick Attack"))
                    && secondPokemonMove.getEffect() != null && secondPokemonMove
                    .getEffect()
                    .equals("Quick Attack")) {
                Pokemon firstPokemonCopy = firstPokemon;
                firstPokemon = secondPokemon;
                secondPokemon = firstPokemonCopy;
                Move firstMoveCopy = firstPokemonMove;
                firstPokemonMove = secondPokemonMove;
                secondPokemonMove = firstMoveCopy;
            }

            // performs first move
            if (firstPokemonMove != null) {
                int damage1 = Combat
                        .calculateDamage(firstPokemonMove, firstPokemon, secondPokemon);
                secondPokemon.takeDamage(damage1);
            }

            // if second pokemon has no HP, perform faint actions and prompt to switch
            if (secondPokemon.getHP() == 0) {
                System.out.println(secondPokemon.getName() + " fainted!");
                if (secondPokemon.getUniqueIdentifier() == team1[team1CurrentPokemon]
                        .getUniqueIdentifier()) {
                    team1[team1CurrentPokemon].faint();
                    team1PokemonLeft = team1PokemonLeft - 1;
                    if (team1PokemonLeft == 0) {
                        break;
                    }
                    Combat.switchPokemon(team1, team1CurrentPokemon);
                    team1CurrentPokemon = StdIn.readInt() - 1;
                    System.out.println("Go " + team1[team1CurrentPokemon].getName() + "!");
                }
                if (secondPokemon.getUniqueIdentifier() == team2[team2CurrentPokemon]
                        .getUniqueIdentifier()) {
                    team2[team2CurrentPokemon].faint();
                    team2PokemonLeft = team2PokemonLeft - 1;
                    if (team2PokemonLeft == 0) {
                        break;
                    }
                    Combat.switchPokemon(team2, team2CurrentPokemon);
                    team2CurrentPokemon = StdIn.readInt() - 1;
                    System.out.println("Go " + team2[team2CurrentPokemon].getName() + "!");
                }
            }

            // if second pokemon still has HP, continue
            else {
                System.out.println(secondPokemon.getName() + ": " + secondPokemon.getHP()
                                           + "/" + secondPokemon.getMaxHP());

                // performs second move
                if (secondPokemonMove != null) {
                    int damage2 = Combat
                            .calculateDamage(secondPokemonMove, secondPokemon, firstPokemon);
                    firstPokemon.takeDamage(damage2);
                }

                // if first pokemon has no HP, perform faint actions and prompt to switch
                if (firstPokemon.getHP() == 0) {
                    System.out.println(firstPokemon.getName() + " fainted!");
                    if (firstPokemon.getUniqueIdentifier() == team1[team1CurrentPokemon]
                            .getUniqueIdentifier()) {
                        team1[team1CurrentPokemon].faint();
                        team1PokemonLeft = team1PokemonLeft - 1;
                        if (team1PokemonLeft == 0) {
                            break;
                        }
                        Combat.switchPokemon(team1, team1CurrentPokemon);
                        team1CurrentPokemon = StdIn.readInt() - 1;
                        System.out.println(
                                "Go " + team1[team1CurrentPokemon].getName() + "!");
                    }

                    if (firstPokemon.getUniqueIdentifier() == team2[team2CurrentPokemon]
                            .getUniqueIdentifier()) {
                        team2[team2CurrentPokemon].faint();
                        team2PokemonLeft = team2PokemonLeft - 1;
                        if (team2PokemonLeft == 0) {
                            break;
                        }
                        Combat.switchPokemon(team2, team2CurrentPokemon);
                        team2CurrentPokemon = StdIn.readInt() - 1;
                        System.out.println(
                                "Go " + team2[team2CurrentPokemon].getName() + "!");
                    }


                }
                else {
                    System.out.println(
                            firstPokemon.getName() + ": " + firstPokemon.getHP()
                                    + "/" + firstPokemon.getMaxHP());
                }

            }

            // evaluates status of each Pokemon
            status(firstPokemon);
            status(secondPokemon);
        }
        // after the battle, print victory for the winner
        victory(team1PokemonLeft, "Player 1", "Player 2");
        victory(team2PokemonLeft, "Player 2", "Player 1");
    }
}
