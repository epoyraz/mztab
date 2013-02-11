package uk.ac.ebi.pride.jmztab.parser;

import uk.ac.ebi.pride.jmztab.model.MZTabColumnFactory;
import uk.ac.ebi.pride.jmztab.model.Section;

/**
 * User: Qingwei
 * Date: 10/02/13
 */
public class PRHLineParser extends MZTabHeaderLineParser {
    /**
     * We assume that user before call this method, have check the raw line
     * is not empty line and start with section prefix.
     */
    protected PRHLineParser(String line) {
        super(line, MZTabColumnFactory.getInstance(Section.Protein_Header));
    }


}
