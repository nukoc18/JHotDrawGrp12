package org.jhotdraw.draw.action.acceptanceTest;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class ArrangeTest extends ScenarioTest<GivenFigures, WhenFiguresArrange, ThenFiguresArranged> {

    @Test
    public void selectingFiguresAndSendToBack() {
        given().selectedFigures();
        when().sendingFiguresToBack();
        then().theFiguresAreBehind();
    }

    @Test
    public void selectingFiguresAndBringToFront() {
        given().selectedFigures();
        when().bringingFiguresToFront();
        then().theFiguresAreInFront();
    }
}
