package org.jhotdraw.draw.action;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jhotdraw.draw.*;
import org.jhotdraw.draw.figure.Figure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BringToFrontActionTest {
    @Mock
    private DefaultDrawingEditor editor;
    @Mock
    private DrawingView view;
    @Mock
    private Drawing drawing;
    private ArrayList<Figure> figures;
    private BringToFrontAction action;

    @Before
    public void setUp() {
        action = new BringToFrontAction(editor);
        drawing = new QuadTreeDrawing();
        figures = new ArrayList<>();
    }

    @Test
    public void testBringToFrontAction() {
        // Arrange
        Figure figure1 = mock(Figure.class);
        Figure figure2 = mock(Figure.class);
        when(figure1.getDrawingArea()).thenReturn(new Rectangle2D.Double());
        when(figure2.getDrawingArea()).thenReturn(new Rectangle2D.Double());
        figures.add(figure1);
        figures.add(figure2);
        drawing.addAll(figures);
        when(view.getDrawing()).thenReturn(drawing);


        action.arrange(view, Collections.singletonList(figure2));
        List<Figure> returnedFigures = drawing.getFiguresFrontToBack();

        // Assert
        assertEquals(returnedFigures.get(0), figure2);
    }
}

