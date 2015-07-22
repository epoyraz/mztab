


---


# Introduction #

The metadata section can provide additional information about the dataset(s) reported in the mzTab file. All fields in the metadata section are optional apart from five exceptions:
  * "mzTab-version" MUST always be reported.
  * "mzTab-mode" MUST always be reported. Two modes are possible: 'Summary' and 'Complete'.
  * "mzTab-type" MUST  always be reported. Two types are possible: 'Quantification' or 'Identification'. Any analyses generating both quantification and identification results MUST be flagged as 'Quantification'.
  * "description" MUST  always be reported.
  * "ms\_run-location[1-n]" MUST  always be reported.

# Create Metadata #
```
        MZTabDescription tabDescription = new MZTabDescription(MZTabDescription.Mode.Summary, MZTabDescription.Type.Identification);
        tabDescription.setId("PRIDE_1234");
        Metadata mtd = new Metadata(tabDescription);

        mtd.setTitle("My first test experiment");
        mtd.setDescription("An experiment investigating the effects of Il-6.");

        mtd.addSampleProcessingParam(1, new CVParam("SEP", "SEP:00173", "SDS PAGE", null));
        mtd.addSampleProcessingParam(2, new CVParam("SEP", "SEP:00142", "enzyme digestion", null));
        mtd.addSampleProcessingParam(2, new CVParam("MS", "MS:1001251", "Trypsin", null));

        mtd.addInstrumentName(1, new CVParam("MS", "MS:100049", "LTQ Orbitrap", null));
        mtd.addInstrumentName(2, new CVParam("MS", "MS:1000031", "Instrument model", "name of the instrument not included in the CV"));
        mtd.addInstrumentSource(1, new CVParam("MS", "MS:1000073", "ESI", null));
        mtd.addInstrumentSource(2, new CVParam("MS", "MS:1000598", "ETD", null));
        mtd.addInstrumentAnalyzer(1, new CVParam("MS", "MS:1000291", "linear ion trap", null));
        mtd.addInstrumentAnalyzer(2, new CVParam("MS", "MS:1000484", "orbitrap", null));
        mtd.addInstrumentDetector(1, new CVParam("MS", "MS:1000253", "electron multiplier", null));
        mtd.addInstrumentDetector(2, new CVParam("MS", "MS:1000348", "focal plane collector", null));

        mtd.addSoftwareParam(1, new CVParam("MS", "MS:1001207", "Mascot", "2.3"));
        mtd.addSoftwareParam(2, new CVParam("MS", "MS:1001561", "Scaffold", "1.0"));
        mtd.addSoftwareSetting(1, "Fragment tolerance = 0.1Da");
        mtd.addSoftwareSetting(1, "Parent tolerance = 0.5Da");

        mtd.addProteinSearchEngineScoreParam(1, new CVParam("MS", "MS:1001171", "Mascot:score", null));
        mtd.addPeptideSearchEngineScoreParam(1, new CVParam("MS", "MS:1001153", "search engine specific score", null));
        mtd.addSmallMoleculeSearchEngineScoreParam(1, new CVParam("MS", "MS:1001420", "SpectraST:delta", null));

        mtd.addPsmSearchEngineScoreParam(1, new CVParam("MS", "MS:1001330", "X!Tandem:expect", null));
        mtd.addPsmSearchEngineScoreParam(2, new CVParam("MS", "MS:1001331", "X!Tandem:hyperscore", null));

        mtd.addFalseDiscoveryRateParam(new CVParam("MS", "MS:1001364", "pep:global FDR", "0.01"));
        mtd.addFalseDiscoveryRateParam(new CVParam("MS", "MS:1001214", "pep:global FDR", "0.08"));

        mtd.addPublicationItem(1, PublicationItem.Type.PUBMED, "21063943");
        mtd.addPublicationItem(1, PublicationItem.Type.DOI, "10.1007/978-1-60761-987-1_6");
        mtd.addPublicationItem(2, PublicationItem.Type.PUBMED, "20615486");
        mtd.addPublicationItem(2, PublicationItem.Type.DOI, "10.1016/j.jprot.2010.06.008");

        mtd.addContactName(1, "James D. Watson");
        mtd.addContactName(2, "Francis Crick");
        mtd.addContactAffiliation(1, "Cambridge University, UK");
        mtd.addContactAffiliation(2, "Cambridge University, UK");
        mtd.addContactEmail(1, "watson@cam.ac.uk");
        mtd.addContactEmail(2, "crick@cam.ac.uk");

        mtd.addUri(new URI("http://www.ebi.ac.uk/pride/url/to/experiment"));
        mtd.addUri(new URI("http://proteomecentral.proteomexchange.org/cgi/GetDataset"));

        mtd.addFixedModParam(1, new CVParam("UNIMOD", "UNIMOD:4", "Carbamidomethyl", null));
        mtd.addFixedModSite(1, "M");
        mtd.addFixedModParam(2, new CVParam("UNIMOD", "UNIMOD:35", "Oxidation", null));
        mtd.addFixedModSite(2, "N-term");
        mtd.addFixedModParam(3, new CVParam("UNIMOD", "UNIMOD:1", "Acetyl", null));
        mtd.addFixedModPosition(3, "Protein C-term");

        mtd.addVariableModParam(1, new CVParam("UNIMOD", "UNIMOD:21", "Phospho", null));
        mtd.addVariableModSite(1, "M");
        mtd.addVariableModParam(2, new CVParam("UNIMOD", "UNIMOD:35", "Oxidation", null));
        mtd.addVariableModSite(2, "N-term");
        mtd.addVariableModParam(3, new CVParam("UNIMOD", "UNIMOD:1", "Acetyl", null));
        mtd.addVariableModPosition(3, "Protein C-term");

        mtd.setQuantificationMethod(new CVParam("MS", "MS:1001837", "iTRAQ quantitation analysis", null));
        mtd.setProteinQuantificationUnit(new CVParam("PRIDE", "PRIDE:0000395", "Ratio", null));
        mtd.setPeptideQuantificationUnit(new CVParam("PRIDE", "PRIDE:0000395", "Ratio", null));
        mtd.setSmallMoleculeQuantificationUnit(new CVParam("PRIDE", "PRIDE:0000395", "Ratio", null));

        mtd.addMsRunFormat(1, new CVParam("MS", "MS:1000584", "mzML file", null));
        mtd.addMsRunFormat(2, new CVParam("MS", "MS:1001062", "Mascot MGF file", null));
        mtd.addMsRunLocation(1, new URL("file://ftp.ebi.ac.uk/path/to/file"));
        mtd.addMsRunLocation(2, new URL("ftp://ftp.ebi.ac.uk/path/to/file"));
        mtd.addMsRunIdFormat(1, new CVParam("MS", "MS:1001530", "mzML unique identifier", null));
        mtd.addMsRunFragmentationMethod(1, new CVParam("MS", "MS:1000133", "CID", null));
        mtd.addMsRunHash(2, "de9f2c7fd25e1b3afad3e85a0bd17d9b100db4b3");
        mtd.addMsRunHashMethod(2, new CVParam("MS", "MS:1000569", "SHA-1", null));
//        mtd.addMsRunFragmentationMethod(2, new CVParam("MS", "MS:1000422", "HCD", null));

        mtd.addCustom(new UserParam("MS operator", "Florian"));

        mtd.addSampleSpecies(1, new CVParam("NEWT", "9606", "Homo sapiens (Human)", null));
        mtd.addSampleSpecies(1, new CVParam("NEWT", "573824", "Human rhinovirus 1", null));
        mtd.addSampleSpecies(2, new CVParam("NEWT", "9606", "Homo sapiens (Human)", null));
        mtd.addSampleSpecies(2, new CVParam("NEWT", "12130", "Human rhinovirus 2", null));
        mtd.addSampleTissue(1, new CVParam("BTO", "BTO:0000759", "liver", null));
        mtd.addSampleCellType(1, new CVParam("CL", "CL:0000182", "hepatocyte", null));
        mtd.addSampleDisease(1, new CVParam("DOID", "DOID:684", "hepatocellular carcinoma", null));
        mtd.addSampleDisease(1, new CVParam("DOID", "DOID:9451", "alcoholic fatty liver", null));
        mtd.addSampleDescription(1, "Hepatocellular carcinoma samples.");
        mtd.addSampleDescription(2, "Healthy control samples.");
        mtd.addSampleCustom(1, new UserParam("Extraction date", "2011-12-21"));
        mtd.addSampleCustom(1, new UserParam("Extraction reason", "liver biopsy"));

        Sample sample1 = mtd.getSampleMap().get(1);
        Sample sample2 = mtd.getSampleMap().get(2);
        mtd.addAssayQuantificationReagent(1, new CVParam("PRIDE", "PRIDE:0000114", "iTRAQ reagent", "114"));
        mtd.addAssayQuantificationReagent(2, new CVParam("PRIDE", "PRIDE:0000115", "iTRAQ reagent", "115"));
        mtd.addAssayQuantificationReagent(1, new CVParam("PRIDE", "MS:1002038", "unlabeled sample", null));
        mtd.addAssaySample(1, sample1);
        mtd.addAssaySample(2, sample2);

        mtd.addAssayQuantificationModParam(2, 1, new CVParam("UNIMOD", "UNIMOD:188", "Label:13C(6)", null));
        mtd.addAssayQuantificationModParam(2, 2, new CVParam("UNIMOD", "UNIMOD:188", "Label:13C(6)", null));
        mtd.addAssayQuantificationModSite(2, 1, "R");
        mtd.addAssayQuantificationModSite(2, 2, "K");
        mtd.addAssayQuantificationModPosition(2, 1, "Anywhere");
        mtd.addAssayQuantificationModPosition(2, 2, "Anywhere");

        MsRun msRun1 = mtd.getMsRunMap().get(1);
        mtd.addAssayMsRun(1, msRun1);

        Assay assay1 = mtd.getAssayMap().get(1);
        Assay assay2 = mtd.getAssayMap().get(2);

        mtd.addStudyVariableAssay(1, assay1);
        mtd.addStudyVariableAssay(1, assay2);
        mtd.addStudyVariableSample(1, sample1);
        mtd.addStudyVariableDescription(1, "description Group B (spike-in 0.74 fmol/uL)");

        mtd.addStudyVariableAssay(2, assay1);
        mtd.addStudyVariableAssay(2, assay2);
        mtd.addStudyVariableSample(2, sample1);
        mtd.addStudyVariableDescription(2, "description Group B (spike-in 0.74 fmol/uL)");

        mtd.addCVLabel(1, "MS");
        mtd.addCVFullName(1, "MS");
        mtd.addCVVersion(1, "3.54.0");
        mtd.addCVURL(1, "http://psidev.cvs.sourceforge.net/viewvc/psidev/psi/psi-ms/mzML/controlledVocabulary/psi-ms.obo");

        mtd.addProteinColUnit(ProteinColumn.RELIABILITY, new CVParam("MS", "MS:00001231", "PeptideProphet:Score", null));

        MZTabColumnFactory peptideFactory = MZTabColumnFactory.getInstance(Section.Peptide);
        peptideFactory.addDefaultStableColumns();

        PeptideColumn peptideColumn = (PeptideColumn) peptideFactory.findColumnByHeader("retention_time");
        mtd.addPeptideColUnit(peptideColumn, new CVParam("UO", "UO:0000031", "minute", null));

        mtd.addPSMColUnit(PSMColumn.RETENTION_TIME, new CVParam("UO", "UO:0000031", "minute", null));
        mtd.addSmallMoleculeColUnit(SmallMoleculeColumn.RETENTION_TIME, new CVParam("UO", "UO:0000031", "minute", null));
```

  * The output
```
MTD	mzTab-version	1.0
MTD	mzTab-mode	Summary
MTD	mzTab-type	Identification
MTD	mzTab-ID	PRIDE_1234
MTD	title	My first test experiment
MTD	description	An experiment investigating the effects of Il-6.
MTD	sample_processing[1]	[SEP, SEP:00173, SDS PAGE, ]
MTD	sample_processing[2]	[SEP, SEP:00142, enzyme digestion, ]|[MS, MS:1001251, Trypsin, ]
MTD	instrument[1]-name	[MS, MS:100049, LTQ Orbitrap, ]
MTD	instrument[1]-source	[MS, MS:1000073, ESI, ]
MTD	instrument[1]-analyzer[1]	[MS, MS:1000291, linear ion trap, ]
MTD	instrument[1]-detector	[MS, MS:1000253, electron multiplier, ]
MTD	instrument[2]-name	[MS, MS:1000031, Instrument model, name of the instrument not included in the CV]
MTD	instrument[2]-source	[MS, MS:1000598, ETD, ]
MTD	instrument[2]-analyzer[1]	[MS, MS:1000484, orbitrap, ]
MTD	instrument[2]-detector	[MS, MS:1000348, focal plane collector, ]
MTD	software[1]	[MS, MS:1001207, Mascot, 2.3]
MTD	software[1]-setting[1]	Fragment tolerance = 0.1Da
MTD	software[1]-setting[2]	Parent tolerance = 0.5Da
MTD	software[2]	[MS, MS:1001561, Scaffold, 1.0]
MTD	protein_search_engine_score[1]	[MS, MS:1001171, Mascot:score, ]
MTD	peptide_search_engine_score[1]	[MS, MS:1001153, search engine specific score, ]
MTD	psm_search_engine_score[1]	[MS, MS:1001330, X!Tandem:expect, ]
MTD	psm_search_engine_score[2]	[MS, MS:1001331, X!Tandem:hyperscore, ]
MTD	smallmolecule_search_engine_score[1]	[MS, MS:1001420, SpectraST:delta, ]
MTD	false_discovery_rate	[MS, MS:1001364, pep:global FDR, 0.01]|[MS, MS:1001214, pep:global FDR, 0.08]
MTD	publication[1]	pubmed:21063943|doi:10.1007/978-1-60761-987-1_6
MTD	publication[2]	pubmed:20615486|doi:10.1016/j.jprot.2010.06.008
MTD	contact[1]-name	James D. Watson
MTD	contact[1]-affiliation	Cambridge University, UK
MTD	contact[1]-email	watson@cam.ac.uk
MTD	contact[2]-name	Francis Crick
MTD	contact[2]-affiliation	Cambridge University, UK
MTD	contact[2]-email	crick@cam.ac.uk
MTD	uri[1]	http://www.ebi.ac.uk/pride/url/to/experiment
MTD	uri[2]	http://proteomecentral.proteomexchange.org/cgi/GetDataset
MTD	fixed_mod[1]	[UNIMOD, UNIMOD:4, Carbamidomethyl, ]
MTD	fixed_mod[1]-site	M
MTD	fixed_mod[2]	[UNIMOD, UNIMOD:35, Oxidation, ]
MTD	fixed_mod[2]-site	N-term
MTD	fixed_mod[3]	[UNIMOD, UNIMOD:1, Acetyl, ]
MTD	fixed_mod[3]-position	Protein C-term
MTD	variable_mod[1]	[UNIMOD, UNIMOD:21, Phospho, ]
MTD	variable_mod[1]-site	M
MTD	variable_mod[2]	[UNIMOD, UNIMOD:35, Oxidation, ]
MTD	variable_mod[2]-site	N-term
MTD	variable_mod[3]	[UNIMOD, UNIMOD:1, Acetyl, ]
MTD	variable_mod[3]-position	Protein C-term
MTD	quantification_method	[MS, MS:1001837, iTRAQ quantitation analysis, ]
MTD	protein-quantification_unit	[PRIDE, PRIDE:0000395, Ratio, ]
MTD	peptide-quantification_unit	[PRIDE, PRIDE:0000395, Ratio, ]
MTD	small_molecule-quantification_unit	[PRIDE, PRIDE:0000395, Ratio, ]
MTD	ms_run[1]-format	[MS, MS:1000584, mzML file, ]
MTD	ms_run[1]-location	file://ftp.ebi.ac.uk/path/to/file
MTD	ms_run[1]-id_format	[MS, MS:1001530, mzML unique identifier, ]
MTD	ms_run[1]-fragmentation_method	[MS, MS:1000133, CID, ]
MTD	ms_run[2]-format	[MS, MS:1001062, Mascot MGF file, ]
MTD	ms_run[2]-location	ftp://ftp.ebi.ac.uk/path/to/file
MTD	ms_run[2]-hash	de9f2c7fd25e1b3afad3e85a0bd17d9b100db4b3
MTD	ms_run[2]-hash_method	[MS, MS:1000569, SHA-1, ]
MTD	sample[1]-species[1]	[NEWT, 9606, Homo sapiens (Human), ]
MTD	sample[1]-species[2]	[NEWT, 573824, Human rhinovirus 1, ]
MTD	sample[1]-tissue[1]	[BTO, BTO:0000759, liver, ]
MTD	sample[1]-cell_type[1]	[CL, CL:0000182, hepatocyte, ]
MTD	sample[1]-disease[1]	[DOID, DOID:684, hepatocellular carcinoma, ]
MTD	sample[1]-disease[2]	[DOID, DOID:9451, alcoholic fatty liver, ]
MTD	sample[1]-description	Hepatocellular carcinoma samples.
MTD	sample[1]-custom[1]	[, , Extraction date, 2011-12-21]
MTD	sample[1]-custom[2]	[, , Extraction reason, liver biopsy]
MTD	sample[2]-species[1]	[NEWT, 9606, Homo sapiens (Human), ]
MTD	sample[2]-species[2]	[NEWT, 12130, Human rhinovirus 2, ]
MTD	sample[2]-description	Healthy control samples.
MTD	assay[1]-quantification_reagent	[PRIDE, MS:1002038, unlabeled sample, ]
MTD	assay[1]-sample_ref	sample[1]
MTD	assay[1]-ms_run_ref	ms_run[1]
MTD	assay[2]-quantification_reagent	[PRIDE, PRIDE:0000115, iTRAQ reagent, 115]
MTD	assay[2]-sample_ref	sample[2]
MTD	assay[2]-quantification_mod[1]	[UNIMOD, UNIMOD:188, Label:13C(6), ]
MTD	assay[2]-quantification_mod[1]-site	R
MTD	assay[2]-quantification_mod[1]-position	Anywhere
MTD	assay[2]-quantification_mod[2]	[UNIMOD, UNIMOD:188, Label:13C(6), ]
MTD	assay[2]-quantification_mod[2]-site	K
MTD	assay[2]-quantification_mod[2]-position	Anywhere
MTD	study_variable[1]-description	description Group B (spike-in 0.74 fmol/uL)
MTD	study_variable[1]-assay_refs	assay[1], assay[2]
MTD	study_variable[1]-sample_refs	sample[1]
MTD	study_variable[2]-description	description Group B (spike-in 0.74 fmol/uL)
MTD	study_variable[2]-assay_refs	assay[1], assay[2]
MTD	study_variable[2]-sample_refs	sample[1]
MTD	cv[1]-label	MS
MTD	cv[1]-full_name	MS
MTD	cv[1]-version	3.54.0
MTD	cv[1]-url	http://psidev.cvs.sourceforge.net/viewvc/psidev/psi/psi-ms/mzML/controlledVocabulary/psi-ms.obo
MTD	colunit-protein	reliability=[MS, MS:00001231, PeptideProphet:Score, ]
MTD	colunit-peptide	retention_time=[UO, UO:0000031, minute, ]
MTD	colunit-psm	retention_time=[UO, UO:0000031, minute, ]
MTD	colunit-small_molecule	retention_time=[UO, UO:0000031, minute, ]
MTD	custom[1]	[, , MS operator, Florian]
```