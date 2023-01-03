package org.jhotdraw.draw.action.acceptanceTest;

import java.util.HashSet;
import java.util.Set;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.draw.figure.Figure;

public class WhenFiguresArrange extends Stage<WhenFiguresArrange>  {

    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private Set<Figure> selectedFigures;

    private SendToBackAction sendToBackAction;
    private BringToFrontAction bringToFrontAction;

    @BeforeStage
    public void before() {
        sendToBackAction = new SendToBackAction(editor);
        bringToFrontAction = new BringToFrontAction(editor);

        selectedFigures = new HashSet<>(editor.getActiveView().getSelectedFigures());
    }

    WhenFiguresArrange sendingFiguresToBack() {
        sendToBackAction.actionPerformed(null);
        return this;
    }

    WhenFiguresArrange bringingFiguresToFront() {
        bringToFrontAction.actionPerformed(null);
        return this;
    }
}
