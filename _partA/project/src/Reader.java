


public interface Reader {
    Project readNextProject();
    void reset();
    boolean hasNext();
}