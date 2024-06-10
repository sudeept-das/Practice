package org.example.concreteObject;

import org.example.factory.DialogFactory;
import org.example.interfaces.Button;

public class HtmlDialog extends DialogFactory {

    @Override
    protected Button createButton() {
        return new HtmlButton();
    }
}
