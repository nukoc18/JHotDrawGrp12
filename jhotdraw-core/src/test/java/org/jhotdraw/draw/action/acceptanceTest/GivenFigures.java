package org.jhotdraw.draw.action.acceptanceTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;

public class GivenFigures extends Stage<GivenFigures> {

    @ProvidedScenarioState
    private DrawingEditor editor;

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }

    GivenFigures selectedFigures() {
        // Create figures
        Figure figure1 = new SVGRectFigure();
        Figure figure2 = new SVGRectFigure();

        // Add figures to drawing and select them
        editor.getActiveView().getDrawing().add(figure1);
        editor.getActiveView().getDrawing().add(figure2);
        editor.getActiveView().addToSelection(figure1);
        editor.getActiveView().addToSelection(figure2);

        return this;
    }
    
}
