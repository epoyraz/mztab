This Wiki holds information about the mzTab format as well as associated projects and tools that make the use of mzTab easier - for developers as well as end-users.

## Introduction ##

mzTab is a standard format developed by the Proteomics Standards Initiative (PSI). mzTab is a flexible tab-delimited file that can capture identification and quantification results coming from mass spectrometry (MS)-based proteomics and metabolomics approaches. We here present an open-source Java Application Programming Interface (API) for mzTab called jmzTab.

The software allows easy and efficient processing of mzTab files, providing read and write capabilities, and is designed to be embedded in other software packages. The second key feature of the jmzTab model is its flexible framework to maintain the logical integrity between the metadata and the table-based sections in the files. As an example implementation, we also describe a Graphical User Interface (GUI)-based tool that can be used to validate and convert mzTab files from PRIDE XML and MzIdentML.

## jmzTab ##

When you use jmzTab library, please cite the following publication:

  * **[Qing-Wei Xu et al., Proteomics 2014; Jun;14(11):1328-32](http://onlinelibrary.wiley.com/doi/10.1002/pmic.201300560/abstract). [PDF File](http://onlinelibrary.wiley.com/doi/10.1002/pmic.201300560/pdf).  [PubMed record](http://www.ncbi.nlm.nih.gov/pubmed/24659499).**

---


## mzTab Format File ##

mzTab is a tab-delimited text file format to report proteomics results. The **format specification version 1.0.0** can be found in the mzTab SVN:
> [mzTab\_format\_specification.docx](http://mztab.googlecode.com/svn/specification_document/mzTab_format_specification.docx) <br />
> [mzTab format specification.pdf](http://mztab.googlecode.com/svn/specification_document/mzTab_format_specification.pdf)

mzTab **example files** can also be found in the svn (see [Example files](ExampleFiles.md)).

A quick introduction to the mzTab format is the **20 minute guide to mzTab** ([PDF](http://mztab.googlecode.com/svn/specification_document/20minute_guide_mzTab.pdf), [docx](http://mztab.googlecode.com/svn/specification_document/20minute_guide_mzTab.docx)).


---


## jmzTab API Tutorial ##

The main principle behind the design of the jmzTab core model is to provide an independent light-weight architecture for simplifying the integration of the library in different proteomics/metabolomics software applications. Users can integrate the model into their applications, without the need any other third-party packages. Especially, when users want to recode the model by using other programming languages, and migrates jmzTab API into other heterogeneous system.

We provide a [tutorial](jmzTab.md) document and a couple of demos to help you to create [metadata](jmzTab_metadata.md) and [fill data](jmzTab_column.md) by calling jmzTab API.


---