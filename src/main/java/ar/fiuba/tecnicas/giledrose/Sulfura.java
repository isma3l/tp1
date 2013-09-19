package ar.fiuba.tecnicas.giledrose;

public class Sulfura extends Articulo {
    private final int SELLIN = 0;
    private final int QUALITY = 80;

    public Sulfura(Item item) {
        super(item);

        if(item.getSellIn() != SELLIN || item.getQuality() != QUALITY)
            throw new IllegalArgumentException("La calidad del Sulfura siempre debe ser 80 y su sellIn 0");
    }

    @Override
    protected void updateSellIn() {
        setSellIn(SELLIN);
    }

    @Override
    protected void updateQuality() {
        setQuality(QUALITY);
    }
}
