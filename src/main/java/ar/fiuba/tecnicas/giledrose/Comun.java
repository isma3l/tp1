package ar.fiuba.tecnicas.giledrose;

public class Comun extends Articulo {

    public Comun(Item item) {
        super(item);

        if(item.getQuality() > LIMITE_CALIDAD_SUPERIOR)
            throw new IllegalArgumentException("La calidad no puede ser superar LIMITE_CALIDAD_SUPERIOR");
    }

    @Override
    protected void updateQuality() {
        int newQuality = getQuality() - getQualityFactor();
        setQuality(getQualityWithinRange(newQuality));
    }
}
