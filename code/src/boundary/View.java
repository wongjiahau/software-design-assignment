package boundary;

import java.util.ArrayList;
import java.util.HashMap;

import libs.IStream;
import libs.Prompter;
import libs.StringUtil;

public class View {
    protected IStream stream;
    protected Prompter prompter;
    public View(IStream stream) {
        this.stream = stream;
        this.prompter = new Prompter(stream);
    }

    protected void displayTitle(String title) {
        String line = "";
        for (int i = 0; i < title.length(); i++) {
            line += "=";
        }
        this.stream.printLine(line);
        this.stream.printLine(title.toUpperCase());
        this.stream.printLine(line);
    }

    /**
     * @param header Should be delimited by comma. Example: "id,name,age"
     * @param rows Data should be delimited by comma. Example: ["1,John,12","2,Kim,13"]
     */
    public void displayTable(String header, ArrayList<String> rows) {
        final int MARGIN = 3;
        ArrayList<String> allRows = new ArrayList<String>();
        allRows.add(header);
        allRows.addAll(rows);

        HashMap<Integer, ArrayList<String>> columns = new HashMap<Integer, ArrayList<String>>();
        for (int i = 0; i < allRows.size(); i++) {
            String row = allRows.get(i);
            String[] data = row.split(",");
            for (int j = 0; j < data.length; j++) {
                if(columns.get(j) == null) {
                    columns.put(j, new ArrayList<String>());
                }
                columns.get(j).add(data[j]);
            }
        }

        for (int i = 0; i < columns.size(); i++) {
            ArrayList<String> col = columns.get(i);
            int maxLength = 0;
            for (int j = 0; j < col.size(); j++) {
                String data = col.get(j);
                if(data.length() > maxLength) {
                    maxLength = data.length();
                }
            }
            maxLength += MARGIN;
            for (int j = 0; j < col.size(); j++) {
               col.set(j, StringUtil.padRight(col.get(j), maxLength));
            }
        }
        
        for (int i = 0; i < columns.get(0).size(); i++) {
            for (int j = 0; j < columns.size(); j++) {
                this.stream.print(columns.get(j).get(i));
            }
            this.stream.print("\n");
        }
    }

}
