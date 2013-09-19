package ar.fiuba.tecnicas.giledrose;


public class BackStage extends Articulo{
    private final int FACTOR_CALIDAD_SI_SELLIN_MAYOR_QUE_10 = 1;
    private final int FACTOR_CALIDAD_SI_SELLIN_MENOR_IGUAL_QUE_10 = 2;
    private final int FACTOR_CALIDAD_SI_SELLIN_MENOR_IGUAL_QUE_5 = 3;
    private final int LIMITE_DECIMO_DIA = 10;
    private final int LIMITE_QUINTO_DIA = 5;

    public BackStage(Item item) {
        super(item);

        if(item.getQuality() > LIMITE_CALIDAD_SUPERIOR)
            throw new IllegalArgumentException("La calidad no puede ser superar LIMITE_CALIDAD_SUPERIOR");
    }

    @Override
    protected int getQualityFactor() {
        if(getSellIn() <= LIMITE_QUINTO_DIA)
            return FACTOR_CALIDAD_SI_SELLIN_MENOR_IGUAL_QUE_5;

        return (getSellIn() <= LIMITE_DECIMO_DIA)? FACTOR_CALIDAD_SI_SELLIN_MENOR_IGUAL_QUE_10: FACTOR_CALIDAD_SI_SELLIN_MAYOR_QUE_10;
    }

    @Override
    protected void updateQuality() {
        int newQuality = ((getSellIn() <= 0)? LIMITE_CALIDAD_INFERIOR: (getQuality() + getQualityFactor()));
        setQuality(getQualityWithinRange(newQuality));
    }
}
