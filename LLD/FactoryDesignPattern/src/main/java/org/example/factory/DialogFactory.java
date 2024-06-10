package org.example.factory;

import org.example.interfaces.Button;

public abstract class DialogFactory {
    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    protected abstract Button createButton();
}
