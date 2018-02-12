package project.science.chemics.atom;

import project.science.chemics.element.Element;
import project.science.chemics.ion.IonType;

public class Atom {

    private int electrons;
    private Element element;

    public Atom ( int electrons , Element element ) {

        this.electrons = electrons;
        this.element = element;

    }

    public int getElectrons () {

        return this.electrons;

    }

    public Element getElement () {

        return this.element;

    }

    public boolean isIon () {

        return ! this.getIonType().equals( IonType.NEUTRAL );

    }

    public IonType getIonType () {

        if ( this.electrons > this.element.getProtons() ) {

            return IonType.ANION;

        } else if ( this.electrons < this.element.getProtons() ) {

            return IonType.KATION;

        } else {

            return IonType.NEUTRAL;

        }

    }

}
