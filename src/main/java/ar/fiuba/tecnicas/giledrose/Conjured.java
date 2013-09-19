package ar.fiuba.tecnicas.giledrose;


public class Conjured extends Articulo{
    private final int FACTOR_CALIDAD = 2;

    public Conjured(Item item) {
        super(item);

        if(item.getQuality() > LIMITE_CALIDAD_SUPERIOR)
            throw new IllegalArgumentException("La calidad no puede ser superar LIMITE_CALIDAD_SUPERIOR");
    }

    @Override
    protected void updateQuality() {
        int newQuality = getQuality() - FACTOR_CALIDAD;
        setQuality(getQualityWithinRange(newQuality));
    }
}
