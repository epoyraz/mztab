package uk.ac.ebi.pride.jmztab.utils.parser;

import uk.ac.ebi.pride.jmztab.model.MZTabColumnFactory;
import uk.ac.ebi.pride.jmztab.model.Metadata;
import uk.ac.ebi.pride.jmztab.model.Section;
import uk.ac.ebi.pride.jmztab.utils.errors.MZTabException;

/**
 * User: Qingwei
 * Date: 10/02/13
 */
public class SMHLineParser extends MZTabHeaderLineParser {
    public SMHLineParser(Metadata metadata) {
        super(MZTabColumnFactory.getInstance(Section.Small_Molecule_Header), metadata);
    }

    public void parse(int lineNumber, String line) throws MZTabException {
        super.parse(lineNumber, line);
    }
}
