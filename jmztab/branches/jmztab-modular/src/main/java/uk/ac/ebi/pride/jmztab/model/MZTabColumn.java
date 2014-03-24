package uk.ac.ebi.pride.jmztab.model;

/**
 * Define a column header which used in {@link Section#Protein_Header}, {@link Section#Peptide_Header},
 * {@link Section#PSM_Header}, or {@link Section#Small_Molecule_Header}. There are two kinds of columns: stable column
 * and optional column. Stable column has stable position and header name, while optional column not.
 * {@link MZTabColumnFactory} used to create and maintain these column objects.
 *
 * @see MZTabColumnFactory
 * @see ProteinColumn
 * @see PeptideColumn
 * @see PSMColumn
 * @see SmallMoleculeColumn
 * @see OptionColumn
 * @see CVParamOptionColumn
 * @see AbundanceColumn
 *
 * User: Qingwei
 * Date: 23/05/13
 */
public class MZTabColumn {
    private final String name;
    private final String order;
    private String header;
    private String logicPosition;
    private Class dataType;
    private boolean optional;

    private IndexedElement element;

    /**
     * Create a column header object. Default, the column header keep the same value with name, and logical position keep
     * the same value with order.
     *
     * @param name define a stable name for column. For optional column, only set stable part for name.
     * @param dataType define the data type for column. When {@link MZTabRecord#setValue(String, Object)} for this column,
     *                 system will check the data type is compatible or not, firstly.
     * @param optional if false the column is stable type, otherwise is optional column.
     * @param order internal order. Every non {@link OptionColumn} has stable order. Column order is used to maintain the
     *              logical position in {@link MZTabColumnFactory}
     */
    public MZTabColumn(String name, Class dataType, boolean optional, String order) {
        if (MZTabUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Column name should not empty.");
        }
        this.name = name;

        if (dataType == null) {
            throw new NullPointerException("Column data type should not set null!");
        }
        this.dataType = dataType;

        this.optional = optional;
        this.order = order;
        this.header = name;
        this.logicPosition = order;
    }

    /**
     * Get the column name. For stable column, name and header are same. But for optional column, name is part
     * of its header. For example, optional column which header is search_engine_score_ms_run[1-n], and its name
     * is search_engine_score. Besides this, ms_run[1-n] is kind of {@link #element}
     *
     * Notice: this design pattern not fit for {@link AbundanceColumn}, {@link OptionColumn} and {@link CVParamOptionColumn}.
     * These optional columns need be generated by calling {@link MZTabColumnFactory} 's methods.
     *
     * @see #getHeader()
     * @see #setElement(IndexedElement)
     */
    public String getName() {
        return name;
    }

    /**
     * Get the column internal order. For stable column, order and logical position are same. But for optional column,
     * the logical position need to calculate by concatenate order and index element id. For example, optional column
     * search_engine_score_ms_run[2] in Protein section, its order is 09, and the logical position is 092. Because the
     * element ms_run[2] 's index is 2.
     *
     * Notice: this design pattern not fit for {@link AbundanceColumn}, {@link OptionColumn} and {@link CVParamOptionColumn}.
     * These optional columns need be generated by calling {@link MZTabColumnFactory} 's methods.
     *
     * @see #getLogicPosition()
     */
    public String getOrder() {
        return order;
    }

    /**
     * Get the column name. For stable column, name and header are same. While for optional column, name is part
     * of its header. For example, optional column which header is search_engine_score_ms_run[1-n], and its name
     * is search_engine_score.  Besides this, ms_run[1-n] is kind of {@link #element}
     *
     * Notice: this design pattern not fit for {@link AbundanceColumn}, {@link OptionColumn} and {@link CVParamOptionColumn}.
     * These optional columns need be generated by calling {@link MZTabColumnFactory} 's methods.
     *
     * @see #getName()
     * @see #setElement(IndexedElement)
     */
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * Get the column logical position. For stable column, order and logical position are same. But for optional column,
     * the logical position need to calculate by concatenate order and index element id. For example, optional column
     * search_engine_score_ms_run[2] in Protein section, its order is 09, and the logical position is 092. Because the
     * element ms_run[2] 's index is 2.
     *
     * Notice: this design pattern not fit for {@link AbundanceColumn}, {@link OptionColumn} and {@link CVParamOptionColumn}.
     * These optional columns need be generated by calling {@link MZTabColumnFactory} 's methods.
     *
     * Notice: in {@link MZTabColumnFactory}, we use logical position to maintain the logical consistence with in {@link MZTabFile},
     * Not use <P>Physical Position</P>, which the locate physical position for a concrete mzTab file. During the process of parsing
     * mzTab file, we create a mapping between physical position and internal logical position.
     *
     * @see #getOrder()
     */
    public String getLogicPosition() {
        return logicPosition;
    }

    public void setLogicPosition(String logicPosition) {
        this.logicPosition = logicPosition;
    }

    /**
     * Get the column data type Class.
     */
    public Class getDataType() {
        return dataType;
    }

    /**
     * Judge this column belong to stable column or optional column.
     */
    public boolean isOptional() {
        return optional;
    }

    /**
     * Indexed element used in optional column header and logical position definition.
     * In stable column, the return is null.
     *
     * Notice: this design pattern not fit for {@link AbundanceColumn}, {@link OptionColumn} and {@link CVParamOptionColumn}.
     * These optional columns need be generated by calling {@link MZTabColumnFactory} 's methods.
     *
     * @see #getHeader()
     * @see #getLogicPosition()
     */
    public IndexedElement getElement() {
        return element;
    }

    /**
     * Indexed element used in optional column header and logical position definition.
     * In stable column, the return is null.
     *
     * Notice: this design pattern not fit for {@link AbundanceColumn}, {@link OptionColumn} and {@link CVParamOptionColumn}.
     * These optional columns need be generated by calling {@link MZTabColumnFactory} 's methods.
     *
     * @see #getHeader()
     * @see #getLogicPosition()
     *
     * @param element SHOULD NOT set null.
     */
    void setElement(IndexedElement element) {
        if (element == null) {
            throw new NullPointerException("Can not set null indexed element for optional column!");
        }
        this.element = element;

        this.logicPosition = logicPosition + element.getId();
        StringBuilder sb = new StringBuilder();
        sb.append(this.header).append("_").append(element.getReference());
        this.header = sb.toString();
    }

    /**
     * Create a optional column for {@link Section#Protein_Header}, {@link Section#Peptide_Header},
     * {@link Section#PSM_Header}, or {@link Section#Small_Molecule_Header}.
     *
     * Notice: this function only used to create stable order optional column, such as search_engine_score_ms_run[1-n],
     * num_psms_ms_run[1-n] and so on. Not used to create {@link AbundanceColumn}, {@link OptionColumn} and
     * {@link CVParamOptionColumn}. These optional columns need be generated by calling {@link MZTabColumnFactory} 's methods.
     *
     * @see MZTabColumnFactory#addOptionalColumn(MZTabColumn, MsRun)
     */
    static MZTabColumn createOptionalColumn(Section section, MZTabColumn column, IndexedElement element) {
        if (! column.isOptional()) {
            throw new IllegalArgumentException(column + " is not optional column!");
        }

        MZTabColumn optionColumn = null;
        switch (section) {
            case Protein_Header:
                optionColumn = new ProteinColumn(column.getName(), column.getDataType(), column.isOptional(), column.getOrder());
                break;
            case Peptide_Header:
                optionColumn = new PeptideColumn(column.getName(), column.getDataType(), column.isOptional(), column.getOrder());
                break;
            case PSM_Header:
                optionColumn = new PSMColumn(column.getName(), column.getDataType(), column.isOptional(), column.getOrder());
                break;
            case Small_Molecule_Header:
                optionColumn = new SmallMoleculeColumn(column.getName(), column.getDataType(), column.isOptional(), column.getOrder());
                break;
        }

        if (optionColumn != null) {
            optionColumn.setElement(element);
        }

        return optionColumn;
    }

    @Override
    public String toString() {
        return "MZTabColumn{" +
                "header='" + header + '\'' +
                ", logicPosition='" + logicPosition + '\'' +
                ", dataType=" + dataType +
                ", optional=" + optional +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MZTabColumn column = (MZTabColumn) o;

        if (optional != column.optional) return false;
        if (dataType != null ? !dataType.equals(column.dataType) : column.dataType != null) return false;
        if (header != null ? !header.equals(column.header) : column.header != null) return false;
        if (logicPosition != null ? !logicPosition.equals(column.logicPosition) : column.logicPosition != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = header != null ? header.hashCode() : 0;
        result = 31 * result + (logicPosition != null ? logicPosition.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (optional ? 1 : 0);
        return result;
    }
}
