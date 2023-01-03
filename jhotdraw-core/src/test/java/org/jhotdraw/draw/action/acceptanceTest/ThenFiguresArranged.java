package org.jhotdraw.draw.action.acceptanceTest;

import java.util.*;
import org.jhotdraw.draw.*;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.figure.Figure;

import static org.junit.Assert.*;

public class ThenFiguresArranged extends Stage<ThenFiguresArranged>{
    @ExpectedScenarioState
    private DrawingEditor editor;

    @ExpectedScenarioState
    private Set<Figure> selectedFigures;

    ThenFiguresArranged theFiguresAreBehind() {
        List<Figure> viewFigures = editor.getActiveView().getDrawing().getChildren();
        int end = selectedFigures.size();

        Set<Figure> backSet = new HashSet<>(viewFigures.subList(0, end));
        assertFigure(backSet, selectedFigures);

        return this;
    }

    ThenFiguresArranged theFiguresAreInFront() {
        List<Figure> viewFigures = editor.getActiveView().getDrawing().getChildren();
        int selection = selectedFigures.size();
        int end = viewFigures.size();
        int start = end - selection;

        Set<Figure> frontSet = new HashSet<>(viewFigures.subList(start, end));
        assertFigure(frontSet, selectedFigures);

        return this;
    }

    private void assertFigure(Set<Figure> viewFigures, Set<Figure> expectedFigures) {
        assertEquals(viewFigures.size(), expectedFigures.size());
        for (Figure figure : expectedFigures) {
            assertTrue(viewFigures.contains(figure));
        }
    }
}
