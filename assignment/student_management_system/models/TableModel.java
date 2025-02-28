package models;

public class TableModel {
    private String[] tableHeadings;
    private String[][] tableData;

    public void setTableHeadings(String[] tableHeadings) {
        this.tableHeadings = tableHeadings;
    }

    public void setTableData(String[][] tableData) {
        this.tableData = tableData;
    }

    public String[] getTableHeadings() {
        return tableHeadings;
    }

    public String[][] getTableData() {
        return tableData;
    }
}
