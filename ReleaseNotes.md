**jmzTab version 3.0.2 - (12. Febreruary 2015)**
  * general refinements and bug fixing
  * removes from the mzTabCLI the need to separate the input and output directory from the file
  * allow parsing the file with the columns in different order to the one define in the specification. Due to this new feature the defaults columns need to be added manually to the factory. Examples:

```

MZTabColumnFactory prh = MZTabColumnFactory.getInstance(Section.Protein_Header);
prh.addDefaultStableColumns();
// add other optional columns
prh.addBestSearchEngineScoreOptionalColumn(ProteinColumn.BEST_SEARCH_ENGINE_SCORE, 1);

MZTabColumnFactor peh = MZTabColumnFactory.getInstance(Section.Peptide_Header);
peh.addDefaultStableColumns();
// add other optional columns
peh.addBestSearchEngineScoreOptionalColumn(ProteinColumn.BEST_SEARCH_ENGINE_SCORE, 1);

MZTabColumnFactory psh = MZTabColumnFactory.getInstance(Section.PSM_Header);
psh.addDefaultStableColumns();
// add other optional columns
psh.addSearchEngineScoreOptionalColumn(PSMColumn.SEARCH_ENGINE_SCORE, 1, null);

MZTabColumnFactory smh = MZTabColumnFactory.getInstance(Section.PSM_Header);
smh.addDefaultStableColumns();
// add other optional columns
smh.addSearchEngineScoreOptionalColumn(PSMColumn.SEARCH_ENGINE_SCORE, 1, null);
```


---

**mzTab Specification Document 1.0.0 - final version (20. June 2014)**
  * Final version 1.0.0 of the mzTab file format


---

**jmzTab version 3.0.0 - (1. August 2014)**
  * update version of the library to the Specification Document 1.0 RC 5 - (30. June 2014)
  * new modular version of the jmzTab library. This version allows a easier integration in other projects because minimizes the number dependencies per module.
  * first version of mzIdentML converter
  * general refinements and bug fixing
  * update mzTab examples


---

**mzTab Specification Document 1.0 RC 5 - (11. December 2013)**
  * A completely updated version of the mzTab format specification
  * Version currently submitted to the PSI document process


---

**jmzTab version 2.1.5 - (5. December 2013)**
  * Fixed bugs
  * Add SmallMoleculeTest to generate a mztab file which including small molecule records.
  * Move conf/**.properties to src/resources/conf/**.properties, thus, the jar file will include these property files.
  * Create SearchEngineParam and SearchEngineScoreParam
  * Redefine ConvertProvider class
  * Update mzTab examples


---

**jmzTab version 2.1.4 - (5. November 2013)**
  * update metadata, add id number for some elements.
  * uploaded new mzTab example files (validated with jmzTab)


---

**jmzTab version 2.1.3 - (18. October 2013)**
  * export pride-q to mzTab
  * export PRIDE XML to mzTab


---

**jmzTab version 2.1.2 - (18. September 2013)**
  * Modify MZTabCommandLine and MZTabInspector
  * Allow user exchange the order of columns in table based section.


---

**jmzTab version 2.1.1 - (9. July 2013)**
  * modify table-style section header and record fill based on newest specification.
  * Add MZTabUtilTest and fixed a bug in parsing modification.
  * Add a lots of test cases.


---

**jmzTab version 2.1.0 - (14. Juny 2013)**
  * Reorganized the API package structure based on mzTab specification version 1.0 release candidate 4.
  * implement prideq export mztab


---

**jmzTab version 2.0.5 - (3. April 2013)**
  * Add simple GUI -- MZTabInspector
  * Update wiki documents.


---

**jmzTab version 2.0.4 - (25. March 2013)**
  * Modify MZTabErrorList
  * Modify command line interface
  * Create a MZTabFileChecker, which used to check MZTabFile internal constraints.
  * remove AbstractMZTabRecord to MZTabRecord


---

**jmzTab version 2.0.3 - (21. March 2013)**
  * fixed some bugs in model.
  * fixed command line interface and provide some demo (see demo.bat in testset directory)
  * modify assembly.xml, implement maven package command.


---

**jmzTab version 2.0.2 - (11. March 2013)**
  * modify MZTabFile, make the model package to a independent model.
  * modify MZTabFileParser, parse a text file and generate MZTabFile model.
  * finish PRIDE XML convert to mzTab
  * modify command line interface


---

**jmzTab version 2.0.1 - (4. March 2013)**
  * Enrich the methods of jmztab model.
  * Modify model, add property change listener into Metadata, SubUnit and MZTabColumnFactory. Create a OperationCenter used to operator property change event.
  * Finish MZTabFileMerger


---

**jmzTab version 2.0 - (26. February 2013)**
  * Reorganized the jmzTab API, based on mzTab specification version 1.0 release candidate 2.
  * add load function, load a table line into a record.
  * Rename PeptideRecord --> Peptide, ProteinRecord --> Protein,
  * SmallMoleculeRecord --> SmallMolecule
  * Alter Software, Email check level from error to warn
  * Add Command Line Interface, MZTabCommandLine
  * Add MZTabFile to buffered the tabFile into memory.


---

**jmzTab version 1.0.9 - (18. February 2013)**
  * Added support for the latest version of the mzTab specification:
  * BUGFIX: Fixed null pointer exception when accessing msFiles in a file that doesn't contain any.


---

**jmzTab version 1.0.8 - (21. May 2012)**
  * BUGFIX: Unit.setPublication() checks null values now.


---

**jmzTab version 1.0.7 - (4. May 2012)**
  * **CHANGED NAME**: Changed name from mztab-java to jmzTab. Packages are now uk.ac.ebi.pride.jmztab.
  * NEW FEATURE: Updated library to support mzTab 0.9.2
    * Only uses "NA" to report missing values
    * Added "smiles" and "inchi\_key" columns to the small molecules section.


---

**mztab-java version 1.0.6 - (24. April 2012)**
  * BUGFIX: Test cases contained strings where the Tab character was not escaped.


---

**mztab-java version 1.0.5 - (7. March 2012)**
  * BUGFIX: Fixed two bugs that cause NULL pointer exceptions in case string values were set to NULL.


---

**mztab-java version 1.0.4 - (6. March 2012)**
  * NEW FEATURE: Updated to support mzTab version 0.8.
  * NEW FEATURE: Added additional checks to make sure the set values are valid.

---

**mztab-java version 1.0.3 - (24. November 2011)**

  * NEW FEATURE: Updated to support mzTab version 0.7. Renamed Subsample get/setQuantitationReagent to get/setQuantificationReagent.


---

**mztab-java version 1.0.2 - (14. November 2011)**

  * NEW FEATURE: Added additional constructor to SpecRef.
  * NEW FEATURE: Added function addSpecRef to Peptide and SmallMolecule to set spectrum references more easily.
  * BUGFIX: Fixed a bug in Unit::setMsFile that caused a null pointer exception.


---

**mztab-java version 1.0.1 - (14. November 2011)**

  * NEW FEATURE: Added support for mzTab version 0.6 (ms\_file references in Unit, spec\_refs in Peptide and SmallMolecule, optional positions in modifications)


---

**mztab-java version 1.0.0 - (4. November 2011)**

  * NEW FEATURE: Added additional function to generate mzTab string with a custom number of subsamples and optional columns.
  * NEW FEATURE: Protein, Peptide, and SmallMolecule function names made more consistent. **WARNING**: Several function names changed. Please do check your code when updating to this version.
  * BUGFIX: Custom columns were not written to the mzTab file if a custom column was added during editing.
  * BUGFIX: Quantitative values were not written to the mzTab file if a subsample was added during editing.
  * NEW FEATURE: Added support for '"' encapsulated fields.
  * NEW FEATURE: Incorporated changes proposed by Julian Uszkoreit. Changed all toMzTab functions to use StringBuffer for better performance.
  * First stable version of the mztab-java API

---