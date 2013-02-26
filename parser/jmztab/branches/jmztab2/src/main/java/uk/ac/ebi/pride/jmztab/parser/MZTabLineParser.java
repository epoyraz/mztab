package uk.ac.ebi.pride.jmztab.parser;

import uk.ac.ebi.pride.jmztab.errors.FormatErrorType;
import uk.ac.ebi.pride.jmztab.errors.MZTabError;
import uk.ac.ebi.pride.jmztab.errors.MZTabException;
import uk.ac.ebi.pride.jmztab.model.Section;
import uk.ac.ebi.pride.jmztab.utils.MZTabConstants;

/**
 * User: Qingwei
 * Date: 10/02/13
 */
public class MZTabLineParser {
    protected int lineNumber;

    protected Section section;

    /**
     * based on TAB char to split raw line into String array.
     */
    protected String[] items;

    /**
     * We assume that user before call this method, have check the raw line
     * is not empty line and start with section prefix.
     */
    protected void check(int lineNumber, String line) throws MZTabException {
        this.lineNumber = lineNumber;

        this.items = line.split("\\s*" + MZTabConstants.TAB + "\\s*");
        items[0] = items[0].trim();
        items[items.length - 1] = items[items.length - 1].trim();

        section = Section.findSection(items[0]);

        if (section == null) {
            MZTabError error = new MZTabError(FormatErrorType.LinePrefix, lineNumber, items[0]);
            throw new MZTabException(error);
        }
    }
}
