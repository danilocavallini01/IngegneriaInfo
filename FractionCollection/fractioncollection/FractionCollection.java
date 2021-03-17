package fractioncollection;
import frazione.Frazione;

public class FractionCollection {
    

    private final static int DEFAULT_GROWTH_FACTOR = 2;
    private final static int DEFAULT_PHYSICAL_SIZE = 10;
    private Frazione[] innerContainer;
    private int size;

    public FractionCollection() {
        this(DEFAULT_PHYSICAL_SIZE);
    }

    public FractionCollection(int size) {
        this.innerContainer = new Frazione[size];
        this.size = 0;
    }

    public FractionCollection(Frazione[] outerContainer) {
        this();

        for(Frazione f : outerContainer) {
            if(!isNull(f)) {
                this.put(f);
            }
        }
    }

    private boolean isNull( Frazione f ) {
        return f == null;
    }

    private boolean isFull() {
        return this.size >= this.innerContainer.length;
    }

    public int size() {
        return this.size;
    }

    public Frazione get(int index) {
        if(index < 0 || index > this.size) {
            return null;
        }
        return this.innerContainer[index];
    }

    public void put(Frazione add) {
        if(isFull()) {

            Frazione[] collection = new Frazione[this.size * DEFAULT_GROWTH_FACTOR];
            int tempsize = 0;

            for(Frazione f: this.innerContainer) {
                if(!isNull(f)) {
                    collection[tempsize++] = f;
                }
            }

            collection[tempsize++] = add;

            this.size = tempsize;
            this.innerContainer = collection;
        } else {
            innerContainer[this.size++] = add;
        }
    }

    public void remove(int index) {
        if(index >= this.size ) {
            return;
        }

        innerContainer[index] = null;
        for(int i = index; i< size; i++) {
            innerContainer[i] = innerContainer[i+1];
        }

        size--;
    }

    public FractionCollection sum(FractionCollection collect) {
        if(this.size() != collect.size()) {
            return null;
        }

        Frazione[] result = new Frazione[collect.size()];

        for (int i = 0; i < collect.size(); i++) {
            result[i] = this.get(i).sum(collect.get(i));
        }

        return new FractionCollection(result);
    } 

    public FractionCollection mul(FractionCollection collect) {
        if(this.size() != collect.size()) {
            return null;
        }

        Frazione[] result = new Frazione[collect.size()];

        for (int i = 0; i < collect.size() - 1; i++) {
            result[i] = this.get(i).mul(collect.get(i));
        }

        return new FractionCollection(result);
    } 


    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < size; i++) {
            result.append(innerContainer[i].toString()).append(" <> ");
        }

        return result.toString();
    }

}