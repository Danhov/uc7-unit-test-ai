package uc7.unitTest.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerAnalyzerTest {

    private PlayerAnalyzer playerAnalyzer;

    @BeforeEach
    void setUp() {
        playerAnalyzer = new PlayerAnalyzer();
    }

    // Positive Test Cases

    @Test
    void testCalculateScore_NormalPlayer() {
        Player player = new Player();
        player.setAge(25);
        player.setExperience(5);
        player.setSkills(Arrays.asList(2, 2, 2));

        List<Player> players = List.of(player);

        double expectedScore = 250.0;
        double actualScore = playerAnalyzer.calculateScore(players);

        assertEquals(expectedScore, actualScore, 0.01);
    }

    @Test
    void testCalculateScore_JuniorPlayer() {
        Player player = new Player();
        player.setAge(15);
        player.setExperience(3);
        player.setSkills(Arrays.asList(3, 3, 3));

        List<Player> players = List.of(player);

        double expectedScore = 67.5;
        double actualScore = playerAnalyzer.calculateScore(players);

        assertEquals(expectedScore, actualScore, 0.01);
    }

    @Test
    void testCalculateScore_SeniorPlayer() {
        Player player = new Player();
        player.setAge(35);
        player.setExperience(15);
        player.setSkills(Arrays.asList(4, 4, 4));

        List<Player> players = List.of(player);

        double expectedScore = 2520.0;
        double actualScore = playerAnalyzer.calculateScore(players);

        assertEquals(expectedScore, actualScore, 0.01);
    }

    @Test
    void testCalculateScore_MultiplePlayers() {
        Player player1 = new Player();
        player1.setAge(25);
        player1.setExperience(5);
        player1.setSkills(Arrays.asList(2, 2, 2));

        Player player2 = new Player();
        player2.setAge(15);
        player2.setExperience(3);
        player2.setSkills(Arrays.asList(3, 3, 3));

        List<Player> players = Arrays.asList(player1, player2);

        double expectedScore = 250.0 + 67.5;
        double actualScore = playerAnalyzer.calculateScore(players);

        assertEquals(expectedScore, actualScore, 0.01);
    }

    // Negative Test Cases

    @Test
    void testCalculateScore_NullSkills() {
        Player player = new Player();
        player.setSkills(null); // Setting skills to null

        List<Player> players = List.of(player);

        assertThrows(NullPointerException.class, () -> playerAnalyzer.calculateScore(players));
    }

    @Test
    void testCalculateScore_EmptyArray() {
        List<Player> players = new ArrayList<>(); // Empty list

        double expectedScore = 0.0;
        double actualScore = playerAnalyzer.calculateScore(players);

        assertEquals(expectedScore, actualScore, 0.01);
    }
}