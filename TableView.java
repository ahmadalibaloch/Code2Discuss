public class SortableEmpJobTableView extends SortableTableView<EmployeeJob> {


    public SortableEmpJobTableView(Context context) {
        this(context, null);
    }

    public SortableEmpJobTableView(Context context, AttributeSet attributes) {
        this(context, attributes, 0);
    }

    public SortableEmpJobTableView(Context context, AttributeSet attributes, int styleAttributes) {
        super(context, attributes, styleAttributes);


        SimpleTableHeaderAdapter simpleTableHeaderAdapter = new SimpleTableHeaderAdapter(context, "Job","Status","Info");
        simpleTableHeaderAdapter.setTextColor(ContextCompat.getColor(context,R.color.table_header_text));
        setHeaderAdapter(simpleTableHeaderAdapter);

        int rowColorEven = ContextCompat.getColor(context, R.color.table_data_row_even);
        int rowColorOdd = ContextCompat.getColor(context, R.color.table_data_row_odd);
        setDataRowBackgroundProvider(TableDataRowBackgroundProviders.alternatingRowColors(rowColorEven, rowColorOdd));
        setHeaderSortStateViewProvider(SortStateViewProviders.brightArrows());

        setColumnWeight(0, 4);
        setColumnWeight(1, 4);
        setColumnWeight(2,2);

        setColumnComparator(0, EmpJobComparators.getEmpJobNameComparator());
        setColumnComparator(1, EmpJobComparators.getEmpJobNameStatus());
        setColumnComparator(2, EmpJobComparators.getEmpJobNameDescription());
    }
}