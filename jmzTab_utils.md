


---

# Introduction #

We create two interfaces, CLI (mzTabCLI) and Simple GUI (mzTabGUI), to simplify the usage of jmzTab APIs. Compared with GUI, command line provides more flexible way to batch process the mzTab files.

## Command Line Interface ##

In [mzTabCLI Demo](https://code.google.com/p/mztab/source/browse/jmztab/trunk/etcs/command_demo.bat), we provide a couple of examples to help user call command line interface quickly.

  * print command line help
```
java -jar mzTabCLI.jar -help
```
The output will like following:
```
usage: jmztab
 -check <inFile>             Choose a file from input directory. This
                             parameter should not be null!
 -convert <inFile, format>   Converts the given format file (PRIDE or MZIDENTML) to an mztab
                             file.
 -h,--help                   print help message
 -message <code>             print Error/Warn detail message based on code
                             number.
 -outFile <arg>              Record error/warn messages into outfile. If
                             not set, print message on the screen.
```


  * print special error/warn message based on code, see details of [Error/Warn Message List](jmzTab_message.md).
```
java -jar mzTabCLI.jar -message code=2000
```
The output would be like:
```
    Code:       2000
Category:       Logical
Original:       Column "{0}" is an empty cell, or the current column cannot use "null".
   Cause:       In the table-based sections (protein, peptide, psm, and small molecule) there MUST NOT be any empty cells. Missing values MUST be reported using "null".
```
    1. **Code:** Unique number for error/warn
    1. **Category:** Currently, there are three types of messages: _**Format, Logical**_
    1. **Original:** Message expression pattern. "{?}" is a couple of parameters which can be filled during validate processing.
    1. **Cause:** A readable text to describe the reason why raise this error/warn. Currently, these cause message coming from mztab specification mainly.



  * Exists warn/error messages during validate, print messages on screen:
```
java -Xms2048m -jar mzTabCLI.jar -check inFile=temp/SILAC_CQI.mzTab
```

The output would be like:
```
Begin check mztab file: c:\work\jmztab2\target\jmztab\testset\mztab_merged_example.txt
[Warn-2018] line 13: Software parameter "[MS, MS:1001583, MaxQuant,]" does not contain version information.
[Warn-2001] line 36: Column "search_engine_score_ms_run[6]" field value does not allow a "null" value.
Finish!
```


  * Exists warn/error messages during validate, print messages into SILAC\_CQI.err file:
```
java -Xms2048m -jar mzTabCLI.jar -check inFile=temp/SILAC_CQI.mzTab -outFile SILAC_CQI.err
```


  * Convert PRIDE\_Exp\_Complete\_Ac\_16649.xml, and print mzTab file to screen:
```
java -Xms2048m -jar mzTabCLI.jar -convert inFile=temp/PRIDE_Exp_Complete_Ac_16649.xml format=PRIDE
```

  * Convert PRIDE\_Exp\_Complete\_Ac\_16649.xml, and print mzTab file to PRIDE\_Exp\_Complete\_Ac\_16649.mztab:
```
java -Xms2048m -jar mzTabCLI.jar -convert inFile=temp/PRIDE_Exp_Complete_Ac_16649.xml format=PRIDE -outFile PRIDE_Exp_Complete_Ac_16649.mztab
```



---

## Simple GUI ##
There are some screenshots about how to use GUI (Click on a screenshot to see the full size version):
<table>
<tr>
<td><a href='http://mztab.googlecode.com/svn/wiki/images/jmztab-validate-full.png'><img src='http://mztab.googlecode.com/svn/wiki/images/jmztab-validate-small.png' /></a></td>
<td><a href='http://mztab.googlecode.com/svn/wiki/images/jmztab-convert-full.png'><img src='http://mztab.googlecode.com/svn/wiki/images/jmztab-convert-small.png' /></a></td>
</tr>
</table>