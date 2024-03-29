package com.myob.iris.controller;

import com.myob.iris.model.Color;
import com.myob.iris.model.GameState;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class GameCoreTest {
    private Referee referee = new Referee();
    private ColorMatcher colorMatcher = new ColorMatcher();
    private GameState gameState59Attempts = new GameState(false, 59);
    private GameState gameState60Attempts = new GameState(false, 60);
    private List<Color> masterColor = new ArrayList<>() {{
        add(Color.Orange);
        add(Color.Blue);
        add(Color.Red);
        add(Color.Yellow);
    }};
    private List<Color> humanColorMatch = new ArrayList<>() {{
        add(Color.Orange);
        add(Color.Blue);
        add(Color.Red);
        add(Color.Yellow);
    }};
    private List<Color> humanColorDoNotMatch = new ArrayList<>() {{
        add(Color.Green);
        add(Color.Green);
        add(Color.Purple);
        add(Color.Purple);
    }};
    private GameCore core = new GameCore(masterColor, referee, colorMatcher);

    @Test
    public void givenNoMatchHumanColor59AttemptsSetGameStateFalseIncreaseAttemptsBy1() {
        core.play(humanColorDoNotMatch, gameState59Attempts);
        assertThat(gameState59Attempts.isWon(), equalTo(false));
        assertThat(gameState59Attempts.getAttempts(), equalTo(60));
    }

    @Test
    public void givenMatchHumanColor59AttemptsSetGameStateTrueIncreaseAttemptsBy1() {
        core.play(humanColorMatch, gameState59Attempts);
        assertThat(gameState59Attempts.isWon(), equalTo(true));
        assertThat(gameState59Attempts.getAttempts(), equalTo(60));
    }

    @Test
    public void givenMatchHumanColor60AttemptsSetGameStateTrueIncreaseAttemptsBy1() {
        core.play(humanColorMatch, gameState60Attempts);
        assertThat(gameState60Attempts.isWon(), equalTo(true));
        assertThat(gameState60Attempts.getAttempts(), equalTo(61));
    }
}