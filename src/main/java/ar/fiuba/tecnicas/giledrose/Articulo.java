package ar.fiuba.tecnicas.giledrose;


public abstract class Articulo {
    private Item item;
    private final int DEGRADACION_SELLIN = 1;
    private final int FACTOR_CALIDAD_MIENTRAS_NO_CADUQUE = 1;
    private final int FACTOR_CALIDAD_DESPUES_DE_CADUCAR = 2;
    protected final int LIMITE_CALIDAD_INFERIOR = 0;
    protected final int LIMITE_CALIDAD_SUPERIOR = 50;

    public Articulo(Item item) {
        this.item = item;

        if(item.getQuality() < LIMITE_CALIDAD_INFERIOR)
            throw new IllegalArgumentException("La calidad no puede ser negativa");
    }

    protected int getSellIn() {
        return item.getSellIn();
    }

    protected void setSellIn(int sellIn) {
        item.setSellIn(sellIn);
    }

    protected int getQuality() {
        return item.getQuality();
    }

    protected  void setQuality(int quality) {
        item.setQuality(quality);
    }

    public void update() {
        updateQuality();
        updateSellIn();
    }

    protected int getQualityWithinRange(int quality) {
        if(quality < LIMITE_CALIDAD_INFERIOR)
            return LIMITE_CALIDAD_INFERIOR;
        if(quality > LIMITE_CALIDAD_SUPERIOR)
            return  LIMITE_CALIDAD_SUPERIOR;
        return quality;
    }

    protected int getQualityFactor() {
        return (getSellIn() > 0)? FACTOR_CALIDAD_MIENTRAS_NO_CADUQUE: FACTOR_CALIDAD_DESPUES_DE_CADUCAR;
    }

    protected void updateSellIn() {
        setSellIn(getSellIn() - DEGRADACION_SELLIN);
    }

    protected abstract void updateQuality();

}

