/*
 * @(#)BringToFrontAction.java
 *
 * Copyright (c) 2003-2008 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.draw.action;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.draw.*;


/**
 * ToFrontAction.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public class BringToFrontAction extends ArrangeAction {

    private static final long serialVersionUID = 1L;
    public static final String ID = "edit.bringToFront";

    /**
     * Creates a new instance.
     */
    public BringToFrontAction(DrawingEditor editor) {
        super(editor, "front", ID);
    }
}
