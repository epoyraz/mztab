package uk.ac.ebi.pride.jmztab.utils.errors;

/**
 * User: Qingwei
 * Date: 29/01/13
 */
public class LogicalErrorType extends MZTabErrorType {
    public static MZTabErrorType NULL = createError(Category.Logical, "NULL");
    public static MZTabErrorType NotNULL = createWarn(Category.Logical, "NotNULL");

    public static MZTabErrorType LineOrder = createError(Category.Logical, "LineOrder");
    public static MZTabErrorType HeaderLine = createError(Category.Logical, "HeaderLine");
    public static MZTabErrorType NoHeaderLine = createError(Category.Logical, "NoHeaderLine");

    // not defined in metadata.
    public static MZTabErrorType MsRunNotDefined = createError(Category.Logical, "MsRunNotDefined");
    public static MZTabErrorType AssayNotDefined = createError(Category.Logical, "AssayNotDefined");
    public static MZTabErrorType StudyVariableNotDefined = createError(Category.Logical, "StudyVariableNotDefined");

    public static MZTabErrorType NotDefineInMetadata = createError(Category.Logical, "NotDefineInMetadata");
    public static MZTabErrorType NotDefineInHeader = createError(Category.Logical, "NotDefineInHeader");
    public static MZTabErrorType DuplicationDefine = createError(Category.Logical, "DuplicationDefine");
    public static MZTabErrorType DuplicationAccession = createError(Category.Logical, "DuplicationAccession");
    public static MZTabErrorType AssayRefs = createError(Category.Logical, "AssayRefs");

    public static MZTabErrorType ProteinCoverage = createError(Category.Logical, "ProteinCoverage");
    public static MZTabErrorType IdNumber = createError(Category.Logical, "IdNumber");
    public static MZTabErrorType ModificationPosition = createError(Category.Logical, "ModificationPosition");
    public static MZTabErrorType CHEMMODS = createWarn(Category.Logical, "CHEMMODS");
    public static MZTabErrorType SubstituteIdentifier = createError(Category.Logical, "SubstituteIdentifier");
    public static MZTabErrorType SoftwareVersion = createWarn(Category.Logical, "SoftwareVersion");

    public static MZTabErrorType AbundanceColumnTogether = createError(Category.Logical, "AbundanceColumnTogether");
    public static MZTabErrorType AbundanceColumnSameId = createError(Category.Logical, "AbundanceColumnSameId");

    public static MZTabErrorType SpectraRef = createError(Category.Logical, "SpectraRef");
    public static MZTabErrorType AmbiguityMod = createWarn(Category.Logical, "AmbiguityMod");
    public static MZTabErrorType MsRunLocation = createWarn(Category.Logical, "MsRunLocation");

}
