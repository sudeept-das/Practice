package org.example.concreteObject;

import org.example.factory.DialogFactory;
import org.example.interfaces.Button;

public class WindowsDialog extends DialogFactory {
    @Override
    protected Button createButton() {
        return new WindowsButton();
    }
}
