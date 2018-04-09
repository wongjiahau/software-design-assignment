package libs;

public interface IStream {
    String getNextLine();
    void print(String message);
    void printLine(String message);
    void pressAnyKeyToContinue();
}
